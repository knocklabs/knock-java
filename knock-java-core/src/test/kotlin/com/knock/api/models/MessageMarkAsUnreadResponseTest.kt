// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import com.knock.api.core.JsonValue
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MessageMarkAsUnreadResponseTest {

    @Test
    fun createMessageMarkAsUnreadResponse() {
        val messageMarkAsUnreadResponse =
            MessageMarkAsUnreadResponse.builder()
                .id("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
                ._typename("Message")
                .addActor("user_123")
                .archivedAt(null)
                .channelId("123e4567-e89b-12d3-a456-426614174000")
                .clickedAt(null)
                .data(
                    MessageMarkAsUnreadResponse.Data.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .addEngagementStatus(MessageMarkAsUnreadResponse.EngagementStatus.SEEN)
                .addEngagementStatus(MessageMarkAsUnreadResponse.EngagementStatus.READ)
                .insertedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                .interactedAt(null)
                .linkClickedAt(null)
                .metadata(
                    MessageMarkAsUnreadResponse.Metadata.builder()
                        .putAdditionalProperty("external_id", JsonValue.from("bar"))
                        .build()
                )
                .readAt(null)
                .recipient("user_123")
                .scheduledAt(null)
                .seenAt(null)
                .source(
                    MessageMarkAsUnreadResponse.Source.builder()
                        ._typename("NotificationSource")
                        .addCategory("collaboration")
                        .key("comment-created")
                        .versionId("123e4567-e89b-12d3-a456-426614174000")
                        .build()
                )
                .status(MessageMarkAsUnreadResponse.Status.QUEUED)
                .tenant("tenant_123")
                .updatedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                .workflow("comment-created")
                .build()
        assertThat(messageMarkAsUnreadResponse).isNotNull
        assertThat(messageMarkAsUnreadResponse.id()).contains("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
        assertThat(messageMarkAsUnreadResponse._typename()).contains("Message")
        assertThat(messageMarkAsUnreadResponse.actors().get())
            .containsExactly(MessageMarkAsUnreadResponse.Actor.ofString("user_123"))
        assertThat(messageMarkAsUnreadResponse.archivedAt()).isEmpty
        assertThat(messageMarkAsUnreadResponse.channelId())
            .contains("123e4567-e89b-12d3-a456-426614174000")
        assertThat(messageMarkAsUnreadResponse.clickedAt()).isEmpty
        assertThat(messageMarkAsUnreadResponse.data())
            .contains(
                MessageMarkAsUnreadResponse.Data.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(messageMarkAsUnreadResponse.engagementStatuses().get())
            .containsExactly(
                MessageMarkAsUnreadResponse.EngagementStatus.SEEN,
                MessageMarkAsUnreadResponse.EngagementStatus.READ,
            )
        assertThat(messageMarkAsUnreadResponse.insertedAt())
            .contains(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
        assertThat(messageMarkAsUnreadResponse.interactedAt()).isEmpty
        assertThat(messageMarkAsUnreadResponse.linkClickedAt()).isEmpty
        assertThat(messageMarkAsUnreadResponse.metadata())
            .contains(
                MessageMarkAsUnreadResponse.Metadata.builder()
                    .putAdditionalProperty("external_id", JsonValue.from("bar"))
                    .build()
            )
        assertThat(messageMarkAsUnreadResponse.readAt()).isEmpty
        assertThat(messageMarkAsUnreadResponse.recipient())
            .contains(MessageMarkAsUnreadResponse.Recipient.ofString("user_123"))
        assertThat(messageMarkAsUnreadResponse.scheduledAt()).isEmpty
        assertThat(messageMarkAsUnreadResponse.seenAt()).isEmpty
        assertThat(messageMarkAsUnreadResponse.source())
            .contains(
                MessageMarkAsUnreadResponse.Source.builder()
                    ._typename("NotificationSource")
                    .addCategory("collaboration")
                    .key("comment-created")
                    .versionId("123e4567-e89b-12d3-a456-426614174000")
                    .build()
            )
        assertThat(messageMarkAsUnreadResponse.status())
            .contains(MessageMarkAsUnreadResponse.Status.QUEUED)
        assertThat(messageMarkAsUnreadResponse.tenant()).contains("tenant_123")
        assertThat(messageMarkAsUnreadResponse.updatedAt())
            .contains(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
        assertThat(messageMarkAsUnreadResponse.workflow()).contains("comment-created")
    }
}
