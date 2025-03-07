// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.async

import com.knock.api.TestServerExtension
import com.knock.api.client.okhttp.KnockOkHttpClientAsync
import com.knock.api.core.JsonValue
import com.knock.api.models.MessageArchiveParams
import com.knock.api.models.MessageGetContentParams
import com.knock.api.models.MessageGetParams
import com.knock.api.models.MessageListActivitiesParams
import com.knock.api.models.MessageListDeliveryLogsParams
import com.knock.api.models.MessageListEventsParams
import com.knock.api.models.MessageMarkAsInteractedParams
import com.knock.api.models.MessageMarkAsReadParams
import com.knock.api.models.MessageMarkAsSeenParams
import com.knock.api.models.MessageMarkAsUnreadParams
import com.knock.api.models.MessageMarkAsUnseenParams
import com.knock.api.models.MessageUnarchiveParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class MessageServiceAsyncTest {

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun list() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val messageServiceAsync = client.messages()

        val pageFuture = messageServiceAsync.list()

        val page = pageFuture.get()
        page.response().validate()
    }

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
        val messageServiceAsync = client.messages()

        val responseFuture =
            messageServiceAsync.archive(
                MessageArchiveParams.builder().messageId("1jNaXzB2RZX3LY8wVQnfCKyPnv7").build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun get() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val messageServiceAsync = client.messages()

        val messageFuture =
            messageServiceAsync.get(
                MessageGetParams.builder().messageId("1jNaXzB2RZX3LY8wVQnfCKyPnv7").build()
            )

        val message = messageFuture.get()
        message.validate()
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
        val messageServiceAsync = client.messages()

        val responseFuture =
            messageServiceAsync.getContent(
                MessageGetContentParams.builder().messageId("message_id").build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun listActivities() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val messageServiceAsync = client.messages()

        val pageFuture =
            messageServiceAsync.listActivities(
                MessageListActivitiesParams.builder().messageId("message_id").build()
            )

        val page = pageFuture.get()
        page.response().validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun listDeliveryLogs() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val messageServiceAsync = client.messages()

        val pageFuture =
            messageServiceAsync.listDeliveryLogs(
                MessageListDeliveryLogsParams.builder().messageId("message_id").build()
            )

        val page = pageFuture.get()
        page.response().validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun listEvents() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val messageServiceAsync = client.messages()

        val pageFuture =
            messageServiceAsync.listEvents(
                MessageListEventsParams.builder().messageId("message_id").build()
            )

        val page = pageFuture.get()
        page.response().validate()
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
        val messageServiceAsync = client.messages()

        val responseFuture =
            messageServiceAsync.markAsInteracted(
                MessageMarkAsInteractedParams.builder()
                    .messageId("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
                    .metadata(
                        MessageMarkAsInteractedParams.Metadata.builder()
                            .putAdditionalProperty("key", JsonValue.from("bar"))
                            .build()
                    )
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
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
        val messageServiceAsync = client.messages()

        val responseFuture =
            messageServiceAsync.markAsRead(
                MessageMarkAsReadParams.builder().messageId("1jNaXzB2RZX3LY8wVQnfCKyPnv7").build()
            )

        val response = responseFuture.get()
        response.validate()
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
        val messageServiceAsync = client.messages()

        val responseFuture =
            messageServiceAsync.markAsSeen(
                MessageMarkAsSeenParams.builder().messageId("1jNaXzB2RZX3LY8wVQnfCKyPnv7").build()
            )

        val response = responseFuture.get()
        response.validate()
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
        val messageServiceAsync = client.messages()

        val responseFuture =
            messageServiceAsync.markAsUnread(
                MessageMarkAsUnreadParams.builder().messageId("1jNaXzB2RZX3LY8wVQnfCKyPnv7").build()
            )

        val response = responseFuture.get()
        response.validate()
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
        val messageServiceAsync = client.messages()

        val responseFuture =
            messageServiceAsync.markAsUnseen(
                MessageMarkAsUnseenParams.builder().messageId("1jNaXzB2RZX3LY8wVQnfCKyPnv7").build()
            )

        val response = responseFuture.get()
        response.validate()
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
        val messageServiceAsync = client.messages()

        val responseFuture =
            messageServiceAsync.unarchive(
                MessageUnarchiveParams.builder().messageId("1jNaXzB2RZX3LY8wVQnfCKyPnv7").build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
