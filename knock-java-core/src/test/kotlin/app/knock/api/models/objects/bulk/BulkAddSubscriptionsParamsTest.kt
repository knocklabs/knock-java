// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects.bulk

import app.knock.api.core.JsonValue
import app.knock.api.models.UnnamedSchemaWithArrayParent0
import app.knock.api.models.recipients.channeldata.PushChannelData
import app.knock.api.models.recipients.preferences.InlinePreferenceSetRequest
import app.knock.api.models.recipients.preferences.PreferenceSetChannelTypeSetting
import app.knock.api.models.recipients.preferences.PreferenceSetChannelTypes
import app.knock.api.models.shared.Condition
import app.knock.api.models.users.InlineIdentifyUserRequest
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BulkAddSubscriptionsParamsTest {

    @Test
    fun create() {
        BulkAddSubscriptionsParams.builder()
            .collection("projects")
            .addSubscription(
                BulkAddSubscriptionsParams.Subscription.builder()
                    .addRecipient(
                        InlineIdentifyUserRequest.builder()
                            .id("user_1")
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
                                                                    "variable" to
                                                                        "specimen.dna_sequence",
                                                                )
                                                            ),
                                                    )
                                                ),
                                            )
                                            .putAdditionalProperty(
                                                "transactional",
                                                JsonValue.from(true),
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
                                                                    "variable" to
                                                                        "specimen.dna_sequence",
                                                                )
                                                            ),
                                                    )
                                                ),
                                            )
                                            .putAdditionalProperty(
                                                "welcome-sequence",
                                                JsonValue.from(true),
                                            )
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .properties(
                        BulkAddSubscriptionsParams.Subscription.Properties.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .build()
            )
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            BulkAddSubscriptionsParams.builder()
                .collection("projects")
                .addSubscription(
                    BulkAddSubscriptionsParams.Subscription.builder()
                        .addRecipient(InlineIdentifyUserRequest.builder().id("user_1").build())
                        .build()
                )
                .build()

        assertThat(params._pathParam(0)).isEqualTo("projects")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            BulkAddSubscriptionsParams.builder()
                .collection("projects")
                .addSubscription(
                    BulkAddSubscriptionsParams.Subscription.builder()
                        .addRecipient(
                            InlineIdentifyUserRequest.builder()
                                .id("user_1")
                                .addChannelData(
                                    UnnamedSchemaWithArrayParent0.builder()
                                        .channelId("97c5837d-c65c-4d54-aa39-080eeb81c69d")
                                        .data(
                                            PushChannelData.builder()
                                                .addToken("push_token_xxx")
                                                .type(PushChannelData.Type.PUSH_FCM)
                                                ._typename(
                                                    PushChannelData._Typename.PUSH_CHANNEL_DATA
                                                )
                                                .build()
                                        )
                                        .provider("push_fcm")
                                        .build()
                                )
                                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
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
                                                                        "variable" to
                                                                            "specimen.dna_sequence",
                                                                    )
                                                                ),
                                                        )
                                                    ),
                                                )
                                                .putAdditionalProperty(
                                                    "transactional",
                                                    JsonValue.from(true),
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
                                                                        "variable" to
                                                                            "specimen.dna_sequence",
                                                                    )
                                                                ),
                                                        )
                                                    ),
                                                )
                                                .putAdditionalProperty(
                                                    "welcome-sequence",
                                                    JsonValue.from(true),
                                                )
                                                .build()
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .properties(
                            BulkAddSubscriptionsParams.Subscription.Properties.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.subscriptions())
            .containsExactly(
                BulkAddSubscriptionsParams.Subscription.builder()
                    .addRecipient(
                        InlineIdentifyUserRequest.builder()
                            .id("user_1")
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
                                                                    "variable" to
                                                                        "specimen.dna_sequence",
                                                                )
                                                            ),
                                                    )
                                                ),
                                            )
                                            .putAdditionalProperty(
                                                "transactional",
                                                JsonValue.from(true),
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
                                                                    "variable" to
                                                                        "specimen.dna_sequence",
                                                                )
                                                            ),
                                                    )
                                                ),
                                            )
                                            .putAdditionalProperty(
                                                "welcome-sequence",
                                                JsonValue.from(true),
                                            )
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .properties(
                        BulkAddSubscriptionsParams.Subscription.Properties.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            BulkAddSubscriptionsParams.builder()
                .collection("projects")
                .addSubscription(
                    BulkAddSubscriptionsParams.Subscription.builder()
                        .addRecipient(InlineIdentifyUserRequest.builder().id("user_1").build())
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.subscriptions())
            .containsExactly(
                BulkAddSubscriptionsParams.Subscription.builder()
                    .addRecipient(InlineIdentifyUserRequest.builder().id("user_1").build())
                    .build()
            )
    }
}
