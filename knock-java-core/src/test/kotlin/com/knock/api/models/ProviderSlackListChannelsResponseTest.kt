// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ProviderSlackListChannelsResponseTest {

    @Test
    fun createProviderSlackListChannelsResponse() {
        val providerSlackListChannelsResponse =
            ProviderSlackListChannelsResponse.builder()
                .id("id")
                .contextTeamId("context_team_id")
                .isIm(true)
                .isPrivate(true)
                .name("name")
                .build()
        assertThat(providerSlackListChannelsResponse).isNotNull
        assertThat(providerSlackListChannelsResponse.id()).isEqualTo("id")
        assertThat(providerSlackListChannelsResponse.contextTeamId()).isEqualTo("context_team_id")
        assertThat(providerSlackListChannelsResponse.isIm()).isEqualTo(true)
        assertThat(providerSlackListChannelsResponse.isPrivate()).isEqualTo(true)
        assertThat(providerSlackListChannelsResponse.name()).isEqualTo("name")
    }
}
