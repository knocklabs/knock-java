// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.core.JsonValue
import app.knock.api.models.recipients.channeldata.InlineChannelDataRequest
import app.knock.api.models.recipients.preferences.InlinePreferenceSetRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ObjectSetParamsTest {

    @Test
    fun create() {
        ObjectSetParams.builder()
            .collection("collection")
            .objectId("object_id")
            .channelData(
                InlineChannelDataRequest.builder()
                    .putAdditionalProperty(
                        "97c5837d-c65c-4d54-aa39-080eeb81c69d",
                        JsonValue.from(
                            mapOf(
                                "data" to
                                    mapOf(
                                        "__typename" to "PushChannelData",
                                        "tokens" to listOf("push_token_xxx"),
                                    )
                            )
                        ),
                    )
                    .build()
            )
            .preferences(
                InlinePreferenceSetRequest.builder()
                    .putAdditionalProperty(
                        "default",
                        JsonValue.from(
                            mapOf(
                                "categories" to
                                    mapOf(
                                        "transactional" to
                                            mapOf(
                                                "channel_types" to
                                                    mapOf(
                                                        "chat" to true,
                                                        "email" to false,
                                                        "http" to true,
                                                        "in_app_feed" to true,
                                                        "push" to true,
                                                        "sms" to true,
                                                    ),
                                                "conditions" to
                                                    listOf(
                                                        mapOf(
                                                            "argument" to "some_property",
                                                            "operator" to "equal_to",
                                                            "variable" to "recipient.property",
                                                        )
                                                    ),
                                            )
                                    ),
                                "channel_types" to
                                    mapOf(
                                        "chat" to true,
                                        "email" to true,
                                        "http" to true,
                                        "in_app_feed" to true,
                                        "push" to true,
                                        "sms" to true,
                                    ),
                                "workflows" to
                                    mapOf(
                                        "dinosaurs-loose" to
                                            mapOf(
                                                "channel_types" to
                                                    mapOf(
                                                        "chat" to true,
                                                        "email" to true,
                                                        "http" to true,
                                                        "in_app_feed" to true,
                                                        "push" to true,
                                                        "sms" to true,
                                                    ),
                                                "conditions" to
                                                    listOf(
                                                        mapOf(
                                                            "argument" to "some_property",
                                                            "operator" to "equal_to",
                                                            "variable" to "recipient.property",
                                                        )
                                                    ),
                                            )
                                    ),
                            )
                        ),
                    )
                    .build()
            )
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            ObjectSetParams.builder().collection("collection").objectId("object_id").build()

        assertThat(params._pathParam(0)).isEqualTo("collection")
        assertThat(params._pathParam(1)).isEqualTo("object_id")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            ObjectSetParams.builder()
                .collection("collection")
                .objectId("object_id")
                .channelData(
                    InlineChannelDataRequest.builder()
                        .putAdditionalProperty(
                            "97c5837d-c65c-4d54-aa39-080eeb81c69d",
                            JsonValue.from(
                                mapOf(
                                    "data" to
                                        mapOf(
                                            "__typename" to "PushChannelData",
                                            "tokens" to listOf("push_token_xxx"),
                                        )
                                )
                            ),
                        )
                        .build()
                )
                .preferences(
                    InlinePreferenceSetRequest.builder()
                        .putAdditionalProperty(
                            "default",
                            JsonValue.from(
                                mapOf(
                                    "categories" to
                                        mapOf(
                                            "transactional" to
                                                mapOf(
                                                    "channel_types" to
                                                        mapOf(
                                                            "chat" to true,
                                                            "email" to false,
                                                            "http" to true,
                                                            "in_app_feed" to true,
                                                            "push" to true,
                                                            "sms" to true,
                                                        ),
                                                    "conditions" to
                                                        listOf(
                                                            mapOf(
                                                                "argument" to "some_property",
                                                                "operator" to "equal_to",
                                                                "variable" to "recipient.property",
                                                            )
                                                        ),
                                                )
                                        ),
                                    "channel_types" to
                                        mapOf(
                                            "chat" to true,
                                            "email" to true,
                                            "http" to true,
                                            "in_app_feed" to true,
                                            "push" to true,
                                            "sms" to true,
                                        ),
                                    "workflows" to
                                        mapOf(
                                            "dinosaurs-loose" to
                                                mapOf(
                                                    "channel_types" to
                                                        mapOf(
                                                            "chat" to true,
                                                            "email" to true,
                                                            "http" to true,
                                                            "in_app_feed" to true,
                                                            "push" to true,
                                                            "sms" to true,
                                                        ),
                                                    "conditions" to
                                                        listOf(
                                                            mapOf(
                                                                "argument" to "some_property",
                                                                "operator" to "equal_to",
                                                                "variable" to "recipient.property",
                                                            )
                                                        ),
                                                )
                                        ),
                                )
                            ),
                        )
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.channelData())
            .contains(
                InlineChannelDataRequest.builder()
                    .putAdditionalProperty(
                        "97c5837d-c65c-4d54-aa39-080eeb81c69d",
                        JsonValue.from(
                            mapOf(
                                "data" to
                                    mapOf(
                                        "__typename" to "PushChannelData",
                                        "tokens" to listOf("push_token_xxx"),
                                    )
                            )
                        ),
                    )
                    .build()
            )
        assertThat(body.preferences())
            .contains(
                InlinePreferenceSetRequest.builder()
                    .putAdditionalProperty(
                        "default",
                        JsonValue.from(
                            mapOf(
                                "categories" to
                                    mapOf(
                                        "transactional" to
                                            mapOf(
                                                "channel_types" to
                                                    mapOf(
                                                        "chat" to true,
                                                        "email" to false,
                                                        "http" to true,
                                                        "in_app_feed" to true,
                                                        "push" to true,
                                                        "sms" to true,
                                                    ),
                                                "conditions" to
                                                    listOf(
                                                        mapOf(
                                                            "argument" to "some_property",
                                                            "operator" to "equal_to",
                                                            "variable" to "recipient.property",
                                                        )
                                                    ),
                                            )
                                    ),
                                "channel_types" to
                                    mapOf(
                                        "chat" to true,
                                        "email" to true,
                                        "http" to true,
                                        "in_app_feed" to true,
                                        "push" to true,
                                        "sms" to true,
                                    ),
                                "workflows" to
                                    mapOf(
                                        "dinosaurs-loose" to
                                            mapOf(
                                                "channel_types" to
                                                    mapOf(
                                                        "chat" to true,
                                                        "email" to true,
                                                        "http" to true,
                                                        "in_app_feed" to true,
                                                        "push" to true,
                                                        "sms" to true,
                                                    ),
                                                "conditions" to
                                                    listOf(
                                                        mapOf(
                                                            "argument" to "some_property",
                                                            "operator" to "equal_to",
                                                            "variable" to "recipient.property",
                                                        )
                                                    ),
                                            )
                                    ),
                            )
                        ),
                    )
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            ObjectSetParams.builder().collection("collection").objectId("object_id").build()

        val body = params._body()
    }
}
