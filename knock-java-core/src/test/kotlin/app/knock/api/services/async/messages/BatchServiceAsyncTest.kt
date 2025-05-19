// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async.messages

import app.knock.api.TestServerExtension
import app.knock.api.client.okhttp.KnockOkHttpClientAsync
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
internal class BatchServiceAsyncTest {

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun archive() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val batchServiceAsync = client.messages().batch()

        val messagesFuture =
            batchServiceAsync.archive(
                BatchArchiveParams.builder()
                    .addMessageId("2w3YUpTTOxuDvZFji8OMsKrG176")
                    .addMessageId("2w3YVRbPXMIh8Zq6oBFcVDA5xes")
                    .build()
            )

        val messages = messagesFuture.get()
        messages.forEach { it.validate() }
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun getContent() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val batchServiceAsync = client.messages().batch()

        val responseFuture =
            batchServiceAsync.getContent(
                BatchGetContentParams.builder().addMessageId("string").build()
            )

        val response = responseFuture.get()
        response.forEach { it.validate() }
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun markAsInteracted() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val batchServiceAsync = client.messages().batch()

        val messagesFuture =
            batchServiceAsync.markAsInteracted(
                BatchMarkAsInteractedParams.builder()
                    .addMessageId("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
                    .metadata(
                        BatchMarkAsInteractedParams.Metadata.builder()
                            .putAdditionalProperty("key", JsonValue.from("bar"))
                            .build()
                    )
                    .build()
            )

        val messages = messagesFuture.get()
        messages.forEach { it.validate() }
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun markAsRead() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val batchServiceAsync = client.messages().batch()

        val messagesFuture =
            batchServiceAsync.markAsRead(
                BatchMarkAsReadParams.builder()
                    .addMessageId("2w3YUpTTOxuDvZFji8OMsKrG176")
                    .addMessageId("2w3YVRbPXMIh8Zq6oBFcVDA5xes")
                    .build()
            )

        val messages = messagesFuture.get()
        messages.forEach { it.validate() }
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun markAsSeen() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val batchServiceAsync = client.messages().batch()

        val messagesFuture =
            batchServiceAsync.markAsSeen(
                BatchMarkAsSeenParams.builder()
                    .addMessageId("2w3YUpTTOxuDvZFji8OMsKrG176")
                    .addMessageId("2w3YVRbPXMIh8Zq6oBFcVDA5xes")
                    .build()
            )

        val messages = messagesFuture.get()
        messages.forEach { it.validate() }
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun markAsUnread() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val batchServiceAsync = client.messages().batch()

        val messagesFuture =
            batchServiceAsync.markAsUnread(
                BatchMarkAsUnreadParams.builder()
                    .addMessageId("2w3YUpTTOxuDvZFji8OMsKrG176")
                    .addMessageId("2w3YVRbPXMIh8Zq6oBFcVDA5xes")
                    .build()
            )

        val messages = messagesFuture.get()
        messages.forEach { it.validate() }
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun markAsUnseen() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val batchServiceAsync = client.messages().batch()

        val messagesFuture =
            batchServiceAsync.markAsUnseen(
                BatchMarkAsUnseenParams.builder()
                    .addMessageId("2w3YUpTTOxuDvZFji8OMsKrG176")
                    .addMessageId("2w3YVRbPXMIh8Zq6oBFcVDA5xes")
                    .build()
            )

        val messages = messagesFuture.get()
        messages.forEach { it.validate() }
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun unarchive() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val batchServiceAsync = client.messages().batch()

        val messagesFuture =
            batchServiceAsync.unarchive(
                BatchUnarchiveParams.builder()
                    .addMessageId("2w3YUpTTOxuDvZFji8OMsKrG176")
                    .addMessageId("2w3YVRbPXMIh8Zq6oBFcVDA5xes")
                    .build()
            )

        val messages = messagesFuture.get()
        messages.forEach { it.validate() }
    }
}
