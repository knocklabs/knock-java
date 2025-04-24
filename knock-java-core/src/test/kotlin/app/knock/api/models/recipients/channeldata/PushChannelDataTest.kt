// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.recipients.channeldata

import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PushChannelDataTest {

    @Test
    fun create() {
        val pushChannelData =
            PushChannelData.builder()
                .addToken("push_token_1")
                .type(PushChannelData.Type.PUSH_FCM)
                ._typename(PushChannelData._Typename.PUSH_CHANNEL_DATA)
                .build()

        assertThat(pushChannelData.tokens()).containsExactly("push_token_1")
        assertThat(pushChannelData.type()).isEqualTo(PushChannelData.Type.PUSH_FCM)
        assertThat(pushChannelData._typename())
            .contains(PushChannelData._Typename.PUSH_CHANNEL_DATA)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val pushChannelData =
            PushChannelData.builder()
                .addToken("push_token_1")
                .type(PushChannelData.Type.PUSH_FCM)
                ._typename(PushChannelData._Typename.PUSH_CHANNEL_DATA)
                .build()

        val roundtrippedPushChannelData =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(pushChannelData),
                jacksonTypeRef<PushChannelData>(),
            )

        assertThat(roundtrippedPushChannelData).isEqualTo(pushChannelData)
    }
}
