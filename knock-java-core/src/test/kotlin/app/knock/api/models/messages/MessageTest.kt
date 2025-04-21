// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages

import app.knock.api.core.JsonValue
import app.knock.api.core.jsonMapper
import app.knock.api.models.recipients.RecipientReference
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageTest {

    @Test
    fun create() {
        val message =
            Message.builder()
                .id("id")
                ._typename("Message")
                .addActor("user_123")
                .archivedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .clickedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    Message.Data.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .addEngagementStatus(Message.EngagementStatus.READ)
                .addEngagementStatus(Message.EngagementStatus.SEEN)
                .insertedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .interactedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .linkClickedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .metadata(
                    Message.Metadata.builder()
                        .putAdditionalProperty("external_id", JsonValue.from("bar"))
                        .build()
                )
                .readAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .recipient("user_123")
                .scheduledAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .seenAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .source(
                    Message.Source.builder()
                        ._typename("Guide")
                        .addCategory("collaboration")
                        .key("comment-created")
                        .versionId("123e4567-e89b-12d3-a456-426614174000")
                        .build()
                )
                .status(Message.Status.SENT)
                .tenant("tenant")
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .workflow("workflow")
                .build()

        assertThat(message.id()).contains("id")
        assertThat(message._typename()).contains("Message")
        assertThat(message.actors().getOrNull())
            .containsExactly(RecipientReference.ofUser("user_123"))
        assertThat(message.archivedAt()).contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(message.channelId()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(message.clickedAt()).contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(message.data())
            .contains(
                Message.Data.builder().putAdditionalProperty("foo", JsonValue.from("bar")).build()
            )
        assertThat(message.engagementStatuses().getOrNull())
            .containsExactly(Message.EngagementStatus.READ, Message.EngagementStatus.SEEN)
        assertThat(message.insertedAt()).contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(message.interactedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(message.linkClickedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(message.metadata())
            .contains(
                Message.Metadata.builder()
                    .putAdditionalProperty("external_id", JsonValue.from("bar"))
                    .build()
            )
        assertThat(message.readAt()).contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(message.recipient()).contains(RecipientReference.ofUser("user_123"))
        assertThat(message.scheduledAt()).contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(message.seenAt()).contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(message.source())
            .contains(
                Message.Source.builder()
                    ._typename("Guide")
                    .addCategory("collaboration")
                    .key("comment-created")
                    .versionId("123e4567-e89b-12d3-a456-426614174000")
                    .build()
            )
        assertThat(message.status()).contains(Message.Status.SENT)
        assertThat(message.tenant()).contains("tenant")
        assertThat(message.updatedAt()).contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(message.workflow()).contains("workflow")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val message =
            Message.builder()
                .id("id")
                ._typename("Message")
                .addActor("user_123")
                .archivedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .clickedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    Message.Data.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .addEngagementStatus(Message.EngagementStatus.READ)
                .addEngagementStatus(Message.EngagementStatus.SEEN)
                .insertedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .interactedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .linkClickedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .metadata(
                    Message.Metadata.builder()
                        .putAdditionalProperty("external_id", JsonValue.from("bar"))
                        .build()
                )
                .readAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .recipient("user_123")
                .scheduledAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .seenAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .source(
                    Message.Source.builder()
                        ._typename("Guide")
                        .addCategory("collaboration")
                        .key("comment-created")
                        .versionId("123e4567-e89b-12d3-a456-426614174000")
                        .build()
                )
                .status(Message.Status.SENT)
                .tenant("tenant")
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .workflow("workflow")
                .build()

        val roundtrippedMessage =
            jsonMapper.readValue(jsonMapper.writeValueAsString(message), jacksonTypeRef<Message>())

        assertThat(roundtrippedMessage).isEqualTo(message)
    }
}
