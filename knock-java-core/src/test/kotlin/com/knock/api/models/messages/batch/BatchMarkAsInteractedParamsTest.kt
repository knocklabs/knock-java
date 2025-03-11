// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models.messages.batch

import com.knock.api.core.JsonValue
import kotlin.test.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BatchMarkAsInteractedParamsTest {

    @Test
    fun create() {
      BatchMarkAsInteractedParams.builder()
          .addMessageId("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
          .metadata(BatchMarkAsInteractedParams.Metadata.builder()
              .putAdditionalProperty("key", JsonValue.from("bar"))
              .build())
          .build()
    }

    @Test
    fun body() {
      val params = BatchMarkAsInteractedParams.builder()
          .addMessageId("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
          .metadata(BatchMarkAsInteractedParams.Metadata.builder()
              .putAdditionalProperty("key", JsonValue.from("bar"))
              .build())
          .build()

      val body = params._body()

      assertNotNull(body)
      assertThat(body.messageIds()).isEqualTo(listOf("1jNaXzB2RZX3LY8wVQnfCKyPnv7"))
      assertThat(body.metadata()).contains(BatchMarkAsInteractedParams.Metadata.builder()
          .putAdditionalProperty("key", JsonValue.from("bar"))
          .build())
    }

    @Test
    fun bodyWithoutOptionalFields() {
      val params = BatchMarkAsInteractedParams.builder()
          .addMessageId("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
          .build()

      val body = params._body()

      assertNotNull(body)
      assertThat(body.messageIds()).isEqualTo(listOf("1jNaXzB2RZX3LY8wVQnfCKyPnv7"))
    }
}
