// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.recipients.preferences

import app.knock.api.core.JsonValue
import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PreferenceSetRequestTest {

    @Test
    fun create() {
        val preferenceSetRequest =
            PreferenceSetRequest.builder()
                .categories(
                    PreferenceSetRequest.Categories.builder()
                        .putAdditionalProperty("marketing", JsonValue.from(false))
                        .putAdditionalProperty(
                            "transactional",
                            JsonValue.from(
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
                        )
                        .build()
                )
                .channelTypes(
                    PreferenceSetChannelTypes.builder()
                        .chat(true)
                        .email(true)
                        .http(true)
                        .inAppFeed(true)
                        .push(true)
                        .sms(true)
                        .build()
                )
                .workflows(
                    PreferenceSetRequest.Workflows.builder()
                        .putAdditionalProperty(
                            "dinosaurs-loose",
                            JsonValue.from(
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
                        )
                        .build()
                )
                .build()

        assertThat(preferenceSetRequest.categories())
            .contains(
                PreferenceSetRequest.Categories.builder()
                    .putAdditionalProperty("marketing", JsonValue.from(false))
                    .putAdditionalProperty(
                        "transactional",
                        JsonValue.from(
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
                    )
                    .build()
            )
        assertThat(preferenceSetRequest.channelTypes())
            .contains(
                PreferenceSetChannelTypes.builder()
                    .chat(true)
                    .email(true)
                    .http(true)
                    .inAppFeed(true)
                    .push(true)
                    .sms(true)
                    .build()
            )
        assertThat(preferenceSetRequest.workflows())
            .contains(
                PreferenceSetRequest.Workflows.builder()
                    .putAdditionalProperty(
                        "dinosaurs-loose",
                        JsonValue.from(
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
                    )
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val preferenceSetRequest =
            PreferenceSetRequest.builder()
                .categories(
                    PreferenceSetRequest.Categories.builder()
                        .putAdditionalProperty("marketing", JsonValue.from(false))
                        .putAdditionalProperty(
                            "transactional",
                            JsonValue.from(
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
                        )
                        .build()
                )
                .channelTypes(
                    PreferenceSetChannelTypes.builder()
                        .chat(true)
                        .email(true)
                        .http(true)
                        .inAppFeed(true)
                        .push(true)
                        .sms(true)
                        .build()
                )
                .workflows(
                    PreferenceSetRequest.Workflows.builder()
                        .putAdditionalProperty(
                            "dinosaurs-loose",
                            JsonValue.from(
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
                        )
                        .build()
                )
                .build()

        val roundtrippedPreferenceSetRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(preferenceSetRequest),
                jacksonTypeRef<PreferenceSetRequest>(),
            )

        assertThat(roundtrippedPreferenceSetRequest).isEqualTo(preferenceSetRequest)
    }
}
