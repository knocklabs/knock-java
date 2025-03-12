// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.workflows

import kotlin.test.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WorkflowCancelParamsTest {

    @Test
    fun create() {
      WorkflowCancelParams.builder()
          .key("key")
          .cancellationKey("cancel-workflow-123")
          .addRecipient("jhammond")
          .tenant("prk_1")
          .build()
    }

    @Test
    fun body() {
      val params = WorkflowCancelParams.builder()
          .key("key")
          .cancellationKey("cancel-workflow-123")
          .addRecipient("jhammond")
          .tenant("prk_1")
          .build()

      val body = params._body()

      assertNotNull(body)
      assertThat(body.cancellationKey()).isEqualTo("cancel-workflow-123")
      assertThat(body.recipients()).contains(listOf("jhammond"))
      assertThat(body.tenant()).contains("prk_1")
    }

    @Test
    fun bodyWithoutOptionalFields() {
      val params = WorkflowCancelParams.builder()
          .key("key")
          .cancellationKey("cancel-workflow-123")
          .build()

      val body = params._body()

      assertNotNull(body)
      assertThat(body.cancellationKey()).isEqualTo("cancel-workflow-123")
    }

    @Test
    fun getPathParam() {
      val params = WorkflowCancelParams.builder()
          .key("key")
          .cancellationKey("cancel-workflow-123")
          .build()
      assertThat(params).isNotNull
      // path param "key"
      assertThat(params.getPathParam(0)).isEqualTo("key")
      // out-of-bound path param
      assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
