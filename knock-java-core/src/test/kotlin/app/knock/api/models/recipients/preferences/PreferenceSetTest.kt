// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.recipients.preferences

import app.knock.api.core.JsonValue
import app.knock.api.core.jsonMapper
import app.knock.api.models.Condition
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PreferenceSetTest {

    @Test
    fun create() {
        val preferenceSet =
            PreferenceSet.builder()
                .id("default")
                ._typename("PreferenceSet")
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
                                                "argument" to "some_property",
                                                "operator" to "equal_to",
                                                "variable" to "recipient.property",
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
                            PreferenceSetChannelTypes.Sms.Conditions.builder()
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
                                            "email" to true,
                                            "http" to true,
                                            "in_app_feed" to true,
                                            "push" to true,
                                            "sms" to
                                                mapOf(
                                                    "conditions" to
                                                        listOf(
                                                            mapOf(
                                                                "argument" to "US",
                                                                "operator" to "equal_to",
                                                                "variable" to
                                                                    "recipient.country_code",
                                                            )
                                                        )
                                                ),
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
                        .build()
                )
                .build()

        assertThat(preferenceSet.id()).isEqualTo("default")
        assertThat(preferenceSet._typename()).isEqualTo("PreferenceSet")
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
                                            "argument" to "some_property",
                                            "operator" to "equal_to",
                                            "variable" to "recipient.property",
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
                        PreferenceSetChannelTypes.Sms.Conditions.builder()
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
                                        "email" to true,
                                        "http" to true,
                                        "in_app_feed" to true,
                                        "push" to true,
                                        "sms" to
                                            mapOf(
                                                "conditions" to
                                                    listOf(
                                                        mapOf(
                                                            "argument" to "US",
                                                            "operator" to "equal_to",
                                                            "variable" to "recipient.country_code",
                                                        )
                                                    )
                                            ),
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
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val preferenceSet =
            PreferenceSet.builder()
                .id("default")
                ._typename("PreferenceSet")
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
                                                "argument" to "some_property",
                                                "operator" to "equal_to",
                                                "variable" to "recipient.property",
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
                            PreferenceSetChannelTypes.Sms.Conditions.builder()
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
                                            "email" to true,
                                            "http" to true,
                                            "in_app_feed" to true,
                                            "push" to true,
                                            "sms" to
                                                mapOf(
                                                    "conditions" to
                                                        listOf(
                                                            mapOf(
                                                                "argument" to "US",
                                                                "operator" to "equal_to",
                                                                "variable" to
                                                                    "recipient.country_code",
                                                            )
                                                        )
                                                ),
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
