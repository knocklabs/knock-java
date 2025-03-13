// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.providers.msteams

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MsTeamListChannelsResponseTest {

    @Test
    fun createMsTeamListChannelsResponse() {
      val msTeamListChannelsResponse = MsTeamListChannelsResponse.builder()
          .addMsTeamsChannel(MsTeamListChannelsResponse.MsTeamsChannel.builder()
              .id("channel-id-1")
              .displayName("General")
              .createdDateTime("createdDateTime")
              .description("description")
              .isArchived(true)
              .membershipType("membershipType")
              .build())
          .build()
      assertThat(msTeamListChannelsResponse).isNotNull
      assertThat(msTeamListChannelsResponse.msTeamsChannels()).containsExactly(MsTeamListChannelsResponse.MsTeamsChannel.builder()
          .id("channel-id-1")
          .displayName("General")
          .createdDateTime("createdDateTime")
          .description("description")
          .isArchived(true)
          .membershipType("membershipType")
          .build())
    }
}
