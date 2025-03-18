// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.providers.slack

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SlackCheckAuthResponseTest {

    @Test
    fun createSlackCheckAuthResponse() {
        val slackCheckAuthResponse =
            SlackCheckAuthResponse.builder()
                .connection(
                    SlackCheckAuthResponse.Connection.builder().ok(true).reason("reason").build()
                )
                .build()
        assertThat(slackCheckAuthResponse).isNotNull
        assertThat(slackCheckAuthResponse.connection())
            .isEqualTo(
                SlackCheckAuthResponse.Connection.builder().ok(true).reason("reason").build()
            )
    }
}
