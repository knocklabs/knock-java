// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages

import app.knock.api.core.JsonValue
import kotlin.test.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MessageMarkAsInteractedParamsTest {

    @Test
    fun create() {
      MessageMarkAsInteractedParams.builder()
          .messageId("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
          .metadata(MessageMarkAsInteractedParams.Metadata.builder()
              .putAdditionalProperty("key", JsonValue.from("bar"))
              .build())
          .build()
    }

    @Test
    fun body() {
      val params = MessageMarkAsInteractedParams.builder()
          .messageId("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
          .metadata(MessageMarkAsInteractedParams.Metadata.builder()
              .putAdditionalProperty("key", JsonValue.from("bar"))
              .build())
          .build()

      val body = params._body()

      assertNotNull(body)
      assertThat(body.metadata()).contains(MessageMarkAsInteractedParams.Metadata.builder()
          .putAdditionalProperty("key", JsonValue.from("bar"))
          .build())
    }

    @Test
    fun bodyWithoutOptionalFields() {
      val params = MessageMarkAsInteractedParams.builder()
          .messageId("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
          .build()

      val body = params._body()

      assertNotNull(body)
    }

    @Test
    fun getPathParam() {
      val params = MessageMarkAsInteractedParams.builder()
          .messageId("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
          .build()
      assertThat(params).isNotNull
      // path param "messageId"
      assertThat(params.getPathParam(0)).isEqualTo("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
      // out-of-bound path param
      assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
