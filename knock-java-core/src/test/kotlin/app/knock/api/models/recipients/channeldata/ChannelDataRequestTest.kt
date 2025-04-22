// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.recipients.channeldata

import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChannelDataRequestTest {

    @Test
    fun create() {
        val channelDataRequest =
            ChannelDataRequest.builder().pushChannelData(listOf("push_token_1")).build()

        assertThat(channelDataRequest.data())
            .isEqualTo(
                ChannelDataRequest.Data.ofPushChannel(
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
        val channelDataRequest =
            ChannelDataRequest.builder().pushChannelData(listOf("push_token_1")).build()

        val roundtrippedChannelDataRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(channelDataRequest),
                jacksonTypeRef<ChannelDataRequest>(),
            )

        assertThat(roundtrippedChannelDataRequest).isEqualTo(channelDataRequest)
    }
}
