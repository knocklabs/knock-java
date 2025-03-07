// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ObjectBulkDeleteResponseTest {

    @Test
    fun createObjectBulkDeleteResponse() {
        val objectBulkDeleteResponse =
            ObjectBulkDeleteResponse.builder()
                .id("123e4567-e89b-12d3-a456-426614174000")
                ._typename("BulkOperation")
                .estimatedTotalRows(1000L)
                .insertedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                .name("Bulk operation name")
                .processedRows(0L)
                .status(ObjectBulkDeleteResponse.Status.QUEUED)
                .successCount(0L)
                .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                .completedAt(null)
                .errorCount(0L)
                .addErrorItem(
                    ObjectBulkDeleteResponse.ErrorItem.builder()
                        .id("id")
                        .collection("collection")
                        .build()
                )
                .failedAt(null)
                .startedAt(null)
                .build()
        assertThat(objectBulkDeleteResponse).isNotNull
        assertThat(objectBulkDeleteResponse.id()).isEqualTo("123e4567-e89b-12d3-a456-426614174000")
        assertThat(objectBulkDeleteResponse._typename()).isEqualTo("BulkOperation")
        assertThat(objectBulkDeleteResponse.estimatedTotalRows()).isEqualTo(1000L)
        assertThat(objectBulkDeleteResponse.insertedAt())
            .isEqualTo(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
        assertThat(objectBulkDeleteResponse.name()).isEqualTo("Bulk operation name")
        assertThat(objectBulkDeleteResponse.processedRows()).isEqualTo(0L)
        assertThat(objectBulkDeleteResponse.status())
            .isEqualTo(ObjectBulkDeleteResponse.Status.QUEUED)
        assertThat(objectBulkDeleteResponse.successCount()).isEqualTo(0L)
        assertThat(objectBulkDeleteResponse.updatedAt())
            .isEqualTo(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
        assertThat(objectBulkDeleteResponse.completedAt()).isEmpty
        assertThat(objectBulkDeleteResponse.errorCount()).contains(0L)
        assertThat(objectBulkDeleteResponse.errorItems().get())
            .containsExactly(
                ObjectBulkDeleteResponse.ErrorItem.builder()
                    .id("id")
                    .collection("collection")
                    .build()
            )
        assertThat(objectBulkDeleteResponse.failedAt()).isEmpty
        assertThat(objectBulkDeleteResponse.startedAt()).isEmpty
    }
}
