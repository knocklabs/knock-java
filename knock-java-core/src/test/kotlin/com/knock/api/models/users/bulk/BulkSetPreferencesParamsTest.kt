// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models.users.bulk

import com.knock.api.core.JsonValue
import com.knock.api.models.recipients.PreferenceSetChannelTypes
import com.knock.api.models.recipients.PreferenceSetRequest
import kotlin.test.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BulkSetPreferencesParamsTest {

    @Test
    fun create() {
      BulkSetPreferencesParams.builder()
          .preferences(PreferenceSetRequest.builder()
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
          .addUserId("user_1")
          .addUserId("user_2")
          .build()
    }

    @Test
    fun body() {
      val params = BulkSetPreferencesParams.builder()
          .preferences(PreferenceSetRequest.builder()
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
          .addUserId("user_1")
          .addUserId("user_2")
          .build()

      val body = params._body()

      assertNotNull(body)
      assertThat(body.preferences()).isEqualTo(PreferenceSetRequest.builder()
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
      assertThat(body.userIds()).isEqualTo(listOf(
        "user_1", "user_2"
      ))
    }

    @Test
    fun bodyWithoutOptionalFields() {
      val params = BulkSetPreferencesParams.builder()
          .preferences(PreferenceSetRequest.builder().build())
          .addUserId("user_1")
          .addUserId("user_2")
          .build()

      val body = params._body()

      assertNotNull(body)
      assertThat(body.preferences()).isEqualTo(PreferenceSetRequest.builder().build())
      assertThat(body.userIds()).isEqualTo(listOf(
        "user_1", "user_2"
      ))
    }
}
