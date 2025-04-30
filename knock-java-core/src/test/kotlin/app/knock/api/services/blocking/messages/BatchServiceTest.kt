// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking.messages

import app.knock.api.TestServerExtension
import app.knock.api.client.okhttp.KnockOkHttpClient
import app.knock.api.core.JsonValue
import app.knock.api.models.messages.batch.BatchArchiveParams
import app.knock.api.models.messages.batch.BatchGetContentParams
import app.knock.api.models.messages.batch.BatchMarkAsInteractedParams
import app.knock.api.models.messages.batch.BatchMarkAsReadParams
import app.knock.api.models.messages.batch.BatchMarkAsSeenParams
import app.knock.api.models.messages.batch.BatchMarkAsUnreadParams
import app.knock.api.models.messages.batch.BatchMarkAsUnseenParams
import app.knock.api.models.messages.batch.BatchUnarchiveParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class BatchServiceTest {

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun archive() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val batchService = client.messages().batch()

        val messages =
            batchService.archive(
                BatchArchiveParams.builder()
                    .addMessageId("2w3YUpTTOxuDvZFji8OMsKrG176")
                    .addMessageId("2w3YVRbPXMIh8Zq6oBFcVDA5xes")
                    .build()
            )

        messages.forEach { it.validate() }
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun getContent() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val batchService = client.messages().batch()

        val response =
            batchService.getContent(BatchGetContentParams.builder().addMessageId("string").build())

        response.forEach { it.validate() }
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun markAsInteracted() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val batchService = client.messages().batch()

        val messages =
            batchService.markAsInteracted(
                BatchMarkAsInteractedParams.builder()
                    .addMessageId("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
                    .metadata(
                        BatchMarkAsInteractedParams.Metadata.builder()
                            .putAdditionalProperty("key", JsonValue.from("bar"))
                            .build()
                    )
                    .build()
            )

        messages.forEach { it.validate() }
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun markAsRead() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val batchService = client.messages().batch()

        val messages =
            batchService.markAsRead(
                BatchMarkAsReadParams.builder()
                    .addMessageId("2w3YUpTTOxuDvZFji8OMsKrG176")
                    .addMessageId("2w3YVRbPXMIh8Zq6oBFcVDA5xes")
                    .build()
            )

        messages.forEach { it.validate() }
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun markAsSeen() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val batchService = client.messages().batch()

        val messages =
            batchService.markAsSeen(
                BatchMarkAsSeenParams.builder()
                    .addMessageId("2w3YUpTTOxuDvZFji8OMsKrG176")
                    .addMessageId("2w3YVRbPXMIh8Zq6oBFcVDA5xes")
                    .build()
            )

        messages.forEach { it.validate() }
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun markAsUnread() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val batchService = client.messages().batch()

        val messages =
            batchService.markAsUnread(
                BatchMarkAsUnreadParams.builder()
                    .addMessageId("2w3YUpTTOxuDvZFji8OMsKrG176")
                    .addMessageId("2w3YVRbPXMIh8Zq6oBFcVDA5xes")
                    .build()
            )

        messages.forEach { it.validate() }
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun markAsUnseen() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val batchService = client.messages().batch()

        val messages =
            batchService.markAsUnseen(
                BatchMarkAsUnseenParams.builder()
                    .addMessageId("2w3YUpTTOxuDvZFji8OMsKrG176")
                    .addMessageId("2w3YVRbPXMIh8Zq6oBFcVDA5xes")
                    .build()
            )

        messages.forEach { it.validate() }
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun unarchive() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val batchService = client.messages().batch()

        val messages =
            batchService.unarchive(
                BatchUnarchiveParams.builder()
                    .addMessageId("2w3YUpTTOxuDvZFji8OMsKrG176")
                    .addMessageId("2w3YVRbPXMIh8Zq6oBFcVDA5xes")
                    .build()
            )

        messages.forEach { it.validate() }
    }
}
