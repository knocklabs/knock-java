// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ChannelDataTest {

    @Test
    fun createChannelData() {
        val channelData =
            ChannelData.builder()
                ._typename("ChannelData")
                .channelId("123e4567-e89b-12d3-a456-426614174000")
                .data(PushChannelData.builder().addToken("push_token_1").build())
                .build()
        assertThat(channelData).isNotNull
        assertThat(channelData._typename()).isEqualTo("ChannelData")
        assertThat(channelData.channelId()).isEqualTo("123e4567-e89b-12d3-a456-426614174000")
        assertThat(channelData.data())
            .isEqualTo(
                ChannelData.Data.ofPushChannel(
                    PushChannelData.builder().addToken("push_token_1").build()
                )
            )
    }
}
