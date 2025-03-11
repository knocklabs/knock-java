// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models.recipients

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MsTeamsChannelDataTest {

    @Test
    fun createMsTeamsChannelData() {
        val msTeamsChannelData =
            MsTeamsChannelData.builder()
                .addConnection(
                    MsTeamsChannelData.Connection.MsTeamsTokenConnection.builder()
                        .msTeamsChannelId("123e4567-e89b-12d3-a456-426614174000")
                        .msTeamsTeamId("123e4567-e89b-12d3-a456-426614174000")
                        .msTeamsTenantId(null)
                        .msTeamsUserId(null)
                        .build()
                )
                .msTeamsTenantId(null)
                .build()
        assertThat(msTeamsChannelData).isNotNull
        assertThat(msTeamsChannelData.connections())
            .containsExactly(
                MsTeamsChannelData.Connection.ofMsTeamsToken(
                    MsTeamsChannelData.Connection.MsTeamsTokenConnection.builder()
                        .msTeamsChannelId("123e4567-e89b-12d3-a456-426614174000")
                        .msTeamsTeamId("123e4567-e89b-12d3-a456-426614174000")
                        .msTeamsTenantId(null)
                        .msTeamsUserId(null)
                        .build()
                )
            )
        assertThat(msTeamsChannelData.msTeamsTenantId()).isEmpty
    }
}
