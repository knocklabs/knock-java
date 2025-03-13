// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ObjectListMessagesParamsTest {

    @Test
    fun create() {
        ObjectListMessagesParams.builder()
            .collection("projects")
            .objectId("project-123")
            .after("after")
            .before("before")
            .channelId("channel_id")
            .addEngagementStatus(ObjectListMessagesParams.EngagementStatus.SEEN)
            .addMessageId("string")
            .pageSize(0L)
            .source("source")
            .addStatus(ObjectListMessagesParams.Status.QUEUED)
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
            ObjectListMessagesParams.builder()
                .collection("projects")
                .objectId("project-123")
                .after("after")
                .before("before")
                .channelId("channel_id")
                .addEngagementStatus(ObjectListMessagesParams.EngagementStatus.SEEN)
                .addMessageId("string")
                .pageSize(0L)
                .source("source")
                .addStatus(ObjectListMessagesParams.Status.QUEUED)
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
        expected.put(
            "engagement_status[]",
            ObjectListMessagesParams.EngagementStatus.SEEN.toString(),
        )
        expected.put("message_ids[]", "string")
        expected.put("page_size", "0")
        expected.put("source", "source")
        expected.put("status[]", ObjectListMessagesParams.Status.QUEUED.toString())
        expected.put("tenant", "tenant")
        expected.put("trigger_data", "trigger_data")
        expected.put("workflow_categories[]", "string")
        expected.put("workflow_recipient_run_id", "182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        expected.put("workflow_run_id", "182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            ObjectListMessagesParams.builder()
                .collection("projects")
                .objectId("project-123")
                .build()
        val expected = QueryParams.builder()
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun getPathParam() {
        val params =
            ObjectListMessagesParams.builder()
                .collection("projects")
                .objectId("project-123")
                .build()
        assertThat(params).isNotNull
        // path param "collection"
        assertThat(params.getPathParam(0)).isEqualTo("projects")
        // path param "objectId"
        assertThat(params.getPathParam(1)).isEqualTo("project-123")
        // out-of-bound path param
        assertThat(params.getPathParam(2)).isEqualTo("")
    }
}
