// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.recipients.channeldata

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PushChannelDataTest {

    @Test
    fun createPushChannelData() {
        val pushChannelData = PushChannelData.builder().addToken("push_token_1").build()
        assertThat(pushChannelData).isNotNull
        assertThat(pushChannelData.tokens()).containsExactly("push_token_1")
    }
}
