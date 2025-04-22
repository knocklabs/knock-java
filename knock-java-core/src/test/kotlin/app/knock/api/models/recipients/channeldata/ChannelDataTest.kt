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
                .pushChannelData(listOf("push_token_1"))
                .build()

        assertThat(channelData._typename()).isEqualTo("ChannelData")
        assertThat(channelData.channelId()).isEqualTo("123e4567-e89b-12d3-a456-426614174000")
        assertThat(channelData.data())
            .isEqualTo(
                ChannelData.Data.ofPushChannel(
                    PushChannelData.builder()
                        ._typename(PushChannelData._Typename.PUSH_CHANNEL_DATA)
                        .addToken("push_token_1")
                        .build()
                )
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val channelData =
            ChannelData.builder()
                ._typename("ChannelData")
                .channelId("123e4567-e89b-12d3-a456-426614174000")
                .pushChannelData(listOf("push_token_1"))
                .build()

        val roundtrippedChannelData =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(channelData),
                jacksonTypeRef<ChannelData>(),
            )

        assertThat(roundtrippedChannelData).isEqualTo(channelData)
    }
}
