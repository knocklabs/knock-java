// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ObjectBulkAddSubscriptionsResponseTest {

    @Test
    fun createObjectBulkAddSubscriptionsResponse() {
        val objectBulkAddSubscriptionsResponse =
            ObjectBulkAddSubscriptionsResponse.builder()
                .id("123e4567-e89b-12d3-a456-426614174000")
                ._typename("BulkOperation")
                .estimatedTotalRows(1000L)
                .insertedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                .name("Bulk operation name")
                .processedRows(0L)
                .status(ObjectBulkAddSubscriptionsResponse.Status.QUEUED)
                .successCount(0L)
                .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                .completedAt(null)
                .errorCount(0L)
                .addErrorItem(
                    ObjectBulkAddSubscriptionsResponse.ErrorItem.builder()
                        .id("id")
                        .collection("collection")
                        .build()
                )
                .failedAt(null)
                .startedAt(null)
                .build()
        assertThat(objectBulkAddSubscriptionsResponse).isNotNull
        assertThat(objectBulkAddSubscriptionsResponse.id())
            .isEqualTo("123e4567-e89b-12d3-a456-426614174000")
        assertThat(objectBulkAddSubscriptionsResponse._typename()).isEqualTo("BulkOperation")
        assertThat(objectBulkAddSubscriptionsResponse.estimatedTotalRows()).isEqualTo(1000L)
        assertThat(objectBulkAddSubscriptionsResponse.insertedAt())
            .isEqualTo(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
        assertThat(objectBulkAddSubscriptionsResponse.name()).isEqualTo("Bulk operation name")
        assertThat(objectBulkAddSubscriptionsResponse.processedRows()).isEqualTo(0L)
        assertThat(objectBulkAddSubscriptionsResponse.status())
            .isEqualTo(ObjectBulkAddSubscriptionsResponse.Status.QUEUED)
        assertThat(objectBulkAddSubscriptionsResponse.successCount()).isEqualTo(0L)
        assertThat(objectBulkAddSubscriptionsResponse.updatedAt())
            .isEqualTo(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
        assertThat(objectBulkAddSubscriptionsResponse.completedAt()).isEmpty
        assertThat(objectBulkAddSubscriptionsResponse.errorCount()).contains(0L)
        assertThat(objectBulkAddSubscriptionsResponse.errorItems().get())
            .containsExactly(
                ObjectBulkAddSubscriptionsResponse.ErrorItem.builder()
                    .id("id")
                    .collection("collection")
                    .build()
            )
        assertThat(objectBulkAddSubscriptionsResponse.failedAt()).isEmpty
        assertThat(objectBulkAddSubscriptionsResponse.startedAt()).isEmpty
    }
}
