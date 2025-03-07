// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import com.knock.api.core.JsonValue
import java.time.OffsetDateTime
import kotlin.test.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ObjectBulkSetParamsTest {

    @Test
    fun create() {
        ObjectBulkSetParams.builder()
            .collection("collection")
            .addObject(
                InlineObjectRequest.builder()
                    .id("project_1")
                    .collection("projects")
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
                                                                    "variable" to
                                                                        "recipient.property",
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
                                                                    "variable" to
                                                                        "recipient.property",
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
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            ObjectBulkSetParams.builder()
                .collection("collection")
                .addObject(
                    InlineObjectRequest.builder()
                        .id("project_1")
                        .collection("projects")
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
                                                                        "argument" to
                                                                            "some_property",
                                                                        "operator" to "equal_to",
                                                                        "variable" to
                                                                            "recipient.property",
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
                                                                        "argument" to
                                                                            "some_property",
                                                                        "operator" to "equal_to",
                                                                        "variable" to
                                                                            "recipient.property",
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
                )
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.objects())
            .isEqualTo(
                listOf(
                    InlineObjectRequest.builder()
                        .id("project_1")
                        .collection("projects")
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
                                                                        "argument" to
                                                                            "some_property",
                                                                        "operator" to "equal_to",
                                                                        "variable" to
                                                                            "recipient.property",
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
                                                                        "argument" to
                                                                            "some_property",
                                                                        "operator" to "equal_to",
                                                                        "variable" to
                                                                            "recipient.property",
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
                )
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            ObjectBulkSetParams.builder()
                .collection("collection")
                .addObject(
                    InlineObjectRequest.builder().id("project_1").collection("projects").build()
                )
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.objects())
            .isEqualTo(
                listOf(InlineObjectRequest.builder().id("project_1").collection("projects").build())
            )
    }

    @Test
    fun getPathParam() {
        val params =
            ObjectBulkSetParams.builder()
                .collection("collection")
                .addObject(
                    InlineObjectRequest.builder().id("project_1").collection("projects").build()
                )
                .build()
        assertThat(params).isNotNull
        // path param "collection"
        assertThat(params.getPathParam(0)).isEqualTo("collection")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
