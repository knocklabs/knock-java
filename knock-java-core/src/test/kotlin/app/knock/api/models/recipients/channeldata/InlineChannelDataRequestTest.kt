// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.recipients.channeldata

import app.knock.api.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InlineChannelDataRequestTest {

    @Test
    fun createInlineChannelDataRequest() {
        val inlineChannelDataRequest =
            InlineChannelDataRequest.builder()
                .putAdditionalProperty(
                    "97c5837d-c65c-4d54-aa39-080eeb81c69d",
                    JsonValue.from(mapOf("data" to mapOf("tokens" to listOf("push_token_xxx")))),
                )
                .build()
        assertThat(inlineChannelDataRequest).isNotNull
    }
}
