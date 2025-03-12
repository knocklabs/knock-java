// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.providers.msteams

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MsTeamCheckAuthResponseTest {

    @Test
    fun createMsTeamCheckAuthResponse() {
      val msTeamCheckAuthResponse = MsTeamCheckAuthResponse.builder()
          .connection(MsTeamCheckAuthResponse.Connection.builder()
              .ok(true)
              .reason("reason")
              .build())
          .build()
      assertThat(msTeamCheckAuthResponse).isNotNull
      assertThat(msTeamCheckAuthResponse.connection()).isEqualTo(MsTeamCheckAuthResponse.Connection.builder()
          .ok(true)
          .reason("reason")
          .build())
    }
}
