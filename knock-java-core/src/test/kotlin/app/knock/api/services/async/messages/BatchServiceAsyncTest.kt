// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async.messages

import app.knock.api.TestServerExtension
import app.knock.api.client.okhttp.KnockOkHttpClientAsync
import app.knock.api.core.JsonValue
import app.knock.api.models.messages.batch.BatchGetContentParams
import app.knock.api.models.messages.batch.BatchMarkAsInteractedParams
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
                .bearerToken("My Bearer Token")
                .build()
        val batchServiceAsync = client.messages().batch()

        val messagesFuture = batchServiceAsync.archive()

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
                .bearerToken("My Bearer Token")
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
                .bearerToken("My Bearer Token")
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
                .bearerToken("My Bearer Token")
                .build()
        val batchServiceAsync = client.messages().batch()

        val messagesFuture = batchServiceAsync.markAsRead()

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
                .bearerToken("My Bearer Token")
                .build()
        val batchServiceAsync = client.messages().batch()

        val messagesFuture = batchServiceAsync.markAsSeen()

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
                .bearerToken("My Bearer Token")
                .build()
        val batchServiceAsync = client.messages().batch()

        val messagesFuture = batchServiceAsync.markAsUnread()

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
                .bearerToken("My Bearer Token")
                .build()
        val batchServiceAsync = client.messages().batch()

        val messagesFuture = batchServiceAsync.markAsUnseen()

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
                .bearerToken("My Bearer Token")
                .build()
        val batchServiceAsync = client.messages().batch()

        val messagesFuture = batchServiceAsync.unarchive()

        val messages = messagesFuture.get()
        messages.forEach { it.validate() }
    }
}
