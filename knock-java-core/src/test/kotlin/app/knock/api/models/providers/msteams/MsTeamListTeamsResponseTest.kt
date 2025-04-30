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
                .id("id")
                .displayName("displayName")
                .description("description")
                .build()

        assertThat(msTeamListTeamsResponse.id()).isEqualTo("id")
        assertThat(msTeamListTeamsResponse.displayName()).isEqualTo("displayName")
        assertThat(msTeamListTeamsResponse.description()).contains("description")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val msTeamListTeamsResponse =
            MsTeamListTeamsResponse.builder()
                .id("id")
                .displayName("displayName")
                .description("description")
                .build()

        val roundtrippedMsTeamListTeamsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(msTeamListTeamsResponse),
                jacksonTypeRef<MsTeamListTeamsResponse>(),
            )

        assertThat(roundtrippedMsTeamListTeamsResponse).isEqualTo(msTeamListTeamsResponse)
    }
}
