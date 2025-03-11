// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.blocking

import com.knock.api.TestServerExtension
import com.knock.api.client.okhttp.KnockOkHttpClient
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
import com.knock.api.models.users.UserListParams
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
class UserServiceTest {

    @Disabled("skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url")
    @Test
    fun update() {
      val client = KnockOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .bearerToken("My Bearer Token")
          .build()
      val userService = client.users()

      val user = userService.update(UserUpdateParams.builder()
          .userId("user_id")
          .identifyUserRequest(IdentifyUserRequest.builder()
              .channelData(InlineChannelDataRequest.builder()
                  .putAdditionalProperty("97c5837d-c65c-4d54-aa39-080eeb81c69d", JsonValue.from(mapOf("data" to mapOf("tokens" to listOf("push_token_xxx")))))
                  .build())
              .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
              .preferences(InlinePreferenceSetRequest.builder()
                  .putAdditionalProperty("default", JsonValue.from(mapOf(
                    "categories" to mapOf("transactional" to mapOf(
                      "channel_types" to mapOf(
                        "chat" to true,
                        "email" to false,
                        "http" to true,
                        "in_app_feed" to true,
                        "push" to true,
                        "sms" to true,
                      ), "conditions" to listOf(mapOf(
                        "argument" to "some_property",
                        "operator" to "equal_to",
                        "variable" to "recipient.property",
                      ))
                    )),
                    "channel_types" to mapOf(
                      "chat" to true,
                      "email" to true,
                      "http" to true,
                      "in_app_feed" to true,
                      "push" to true,
                      "sms" to true,
                    ),
                    "workflows" to mapOf("dinosaurs-loose" to mapOf(
                      "channel_types" to mapOf(
                        "chat" to true,
                        "email" to true,
                        "http" to true,
                        "in_app_feed" to true,
                        "push" to true,
                        "sms" to true,
                      ), "conditions" to listOf(mapOf(
                        "argument" to "some_property",
                        "operator" to "equal_to",
                        "variable" to "recipient.property",
                      ))
                    )),
                  )))
                  .build())
              .build())
          .build())

      user.validate()
    }

    @Disabled("skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url")
    @Test
    fun list() {
      val client = KnockOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .bearerToken("My Bearer Token")
          .build()
      val userService = client.users()

      val page = userService.list()

      page.response().validate()
    }

    @Disabled("skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url")
    @Test
    fun delete() {
      val client = KnockOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .bearerToken("My Bearer Token")
          .build()
      val userService = client.users()

      userService.delete(UserDeleteParams.builder()
          .userId("user_id")
          .build())
    }

    @Disabled("skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url")
    @Test
    fun get() {
      val client = KnockOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .bearerToken("My Bearer Token")
          .build()
      val userService = client.users()

      val user = userService.get(UserGetParams.builder()
          .userId("user_id")
          .build())

      user.validate()
    }

    @Disabled("skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url")
    @Test
    fun getChannelData() {
      val client = KnockOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .bearerToken("My Bearer Token")
          .build()
      val userService = client.users()

      val channelData = userService.getChannelData(UserGetChannelDataParams.builder()
          .userId("user_id")
          .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build())

      channelData.validate()
    }

    @Disabled("skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url")
    @Test
    fun getPreferences() {
      val client = KnockOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .bearerToken("My Bearer Token")
          .build()
      val userService = client.users()

      val preferenceSet = userService.getPreferences(UserGetPreferencesParams.builder()
          .userId("user_id")
          .preferenceSetId("default")
          .tenant("tenant")
          .build())

      preferenceSet.validate()
    }

    @Disabled("skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url")
    @Test
    fun listMessages() {
      val client = KnockOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .bearerToken("My Bearer Token")
          .build()
      val userService = client.users()

      val page = userService.listMessages(UserListMessagesParams.builder()
          .userId("user-123")
          .build())

      page.response().validate()
    }

    @Disabled("skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url")
    @Test
    fun listPreferences() {
      val client = KnockOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .bearerToken("My Bearer Token")
          .build()
      val userService = client.users()

      val preferenceSets = userService.listPreferences(UserListPreferencesParams.builder()
          .userId("user_id")
          .build())

      preferenceSets.forEach { it.validate() }
    }

