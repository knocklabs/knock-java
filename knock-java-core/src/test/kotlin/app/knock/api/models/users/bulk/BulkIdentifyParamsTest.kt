// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users.bulk

import app.knock.api.core.JsonValue
import app.knock.api.models.Condition
import app.knock.api.models.UnnamedSchemaWithArrayParent0
import app.knock.api.models.UnnamedSchemaWithArrayParent1
import app.knock.api.models.recipients.channeldata.PushChannelData
import app.knock.api.models.recipients.preferences.PreferenceSetChannelTypeSetting
import app.knock.api.models.recipients.preferences.PreferenceSetChannelTypes
import app.knock.api.models.users.InlineIdentifyUserRequest
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BulkIdentifyParamsTest {

    @Test
    fun create() {
        BulkIdentifyParams.builder()
            .addUser(
                InlineIdentifyUserRequest.builder()
                    .id("user_1")
                    .addChannelData(
                        UnnamedSchemaWithArrayParent0.builder()
                            .channelId("97c5837d-c65c-4d54-aa39-080eeb81c69d")
                            .data(
                                PushChannelData.builder()
                                    ._typename(PushChannelData._Typename.PUSH_CHANNEL_DATA)
                                    .addToken("push_token_xxx")
                                    .build()
                            )
                            .build()
                    )
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .addPreference(
                        UnnamedSchemaWithArrayParent1.builder()
                            .id("default")
                            .categories(
                                UnnamedSchemaWithArrayParent1.Categories
                                    .PreferenceSetWorkflowCategorySettingObject
                                    .builder()
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
                                    .addCondition(
                                        Condition.builder()
                                            .argument("some_property")
                                            .operator(Condition.Operator.EQUAL_TO)
                                            .variable("recipient.property")
                                            .build()
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
    fun body() {
        val params =
            BulkIdentifyParams.builder()
                .addUser(
                    InlineIdentifyUserRequest.builder()
                        .id("user_1")
                        .addChannelData(
                            UnnamedSchemaWithArrayParent0.builder()
                                .channelId("97c5837d-c65c-4d54-aa39-080eeb81c69d")
                                .data(
                                    PushChannelData.builder()
                                        ._typename(PushChannelData._Typename.PUSH_CHANNEL_DATA)
                                        .addToken("push_token_xxx")
                                        .build()
                                )
                                .build()
                        )
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .addPreference(
                            UnnamedSchemaWithArrayParent1.builder()
                                .id("default")
                                .categories(
                                    UnnamedSchemaWithArrayParent1.Categories
                                        .PreferenceSetWorkflowCategorySettingObject
                                        .builder()
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
                                                                .operator(
                                                                    Condition.Operator.EQUAL_TO
                                                                )
                                                                .variable("recipient.country_code")
                                                                .build()
                                                        )
                                                        .build()
                                                )
                                                .build()
                                        )
                                        .addCondition(
                                            Condition.builder()
                                                .argument("some_property")
                                                .operator(Condition.Operator.EQUAL_TO)
                                                .variable("recipient.property")
                                                .build()
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

        assertThat(body.users())
            .containsExactly(
                InlineIdentifyUserRequest.builder()
                    .id("user_1")
                    .addChannelData(
                        UnnamedSchemaWithArrayParent0.builder()
                            .channelId("97c5837d-c65c-4d54-aa39-080eeb81c69d")
                            .data(
                                PushChannelData.builder()
                                    ._typename(PushChannelData._Typename.PUSH_CHANNEL_DATA)
                                    .addToken("push_token_xxx")
                                    .build()
                            )
                            .build()
                    )
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .addPreference(
                        UnnamedSchemaWithArrayParent1.builder()
                            .id("default")
                            .categories(
                                UnnamedSchemaWithArrayParent1.Categories
                                    .PreferenceSetWorkflowCategorySettingObject
                                    .builder()
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
                                    .addCondition(
                                        Condition.builder()
                                            .argument("some_property")
                                            .operator(Condition.Operator.EQUAL_TO)
                                            .variable("recipient.property")
                                            .build()
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
            BulkIdentifyParams.builder()
                .addUser(InlineIdentifyUserRequest.builder().id("user_1").build())
                .build()

        val body = params._body()

        assertThat(body.users())
            .containsExactly(InlineIdentifyUserRequest.builder().id("user_1").build())
    }
}
