// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.workflowrecipientruns

import app.knock.api.core.JsonValue
import app.knock.api.core.jsonMapper
import app.knock.api.models.recipients.RecipientReference
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WorkflowRecipientRunDetailTest {

    @Test
    fun create() {
        val workflowRecipientRunDetail =
            WorkflowRecipientRunDetail.builder()
                .id("7d9a2b4e-1f3c-4a5b-8c6d-9e0f1a2b3c4d")
                ._typename("WorkflowRecipientRun")
                .insertedAt(OffsetDateTime.parse("2025-01-01T00:00:00Z"))
                .recipient("user_123")
                .status(WorkflowRecipientRunDetail.Status.COMPLETED)
                .triggerSource(
                    WorkflowRecipientRunDetail.TriggerSource.builder()
                        .type(WorkflowRecipientRunDetail.TriggerSource.Type.API)
                        .audienceKey(null)
                        .cancellationKey("cancel-key")
                        .scheduleId(null)
                        .build()
                )
                .updatedAt(OffsetDateTime.parse("2025-01-01T00:00:05Z"))
                .workflow("welcome")
                .workflowRunId("0f1e2d3c-4b5a-6978-8796-a5b4c3d2e1f0")
                .addEvent(
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
                )
                .actor(
                    RecipientReference.ObjectReference.builder()
                        .id("team-1")
                        .collection("teams")
                        .build()
                )
                .errorCount(0L)
                .tenant("acme")
                .build()

        assertThat(workflowRecipientRunDetail.id())
            .isEqualTo("7d9a2b4e-1f3c-4a5b-8c6d-9e0f1a2b3c4d")
        assertThat(workflowRecipientRunDetail._typename()).isEqualTo("WorkflowRecipientRun")
        assertThat(workflowRecipientRunDetail.insertedAt())
            .isEqualTo(OffsetDateTime.parse("2025-01-01T00:00:00Z"))
        assertThat(workflowRecipientRunDetail.recipient())
            .isEqualTo(RecipientReference.ofUser("user_123"))
        assertThat(workflowRecipientRunDetail.status())
            .isEqualTo(WorkflowRecipientRunDetail.Status.COMPLETED)
        assertThat(workflowRecipientRunDetail.workflow()).isEqualTo("welcome")
        assertThat(workflowRecipientRunDetail.actor())
            .contains(
                RecipientReference.ofObjectReference(
                    RecipientReference.ObjectReference.builder()
                        .id("team-1")
                        .collection("teams")
                        .build()
                )
            )
        assertThat(workflowRecipientRunDetail.errorCount()).contains(0L)
        assertThat(workflowRecipientRunDetail.tenant()).contains("acme")
        assertThat(workflowRecipientRunDetail.events())
            .containsExactly(
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
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val workflowRecipientRunDetail =
            WorkflowRecipientRunDetail.builder()
                .id("7d9a2b4e-1f3c-4a5b-8c6d-9e0f1a2b3c4d")
                ._typename("WorkflowRecipientRun")
                .insertedAt(OffsetDateTime.parse("2025-01-01T00:00:00Z"))
                .recipient("user_123")
                .status(WorkflowRecipientRunDetail.Status.COMPLETED)
                .triggerSource(
                    WorkflowRecipientRunDetail.TriggerSource.builder()
                        .type(WorkflowRecipientRunDetail.TriggerSource.Type.API)
                        .audienceKey(null)
                        .cancellationKey("cancel-key")
                        .scheduleId(null)
                        .build()
                )
                .updatedAt(OffsetDateTime.parse("2025-01-01T00:00:05Z"))
                .workflow("welcome")
                .workflowRunId("0f1e2d3c-4b5a-6978-8796-a5b4c3d2e1f0")
                .addEvent(
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
                )
                .actor(
                    RecipientReference.ObjectReference.builder()
                        .id("team-1")
                        .collection("teams")
                        .build()
                )
                .errorCount(0L)
                .tenant("acme")
                .build()

        val roundtrippedWorkflowRecipientRunDetail =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(workflowRecipientRunDetail),
                jacksonTypeRef<WorkflowRecipientRunDetail>(),
            )

        assertThat(roundtrippedWorkflowRecipientRunDetail).isEqualTo(workflowRecipientRunDetail)
    }
}
