// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects.bulk

import app.knock.api.core.JsonValue
import app.knock.api.models.UnnamedSchemaWithArrayParent0
import app.knock.api.models.UnnamedSchemaWithArrayParent1
import app.knock.api.models.objects.InlineObjectRequest
import app.knock.api.models.recipients.channeldata.PushChannelData
import app.knock.api.models.recipients.preferences.PreferenceSetChannelTypes
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BulkSetParamsTest {

    @Test
    fun create() {
        BulkSetParams.builder()
            .collection("collection")
            .addObject(
                InlineObjectRequest.builder()
                    .id("project_1")
                    .collection("projects")
                    .addChannelData(
                        UnnamedSchemaWithArrayParent0.builder()
                            .channelId("97c5837d-c65c-4d54-aa39-080eeb81c69d")
                            .data(
                                PushChannelData.builder()
                                    .addToken("push_token_xxx")
                                    .type(PushChannelData.Type.PUSH_FCM)
                                    ._typename(PushChannelData._Typename.PUSH_CHANNEL_DATA)
                                    .build()
                            )
                            .provider("push_fcm")
                            .build()
                    )
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .addPreference(
                        UnnamedSchemaWithArrayParent1.builder()
                            .id("default")
                            .categories(
                                UnnamedSchemaWithArrayParent1.Categories.builder()
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
                                    .push(true)
                                    .sms(true)
                                    .build()
                            )
                            .workflows(
                                UnnamedSchemaWithArrayParent1.Workflows.builder()
                                    .putAdditionalProperty(
                                        "dinosaurs-loose",
                                        JsonValue.from(
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
            )
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            BulkSetParams.builder()
                .collection("collection")
                .addObject(
                    InlineObjectRequest.builder().id("project_1").collection("projects").build()
                )
                .build()

        assertThat(params._pathParam(0)).isEqualTo("collection")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            BulkSetParams.builder()
                .collection("collection")
                .addObject(
                    InlineObjectRequest.builder()
                        .id("project_1")
                        .collection("projects")
                        .addChannelData(
                            UnnamedSchemaWithArrayParent0.builder()
                                .channelId("97c5837d-c65c-4d54-aa39-080eeb81c69d")
                                .data(
                                    PushChannelData.builder()
                                        .addToken("push_token_xxx")
                                        .type(PushChannelData.Type.PUSH_FCM)
                                        ._typename(PushChannelData._Typename.PUSH_CHANNEL_DATA)
                                        .build()
                                )
                                .provider("push_fcm")
                                .build()
                        )
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .addPreference(
                            UnnamedSchemaWithArrayParent1.builder()
                                .id("default")
                                .categories(
                                    UnnamedSchemaWithArrayParent1.Categories.builder()
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
                                        .push(true)
                                        .sms(true)
                                        .build()
                                )
                                .workflows(
                                    UnnamedSchemaWithArrayParent1.Workflows.builder()
                                        .putAdditionalProperty(
                                            "dinosaurs-loose",
                                            JsonValue.from(
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
                )
                .build()

        val body = params._body()

        assertThat(body.objects())
            .containsExactly(
                InlineObjectRequest.builder()
                    .id("project_1")
                    .collection("projects")
                    .addChannelData(
                        UnnamedSchemaWithArrayParent0.builder()
                            .channelId("97c5837d-c65c-4d54-aa39-080eeb81c69d")
                            .data(
                                PushChannelData.builder()
                                    .addToken("push_token_xxx")
                                    .type(PushChannelData.Type.PUSH_FCM)
                                    ._typename(PushChannelData._Typename.PUSH_CHANNEL_DATA)
                                    .build()
                            )
                            .provider("push_fcm")
                            .build()
                    )
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .addPreference(
                        UnnamedSchemaWithArrayParent1.builder()
                            .id("default")
                            .categories(
                                UnnamedSchemaWithArrayParent1.Categories.builder()
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
                                    .push(true)
                                    .sms(true)
                                    .build()
                            )
                            .workflows(
                                UnnamedSchemaWithArrayParent1.Workflows.builder()
                                    .putAdditionalProperty(
                                        "dinosaurs-loose",
                                        JsonValue.from(
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
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            BulkSetParams.builder()
                .collection("collection")
                .addObject(
                    InlineObjectRequest.builder().id("project_1").collection("projects").build()
                )
                .build()

        val body = params._body()

        assertThat(body.objects())
            .containsExactly(
                InlineObjectRequest.builder().id("project_1").collection("projects").build()
            )
    }
}
