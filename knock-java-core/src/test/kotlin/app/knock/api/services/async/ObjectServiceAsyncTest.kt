// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async

import app.knock.api.TestServerExtension
import app.knock.api.client.okhttp.KnockOkHttpClientAsync
import app.knock.api.core.JsonValue
import app.knock.api.models.UnnamedSchemaWithArrayParent0
import app.knock.api.models.UnnamedSchemaWithArrayParent1
import app.knock.api.models.objects.ObjectDeleteParams
import app.knock.api.models.objects.ObjectGetParams
import app.knock.api.models.objects.ObjectListMessagesParams
import app.knock.api.models.objects.ObjectListParams
import app.knock.api.models.objects.ObjectListSchedulesParams
import app.knock.api.models.objects.ObjectSetParams
import app.knock.api.models.recipients.channeldata.PushChannelData
import app.knock.api.models.recipients.preferences.PreferenceSetChannelTypes
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
                ObjectDeleteParams.builder().collection("collection").id("id").build()
            )

        val object_ = objectFuture.get()
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
                ObjectGetParams.builder().collection("collection").id("id").build()
            )

        val object_ = objectFuture.get()
        object_.validate()
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
                ObjectListMessagesParams.builder().collection("projects").id("project-123").build()
            )

        val page = pageFuture.get()
        page.response().validate()
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
                ObjectListSchedulesParams.builder().collection("collection").id("id").build()
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
                    .id("id")
                    .addChannelData(
                        UnnamedSchemaWithArrayParent0.builder()
                            .channelId("97c5837d-c65c-4d54-aa39-080eeb81c69d")
                            .data(
                                PushChannelData.builder()
                                    ._typename(PushChannelData._Typename.PUSH_CHANNEL_DATA)
                                    .addToken("push_token_123")
                                    .build()
                            )
                            .provider("push_fcm")
                            .build()
                    )
                    .locale("en-US")
                    .addPreference(
                        UnnamedSchemaWithArrayParent1.builder()
                            .id("default")
                            .categories(
                                UnnamedSchemaWithArrayParent1.Categories.builder()
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
                                                            "argument" to "some_property",
                                                            "operator" to "equal_to",
                                                            "variable" to "recipient.property",
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
                    .timezone("America/New_York")
                    .build()
            )

        val object_ = objectFuture.get()
        object_.validate()
    }
}
