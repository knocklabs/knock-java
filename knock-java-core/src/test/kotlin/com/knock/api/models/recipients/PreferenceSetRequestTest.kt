// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models.recipients

import com.knock.api.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PreferenceSetRequestTest {

    @Test
    fun createPreferenceSetRequest() {
      val preferenceSetRequest = PreferenceSetRequest.builder()
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
          .build()
      assertThat(preferenceSetRequest).isNotNull
      assertThat(preferenceSetRequest.categories()).contains(PreferenceSetRequest.Categories.builder()
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
      assertThat(preferenceSetRequest.channelTypes()).contains(PreferenceSetChannelTypes.builder()
          .chat(PreferenceSetChannelTypes.Chat.ofBool(true))
          .email(PreferenceSetChannelTypes.Email.ofBool(true))
          .http(PreferenceSetChannelTypes.Http.ofBool(true))
          .inAppFeed(PreferenceSetChannelTypes.InAppFeed.ofBool(true))
          .push(PreferenceSetChannelTypes.Push.ofBool(true))
          .sms(PreferenceSetChannelTypes.Sms.ofBool(true))
          .build())
      assertThat(preferenceSetRequest.workflows()).contains(PreferenceSetRequest.Workflows.builder()
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
    }
}
