// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UserBulkDeleteResponseTest {

    @Test
    fun createUserBulkDeleteResponse() {
        val userBulkDeleteResponse =
            UserBulkDeleteResponse.builder()
                .id("123e4567-e89b-12d3-a456-426614174000")
                ._typename("BulkOperation")
                .estimatedTotalRows(1000L)
                .insertedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                .name("Bulk operation name")
                .processedRows(0L)
                .status(UserBulkDeleteResponse.Status.QUEUED)
                .successCount(0L)
                .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                .completedAt(null)
                .errorCount(0L)
                .addErrorItem(
                    UserBulkDeleteResponse.ErrorItem.builder()
                        .id("id")
                        .collection("collection")
                        .build()
                )
                .failedAt(null)
                .startedAt(null)
                .build()
        assertThat(userBulkDeleteResponse).isNotNull
        assertThat(userBulkDeleteResponse.id()).isEqualTo("123e4567-e89b-12d3-a456-426614174000")
        assertThat(userBulkDeleteResponse._typename()).isEqualTo("BulkOperation")
        assertThat(userBulkDeleteResponse.estimatedTotalRows()).isEqualTo(1000L)
        assertThat(userBulkDeleteResponse.insertedAt())
            .isEqualTo(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
        assertThat(userBulkDeleteResponse.name()).isEqualTo("Bulk operation name")
        assertThat(userBulkDeleteResponse.processedRows()).isEqualTo(0L)
        assertThat(userBulkDeleteResponse.status()).isEqualTo(UserBulkDeleteResponse.Status.QUEUED)
        assertThat(userBulkDeleteResponse.successCount()).isEqualTo(0L)
        assertThat(userBulkDeleteResponse.updatedAt())
            .isEqualTo(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
        assertThat(userBulkDeleteResponse.completedAt()).isEmpty
        assertThat(userBulkDeleteResponse.errorCount()).contains(0L)
        assertThat(userBulkDeleteResponse.errorItems().get())
            .containsExactly(
                UserBulkDeleteResponse.ErrorItem.builder().id("id").collection("collection").build()
            )
        assertThat(userBulkDeleteResponse.failedAt()).isEmpty
        assertThat(userBulkDeleteResponse.startedAt()).isEmpty
    }
}
