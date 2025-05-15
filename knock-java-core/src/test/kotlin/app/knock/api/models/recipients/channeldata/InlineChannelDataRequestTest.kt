// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.recipients.channeldata

import app.knock.api.core.JsonValue
import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InlineChannelDataRequestTest {

    @Test
    fun create() {
        val inlineChannelDataRequest =
            InlineChannelDataRequest.builder()
                .putAdditionalProperty(
                    "97c5837d-c65c-4d54-aa39-080eeb81c69d",
                    JsonValue.from(mapOf("tokens" to listOf("push_token_xxx"))),
                )
                .build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inlineChannelDataRequest =
            InlineChannelDataRequest.builder()
                .putAdditionalProperty(
                    "97c5837d-c65c-4d54-aa39-080eeb81c69d",
                    JsonValue.from(mapOf("tokens" to listOf("push_token_xxx"))),
                )
                .build()

        val roundtrippedInlineChannelDataRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inlineChannelDataRequest),
                jacksonTypeRef<InlineChannelDataRequest>(),
            )

        assertThat(roundtrippedInlineChannelDataRequest).isEqualTo(inlineChannelDataRequest)
    }
}
