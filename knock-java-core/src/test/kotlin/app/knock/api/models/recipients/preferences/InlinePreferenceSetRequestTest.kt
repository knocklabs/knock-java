// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.recipients.preferences

import app.knock.api.core.JsonValue
import app.knock.api.core.jsonMapper
import app.knock.api.models.shared.Condition
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InlinePreferenceSetRequestTest {

    @Test
    fun create() {
        val inlinePreferenceSetRequest =
            InlinePreferenceSetRequest.builder()
                .id("id")
                .categories(
                    InlinePreferenceSetRequest.Categories.builder()
                        .putAdditionalProperty(
                            "marketing",
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
                        .putAdditionalProperty("transactional", JsonValue.from(true))
                        .build()
                )
                .channelTypes(
                    PreferenceSetChannelTypes.builder()
                        .chat(true)
                        .email(true)
                        .http(true)
                        .inAppFeed(true)
                        .push(true)
                        .sms(
                            PreferenceSetChannelTypeSetting.builder()
                                .addCondition(
                                    Condition.builder()
                                        .argument("US")
                                        .operator(Condition.Operator.EQUAL_TO)
                                        .variable("recipient.country_code")
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .workflows(
                    InlinePreferenceSetRequest.Workflows.builder()
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
                        .putAdditionalProperty("welcome-sequence", JsonValue.from(true))
                        .build()
                )
                .build()

        assertThat(inlinePreferenceSetRequest.id()).isEqualTo("id")
        assertThat(inlinePreferenceSetRequest.categories())
            .contains(
                InlinePreferenceSetRequest.Categories.builder()
                    .putAdditionalProperty(
                        "marketing",
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
                    .putAdditionalProperty("transactional", JsonValue.from(true))
                    .build()
            )
        assertThat(inlinePreferenceSetRequest.channelTypes())
            .contains(
                PreferenceSetChannelTypes.builder()
                    .chat(true)
                    .email(true)
                    .http(true)
                    .inAppFeed(true)
                    .push(true)
                    .sms(
                        PreferenceSetChannelTypeSetting.builder()
                            .addCondition(
                                Condition.builder()
                                    .argument("US")
                                    .operator(Condition.Operator.EQUAL_TO)
                                    .variable("recipient.country_code")
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )
        assertThat(inlinePreferenceSetRequest.workflows())
            .contains(
                InlinePreferenceSetRequest.Workflows.builder()
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
                    .putAdditionalProperty("welcome-sequence", JsonValue.from(true))
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inlinePreferenceSetRequest =
            InlinePreferenceSetRequest.builder()
                .id("id")
                .categories(
                    InlinePreferenceSetRequest.Categories.builder()
                        .putAdditionalProperty(
                            "marketing",
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
                        .putAdditionalProperty("transactional", JsonValue.from(true))
                        .build()
                )
                .channelTypes(
                    PreferenceSetChannelTypes.builder()
                        .chat(true)
                        .email(true)
                        .http(true)
                        .inAppFeed(true)
                        .push(true)
                        .sms(
                            PreferenceSetChannelTypeSetting.builder()
                                .addCondition(
                                    Condition.builder()
                                        .argument("US")
                                        .operator(Condition.Operator.EQUAL_TO)
                                        .variable("recipient.country_code")
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .workflows(
                    InlinePreferenceSetRequest.Workflows.builder()
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
                        .putAdditionalProperty("welcome-sequence", JsonValue.from(true))
                        .build()
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
