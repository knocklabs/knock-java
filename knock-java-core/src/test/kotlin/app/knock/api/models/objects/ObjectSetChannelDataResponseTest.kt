// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.core.jsonMapper
import app.knock.api.models.recipients.channeldata.PushChannelData
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ObjectSetChannelDataResponseTest {

    @Test
    fun create() {
        val objectSetChannelDataResponse =
            ObjectSetChannelDataResponse.builder()
                .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .data(
                    PushChannelData.builder()
                        ._typename(PushChannelData._Typename.PUSH_CHANNEL_DATA)
                        .addToken("push_token_1")
                        .build()
                )
                .provider("push_fcm")
                .build()

        assertThat(objectSetChannelDataResponse.channelId())
            .isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(objectSetChannelDataResponse.data())
            .isEqualTo(
                ObjectSetChannelDataResponse.Data.ofPushChannel(
                    PushChannelData.builder()
                        ._typename(PushChannelData._Typename.PUSH_CHANNEL_DATA)
                        .addToken("push_token_1")
                        .build()
                )
            )
        assertThat(objectSetChannelDataResponse.provider()).isEqualTo("push_fcm")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val objectSetChannelDataResponse =
            ObjectSetChannelDataResponse.builder()
                .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .data(
                    PushChannelData.builder()
                        ._typename(PushChannelData._Typename.PUSH_CHANNEL_DATA)
                        .addToken("push_token_1")
                        .build()
                )
                .provider("push_fcm")
                .build()

        val roundtrippedObjectSetChannelDataResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(objectSetChannelDataResponse),
                jacksonTypeRef<ObjectSetChannelDataResponse>(),
            )

        assertThat(roundtrippedObjectSetChannelDataResponse).isEqualTo(objectSetChannelDataResponse)
    }
}
