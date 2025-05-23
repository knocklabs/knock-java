// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.core.JsonValue
import app.knock.api.models.recipients.preferences.PreferenceSetChannelTypes
import app.knock.api.models.recipients.preferences.PreferenceSetRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserSetPreferencesParamsTest {

    @Test
    fun create() {
        UserSetPreferencesParams.builder()
            .userId("user_id")
            .id("default")
            .preferenceSetRequest(
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
            )
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            UserSetPreferencesParams.builder()
                .userId("user_id")
                .id("default")
                .preferenceSetRequest(PreferenceSetRequest.builder().build())
                .build()

        assertThat(params._pathParam(0)).isEqualTo("user_id")
        assertThat(params._pathParam(1)).isEqualTo("default")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            UserSetPreferencesParams.builder()
                .userId("user_id")
                .id("default")
                .preferenceSetRequest(
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
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
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
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            UserSetPreferencesParams.builder()
                .userId("user_id")
                .id("default")
                .preferenceSetRequest(PreferenceSetRequest.builder().build())
                .build()

        val body = params._body()

        assertThat(body).isEqualTo(PreferenceSetRequest.builder().build())
    }
}
