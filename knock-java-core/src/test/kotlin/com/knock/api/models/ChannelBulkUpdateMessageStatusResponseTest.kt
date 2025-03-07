// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ChannelBulkUpdateMessageStatusResponseTest {

    @Test
    fun createChannelBulkUpdateMessageStatusResponse() {
        val channelBulkUpdateMessageStatusResponse =
            ChannelBulkUpdateMessageStatusResponse.builder()
                .id("123e4567-e89b-12d3-a456-426614174000")
                ._typename("BulkOperation")
                .estimatedTotalRows(1000L)
                .insertedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                .name("Bulk operation name")
                .processedRows(0L)
                .status(ChannelBulkUpdateMessageStatusResponse.Status.QUEUED)
                .successCount(0L)
                .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                .completedAt(null)
                .errorCount(0L)
                .addErrorItem(
                    ChannelBulkUpdateMessageStatusResponse.ErrorItem.builder()
                        .id("id")
                        .collection("collection")
                        .build()
                )
                .failedAt(null)
                .startedAt(null)
                .build()
        assertThat(channelBulkUpdateMessageStatusResponse).isNotNull
        assertThat(channelBulkUpdateMessageStatusResponse.id())
            .isEqualTo("123e4567-e89b-12d3-a456-426614174000")
        assertThat(channelBulkUpdateMessageStatusResponse._typename()).isEqualTo("BulkOperation")
        assertThat(channelBulkUpdateMessageStatusResponse.estimatedTotalRows()).isEqualTo(1000L)
        assertThat(channelBulkUpdateMessageStatusResponse.insertedAt())
            .isEqualTo(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
        assertThat(channelBulkUpdateMessageStatusResponse.name()).isEqualTo("Bulk operation name")
        assertThat(channelBulkUpdateMessageStatusResponse.processedRows()).isEqualTo(0L)
        assertThat(channelBulkUpdateMessageStatusResponse.status())
            .isEqualTo(ChannelBulkUpdateMessageStatusResponse.Status.QUEUED)
        assertThat(channelBulkUpdateMessageStatusResponse.successCount()).isEqualTo(0L)
        assertThat(channelBulkUpdateMessageStatusResponse.updatedAt())
            .isEqualTo(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
        assertThat(channelBulkUpdateMessageStatusResponse.completedAt()).isEmpty
        assertThat(channelBulkUpdateMessageStatusResponse.errorCount()).contains(0L)
        assertThat(channelBulkUpdateMessageStatusResponse.errorItems().get())
            .containsExactly(
                ChannelBulkUpdateMessageStatusResponse.ErrorItem.builder()
                    .id("id")
                    .collection("collection")
                    .build()
            )
        assertThat(channelBulkUpdateMessageStatusResponse.failedAt()).isEmpty
        assertThat(channelBulkUpdateMessageStatusResponse.startedAt()).isEmpty
    }
}
