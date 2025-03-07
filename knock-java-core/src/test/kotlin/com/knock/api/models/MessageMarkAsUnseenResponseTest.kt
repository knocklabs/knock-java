// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import com.knock.api.core.JsonValue
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MessageMarkAsUnseenResponseTest {

    @Test
    fun createMessageMarkAsUnseenResponse() {
        val messageMarkAsUnseenResponse =
            MessageMarkAsUnseenResponse.builder()
                .id("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
                ._typename("Message")
                .addActor("user_123")
                .archivedAt(null)
                .channelId("123e4567-e89b-12d3-a456-426614174000")
                .clickedAt(null)
                .data(
                    MessageMarkAsUnseenResponse.Data.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .addEngagementStatus(MessageMarkAsUnseenResponse.EngagementStatus.SEEN)
                .addEngagementStatus(MessageMarkAsUnseenResponse.EngagementStatus.READ)
                .insertedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                .interactedAt(null)
                .linkClickedAt(null)
                .metadata(
                    MessageMarkAsUnseenResponse.Metadata.builder()
                        .putAdditionalProperty("external_id", JsonValue.from("bar"))
                        .build()
                )
                .readAt(null)
                .recipient("user_123")
                .scheduledAt(null)
                .seenAt(null)
                .source(
                    MessageMarkAsUnseenResponse.Source.builder()
                        ._typename("NotificationSource")
                        .addCategory("collaboration")
                        .key("comment-created")
                        .versionId("123e4567-e89b-12d3-a456-426614174000")
                        .build()
                )
                .status(MessageMarkAsUnseenResponse.Status.QUEUED)
                .tenant("tenant_123")
                .updatedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                .workflow("comment-created")
                .build()
        assertThat(messageMarkAsUnseenResponse).isNotNull
        assertThat(messageMarkAsUnseenResponse.id()).contains("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
        assertThat(messageMarkAsUnseenResponse._typename()).contains("Message")
        assertThat(messageMarkAsUnseenResponse.actors().get())
            .containsExactly(MessageMarkAsUnseenResponse.Actor.ofString("user_123"))
        assertThat(messageMarkAsUnseenResponse.archivedAt()).isEmpty
        assertThat(messageMarkAsUnseenResponse.channelId())
            .contains("123e4567-e89b-12d3-a456-426614174000")
        assertThat(messageMarkAsUnseenResponse.clickedAt()).isEmpty
        assertThat(messageMarkAsUnseenResponse.data())
            .contains(
                MessageMarkAsUnseenResponse.Data.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(messageMarkAsUnseenResponse.engagementStatuses().get())
            .containsExactly(
                MessageMarkAsUnseenResponse.EngagementStatus.SEEN,
                MessageMarkAsUnseenResponse.EngagementStatus.READ,
            )
        assertThat(messageMarkAsUnseenResponse.insertedAt())
            .contains(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
        assertThat(messageMarkAsUnseenResponse.interactedAt()).isEmpty
        assertThat(messageMarkAsUnseenResponse.linkClickedAt()).isEmpty
        assertThat(messageMarkAsUnseenResponse.metadata())
            .contains(
                MessageMarkAsUnseenResponse.Metadata.builder()
                    .putAdditionalProperty("external_id", JsonValue.from("bar"))
                    .build()
            )
        assertThat(messageMarkAsUnseenResponse.readAt()).isEmpty
        assertThat(messageMarkAsUnseenResponse.recipient())
            .contains(MessageMarkAsUnseenResponse.Recipient.ofString("user_123"))
        assertThat(messageMarkAsUnseenResponse.scheduledAt()).isEmpty
        assertThat(messageMarkAsUnseenResponse.seenAt()).isEmpty
        assertThat(messageMarkAsUnseenResponse.source())
            .contains(
                MessageMarkAsUnseenResponse.Source.builder()
                    ._typename("NotificationSource")
                    .addCategory("collaboration")
                    .key("comment-created")
                    .versionId("123e4567-e89b-12d3-a456-426614174000")
                    .build()
            )
        assertThat(messageMarkAsUnseenResponse.status())
            .contains(MessageMarkAsUnseenResponse.Status.QUEUED)
        assertThat(messageMarkAsUnseenResponse.tenant()).contains("tenant_123")
        assertThat(messageMarkAsUnseenResponse.updatedAt())
            .contains(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
        assertThat(messageMarkAsUnseenResponse.workflow()).contains("comment-created")
    }
}
