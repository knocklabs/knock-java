// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import com.knock.api.core.JsonValue
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MessageMarkAsReadResponseTest {

    @Test
    fun createMessageMarkAsReadResponse() {
        val messageMarkAsReadResponse =
            MessageMarkAsReadResponse.builder()
                .id("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
                ._typename("Message")
                .addActor("user_123")
                .archivedAt(null)
                .channelId("123e4567-e89b-12d3-a456-426614174000")
                .clickedAt(null)
                .data(
                    MessageMarkAsReadResponse.Data.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .addEngagementStatus(MessageMarkAsReadResponse.EngagementStatus.SEEN)
                .addEngagementStatus(MessageMarkAsReadResponse.EngagementStatus.READ)
                .insertedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                .interactedAt(null)
                .linkClickedAt(null)
                .metadata(
                    MessageMarkAsReadResponse.Metadata.builder()
                        .putAdditionalProperty("external_id", JsonValue.from("bar"))
                        .build()
                )
                .readAt(null)
                .recipient("user_123")
                .scheduledAt(null)
                .seenAt(null)
                .source(
                    MessageMarkAsReadResponse.Source.builder()
                        ._typename("NotificationSource")
                        .addCategory("collaboration")
                        .key("comment-created")
                        .versionId("123e4567-e89b-12d3-a456-426614174000")
                        .build()
                )
                .status(MessageMarkAsReadResponse.Status.QUEUED)
                .tenant("tenant_123")
                .updatedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                .workflow("comment-created")
                .build()
        assertThat(messageMarkAsReadResponse).isNotNull
        assertThat(messageMarkAsReadResponse.id()).contains("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
        assertThat(messageMarkAsReadResponse._typename()).contains("Message")
        assertThat(messageMarkAsReadResponse.actors().get())
            .containsExactly(MessageMarkAsReadResponse.Actor.ofString("user_123"))
        assertThat(messageMarkAsReadResponse.archivedAt()).isEmpty
        assertThat(messageMarkAsReadResponse.channelId())
            .contains("123e4567-e89b-12d3-a456-426614174000")
        assertThat(messageMarkAsReadResponse.clickedAt()).isEmpty
        assertThat(messageMarkAsReadResponse.data())
            .contains(
                MessageMarkAsReadResponse.Data.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(messageMarkAsReadResponse.engagementStatuses().get())
            .containsExactly(
                MessageMarkAsReadResponse.EngagementStatus.SEEN,
                MessageMarkAsReadResponse.EngagementStatus.READ,
            )
        assertThat(messageMarkAsReadResponse.insertedAt())
            .contains(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
        assertThat(messageMarkAsReadResponse.interactedAt()).isEmpty
        assertThat(messageMarkAsReadResponse.linkClickedAt()).isEmpty
        assertThat(messageMarkAsReadResponse.metadata())
            .contains(
                MessageMarkAsReadResponse.Metadata.builder()
                    .putAdditionalProperty("external_id", JsonValue.from("bar"))
                    .build()
            )
        assertThat(messageMarkAsReadResponse.readAt()).isEmpty
        assertThat(messageMarkAsReadResponse.recipient())
            .contains(MessageMarkAsReadResponse.Recipient.ofString("user_123"))
        assertThat(messageMarkAsReadResponse.scheduledAt()).isEmpty
        assertThat(messageMarkAsReadResponse.seenAt()).isEmpty
        assertThat(messageMarkAsReadResponse.source())
            .contains(
                MessageMarkAsReadResponse.Source.builder()
                    ._typename("NotificationSource")
                    .addCategory("collaboration")
                    .key("comment-created")
                    .versionId("123e4567-e89b-12d3-a456-426614174000")
                    .build()
            )
        assertThat(messageMarkAsReadResponse.status())
            .contains(MessageMarkAsReadResponse.Status.QUEUED)
        assertThat(messageMarkAsReadResponse.tenant()).contains("tenant_123")
        assertThat(messageMarkAsReadResponse.updatedAt())
            .contains(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
        assertThat(messageMarkAsReadResponse.workflow()).contains("comment-created")
    }
}
