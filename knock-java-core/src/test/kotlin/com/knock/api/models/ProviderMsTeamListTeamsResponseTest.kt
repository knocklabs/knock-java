// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ProviderMsTeamListTeamsResponseTest {

    @Test
    fun createProviderMsTeamListTeamsResponse() {
        val providerMsTeamListTeamsResponse =
            ProviderMsTeamListTeamsResponse.builder()
                .addMsTeamsTeam(
                    ProviderMsTeamListTeamsResponse.MsTeamsTeam.builder()
                        .id("team-id-1")
                        .displayName("Engineering Team")
                        .description("description")
                        .build()
                )
                .skipToken("token-for-next-page")
                .build()
        assertThat(providerMsTeamListTeamsResponse).isNotNull
        assertThat(providerMsTeamListTeamsResponse.msTeamsTeams())
            .containsExactly(
                ProviderMsTeamListTeamsResponse.MsTeamsTeam.builder()
                    .id("team-id-1")
                    .displayName("Engineering Team")
                    .description("description")
                    .build()
            )
        assertThat(providerMsTeamListTeamsResponse.skipToken()).contains("token-for-next-page")
    }
}
