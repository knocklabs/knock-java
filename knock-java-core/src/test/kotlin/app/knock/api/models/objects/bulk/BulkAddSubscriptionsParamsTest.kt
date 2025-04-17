// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects.bulk

import app.knock.api.core.JsonValue
import app.knock.api.models.recipients.channeldata.InlineChannelDataRequest
import app.knock.api.models.recipients.preferences.InlinePreferenceSetRequest
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
                    .id("project-1")
                    .addRecipient(
                        InlineIdentifyUserRequest.builder()
                            .id("user_1")
                            .channelData(
                                InlineChannelDataRequest.builder()
                                    .putAdditionalProperty(
                                        "97c5837d-c65c-4d54-aa39-080eeb81c69d",
                                        JsonValue.from(
                                            mapOf(
                                                "data" to
                                                    mapOf("tokens" to listOf("push_token_xxx"))
                                            )
                                        ),
                                    )
                                    .build()
                            )
                            .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .preferences(
                                InlinePreferenceSetRequest.builder()
                                    .putAdditionalProperty(
                                        "default",
                                        JsonValue.from(
                                            mapOf(
                                                "categories" to
                                                    mapOf(
                                                        "transactional" to
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
                                                                            "argument" to
                                                                                "some_property",
                                                                            "operator" to
                                                                                "equal_to",
                                                                            "variable" to
                                                                                "recipient.property",
                                                                        )
                                                                    ),
                                                            )
                                                    ),
                                                "channel_types" to
                                                    mapOf(
                                                        "chat" to true,
                                                        "email" to true,
                                                        "http" to true,
                                                        "in_app_feed" to true,
                                                        "push" to true,
                                                        "sms" to true,
                                                    ),
                                                "workflows" to
                                                    mapOf(
                                                        "dinosaurs-loose" to
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
                                                                            "operator" to
                                                                                "equal_to",
                                                                            "variable" to
                                                                                "recipient.property",
                                                                        )
                                                                    ),
                                                            )
                                                    ),
                                            )
                                        ),
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
                        .id("project-1")
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
                        .id("project-1")
                        .addRecipient(
                            InlineIdentifyUserRequest.builder()
                                .id("user_1")
                                .channelData(
                                    InlineChannelDataRequest.builder()
                                        .putAdditionalProperty(
                                            "97c5837d-c65c-4d54-aa39-080eeb81c69d",
                                            JsonValue.from(
                                                mapOf(
                                                    "data" to
                                                        mapOf("tokens" to listOf("push_token_xxx"))
                                                )
                                            ),
                                        )
                                        .build()
                                )
                                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .preferences(
                                    InlinePreferenceSetRequest.builder()
                                        .putAdditionalProperty(
                                            "default",
                                            JsonValue.from(
                                                mapOf(
                                                    "categories" to
                                                        mapOf(
                                                            "transactional" to
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
                                                                                "argument" to
                                                                                    "some_property",
                                                                                "operator" to
                                                                                    "equal_to",
                                                                                "variable" to
                                                                                    "recipient.property",
                                                                            )
                                                                        ),
                                                                )
                                                        ),
                                                    "channel_types" to
                                                        mapOf(
                                                            "chat" to true,
                                                            "email" to true,
                                                            "http" to true,
                                                            "in_app_feed" to true,
                                                            "push" to true,
                                                            "sms" to true,
                                                        ),
                                                    "workflows" to
                                                        mapOf(
                                                            "dinosaurs-loose" to
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
                                                                                "operator" to
                                                                                    "equal_to",
                                                                                "variable" to
                                                                                    "recipient.property",
                                                                            )
                                                                        ),
                                                                )
                                                        ),
                                                )
                                            ),
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
                    .id("project-1")
                    .addRecipient(
                        InlineIdentifyUserRequest.builder()
                            .id("user_1")
                            .channelData(
                                InlineChannelDataRequest.builder()
                                    .putAdditionalProperty(
                                        "97c5837d-c65c-4d54-aa39-080eeb81c69d",
                                        JsonValue.from(
                                            mapOf(
                                                "data" to
                                                    mapOf("tokens" to listOf("push_token_xxx"))
                                            )
                                        ),
                                    )
                                    .build()
                            )
                            .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .preferences(
                                InlinePreferenceSetRequest.builder()
                                    .putAdditionalProperty(
                                        "default",
                                        JsonValue.from(
                                            mapOf(
                                                "categories" to
                                                    mapOf(
                                                        "transactional" to
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
                                                                            "argument" to
                                                                                "some_property",
                                                                            "operator" to
                                                                                "equal_to",
                                                                            "variable" to
                                                                                "recipient.property",
                                                                        )
                                                                    ),
                                                            )
                                                    ),
                                                "channel_types" to
                                                    mapOf(
                                                        "chat" to true,
                                                        "email" to true,
                                                        "http" to true,
                                                        "in_app_feed" to true,
                                                        "push" to true,
                                                        "sms" to true,
                                                    ),
                                                "workflows" to
                                                    mapOf(
                                                        "dinosaurs-loose" to
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
                                                                            "operator" to
                                                                                "equal_to",
                                                                            "variable" to
                                                                                "recipient.property",
                                                                        )
                                                                    ),
                                                            )
                                                    ),
                                            )
                                        ),
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
                        .id("project-1")
                        .addRecipient(InlineIdentifyUserRequest.builder().id("user_1").build())
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.subscriptions())
            .containsExactly(
                BulkAddSubscriptionsParams.Subscription.builder()
                    .id("project-1")
                    .addRecipient(InlineIdentifyUserRequest.builder().id("user_1").build())
                    .build()
            )
    }
}
