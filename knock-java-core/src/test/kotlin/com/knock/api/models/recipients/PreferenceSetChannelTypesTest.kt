// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models.recipients

import com.knock.api.models.Condition
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PreferenceSetChannelTypesTest {

    @Test
    fun createPreferenceSetChannelTypes() {
      val preferenceSetChannelTypes = PreferenceSetChannelTypes.builder()
          .chat(PreferenceSetChannelTypes.Chat.ofBool(true))
          .email(PreferenceSetChannelTypes.Email.ofBool(true))
          .http(PreferenceSetChannelTypes.Http.ofBool(true))
          .inAppFeed(PreferenceSetChannelTypes.InAppFeed.ofBool(true))
          .push(PreferenceSetChannelTypes.Push.ofBool(true))
          .sms(PreferenceSetChannelTypeSetting.builder()
              .addCondition(Condition.builder()
                  .argument("US")
                  .operator(Condition.Operator.EQUAL_TO)
                  .variable("recipient.country_code")
                  .build())
              .build())
          .build()
      assertThat(preferenceSetChannelTypes).isNotNull
      assertThat(preferenceSetChannelTypes.chat()).contains(PreferenceSetChannelTypes.Chat.ofBool(true))
      assertThat(preferenceSetChannelTypes.email()).contains(PreferenceSetChannelTypes.Email.ofBool(true))
      assertThat(preferenceSetChannelTypes.http()).contains(PreferenceSetChannelTypes.Http.ofBool(true))
      assertThat(preferenceSetChannelTypes.inAppFeed()).contains(PreferenceSetChannelTypes.InAppFeed.ofBool(true))
      assertThat(preferenceSetChannelTypes.push()).contains(PreferenceSetChannelTypes.Push.ofBool(true))
      assertThat(preferenceSetChannelTypes.sms()).contains(PreferenceSetChannelTypes.Sms.ofPreferenceSetChannelTypeSetting(PreferenceSetChannelTypeSetting.builder()
          .addCondition(Condition.builder()
              .argument("US")
              .operator(Condition.Operator.EQUAL_TO)
              .variable("recipient.country_code")
              .build())
          .build()))
    }
}
