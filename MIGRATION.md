# Migration guide

## 2.0.0: OpenAPI modernization

This release brings the SDK in line with the current [Knock OpenAPI spec](https://api.knock.app/v1/openapi) and with the [Node SDK](https://github.com/knocklabs/knock-node). Most changes are additive. The breaking changes are listed below.

### Endpoints that return `204 No Content` return nothing

These methods used to return a `String` (always empty). They now return nothing, `CompletableFuture<Void?>` for the async client, and their raw-response variants return `HttpResponse` instead of `HttpResponseFor<String>`:

- `users().delete`, `objects().delete`, `tenants().delete`
- `users().unsetChannelData`, `objects().unsetChannelData`
- `audiences().addMembers`, `audiences().removeMembers`
- `workflows().cancel`

```java
// Before
String result = client.users().delete("user_1");

// After
client.users().delete("user_1");
```

### Message lists read `items` instead of `entries`

The API returns message, event, and delivery log lists under `items`. The old `entries()` accessor always returned an empty list. The page accessor is now `items()` on:

- `MessageListPage`, `UserListMessagesPage`, `ObjectListMessagesPage`
- `MessageListEventsPage`, `MessageListDeliveryLogsPage`

The same applies to the async page classes and to the `*PageResponse` classes (`items()` / `_items()`). `autoPager()` works unchanged.

```java
// Before
List<Message> messages = client.messages().list().entries();

// After
List<Message> messages = client.messages().list().items();
```

### Guide message actions use the path-less endpoints

`users().guides().markMessageAsSeen`, `markMessageAsInteracted`, and `markMessageAsArchived` now call `PUT /v1/users/{user_id}/guides/messages/{action}` and no longer take a `messageId`. The guide, step, and channel are identified in the request body instead:

```java
// Before
client.users().guides().markMessageAsSeen("user_1", "message_1", params);

// After
client.users().guides().markMessageAsSeen(
    "user_1",
    GuideMarkMessageAsSeenParams.builder()
        .channelId("channel_1")
        .guideId("guide_1")
        .guideKey("onboarding")
        .guideStepRef("step_1")
        .content(GuideMarkMessageAsSeenParams.Content.builder().build())
        .build());
```

- The three `GuideMarkMessageAs*Response` classes are replaced by a single `GuideActionResponse`.
- `GuideGetChannelResponse` matches the API's current shape: `entries()`, `guideGroups()`, `guideGroupDisplayLogs()`, and `ineligibleGuides()` replace `guides()` and `recipient()`.

### `messages().activities()` is removed

`messages().activities().list(...)` duplicated `messages().listActivities(...)`, which calls the same endpoint. Use `listActivities`:

```java
// Before
client.messages().activities().list(ActivityListParams.builder().messageId("message_1").build());

// After
client.messages().listActivities("message_1");
```

### Recipient filters accept object references

`UserListSubscriptionsParams.objects`, `ObjectListSubscriptionsParams.recipients`, and `ScheduleListParams.recipients` are now `List<RecipientReference>` instead of `List<String>`, so that object recipients can be filtered on. The `addObject(String)` and `addRecipient(String)` overloads still accept user IDs:

```java
ScheduleListParams.builder()
    .workflow("digest")
    .addRecipient("user_1")
    .addRecipient(RecipientReference.ObjectReference.builder().collection("projects").id("p1").build())
    .build();
```

Object references are now sent in the indexed form (`recipients[0][collection]=...`) that the API expects.

### Bulk add subscriptions requires `id`

Each item in `objects().bulk().addSubscriptions` now requires the object `id`, as the API does:

```java
BulkAddSubscriptionsParams.Subscription.builder()
    .id("project_1")
    .addRecipient("user_1")
    .build();
```

### Schedule `repeats` is optional

`ScheduleCreateParams.repeats()` returns `Optional<List<ScheduleRepeatRule>>`, because a schedule can be created with only `scheduled_at`.

### Dependency updates

The SDK still supports Java 8, but its dependencies have moved to their current major versions:

- **OkHttp 5.** `knock-java-client-okhttp` (and so `knock-java`) now depends on OkHttp 5.5.0, via the `com.squareup.okhttp3:okhttp-jvm` artifact. OkHttp 5 is binary compatible with OkHttp 4 for most uses. If your build pins `com.squareup.okhttp3:okhttp` to 4.x, remove the pin or move it to 5.x. In Maven, depend on `okhttp-jvm` rather than `okhttp`, because the `okhttp` artifact is empty in OkHttp 5.
- **Kotlin.** The SDK is compiled with language and API version 2.2 and depends on `kotlin-stdlib` 2.2 or later (OkHttp 5 already requires `kotlin-stdlib` 2.x). Java projects aren't affected beyond the newer transitive `kotlin-stdlib`. Kotlin projects need the Kotlin 2.1 compiler or later.
- **Jackson.** The default Jackson version is 2.22.3. The minimum supported version is still 2.13.4.
- **Apache HttpClient.** The transitive `httpclient5` and `httpcore5` versions are 5.6.4 and 5.4.4.

## New functionality

- `workflowRecipientRuns()` with `list` and `get`
- `users().preferenceCenter()` with `getConfig` and `generateSignedUrl`
- `users().unsetPreferences` and `objects().unsetPreferences`
- `objects().bulk().deleteSubscriptions`
- `users().guides().resetGuideEngagements` and `unarchiveGuideMessage`
- `app.knock.api.lib.UserTokens` for signing user tokens (see the README)
- New request fields: workflow trigger `settings` (`sandbox_mode`, `skip_delay`), schedule `actor`, tenant `name`, `resolve_full_preference_settings` on tenants, `create_audience` on audience members, feed `locale` / `exclude` / `mode` / `inserted_at`, and inline user `avatar` / `locale` / `phone_number`
- New response fields: message `source` run identifiers and connection `knock_tenant_id`
