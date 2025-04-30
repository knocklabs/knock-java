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
            .id("id")
            .channelData(
                InlineChannelDataRequest.builder()
                    .putAdditionalProperty(
                        "97c5837d-c65c-4d54-aa39-080eeb81c69d",
                        JsonValue.from(mapOf("data" to mapOf("tokens" to listOf("push_token_123")))),
                    )
                    .build()
            )
            .locale("en-US")
            .preferences(
                InlinePreferenceSetRequest.builder()
                    .putAdditionalProperty(
                        "default",
                        JsonValue.from(
                            mapOf(
                                "categories" to
                                    mapOf(
                                        "marketing" to
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
                                                            "argument" to "frog_genome",
                                                            "operator" to "contains",
                                                            "variable" to "specimen.dna_sequence",
                                                        )
                                                    ),
                                            ),
                                        "transactional" to true,
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
                                                            "argument" to "frog_genome",
                                                            "operator" to "contains",
                                                            "variable" to "specimen.dna_sequence",
                                                        )
                                                    ),
                                            )
                                    ),
                            )
                        ),
                    )
                    .build()
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
                .channelData(
                    InlineChannelDataRequest.builder()
                        .putAdditionalProperty(
                            "97c5837d-c65c-4d54-aa39-080eeb81c69d",
                            JsonValue.from(
                                mapOf("data" to mapOf("tokens" to listOf("push_token_123")))
                            ),
                        )
                        .build()
                )
                .locale("en-US")
                .preferences(
                    InlinePreferenceSetRequest.builder()
                        .putAdditionalProperty(
                            "default",
                            JsonValue.from(
                                mapOf(
                                    "categories" to
                                        mapOf(
                                            "marketing" to
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
                                                                "argument" to "frog_genome",
                                                                "operator" to "contains",
                                                                "variable" to
                                                                    "specimen.dna_sequence",
                                                            )
                                                        ),
                                                ),
                                            "transactional" to true,
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
                                                                "argument" to "frog_genome",
                                                                "operator" to "contains",
                                                                "variable" to
                                                                    "specimen.dna_sequence",
                                                            )
                                                        ),
                                                )
                                        ),
                                )
                            ),
                        )
                        .build()
                )
                .timezone("America/New_York")
                .build()

        val body = params._body()

        assertThat(body.channelData())
            .contains(
                InlineChannelDataRequest.builder()
                    .putAdditionalProperty(
                        "97c5837d-c65c-4d54-aa39-080eeb81c69d",
                        JsonValue.from(mapOf("data" to mapOf("tokens" to listOf("push_token_123")))),
                    )
                    .build()
            )
        assertThat(body.locale()).contains("en-US")
        assertThat(body.preferences())
            .contains(
                InlinePreferenceSetRequest.builder()
                    .putAdditionalProperty(
                        "default",
                        JsonValue.from(
                            mapOf(
                                "categories" to
                                    mapOf(
                                        "marketing" to
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
                                                            "argument" to "frog_genome",
                                                            "operator" to "contains",
                                                            "variable" to "specimen.dna_sequence",
                                                        )
                                                    ),
                                            ),
                                        "transactional" to true,
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
                                                            "argument" to "frog_genome",
                                                            "operator" to "contains",
                                                            "variable" to "specimen.dna_sequence",
                                                        )
                                                    ),
                                            )
                                    ),
                            )
                        ),
                    )
                    .build()
            )
        assertThat(body.timezone()).contains("America/New_York")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = ObjectSetParams.builder().collection("collection").id("id").build()

        val body = params._body()
    }
}
