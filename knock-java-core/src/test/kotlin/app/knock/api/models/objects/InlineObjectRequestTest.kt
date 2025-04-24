// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

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

internal class InlineObjectRequestTest {

    @Test
    fun create() {
        val inlineObjectRequest =
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
                .build()

        assertThat(inlineObjectRequest.id()).isEqualTo("project_1")
        assertThat(inlineObjectRequest.collection()).isEqualTo("projects")
        assertThat(inlineObjectRequest.channelData().getOrNull())
            .containsExactly(
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
        assertThat(inlineObjectRequest.createdAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(inlineObjectRequest.preferences().getOrNull())
            .containsExactly(
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
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inlineObjectRequest =
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
                .build()

        val roundtrippedInlineObjectRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inlineObjectRequest),
                jacksonTypeRef<InlineObjectRequest>(),
            )

        assertThat(roundtrippedInlineObjectRequest).isEqualTo(inlineObjectRequest)
    }
}
