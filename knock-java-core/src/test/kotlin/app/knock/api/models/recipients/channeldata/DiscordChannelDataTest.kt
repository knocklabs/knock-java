// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.recipients.channeldata

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DiscordChannelDataTest {

    @Test
    fun create() {
        val discordChannelData =
            DiscordChannelData.builder()
                .addConnection(
                    DiscordChannelData.Connection.DiscordChannelConnection.builder()
                        .channelId("123456789012345678")
                        .build()
                )
                .build()

        assertThat(discordChannelData.connections())
            .containsExactly(
                DiscordChannelData.Connection.ofDiscordChannel(
                    DiscordChannelData.Connection.DiscordChannelConnection.builder()
                        .channelId("123456789012345678")
                        .build()
                )
            )
    }
}
