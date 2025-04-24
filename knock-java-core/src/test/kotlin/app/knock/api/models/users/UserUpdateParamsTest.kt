// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.core.JsonValue
import app.knock.api.models.UnnamedSchemaWithArrayParent0
import app.knock.api.models.recipients.channeldata.PushChannelData
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserUpdateParamsTest {

    @Test
    fun create() {
        UserUpdateParams.builder()
            .userId("user_id")
            .identifyUserRequest(
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
            )
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            UserUpdateParams.builder()
                .userId("user_id")
                .identifyUserRequest(IdentifyUserRequest.builder().build())
                .build()

        assertThat(params._pathParam(0)).isEqualTo("user_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            UserUpdateParams.builder()
                .userId("user_id")
                .identifyUserRequest(
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
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
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
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            UserUpdateParams.builder()
                .userId("user_id")
                .identifyUserRequest(IdentifyUserRequest.builder().build())
                .build()

        val body = params._body()

        assertThat(body).isEqualTo(IdentifyUserRequest.builder().build())
    }
}
