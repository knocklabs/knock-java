// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.providers.msteams

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MsTeamListTeamsResponseTest {

    @Test
    fun createMsTeamListTeamsResponse() {
      val msTeamListTeamsResponse = MsTeamListTeamsResponse.builder()
          .addMsTeamsTeam(MsTeamListTeamsResponse.MsTeamsTeam.builder()
              .id("team-id-1")
              .displayName("Engineering Team")
              .description("description")
              .build())
          .skipToken("token-for-next-page")
          .build()
      assertThat(msTeamListTeamsResponse).isNotNull
      assertThat(msTeamListTeamsResponse.msTeamsTeams()).containsExactly(MsTeamListTeamsResponse.MsTeamsTeam.builder()
          .id("team-id-1")
          .displayName("Engineering Team")
          .description("description")
          .build())
      assertThat(msTeamListTeamsResponse.skipToken()).contains("token-for-next-page")
    }
}
