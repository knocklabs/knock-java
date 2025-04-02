// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.providers.msteams

import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MsTeamListTeamsResponseTest {

    @Test
    fun create() {
        val msTeamListTeamsResponse =
            MsTeamListTeamsResponse.builder()
                .addMsTeamsTeam(
                    MsTeamListTeamsResponse.MsTeamsTeam.builder()
                        .id("team-id-1")
                        .displayName("Engineering Team")
                        .description("description")
                        .build()
                )
                .skipToken("token-for-next-page")
                .build()

        assertThat(msTeamListTeamsResponse.msTeamsTeams())
            .containsExactly(
                MsTeamListTeamsResponse.MsTeamsTeam.builder()
                    .id("team-id-1")
                    .displayName("Engineering Team")
                    .description("description")
                    .build()
            )
        assertThat(msTeamListTeamsResponse.skipToken()).contains("token-for-next-page")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val msTeamListTeamsResponse =
            MsTeamListTeamsResponse.builder()
                .addMsTeamsTeam(
                    MsTeamListTeamsResponse.MsTeamsTeam.builder()
                        .id("team-id-1")
                        .displayName("Engineering Team")
                        .description("description")
                        .build()
                )
                .skipToken("token-for-next-page")
                .build()

        val roundtrippedMsTeamListTeamsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(msTeamListTeamsResponse),
                jacksonTypeRef<MsTeamListTeamsResponse>(),
            )

        assertThat(roundtrippedMsTeamListTeamsResponse).isEqualTo(msTeamListTeamsResponse)
    }
}
