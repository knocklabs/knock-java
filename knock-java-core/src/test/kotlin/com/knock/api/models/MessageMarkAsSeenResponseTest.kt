// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import com.knock.api.core.JsonValue
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MessageMarkAsSeenResponseTest {

    @Test
    fun createMessageMarkAsSeenResponse() {
        val messageMarkAsSeenResponse =
            MessageMarkAsSeenResponse.builder()
                .id("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
                ._typename("Message")
                .addActor("user_123")
                .archivedAt(null)
                .channelId("123e4567-e89b-12d3-a456-426614174000")
                .clickedAt(null)
                .data(
                    MessageMarkAsSeenResponse.Data.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .addEngagementStatus(MessageMarkAsSeenResponse.EngagementStatus.SEEN)
                .addEngagementStatus(MessageMarkAsSeenResponse.EngagementStatus.READ)
                .insertedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                .interactedAt(null)
                .linkClickedAt(null)
                .metadata(
                    MessageMarkAsSeenResponse.Metadata.builder()
                        .putAdditionalProperty("external_id", JsonValue.from("bar"))
                        .build()
                )
                .readAt(null)
                .recipient("user_123")
                .scheduledAt(null)
                .seenAt(null)
                .source(
                    MessageMarkAsSeenResponse.Source.builder()
                        ._typename("NotificationSource")
                        .addCategory("collaboration")
                        .key("comment-created")
                        .versionId("123e4567-e89b-12d3-a456-426614174000")
                        .build()
                )
                .status(MessageMarkAsSeenResponse.Status.QUEUED)
                .tenant("tenant_123")
                .updatedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                .workflow("comment-created")
                .build()
        assertThat(messageMarkAsSeenResponse).isNotNull
        assertThat(messageMarkAsSeenResponse.id()).contains("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
        assertThat(messageMarkAsSeenResponse._typename()).contains("Message")
        assertThat(messageMarkAsSeenResponse.actors().get())
            .containsExactly(MessageMarkAsSeenResponse.Actor.ofString("user_123"))
        assertThat(messageMarkAsSeenResponse.archivedAt()).isEmpty
        assertThat(messageMarkAsSeenResponse.channelId())
            .contains("123e4567-e89b-12d3-a456-426614174000")
        assertThat(messageMarkAsSeenResponse.clickedAt()).isEmpty
        assertThat(messageMarkAsSeenResponse.data())
            .contains(
                MessageMarkAsSeenResponse.Data.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(messageMarkAsSeenResponse.engagementStatuses().get())
            .containsExactly(
                MessageMarkAsSeenResponse.EngagementStatus.SEEN,
                MessageMarkAsSeenResponse.EngagementStatus.READ,
            )
        assertThat(messageMarkAsSeenResponse.insertedAt())
            .contains(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
        assertThat(messageMarkAsSeenResponse.interactedAt()).isEmpty
        assertThat(messageMarkAsSeenResponse.linkClickedAt()).isEmpty
        assertThat(messageMarkAsSeenResponse.metadata())
            .contains(
                MessageMarkAsSeenResponse.Metadata.builder()
                    .putAdditionalProperty("external_id", JsonValue.from("bar"))
                    .build()
            )
        assertThat(messageMarkAsSeenResponse.readAt()).isEmpty
        assertThat(messageMarkAsSeenResponse.recipient())
            .contains(MessageMarkAsSeenResponse.Recipient.ofString("user_123"))
        assertThat(messageMarkAsSeenResponse.scheduledAt()).isEmpty
        assertThat(messageMarkAsSeenResponse.seenAt()).isEmpty
        assertThat(messageMarkAsSeenResponse.source())
            .contains(
                MessageMarkAsSeenResponse.Source.builder()
                    ._typename("NotificationSource")
                    .addCategory("collaboration")
                    .key("comment-created")
                    .versionId("123e4567-e89b-12d3-a456-426614174000")
                    .build()
            )
        assertThat(messageMarkAsSeenResponse.status())
            .contains(MessageMarkAsSeenResponse.Status.QUEUED)
        assertThat(messageMarkAsSeenResponse.tenant()).contains("tenant_123")
        assertThat(messageMarkAsSeenResponse.updatedAt())
            .contains(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
        assertThat(messageMarkAsSeenResponse.workflow()).contains("comment-created")
    }
}
