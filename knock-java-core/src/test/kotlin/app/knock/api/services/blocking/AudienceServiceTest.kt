// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking

import app.knock.api.TestServerExtension
import app.knock.api.client.okhttp.KnockOkHttpClient
import app.knock.api.core.JsonValue
import app.knock.api.models.Condition
import app.knock.api.models.UnnamedSchemaWithArrayParent0
import app.knock.api.models.UnnamedSchemaWithArrayParent1
import app.knock.api.models.audiences.AudienceAddMembersParams
import app.knock.api.models.audiences.AudienceListMembersParams
import app.knock.api.models.audiences.AudienceRemoveMembersParams
import app.knock.api.models.recipients.channeldata.PushChannelData
import app.knock.api.models.recipients.preferences.PreferenceSetChannelTypeSetting
import app.knock.api.models.recipients.preferences.PreferenceSetChannelTypes
import app.knock.api.models.users.InlineIdentifyUserRequest
import java.time.OffsetDateTime
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class AudienceServiceTest {

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun addMembers() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val audienceService = client.audiences()

        audienceService.addMembers(
            AudienceAddMembersParams.builder()
                .key("key")
                .addMember(
                    AudienceAddMembersParams.Member.builder()
                        .user(
                            InlineIdentifyUserRequest.builder()
                                .id("user_1")
                                .addChannelData(
                                    UnnamedSchemaWithArrayParent0.builder()
                                        .channelId("97c5837d-c65c-4d54-aa39-080eeb81c69d")
                                        .data(
                                            PushChannelData.builder()
                                                ._typename(
                                                    PushChannelData._Typename.PUSH_CHANNEL_DATA
                                                )
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
                                                            PreferenceSetChannelTypeSetting
                                                                .builder()
                                                                .addCondition(
                                                                    Condition.builder()
                                                                        .argument("US")
                                                                        .operator(
                                                                            Condition.Operator
                                                                                .EQUAL_TO
                                                                        )
                                                                        .variable(
                                                                            "recipient.country_code"
                                                                        )
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
                                                                        "argument" to
                                                                            "some_property",
                                                                        "operator" to "equal_to",
                                                                        "variable" to
                                                                            "recipient.property",
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
                        .tenant(null)
                        .build()
                )
                .build()
        )
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun listMembers() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val audienceService = client.audiences()

        val response =
            audienceService.listMembers(AudienceListMembersParams.builder().key("key").build())

        response.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun removeMembers() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val audienceService = client.audiences()

        audienceService.removeMembers(
            AudienceRemoveMembersParams.builder()
                .key("key")
                .addMember(
                    AudienceRemoveMembersParams.Member.builder()
                        .user(
                            InlineIdentifyUserRequest.builder()
                                .id("user_1")
                                .addChannelData(
                                    UnnamedSchemaWithArrayParent0.builder()
                                        .channelId("97c5837d-c65c-4d54-aa39-080eeb81c69d")
                                        .data(
                                            PushChannelData.builder()
                                                ._typename(
                                                    PushChannelData._Typename.PUSH_CHANNEL_DATA
                                                )
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
                                                            PreferenceSetChannelTypeSetting
                                                                .builder()
                                                                .addCondition(
                                                                    Condition.builder()
                                                                        .argument("US")
                                                                        .operator(
                                                                            Condition.Operator
                                                                                .EQUAL_TO
                                                                        )
                                                                        .variable(
                                                                            "recipient.country_code"
                                                                        )
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
                                                                        "argument" to
                                                                            "some_property",
                                                                        "operator" to "equal_to",
                                                                        "variable" to
                                                                            "recipient.property",
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
                        .tenant(null)
                        .build()
                )
                .build()
        )
    }
}
