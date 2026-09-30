// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.workflowrecipientruns

import app.knock.api.core.JsonValue
import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WorkflowRecipientRunEventTest {

    @Test
    fun create() {
        val workflowRecipientRunEvent =
            WorkflowRecipientRunEvent.builder()
                .id("evt_1")
                ._typename("WorkflowRecipientRunEvent")
                .event("workflow_step.completed")
                .insertedAt(OffsetDateTime.parse("2025-01-01T00:00:01Z"))
                .status(WorkflowRecipientRunEvent.Status.OK)
                .attempt(1L)
                .data(
                    WorkflowRecipientRunEvent.Data.builder()
                        .putAdditionalProperty("channel", JsonValue.from("email"))
                        .build()
                )
                .stepRef("email_1")
                .stepType("channel")
                .build()

        assertThat(workflowRecipientRunEvent.id()).isEqualTo("evt_1")
        assertThat(workflowRecipientRunEvent.event()).isEqualTo("workflow_step.completed")
        assertThat(workflowRecipientRunEvent.status())
            .isEqualTo(WorkflowRecipientRunEvent.Status.OK)
        assertThat(workflowRecipientRunEvent.attempt()).contains(1L)
        assertThat(workflowRecipientRunEvent.stepRef()).contains("email_1")
        assertThat(workflowRecipientRunEvent.stepType()).contains("channel")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val workflowRecipientRunEvent =
            WorkflowRecipientRunEvent.builder()
                .id("evt_1")
                ._typename("WorkflowRecipientRunEvent")
                .event("workflow_step.completed")
                .insertedAt(OffsetDateTime.parse("2025-01-01T00:00:01Z"))
                .status(WorkflowRecipientRunEvent.Status.OK)
                .attempt(1L)
                .data(
                    WorkflowRecipientRunEvent.Data.builder()
                        .putAdditionalProperty("channel", JsonValue.from("email"))
                        .build()
                )
                .stepRef("email_1")
                .stepType("channel")
                .build()

        val roundtrippedWorkflowRecipientRunEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(workflowRecipientRunEvent),
                jacksonTypeRef<WorkflowRecipientRunEvent>(),
            )

        assertThat(roundtrippedWorkflowRecipientRunEvent).isEqualTo(workflowRecipientRunEvent)
    }
}
