// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.core.jsonMapper
import app.knock.api.models.UnnamedSchemaWithArrayParent0
import app.knock.api.models.recipients.channeldata.PushChannelData
import app.knock.api.models.recipients.preferences.InlinePreferenceSetRequest
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InlineObjectRequestTest {

    @Test
    fun create() {
        val inlineObjectRequest =
            InlineObjectRequest.builder()
                .id("project_1")
                .collection("projects")
                .addChannelData(
                    UnnamedSchemaWithArrayParent0.builder()
                        .channelId("97c5837d-c65c-4d54-aa39-080eeb81c69d")
                        .data(
                            PushChannelData.builder()
                                .addToken("push_token_xxx")
                                .type(PushChannelData.Type.PUSH_FCM)
                                ._typename(PushChannelData._Typename.PUSH_CHANNEL_DATA)
                                .build()
                        )
                        .provider("push_fcm")
                        .build()
                )
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .preferences(InlinePreferenceSetRequest.builder().build())
                .build()

        assertThat(inlineObjectRequest.id()).isEqualTo("project_1")
        assertThat(inlineObjectRequest.collection()).isEqualTo("projects")
        assertThat(inlineObjectRequest.channelData().getOrNull())
            .containsExactly(
                UnnamedSchemaWithArrayParent0.builder()
                    .channelId("97c5837d-c65c-4d54-aa39-080eeb81c69d")
                    .data(
                        PushChannelData.builder()
                            .addToken("push_token_xxx")
                            .type(PushChannelData.Type.PUSH_FCM)
                            ._typename(PushChannelData._Typename.PUSH_CHANNEL_DATA)
                            .build()
                    )
                    .provider("push_fcm")
                    .build()
            )
        assertThat(inlineObjectRequest.createdAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(inlineObjectRequest.preferences())
            .isEqualTo(InlinePreferenceSetRequest.builder().build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inlineObjectRequest =
            InlineObjectRequest.builder()
                .id("project_1")
                .collection("projects")
                .addChannelData(
                    UnnamedSchemaWithArrayParent0.builder()
                        .channelId("97c5837d-c65c-4d54-aa39-080eeb81c69d")
                        .data(
                            PushChannelData.builder()
                                .addToken("push_token_xxx")
                                .type(PushChannelData.Type.PUSH_FCM)
                                ._typename(PushChannelData._Typename.PUSH_CHANNEL_DATA)
                                .build()
                        )
                        .provider("push_fcm")
                        .build()
                )
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .preferences(InlinePreferenceSetRequest.builder().build())
                .build()

        val roundtrippedInlineObjectRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inlineObjectRequest),
                jacksonTypeRef<InlineObjectRequest>(),
            )

        assertThat(roundtrippedInlineObjectRequest).isEqualTo(inlineObjectRequest)
    }
}
