// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UserBulkSetPreferencesResponseTest {

    @Test
    fun createUserBulkSetPreferencesResponse() {
        val userBulkSetPreferencesResponse =
            UserBulkSetPreferencesResponse.builder()
                .id("123e4567-e89b-12d3-a456-426614174000")
                ._typename("BulkOperation")
                .estimatedTotalRows(1000L)
                .insertedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                .name("Bulk operation name")
                .processedRows(0L)
                .status(UserBulkSetPreferencesResponse.Status.QUEUED)
                .successCount(0L)
                .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                .completedAt(null)
                .errorCount(0L)
                .addErrorItem(
                    UserBulkSetPreferencesResponse.ErrorItem.builder()
                        .id("id")
                        .collection("collection")
                        .build()
                )
                .failedAt(null)
                .startedAt(null)
                .build()
        assertThat(userBulkSetPreferencesResponse).isNotNull
        assertThat(userBulkSetPreferencesResponse.id())
            .isEqualTo("123e4567-e89b-12d3-a456-426614174000")
        assertThat(userBulkSetPreferencesResponse._typename()).isEqualTo("BulkOperation")
        assertThat(userBulkSetPreferencesResponse.estimatedTotalRows()).isEqualTo(1000L)
        assertThat(userBulkSetPreferencesResponse.insertedAt())
            .isEqualTo(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
        assertThat(userBulkSetPreferencesResponse.name()).isEqualTo("Bulk operation name")
        assertThat(userBulkSetPreferencesResponse.processedRows()).isEqualTo(0L)
        assertThat(userBulkSetPreferencesResponse.status())
            .isEqualTo(UserBulkSetPreferencesResponse.Status.QUEUED)
        assertThat(userBulkSetPreferencesResponse.successCount()).isEqualTo(0L)
        assertThat(userBulkSetPreferencesResponse.updatedAt())
            .isEqualTo(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
        assertThat(userBulkSetPreferencesResponse.completedAt()).isEmpty
        assertThat(userBulkSetPreferencesResponse.errorCount()).contains(0L)
        assertThat(userBulkSetPreferencesResponse.errorItems().get())
            .containsExactly(
                UserBulkSetPreferencesResponse.ErrorItem.builder()
                    .id("id")
                    .collection("collection")
                    .build()
            )
        assertThat(userBulkSetPreferencesResponse.failedAt()).isEmpty
        assertThat(userBulkSetPreferencesResponse.startedAt()).isEmpty
    }
}
