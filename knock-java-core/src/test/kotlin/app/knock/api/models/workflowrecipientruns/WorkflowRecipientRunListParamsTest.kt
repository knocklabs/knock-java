// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.workflowrecipientruns

import app.knock.api.core.http.QueryParams
import app.knock.api.models.recipients.RecipientReference
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WorkflowRecipientRunListParamsTest {

    @Test
    fun create() {
        WorkflowRecipientRunListParams.builder()
            .after("after")
            .before("before")
            .endingAt(OffsetDateTime.parse("2025-01-31T00:00:00Z"))
            .hasErrors(true)
            .pageSize(25L)
            .recipient(
                RecipientReference.ObjectReference.builder()
                    .id("project-1")
                    .collection("projects")
                    .build()
            )
            .startingAt(OffsetDateTime.parse("2025-01-01T00:00:00Z"))
            .addStatus(WorkflowRecipientRunListParams.Status.COMPLETED)
            .addStatus(WorkflowRecipientRunListParams.Status.CANCELLED)
            .tenant("acme")
            .workflow("welcome")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            WorkflowRecipientRunListParams.builder()
                .after("after")
                .before("before")
                .endingAt(OffsetDateTime.parse("2025-01-31T00:00:00Z"))
                .hasErrors(true)
                .pageSize(25L)
                .recipient(
                    RecipientReference.ObjectReference.builder()
                        .id("project-1")
                        .collection("projects")
                        .build()
                )
                .startingAt(OffsetDateTime.parse("2025-01-01T00:00:00Z"))
                .addStatus(WorkflowRecipientRunListParams.Status.COMPLETED)
                .addStatus(WorkflowRecipientRunListParams.Status.CANCELLED)
                .tenant("acme")
                .workflow("welcome")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "after")
                    .put("before", "before")
                    .put("ending_at", "2025-01-31T00:00:00Z")
                    .put("has_errors", "true")
                    .put("page_size", "25")
                    .put("recipient[id]", "project-1")
                    .put("recipient[collection]", "projects")
                    .put("starting_at", "2025-01-01T00:00:00Z")
                    .put("status[]", "completed")
                    .put("status[]", "cancelled")
                    .put("tenant", "acme")
                    .put("workflow", "welcome")
                    .build()
            )
    }

    @Test
    fun queryParamsWithUserRecipient() {
        val params = WorkflowRecipientRunListParams.builder().recipient("user_123").build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(QueryParams.builder().put("recipient", "user_123").build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = WorkflowRecipientRunListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
