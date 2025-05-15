// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking.objects

import app.knock.api.TestServerExtension
import app.knock.api.client.okhttp.KnockOkHttpClient
import app.knock.api.core.JsonValue
import app.knock.api.models.objects.InlineObjectRequest
import app.knock.api.models.objects.bulk.BulkAddSubscriptionsParams
import app.knock.api.models.objects.bulk.BulkDeleteParams
import app.knock.api.models.objects.bulk.BulkSetParams
import app.knock.api.models.recipients.channeldata.InlineChannelDataRequest
import app.knock.api.models.recipients.preferences.InlinePreferenceSetRequest
import app.knock.api.models.users.InlineIdentifyUserRequest
import java.time.OffsetDateTime
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class BulkServiceTest {

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun delete() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val bulkService = client.objects().bulk()

        val bulkOperation =
            bulkService.delete(
                BulkDeleteParams.builder()
                    .collection("collection")
                    .objectIds(listOf("obj_123", "obj_456", "obj_789"))
                    .build()
            )

        bulkOperation.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun addSubscriptions() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val bulkService = client.objects().bulk()

        val bulkOperation =
            bulkService.addSubscriptions(
                BulkAddSubscriptionsParams.builder()
                    .collection("projects")
                    .addSubscription(
                        BulkAddSubscriptionsParams.Subscription.builder()
                            .addRecipient(
                                InlineIdentifyUserRequest.builder()
                                    .id("user_1")
                                    .avatar("avatar")
                                    .channelData(
                                        InlineChannelDataRequest.builder()
                                            .putAdditionalProperty(
                                                "97c5837d-c65c-4d54-aa39-080eeb81c69d",
                                                JsonValue.from(
                                                    mapOf("tokens" to listOf("push_token_xxx"))
                                                ),
                                            )
                                            .build()
                                    )
                                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                    .email("email")
                                    .locale("locale")
                                    .name("name")
                                    .phoneNumber("phone_number")
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
                                                                                "in_app_feed" to
                                                                                    true,
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
                                                                                "email" to false,
                                                                                "http" to true,
                                                                                "in_app_feed" to
                                                                                    true,
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
                                                                    ),
                                                                "welcome-sequence" to true,
                                                            ),
                                                    )
                                                ),
                                            )
                                            .build()
                                    )
                                    .timezone("timezone")
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

        bulkOperation.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun set() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val bulkService = client.objects().bulk()

        val bulkOperation =
            bulkService.set(
                BulkSetParams.builder()
                    .collection("collection")
                    .addObject(
                        InlineObjectRequest.builder()
                            .id("project_1")
                            .collection("projects")
                            .channelData(
                                InlineChannelDataRequest.builder()
                                    .putAdditionalProperty(
                                        "97c5837d-c65c-4d54-aa39-080eeb81c69d",
                                        JsonValue.from(mapOf("tokens" to listOf("push_token_xxx"))),
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
                                                                                "frog_genome",
                                                                            "operator" to
                                                                                "contains",
                                                                            "variable" to
                                                                                "specimen.dna_sequence",
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
                                                            ),
                                                        "welcome-sequence" to true,
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

        bulkOperation.validate()
    }
}
