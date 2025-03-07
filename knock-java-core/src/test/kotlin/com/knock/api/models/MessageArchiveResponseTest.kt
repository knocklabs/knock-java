// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import com.knock.api.core.JsonValue
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MessageArchiveResponseTest {

    @Test
    fun createMessageArchiveResponse() {
        val messageArchiveResponse =
            MessageArchiveResponse.builder()
                .id("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
                ._typename("Message")
                .addActor("user_123")
                .archivedAt(null)
                .channelId("123e4567-e89b-12d3-a456-426614174000")
                .clickedAt(null)
                .data(
                    MessageArchiveResponse.Data.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .addEngagementStatus(MessageArchiveResponse.EngagementStatus.SEEN)
                .addEngagementStatus(MessageArchiveResponse.EngagementStatus.READ)
                .insertedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                .interactedAt(null)
                .linkClickedAt(null)
                .metadata(
                    MessageArchiveResponse.Metadata.builder()
                        .putAdditionalProperty("external_id", JsonValue.from("bar"))
                        .build()
                )
                .readAt(null)
                .recipient("user_123")
                .scheduledAt(null)
                .seenAt(null)
                .source(
                    MessageArchiveResponse.Source.builder()
                        ._typename("NotificationSource")
                        .addCategory("collaboration")
                        .key("comment-created")
                        .versionId("123e4567-e89b-12d3-a456-426614174000")
                        .build()
                )
                .status(MessageArchiveResponse.Status.QUEUED)
                .tenant("tenant_123")
                .updatedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                .workflow("comment-created")
                .build()
        assertThat(messageArchiveResponse).isNotNull
        assertThat(messageArchiveResponse.id()).contains("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
        assertThat(messageArchiveResponse._typename()).contains("Message")
        assertThat(messageArchiveResponse.actors().get())
            .containsExactly(MessageArchiveResponse.Actor.ofString("user_123"))
        assertThat(messageArchiveResponse.archivedAt()).isEmpty
        assertThat(messageArchiveResponse.channelId())
            .contains("123e4567-e89b-12d3-a456-426614174000")
        assertThat(messageArchiveResponse.clickedAt()).isEmpty
        assertThat(messageArchiveResponse.data())
            .contains(
                MessageArchiveResponse.Data.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(messageArchiveResponse.engagementStatuses().get())
            .containsExactly(
                MessageArchiveResponse.EngagementStatus.SEEN,
                MessageArchiveResponse.EngagementStatus.READ,
            )
        assertThat(messageArchiveResponse.insertedAt())
            .contains(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
        assertThat(messageArchiveResponse.interactedAt()).isEmpty
        assertThat(messageArchiveResponse.linkClickedAt()).isEmpty
        assertThat(messageArchiveResponse.metadata())
            .contains(
                MessageArchiveResponse.Metadata.builder()
                    .putAdditionalProperty("external_id", JsonValue.from("bar"))
                    .build()
            )
        assertThat(messageArchiveResponse.readAt()).isEmpty
        assertThat(messageArchiveResponse.recipient())
            .contains(MessageArchiveResponse.Recipient.ofString("user_123"))
        assertThat(messageArchiveResponse.scheduledAt()).isEmpty
        assertThat(messageArchiveResponse.seenAt()).isEmpty
        assertThat(messageArchiveResponse.source())
            .contains(
                MessageArchiveResponse.Source.builder()
                    ._typename("NotificationSource")
                    .addCategory("collaboration")
                    .key("comment-created")
                    .versionId("123e4567-e89b-12d3-a456-426614174000")
                    .build()
            )
        assertThat(messageArchiveResponse.status()).contains(MessageArchiveResponse.Status.QUEUED)
        assertThat(messageArchiveResponse.tenant()).contains("tenant_123")
        assertThat(messageArchiveResponse.updatedAt())
            .contains(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
        assertThat(messageArchiveResponse.workflow()).contains("comment-created")
    }
}
