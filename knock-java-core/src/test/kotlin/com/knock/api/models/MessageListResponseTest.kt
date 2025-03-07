// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import com.knock.api.core.JsonValue
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MessageListResponseTest {

    @Test
    fun createMessageListResponse() {
        val messageListResponse =
            MessageListResponse.builder()
                .id("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
                ._typename("Message")
                .addActor("user_123")
                .archivedAt(null)
                .channelId("123e4567-e89b-12d3-a456-426614174000")
                .clickedAt(null)
                .data(
                    MessageListResponse.Data.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .addEngagementStatus(MessageListResponse.EngagementStatus.SEEN)
                .addEngagementStatus(MessageListResponse.EngagementStatus.READ)
                .insertedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                .interactedAt(null)
                .linkClickedAt(null)
                .metadata(
                    MessageListResponse.Metadata.builder()
                        .putAdditionalProperty("external_id", JsonValue.from("bar"))
                        .build()
                )
                .readAt(null)
                .recipient("user_123")
                .scheduledAt(null)
                .seenAt(null)
                .source(
                    MessageListResponse.Source.builder()
                        ._typename("NotificationSource")
                        .addCategory("collaboration")
                        .key("comment-created")
                        .versionId("123e4567-e89b-12d3-a456-426614174000")
                        .build()
                )
                .status(MessageListResponse.Status.QUEUED)
                .tenant("tenant_123")
                .updatedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                .workflow("comment-created")
                .build()
        assertThat(messageListResponse).isNotNull
        assertThat(messageListResponse.id()).contains("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
        assertThat(messageListResponse._typename()).contains("Message")
        assertThat(messageListResponse.actors().get())
            .containsExactly(MessageListResponse.Actor.ofString("user_123"))
        assertThat(messageListResponse.archivedAt()).isEmpty
        assertThat(messageListResponse.channelId()).contains("123e4567-e89b-12d3-a456-426614174000")
        assertThat(messageListResponse.clickedAt()).isEmpty
        assertThat(messageListResponse.data())
            .contains(
                MessageListResponse.Data.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(messageListResponse.engagementStatuses().get())
            .containsExactly(
                MessageListResponse.EngagementStatus.SEEN,
                MessageListResponse.EngagementStatus.READ,
            )
        assertThat(messageListResponse.insertedAt())
            .contains(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
        assertThat(messageListResponse.interactedAt()).isEmpty
        assertThat(messageListResponse.linkClickedAt()).isEmpty
        assertThat(messageListResponse.metadata())
            .contains(
                MessageListResponse.Metadata.builder()
                    .putAdditionalProperty("external_id", JsonValue.from("bar"))
                    .build()
            )
        assertThat(messageListResponse.readAt()).isEmpty
        assertThat(messageListResponse.recipient())
            .contains(MessageListResponse.Recipient.ofString("user_123"))
        assertThat(messageListResponse.scheduledAt()).isEmpty
        assertThat(messageListResponse.seenAt()).isEmpty
        assertThat(messageListResponse.source())
            .contains(
                MessageListResponse.Source.builder()
                    ._typename("NotificationSource")
                    .addCategory("collaboration")
                    .key("comment-created")
                    .versionId("123e4567-e89b-12d3-a456-426614174000")
                    .build()
            )
        assertThat(messageListResponse.status()).contains(MessageListResponse.Status.QUEUED)
        assertThat(messageListResponse.tenant()).contains("tenant_123")
        assertThat(messageListResponse.updatedAt())
            .contains(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
        assertThat(messageListResponse.workflow()).contains("comment-created")
    }
}
