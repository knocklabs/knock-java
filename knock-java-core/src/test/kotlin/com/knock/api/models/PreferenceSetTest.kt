// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import com.knock.api.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PreferenceSetTest {

    @Test
    fun createPreferenceSet() {
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
                        .chat(PreferenceSetChannelTypes.Chat.ofBool(true))
                        .email(PreferenceSetChannelTypes.Email.ofBool(true))
                        .http(PreferenceSetChannelTypes.Http.ofBool(true))
                        .inAppFeed(PreferenceSetChannelTypes.InAppFeed.ofBool(true))
                        .push(PreferenceSetChannelTypes.Push.ofBool(false))
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
        assertThat(preferenceSet).isNotNull
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
                    .chat(PreferenceSetChannelTypes.Chat.ofBool(true))
                    .email(PreferenceSetChannelTypes.Email.ofBool(true))
                    .http(PreferenceSetChannelTypes.Http.ofBool(true))
                    .inAppFeed(PreferenceSetChannelTypes.InAppFeed.ofBool(true))
                    .push(PreferenceSetChannelTypes.Push.ofBool(false))
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
}
