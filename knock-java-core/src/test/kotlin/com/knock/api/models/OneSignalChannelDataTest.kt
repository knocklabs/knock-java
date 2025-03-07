// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OneSignalChannelDataTest {

    @Test
    fun createOneSignalChannelData() {
        val oneSignalChannelData =
            OneSignalChannelData.builder()
                .addPlayerId("123e4567-e89b-12d3-a456-426614174000")
                .build()
        assertThat(oneSignalChannelData).isNotNull
        assertThat(oneSignalChannelData.playerIds())
            .containsExactly("123e4567-e89b-12d3-a456-426614174000")
    }
}
