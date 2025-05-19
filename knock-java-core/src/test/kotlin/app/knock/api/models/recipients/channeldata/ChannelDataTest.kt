// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.recipients.channeldata

import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChannelDataTest {

    @Test
    fun create() {
        val channelData =
            ChannelData.builder()
                ._typename("ChannelData")
                .channelId("123e4567-e89b-12d3-a456-426614174000")
                .data(PushChannelData.builder().addToken("push_token_1").build())
                .provider(ChannelData.Provider.PUSH_FCM)
                .build()

        assertThat(channelData._typename()).isEqualTo("ChannelData")
        assertThat(channelData.channelId()).isEqualTo("123e4567-e89b-12d3-a456-426614174000")
        assertThat(channelData.data())
            .isEqualTo(
                ChannelData.Data.ofPushChannel(
                    PushChannelData.builder().addToken("push_token_1").build()
                )
            )
        assertThat(channelData.provider()).contains(ChannelData.Provider.PUSH_FCM)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val channelData =
            ChannelData.builder()
                ._typename("ChannelData")
                .channelId("123e4567-e89b-12d3-a456-426614174000")
                .data(PushChannelData.builder().addToken("push_token_1").build())
                .provider(ChannelData.Provider.PUSH_FCM)
                .build()

        val roundtrippedChannelData =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(channelData),
                jacksonTypeRef<ChannelData>(),
            )

        assertThat(roundtrippedChannelData).isEqualTo(channelData)
    }
}
