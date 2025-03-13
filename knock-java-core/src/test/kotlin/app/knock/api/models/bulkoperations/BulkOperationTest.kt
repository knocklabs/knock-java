// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.bulkoperations

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BulkOperationTest {

    @Test
    fun createBulkOperation() {
        val bulkOperation =
            BulkOperation.builder()
                .id("123e4567-e89b-12d3-a456-426614174000")
                ._typename("BulkOperation")
                .estimatedTotalRows(1000L)
                .insertedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                .name("Bulk operation name")
                .processedRows(0L)
                .status(BulkOperation.Status.QUEUED)
                .successCount(0L)
                .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                .completedAt(null)
                .errorCount(0L)
                .addErrorItem(
                    BulkOperation.ErrorItem.builder().id("id").collection("collection").build()
                )
                .failedAt(null)
                .startedAt(null)
                .build()
        assertThat(bulkOperation).isNotNull
        assertThat(bulkOperation.id()).isEqualTo("123e4567-e89b-12d3-a456-426614174000")
        assertThat(bulkOperation._typename()).isEqualTo("BulkOperation")
        assertThat(bulkOperation.estimatedTotalRows()).isEqualTo(1000L)
        assertThat(bulkOperation.insertedAt())
            .isEqualTo(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
        assertThat(bulkOperation.name()).isEqualTo("Bulk operation name")
        assertThat(bulkOperation.processedRows()).isEqualTo(0L)
        assertThat(bulkOperation.status()).isEqualTo(BulkOperation.Status.QUEUED)
        assertThat(bulkOperation.successCount()).isEqualTo(0L)
        assertThat(bulkOperation.updatedAt())
            .isEqualTo(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
        assertThat(bulkOperation.completedAt()).isEmpty
        assertThat(bulkOperation.errorCount()).contains(0L)
        assertThat(bulkOperation.errorItems().get())
            .containsExactly(
                BulkOperation.ErrorItem.builder().id("id").collection("collection").build()
            )
        assertThat(bulkOperation.failedAt()).isEmpty
        assertThat(bulkOperation.startedAt()).isEmpty
    }
}
