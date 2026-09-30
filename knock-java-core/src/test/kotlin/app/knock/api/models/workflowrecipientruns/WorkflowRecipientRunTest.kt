// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.workflowrecipientruns

import app.knock.api.core.jsonMapper
import app.knock.api.models.recipients.RecipientReference
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WorkflowRecipientRunTest {

    @Test
    fun create() {
        val workflowRecipientRun =
            WorkflowRecipientRun.builder()
                .id("7d9a2b4e-1f3c-4a5b-8c6d-9e0f1a2b3c4d")
                ._typename("WorkflowRecipientRun")
                .insertedAt(OffsetDateTime.parse("2025-01-01T00:00:00Z"))
                .recipient("user_123")
                .status(WorkflowRecipientRun.Status.COMPLETED)
                .triggerSource(
                    WorkflowRecipientRun.TriggerSource.builder()
                        .type(WorkflowRecipientRun.TriggerSource.Type.API)
                        .audienceKey(null)
                        .cancellationKey("cancel-key")
                        .scheduleId(null)
                        .build()
                )
                .updatedAt(OffsetDateTime.parse("2025-01-01T00:00:05Z"))
                .workflow("welcome")
                .workflowRunId("0f1e2d3c-4b5a-6978-8796-a5b4c3d2e1f0")
                .actor(
                    RecipientReference.ObjectReference.builder()
                        .id("team-1")
                        .collection("teams")
                        .build()
                )
                .errorCount(0L)
                .tenant("acme")
                .build()

        assertThat(workflowRecipientRun.id()).isEqualTo("7d9a2b4e-1f3c-4a5b-8c6d-9e0f1a2b3c4d")
        assertThat(workflowRecipientRun._typename()).isEqualTo("WorkflowRecipientRun")
        assertThat(workflowRecipientRun.insertedAt())
            .isEqualTo(OffsetDateTime.parse("2025-01-01T00:00:00Z"))
        assertThat(workflowRecipientRun.recipient())
            .isEqualTo(RecipientReference.ofUser("user_123"))
        assertThat(workflowRecipientRun.status()).isEqualTo(WorkflowRecipientRun.Status.COMPLETED)
        assertThat(workflowRecipientRun.workflow()).isEqualTo("welcome")
        assertThat(workflowRecipientRun.actor())
            .contains(
                RecipientReference.ofObjectReference(
                    RecipientReference.ObjectReference.builder()
                        .id("team-1")
                        .collection("teams")
                        .build()
                )
            )
        assertThat(workflowRecipientRun.errorCount()).contains(0L)
        assertThat(workflowRecipientRun.tenant()).contains("acme")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val workflowRecipientRun =
            WorkflowRecipientRun.builder()
                .id("7d9a2b4e-1f3c-4a5b-8c6d-9e0f1a2b3c4d")
                ._typename("WorkflowRecipientRun")
                .insertedAt(OffsetDateTime.parse("2025-01-01T00:00:00Z"))
                .recipient("user_123")
                .status(WorkflowRecipientRun.Status.COMPLETED)
                .triggerSource(
                    WorkflowRecipientRun.TriggerSource.builder()
                        .type(WorkflowRecipientRun.TriggerSource.Type.API)
                        .audienceKey(null)
                        .cancellationKey("cancel-key")
                        .scheduleId(null)
                        .build()
                )
                .updatedAt(OffsetDateTime.parse("2025-01-01T00:00:05Z"))
                .workflow("welcome")
                .workflowRunId("0f1e2d3c-4b5a-6978-8796-a5b4c3d2e1f0")
                .actor(
                    RecipientReference.ObjectReference.builder()
                        .id("team-1")
                        .collection("teams")
                        .build()
                )
                .errorCount(0L)
                .tenant("acme")
                .build()

        val roundtrippedWorkflowRecipientRun =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(workflowRecipientRun),
                jacksonTypeRef<WorkflowRecipientRun>(),
            )

        assertThat(roundtrippedWorkflowRecipientRun).isEqualTo(workflowRecipientRun)
    }
}
