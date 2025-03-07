// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import com.knock.api.core.JsonValue
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ObjectListMessagesResponseTest {

    @Test
    fun createObjectListMessagesResponse() {
        val objectListMessagesResponse =
            ObjectListMessagesResponse.builder()
                .id("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
                ._typename("Message")
                .addActor("user_123")
                .archivedAt(null)
                .channelId("123e4567-e89b-12d3-a456-426614174000")
                .clickedAt(null)
                .data(
                    ObjectListMessagesResponse.Data.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .addEngagementStatus(ObjectListMessagesResponse.EngagementStatus.SEEN)
                .addEngagementStatus(ObjectListMessagesResponse.EngagementStatus.READ)
                .insertedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                .interactedAt(null)
                .linkClickedAt(null)
                .metadata(
                    ObjectListMessagesResponse.Metadata.builder()
                        .putAdditionalProperty("external_id", JsonValue.from("bar"))
                        .build()
                )
                .readAt(null)
                .recipient("user_123")
                .scheduledAt(null)
                .seenAt(null)
                .source(
                    ObjectListMessagesResponse.Source.builder()
                        ._typename("NotificationSource")
                        .addCategory("collaboration")
                        .key("comment-created")
                        .versionId("123e4567-e89b-12d3-a456-426614174000")
                        .build()
                )
                .status(ObjectListMessagesResponse.Status.QUEUED)
                .tenant("tenant_123")
                .updatedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                .workflow("comment-created")
                .build()
        assertThat(objectListMessagesResponse).isNotNull
        assertThat(objectListMessagesResponse.id()).contains("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
        assertThat(objectListMessagesResponse._typename()).contains("Message")
        assertThat(objectListMessagesResponse.actors().get())
            .containsExactly(ObjectListMessagesResponse.Actor.ofString("user_123"))
        assertThat(objectListMessagesResponse.archivedAt()).isEmpty
        assertThat(objectListMessagesResponse.channelId())
            .contains("123e4567-e89b-12d3-a456-426614174000")
        assertThat(objectListMessagesResponse.clickedAt()).isEmpty
        assertThat(objectListMessagesResponse.data())
            .contains(
                ObjectListMessagesResponse.Data.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(objectListMessagesResponse.engagementStatuses().get())
            .containsExactly(
                ObjectListMessagesResponse.EngagementStatus.SEEN,
                ObjectListMessagesResponse.EngagementStatus.READ,
            )
        assertThat(objectListMessagesResponse.insertedAt())
            .contains(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
        assertThat(objectListMessagesResponse.interactedAt()).isEmpty
        assertThat(objectListMessagesResponse.linkClickedAt()).isEmpty
        assertThat(objectListMessagesResponse.metadata())
            .contains(
                ObjectListMessagesResponse.Metadata.builder()
                    .putAdditionalProperty("external_id", JsonValue.from("bar"))
                    .build()
            )
        assertThat(objectListMessagesResponse.readAt()).isEmpty
        assertThat(objectListMessagesResponse.recipient())
            .contains(ObjectListMessagesResponse.Recipient.ofString("user_123"))
        assertThat(objectListMessagesResponse.scheduledAt()).isEmpty
        assertThat(objectListMessagesResponse.seenAt()).isEmpty
        assertThat(objectListMessagesResponse.source())
            .contains(
                ObjectListMessagesResponse.Source.builder()
                    ._typename("NotificationSource")
                    .addCategory("collaboration")
                    .key("comment-created")
                    .versionId("123e4567-e89b-12d3-a456-426614174000")
                    .build()
            )
        assertThat(objectListMessagesResponse.status())
            .contains(ObjectListMessagesResponse.Status.QUEUED)
        assertThat(objectListMessagesResponse.tenant()).contains("tenant_123")
        assertThat(objectListMessagesResponse.updatedAt())
            .contains(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
        assertThat(objectListMessagesResponse.workflow()).contains("comment-created")
    }
}
