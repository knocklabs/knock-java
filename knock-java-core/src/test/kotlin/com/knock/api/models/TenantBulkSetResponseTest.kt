// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TenantBulkSetResponseTest {

    @Test
    fun createTenantBulkSetResponse() {
        val tenantBulkSetResponse =
            TenantBulkSetResponse.builder()
                .id("123e4567-e89b-12d3-a456-426614174000")
                ._typename("BulkOperation")
                .estimatedTotalRows(1000L)
                .insertedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                .name("Bulk operation name")
                .processedRows(0L)
                .status(TenantBulkSetResponse.Status.QUEUED)
                .successCount(0L)
                .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                .completedAt(null)
                .errorCount(0L)
                .addErrorItem(
                    TenantBulkSetResponse.ErrorItem.builder()
                        .id("id")
                        .collection("collection")
                        .build()
                )
                .failedAt(null)
                .startedAt(null)
                .build()
        assertThat(tenantBulkSetResponse).isNotNull
        assertThat(tenantBulkSetResponse.id()).isEqualTo("123e4567-e89b-12d3-a456-426614174000")
        assertThat(tenantBulkSetResponse._typename()).isEqualTo("BulkOperation")
        assertThat(tenantBulkSetResponse.estimatedTotalRows()).isEqualTo(1000L)
        assertThat(tenantBulkSetResponse.insertedAt())
            .isEqualTo(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
        assertThat(tenantBulkSetResponse.name()).isEqualTo("Bulk operation name")
        assertThat(tenantBulkSetResponse.processedRows()).isEqualTo(0L)
        assertThat(tenantBulkSetResponse.status()).isEqualTo(TenantBulkSetResponse.Status.QUEUED)
        assertThat(tenantBulkSetResponse.successCount()).isEqualTo(0L)
        assertThat(tenantBulkSetResponse.updatedAt())
            .isEqualTo(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
        assertThat(tenantBulkSetResponse.completedAt()).isEmpty
        assertThat(tenantBulkSetResponse.errorCount()).contains(0L)
        assertThat(tenantBulkSetResponse.errorItems().get())
            .containsExactly(
                TenantBulkSetResponse.ErrorItem.builder().id("id").collection("collection").build()
            )
        assertThat(tenantBulkSetResponse.failedAt()).isEmpty
        assertThat(tenantBulkSetResponse.startedAt()).isEmpty
    }
}
