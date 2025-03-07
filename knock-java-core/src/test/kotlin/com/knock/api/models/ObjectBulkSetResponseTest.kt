// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ObjectBulkSetResponseTest {

    @Test
    fun createObjectBulkSetResponse() {
        val objectBulkSetResponse =
            ObjectBulkSetResponse.builder()
                .id("123e4567-e89b-12d3-a456-426614174000")
                ._typename("BulkOperation")
                .estimatedTotalRows(1000L)
                .insertedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                .name("Bulk operation name")
                .processedRows(0L)
                .status(ObjectBulkSetResponse.Status.QUEUED)
                .successCount(0L)
                .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                .completedAt(null)
                .errorCount(0L)
                .addErrorItem(
                    ObjectBulkSetResponse.ErrorItem.builder()
                        .id("id")
                        .collection("collection")
                        .build()
                )
                .failedAt(null)
                .startedAt(null)
                .build()
        assertThat(objectBulkSetResponse).isNotNull
        assertThat(objectBulkSetResponse.id()).isEqualTo("123e4567-e89b-12d3-a456-426614174000")
        assertThat(objectBulkSetResponse._typename()).isEqualTo("BulkOperation")
        assertThat(objectBulkSetResponse.estimatedTotalRows()).isEqualTo(1000L)
        assertThat(objectBulkSetResponse.insertedAt())
            .isEqualTo(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
        assertThat(objectBulkSetResponse.name()).isEqualTo("Bulk operation name")
        assertThat(objectBulkSetResponse.processedRows()).isEqualTo(0L)
        assertThat(objectBulkSetResponse.status()).isEqualTo(ObjectBulkSetResponse.Status.QUEUED)
        assertThat(objectBulkSetResponse.successCount()).isEqualTo(0L)
        assertThat(objectBulkSetResponse.updatedAt())
            .isEqualTo(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
        assertThat(objectBulkSetResponse.completedAt()).isEmpty
        assertThat(objectBulkSetResponse.errorCount()).contains(0L)
        assertThat(objectBulkSetResponse.errorItems().get())
            .containsExactly(
                ObjectBulkSetResponse.ErrorItem.builder().id("id").collection("collection").build()
            )
        assertThat(objectBulkSetResponse.failedAt()).isEmpty
        assertThat(objectBulkSetResponse.startedAt()).isEmpty
    }
}
