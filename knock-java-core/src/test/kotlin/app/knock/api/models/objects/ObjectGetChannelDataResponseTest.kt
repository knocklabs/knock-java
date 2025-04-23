// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.core.jsonMapper
import app.knock.api.models.recipients.channeldata.PushChannelData
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ObjectGetChannelDataResponseTest {

    @Test
    fun create() {
        val objectGetChannelDataResponse =
            ObjectGetChannelDataResponse.builder()
                .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .data(
                    PushChannelData.builder()
                        ._typename(PushChannelData._Typename.PUSH_CHANNEL_DATA)
                        .addToken("push_token_1")
                        .build()
                )
                .provider("push_fcm")
                .build()

        assertThat(objectGetChannelDataResponse.channelId())
            .isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(objectGetChannelDataResponse.data())
            .isEqualTo(
                ObjectGetChannelDataResponse.Data.ofPushChannel(
                    PushChannelData.builder()
                        ._typename(PushChannelData._Typename.PUSH_CHANNEL_DATA)
                        .addToken("push_token_1")
                        .build()
                )
            )
        assertThat(objectGetChannelDataResponse.provider()).isEqualTo("push_fcm")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val objectGetChannelDataResponse =
            ObjectGetChannelDataResponse.builder()
                .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .data(
                    PushChannelData.builder()
                        ._typename(PushChannelData._Typename.PUSH_CHANNEL_DATA)
                        .addToken("push_token_1")
                        .build()
                )
                .provider("push_fcm")
                .build()

        val roundtrippedObjectGetChannelDataResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(objectGetChannelDataResponse),
                jacksonTypeRef<ObjectGetChannelDataResponse>(),
            )

        assertThat(roundtrippedObjectGetChannelDataResponse).isEqualTo(objectGetChannelDataResponse)
    }
}
