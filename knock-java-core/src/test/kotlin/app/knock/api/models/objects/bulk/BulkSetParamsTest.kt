// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects.bulk

import app.knock.api.core.JsonValue
import app.knock.api.models.objects.InlineObjectRequest
import app.knock.api.models.recipients.channeldata.InlineChannelDataRequest
import app.knock.api.models.recipients.preferences.InlinePreferenceSetRequest
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BulkSetParamsTest {

    @Test
    fun create() {
        BulkSetParams.builder()
            .collection("collection")
            .addObject(
                InlineObjectRequest.builder()
                    .id("project_1")
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
                    .collection("projects")
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
    fun pathParams() {
        val params =
            BulkSetParams.builder()
                .collection("collection")
                .addObject(InlineObjectRequest.builder().build())
                .build()

        assertThat(params._pathParam(0)).isEqualTo("collection")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            BulkSetParams.builder()
                .collection("collection")
                .addObject(
                    InlineObjectRequest.builder()
                        .id("project_1")
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
                        .collection("projects")
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

        assertThat(body.objects())
            .containsExactly(
                InlineObjectRequest.builder()
                    .id("project_1")
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
                    .collection("projects")
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
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            BulkSetParams.builder()
                .collection("collection")
                .addObject(InlineObjectRequest.builder().build())
                .build()

        val body = params._body()

        assertThat(body.objects()).containsExactly(InlineObjectRequest.builder().build())
    }
}
