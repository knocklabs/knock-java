// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.blocking.providers

import com.knock.api.TestServerExtension
import com.knock.api.client.okhttp.KnockOkHttpClient
import com.knock.api.models.ProviderSlackCheckAuthParams
import com.knock.api.models.ProviderSlackListChannelsParams
import com.knock.api.models.ProviderSlackRevokeAccessParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class SlackServiceTest {

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun checkAuth() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val slackService = client.providers().slack()

        val response =
            slackService.checkAuth(
                ProviderSlackCheckAuthParams.builder()
                    .channelId("channel_id")
                    .accessTokenObject("access_token_object")
                    .build()
            )

        response.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun listChannels() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val slackService = client.providers().slack()

        val response =
            slackService.listChannels(
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

        response.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun revokeAccess() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val slackService = client.providers().slack()

        slackService.revokeAccess(
            ProviderSlackRevokeAccessParams.builder()
                .channelId("channel_id")
                .accessTokenObject("access_token_object")
                .build()
        )
    }
}
