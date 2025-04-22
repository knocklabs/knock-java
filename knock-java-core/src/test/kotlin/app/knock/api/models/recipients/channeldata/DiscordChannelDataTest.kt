// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.recipients.channeldata

import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DiscordChannelDataTest {

    @Test
    fun create() {
        val discordChannelData =
            DiscordChannelData.builder()
                ._typename(DiscordChannelData._Typename.DISCORD_CHANNEL_DATA)
                .addConnection(
                    DiscordChannelData.Connection.DiscordChannelConnection.builder()
                        .channelId("123456789012345678")
                        .build()
                )
                .build()

        assertThat(discordChannelData._typename())
            .isEqualTo(DiscordChannelData._Typename.DISCORD_CHANNEL_DATA)
        assertThat(discordChannelData.connections())
            .containsExactly(
                DiscordChannelData.Connection.ofDiscordChannel(
                    DiscordChannelData.Connection.DiscordChannelConnection.builder()
                        .channelId("123456789012345678")
                        .build()
                )
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val discordChannelData =
            DiscordChannelData.builder()
                ._typename(DiscordChannelData._Typename.DISCORD_CHANNEL_DATA)
                .addConnection(
                    DiscordChannelData.Connection.DiscordChannelConnection.builder()
                        .channelId("123456789012345678")
                        .build()
                )
                .build()

        val roundtrippedDiscordChannelData =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(discordChannelData),
                jacksonTypeRef<DiscordChannelData>(),
            )

        assertThat(roundtrippedDiscordChannelData).isEqualTo(discordChannelData)
    }
}
