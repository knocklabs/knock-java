// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.providers.slack

import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SlackCheckAuthResponseTest {

    @Test
    fun create() {
        val slackCheckAuthResponse =
            SlackCheckAuthResponse.builder()
                .connection(
                    SlackCheckAuthResponse.Connection.builder().ok(true).reason("reason").build()
                )
                .build()

        assertThat(slackCheckAuthResponse.connection())
            .isEqualTo(
                SlackCheckAuthResponse.Connection.builder().ok(true).reason("reason").build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val slackCheckAuthResponse =
            SlackCheckAuthResponse.builder()
                .connection(
                    SlackCheckAuthResponse.Connection.builder().ok(true).reason("reason").build()
                )
                .build()

        val roundtrippedSlackCheckAuthResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(slackCheckAuthResponse),
                jacksonTypeRef<SlackCheckAuthResponse>(),
            )

        assertThat(roundtrippedSlackCheckAuthResponse).isEqualTo(slackCheckAuthResponse)
    }
}
