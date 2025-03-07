// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import com.knock.api.core.JsonValue
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MessageUnarchiveResponseTest {

    @Test
    fun createMessageUnarchiveResponse() {
        val messageUnarchiveResponse =
            MessageUnarchiveResponse.builder()
                .id("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
                ._typename("Message")
                .addActor("user_123")
                .archivedAt(null)
                .channelId("123e4567-e89b-12d3-a456-426614174000")
                .clickedAt(null)
                .data(
                    MessageUnarchiveResponse.Data.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .addEngagementStatus(MessageUnarchiveResponse.EngagementStatus.SEEN)
                .addEngagementStatus(MessageUnarchiveResponse.EngagementStatus.READ)
                .insertedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                .interactedAt(null)
                .linkClickedAt(null)
                .metadata(
                    MessageUnarchiveResponse.Metadata.builder()
                        .putAdditionalProperty("external_id", JsonValue.from("bar"))
                        .build()
                )
                .readAt(null)
                .recipient("user_123")
                .scheduledAt(null)
                .seenAt(null)
                .source(
                    MessageUnarchiveResponse.Source.builder()
                        ._typename("NotificationSource")
                        .addCategory("collaboration")
                        .key("comment-created")
                        .versionId("123e4567-e89b-12d3-a456-426614174000")
                        .build()
                )
                .status(MessageUnarchiveResponse.Status.QUEUED)
                .tenant("tenant_123")
                .updatedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                .workflow("comment-created")
                .build()
        assertThat(messageUnarchiveResponse).isNotNull
        assertThat(messageUnarchiveResponse.id()).contains("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
        assertThat(messageUnarchiveResponse._typename()).contains("Message")
        assertThat(messageUnarchiveResponse.actors().get())
            .containsExactly(MessageUnarchiveResponse.Actor.ofString("user_123"))
        assertThat(messageUnarchiveResponse.archivedAt()).isEmpty
        assertThat(messageUnarchiveResponse.channelId())
            .contains("123e4567-e89b-12d3-a456-426614174000")
        assertThat(messageUnarchiveResponse.clickedAt()).isEmpty
        assertThat(messageUnarchiveResponse.data())
            .contains(
                MessageUnarchiveResponse.Data.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(messageUnarchiveResponse.engagementStatuses().get())
            .containsExactly(
                MessageUnarchiveResponse.EngagementStatus.SEEN,
                MessageUnarchiveResponse.EngagementStatus.READ,
            )
        assertThat(messageUnarchiveResponse.insertedAt())
            .contains(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
        assertThat(messageUnarchiveResponse.interactedAt()).isEmpty
        assertThat(messageUnarchiveResponse.linkClickedAt()).isEmpty
        assertThat(messageUnarchiveResponse.metadata())
            .contains(
                MessageUnarchiveResponse.Metadata.builder()
                    .putAdditionalProperty("external_id", JsonValue.from("bar"))
                    .build()
            )
        assertThat(messageUnarchiveResponse.readAt()).isEmpty
        assertThat(messageUnarchiveResponse.recipient())
            .contains(MessageUnarchiveResponse.Recipient.ofString("user_123"))
        assertThat(messageUnarchiveResponse.scheduledAt()).isEmpty
        assertThat(messageUnarchiveResponse.seenAt()).isEmpty
        assertThat(messageUnarchiveResponse.source())
            .contains(
                MessageUnarchiveResponse.Source.builder()
                    ._typename("NotificationSource")
                    .addCategory("collaboration")
                    .key("comment-created")
                    .versionId("123e4567-e89b-12d3-a456-426614174000")
                    .build()
            )
        assertThat(messageUnarchiveResponse.status())
            .contains(MessageUnarchiveResponse.Status.QUEUED)
        assertThat(messageUnarchiveResponse.tenant()).contains("tenant_123")
        assertThat(messageUnarchiveResponse.updatedAt())
            .contains(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
        assertThat(messageUnarchiveResponse.workflow()).contains("comment-created")
    }
}
