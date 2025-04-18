// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.core.JsonValue
import app.knock.api.core.jsonMapper
import app.knock.api.models.UnnamedSchemaWithArrayParent0
import app.knock.api.models.UnnamedSchemaWithArrayParent1
import app.knock.api.models.recipients.channeldata.PushChannelData
import app.knock.api.models.recipients.preferences.PreferenceSetChannelTypes
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InlineIdentifyUserRequestTest {

    @Test
    fun create() {
        val inlineIdentifyUserRequest =
            InlineIdentifyUserRequest.builder()
                .id("user_1")
                .addChannelData(
                    UnnamedSchemaWithArrayParent0.builder()
                        .channelId("97c5837d-c65c-4d54-aa39-080eeb81c69d")
                        .data(
                            PushChannelData.builder()
                                ._typename(PushChannelData._Typename.PUSH_CHANNEL_DATA)
                                .addToken("push_token_123")
                                .build()
                        )
                        .build()
                )
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .addPreference(
                    UnnamedSchemaWithArrayParent1.builder()
                        .id("default")
                        .categories(
                            UnnamedSchemaWithArrayParent1.Categories.builder()
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
                                                        "argument" to "some_property",
                                                        "operator" to "equal_to",
                                                        "variable" to "recipient.property",
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

        assertThat(inlineIdentifyUserRequest.id()).isEqualTo("user_1")
        assertThat(inlineIdentifyUserRequest.channelData().getOrNull())
            .containsExactly(
                UnnamedSchemaWithArrayParent0.builder()
                    .channelId("97c5837d-c65c-4d54-aa39-080eeb81c69d")
                    .data(
                        PushChannelData.builder()
                            ._typename(PushChannelData._Typename.PUSH_CHANNEL_DATA)
                            .addToken("push_token_123")
                            .build()
                    )
                    .build()
            )
        assertThat(inlineIdentifyUserRequest.createdAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(inlineIdentifyUserRequest.preferences().getOrNull())
            .containsExactly(
                UnnamedSchemaWithArrayParent1.builder()
                    .id("default")
                    .categories(
                        UnnamedSchemaWithArrayParent1.Categories.builder()
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
                                                    "argument" to "some_property",
                                                    "operator" to "equal_to",
                                                    "variable" to "recipient.property",
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
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inlineIdentifyUserRequest =
            InlineIdentifyUserRequest.builder()
                .id("user_1")
                .addChannelData(
                    UnnamedSchemaWithArrayParent0.builder()
                        .channelId("97c5837d-c65c-4d54-aa39-080eeb81c69d")
                        .data(
                            PushChannelData.builder()
                                ._typename(PushChannelData._Typename.PUSH_CHANNEL_DATA)
                                .addToken("push_token_123")
                                .build()
                        )
                        .build()
                )
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .addPreference(
                    UnnamedSchemaWithArrayParent1.builder()
                        .id("default")
                        .categories(
                            UnnamedSchemaWithArrayParent1.Categories.builder()
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
                                                        "argument" to "some_property",
                                                        "operator" to "equal_to",
                                                        "variable" to "recipient.property",
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

        val roundtrippedInlineIdentifyUserRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inlineIdentifyUserRequest),
                jacksonTypeRef<InlineIdentifyUserRequest>(),
            )

        assertThat(roundtrippedInlineIdentifyUserRequest).isEqualTo(inlineIdentifyUserRequest)
    }
}
