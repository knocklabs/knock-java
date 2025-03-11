// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models.recipients

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ChannelDataRequestTest {

    @Test
    fun createChannelDataRequest() {
      val channelDataRequest = ChannelDataRequest.builder()
          .data(PushChannelData.builder()
              .addToken("push_token_1")
              .build())
          .build()
      assertThat(channelDataRequest).isNotNull
      assertThat(channelDataRequest.data()).isEqualTo(ChannelDataRequest.Data.ofPushChannel(PushChannelData.builder()
          .addToken("push_token_1")
          .build()))
    }
}
