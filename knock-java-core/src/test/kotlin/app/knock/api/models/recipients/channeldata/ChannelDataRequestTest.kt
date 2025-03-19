// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.recipients.channeldata

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChannelDataRequestTest {

    @Test
    fun create() {
        val channelDataRequest =
            ChannelDataRequest.builder()
                .data(PushChannelData.builder().addToken("push_token_1").build())
                .build()

        assertThat(channelDataRequest.data())
            .isEqualTo(
                ChannelDataRequest.Data.ofPushChannel(
                    PushChannelData.builder().addToken("push_token_1").build()
                )
            )
    }
}
