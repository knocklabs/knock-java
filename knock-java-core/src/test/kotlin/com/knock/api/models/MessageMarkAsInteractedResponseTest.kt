// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import com.knock.api.core.JsonValue
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MessageMarkAsInteractedResponseTest {

    @Test
    fun createMessageMarkAsInteractedResponse() {
        val messageMarkAsInteractedResponse =
            MessageMarkAsInteractedResponse.builder()
                .id("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
                ._typename("Message")
                .addActor("user_123")
                .archivedAt(null)
                .channelId("123e4567-e89b-12d3-a456-426614174000")
                .clickedAt(null)
                .data(
                    MessageMarkAsInteractedResponse.Data.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .addEngagementStatus(MessageMarkAsInteractedResponse.EngagementStatus.SEEN)
                .addEngagementStatus(MessageMarkAsInteractedResponse.EngagementStatus.READ)
                .insertedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                .interactedAt(null)
                .linkClickedAt(null)
                .metadata(
                    MessageMarkAsInteractedResponse.Metadata.builder()
                        .putAdditionalProperty("external_id", JsonValue.from("bar"))
                        .build()
                )
                .readAt(null)
                .recipient("user_123")
                .scheduledAt(null)
                .seenAt(null)
                .source(
                    MessageMarkAsInteractedResponse.Source.builder()
                        ._typename("NotificationSource")
                        .addCategory("collaboration")
                        .key("comment-created")
                        .versionId("123e4567-e89b-12d3-a456-426614174000")
                        .build()
                )
                .status(MessageMarkAsInteractedResponse.Status.QUEUED)
                .tenant("tenant_123")
                .updatedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                .workflow("comment-created")
                .build()
        assertThat(messageMarkAsInteractedResponse).isNotNull
        assertThat(messageMarkAsInteractedResponse.id()).contains("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
        assertThat(messageMarkAsInteractedResponse._typename()).contains("Message")
        assertThat(messageMarkAsInteractedResponse.actors().get())
            .containsExactly(MessageMarkAsInteractedResponse.Actor.ofString("user_123"))
        assertThat(messageMarkAsInteractedResponse.archivedAt()).isEmpty
        assertThat(messageMarkAsInteractedResponse.channelId())
            .contains("123e4567-e89b-12d3-a456-426614174000")
        assertThat(messageMarkAsInteractedResponse.clickedAt()).isEmpty
        assertThat(messageMarkAsInteractedResponse.data())
            .contains(
                MessageMarkAsInteractedResponse.Data.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(messageMarkAsInteractedResponse.engagementStatuses().get())
            .containsExactly(
                MessageMarkAsInteractedResponse.EngagementStatus.SEEN,
                MessageMarkAsInteractedResponse.EngagementStatus.READ,
            )
        assertThat(messageMarkAsInteractedResponse.insertedAt())
            .contains(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
        assertThat(messageMarkAsInteractedResponse.interactedAt()).isEmpty
        assertThat(messageMarkAsInteractedResponse.linkClickedAt()).isEmpty
        assertThat(messageMarkAsInteractedResponse.metadata())
            .contains(
                MessageMarkAsInteractedResponse.Metadata.builder()
                    .putAdditionalProperty("external_id", JsonValue.from("bar"))
                    .build()
            )
        assertThat(messageMarkAsInteractedResponse.readAt()).isEmpty
        assertThat(messageMarkAsInteractedResponse.recipient())
            .contains(MessageMarkAsInteractedResponse.Recipient.ofString("user_123"))
        assertThat(messageMarkAsInteractedResponse.scheduledAt()).isEmpty
        assertThat(messageMarkAsInteractedResponse.seenAt()).isEmpty
        assertThat(messageMarkAsInteractedResponse.source())
            .contains(
                MessageMarkAsInteractedResponse.Source.builder()
                    ._typename("NotificationSource")
                    .addCategory("collaboration")
                    .key("comment-created")
                    .versionId("123e4567-e89b-12d3-a456-426614174000")
                    .build()
            )
        assertThat(messageMarkAsInteractedResponse.status())
            .contains(MessageMarkAsInteractedResponse.Status.QUEUED)
        assertThat(messageMarkAsInteractedResponse.tenant()).contains("tenant_123")
        assertThat(messageMarkAsInteractedResponse.updatedAt())
            .contains(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
        assertThat(messageMarkAsInteractedResponse.workflow()).contains("comment-created")
    }
}
