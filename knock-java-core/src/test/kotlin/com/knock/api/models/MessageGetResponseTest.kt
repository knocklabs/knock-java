// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import com.knock.api.core.JsonValue
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MessageGetResponseTest {

    @Test
    fun createMessageGetResponse() {
        val messageGetResponse =
            MessageGetResponse.builder()
                .id("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
                ._typename("Message")
                .addActor("user_123")
                .archivedAt(null)
                .channelId("123e4567-e89b-12d3-a456-426614174000")
                .clickedAt(null)
                .data(
                    MessageGetResponse.Data.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .addEngagementStatus(MessageGetResponse.EngagementStatus.SEEN)
                .addEngagementStatus(MessageGetResponse.EngagementStatus.READ)
                .insertedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                .interactedAt(null)
                .linkClickedAt(null)
                .metadata(
                    MessageGetResponse.Metadata.builder()
                        .putAdditionalProperty("external_id", JsonValue.from("bar"))
                        .build()
                )
                .readAt(null)
                .recipient("user_123")
                .scheduledAt(null)
                .seenAt(null)
                .source(
                    MessageGetResponse.Source.builder()
                        ._typename("NotificationSource")
                        .addCategory("collaboration")
                        .key("comment-created")
                        .versionId("123e4567-e89b-12d3-a456-426614174000")
                        .build()
                )
                .status(MessageGetResponse.Status.QUEUED)
                .tenant("tenant_123")
                .updatedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                .workflow("comment-created")
                .build()
        assertThat(messageGetResponse).isNotNull
        assertThat(messageGetResponse.id()).contains("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
        assertThat(messageGetResponse._typename()).contains("Message")
        assertThat(messageGetResponse.actors().get())
            .containsExactly(MessageGetResponse.Actor.ofString("user_123"))
        assertThat(messageGetResponse.archivedAt()).isEmpty
        assertThat(messageGetResponse.channelId()).contains("123e4567-e89b-12d3-a456-426614174000")
        assertThat(messageGetResponse.clickedAt()).isEmpty
        assertThat(messageGetResponse.data())
            .contains(
                MessageGetResponse.Data.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(messageGetResponse.engagementStatuses().get())
            .containsExactly(
                MessageGetResponse.EngagementStatus.SEEN,
                MessageGetResponse.EngagementStatus.READ,
            )
        assertThat(messageGetResponse.insertedAt())
            .contains(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
        assertThat(messageGetResponse.interactedAt()).isEmpty
        assertThat(messageGetResponse.linkClickedAt()).isEmpty
        assertThat(messageGetResponse.metadata())
            .contains(
                MessageGetResponse.Metadata.builder()
                    .putAdditionalProperty("external_id", JsonValue.from("bar"))
                    .build()
            )
        assertThat(messageGetResponse.readAt()).isEmpty
        assertThat(messageGetResponse.recipient())
            .contains(MessageGetResponse.Recipient.ofString("user_123"))
        assertThat(messageGetResponse.scheduledAt()).isEmpty
        assertThat(messageGetResponse.seenAt()).isEmpty
        assertThat(messageGetResponse.source())
            .contains(
                MessageGetResponse.Source.builder()
                    ._typename("NotificationSource")
                    .addCategory("collaboration")
                    .key("comment-created")
                    .versionId("123e4567-e89b-12d3-a456-426614174000")
                    .build()
            )
        assertThat(messageGetResponse.status()).contains(MessageGetResponse.Status.QUEUED)
        assertThat(messageGetResponse.tenant()).contains("tenant_123")
        assertThat(messageGetResponse.updatedAt())
            .contains(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
        assertThat(messageGetResponse.workflow()).contains("comment-created")
    }
}
