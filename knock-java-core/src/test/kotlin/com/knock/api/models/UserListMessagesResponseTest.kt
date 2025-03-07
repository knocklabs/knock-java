// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import com.knock.api.core.JsonValue
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UserListMessagesResponseTest {

    @Test
    fun createUserListMessagesResponse() {
        val userListMessagesResponse =
            UserListMessagesResponse.builder()
                .id("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
                ._typename("Message")
                .addActor("user_123")
                .archivedAt(null)
                .channelId("123e4567-e89b-12d3-a456-426614174000")
                .clickedAt(null)
                .data(
                    UserListMessagesResponse.Data.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .addEngagementStatus(UserListMessagesResponse.EngagementStatus.SEEN)
                .addEngagementStatus(UserListMessagesResponse.EngagementStatus.READ)
                .insertedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                .interactedAt(null)
                .linkClickedAt(null)
                .metadata(
                    UserListMessagesResponse.Metadata.builder()
                        .putAdditionalProperty("external_id", JsonValue.from("bar"))
                        .build()
                )
                .readAt(null)
                .recipient("user_123")
                .scheduledAt(null)
                .seenAt(null)
                .source(
                    UserListMessagesResponse.Source.builder()
                        ._typename("NotificationSource")
                        .addCategory("collaboration")
                        .key("comment-created")
                        .versionId("123e4567-e89b-12d3-a456-426614174000")
                        .build()
                )
                .status(UserListMessagesResponse.Status.QUEUED)
                .tenant("tenant_123")
                .updatedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                .workflow("comment-created")
                .build()
        assertThat(userListMessagesResponse).isNotNull
        assertThat(userListMessagesResponse.id()).contains("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
        assertThat(userListMessagesResponse._typename()).contains("Message")
        assertThat(userListMessagesResponse.actors().get())
            .containsExactly(UserListMessagesResponse.Actor.ofString("user_123"))
        assertThat(userListMessagesResponse.archivedAt()).isEmpty
        assertThat(userListMessagesResponse.channelId())
            .contains("123e4567-e89b-12d3-a456-426614174000")
        assertThat(userListMessagesResponse.clickedAt()).isEmpty
        assertThat(userListMessagesResponse.data())
            .contains(
                UserListMessagesResponse.Data.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(userListMessagesResponse.engagementStatuses().get())
            .containsExactly(
                UserListMessagesResponse.EngagementStatus.SEEN,
                UserListMessagesResponse.EngagementStatus.READ,
            )
        assertThat(userListMessagesResponse.insertedAt())
            .contains(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
        assertThat(userListMessagesResponse.interactedAt()).isEmpty
        assertThat(userListMessagesResponse.linkClickedAt()).isEmpty
        assertThat(userListMessagesResponse.metadata())
            .contains(
                UserListMessagesResponse.Metadata.builder()
                    .putAdditionalProperty("external_id", JsonValue.from("bar"))
                    .build()
            )
        assertThat(userListMessagesResponse.readAt()).isEmpty
        assertThat(userListMessagesResponse.recipient())
            .contains(UserListMessagesResponse.Recipient.ofString("user_123"))
        assertThat(userListMessagesResponse.scheduledAt()).isEmpty
        assertThat(userListMessagesResponse.seenAt()).isEmpty
        assertThat(userListMessagesResponse.source())
            .contains(
                UserListMessagesResponse.Source.builder()
                    ._typename("NotificationSource")
                    .addCategory("collaboration")
                    .key("comment-created")
                    .versionId("123e4567-e89b-12d3-a456-426614174000")
                    .build()
            )
        assertThat(userListMessagesResponse.status())
            .contains(UserListMessagesResponse.Status.QUEUED)
        assertThat(userListMessagesResponse.tenant()).contains("tenant_123")
        assertThat(userListMessagesResponse.updatedAt())
            .contains(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
        assertThat(userListMessagesResponse.workflow()).contains("comment-created")
    }
}
