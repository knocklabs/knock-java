// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models.objects

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ObjectUnsetChannelDataParamsTest {

    @Test
    fun create() {
      ObjectUnsetChannelDataParams.builder()
          .collection("collection")
          .objectId("object_id")
          .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build()
    }

    @Test
    fun getPathParam() {
      val params = ObjectUnsetChannelDataParams.builder()
          .collection("collection")
          .objectId("object_id")
          .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
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
