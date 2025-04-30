// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.recipients.preferences

import app.knock.api.core.JsonValue
import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InlinePreferenceSetRequestTest {

    @Test
    fun create() {
        val inlinePreferenceSetRequest =
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
                                                        "argument" to "frog_genome",
                                                        "operator" to "contains",
                                                        "variable" to "specimen.dna_sequence",
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
                                    "welcome-sequence" to true,
                                ),
                        )
                    ),
                )
                .build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inlinePreferenceSetRequest =
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
                                                        "argument" to "frog_genome",
                                                        "operator" to "contains",
                                                        "variable" to "specimen.dna_sequence",
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
                                    "welcome-sequence" to true,
                                ),
                        )
                    ),
                )
                .build()

        val roundtrippedInlinePreferenceSetRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inlinePreferenceSetRequest),
                jacksonTypeRef<InlinePreferenceSetRequest>(),
            )

        assertThat(roundtrippedInlinePreferenceSetRequest).isEqualTo(inlinePreferenceSetRequest)
    }
}
