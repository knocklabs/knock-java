// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages

import app.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageListParamsTest {

    @Test
    fun create() {
        MessageListParams.builder()
            .after("after")
            .before("before")
            .channelId("channel_id")
            .addEngagementStatus(MessageListParams.EngagementStatus.SEEN)
            .insertedAt(
                MessageListParams.InsertedAt.builder()
                    .gt("gt")
                    .gte("gte")
                    .lt("lt")
                    .lte("lte")
                    .build()
            )
            .addMessageId("string")
            .pageSize(0L)
            .source("source")
            .addStatus(MessageListParams.Status.QUEUED)
            .tenant("tenant")
            .triggerData("trigger_data")
            .addWorkflowCategory("string")
            .workflowRecipientRunId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .workflowRunId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            MessageListParams.builder()
                .after("after")
                .before("before")
                .channelId("channel_id")
                .addEngagementStatus(MessageListParams.EngagementStatus.SEEN)
                .insertedAt(
                    MessageListParams.InsertedAt.builder()
                        .gt("gt")
                        .gte("gte")
                        .lt("lt")
                        .lte("lte")
                        .build()
                )
                .addMessageId("string")
                .pageSize(0L)
                .source("source")
                .addStatus(MessageListParams.Status.QUEUED)
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
        val params = MessageListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
