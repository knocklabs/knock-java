// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages

import app.knock.api.core.JsonValue
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageTest {

    @Test
    fun create() {
        val message =
            Message.builder()
                .id("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
                ._typename("Message")
                .addActor("user_123")
                .archivedAt(null)
                .channelId("123e4567-e89b-12d3-a456-426614174000")
                .clickedAt(null)
                .data(
                    Message.Data.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .addEngagementStatus(Message.EngagementStatus.SEEN)
                .addEngagementStatus(Message.EngagementStatus.READ)
                .insertedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                .interactedAt(null)
                .linkClickedAt(null)
                .metadata(
                    Message.Metadata.builder()
                        .putAdditionalProperty("external_id", JsonValue.from("bar"))
                        .build()
                )
                .readAt(null)
                .recipient("user_123")
                .scheduledAt(null)
                .seenAt(null)
                .source(
                    Message.Source.builder()
                        ._typename("NotificationSource")
                        .addCategory("collaboration")
                        .key("comment-created")
                        .versionId("123e4567-e89b-12d3-a456-426614174000")
                        .build()
                )
                .status(Message.Status.QUEUED)
                .tenant("tenant_123")
                .updatedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                .workflow("comment-created")
                .build()

        assertThat(message.id()).contains("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
        assertThat(message._typename()).contains("Message")
        assertThat(message.actors().getOrNull()).containsExactly(Message.Actor.ofString("user_123"))
        assertThat(message.archivedAt()).isEmpty
        assertThat(message.channelId()).contains("123e4567-e89b-12d3-a456-426614174000")
        assertThat(message.clickedAt()).isEmpty
        assertThat(message.data())
            .contains(
                Message.Data.builder().putAdditionalProperty("foo", JsonValue.from("bar")).build()
            )
        assertThat(message.engagementStatuses().getOrNull())
            .containsExactly(Message.EngagementStatus.SEEN, Message.EngagementStatus.READ)
        assertThat(message.insertedAt()).contains(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
        assertThat(message.interactedAt()).isEmpty
        assertThat(message.linkClickedAt()).isEmpty
        assertThat(message.metadata())
            .contains(
                Message.Metadata.builder()
                    .putAdditionalProperty("external_id", JsonValue.from("bar"))
                    .build()
            )
        assertThat(message.readAt()).isEmpty
        assertThat(message.recipient()).contains(Message.Recipient.ofString("user_123"))
        assertThat(message.scheduledAt()).isEmpty
        assertThat(message.seenAt()).isEmpty
        assertThat(message.source())
            .contains(
                Message.Source.builder()
                    ._typename("NotificationSource")
                    .addCategory("collaboration")
                    .key("comment-created")
                    .versionId("123e4567-e89b-12d3-a456-426614174000")
                    .build()
            )
        assertThat(message.status()).contains(Message.Status.QUEUED)
        assertThat(message.tenant()).contains("tenant_123")
        assertThat(message.updatedAt()).contains(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
        assertThat(message.workflow()).contains("comment-created")
    }
}
