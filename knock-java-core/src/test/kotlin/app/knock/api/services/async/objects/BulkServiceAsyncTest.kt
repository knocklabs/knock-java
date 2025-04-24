// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async.objects

import app.knock.api.TestServerExtension
import app.knock.api.client.okhttp.KnockOkHttpClientAsync
import app.knock.api.core.JsonValue
import app.knock.api.models.UnnamedSchemaWithArrayParent0
import app.knock.api.models.objects.InlineObjectRequest
import app.knock.api.models.objects.bulk.BulkAddSubscriptionsParams
import app.knock.api.models.objects.bulk.BulkDeleteParams
import app.knock.api.models.objects.bulk.BulkSetParams
import app.knock.api.models.recipients.channeldata.PushChannelData
import app.knock.api.models.recipients.preferences.InlinePreferenceSetRequest
import app.knock.api.models.recipients.preferences.PreferenceSetChannelTypeSetting
import app.knock.api.models.recipients.preferences.PreferenceSetChannelTypes
import app.knock.api.models.shared.Condition
import app.knock.api.models.users.InlineIdentifyUserRequest
import java.time.OffsetDateTime
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class BulkServiceAsyncTest {

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun delete() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val bulkServiceAsync = client.objects().bulk()

        val bulkOperationFuture =
            bulkServiceAsync.delete(
                BulkDeleteParams.builder()
                    .collection("collection")
                    .objectIds(listOf("obj_123", "obj_456", "obj_789"))
                    .build()
            )

        val bulkOperation = bulkOperationFuture.get()
        bulkOperation.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun addSubscriptions() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val bulkServiceAsync = client.objects().bulk()

        val bulkOperationFuture =
            bulkServiceAsync.addSubscriptions(
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
                                                                            "argument" to
                                                                                "frog_genome",
                                                                            "operator" to
                                                                                "contains",
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
                                                                    .variable(
                                                                        "recipient.country_code"
                                                                    )
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
                                                                            "argument" to
                                                                                "frog_genome",
                                                                            "operator" to
                                                                                "contains",
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
            )

        val bulkOperation = bulkOperationFuture.get()
        bulkOperation.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun set() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val bulkServiceAsync = client.objects().bulk()

        val bulkOperationFuture =
            bulkServiceAsync.set(
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
                    .build()
            )

        val bulkOperation = bulkOperationFuture.get()
        bulkOperation.validate()
    }
}