    @Disabled("skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url")
    @Test
    fun listSchedules() {
      val client = KnockOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .bearerToken("My Bearer Token")
          .build()
      val userService = client.users()

      val page = userService.listSchedules(UserListSchedulesParams.builder()
          .userId("user_id")
          .build())

      page.response().validate()
    }

    @Disabled("skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url")
    @Test
    fun listSubscriptions() {
      val client = KnockOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .bearerToken("My Bearer Token")
          .build()
      val userService = client.users()

      val page = userService.listSubscriptions(UserListSubscriptionsParams.builder()
          .userId("user_id")
          .build())

      page.response().validate()
    }

    @Disabled("skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url")
    @Test
    fun merge() {
      val client = KnockOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .bearerToken("My Bearer Token")
          .build()
      val userService = client.users()

      val user = userService.merge(UserMergeParams.builder()
          .userId("user_id")
          .fromUserId("user_1")
          .build())

      user.validate()
    }

    @Disabled("skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url")
    @Test
    fun setChannelData() {
      val client = KnockOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .bearerToken("My Bearer Token")
          .build()
      val userService = client.users()

      val channelData = userService.setChannelData(UserSetChannelDataParams.builder()
          .userId("user_id")
          .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .channelDataRequest(ChannelDataRequest.builder()
              .data(PushChannelData.builder()
                  .addToken("push_token_1")
                  .build())
              .build())
          .build())

      channelData.validate()
    }

    @Disabled("skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url")
    @Test
    fun setPreferences() {
      val client = KnockOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .bearerToken("My Bearer Token")
          .build()
      val userService = client.users()

      val preferenceSet = userService.setPreferences(UserSetPreferencesParams.builder()
          .userId("user_id")
          .preferenceSetId("default")
          .preferenceSetRequest(PreferenceSetRequest.builder()
              .categories(PreferenceSetRequest.Categories.builder()
                  .putAdditionalProperty("marketing", JsonValue.from(false))
                  .putAdditionalProperty("transactional", JsonValue.from(mapOf(
                    "channel_types" to mapOf(
                      "chat" to true,
                      "email" to false,
                      "http" to true,
                      "in_app_feed" to true,
                      "push" to true,
                      "sms" to true,
                    ), "conditions" to listOf(mapOf(
                      "argument" to "some_property",
                      "operator" to "equal_to",
                      "variable" to "recipient.property",
                    ))
                  )))
                  .build())
              .channelTypes(PreferenceSetChannelTypes.builder()
                  .chat(PreferenceSetChannelTypes.Chat.ofBool(true))
                  .email(PreferenceSetChannelTypes.Email.ofBool(true))
                  .http(PreferenceSetChannelTypes.Http.ofBool(true))
                  .inAppFeed(PreferenceSetChannelTypes.InAppFeed.ofBool(true))
                  .push(PreferenceSetChannelTypes.Push.ofBool(true))
                  .sms(PreferenceSetChannelTypes.Sms.ofBool(true))
                  .build())
              .workflows(PreferenceSetRequest.Workflows.builder()
                  .putAdditionalProperty("dinosaurs-loose", JsonValue.from(mapOf(
                    "channel_types" to mapOf(
                      "chat" to true,
                      "email" to false,
                      "http" to true,
                      "in_app_feed" to true,
                      "push" to true,
                      "sms" to true,
                    ), "conditions" to listOf(mapOf(
                      "argument" to "some_property",
                      "operator" to "equal_to",
                      "variable" to "recipient.property",
                    ))
                  )))
                  .build())
              .build())
          .build())

      preferenceSet.validate()
    }

    @Disabled("skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url")
    @Test
    fun unsetChannelData() {
      val client = KnockOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .bearerToken("My Bearer Token")
          .build()
      val userService = client.users()

      userService.unsetChannelData(UserUnsetChannelDataParams.builder()
          .userId("user_id")
          .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build())
    }
}
