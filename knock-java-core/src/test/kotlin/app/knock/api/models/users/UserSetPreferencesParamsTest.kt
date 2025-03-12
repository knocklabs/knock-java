// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.core.JsonValue
import app.knock.api.models.recipients.preferences.PreferenceSetChannelTypes
import app.knock.api.models.recipients.preferences.PreferenceSetRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UserSetPreferencesParamsTest {

    @Test
    fun create() {
      UserSetPreferencesParams.builder()
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
          .build()
    }

    @Test
    fun body() {
      val params = UserSetPreferencesParams.builder()
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
          .build()

      val body = params._body()

      assertThat(body).isEqualTo(PreferenceSetRequest.builder()
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
    }

    @Test
    fun bodyWithoutOptionalFields() {
      val params = UserSetPreferencesParams.builder()
          .userId("user_id")
          .preferenceSetId("default")
          .preferenceSetRequest(PreferenceSetRequest.builder().build())
          .build()

      val body = params._body()

      assertThat(body).isEqualTo(PreferenceSetRequest.builder().build())
    }

    @Test
    fun getPathParam() {
      val params = UserSetPreferencesParams.builder()
          .userId("user_id")
          .preferenceSetId("default")
          .preferenceSetRequest(PreferenceSetRequest.builder().build())
          .build()
      assertThat(params).isNotNull
      // path param "userId"
      assertThat(params.getPathParam(0)).isEqualTo("user_id")
      // path param "preferenceSetId"
      assertThat(params.getPathParam(1)).isEqualTo("default")
      // out-of-bound path param
      assertThat(params.getPathParam(2)).isEqualTo("")
    }
}
