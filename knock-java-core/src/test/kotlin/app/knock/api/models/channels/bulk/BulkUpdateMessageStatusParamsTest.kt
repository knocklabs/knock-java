// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.channels.bulk

import java.time.OffsetDateTime
import kotlin.test.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BulkUpdateMessageStatusParamsTest {

    @Test
    fun create() {
        BulkUpdateMessageStatusParams.builder()
            .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .action(BulkUpdateMessageStatusParams.Action.SEEN)
            .archived(BulkUpdateMessageStatusParams.Archived.EXCLUDE)
            .deliveryStatus(BulkUpdateMessageStatusParams.DeliveryStatus.QUEUED)
            .engagementStatus(BulkUpdateMessageStatusParams.EngagementStatus.SEEN)
            .hasTenant(true)
            .newerThan(OffsetDateTime.parse("2024-01-01T00:00:00Z"))
            .olderThan(OffsetDateTime.parse("2024-01-01T00:00:00Z"))
            .addRecipientId("recipient1")
            .addRecipientId("recipient2")
            .addTenant("tenant1")
            .addTenant("tenant2")
            .triggerData("{\"key\":\"value\"}")
            .addWorkflow("workflow1")
            .addWorkflow("workflow2")
            .build()
    }

    @Test
    fun body() {
        val params =
            BulkUpdateMessageStatusParams.builder()
                .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .action(BulkUpdateMessageStatusParams.Action.SEEN)
                .archived(BulkUpdateMessageStatusParams.Archived.EXCLUDE)
                .deliveryStatus(BulkUpdateMessageStatusParams.DeliveryStatus.QUEUED)
                .engagementStatus(BulkUpdateMessageStatusParams.EngagementStatus.SEEN)
                .hasTenant(true)
                .newerThan(OffsetDateTime.parse("2024-01-01T00:00:00Z"))
                .olderThan(OffsetDateTime.parse("2024-01-01T00:00:00Z"))
                .addRecipientId("recipient1")
                .addRecipientId("recipient2")
                .addTenant("tenant1")
                .addTenant("tenant2")
                .triggerData("{\"key\":\"value\"}")
                .addWorkflow("workflow1")
                .addWorkflow("workflow2")
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.archived()).contains(BulkUpdateMessageStatusParams.Archived.EXCLUDE)
        assertThat(body.deliveryStatus())
            .contains(BulkUpdateMessageStatusParams.DeliveryStatus.QUEUED)
        assertThat(body.engagementStatus())
            .contains(BulkUpdateMessageStatusParams.EngagementStatus.SEEN)
        assertThat(body.hasTenant()).contains(true)
        assertThat(body.newerThan()).contains(OffsetDateTime.parse("2024-01-01T00:00:00Z"))
        assertThat(body.olderThan()).contains(OffsetDateTime.parse("2024-01-01T00:00:00Z"))
        assertThat(body.recipientIds()).contains(listOf("recipient1", "recipient2"))
        assertThat(body.tenants()).contains(listOf("tenant1", "tenant2"))
        assertThat(body.triggerData()).contains("{\"key\":\"value\"}")
        assertThat(body.workflows()).contains(listOf("workflow1", "workflow2"))
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            BulkUpdateMessageStatusParams.builder()
                .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .action(BulkUpdateMessageStatusParams.Action.SEEN)
                .build()

        val body = params._body()

        assertNotNull(body)
    }

    @Test
    fun getPathParam() {
        val params =
            BulkUpdateMessageStatusParams.builder()
                .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .action(BulkUpdateMessageStatusParams.Action.SEEN)
                .build()
        assertThat(params).isNotNull
        // path param "channelId"
        assertThat(params.getPathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // path param "action"
        assertThat(params.getPathParam(1))
            .isEqualTo(BulkUpdateMessageStatusParams.Action.SEEN.toString())
        // out-of-bound path param
        assertThat(params.getPathParam(2)).isEqualTo("")
    }
}
