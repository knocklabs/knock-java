// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.async.messages

import com.knock.api.TestServerExtension
import com.knock.api.client.okhttp.KnockOkHttpClientAsync
import com.knock.api.core.JsonValue
import com.knock.api.models.MessageBatchGetContentParams
import com.knock.api.models.MessageBatchMarkAsInteractedParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class BatchServiceAsyncTest {

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

        val responseFuture = batchServiceAsync.archive()

        val response = responseFuture.get()
        response.forEach { it.validate() }
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
                MessageBatchGetContentParams.builder().addMessageId("string").build()
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

        val responseFuture =
            batchServiceAsync.markAsInteracted(
                MessageBatchMarkAsInteractedParams.builder()
                    .addMessageId("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
                    .metadata(
                        MessageBatchMarkAsInteractedParams.Metadata.builder()
                            .putAdditionalProperty("key", JsonValue.from("bar"))
                            .build()
                    )
                    .build()
            )

        val response = responseFuture.get()
        response.forEach { it.validate() }
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

        val responseFuture = batchServiceAsync.markAsRead()

        val response = responseFuture.get()
        response.forEach { it.validate() }
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

        val responseFuture = batchServiceAsync.markAsSeen()

        val response = responseFuture.get()
        response.forEach { it.validate() }
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

        val responseFuture = batchServiceAsync.markAsUnread()

        val response = responseFuture.get()
        response.forEach { it.validate() }
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

        val responseFuture = batchServiceAsync.markAsUnseen()

        val response = responseFuture.get()
        response.forEach { it.validate() }
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

        val responseFuture = batchServiceAsync.unarchive()

        val response = responseFuture.get()
        response.forEach { it.validate() }
    }
}
