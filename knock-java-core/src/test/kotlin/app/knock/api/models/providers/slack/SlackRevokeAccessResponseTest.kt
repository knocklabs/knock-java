// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.providers.slack

import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SlackRevokeAccessResponseTest {

    @Test
    fun create() {
        val slackRevokeAccessResponse = SlackRevokeAccessResponse.builder().ok("ok").build()

        assertThat(slackRevokeAccessResponse.ok()).contains("ok")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val slackRevokeAccessResponse = SlackRevokeAccessResponse.builder().ok("ok").build()

        val roundtrippedSlackRevokeAccessResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(slackRevokeAccessResponse),
                jacksonTypeRef<SlackRevokeAccessResponse>(),
            )

        assertThat(roundtrippedSlackRevokeAccessResponse).isEqualTo(slackRevokeAccessResponse)
    }
}
