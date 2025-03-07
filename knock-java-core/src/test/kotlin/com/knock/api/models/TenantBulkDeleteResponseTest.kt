// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TenantBulkDeleteResponseTest {

    @Test
    fun createTenantBulkDeleteResponse() {
        val tenantBulkDeleteResponse =
            TenantBulkDeleteResponse.builder()
                .id("123e4567-e89b-12d3-a456-426614174000")
                ._typename("BulkOperation")
                .estimatedTotalRows(1000L)
                .insertedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                .name("Bulk operation name")
                .processedRows(0L)
                .status(TenantBulkDeleteResponse.Status.QUEUED)
                .successCount(0L)
                .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                .completedAt(null)
                .errorCount(0L)
                .addErrorItem(
                    TenantBulkDeleteResponse.ErrorItem.builder()
                        .id("id")
                        .collection("collection")
                        .build()
                )
                .failedAt(null)
                .startedAt(null)
                .build()
        assertThat(tenantBulkDeleteResponse).isNotNull
        assertThat(tenantBulkDeleteResponse.id()).isEqualTo("123e4567-e89b-12d3-a456-426614174000")
        assertThat(tenantBulkDeleteResponse._typename()).isEqualTo("BulkOperation")
        assertThat(tenantBulkDeleteResponse.estimatedTotalRows()).isEqualTo(1000L)
        assertThat(tenantBulkDeleteResponse.insertedAt())
            .isEqualTo(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
        assertThat(tenantBulkDeleteResponse.name()).isEqualTo("Bulk operation name")
        assertThat(tenantBulkDeleteResponse.processedRows()).isEqualTo(0L)
        assertThat(tenantBulkDeleteResponse.status())
            .isEqualTo(TenantBulkDeleteResponse.Status.QUEUED)
        assertThat(tenantBulkDeleteResponse.successCount()).isEqualTo(0L)
        assertThat(tenantBulkDeleteResponse.updatedAt())
            .isEqualTo(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
        assertThat(tenantBulkDeleteResponse.completedAt()).isEmpty
        assertThat(tenantBulkDeleteResponse.errorCount()).contains(0L)
        assertThat(tenantBulkDeleteResponse.errorItems().get())
            .containsExactly(
                TenantBulkDeleteResponse.ErrorItem.builder()
                    .id("id")
                    .collection("collection")
                    .build()
            )
        assertThat(tenantBulkDeleteResponse.failedAt()).isEmpty
        assertThat(tenantBulkDeleteResponse.startedAt()).isEmpty
    }
}
