// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.core.JsonValue
import app.knock.api.core.jsonMapper
import app.knock.api.models.UnnamedSchemaWithArrayParent0
import app.knock.api.models.recipients.channeldata.PushChannelData
import app.knock.api.models.recipients.preferences.InlinePreferenceSetRequest
import app.knock.api.models.recipients.preferences.PreferenceSetChannelTypeSetting
import app.knock.api.models.recipients.preferences.PreferenceSetChannelTypes
import app.knock.api.models.shared.Condition
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class IdentifyUserRequestTest {

    @Test
    fun create() {
        val identifyUserRequest =
            IdentifyUserRequest.builder()
                .avatar("avatar")
                .addChannelData(
                    UnnamedSchemaWithArrayParent0.builder()
                        .channelId("97c5837d-c65c-4d54-aa39-080eeb81c69d")
                        .data(
                            PushChannelData.builder()
                                .addToken("push_token_123")
                                .type(PushChannelData.Type.PUSH_FCM)
                                ._typename(PushChannelData._Typename.PUSH_CHANNEL_DATA)
                                .build()
                        )
                        .provider("push_fcm")
                        .build()
                )
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .email("ian.malcolm@chaos.theory")
                .locale("locale")
                .name("Dr. Ian Malcolm")
                .phoneNumber("phone_number")
                .preferences(
                    InlinePreferenceSetRequest.builder()
                        .id("id")
                        .categories(
                            InlinePreferenceSetRequest.Categories.builder()
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
                                                        "argument" to "frog_genome",
                                                        "operator" to "contains",
                                                        "variable" to "specimen.dna_sequence",
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
                            InlinePreferenceSetRequest.Workflows.builder()
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
                                .putAdditionalProperty("welcome-sequence", JsonValue.from(true))
                                .build()
                        )
                        .build()
                )
                .timezone("America/New_York")
                .build()

        assertThat(identifyUserRequest.avatar()).contains("avatar")
        assertThat(identifyUserRequest.channelData().getOrNull())
            .containsExactly(
                UnnamedSchemaWithArrayParent0.builder()
                    .channelId("97c5837d-c65c-4d54-aa39-080eeb81c69d")
                    .data(
                        PushChannelData.builder()
                            .addToken("push_token_123")
                            .type(PushChannelData.Type.PUSH_FCM)
                            ._typename(PushChannelData._Typename.PUSH_CHANNEL_DATA)
                            .build()
                    )
                    .provider("push_fcm")
                    .build()
            )
        assertThat(identifyUserRequest.createdAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(identifyUserRequest.email()).contains("ian.malcolm@chaos.theory")
        assertThat(identifyUserRequest.locale()).contains("locale")
        assertThat(identifyUserRequest.name()).contains("Dr. Ian Malcolm")
        assertThat(identifyUserRequest.phoneNumber()).contains("phone_number")
        assertThat(identifyUserRequest.preferences())
            .contains(
                InlinePreferenceSetRequest.builder()
                    .id("id")
                    .categories(
                        InlinePreferenceSetRequest.Categories.builder()
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
                                                    "argument" to "frog_genome",
                                                    "operator" to "contains",
                                                    "variable" to "specimen.dna_sequence",
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
                        InlinePreferenceSetRequest.Workflows.builder()
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
                            .putAdditionalProperty("welcome-sequence", JsonValue.from(true))
                            .build()
                    )
                    .build()
            )
        assertThat(identifyUserRequest.timezone()).contains("America/New_York")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val identifyUserRequest =
            IdentifyUserRequest.builder()
                .avatar("avatar")
                .addChannelData(
                    UnnamedSchemaWithArrayParent0.builder()
                        .channelId("97c5837d-c65c-4d54-aa39-080eeb81c69d")
                        .data(
                            PushChannelData.builder()
                                .addToken("push_token_123")
                                .type(PushChannelData.Type.PUSH_FCM)
                                ._typename(PushChannelData._Typename.PUSH_CHANNEL_DATA)
                                .build()
                        )
                        .provider("push_fcm")
                        .build()
                )
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .email("ian.malcolm@chaos.theory")
                .locale("locale")
                .name("Dr. Ian Malcolm")
                .phoneNumber("phone_number")
                .preferences(
                    InlinePreferenceSetRequest.builder()
                        .id("id")
                        .categories(
                            InlinePreferenceSetRequest.Categories.builder()
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
                                                        "argument" to "frog_genome",
                                                        "operator" to "contains",
                                                        "variable" to "specimen.dna_sequence",
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
                            InlinePreferenceSetRequest.Workflows.builder()
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
                                .putAdditionalProperty("welcome-sequence", JsonValue.from(true))
                                .build()
                        )
                        .build()
                )
                .timezone("America/New_York")
                .build()

        val roundtrippedIdentifyUserRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(identifyUserRequest),
                jacksonTypeRef<IdentifyUserRequest>(),
            )

        assertThat(roundtrippedIdentifyUserRequest).isEqualTo(identifyUserRequest)
    }
}
