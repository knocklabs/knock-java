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

internal class IdentifyUserRequestTest {

    @Test
    fun create() {
        val identifyUserRequest =
            IdentifyUserRequest.builder()
                .avatar("avatar")
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
                .email("ian.malcolm@chaos.theory")
                .locale("locale")
                .name("Dr. Ian Malcolm")
                .phoneNumber("phone_number")
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
                .timezone("America/New_York")
                .build()

        assertThat(identifyUserRequest.avatar()).contains("avatar")
        assertThat(identifyUserRequest.channelData().getOrNull())
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
        assertThat(identifyUserRequest.createdAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(identifyUserRequest.email()).contains("ian.malcolm@chaos.theory")
        assertThat(identifyUserRequest.locale()).contains("locale")
        assertThat(identifyUserRequest.name()).contains("Dr. Ian Malcolm")
        assertThat(identifyUserRequest.phoneNumber()).contains("phone_number")
        assertThat(identifyUserRequest.preferences())
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
        assertThat(identifyUserRequest.timezone()).contains("America/New_York")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val identifyUserRequest =
            IdentifyUserRequest.builder()
                .avatar("avatar")
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
                .email("ian.malcolm@chaos.theory")
                .locale("locale")
                .name("Dr. Ian Malcolm")
                .phoneNumber("phone_number")
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
                .timezone("America/New_York")
                .build()

        val roundtrippedIdentifyUserRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(identifyUserRequest),
                jacksonTypeRef<IdentifyUserRequest>(),
            )

        assertThat(roundtrippedIdentifyUserRequest).isEqualTo(identifyUserRequest)
    }
}
