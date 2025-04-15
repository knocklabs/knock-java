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
                .addConnection(
                    MsTeamsChannelData.Connection.TokenConnection.builder()
                        .accessToken("xoxb-1234567890")
                        .channelId("C01234567890")
                        .userId("U01234567890")
                        .build()
                )
                .msTeamsTenantId(null)
                .build()

        assertThat(msTeamsChannelData.connections())
            .containsExactly(
                MsTeamsChannelData.Connection.ofToken(
                    MsTeamsChannelData.Connection.TokenConnection.builder()
                        .accessToken("xoxb-1234567890")
                        .channelId("C01234567890")
                        .userId("U01234567890")
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
                .addConnection(
                    MsTeamsChannelData.Connection.TokenConnection.builder()
                        .accessToken("xoxb-1234567890")
                        .channelId("C01234567890")
                        .userId("U01234567890")
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
