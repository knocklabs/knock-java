# Plan: modernize knock-java to the current OpenAPI spec, at parity with knock-node

Status: proposal
Target release: `2.0.0`
Parity reference: [`knocklabs/knock-node`](https://github.com/knocklabs/knock-node) `main` (`api.md`, `src/lib/`, `tests/lib/`, `examples/`)
Spec: live `https://api.knock.app/v1/openapi` (118 operations). knock-java is currently pinned by `.stats.yml` to an older spec (`openapi_spec_hash: 92953a04…`, 107 operations) and an older config (`config_hash: 7460c5bd…`).

## TL;DR

- **Goal:** every method, named model, and hand-written helper in knock-node has a Java equivalent that follows this repo's conventions, and every call works against the live API.
- **Where we are:** knock-node, knock-python, and knock-go report 98 configured endpoints. knock-java reports 89. Of Node's 98 methods, **86 already exist** in Java with matching names and paths, **9 must be added**, and **3 must be re-pointed** to new paths. Appendix A lists every row.
- **Hand-written parity:** knock-node has two non-generated features that Java lacks. The first is **JWT user-token signing** (`signUserToken`, `buildUserTokenGrant`, `Grants`). The second is a **custom query-string serializer**. Java needs both.
- **Wire bugs in the current Java release**, confirmed with read-only calls against the live API:
  1. The five message-family list methods read `entries`, but the API returns `items`. The result is **silently empty pages**.
  2. Object-reference array query params are sent as `objects[][id]=…`, which the API rejects with a 422. The accepted form is `objects[0][id]=…`.
  3. The new spec renames `status[]` to `status` (and similarly for other array params). A naïve regeneration would send `status=…`, which the API rejects with a 422.
- **Java-only surface to remove:** the duplicate `messages().activities().list()` and the per-message guide paths. Node has neither.
- **Breaking changes:** the regeneration brings model drift (channel-data unions, guide response shape, 204s returning `String`) and a pagination accessor rename. Together these require a major version.

## 1. How parity was measured

1. **Java surface.** Every `*ServiceImpl.kt` method carries a `// <verb> <path>` comment. Those comments give Java's (verb, path, accessor chain, method) tuples. That is 89 distinct endpoints, one of which is exposed twice.
2. **Node surface.** knock-node's `api.md` lists all 98 methods along with their paths and named types. Joining on (verb, normalized path) gives Appendix A. A method matches when the Java accessor chain and name equal the Node chain and name. For example, `client.users.guides.getChannel` corresponds to `client.users().guides().getChannel()`.
3. **Types.** Node's named types were compared with Java model class names (§5.2).
4. **Hand-written code.** knock-node's `src/lib/`, `tests/lib/`, and `examples/` were reviewed (§7).
5. **Spec drift.** The pinned spec was diffed against the live spec after stripping `x-*` extensions, examples, and descriptions (§6).
6. **Behavior.** Every wire-level claim was checked with read-only `GET`s against the live API. Only status codes and top-level response keys were inspected.

## 2. Conventions that new code must follow

knock-java, knock-node, knock-python, and knock-go are all generated from **one shared Stainless project** (`knock/knock`). Method names and named models therefore come from the shared config. Most "parity" work means **regenerating Java from the current spec and config**, then fixing what the regeneration breaks. It does not mean designing new names. Hand edits to generated files are lost on the next generation, so custom code goes in files Stainless does not own. knock-node follows the same rule with `src/lib/`.

The generated Java surface follows these patterns:

| Concern | Convention (existing example) |
| --- | --- |
| Resource → service | `UserService` / `UserServiceAsync` plus `*Impl`, each with a nested `WithRawResponse` view |
| Sub-resource | Accessor on the parent, for example `users().guides()` → `services/blocking/users/GuideService.kt` |
| Client wiring | Accessor on `KnockClient`, `KnockClientAsync`, both `*Impl`s, and both `WithRawResponse` interfaces |
| Names from Node | Node `client.a.b.method` maps to Java `client.a().b().method()`. Initialisms become camel case: `generateSignedURL` → `generateSignedUrl` (compare the existing `logoUrl`) |
| Params | `<Resource><Method>Params` in `models/<resource>/[<sub>/]`, for example `models/users/guides/GuideMarkMessageAsSeenParams.kt` |
| Responses | The named model when the config declares one (`User`, `BulkOperation`, `Message`), otherwise `<Resource><Method>Response`. Node's array aliases (for example `ScheduleCreateResponse = Schedule[]`) become `List<T>` in Java |
| Pagination | `<Resource><Method>Page`, `…PageAsync`, and `…PageResponse`, using the `entries` cursor, the `items` cursor, or the Slack cursor. These correspond to Node's `EntriesCursor`, `ItemsCursor`, and `SlackChannelsCursor` |
| Path params | Positional overloads plus the params-object form, with `checkRequired` in `*Impl` |
| Tests | `services/{blocking,async}/**/<Service>ServiceTest.kt` against Prism (`scripts/mock`), plus `models/**/<Model>Test.kt` |

## 3. Parity scorecard

| Area | knock-node | knock-java today | After this plan |
| --- | --- | --- | --- |
| Endpoints | 98 | 89, with 3 on obsolete guide paths | 98 |
| Methods matching Node (name and path) | 98 | 86 | 98 |
| Java-only methods | n/a | 4: `messages().activities().list()` and 3 per-message guide methods | 0 |
| Named models | Current config | Older config. About 20 named types missing (§5.2) | Current config |
| Message-family pagination | `ItemsCursor` | Reads `entries`, so pages are empty | `items` cursor |
| Query arrays | brackets for primitives, indices for objects (`src/lib/stringifyQuery.ts`) | brackets for primitives, broken for objects | Same as Node |
| User-token signing | `signUserToken`, `buildUserTokenGrant`, `Grants` | None | `app.knock.api.lib` equivalent (§7.1) |
| Examples and docs | `examples/token-signing.ts`, README "JWT Token Signing" | None | Java example and README section |

## 4. Correctness fixes (do these first)

### 4.1 Message-family pagination uses the wrong envelope

The live API returns `{ "items": [...], "page_info": {...} }` for all six endpoints below. Node types each of them as an `ItemsCursor`.

| Java page class | Reads | API returns | Node |
| --- | --- | --- | --- |
| `MessageListPage` | `entries` | `items` | `MessagesItemsCursor` |
| `UserListMessagesPage` | `entries` | `items` | `MessagesItemsCursor` |
| `ObjectListMessagesPage` | `entries` | `items` | `MessagesItemsCursor` |
| `MessageListEventsPage` | `entries` | `items` | `MessageEventsItemsCursor` |
| `MessageListDeliveryLogsPage` | `entries` | `items` | `MessageDeliveryLogsItemsCursor` |
| `MessageListActivitiesPage` | `items` | `items` | `ActivitiesItemsCursor` (already correct) |

The page classes fall back to an empty list when `entries` is missing. As a result, `messages().list()`, `users().listMessages()`, `objects().listMessages()`, `messages().listEvents()`, and `messages().listDeliveryLogs()` return empty pages with `hasNextPage() == false` and no error.

**Change:** use the `items` cursor for these five methods, matching Node. The accessor changes from `entries()` to `items()`. That is a source break, but no caller can be relying on the current behavior, since it only ever returns empty lists.

### 4.2 Query-string array serialization

The API is a Phoenix/Plug app. knock-node hit this problem in [KNO-9922](https://linear.app/knock/issue/KNO-9922) and fixed it in `src/lib/stringifyQuery.ts`, which has its own `tests/stringifyQuery.test.ts`. The required wire forms are:

| Kind | Required wire form | Live check |
| --- | --- | --- |
| Primitive arrays (`status`, `engagement_status`, `message_ids`, `workflow_categories`, `include`, `tenant_ids`) | `status[]=a&status[]=b` | `status[]=bounced` → 200, `status=bounced` → 422. Same for `include` |
| Arrays of objects (`objects`, `recipients` containing `RecipientReference` objects) | `objects[0][id]=x&objects[0][collection]=y` | indexed → 200, `objects[][id]=…` → 422 |

Current Java behavior:

- Primitive arrays work, because the old spec literally named the params `status[]` and so on. The SDK hard-codes those keys, for example `put("status[]", …)` in `MessageListParams`.
- Object arrays are **broken today**. `ObjectListSubscriptionsParams` emits `objects[][id]` and `recipients[][id]`.
- The new spec drops the `[]` from the names. A naïve regeneration would emit `status=…` and break every filtered list call.

**Change:**

1. Configure brackets for primitive arrays and indices for arrays of objects, which is the split Node uses. If Stainless's Java target cannot express a split format, add a serializer in a non-generated file (§7.2) and route query encoding through it.
2. Port Node's `stringifyQuery.test.ts` cases to Java params tests. Assert the exact `_queryParams()` output for `MessageListParams.status`, `ObjectListParams.include`, `BatchGetContentParams.messageIds`, `TenantBulkDeleteParams.tenantIds`, `ObjectListSubscriptionsParams.objects`/`recipients`, `UserListSubscriptionsParams.objects`, `ScheduleListParams.recipients`, and `WorkflowRecipientRunListParams.recipient`.

### 4.3 Spec defect: guide per-message paths

In the live spec, `PUT /v1/users/{user_id}/guides/messages/{message_id}/{seen|interacted|archived}` still has `{message_id}` in the path but no longer declares it as a parameter. Node has already moved these three methods to the path-less endpoints. Java should do the same (§5.1) and stop configuring the per-message paths. Also report the defect to whoever owns the spec.

## 5. Endpoint and model parity

### 5.1 Methods to add or re-point (12)

These are the only rows in Appendix A that are not "Exists".

**Users: preferences**

| Java method | HTTP | Params | Returns |
| --- | --- | --- | --- |
| `users().unsetPreferences(userId, id)` | `DELETE /v1/users/{user_id}/preferences/{id}` | `UserUnsetPreferencesParams` | nothing (204) |

**Users: guides.** Re-point three methods and add two.

| Java method | HTTP | Params / body | Returns |
| --- | --- | --- | --- |
| `markMessageAsSeen(userId, params)` **(re-point)** | `PUT /v1/users/{user_id}/guides/messages/seen` | `GuideMarkMessageAsSeenParams` / `GuideSeenRequest` | `GuideActionResponse` |
| `markMessageAsInteracted(userId, params)` **(re-point)** | `PUT …/guides/messages/interacted` | `GuideMarkMessageAsInteractedParams` / `GuideInteractedRequest` | `GuideActionResponse` |
| `markMessageAsArchived(userId, params)` **(re-point)** | `PUT …/guides/messages/archived` | `GuideMarkMessageAsArchivedParams` / `GuideArchivedRequest` | `GuideActionResponse` |
| `unarchiveGuideMessage(userId, params)` **(add)** | `DELETE …/guides/messages/archived` | `GuideUnarchiveGuideMessageParams` (`guide_key`, `tenant`) | `GuideActionResponse` |
| `resetGuideEngagements(userId, params)` **(add)** | `PUT /v1/users/{user_id}/guides/engagements/reset` | `GuideResetGuideEngagementsParams` (`guide_key`, `tenant`) | `GuideActionResponse` |

The re-pointed methods drop the `messageId` path parameter, so the positional overload changes from `(userId, messageId, params)` to `(userId, params)`. The body now identifies the guide step with `channel_id`, `guide_id`, `guide_key`, and `guide_step_ref`. `GuideActionResponse` replaces the three per-method `GuideMarkMessageAs*Response` classes. The names `unarchiveGuideMessage` and `resetGuideEngagements` come from the shared config. They are less regular than `markMessageAs*`, but cross-SDK parity takes priority.

**Users: new `preferenceCenter()` sub-service**

New files: `services/{blocking,async}/users/PreferenceCenterService{,Impl,Async,AsyncImpl}.kt` and `models/users/preferencecenter/`. The accessor is wired into `UserService`, `UserServiceAsync`, and both `WithRawResponse` views.

| Java method | HTTP | Params | Returns |
| --- | --- | --- | --- |
| `getConfig(userId)` | `GET /v1/users/{user_id}/preference_center/config` | `PreferenceCenterGetConfigParams` | `PreferenceCenterGetConfigResponse` |
| `generateSignedUrl(userId)` | `POST /v1/users/{user_id}/preference_center/signed_url` | `PreferenceCenterGenerateSignedUrlParams` | `PreferenceCenterGenerateSignedUrlResponse` (`url`, `token`) |

**Objects**

| Java method | HTTP | Params | Returns |
| --- | --- | --- | --- |
| `objects().unsetPreferences(collection, objectId, id)` | `DELETE /v1/objects/{collection}/{object_id}/preferences/{id}` | `ObjectUnsetPreferencesParams` | nothing (204) |
| `objects().bulk().deleteSubscriptions(collection, params)` | `POST /v1/objects/{collection}/bulk/subscriptions/delete` | `BulkDeleteSubscriptionsParams` (`models/objects/bulk/`), `subscriptions[]` of `{ id, recipients[] }` | `BulkOperation` |

`unsetPreferences` mirrors the existing `unsetChannelData`, and `deleteSubscriptions` mirrors `objects().bulk().addSubscriptions()`.

**New top-level `workflowRecipientRuns()` service**

New files: `services/{blocking,async}/WorkflowRecipientRunService{,Impl,Async,AsyncImpl}.kt`, `models/workflowrecipientruns/`, and the accessor on `KnockClient*`.

| Java method | HTTP | Params | Returns |
| --- | --- | --- | --- |
| `list(params)` | `GET /v1/workflow_recipient_runs` | `WorkflowRecipientRunListParams`: `after`, `before`, `pageSize`, `workflow`, `status[]`, `tenant`, `hasErrors`, `recipient` (`RecipientReference`), `startingAt`, `endingAt` | `WorkflowRecipientRunListPage` (`items` cursor, matching Node's `WorkflowRecipientRunsItemsCursor`) |
| `get(id)` | `GET /v1/workflow_recipient_runs/{id}` | `WorkflowRecipientRunGetParams` | `WorkflowRecipientRunDetail` |

The allowed `status` values are `queued`, `processing`, `paused`, `completed`, and `cancelled`.

### 5.2 Named models to adopt

These are Node's named types that Java lacks. They come from the current shared config, so the regeneration should produce them. Check each one in review.

| Node section | Types |
| --- | --- |
| Recipients > ChannelData | `PushChannelDataTokensOnly`, `PushChannelDataDevicesOnly`, `AwsSnsPushChannelDataTargetArnsOnly`, `AwsSnsPushChannelDataDevicesOnly`, `OneSignalChannelDataPlayerIdsOnly`. These replace `PushChannelData` and `OneSignalChannelData` (§6.1) |
| Recipients > Preferences | `PreferenceSetChannelSetting` |
| Users | `PreferenceSetCommercialSubscribedSetting` |
| Users > Guides | `GuideActionResponse`, `GuideSeenRequest`, `GuideInteractedRequest`, `GuideArchivedRequest` |
| Users > PreferenceCenter | `PreferenceCenterBrandingConfig`, `PreferenceCenterGetConfigResponse`, `PreferenceCenterGenerateSignedUrlResponse` |
| Messages | `MessageContents` (replaces `MessageGetContentResponse`), `MessageInAppFeedContentBlock`, `MessageInAppFeedButtonSetBlock` (currently nested classes) |
| Messages > Batch | `BatchMessagesStatusRequest` |
| Audiences | `AudienceMemberRequest` (replaces the nested `AudienceAddMembersParams.Member`) |
| WorkflowRecipientRuns | `WorkflowRecipientRun`, `WorkflowRecipientRunDetail`, `WorkflowRecipientRunEvent` |

Node's array and page aliases have no Java counterpart and need nothing. These are `ListSchedulesResponse`, `ListSubscriptionsResponse`, `ListMessagesResponse`, `UserListPreferencesResponse`, `ObjectListPreferencesResponse`, `ObjectAddSubscriptionsResponse`, `ObjectDeleteSubscriptionsResponse`, `Batch{Archive,MarkAs*,Unarchive}Response`, and `Schedule{Create,Update,Delete}Response`. Java already represents them as `List<T>` or `*PageResponse`.

### 5.3 Java-only surface to remove

| Java method | Why | Action |
| --- | --- | --- |
| `messages().activities().list()` (`services/*/messages/ActivityService*`) | Duplicates `messages().listActivities()`. Node exposes only the latter | Drop the `activities` sub-resource from the config. List it in `MIGRATION.md` |
| `users().guides().markMessageAs{Seen,Interacted,Archived}(userId, messageId, …)` on `/guides/messages/{message_id}/…` | Obsolete paths with a spec defect (§4.3) | Replaced by the re-pointed methods in §5.1 |

### 5.4 Operations excluded everywhere (keep excluded)

Node, Python, and Go all exclude these 18 spec operations. Java should stay aligned with them.

| Operations | Reason |
| --- | --- |
| `POST /v1/notify`, `POST /v1/notify/cancel` | Legacy aliases of `workflows().trigger()` and `workflows().cancel()` |
| `DELETE /v1/messages/{id}/unarchived`, `/unread`, `/unseen` | Aliases of `unarchive`, `markAsUnread`, and `markAsUnseen` |
| `PUT …/preferences/{id}/{categories,channel_types,workflows}[/{key}]` for users and objects (12 operations) | Not in any Knock SDK. `setPreferences` with `__persistence_strategy__: "merge"` (§6.2) covers partial updates |

## 6. Model drift on existing endpoints

These changes arrive with the spec and config bump. They apply equally to Node, which already ships them.

### 6.1 Breaking

| Area | Change | Java impact |
| --- | --- | --- |
| 204 responses | `EmptyContentResponse` was removed, and 204s have no body. Node returns `void` | `users().delete`, `objects().delete`, `tenants().delete`, `unsetChannelData` (users and objects), `audiences().addMembers`/`removeMembers`, and `workflows().cancel` stop returning `String` and return nothing |
| Message pagination | `entries` → `items` (§4.1) | `entries()` → `items()` on five page classes |
| Guides | Paths (§5.1). `GuidesResponse` replaces `guides`/`recipient` with `entries`, `guide_groups`, `guide_group_display_logs`, and `ineligible_guides` | `GuideGetChannelResponse` accessors change. Mark-as methods drop `messageId` |
| Channel data | Push and OneSignal unions are split (§5.2). Provider enum adds `push_aws_sns`. Responses use `*Full` variants inside `ChannelData` | `ChannelDataRequest.Data.ofPushChannel(...)` and similar factories are renamed |
| Slack incoming webhook | `url` → `incoming_webhook.url` | Accessor change. Confirm this is a real API change before shipping (§10) |
| Subscription and schedule filters | `UserListSubscriptionsParams.objects` and `ScheduleListParams.recipients` change from `List<String>` to `List<RecipientReference>` | Builder signature changes. Serialization per §4.2 |
| Bulk add subscriptions | Each item now requires `id` | New required builder field |
| Tenants | `SetTenantRequest.preferences` removed | `TenantSetParams.preferences(...)` goes away |
| Messages content | `MessageGetContentResponse` → `MessageContents` | Class rename |
| Audiences | `AudienceAddMembersParams.Member` → `AudienceMemberRequest` | Class rename |

### 6.2 Additive

| Area | Added |
| --- | --- |
| `workflows().trigger()` | `settings` (`sandbox_mode`, `skip_delay`) |
| `schedules().create()` | `actor`. `repeats` is no longer required |
| `audiences().addMembers()` | `create_audience` query param |
| `tenants().get()` / `set()` | `resolve_full_preference_settings`. `TenantRequest.name`. Dark-mode branding fields |
| `users().feeds().listItems()` | `locale`, `exclude`, `mode` (`compact`/`rich`), `inserted_at.{gt,gte,lt,lte}` |
| Inline identify | `InlineIdentifyUserRequest`: `avatar`, `locale`, `phone_number`. `name` on object requests. `BulkSetObjectRequest` item type |
| Preferences | `channels` and `commercial_subscribed` on `PreferenceSet`/`PreferenceSetRequest`. `__persistence_strategy__` (`merge`/`replace`). `BulkPreferenceSetRequest` |
| `Message` | `channel`, `recipient_snapshot`, `source.{type,step_ref,workflow_run_id,workflow_recipient_run_id}`. `channel_id` is deprecated |
| Connections | `knock_tenant_id` on Slack, MS Teams, and Discord connections. `SlackTokenConnection.channel_name`. `ms_teams_tenant_id` on the MS Teams auth check |
| Enums | New `MessageEvent.type` and `Condition.operator` values. These are non-breaking because Stainless enums are open |

## 7. Hand-written helpers (non-generated parity)

Put these in a package that Stainless does not generate, `knock-java-core/src/main/kotlin/app/knock/api/lib/`, which mirrors Node's `src/lib/`. Add a `CONTRIBUTING` note, as Node does, stating that the generator never touches it.

### 7.1 User-token signing (port of `src/lib/tokenSigner.ts` and `userTokens.ts`)

Node exports `signUserToken`, `buildUserTokenGrant`, and `Grants`. These produce RS256 JWTs for client-side auth, such as in-app feeds and Slack/Teams channel pickers. The Java equivalent:

```kotlin
package app.knock.api.lib

enum class Grant(val value: String) {
    SLACK_CHANNELS_READ("slack/channels_read"),
    MS_TEAMS_CHANNELS_READ("ms_teams/channels_read"),
    CHANNEL_DATA_READ("channel_data/read"),
    CHANNEL_DATA_WRITE("channel_data/write"),
    USER_FEED_READ("user/feed_read"),
}

sealed class TokenEntity {
    data class User(val id: String) : TokenEntity()
    data class Tenant(val id: String) : TokenEntity()
    data class Object(val id: String, val collection: String) : TokenEntity()
}

class TokenGrant internal constructor(val entity: String, val grants: Map<String, List<Any>>)

class SignUserTokenOptions private constructor(
    val signingKey: String?,       // PEM or base64 PEM; falls back to KNOCK_SIGNING_KEY
    val expiresInSeconds: Long,    // default 3600
    val grants: List<TokenGrant>,
    val shouldGenerateJti: Boolean, // default false
) { /* builder(), matching the SDK's builder style */ }

object UserTokens {
    @JvmStatic fun signUserToken(userId: String): String
    @JvmStatic fun signUserToken(userId: String, options: SignUserTokenOptions): String
    @JvmStatic fun buildUserTokenGrant(entity: TokenEntity, grants: List<Grant>): TokenGrant
}
```

Behavior must match Node exactly so that tokens are interchangeable across SDKs:

- **Key handling.** Accept a PEM key, or a base64-encoded PEM detected by the `LS0tLS1CRUdJTi` prefix. Otherwise throw a clear error. Read `KNOCK_SIGNING_KEY` when no key is passed.
- **Claims.** Header `{alg: RS256, typ: JWT}`. Payload `sub`, `iat`, `exp` (default one hour), an optional `jti` (UUID v4), and `grants`.
- **Entity URIs.** `https://api.knock.app/v1/users/{id}`, `…/v1/objects/$tenants/{id}`, and `…/v1/objects/{collection}/{id}`. Grants for the same entity are merged into `{ entityUri: { grant: [] } }`.
- **Dependencies.** Use JDK APIs only: `KeyFactory` with `PKCS8EncodedKeySpec`, `Signature("SHA256withRSA")`, and `Base64.getUrlEncoder().withoutPadding()`. Serialize claims with the Jackson already on the classpath. This keeps the Java 8 requirement and adds no dependency. Node, by contrast, needs `jose`.
- **Tests.** Port `tests/lib/tokenSigner.test.ts` and `userTokens.test.ts`. Also add a cross-check that verifies a Java-signed token with the public key and compares its claims to what Node produces for the same inputs.

### 7.2 Query serializer (port of `src/lib/stringifyQuery.ts`)

This is only needed if the Stainless Java config cannot express §4.2 directly. The rules are: primitive arrays use brackets, object arrays use indices, and a single `RecipientReference` query param (`recipient`) becomes `recipient[id]=…&recipient[collection]=…`. Port Node's test cases one for one.

## 8. Docs, examples, and tests

- **README.** Add a "User token signing" section mirroring Node's "JWT Token Signing" section. Update the manual-pagination snippet to note `items()` for message lists and keep `entries()` for `users().list()`. Update the channel-data examples.
- **`knock-java-example`.** Add a token-signing example (a port of `examples/token-signing.ts`) and a preference-center signed-URL example.
- **`MIGRATION.md` (new).** One entry per row in §5.3 and §6.1, each with a before/after snippet.
- **Service tests.** Blocking and async Prism tests for every §5.1 method, following the existing layout.
- **Pagination tests.** `items` fixtures for the five message lists and for `WorkflowRecipientRunListPage`, covering `hasNextPage()` and `autoPager()`.
- **Live smoke test (opt-in).** A read-only test skipped unless `KNOCK_API_KEY` is set. It calls `messages().list()`, `messages().listEvents()`, `users().listSubscriptions()` with an object filter, and `workflowRecipientRuns().list()`, and asserts non-error responses and correct envelope parsing. Prism would not have caught either bug in §4. This test would have.

## 9. Rollout

Each step regenerates, passes `./scripts/lint` and `./scripts/test`, and lands on a `next` branch. release-please then cuts `2.0.0`.

1. **Spec and config bump plus transport fixes.** Move to the current shared config, which puts Java on the same `config_hash` lineage as Node. Configure array query format (§4.2) and the `items` cursors (§4.1). Stop configuring the per-message guide paths and `messages().activities()`. Add the serialization and pagination regression tests. `.stats.yml` should then report `configured_endpoints: 98`.
2. **Guides.** Handle the §5.1 guide changes and the reshaped `GuideGetChannelResponse`.
3. **New endpoints.** Add `unsetPreferences` (users and objects), `objects().bulk().deleteSubscriptions()`, `users().preferenceCenter()`, and `workflowRecipientRuns()`, each with tests.
4. **Model-drift review.** Review §5.2 and §6.1 as their own diff, with extra attention on channel data. Resolve §10.
5. **Hand-written parity.** Add the `app.knock.api.lib` token signing (§7.1), the serializer if needed (§7.2), and their tests.
6. **Docs and examples.** Do §8.
7. **Parity guard.** Add a CI check that builds Appendix A automatically. It parses the `// <verb> <path>` comments from `*ServiceImpl.kt` and knock-node's `api.md` at a pinned ref, and fails when a Node method has no Java counterpart or when Java has a method Node lacks. This keeps the SDKs from drifting apart again.

## 10. Open questions

1. Is `PUT /v1/users/{id}/guides/messages/{message_id}/*` still served? If it is, we could keep deprecated overloads for one release, which would need custom code.
2. Is the Slack `url` → `incoming_webhook.url` change a real API change, or did the spec only correct its description?
3. How should mixed arrays (user-id strings together with object references) be serialized for `recipients`/`objects`? Node partitions by the type of the first element. Should Java match that, or reject mixed input?
4. Does `PUT /v1/tenants/{id}` still accept `preferences`?
5. Should `app.knock.api.lib` ship in `knock-java-core`, or in a separate artifact so the core stays free of hand-written code?

## Appendix A: Node → Java method parity matrix

All 98 knock-node methods, grouped by Node top-level resource. "Exists" means Java already has the method with the same accessor chain, name, and path. The notes point to changes that still affect the row.

Totals: **86 exist**, **9 to add**, **3 to re-point**. There are also **4 Java-only methods to remove** (§5.3).

#### `users()`

| Status | HTTP | Java method (target) | Notes |
| --- | --- | --- | --- |
| Exists | `PUT /v1/users/{user_id}` | `users().update` |  |
| Exists | `GET /v1/users` | `users().list` |  |
| Exists | `DELETE /v1/users/{user_id}` | `users().delete` | Returns nothing (§6.1) |
| Exists | `GET /v1/users/{user_id}` | `users().get` |  |
| Exists | `GET /v1/users/{user_id}/channel_data/{channel_id}` | `users().getChannelData` |  |
| Exists | `GET /v1/users/{user_id}/preferences/{id}` | `users().getPreferences` |  |
| Exists | `GET /v1/users/{user_id}/messages` | `users().listMessages` | Wire bug: `entries` → `items` (§4.1) |
| Exists | `GET /v1/users/{user_id}/preferences` | `users().listPreferences` |  |
| Exists | `GET /v1/users/{user_id}/schedules` | `users().listSchedules` |  |
| Exists | `GET /v1/users/{user_id}/subscriptions` | `users().listSubscriptions` | `objects` becomes `List<RecipientReference>` (§6.1) |
| Exists | `POST /v1/users/{user_id}/merge` | `users().merge` |  |
| Exists | `PUT /v1/users/{user_id}/channel_data/{channel_id}` | `users().setChannelData` | Channel-data unions split (§6.1) |
| Exists | `PUT /v1/users/{user_id}/preferences/{id}` | `users().setPreferences` |  |
| Exists | `DELETE /v1/users/{user_id}/channel_data/{channel_id}` | `users().unsetChannelData` | Returns nothing (§6.1) |
| Add | `DELETE /v1/users/{user_id}/preferences/{id}` | `users().unsetPreferences` | New (§5.1) |
| Exists | `GET /v1/users/{user_id}/feeds/{id}/settings` | `users().feeds().getSettings` |  |
| Exists | `GET /v1/users/{user_id}/feeds/{id}` | `users().feeds().listItems` | Adds `locale`, `exclude`, `mode`, `inserted_at.*` (§6.2) |
| Exists | `GET /v1/users/{user_id}/guides/{channel_id}` | `users().guides().getChannel` | Response reshaped (§6.1) |
| Re-point | `PUT /v1/users/{user_id}/guides/messages/archived` | `users().guides().markMessageAsArchived` | Drops `messageId`. Returns `GuideActionResponse` (§5.1) |
| Re-point | `PUT /v1/users/{user_id}/guides/messages/interacted` | `users().guides().markMessageAsInteracted` | Drops `messageId`. Returns `GuideActionResponse` (§5.1) |
| Re-point | `PUT /v1/users/{user_id}/guides/messages/seen` | `users().guides().markMessageAsSeen` | Drops `messageId`. Returns `GuideActionResponse` (§5.1) |
| Add | `PUT /v1/users/{user_id}/guides/engagements/reset` | `users().guides().resetGuideEngagements` | New (§5.1) |
| Add | `DELETE /v1/users/{user_id}/guides/messages/archived` | `users().guides().unarchiveGuideMessage` | New (§5.1) |
| Exists | `POST /v1/users/bulk/delete` | `users().bulk().delete` |  |
| Exists | `POST /v1/users/bulk/identify` | `users().bulk().identify` |  |
| Exists | `POST /v1/users/bulk/preferences` | `users().bulk().setPreferences` |  |
| Add | `POST /v1/users/{user_id}/preference_center/signed_url` | `users().preferenceCenter().generateSignedUrl` | New (§5.1) |
| Add | `GET /v1/users/{user_id}/preference_center/config` | `users().preferenceCenter().getConfig` | New (§5.1) |

#### `objects()`

| Status | HTTP | Java method (target) | Notes |
| --- | --- | --- | --- |
| Exists | `GET /v1/objects/{collection}` | `objects().list` |  |
| Exists | `DELETE /v1/objects/{collection}/{id}` | `objects().delete` | Returns nothing (§6.1) |
| Exists | `POST /v1/objects/{collection}/{object_id}/subscriptions` | `objects().addSubscriptions` |  |
| Exists | `DELETE /v1/objects/{collection}/{object_id}/subscriptions` | `objects().deleteSubscriptions` |  |
| Exists | `GET /v1/objects/{collection}/{id}` | `objects().get` |  |
| Exists | `GET /v1/objects/{collection}/{object_id}/channel_data/{channel_id}` | `objects().getChannelData` |  |
| Exists | `GET /v1/objects/{collection}/{object_id}/preferences/{id}` | `objects().getPreferences` |  |
| Exists | `GET /v1/objects/{collection}/{id}/messages` | `objects().listMessages` | Wire bug: `entries` → `items` (§4.1) |
| Exists | `GET /v1/objects/{collection}/{object_id}/preferences` | `objects().listPreferences` |  |
| Exists | `GET /v1/objects/{collection}/{id}/schedules` | `objects().listSchedules` |  |
| Exists | `GET /v1/objects/{collection}/{object_id}/subscriptions` | `objects().listSubscriptions` | Wire bug: object-array query format (§4.2) |
| Exists | `PUT /v1/objects/{collection}/{id}` | `objects().set` |  |
| Exists | `PUT /v1/objects/{collection}/{object_id}/channel_data/{channel_id}` | `objects().setChannelData` | Channel-data unions split (§6.1) |
| Exists | `PUT /v1/objects/{collection}/{object_id}/preferences/{id}` | `objects().setPreferences` |  |
| Exists | `DELETE /v1/objects/{collection}/{object_id}/channel_data/{channel_id}` | `objects().unsetChannelData` | Returns nothing (§6.1) |
| Add | `DELETE /v1/objects/{collection}/{object_id}/preferences/{id}` | `objects().unsetPreferences` | New (§5.1) |
| Exists | `POST /v1/objects/{collection}/bulk/delete` | `objects().bulk().delete` |  |
| Exists | `POST /v1/objects/{collection}/bulk/subscriptions/add` | `objects().bulk().addSubscriptions` | Each item now requires `id` (§6.1) |
| Add | `POST /v1/objects/{collection}/bulk/subscriptions/delete` | `objects().bulk().deleteSubscriptions` | New (§5.1) |
| Exists | `POST /v1/objects/{collection}/bulk/set` | `objects().bulk().set` |  |

#### `tenants()`

| Status | HTTP | Java method (target) | Notes |
| --- | --- | --- | --- |
| Exists | `GET /v1/tenants` | `tenants().list` |  |
| Exists | `DELETE /v1/tenants/{id}` | `tenants().delete` | Returns nothing (§6.1) |
| Exists | `GET /v1/tenants/{id}` | `tenants().get` | Adds `resolve_full_preference_settings` (§6.2) |
| Exists | `PUT /v1/tenants/{id}` | `tenants().set` | Adds `resolve_full_preference_settings`. Drops `preferences` (§6.1) |
| Exists | `POST /v1/tenants/bulk/delete` | `tenants().bulk().delete` | Keep `tenant_ids[]` wire form (§4.2) |
| Exists | `POST /v1/tenants/bulk/set` | `tenants().bulk().set` |  |

#### `bulkOperations()`

| Status | HTTP | Java method (target) | Notes |
| --- | --- | --- | --- |
| Exists | `GET /v1/bulk_operations/{id}` | `bulkOperations().get` |  |

#### `messages()`

| Status | HTTP | Java method (target) | Notes |
| --- | --- | --- | --- |
| Exists | `GET /v1/messages` | `messages().list` | Wire bug: `entries` → `items` (§4.1). Filters must stay `status[]` (§4.2) |
| Exists | `PUT /v1/messages/{message_id}/archived` | `messages().archive` |  |
| Exists | `GET /v1/messages/{message_id}` | `messages().get` |  |
| Exists | `GET /v1/messages/{message_id}/content` | `messages().getContent` | Returns named `MessageContents` (§5.2) |
| Exists | `GET /v1/messages/{message_id}/activities` | `messages().listActivities` | Remove duplicate `messages().activities().list()` (§5.3) |
| Exists | `GET /v1/messages/{message_id}/delivery_logs` | `messages().listDeliveryLogs` | Wire bug: `entries` → `items` (§4.1) |
| Exists | `GET /v1/messages/{message_id}/events` | `messages().listEvents` | Wire bug: `entries` → `items` (§4.1) |
| Exists | `PUT /v1/messages/{message_id}/interacted` | `messages().markAsInteracted` |  |
| Exists | `PUT /v1/messages/{message_id}/read` | `messages().markAsRead` |  |
| Exists | `PUT /v1/messages/{message_id}/seen` | `messages().markAsSeen` |  |
| Exists | `DELETE /v1/messages/{message_id}/read` | `messages().markAsUnread` |  |
| Exists | `DELETE /v1/messages/{message_id}/seen` | `messages().markAsUnseen` |  |
| Exists | `DELETE /v1/messages/{message_id}/archived` | `messages().unarchive` |  |
| Exists | `POST /v1/messages/batch/archived` | `messages().batch().archive` |  |
| Exists | `GET /v1/messages/batch/content` | `messages().batch().getContent` | Keep `message_ids[]` wire form (§4.2) |
| Exists | `POST /v1/messages/batch/interacted` | `messages().batch().markAsInteracted` |  |
| Exists | `POST /v1/messages/batch/read` | `messages().batch().markAsRead` |  |
| Exists | `POST /v1/messages/batch/seen` | `messages().batch().markAsSeen` |  |
| Exists | `POST /v1/messages/batch/unread` | `messages().batch().markAsUnread` |  |
| Exists | `POST /v1/messages/batch/unseen` | `messages().batch().markAsUnseen` |  |
| Exists | `POST /v1/messages/batch/unarchived` | `messages().batch().unarchive` |  |

#### `providers()`

| Status | HTTP | Java method (target) | Notes |
| --- | --- | --- | --- |
| Exists | `GET /v1/providers/slack/{channel_id}/auth_check` | `providers().slack().checkAuth` |  |
| Exists | `GET /v1/providers/slack/{channel_id}/channels` | `providers().slack().listChannels` |  |
| Exists | `PUT /v1/providers/slack/{channel_id}/revoke_access` | `providers().slack().revokeAccess` |  |
| Exists | `GET /v1/providers/ms-teams/{channel_id}/auth_check` | `providers().msTeams().checkAuth` |  |
| Exists | `GET /v1/providers/ms-teams/{channel_id}/channels` | `providers().msTeams().listChannels` |  |
| Exists | `GET /v1/providers/ms-teams/{channel_id}/teams` | `providers().msTeams().listTeams` |  |
| Exists | `PUT /v1/providers/ms-teams/{channel_id}/revoke_access` | `providers().msTeams().revokeAccess` |  |

#### `integrations()`

| Status | HTTP | Java method (target) | Notes |
| --- | --- | --- | --- |
| Exists | `POST /v1/integrations/census/custom-destination` | `integrations().census().customDestination` |  |
| Exists | `POST /v1/integrations/hightouch/embedded-destination` | `integrations().hightouch().embeddedDestination` |  |

#### `workflows()`

| Status | HTTP | Java method (target) | Notes |
| --- | --- | --- | --- |
| Exists | `POST /v1/workflows/{key}/cancel` | `workflows().cancel` | Returns nothing (§6.1) |
| Exists | `POST /v1/workflows/{key}/trigger` | `workflows().trigger` | Adds `settings` (§6.2) |

#### `workflowRecipientRuns()`

| Status | HTTP | Java method (target) | Notes |
| --- | --- | --- | --- |
| Add | `GET /v1/workflow_recipient_runs` | `workflowRecipientRuns().list` | New (§5.1) |
| Add | `GET /v1/workflow_recipient_runs/{id}` | `workflowRecipientRuns().get` | New (§5.1) |

#### `schedules()`

| Status | HTTP | Java method (target) | Notes |
| --- | --- | --- | --- |
| Exists | `POST /v1/schedules` | `schedules().create` | Adds `actor`. `repeats` becomes optional (§6.2) |
| Exists | `PUT /v1/schedules` | `schedules().update` |  |
| Exists | `GET /v1/schedules` | `schedules().list` | `recipients` becomes `List<RecipientReference>` (§6.1) |
| Exists | `DELETE /v1/schedules` | `schedules().delete` |  |
| Exists | `POST /v1/schedules/bulk/create` | `schedules().bulk().create` |  |

#### `channels()`

| Status | HTTP | Java method (target) | Notes |
| --- | --- | --- | --- |
| Exists | `POST /v1/channels/{channel_id}/messages/bulk/{action}` | `channels().bulk().updateMessageStatus` |  |

#### `audiences()`

| Status | HTTP | Java method (target) | Notes |
| --- | --- | --- | --- |
| Exists | `POST /v1/audiences/{key}/members` | `audiences().addMembers` | Returns nothing (§6.1). Adds `create_audience`. Uses `AudienceMemberRequest` |
| Exists | `GET /v1/audiences/{key}/members` | `audiences().listMembers` |  |
| Exists | `DELETE /v1/audiences/{key}/members` | `audiences().removeMembers` | Returns nothing (§6.1) |
