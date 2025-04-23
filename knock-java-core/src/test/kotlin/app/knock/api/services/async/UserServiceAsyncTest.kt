// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async

import app.knock.api.TestServerExtension
import app.knock.api.client.okhttp.KnockOkHttpClientAsync
import app.knock.api.core.JsonValue
import app.knock.api.models.UnnamedSchemaWithArrayParent0
import app.knock.api.models.UnnamedSchemaWithArrayParent1
import app.knock.api.models.recipients.channeldata.ChannelDataRequest
import app.knock.api.models.recipients.channeldata.PushChannelData
import app.knock.api.models.recipients.preferences.PreferenceSetChannelTypes
import app.knock.api.models.recipients.preferences.PreferenceSetRequest
import app.knock.api.models.users.IdentifyUserRequest
import app.knock.api.models.users.UserDeleteParams
import app.knock.api.models.users.UserGetChannelDataParams
import app.knock.api.models.users.UserGetParams
import app.knock.api.models.users.UserGetPreferencesParams
import app.knock.api.models.users.UserListMessagesParams
import app.knock.api.models.users.UserListPreferencesParams
import app.knock.api.models.users.UserListSchedulesParams
import app.knock.api.models.users.UserListSubscriptionsParams
import app.knock.api.models.users.UserMergeParams
import app.knock.api.models.users.UserSetChannelDataParams
import app.knock.api.models.users.UserSetPreferencesParams
import app.knock.api.models.users.UserUnsetChannelDataParams
import app.knock.api.models.users.UserUpdateParams
import java.time.OffsetDateTime
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class UserServiceAsyncTest {

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun update() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val userServiceAsync = client.users()

        val userFuture =
            userServiceAsync.update(
                UserUpdateParams.builder()
                    .userId("user_id")
                    .identifyUserRequest(
                        IdentifyUserRequest.builder()
                            .avatar("avatar")
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
                            .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .email("jane@ingen.net")
                            .locale("locale")
                            .name("Jane Doe")
                            .phoneNumber("phone_number")
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
                                                                    "variable" to
                                                                        "recipient.property",
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
                            .timezone("America/New_York")
                            .build()
                    )
                    .build()
            )

        val user = userFuture.get()
        user.validate()
    }

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
        val userServiceAsync = client.users()

        val pageFuture = userServiceAsync.list()

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
        val userServiceAsync = client.users()

        val userFuture =
            userServiceAsync.delete(UserDeleteParams.builder().userId("user_id").build())

        val user = userFuture.get()
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
        val userServiceAsync = client.users()

        val userFuture = userServiceAsync.get(UserGetParams.builder().userId("user_id").build())

        val user = userFuture.get()
        user.validate()
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
        val userServiceAsync = client.users()

        val channelDataFuture =
            userServiceAsync.getChannelData(
                UserGetChannelDataParams.builder()
                    .userId("user_id")
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
        val userServiceAsync = client.users()

        val preferenceSetFuture =
            userServiceAsync.getPreferences(
                UserGetPreferencesParams.builder()
                    .userId("user_id")
                    .id("default")
                    .tenant("tenant")
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
        val userServiceAsync = client.users()

        val pageFuture =
            userServiceAsync.listMessages(
                UserListMessagesParams.builder().userId("user-123").build()
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
        val userServiceAsync = client.users()

        val preferenceSetsFuture =
            userServiceAsync.listPreferences(
                UserListPreferencesParams.builder().userId("user_id").build()
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
        val userServiceAsync = client.users()

        val pageFuture =
            userServiceAsync.listSchedules(
                UserListSchedulesParams.builder().userId("user_id").build()
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
        val userServiceAsync = client.users()

        val pageFuture =
            userServiceAsync.listSubscriptions(
                UserListSubscriptionsParams.builder().userId("user_id").build()
            )

        val page = pageFuture.get()
        page.response().validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun merge() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val userServiceAsync = client.users()

        val userFuture =
            userServiceAsync.merge(
                UserMergeParams.builder().userId("user_id").fromUserId("user_1").build()
            )

        val user = userFuture.get()
        user.validate()
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
        val userServiceAsync = client.users()

        val channelDataFuture =
            userServiceAsync.setChannelData(
                UserSetChannelDataParams.builder()
                    .userId("user_id")
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
        val userServiceAsync = client.users()

        val preferenceSetFuture =
            userServiceAsync.setPreferences(
                UserSetPreferencesParams.builder()
                    .userId("user_id")
                    .id("default")
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
        val userServiceAsync = client.users()

        val responseFuture =
            userServiceAsync.unsetChannelData(
                UserUnsetChannelDataParams.builder()
                    .userId("user_id")
                    .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val response = responseFuture.get()
    }
}
