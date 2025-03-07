// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import com.knock.api.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ObjectSetPreferencesParamsTest {

    @Test
    fun create() {
        ObjectSetPreferencesParams.builder()
            .collection("collection")
            .objectId("object_id")
            .id("id")
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
                            .push(PreferenceSetChannelTypes.Push.ofBool(true))
                            .sms(PreferenceSetChannelTypes.Sms.ofBool(true))
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
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            ObjectSetPreferencesParams.builder()
                .collection("collection")
                .objectId("object_id")
                .id("id")
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
                                .push(PreferenceSetChannelTypes.Push.ofBool(true))
                                .sms(PreferenceSetChannelTypes.Sms.ofBool(true))
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
                            .push(PreferenceSetChannelTypes.Push.ofBool(true))
                            .sms(PreferenceSetChannelTypes.Sms.ofBool(true))
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
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            ObjectSetPreferencesParams.builder()
                .collection("collection")
                .objectId("object_id")
                .id("id")
                .preferenceSetRequest(PreferenceSetRequest.builder().build())
                .build()

        val body = params._body()

        assertThat(body).isEqualTo(PreferenceSetRequest.builder().build())
    }

    @Test
    fun getPathParam() {
        val params =
            ObjectSetPreferencesParams.builder()
                .collection("collection")
                .objectId("object_id")
                .id("id")
                .preferenceSetRequest(PreferenceSetRequest.builder().build())
                .build()
        assertThat(params).isNotNull
        // path param "collection"
        assertThat(params.getPathParam(0)).isEqualTo("collection")
        // path param "objectId"
        assertThat(params.getPathParam(1)).isEqualTo("object_id")
        // path param "id"
        assertThat(params.getPathParam(2)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params.getPathParam(3)).isEqualTo("")
    }
}
