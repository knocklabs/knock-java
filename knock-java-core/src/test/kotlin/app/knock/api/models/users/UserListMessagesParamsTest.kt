// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserListMessagesParamsTest {

    @Test
    fun create() {
        UserListMessagesParams.builder()
            .userId("user-123")
            .after("after")
            .before("before")
            .channelId("channel_id")
            .addEngagementStatus(UserListMessagesParams.EngagementStatus.SEEN)
            .insertedAt(
                UserListMessagesParams.InsertedAt.builder()
                    .gt("gt")
                    .gte("gte")
                    .lt("lt")
                    .lte("lte")
                    .build()
            )
            .addMessageId("string")
            .pageSize(0L)
            .source("source")
            .addStatus(UserListMessagesParams.Status.QUEUED)
            .tenant("tenant")
            .triggerData("trigger_data")
            .addWorkflowCategory("string")
            .workflowRecipientRunId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .workflowRunId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .build()
    }

    @Test
    fun pathParams() {
        val params = UserListMessagesParams.builder().userId("user-123").build()

        assertThat(params._pathParam(0)).isEqualTo("user-123")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            UserListMessagesParams.builder()
                .userId("user-123")
                .after("after")
                .before("before")
                .channelId("channel_id")
                .addEngagementStatus(UserListMessagesParams.EngagementStatus.SEEN)
                .insertedAt(
                    UserListMessagesParams.InsertedAt.builder()
                        .gt("gt")
                        .gte("gte")
                        .lt("lt")
                        .lte("lte")
                        .build()
                )
                .addMessageId("string")
                .pageSize(0L)
                .source("source")
                .addStatus(UserListMessagesParams.Status.QUEUED)
                .tenant("tenant")
                .triggerData("trigger_data")
                .addWorkflowCategory("string")
                .workflowRecipientRunId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .workflowRunId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "after")
                    .put("before", "before")
                    .put("channel_id", "channel_id")
                    .put("engagement_status[]", "seen")
                    .put("inserted_at[gt]", "gt")
                    .put("inserted_at[gte]", "gte")
                    .put("inserted_at[lt]", "lt")
                    .put("inserted_at[lte]", "lte")
                    .put("message_ids[]", "string")
                    .put("page_size", "0")
                    .put("source", "source")
                    .put("status[]", "queued")
                    .put("tenant", "tenant")
                    .put("trigger_data", "trigger_data")
                    .put("workflow_categories[]", "string")
                    .put("workflow_recipient_run_id", "182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .put("workflow_run_id", "182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = UserListMessagesParams.builder().userId("user-123").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
