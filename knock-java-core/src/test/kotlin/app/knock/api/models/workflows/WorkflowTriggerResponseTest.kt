// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.workflows

import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
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

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val workflowTriggerResponse =
            WorkflowTriggerResponse.builder()
                .workflowRunId("123e4567-e89b-12d3-a456-426614174000")
                .build()

        val roundtrippedWorkflowTriggerResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(workflowTriggerResponse),
                jacksonTypeRef<WorkflowTriggerResponse>(),
            )

        assertThat(roundtrippedWorkflowTriggerResponse).isEqualTo(workflowTriggerResponse)
    }
}
