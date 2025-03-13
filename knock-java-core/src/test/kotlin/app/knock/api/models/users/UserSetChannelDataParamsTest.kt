// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.models.recipients.channeldata.ChannelDataRequest
import app.knock.api.models.recipients.channeldata.PushChannelData
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UserSetChannelDataParamsTest {

    @Test
    fun create() {
        UserSetChannelDataParams.builder()
            .userId("user_id")
            .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .channelDataRequest(
                ChannelDataRequest.builder()
                    .data(PushChannelData.builder().addToken("push_token_1").build())
                    .build()
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            UserSetChannelDataParams.builder()
                .userId("user_id")
                .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .channelDataRequest(
                    ChannelDataRequest.builder()
                        .data(PushChannelData.builder().addToken("push_token_1").build())
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                ChannelDataRequest.builder()
                    .data(PushChannelData.builder().addToken("push_token_1").build())
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            UserSetChannelDataParams.builder()
                .userId("user_id")
                .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .channelDataRequest(
                    ChannelDataRequest.builder()
                        .data(PushChannelData.builder().addToken("push_token_1").build())
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                ChannelDataRequest.builder()
                    .data(PushChannelData.builder().addToken("push_token_1").build())
                    .build()
            )
    }

    @Test
    fun getPathParam() {
        val params =
            UserSetChannelDataParams.builder()
                .userId("user_id")
                .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .channelDataRequest(
                    ChannelDataRequest.builder()
                        .data(PushChannelData.builder().addToken("push_token_1").build())
                        .build()
                )
                .build()
        assertThat(params).isNotNull
        // path param "userId"
        assertThat(params.getPathParam(0)).isEqualTo("user_id")
        // path param "channelId"
        assertThat(params.getPathParam(1)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params.getPathParam(2)).isEqualTo("")
    }
}
