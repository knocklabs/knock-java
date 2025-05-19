// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.providers.msteams

import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MsTeamListTeamsPageResponseTest {

    @Test
    fun create() {
        val msTeamListTeamsPageResponse =
            MsTeamListTeamsPageResponse.builder()
                .addMsTeamsTeam(
                    MsTeamListTeamsResponse.builder()
                        .id("team-id-1")
                        .displayName("Engineering Team")
                        .description("description")
                        .build()
                )
                .skipToken("token-for-next-page")
                .build()

        assertThat(msTeamListTeamsPageResponse.msTeamsTeams())
            .containsExactly(
                MsTeamListTeamsResponse.builder()
                    .id("team-id-1")
                    .displayName("Engineering Team")
                    .description("description")
                    .build()
            )
        assertThat(msTeamListTeamsPageResponse.skipToken()).contains("token-for-next-page")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val msTeamListTeamsPageResponse =
            MsTeamListTeamsPageResponse.builder()
                .addMsTeamsTeam(
                    MsTeamListTeamsResponse.builder()
                        .id("team-id-1")
                        .displayName("Engineering Team")
                        .description("description")
                        .build()
                )
                .skipToken("token-for-next-page")
                .build()

        val roundtrippedMsTeamListTeamsPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(msTeamListTeamsPageResponse),
                jacksonTypeRef<MsTeamListTeamsPageResponse>(),
            )

        assertThat(roundtrippedMsTeamListTeamsPageResponse).isEqualTo(msTeamListTeamsPageResponse)
    }
}
