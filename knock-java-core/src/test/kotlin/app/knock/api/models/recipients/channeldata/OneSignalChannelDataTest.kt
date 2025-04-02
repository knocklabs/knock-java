// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.recipients.channeldata

import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OneSignalChannelDataTest {

    @Test
    fun create() {
        val oneSignalChannelData =
            OneSignalChannelData.builder()
                .addPlayerId("123e4567-e89b-12d3-a456-426614174000")
                .build()

        assertThat(oneSignalChannelData.playerIds())
            .containsExactly("123e4567-e89b-12d3-a456-426614174000")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val oneSignalChannelData =
            OneSignalChannelData.builder()
                .addPlayerId("123e4567-e89b-12d3-a456-426614174000")
                .build()

        val roundtrippedOneSignalChannelData =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(oneSignalChannelData),
                jacksonTypeRef<OneSignalChannelData>(),
            )

        assertThat(roundtrippedOneSignalChannelData).isEqualTo(oneSignalChannelData)
    }
}
