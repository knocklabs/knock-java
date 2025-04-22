// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.core.JsonValue
import app.knock.api.core.jsonMapper
import app.knock.api.models.recipients.channeldata.ChannelData
import app.knock.api.models.recipients.preferences.PreferenceSet
import app.knock.api.models.recipients.preferences.PreferenceSetChannelTypeSetting
import app.knock.api.models.recipients.preferences.PreferenceSetChannelTypes
import app.knock.api.models.shared.Condition
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserUpdateResponseTest {

    @Test
    fun create() {
        val userUpdateResponse =
            UserUpdateResponse.builder()
                .id("user-123")
                .createdAt(OffsetDateTime.parse("2023-01-01T12:00:00Z"))
                .updatedAt(OffsetDateTime.parse("2023-01-01T12:00:00Z"))
                ._typename("User")
                .avatar("avatar")
                .addChannelData(
                    ChannelData.builder()
                        ._typename("ChannelData")
                        .channelId("97c5837d-c65c-4d54-aa39-080eeb81c69d")
                        .pushChannelData(listOf("push_token_123"))
                        .build()
                )
                .email("jane@ingen.net")
                .locale("locale")
                .name("Jane Doe")
                .phoneNumber("phone_number")
                .preferences(
                    PreferenceSet.builder()
                        .id("default")
                        ._typename("PreferenceSet")
                        .categories(
                            PreferenceSet.Categories.builder()
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
                            PreferenceSet.Workflows.builder()
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
                .timezone("America/New_York")
                .build()

        assertThat(userUpdateResponse.id()).isEqualTo("user-123")
        assertThat(userUpdateResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2023-01-01T12:00:00Z"))
        assertThat(userUpdateResponse.updatedAt())
            .isEqualTo(OffsetDateTime.parse("2023-01-01T12:00:00Z"))
        assertThat(userUpdateResponse._typename()).contains("User")
        assertThat(userUpdateResponse.avatar()).contains("avatar")
        assertThat(userUpdateResponse.channelData().getOrNull())
            .containsExactly(
                ChannelData.builder()
                    ._typename("ChannelData")
                    .channelId("97c5837d-c65c-4d54-aa39-080eeb81c69d")
                    .pushChannelData(listOf("push_token_123"))
                    .build()
            )
        assertThat(userUpdateResponse.email()).contains("jane@ingen.net")
        assertThat(userUpdateResponse.locale()).contains("locale")
        assertThat(userUpdateResponse.name()).contains("Jane Doe")
        assertThat(userUpdateResponse.phoneNumber()).contains("phone_number")
        assertThat(userUpdateResponse.preferences())
            .contains(
                PreferenceSet.builder()
                    .id("default")
                    ._typename("PreferenceSet")
                    .categories(
                        PreferenceSet.Categories.builder()
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
                        PreferenceSet.Workflows.builder()
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
        assertThat(userUpdateResponse.timezone()).contains("America/New_York")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val userUpdateResponse =
            UserUpdateResponse.builder()
                .id("user-123")
                .createdAt(OffsetDateTime.parse("2023-01-01T12:00:00Z"))
                .updatedAt(OffsetDateTime.parse("2023-01-01T12:00:00Z"))
                ._typename("User")
                .avatar("avatar")
                .addChannelData(
                    ChannelData.builder()
                        ._typename("ChannelData")
                        .channelId("97c5837d-c65c-4d54-aa39-080eeb81c69d")
                        .pushChannelData(listOf("push_token_123"))
                        .build()
                )
                .email("jane@ingen.net")
                .locale("locale")
                .name("Jane Doe")
                .phoneNumber("phone_number")
                .preferences(
                    PreferenceSet.builder()
                        .id("default")
                        ._typename("PreferenceSet")
                        .categories(
                            PreferenceSet.Categories.builder()
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
                            PreferenceSet.Workflows.builder()
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
                .timezone("America/New_York")
                .build()

        val roundtrippedUserUpdateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(userUpdateResponse),
                jacksonTypeRef<UserUpdateResponse>(),
            )

        assertThat(roundtrippedUserUpdateResponse).isEqualTo(userUpdateResponse)
    }
}
