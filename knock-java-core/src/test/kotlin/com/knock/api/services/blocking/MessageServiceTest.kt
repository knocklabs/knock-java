// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.blocking

import com.knock.api.TestServerExtension
import com.knock.api.client.okhttp.KnockOkHttpClient
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
class MessageServiceTest {

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun list() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val messageService = client.messages()

        val page = messageService.list()

        page.response().validate()
    }

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
        val messageService = client.messages()

        val message =
            messageService.archive(
                MessageArchiveParams.builder().messageId("1jNaXzB2RZX3LY8wVQnfCKyPnv7").build()
            )

        message.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun get() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val messageService = client.messages()

        val message =
            messageService.get(
                MessageGetParams.builder().messageId("1jNaXzB2RZX3LY8wVQnfCKyPnv7").build()
            )

        message.validate()
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
        val messageService = client.messages()

        val response =
            messageService.getContent(
                MessageGetContentParams.builder().messageId("message_id").build()
            )

        response.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun listActivities() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val messageService = client.messages()

        val page =
            messageService.listActivities(
                MessageListActivitiesParams.builder().messageId("message_id").build()
            )

        page.response().validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun listDeliveryLogs() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val messageService = client.messages()

        val page =
            messageService.listDeliveryLogs(
                MessageListDeliveryLogsParams.builder().messageId("message_id").build()
            )

        page.response().validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun listEvents() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val messageService = client.messages()

        val page =
            messageService.listEvents(
                MessageListEventsParams.builder().messageId("message_id").build()
            )

        page.response().validate()
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
        val messageService = client.messages()

        val message =
            messageService.markAsInteracted(
                MessageMarkAsInteractedParams.builder()
                    .messageId("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
                    .metadata(
                        MessageMarkAsInteractedParams.Metadata.builder()
                            .putAdditionalProperty("key", JsonValue.from("bar"))
                            .build()
                    )
                    .build()
            )

        message.validate()
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
        val messageService = client.messages()

        val message =
            messageService.markAsRead(
                MessageMarkAsReadParams.builder().messageId("1jNaXzB2RZX3LY8wVQnfCKyPnv7").build()
            )

        message.validate()
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
        val messageService = client.messages()

        val message =
            messageService.markAsSeen(
                MessageMarkAsSeenParams.builder().messageId("1jNaXzB2RZX3LY8wVQnfCKyPnv7").build()
            )

        message.validate()
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
        val messageService = client.messages()

        val message =
            messageService.markAsUnread(
                MessageMarkAsUnreadParams.builder().messageId("1jNaXzB2RZX3LY8wVQnfCKyPnv7").build()
            )

        message.validate()
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
        val messageService = client.messages()

        val message =
            messageService.markAsUnseen(
                MessageMarkAsUnseenParams.builder().messageId("1jNaXzB2RZX3LY8wVQnfCKyPnv7").build()
            )

        message.validate()
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
        val messageService = client.messages()

        val message =
            messageService.unarchive(
                MessageUnarchiveParams.builder().messageId("1jNaXzB2RZX3LY8wVQnfCKyPnv7").build()
            )

        message.validate()
    }
}
