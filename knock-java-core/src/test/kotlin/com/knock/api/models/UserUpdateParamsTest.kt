// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import com.knock.api.core.JsonValue
import java.time.OffsetDateTime
import kotlin.test.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UserUpdateParamsTest {

    @Test
    fun create() {
        UserUpdateParams.builder()
            .userId("user_id")
            .channelData(
                InlineChannelDataRequest.builder()
                    .putAdditionalProperty(
                        "97c5837d-c65c-4d54-aa39-080eeb81c69d",
                        JsonValue.from(mapOf("data" to mapOf("tokens" to listOf("push_token_xxx")))),
                    )
                    .build()
            )
            .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
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
    fun body() {
        val params =
            UserUpdateParams.builder()
                .userId("user_id")
                .channelData(
                    InlineChannelDataRequest.builder()
                        .putAdditionalProperty(
                            "97c5837d-c65c-4d54-aa39-080eeb81c69d",
                            JsonValue.from(
                                mapOf("data" to mapOf("tokens" to listOf("push_token_xxx")))
                            ),
                        )
                        .build()
                )
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
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

        assertNotNull(body)
        assertThat(body.channelData())
            .contains(
                InlineChannelDataRequest.builder()
                    .putAdditionalProperty(
                        "97c5837d-c65c-4d54-aa39-080eeb81c69d",
                        JsonValue.from(mapOf("data" to mapOf("tokens" to listOf("push_token_xxx")))),
                    )
                    .build()
            )
        assertThat(body.createdAt()).contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
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
        val params = UserUpdateParams.builder().userId("user_id").build()

        val body = params._body()

        assertNotNull(body)
    }

    @Test
    fun getPathParam() {
        val params = UserUpdateParams.builder().userId("user_id").build()
        assertThat(params).isNotNull
        // path param "userId"
        assertThat(params.getPathParam(0)).isEqualTo("user_id")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
