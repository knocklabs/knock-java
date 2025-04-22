// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.recipients.channeldata

import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MsTeamsChannelDataTest {

    @Test
    fun create() {
        val msTeamsChannelData =
            MsTeamsChannelData.builder()
                ._typename(MsTeamsChannelData._Typename.MS_TEAMS_CHANNEL_DATA)
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

        assertThat(msTeamsChannelData._typename())
            .isEqualTo(MsTeamsChannelData._Typename.MS_TEAMS_CHANNEL_DATA)
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

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val msTeamsChannelData =
            MsTeamsChannelData.builder()
                ._typename(MsTeamsChannelData._Typename.MS_TEAMS_CHANNEL_DATA)
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

        val roundtrippedMsTeamsChannelData =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(msTeamsChannelData),
                jacksonTypeRef<MsTeamsChannelData>(),
            )

        assertThat(roundtrippedMsTeamsChannelData).isEqualTo(msTeamsChannelData)
    }
}
