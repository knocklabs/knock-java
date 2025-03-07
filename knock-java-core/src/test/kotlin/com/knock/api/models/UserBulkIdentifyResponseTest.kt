// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UserBulkIdentifyResponseTest {

    @Test
    fun createUserBulkIdentifyResponse() {
        val userBulkIdentifyResponse =
            UserBulkIdentifyResponse.builder()
                .id("123e4567-e89b-12d3-a456-426614174000")
                ._typename("BulkOperation")
                .estimatedTotalRows(1000L)
                .insertedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                .name("Bulk operation name")
                .processedRows(0L)
                .status(UserBulkIdentifyResponse.Status.QUEUED)
                .successCount(0L)
                .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                .completedAt(null)
                .errorCount(0L)
                .addErrorItem(
                    UserBulkIdentifyResponse.ErrorItem.builder()
                        .id("id")
                        .collection("collection")
                        .build()
                )
                .failedAt(null)
                .startedAt(null)
                .build()
        assertThat(userBulkIdentifyResponse).isNotNull
        assertThat(userBulkIdentifyResponse.id()).isEqualTo("123e4567-e89b-12d3-a456-426614174000")
        assertThat(userBulkIdentifyResponse._typename()).isEqualTo("BulkOperation")
        assertThat(userBulkIdentifyResponse.estimatedTotalRows()).isEqualTo(1000L)
        assertThat(userBulkIdentifyResponse.insertedAt())
            .isEqualTo(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
        assertThat(userBulkIdentifyResponse.name()).isEqualTo("Bulk operation name")
        assertThat(userBulkIdentifyResponse.processedRows()).isEqualTo(0L)
        assertThat(userBulkIdentifyResponse.status())
            .isEqualTo(UserBulkIdentifyResponse.Status.QUEUED)
        assertThat(userBulkIdentifyResponse.successCount()).isEqualTo(0L)
        assertThat(userBulkIdentifyResponse.updatedAt())
            .isEqualTo(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
        assertThat(userBulkIdentifyResponse.completedAt()).isEmpty
        assertThat(userBulkIdentifyResponse.errorCount()).contains(0L)
        assertThat(userBulkIdentifyResponse.errorItems().get())
            .containsExactly(
                UserBulkIdentifyResponse.ErrorItem.builder()
                    .id("id")
                    .collection("collection")
                    .build()
            )
        assertThat(userBulkIdentifyResponse.failedAt()).isEmpty
        assertThat(userBulkIdentifyResponse.startedAt()).isEmpty
    }
}
