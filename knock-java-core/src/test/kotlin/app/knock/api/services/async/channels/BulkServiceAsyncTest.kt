// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async.channels

import app.knock.api.TestServerExtension
import app.knock.api.client.okhttp.KnockOkHttpClientAsync
import app.knock.api.models.channels.bulk.BulkUpdateMessageStatusParams
import java.time.OffsetDateTime
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class BulkServiceAsyncTest {

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun updateMessageStatus() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val bulkServiceAsync = client.channels().bulk()

        val bulkOperationFuture =
            bulkServiceAsync.updateMessageStatus(
                BulkUpdateMessageStatusParams.builder()
                    .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .status(BulkUpdateMessageStatusParams.Status.SEEN)
                    .archived(BulkUpdateMessageStatusParams.Archived.INCLUDE)
                    .deliveryStatus(BulkUpdateMessageStatusParams.DeliveryStatus.DELIVERED)
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
            )

        val bulkOperation = bulkOperationFuture.get()
        bulkOperation.validate()
    }
}
