// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ProviderMsTeamListChannelsResponseTest {

    @Test
    fun createProviderMsTeamListChannelsResponse() {
        val providerMsTeamListChannelsResponse =
            ProviderMsTeamListChannelsResponse.builder()
                .addMsTeamsChannel(
                    ProviderMsTeamListChannelsResponse.MsTeamsChannel.builder()
                        .id("channel-id-1")
                        .displayName("General")
                        .createdDateTime("createdDateTime")
                        .description("description")
                        .isArchived(true)
                        .membershipType("membershipType")
                        .build()
                )
                .build()
        assertThat(providerMsTeamListChannelsResponse).isNotNull
        assertThat(providerMsTeamListChannelsResponse.msTeamsChannels())
            .containsExactly(
                ProviderMsTeamListChannelsResponse.MsTeamsChannel.builder()
                    .id("channel-id-1")
                    .displayName("General")
                    .createdDateTime("createdDateTime")
                    .description("description")
                    .isArchived(true)
                    .membershipType("membershipType")
                    .build()
            )
    }
}
