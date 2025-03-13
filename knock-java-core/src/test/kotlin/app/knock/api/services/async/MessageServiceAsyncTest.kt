// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async

import app.knock.api.TestServerExtension
import app.knock.api.client.okhttp.KnockOkHttpClientAsync
import app.knock.api.core.JsonValue
import app.knock.api.models.messages.MessageArchiveParams
import app.knock.api.models.messages.MessageGetContentParams
import app.knock.api.models.messages.MessageGetParams
import app.knock.api.models.messages.MessageListActivitiesParams
import app.knock.api.models.messages.MessageListDeliveryLogsParams
import app.knock.api.models.messages.MessageListEventsParams
import app.knock.api.models.messages.MessageListParams
import app.knock.api.models.messages.MessageMarkAsInteractedParams
import app.knock.api.models.messages.MessageMarkAsReadParams
import app.knock.api.models.messages.MessageMarkAsSeenParams
import app.knock.api.models.messages.MessageMarkAsUnreadParams
import app.knock.api.models.messages.MessageMarkAsUnseenParams
import app.knock.api.models.messages.MessageUnarchiveParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class MessageServiceAsyncTest {

    @Disabled("skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url")
    @Test
    fun list() {
      val client = KnockOkHttpClientAsync.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .bearerToken("My Bearer Token")
          .build()
      val messageServiceAsync = client.messages()

      val pageFuture = messageServiceAsync.list()

      val page = pageFuture.get()
      page.response().validate()
    }

    @Disabled("skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url")
    @Test
    fun archive() {
      val client = KnockOkHttpClientAsync.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .bearerToken("My Bearer Token")
          .build()
      val messageServiceAsync = client.messages()

      val messageFuture = messageServiceAsync.archive(MessageArchiveParams.builder()
          .messageId("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
          .build())

      val message = messageFuture.get()
      message.validate()
    }

    @Disabled("skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url")
    @Test
    fun get() {
      val client = KnockOkHttpClientAsync.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .bearerToken("My Bearer Token")
          .build()
      val messageServiceAsync = client.messages()

      val messageFuture = messageServiceAsync.get(MessageGetParams.builder()
          .messageId("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
          .build())

      val message = messageFuture.get()
      message.validate()
    }

    @Disabled("skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url")
    @Test
    fun getContent() {
      val client = KnockOkHttpClientAsync.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .bearerToken("My Bearer Token")
          .build()
      val messageServiceAsync = client.messages()

      val responseFuture = messageServiceAsync.getContent(MessageGetContentParams.builder()
          .messageId("message_id")
          .build())

      val response = responseFuture.get()
      response.validate()
    }

    @Disabled("skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url")
    @Test
    fun listActivities() {
      val client = KnockOkHttpClientAsync.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .bearerToken("My Bearer Token")
          .build()
      val messageServiceAsync = client.messages()

      val pageFuture = messageServiceAsync.listActivities(MessageListActivitiesParams.builder()
          .messageId("message_id")
          .build())

      val page = pageFuture.get()
      page.response().validate()
    }

    @Disabled("skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url")
    @Test
    fun listDeliveryLogs() {
      val client = KnockOkHttpClientAsync.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .bearerToken("My Bearer Token")
          .build()
      val messageServiceAsync = client.messages()

      val pageFuture = messageServiceAsync.listDeliveryLogs(MessageListDeliveryLogsParams.builder()
          .messageId("message_id")
          .build())

      val page = pageFuture.get()
      page.response().validate()
    }

    @Disabled("skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url")
    @Test
    fun listEvents() {
      val client = KnockOkHttpClientAsync.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .bearerToken("My Bearer Token")
          .build()
      val messageServiceAsync = client.messages()

      val pageFuture = messageServiceAsync.listEvents(MessageListEventsParams.builder()
          .messageId("message_id")
          .build())

      val page = pageFuture.get()
      page.response().validate()
    }

    @Disabled("skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url")
    @Test
    fun markAsInteracted() {
      val client = KnockOkHttpClientAsync.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .bearerToken("My Bearer Token")
          .build()
      val messageServiceAsync = client.messages()

      val messageFuture = messageServiceAsync.markAsInteracted(MessageMarkAsInteractedParams.builder()
          .messageId("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
          .metadata(MessageMarkAsInteractedParams.Metadata.builder()
              .putAdditionalProperty("key", JsonValue.from("bar"))
              .build())
          .build())

      val message = messageFuture.get()
      message.validate()
    }

    @Disabled("skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url")
    @Test
    fun markAsRead() {
      val client = KnockOkHttpClientAsync.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .bearerToken("My Bearer Token")
          .build()
      val messageServiceAsync = client.messages()

      val messageFuture = messageServiceAsync.markAsRead(MessageMarkAsReadParams.builder()
          .messageId("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
          .build())

      val message = messageFuture.get()
      message.validate()
    }

    @Disabled("skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url")
    @Test
    fun markAsSeen() {
      val client = KnockOkHttpClientAsync.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .bearerToken("My Bearer Token")
          .build()
      val messageServiceAsync = client.messages()

      val messageFuture = messageServiceAsync.markAsSeen(MessageMarkAsSeenParams.builder()
          .messageId("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
          .build())

      val message = messageFuture.get()
      message.validate()
    }

    @Disabled("skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url")
    @Test
    fun markAsUnread() {
      val client = KnockOkHttpClientAsync.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .bearerToken("My Bearer Token")
          .build()
      val messageServiceAsync = client.messages()

      val messageFuture = messageServiceAsync.markAsUnread(MessageMarkAsUnreadParams.builder()
          .messageId("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
          .build())

      val message = messageFuture.get()
      message.validate()
    }

    @Disabled("skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url")
    @Test
    fun markAsUnseen() {
      val client = KnockOkHttpClientAsync.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .bearerToken("My Bearer Token")
          .build()
      val messageServiceAsync = client.messages()

      val messageFuture = messageServiceAsync.markAsUnseen(MessageMarkAsUnseenParams.builder()
          .messageId("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
          .build())

      val message = messageFuture.get()
      message.validate()
    }

    @Disabled("skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url")
    @Test
    fun unarchive() {
      val client = KnockOkHttpClientAsync.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .bearerToken("My Bearer Token")
          .build()
      val messageServiceAsync = client.messages()

      val messageFuture = messageServiceAsync.unarchive(MessageUnarchiveParams.builder()
          .messageId("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
          .build())

      val message = messageFuture.get()
      message.validate()
    }
}
