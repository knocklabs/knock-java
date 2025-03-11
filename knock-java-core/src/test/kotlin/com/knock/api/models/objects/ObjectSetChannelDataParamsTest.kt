// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models.objects

import com.knock.api.models.recipients.ChannelDataRequest
import com.knock.api.models.recipients.PushChannelData
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ObjectSetChannelDataParamsTest {

    @Test
    fun create() {
      ObjectSetChannelDataParams.builder()
          .collection("collection")
          .objectId("object_id")
          .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .channelDataRequest(ChannelDataRequest.builder()
              .data(PushChannelData.builder()
                  .addToken("push_token_1")
                  .build())
              .build())
          .build()
    }

    @Test
    fun body() {
      val params = ObjectSetChannelDataParams.builder()
          .collection("collection")
          .objectId("object_id")
          .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .channelDataRequest(ChannelDataRequest.builder()
              .data(PushChannelData.builder()
                  .addToken("push_token_1")
                  .build())
              .build())
          .build()

      val body = params._body()

      assertThat(body).isEqualTo(ChannelDataRequest.builder()
          .data(PushChannelData.builder()
              .addToken("push_token_1")
              .build())
          .build())
    }

    @Test
    fun bodyWithoutOptionalFields() {
      val params = ObjectSetChannelDataParams.builder()
          .collection("collection")
          .objectId("object_id")
          .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .channelDataRequest(ChannelDataRequest.builder()
              .data(PushChannelData.builder()
                  .addToken("push_token_1")
                  .build())
              .build())
          .build()

      val body = params._body()

      assertThat(body).isEqualTo(ChannelDataRequest.builder()
          .data(PushChannelData.builder()
              .addToken("push_token_1")
              .build())
          .build())
    }

    @Test
    fun getPathParam() {
      val params = ObjectSetChannelDataParams.builder()
          .collection("collection")
          .objectId("object_id")
          .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .channelDataRequest(ChannelDataRequest.builder()
              .data(PushChannelData.builder()
                  .addToken("push_token_1")
                  .build())
              .build())
          .build()
      assertThat(params).isNotNull
      // path param "collection"
      assertThat(params.getPathParam(0)).isEqualTo("collection")
      // path param "objectId"
      assertThat(params.getPathParam(1)).isEqualTo("object_id")
      // path param "channelId"
      assertThat(params.getPathParam(2)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
      // out-of-bound path param
      assertThat(params.getPathParam(3)).isEqualTo("")
    }
}
