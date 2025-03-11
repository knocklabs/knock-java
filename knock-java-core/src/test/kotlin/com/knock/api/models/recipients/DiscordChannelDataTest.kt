// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models.recipients

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DiscordChannelDataTest {

    @Test
    fun createDiscordChannelData() {
      val discordChannelData = DiscordChannelData.builder()
          .addConnection(DiscordChannelData.Connection.DiscordChannelConnection.builder()
              .channelId("123456789012345678")
              .build())
          .build()
      assertThat(discordChannelData).isNotNull
      assertThat(discordChannelData.connections()).containsExactly(DiscordChannelData.Connection.ofDiscordChannel(DiscordChannelData.Connection.DiscordChannelConnection.builder()
          .channelId("123456789012345678")
          .build()))
    }
}
