// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.blocking.messages

import com.knock.api.TestServerExtension
import com.knock.api.client.okhttp.KnockOkHttpClient
import com.knock.api.core.JsonValue
import com.knock.api.models.MessageBatchGetContentParams
import com.knock.api.models.MessageBatchMarkAsInteractedParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class BatchServiceTest {

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

        val response = batchService.archive()

        response.forEach { it.validate() }
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
            batchService.getContent(
                MessageBatchGetContentParams.builder().addMessageId("string").build()
            )

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

        val response =
            batchService.markAsInteracted(
                MessageBatchMarkAsInteractedParams.builder()
                    .addMessageId("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
                    .metadata(
                        MessageBatchMarkAsInteractedParams.Metadata.builder()
                            .putAdditionalProperty("key", JsonValue.from("bar"))
                            .build()
                    )
                    .build()
            )

        response.forEach { it.validate() }
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

        val response = batchService.markAsRead()

        response.forEach { it.validate() }
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

        val response = batchService.markAsSeen()

        response.forEach { it.validate() }
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

        val response = batchService.markAsUnread()

        response.forEach { it.validate() }
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

        val response = batchService.markAsUnseen()

        response.forEach { it.validate() }
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

        val response = batchService.unarchive()

        response.forEach { it.validate() }
    }
}
