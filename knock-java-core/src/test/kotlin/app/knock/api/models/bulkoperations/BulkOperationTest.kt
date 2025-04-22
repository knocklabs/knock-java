// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.bulkoperations

import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BulkOperationTest {

    @Test
    fun create() {
        val bulkOperation =
            BulkOperation.builder()
                .id("123e4567-e89b-12d3-a456-426614174000")
                ._typename("BulkOperation")
                .estimatedTotalRows(1000L)
                .insertedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                .name("Bulk operation name")
                .processedRows(0L)
                .status(BulkOperation.Status.PROCESSING)
                .successCount(0L)
                .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                .completedAt(null)
                .errorCount(0L)
                .addErrorItem(
                    BulkOperation.ErrorItem.builder().id("id").collection("collection").build()
                )
                .failedAt(null)
                .progressPath(
                    "https://api.switchboard.com/v1/bulk_operations/123e4567-e89b-12d3-a456-426614174000"
                )
                .startedAt(null)
                .build()

        assertThat(bulkOperation.id()).isEqualTo("123e4567-e89b-12d3-a456-426614174000")
        assertThat(bulkOperation._typename()).isEqualTo("BulkOperation")
        assertThat(bulkOperation.estimatedTotalRows()).isEqualTo(1000L)
        assertThat(bulkOperation.insertedAt())
            .isEqualTo(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
        assertThat(bulkOperation.name()).isEqualTo("Bulk operation name")
        assertThat(bulkOperation.processedRows()).isEqualTo(0L)
        assertThat(bulkOperation.status()).isEqualTo(BulkOperation.Status.PROCESSING)
        assertThat(bulkOperation.successCount()).isEqualTo(0L)
        assertThat(bulkOperation.updatedAt())
            .isEqualTo(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
        assertThat(bulkOperation.completedAt()).isEmpty
        assertThat(bulkOperation.errorCount()).contains(0L)
        assertThat(bulkOperation.errorItems().getOrNull())
            .containsExactly(
                BulkOperation.ErrorItem.builder().id("id").collection("collection").build()
            )
        assertThat(bulkOperation.failedAt()).isEmpty
        assertThat(bulkOperation.progressPath())
            .contains(
                "https://api.switchboard.com/v1/bulk_operations/123e4567-e89b-12d3-a456-426614174000"
            )
        assertThat(bulkOperation.startedAt()).isEmpty
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val bulkOperation =
            BulkOperation.builder()
                .id("123e4567-e89b-12d3-a456-426614174000")
                ._typename("BulkOperation")
                .estimatedTotalRows(1000L)
                .insertedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                .name("Bulk operation name")
                .processedRows(0L)
                .status(BulkOperation.Status.PROCESSING)
                .successCount(0L)
                .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                .completedAt(null)
                .errorCount(0L)
                .addErrorItem(
                    BulkOperation.ErrorItem.builder().id("id").collection("collection").build()
                )
                .failedAt(null)
                .progressPath(
                    "https://api.switchboard.com/v1/bulk_operations/123e4567-e89b-12d3-a456-426614174000"
                )
                .startedAt(null)
                .build()

        val roundtrippedBulkOperation =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(bulkOperation),
                jacksonTypeRef<BulkOperation>(),
            )

        assertThat(roundtrippedBulkOperation).isEqualTo(bulkOperation)
    }
}
