// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking.channels

import app.knock.api.TestServerExtension
import app.knock.api.client.okhttp.KnockOkHttpClient
import app.knock.api.models.channels.bulk.BulkUpdateMessageStatusParams
import java.time.OffsetDateTime
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class BulkServiceTest {

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun updateMessageStatus() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val bulkService = client.channels().bulk()

        val bulkOperation =
            bulkService.updateMessageStatus(
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

        bulkOperation.validate()
    }
}
