// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ProviderSlackListChannelsResponseTest {

    @Test
    fun createProviderSlackListChannelsResponse() {
        val providerSlackListChannelsResponse =
            ProviderSlackListChannelsResponse.builder()
                .nextCursor(null)
                .addSlackChannel(
                    ProviderSlackListChannelsResponse.SlackChannel.builder()
                        .id("C01234567890")
                        .contextTeamId("T01234567890")
                        .isIm(false)
                        .isPrivate(false)
                        .name("general")
                        .build()
                )
                .build()
        assertThat(providerSlackListChannelsResponse).isNotNull
        assertThat(providerSlackListChannelsResponse.nextCursor()).isEmpty
        assertThat(providerSlackListChannelsResponse.slackChannels())
            .containsExactly(
                ProviderSlackListChannelsResponse.SlackChannel.builder()
                    .id("C01234567890")
                    .contextTeamId("T01234567890")
                    .isIm(false)
                    .isPrivate(false)
                    .name("general")
                    .build()
            )
    }
}
