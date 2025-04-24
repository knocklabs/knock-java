// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.core.JsonValue
import app.knock.api.core.jsonMapper
import app.knock.api.models.UnnamedSchemaWithArrayParent0
import app.knock.api.models.recipients.channeldata.PushChannelData
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InlineIdentifyUserRequestTest {

    @Test
    fun create() {
        val inlineIdentifyUserRequest =
            InlineIdentifyUserRequest.builder()
                .id("user_1")
                .addChannelData(
                    UnnamedSchemaWithArrayParent0.builder()
                        .channelId("97c5837d-c65c-4d54-aa39-080eeb81c69d")
                        .data(
                            PushChannelData.builder()
                                .addToken("push_token_123")
                                .type(PushChannelData.Type.PUSH_FCM)
                                ._typename(PushChannelData._Typename.PUSH_CHANNEL_DATA)
                                .build()
                        )
                        .provider("push_fcm")
                        .build()
                )
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .preferences(
                    JsonValue.from(
                        listOf(
                            mapOf(
                                "channel_types" to mapOf("email" to true),
                                "id" to "default",
                                "workflows" to
                                    mapOf(
                                        "dinosaurs-loose" to
                                            mapOf("channel_types" to mapOf("email" to true))
                                    ),
                            )
                        )
                    )
                )
                .build()

        assertThat(inlineIdentifyUserRequest.id()).isEqualTo("user_1")
        assertThat(inlineIdentifyUserRequest.channelData().getOrNull())
            .containsExactly(
                UnnamedSchemaWithArrayParent0.builder()
                    .channelId("97c5837d-c65c-4d54-aa39-080eeb81c69d")
                    .data(
                        PushChannelData.builder()
                            .addToken("push_token_123")
                            .type(PushChannelData.Type.PUSH_FCM)
                            ._typename(PushChannelData._Typename.PUSH_CHANNEL_DATA)
                            .build()
                    )
                    .provider("push_fcm")
                    .build()
            )
        assertThat(inlineIdentifyUserRequest.createdAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(inlineIdentifyUserRequest.preferences())
            .isEqualTo(
                JsonValue.from(
                    listOf(
                        mapOf(
                            "channel_types" to mapOf("email" to true),
                            "id" to "default",
                            "workflows" to
                                mapOf(
                                    "dinosaurs-loose" to
                                        mapOf("channel_types" to mapOf("email" to true))
                                ),
                        )
                    )
                )
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inlineIdentifyUserRequest =
            InlineIdentifyUserRequest.builder()
                .id("user_1")
                .addChannelData(
                    UnnamedSchemaWithArrayParent0.builder()
                        .channelId("97c5837d-c65c-4d54-aa39-080eeb81c69d")
                        .data(
                            PushChannelData.builder()
                                .addToken("push_token_123")
                                .type(PushChannelData.Type.PUSH_FCM)
                                ._typename(PushChannelData._Typename.PUSH_CHANNEL_DATA)
                                .build()
                        )
                        .provider("push_fcm")
                        .build()
                )
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .preferences(
                    JsonValue.from(
                        listOf(
                            mapOf(
                                "channel_types" to mapOf("email" to true),
                                "id" to "default",
                                "workflows" to
                                    mapOf(
                                        "dinosaurs-loose" to
                                            mapOf("channel_types" to mapOf("email" to true))
                                    ),
                            )
                        )
                    )
                )
                .build()

        val roundtrippedInlineIdentifyUserRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inlineIdentifyUserRequest),
                jacksonTypeRef<InlineIdentifyUserRequest>(),
            )

        assertThat(roundtrippedInlineIdentifyUserRequest).isEqualTo(inlineIdentifyUserRequest)
    }
}
