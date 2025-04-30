// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.providers.msteams

import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MsTeamCheckAuthResponseTest {

    @Test
    fun create() {
        val msTeamCheckAuthResponse =
            MsTeamCheckAuthResponse.builder()
                .connection(
                    MsTeamCheckAuthResponse.Connection.builder().ok(true).reason("reason").build()
                )
                .build()

        assertThat(msTeamCheckAuthResponse.connection())
            .isEqualTo(
                MsTeamCheckAuthResponse.Connection.builder().ok(true).reason("reason").build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val msTeamCheckAuthResponse =
            MsTeamCheckAuthResponse.builder()
                .connection(
                    MsTeamCheckAuthResponse.Connection.builder().ok(true).reason("reason").build()
                )
                .build()

        val roundtrippedMsTeamCheckAuthResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(msTeamCheckAuthResponse),
                jacksonTypeRef<MsTeamCheckAuthResponse>(),
            )

        assertThat(roundtrippedMsTeamCheckAuthResponse).isEqualTo(msTeamCheckAuthResponse)
    }
}
