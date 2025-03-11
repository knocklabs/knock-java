// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models.providers.slack

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SlackListChannelsResponseTest {

    @Test
    fun createSlackListChannelsResponse() {
      val slackListChannelsResponse = SlackListChannelsResponse.builder()
          .id("id")
          .contextTeamId("context_team_id")
          .isIm(true)
          .isPrivate(true)
          .name("name")
          .build()
      assertThat(slackListChannelsResponse).isNotNull
      assertThat(slackListChannelsResponse.id()).isEqualTo("id")
      assertThat(slackListChannelsResponse.contextTeamId()).isEqualTo("context_team_id")
      assertThat(slackListChannelsResponse.isIm()).isEqualTo(true)
      assertThat(slackListChannelsResponse.isPrivate()).isEqualTo(true)
      assertThat(slackListChannelsResponse.name()).isEqualTo("name")
    }
}
