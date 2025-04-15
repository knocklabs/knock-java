// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking

import app.knock.api.TestServerExtension
import app.knock.api.client.okhttp.KnockOkHttpClient
import app.knock.api.core.JsonValue
import app.knock.api.models.objects.ObjectAddSubscriptionsParams
import app.knock.api.models.objects.ObjectDeleteSubscriptionsParams
import app.knock.api.models.objects.ObjectGetChannelDataParams
import app.knock.api.models.objects.ObjectListParams
import app.knock.api.models.objects.ObjectListSubscriptionsParams
import app.knock.api.models.objects.ObjectSetChannelDataParams
import app.knock.api.models.objects.ObjectUnsetChannelDataParams
import app.knock.api.models.recipients.channeldata.InlineChannelDataRequest
import app.knock.api.models.recipients.preferences.InlinePreferenceSetRequest
import app.knock.api.models.users.InlineIdentifyUserRequest
import java.time.OffsetDateTime
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ObjectServiceTest {

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun list() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val objectService = client.objects()

        val page = objectService.list(ObjectListParams.builder().collection("collection").build())

        page.response().validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun addSubscriptions() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val objectService = client.objects()

        val subscriptions =
            objectService.addSubscriptions(
                ObjectAddSubscriptionsParams.builder()
                    .collection("collection")
                    .objectId("object_id")
                    .addRecipient("user_1")
                    .addRecipient("user_2")
                    .properties(
                        ObjectAddSubscriptionsParams.Properties.builder()
                            .putAdditionalProperty("key", JsonValue.from("bar"))
                            .build()
                    )
                    .build()
            )

        subscriptions.forEach { it.validate() }
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun deleteSubscriptions() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val objectService = client.objects()

        val subscriptions =
            objectService.deleteSubscriptions(
                ObjectDeleteSubscriptionsParams.builder()
                    .collection("collection")
                    .objectId("object_id")
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
                    .build()
            )

        subscriptions.forEach { it.validate() }
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun getChannelData() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val objectService = client.objects()

        val channelData =
            objectService.getChannelData(
                ObjectGetChannelDataParams.builder()
                    .collection("collection")
                    .objectId("object_id")
                    .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        channelData.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun listSubscriptions() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val objectService = client.objects()

        val page =
            objectService.listSubscriptions(
                ObjectListSubscriptionsParams.builder()
                    .collection("collection")
                    .objectId("object_id")
                    .build()
            )

        page.response().validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun setChannelData() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val objectService = client.objects()

        val channelData =
            objectService.setChannelData(
                ObjectSetChannelDataParams.builder()
                    .collection("collection")
                    .objectId("object_id")
                    .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        channelData.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun unsetChannelData() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val objectService = client.objects()

        objectService.unsetChannelData(
            ObjectUnsetChannelDataParams.builder()
                .collection("collection")
                .objectId("object_id")
                .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()
        )
    }
}
