// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.workflows

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WorkflowTriggerResponseTest {

    @Test
    fun create() {
        val workflowTriggerResponse =
            WorkflowTriggerResponse.builder()
                .workflowRunId("123e4567-e89b-12d3-a456-426614174000")
                .build()

        assertThat(workflowTriggerResponse.workflowRunId())
            .isEqualTo("123e4567-e89b-12d3-a456-426614174000")
    }
}
