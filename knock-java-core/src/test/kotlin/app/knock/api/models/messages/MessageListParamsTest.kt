// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages

import app.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MessageListParamsTest {

    @Test
    fun create() {
        MessageListParams.builder()
            .after("after")
            .before("before")
            .channelId("channel_id")
            .addEngagementStatus(MessageListParams.EngagementStatus.SEEN)
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
        val expected = QueryParams.builder()
        expected.put("after", "after")
        expected.put("before", "before")
        expected.put("channel_id", "channel_id")
        expected.put("engagement_status[]", MessageListParams.EngagementStatus.SEEN.toString())
        expected.put("message_ids[]", "string")
        expected.put("page_size", "0")
        expected.put("source", "source")
        expected.put("status[]", MessageListParams.Status.QUEUED.toString())
        expected.put("tenant", "tenant")
        expected.put("trigger_data", "trigger_data")
        expected.put("workflow_categories[]", "string")
        expected.put("workflow_recipient_run_id", "182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        expected.put("workflow_run_id", "182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = MessageListParams.builder().build()
        val expected = QueryParams.builder()
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }
}
