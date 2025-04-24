// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.core.JsonValue
import app.knock.api.core.jsonMapper
import app.knock.api.models.recipients.channeldata.InlineChannelDataRequest
import app.knock.api.models.recipients.preferences.InlinePreferenceSetRequest
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InlineIdentifyUserRequestTest {

    @Test
    fun create() {
        val inlineIdentifyUserRequest =
            InlineIdentifyUserRequest.builder()
                .id("user_1")
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
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
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
                .build()

        assertThat(inlineIdentifyUserRequest.id()).isEqualTo("user_1")
        assertThat(inlineIdentifyUserRequest.channelData())
            .contains(
                InlineChannelDataRequest.builder()
                    .putAdditionalProperty(
                        "97c5837d-c65c-4d54-aa39-080eeb81c69d",
                        JsonValue.from(mapOf("data" to mapOf("tokens" to listOf("push_token_123")))),
                    )
                    .build()
            )
        assertThat(inlineIdentifyUserRequest.createdAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(inlineIdentifyUserRequest.preferences())
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
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inlineIdentifyUserRequest =
            InlineIdentifyUserRequest.builder()
                .id("user_1")
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
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
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
                .build()

        val roundtrippedInlineIdentifyUserRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inlineIdentifyUserRequest),
                jacksonTypeRef<InlineIdentifyUserRequest>(),
            )

        assertThat(roundtrippedInlineIdentifyUserRequest).isEqualTo(inlineIdentifyUserRequest)
    }
}
