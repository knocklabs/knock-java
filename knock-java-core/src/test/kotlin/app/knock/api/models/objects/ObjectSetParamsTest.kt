// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.core.JsonValue
import app.knock.api.models.UnnamedSchemaWithArrayParent0
import app.knock.api.models.recipients.channeldata.PushChannelData
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ObjectSetParamsTest {

    @Test
    fun create() {
        ObjectSetParams.builder()
            .collection("collection")
            .id("id")
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
            .locale("en-US")
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
    }

    @Test
    fun pathParams() {
        val params = ObjectSetParams.builder().collection("collection").id("id").build()

        assertThat(params._pathParam(0)).isEqualTo("collection")
        assertThat(params._pathParam(1)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            ObjectSetParams.builder()
                .collection("collection")
                .id("id")
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
                .locale("en-US")
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

        val body = params._body()

        assertThat(body.channelData().getOrNull())
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
        assertThat(body.locale()).contains("en-US")
        assertThat(body.preferences())
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
        assertThat(body.timezone()).contains("America/New_York")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = ObjectSetParams.builder().collection("collection").id("id").build()

        val body = params._body()
    }
}
