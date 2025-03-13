// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.core.JsonValue
import app.knock.api.models.recipients.channeldata.InlineChannelDataRequest
import app.knock.api.models.recipients.preferences.InlinePreferenceSetRequest
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InlineIdentifyUserRequestTest {

    @Test
    fun createInlineIdentifyUserRequest() {
      val inlineIdentifyUserRequest = InlineIdentifyUserRequest.builder()
          .id("user_1")
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
          .build()
      assertThat(inlineIdentifyUserRequest).isNotNull
      assertThat(inlineIdentifyUserRequest.id()).isEqualTo("user_1")
      assertThat(inlineIdentifyUserRequest.channelData()).contains(InlineChannelDataRequest.builder()
          .putAdditionalProperty("97c5837d-c65c-4d54-aa39-080eeb81c69d", JsonValue.from(mapOf("data" to mapOf("tokens" to listOf("push_token_xxx")))))
          .build())
      assertThat(inlineIdentifyUserRequest.createdAt()).contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
      assertThat(inlineIdentifyUserRequest.preferences()).contains(InlinePreferenceSetRequest.builder()
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
    }
}
