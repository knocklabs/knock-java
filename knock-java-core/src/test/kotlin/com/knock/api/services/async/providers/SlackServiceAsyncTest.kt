// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.async.providers

import com.knock.api.TestServerExtension
import com.knock.api.client.okhttp.KnockOkHttpClientAsync
import com.knock.api.models.providers.slack.SlackCheckAuthParams
import com.knock.api.models.providers.slack.SlackListChannelsParams
import com.knock.api.models.providers.slack.SlackRevokeAccessParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class SlackServiceAsyncTest {

    @Disabled("skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url")
    @Test
    fun checkAuth() {
      val client = KnockOkHttpClientAsync.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .bearerToken("My Bearer Token")
          .build()
      val slackServiceAsync = client.providers().slack()

      val responseFuture = slackServiceAsync.checkAuth(SlackCheckAuthParams.builder()
          .channelId("channel_id")
          .accessTokenObject("access_token_object")
          .build())

      val response = responseFuture.get()
      response.validate()
    }

    @Disabled("skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url")
    @Test
    fun listChannels() {
      val client = KnockOkHttpClientAsync.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .bearerToken("My Bearer Token")
          .build()
      val slackServiceAsync = client.providers().slack()

      val pageFuture = slackServiceAsync.listChannels(SlackListChannelsParams.builder()
          .channelId("channel_id")
          .accessTokenObject("access_token_object")
          .build())

      val page = pageFuture.get()
      page.response().validate()
    }

    @Disabled("skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url")
    @Test
    fun revokeAccess() {
      val client = KnockOkHttpClientAsync.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .bearerToken("My Bearer Token")
          .build()
      val slackServiceAsync = client.providers().slack()

      val responseFuture = slackServiceAsync.revokeAccess(SlackRevokeAccessParams.builder()
          .channelId("channel_id")
          .accessTokenObject("access_token_object")
          .build())

      val response = responseFuture.get()
    }
}
