// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.workflowrecipientruns

import app.knock.api.core.jsonMapper
import app.knock.api.models.recipients.RecipientReference
import app.knock.api.models.shared.PageInfo
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WorkflowRecipientRunListPageResponseTest {

    @Test
    fun create() {
        val workflowRecipientRunListPageResponse =
            WorkflowRecipientRunListPageResponse.builder()
                .addItem(
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
                )
                .pageInfo(
                    PageInfo.builder()
                        ._typename("PageInfo")
                        .pageSize(50L)
                        .after("after_cursor")
                        .before(null)
                        .build()
                )
                .build()

        assertThat(workflowRecipientRunListPageResponse.items())
            .containsExactly(
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
            )
        assertThat(workflowRecipientRunListPageResponse.pageInfo())
            .isEqualTo(
                PageInfo.builder()
                    ._typename("PageInfo")
                    .pageSize(50L)
                    .after("after_cursor")
                    .before(null)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val workflowRecipientRunListPageResponse =
            WorkflowRecipientRunListPageResponse.builder()
                .addItem(
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
                )
                .pageInfo(
                    PageInfo.builder()
                        ._typename("PageInfo")
                        .pageSize(50L)
                        .after("after_cursor")
                        .before(null)
                        .build()
                )
                .build()

        val roundtrippedWorkflowRecipientRunListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(workflowRecipientRunListPageResponse),
                jacksonTypeRef<WorkflowRecipientRunListPageResponse>(),
            )

        assertThat(roundtrippedWorkflowRecipientRunListPageResponse)
            .isEqualTo(workflowRecipientRunListPageResponse)
    }
}
