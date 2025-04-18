// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async

import app.knock.api.TestServerExtension
import app.knock.api.client.okhttp.KnockOkHttpClientAsync
import app.knock.api.core.JsonValue
import app.knock.api.models.objects.ObjectAddSubscriptionsParams
import app.knock.api.models.objects.ObjectDeleteParams
import app.knock.api.models.objects.ObjectDeleteSubscriptionsParams
import app.knock.api.models.objects.ObjectGetChannelDataParams
import app.knock.api.models.objects.ObjectGetParams
import app.knock.api.models.objects.ObjectGetPreferencesParams
import app.knock.api.models.objects.ObjectListMessagesParams
import app.knock.api.models.objects.ObjectListParams
import app.knock.api.models.objects.ObjectListPreferencesParams
import app.knock.api.models.objects.ObjectListSchedulesParams
import app.knock.api.models.objects.ObjectListSubscriptionsParams
import app.knock.api.models.objects.ObjectSetChannelDataParams
import app.knock.api.models.objects.ObjectSetParams
import app.knock.api.models.objects.ObjectSetPreferencesParams
import app.knock.api.models.objects.ObjectUnsetChannelDataParams
import app.knock.api.models.recipients.channeldata.ChannelDataRequest
import app.knock.api.models.recipients.channeldata.InlineChannelDataRequest
import app.knock.api.models.recipients.channeldata.PushChannelData
import app.knock.api.models.recipients.preferences.InlinePreferenceSetRequest
import app.knock.api.models.recipients.preferences.PreferenceSetChannelTypes
import app.knock.api.models.recipients.preferences.PreferenceSetRequest
import app.knock.api.models.users.InlineIdentifyUserRequest
import java.time.OffsetDateTime
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ObjectServiceAsyncTest {

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun list() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val objectServiceAsync = client.objects()

        val pageFuture =
            objectServiceAsync.list(ObjectListParams.builder().collection("collection").build())

        val page = pageFuture.get()
        page.response().validate()
    }

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
        val objectServiceAsync = client.objects()

        val objectFuture =
            objectServiceAsync.delete(
                ObjectDeleteParams.builder().collection("collection").objectId("object_id").build()
            )

        val object_ = objectFuture.get()
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
        val objectServiceAsync = client.objects()

        val subscriptionsFuture =
            objectServiceAsync.addSubscriptions(
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

        val subscriptions = subscriptionsFuture.get()
        subscriptions.forEach { it.validate() }
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun deleteSubscriptions() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val objectServiceAsync = client.objects()

        val subscriptionsFuture =
            objectServiceAsync.deleteSubscriptions(
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
                                                    mapOf(
                                                        "__typename" to "PushChannelData",
                                                        "tokens" to listOf("push_token_xxx"),
                                                    )
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

        val subscriptions = subscriptionsFuture.get()
        subscriptions.forEach { it.validate() }
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun get() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val objectServiceAsync = client.objects()

        val objectFuture =
            objectServiceAsync.get(
                ObjectGetParams.builder().collection("collection").objectId("object_id").build()
            )

        val object_ = objectFuture.get()
        object_.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun getChannelData() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val objectServiceAsync = client.objects()

        val channelDataFuture =
            objectServiceAsync.getChannelData(
                ObjectGetChannelDataParams.builder()
                    .collection("collection")
                    .objectId("object_id")
                    .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val channelData = channelDataFuture.get()
        channelData.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun getPreferences() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val objectServiceAsync = client.objects()

        val preferenceSetFuture =
            objectServiceAsync.getPreferences(
                ObjectGetPreferencesParams.builder()
                    .collection("collection")
                    .objectId("object_id")
                    .preferenceSetId("default")
                    .build()
            )

        val preferenceSet = preferenceSetFuture.get()
        preferenceSet.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun listMessages() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val objectServiceAsync = client.objects()

        val pageFuture =
            objectServiceAsync.listMessages(
                ObjectListMessagesParams.builder()
                    .collection("projects")
                    .objectId("project-123")
                    .build()
            )

        val page = pageFuture.get()
        page.response().validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun listPreferences() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val objectServiceAsync = client.objects()

        val preferenceSetsFuture =
            objectServiceAsync.listPreferences(
                ObjectListPreferencesParams.builder()
                    .collection("collection")
                    .objectId("object_id")
                    .build()
            )

        val preferenceSets = preferenceSetsFuture.get()
        preferenceSets.forEach { it.validate() }
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun listSchedules() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val objectServiceAsync = client.objects()

        val pageFuture =
            objectServiceAsync.listSchedules(
                ObjectListSchedulesParams.builder()
                    .collection("collection")
                    .objectId("object_id")
                    .build()
            )

        val page = pageFuture.get()
        page.response().validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun listSubscriptions() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val objectServiceAsync = client.objects()

        val pageFuture =
            objectServiceAsync.listSubscriptions(
                ObjectListSubscriptionsParams.builder()
                    .collection("collection")
                    .objectId("object_id")
                    .build()
            )

        val page = pageFuture.get()
        page.response().validate()
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
        val objectServiceAsync = client.objects()

        val objectFuture =
            objectServiceAsync.set(
                ObjectSetParams.builder()
                    .collection("collection")
                    .objectId("object_id")
                    .channelData(
                        InlineChannelDataRequest.builder()
                            .putAdditionalProperty(
                                "97c5837d-c65c-4d54-aa39-080eeb81c69d",
                                JsonValue.from(
                                    mapOf(
                                        "data" to
                                            mapOf(
                                                "__typename" to "PushChannelData",
                                                "tokens" to listOf("push_token_xxx"),
                                            )
                                    )
                                ),
                            )
                            .build()
                    )
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
                                                                    "argument" to "some_property",
                                                                    "operator" to "equal_to",
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
                                                                    "argument" to "some_property",
                                                                    "operator" to "equal_to",
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

        val object_ = objectFuture.get()
        object_.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun setChannelData() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val objectServiceAsync = client.objects()

        val channelDataFuture =
            objectServiceAsync.setChannelData(
                ObjectSetChannelDataParams.builder()
                    .collection("collection")
                    .objectId("object_id")
                    .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .channelDataRequest(
                        ChannelDataRequest.builder()
                            .data(
                                PushChannelData.builder()
                                    ._typename(PushChannelData._Typename.PUSH_CHANNEL_DATA)
                                    .addToken("push_token_1")
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )

        val channelData = channelDataFuture.get()
        channelData.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun setPreferences() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val objectServiceAsync = client.objects()

        val preferenceSetFuture =
            objectServiceAsync.setPreferences(
                ObjectSetPreferencesParams.builder()
                    .collection("collection")
                    .objectId("object_id")
                    .preferenceSetId("default")
                    .preferenceSetRequest(
                        PreferenceSetRequest.builder()
                            .categories(
                                PreferenceSetRequest.Categories.builder()
                                    .putAdditionalProperty("marketing", JsonValue.from(false))
                                    .putAdditionalProperty(
                                        "transactional",
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
                                    .sms(true)
                                    .build()
                            )
                            .workflows(
                                PreferenceSetRequest.Workflows.builder()
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
                    .build()
            )

        val preferenceSet = preferenceSetFuture.get()
        preferenceSet.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun unsetChannelData() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val objectServiceAsync = client.objects()

        val responseFuture =
            objectServiceAsync.unsetChannelData(
                ObjectUnsetChannelDataParams.builder()
                    .collection("collection")
                    .objectId("object_id")
                    .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val response = responseFuture.get()
    }
}
