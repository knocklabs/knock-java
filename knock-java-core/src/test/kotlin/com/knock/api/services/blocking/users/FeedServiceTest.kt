// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.blocking.users

import com.knock.api.TestServerExtension
import com.knock.api.client.okhttp.KnockOkHttpClient
import com.knock.api.models.users.feeds.FeedGetSettingsParams
import com.knock.api.models.users.feeds.FeedListItemsParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class FeedServiceTest {

    @Disabled("skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url")
    @Test
    fun getSettings() {
      val client = KnockOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .bearerToken("My Bearer Token")
          .build()
      val feedService = client.users().feeds()

      val response = feedService.getSettings(FeedGetSettingsParams.builder()
          .userId("user_id")
          .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build())

      response.validate()
    }

    @Disabled("skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url")
    @Test
    fun listItems() {
      val client = KnockOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .bearerToken("My Bearer Token")
          .build()
      val feedService = client.users().feeds()

      val page = feedService.listItems(FeedListItemsParams.builder()
          .userId("user_id")
          .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build())

      page.response().validate()
    }
}
