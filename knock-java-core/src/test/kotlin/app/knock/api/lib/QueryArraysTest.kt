package app.knock.api.lib

import app.knock.api.core.http.QueryParams
import app.knock.api.models.messages.MessageListParams
import app.knock.api.models.messages.batch.BatchGetContentParams
import app.knock.api.models.objects.ObjectListParams
import app.knock.api.models.objects.ObjectListSubscriptionsParams
import app.knock.api.models.recipients.RecipientReference
import app.knock.api.models.schedules.ScheduleListParams
import app.knock.api.models.tenants.bulk.BulkDeleteParams as TenantBulkDeleteParams
import app.knock.api.models.users.UserListSubscriptionsParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class QueryArraysTest {

    private fun objectRef(id: String, collection: String) =
        RecipientReference.ObjectReference.builder().id(id).collection(collection).build()

    @Test
    fun scalarArraysUseBrackets() {
        val queryParams =
            QueryParams.builder()
                .apply {
                    putQueryArray(
                        "status",
                        listOf(QueryArrayElement.Value("sent"), QueryArrayElement.Value("bounced")),
                    )
                }
                .build()

        assertThat(queryParams)
            .isEqualTo(QueryParams.builder().put("status[]", listOf("sent", "bounced")).build())
    }

    @Test
    fun objectArraysUseIndices() {
        val queryParams =
            QueryParams.builder()
                .apply {
                    putQueryArray(
                        "objects",
                        listOf(
                            QueryArrayElement.Fields(listOf("id" to "a", "collection" to "x")),
                            QueryArrayElement.Fields(listOf("id" to "b", "collection" to "y")),
                        ),
                    )
                }
                .build()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("objects[0][id]", "a")
                    .put("objects[0][collection]", "x")
                    .put("objects[1][id]", "b")
                    .put("objects[1][collection]", "y")
                    .build()
            )
    }

    @Test
    fun mixedArraysIndexEveryElement() {
        val queryParams =
            QueryParams.builder()
                .apply {
                    putQueryArray(
                        "recipients",
                        listOf(
                            RecipientReference.ofUser("user_1").toQueryArrayElement(),
                            RecipientReference.ofObjectReference(objectRef("project_1", "projects"))
                                .toQueryArrayElement(),
                        ),
                    )
                }
                .build()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("recipients[0]", "user_1")
                    .put("recipients[1][id]", "project_1")
                    .put("recipients[1][collection]", "projects")
                    .build()
            )
    }

    @Test
    fun singleObjectUsesKeyedFields() {
        val queryParams =
            QueryParams.builder()
                .apply {
                    putQueryObject(
                        "recipient",
                        RecipientReference.ofObjectReference(objectRef("project_1", "projects"))
                            .toQueryArrayElement(),
                    )
                }
                .build()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("recipient[id]", "project_1")
                    .put("recipient[collection]", "projects")
                    .build()
            )
    }

    @Test
    fun primitiveArrayParamsKeepBracketKeys() {
        assertThat(
                MessageListParams.builder()
                    .addStatus(MessageListParams.Status.BOUNCED)
                    .build()
                    ._queryParams()
                    .values("status[]")
            )
            .containsExactly("bounced")
        assertThat(
                ObjectListParams.builder()
                    .collection("projects")
                    .addInclude(ObjectListParams.Include.PREFERENCES)
                    .build()
                    ._queryParams()
                    .values("include[]")
            )
            .containsExactly("preferences")
        assertThat(
                BatchGetContentParams.builder()
                    .addMessageId("m1")
                    .addMessageId("m2")
                    .build()
                    ._queryParams()
                    .values("message_ids[]")
            )
            .containsExactly("m1", "m2")
        assertThat(
                TenantBulkDeleteParams.builder()
                    .addTenantId("t1")
                    .build()
                    ._queryParams()
                    .values("tenant_ids[]")
            )
            .containsExactly("t1")
    }

    @Test
    fun objectSubscriptionFiltersUseIndices() {
        val queryParams =
            ObjectListSubscriptionsParams.builder()
                .collection("projects")
                .objectId("project_1")
                .addRecipient("user_1")
                .addRecipient(objectRef("team_1", "teams"))
                .build()
                ._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("recipients[0]", "user_1")
                    .put("recipients[1][id]", "team_1")
                    .put("recipients[1][collection]", "teams")
                    .build()
            )
    }

    @Test
    fun userSubscriptionObjectFilters() {
        val scalarOnly =
            UserListSubscriptionsParams.builder().userId("u").addObject("project_1").build()
        assertThat(scalarOnly._queryParams())
            .isEqualTo(QueryParams.builder().put("objects[]", "project_1").build())

        val references =
            UserListSubscriptionsParams.builder()
                .userId("u")
                .addObject(objectRef("project_1", "projects"))
                .build()
        assertThat(references._queryParams())
            .isEqualTo(
                QueryParams.builder()
                    .put("objects[0][id]", "project_1")
                    .put("objects[0][collection]", "projects")
                    .build()
            )
    }

    @Test
    fun scheduleRecipientFilters() {
        val queryParams =
            ScheduleListParams.builder()
                .workflow("wf")
                .addRecipient("user_1")
                .addRecipient("user_2")
                .build()
                ._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("workflow", "wf")
                    .put("recipients[]", listOf("user_1", "user_2"))
                    .build()
            )
    }
}
