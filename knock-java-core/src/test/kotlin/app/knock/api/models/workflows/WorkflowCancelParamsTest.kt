// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.workflows

import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WorkflowCancelParamsTest {

    @Test
    fun create() {
        WorkflowCancelParams.builder()
            .key("key")
            .cancellationKey("cancel-workflow-123")
            .addRecipient("jhammond")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            WorkflowCancelParams.builder().key("key").cancellationKey("cancel-workflow-123").build()

        assertThat(params._pathParam(0)).isEqualTo("key")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            WorkflowCancelParams.builder()
                .key("key")
                .cancellationKey("cancel-workflow-123")
                .addRecipient("jhammond")
                .build()

        val body = params._body()

        assertThat(body.cancellationKey()).isEqualTo("cancel-workflow-123")
        assertThat(body.recipients().getOrNull())
            .containsExactly(WorkflowCancelParams.Recipient.ofUser("jhammond"))
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            WorkflowCancelParams.builder().key("key").cancellationKey("cancel-workflow-123").build()

        val body = params._body()

        assertThat(body.cancellationKey()).isEqualTo("cancel-workflow-123")
    }
}
