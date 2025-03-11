// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.async

import com.knock.api.TestServerExtension
import com.knock.api.client.okhttp.KnockOkHttpClientAsync
import com.knock.api.core.JsonValue
import com.knock.api.models.recipients.ChannelDataRequest
import com.knock.api.models.recipients.InlineChannelDataRequest
import com.knock.api.models.recipients.InlinePreferenceSetRequest
import com.knock.api.models.recipients.PreferenceSetChannelTypes
import com.knock.api.models.recipients.PreferenceSetRequest
import com.knock.api.models.recipients.PushChannelData
import com.knock.api.models.users.IdentifyUserRequest
import com.knock.api.models.users.UserDeleteParams
import com.knock.api.models.users.UserGetChannelDataParams
import com.knock.api.models.users.UserGetParams
import com.knock.api.models.users.UserGetPreferencesParams
import com.knock.api.models.users.UserListMessagesParams
import com.knock.api.models.users.UserListPreferencesParams
import com.knock.api.models.users.UserListSchedulesParams
import com.knock.api.models.users.UserListSubscriptionsParams
import com.knock.api.models.users.UserMergeParams
import com.knock.api.models.users.UserSetChannelDataParams
import com.knock.api.models.users.UserSetPreferencesParams
import com.knock.api.models.users.UserUnsetChannelDataParams
import com.knock.api.models.users.UserUpdateParams
import java.time.OffsetDateTime
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class UserServiceAsyncTest {

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
                    .preferenceSetId("default")
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
                            .data(PushChannelData.builder().addToken("push_token_1").build())
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
                                    .chat(PreferenceSetChannelTypes.Chat.ofBool(true))
                                    .email(PreferenceSetChannelTypes.Email.ofBool(true))
                                    .http(PreferenceSetChannelTypes.Http.ofBool(true))
                                    .inAppFeed(PreferenceSetChannelTypes.InAppFeed.ofBool(true))
                                    .push(PreferenceSetChannelTypes.Push.ofBool(true))
                                    .sms(PreferenceSetChannelTypes.Sms.ofBool(true))
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
