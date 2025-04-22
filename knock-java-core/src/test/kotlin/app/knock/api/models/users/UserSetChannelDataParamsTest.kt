// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.models.recipients.channeldata.ChannelDataRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserSetChannelDataParamsTest {

    @Test
    fun create() {
        UserSetChannelDataParams.builder()
            .userId("user_id")
            .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .channelDataRequest(
                ChannelDataRequest.builder().pushChannelData(listOf("push_token_1")).build()
            )
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            UserSetChannelDataParams.builder()
                .userId("user_id")
                .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .channelDataRequest(
                    ChannelDataRequest.builder().pushChannelData(listOf("push_token_1")).build()
                )
                .build()

        assertThat(params._pathParam(0)).isEqualTo("user_id")
        assertThat(params._pathParam(1)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            UserSetChannelDataParams.builder()
                .userId("user_id")
                .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .channelDataRequest(
                    ChannelDataRequest.builder().pushChannelData(listOf("push_token_1")).build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(ChannelDataRequest.builder().pushChannelData(listOf("push_token_1")).build())
    }
}
