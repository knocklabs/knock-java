// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.async.users

import com.knock.api.TestServerExtension
import com.knock.api.client.okhttp.KnockOkHttpClientAsync
import com.knock.api.models.users.feeds.FeedGetSettingsParams
import com.knock.api.models.users.feeds.FeedListItemsParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class FeedServiceAsyncTest {

    @Disabled("skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url")
    @Test
    fun getSettings() {
      val client = KnockOkHttpClientAsync.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .bearerToken("My Bearer Token")
          .build()
      val feedServiceAsync = client.users().feeds()

      val responseFuture = feedServiceAsync.getSettings(FeedGetSettingsParams.builder()
          .userId("user_id")
          .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build())

      val response = responseFuture.get()
      response.validate()
    }

    @Disabled("skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url")
    @Test
    fun listItems() {
      val client = KnockOkHttpClientAsync.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .bearerToken("My Bearer Token")
          .build()
      val feedServiceAsync = client.users().feeds()

      val pageFuture = feedServiceAsync.listItems(FeedListItemsParams.builder()
          .userId("user_id")
          .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build())

      val page = pageFuture.get()
      page.response().validate()
    }
}
