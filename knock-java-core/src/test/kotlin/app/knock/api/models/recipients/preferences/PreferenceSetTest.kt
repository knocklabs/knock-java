// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.recipients.preferences

import app.knock.api.core.JsonValue
import app.knock.api.core.jsonMapper
import app.knock.api.models.shared.Condition
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PreferenceSetTest {

    @Test
    fun create() {
        val preferenceSet =
            PreferenceSet.builder()
                .id("default")
                .categories(
                    PreferenceSet.Categories.builder()
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
                        .push(false)
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
                    PreferenceSet.Workflows.builder()
                        .putAdditionalProperty(
                            "foo",
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

        assertThat(preferenceSet.id()).isEqualTo("default")
        assertThat(preferenceSet.categories())
            .contains(
                PreferenceSet.Categories.builder()
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
        assertThat(preferenceSet.channelTypes())
            .contains(
                PreferenceSetChannelTypes.builder()
                    .chat(true)
                    .email(true)
                    .http(true)
                    .inAppFeed(true)
                    .push(false)
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
        assertThat(preferenceSet.workflows())
            .contains(
                PreferenceSet.Workflows.builder()
                    .putAdditionalProperty(
                        "foo",
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
        val preferenceSet =
            PreferenceSet.builder()
                .id("default")
                .categories(
                    PreferenceSet.Categories.builder()
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
                        .push(false)
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
                    PreferenceSet.Workflows.builder()
                        .putAdditionalProperty(
                            "foo",
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

        val roundtrippedPreferenceSet =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(preferenceSet),
                jacksonTypeRef<PreferenceSet>(),
            )

        assertThat(roundtrippedPreferenceSet).isEqualTo(preferenceSet)
    }
}
