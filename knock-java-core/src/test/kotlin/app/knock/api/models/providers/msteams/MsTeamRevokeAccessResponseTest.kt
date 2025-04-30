// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.providers.msteams

import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MsTeamRevokeAccessResponseTest {

    @Test
    fun create() {
        val msTeamRevokeAccessResponse = MsTeamRevokeAccessResponse.builder().ok("ok").build()

        assertThat(msTeamRevokeAccessResponse.ok()).contains("ok")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val msTeamRevokeAccessResponse = MsTeamRevokeAccessResponse.builder().ok("ok").build()

        val roundtrippedMsTeamRevokeAccessResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(msTeamRevokeAccessResponse),
                jacksonTypeRef<MsTeamRevokeAccessResponse>(),
            )

        assertThat(roundtrippedMsTeamRevokeAccessResponse).isEqualTo(msTeamRevokeAccessResponse)
    }
}
