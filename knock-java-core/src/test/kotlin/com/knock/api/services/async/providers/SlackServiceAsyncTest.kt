// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.async.providers

import com.knock.api.TestServerExtension
import com.knock.api.client.okhttp.KnockOkHttpClientAsync
import com.knock.api.models.ProviderSlackCheckAuthParams
import com.knock.api.models.ProviderSlackListChannelsParams
import com.knock.api.models.ProviderSlackRevokeAccessParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class SlackServiceAsyncTest {

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun checkAuth() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val slackServiceAsync = client.providers().slack()

        val responseFuture =
            slackServiceAsync.checkAuth(
                ProviderSlackCheckAuthParams.builder()
                    .channelId("channel_id")
                    .accessTokenObject("access_token_object")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun listChannels() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val slackServiceAsync = client.providers().slack()

        val responseFuture =
            slackServiceAsync.listChannels(
                ProviderSlackListChannelsParams.builder()
                    .channelId("channel_id")
                    .accessTokenObject("access_token_object")
                    .queryOptions(
                        ProviderSlackListChannelsParams.QueryOptions.builder()
                            .cursor("cursor")
                            .excludeArchived(true)
                            .limit(0L)
                            .teamId("team_id")
                            .types("types")
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
    fun revokeAccess() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val slackServiceAsync = client.providers().slack()

        val responseFuture =
            slackServiceAsync.revokeAccess(
                ProviderSlackRevokeAccessParams.builder()
                    .channelId("channel_id")
                    .accessTokenObject("access_token_object")
                    .build()
            )

        val response = responseFuture.get()
    }
}
