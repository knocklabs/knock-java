// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BulkOperationGetResponseTest {

    @Test
    fun createBulkOperationGetResponse() {
        val bulkOperationGetResponse =
            BulkOperationGetResponse.builder()
                .id("123e4567-e89b-12d3-a456-426614174000")
                ._typename("BulkOperation")
                .estimatedTotalRows(1000L)
                .insertedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                .name("Bulk operation name")
                .processedRows(0L)
                .status(BulkOperationGetResponse.Status.QUEUED)
                .successCount(0L)
                .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                .completedAt(null)
                .errorCount(0L)
                .addErrorItem(
                    BulkOperationGetResponse.ErrorItem.builder()
                        .id("id")
                        .collection("collection")
                        .build()
                )
                .failedAt(null)
                .startedAt(null)
                .build()
        assertThat(bulkOperationGetResponse).isNotNull
        assertThat(bulkOperationGetResponse.id()).isEqualTo("123e4567-e89b-12d3-a456-426614174000")
        assertThat(bulkOperationGetResponse._typename()).isEqualTo("BulkOperation")
        assertThat(bulkOperationGetResponse.estimatedTotalRows()).isEqualTo(1000L)
        assertThat(bulkOperationGetResponse.insertedAt())
            .isEqualTo(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
        assertThat(bulkOperationGetResponse.name()).isEqualTo("Bulk operation name")
        assertThat(bulkOperationGetResponse.processedRows()).isEqualTo(0L)
        assertThat(bulkOperationGetResponse.status())
            .isEqualTo(BulkOperationGetResponse.Status.QUEUED)
        assertThat(bulkOperationGetResponse.successCount()).isEqualTo(0L)
        assertThat(bulkOperationGetResponse.updatedAt())
            .isEqualTo(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
        assertThat(bulkOperationGetResponse.completedAt()).isEmpty
        assertThat(bulkOperationGetResponse.errorCount()).contains(0L)
        assertThat(bulkOperationGetResponse.errorItems().get())
            .containsExactly(
                BulkOperationGetResponse.ErrorItem.builder()
                    .id("id")
                    .collection("collection")
                    .build()
            )
        assertThat(bulkOperationGetResponse.failedAt()).isEmpty
        assertThat(bulkOperationGetResponse.startedAt()).isEmpty
    }
}
