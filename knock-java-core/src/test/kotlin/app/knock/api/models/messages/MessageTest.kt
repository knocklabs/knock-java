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
                .id("2w3YUpTTOxuDvZFji8OMsKrG176")
                ._typename("Message")
                .addActor("mr_arnold")
                .addActor("mr_muldoon")
                .archivedAt(null)
                .channelId("123e4567-e89b-12d3-a456-426614174000")
                .clickedAt(null)
                .data(
                    Message.Data.builder()
                        .putAdditionalProperty("affected_areas", JsonValue.from("bar"))
                        .putAdditionalProperty("attraction_id", JsonValue.from("bar"))
                        .putAdditionalProperty("evacuation_protocol", JsonValue.from("bar"))
                        .putAdditionalProperty("message", JsonValue.from("bar"))
                        .putAdditionalProperty("severity", JsonValue.from("bar"))
                        .putAdditionalProperty("system_status", JsonValue.from("bar"))
                        .build()
                )
                .addEngagementStatus(Message.EngagementStatus.READ)
                .addEngagementStatus(Message.EngagementStatus.SEEN)
                .insertedAt(OffsetDateTime.parse("1993-06-11T21:15:00Z"))
                .interactedAt(null)
                .linkClickedAt(null)
                .metadata(
                    Message.Metadata.builder()
                        .putAdditionalProperty("incident_id", JsonValue.from("bar"))
                        .putAdditionalProperty("initiated_by", JsonValue.from("bar"))
                        .putAdditionalProperty("priority", JsonValue.from("bar"))
                        .build()
                )
                .readAt(OffsetDateTime.parse("1993-06-11T21:30:00Z"))
                .recipient("user_123")
                .scheduledAt(null)
                .seenAt(OffsetDateTime.parse("1993-06-11T21:29:45Z"))
                .source(
                    Message.Source.builder()
                        ._typename("Workflow")
                        .addCategory("security")
                        .addCategory("emergency")
                        .key("security-breach-alert")
                        .versionId("123e4567-e89b-12d3-a456-426614174000")
                        .build()
                )
                .status(Message.Status.SENT)
                .tenant("ingen_isla_nublar")
                .updatedAt(OffsetDateTime.parse("1993-06-11T21:30:05Z"))
                .workflow("security-breach-alert")
                .build()

        assertThat(message.id()).contains("2w3YUpTTOxuDvZFji8OMsKrG176")
        assertThat(message._typename()).contains("Message")
        assertThat(message.actors().getOrNull())
            .containsExactly(
                RecipientReference.ofUser("mr_arnold"),
                RecipientReference.ofUser("mr_muldoon"),
            )
        assertThat(message.archivedAt()).isEmpty
        assertThat(message.channelId()).contains("123e4567-e89b-12d3-a456-426614174000")
        assertThat(message.clickedAt()).isEmpty
        assertThat(message.data())
            .contains(
                Message.Data.builder()
                    .putAdditionalProperty("affected_areas", JsonValue.from("bar"))
                    .putAdditionalProperty("attraction_id", JsonValue.from("bar"))
                    .putAdditionalProperty("evacuation_protocol", JsonValue.from("bar"))
                    .putAdditionalProperty("message", JsonValue.from("bar"))
                    .putAdditionalProperty("severity", JsonValue.from("bar"))
                    .putAdditionalProperty("system_status", JsonValue.from("bar"))
                    .build()
            )
        assertThat(message.engagementStatuses().getOrNull())
            .containsExactly(Message.EngagementStatus.READ, Message.EngagementStatus.SEEN)
        assertThat(message.insertedAt()).contains(OffsetDateTime.parse("1993-06-11T21:15:00Z"))
        assertThat(message.interactedAt()).isEmpty
        assertThat(message.linkClickedAt()).isEmpty
        assertThat(message.metadata())
            .contains(
                Message.Metadata.builder()
                    .putAdditionalProperty("incident_id", JsonValue.from("bar"))
                    .putAdditionalProperty("initiated_by", JsonValue.from("bar"))
                    .putAdditionalProperty("priority", JsonValue.from("bar"))
                    .build()
            )
        assertThat(message.readAt()).contains(OffsetDateTime.parse("1993-06-11T21:30:00Z"))
        assertThat(message.recipient()).contains(RecipientReference.ofUser("user_123"))
        assertThat(message.scheduledAt()).isEmpty
        assertThat(message.seenAt()).contains(OffsetDateTime.parse("1993-06-11T21:29:45Z"))
        assertThat(message.source())
            .contains(
                Message.Source.builder()
                    ._typename("Workflow")
                    .addCategory("security")
                    .addCategory("emergency")
                    .key("security-breach-alert")
                    .versionId("123e4567-e89b-12d3-a456-426614174000")
                    .build()
            )
        assertThat(message.status()).contains(Message.Status.SENT)
        assertThat(message.tenant()).contains("ingen_isla_nublar")
        assertThat(message.updatedAt()).contains(OffsetDateTime.parse("1993-06-11T21:30:05Z"))
        assertThat(message.workflow()).contains("security-breach-alert")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val message =
            Message.builder()
                .id("2w3YUpTTOxuDvZFji8OMsKrG176")
                ._typename("Message")
                .addActor("mr_arnold")
                .addActor("mr_muldoon")
                .archivedAt(null)
                .channelId("123e4567-e89b-12d3-a456-426614174000")
                .clickedAt(null)
                .data(
                    Message.Data.builder()
                        .putAdditionalProperty("affected_areas", JsonValue.from("bar"))
                        .putAdditionalProperty("attraction_id", JsonValue.from("bar"))
                        .putAdditionalProperty("evacuation_protocol", JsonValue.from("bar"))
                        .putAdditionalProperty("message", JsonValue.from("bar"))
                        .putAdditionalProperty("severity", JsonValue.from("bar"))
                        .putAdditionalProperty("system_status", JsonValue.from("bar"))
                        .build()
                )
                .addEngagementStatus(Message.EngagementStatus.READ)
                .addEngagementStatus(Message.EngagementStatus.SEEN)
                .insertedAt(OffsetDateTime.parse("1993-06-11T21:15:00Z"))
                .interactedAt(null)
                .linkClickedAt(null)
                .metadata(
                    Message.Metadata.builder()
                        .putAdditionalProperty("incident_id", JsonValue.from("bar"))
                        .putAdditionalProperty("initiated_by", JsonValue.from("bar"))
                        .putAdditionalProperty("priority", JsonValue.from("bar"))
                        .build()
                )
                .readAt(OffsetDateTime.parse("1993-06-11T21:30:00Z"))
                .recipient("user_123")
                .scheduledAt(null)
                .seenAt(OffsetDateTime.parse("1993-06-11T21:29:45Z"))
                .source(
                    Message.Source.builder()
                        ._typename("Workflow")
                        .addCategory("security")
                        .addCategory("emergency")
                        .key("security-breach-alert")
                        .versionId("123e4567-e89b-12d3-a456-426614174000")
                        .build()
                )
                .status(Message.Status.SENT)
                .tenant("ingen_isla_nublar")
                .updatedAt(OffsetDateTime.parse("1993-06-11T21:30:05Z"))
                .workflow("security-breach-alert")
                .build()

        val roundtrippedMessage =
            jsonMapper.readValue(jsonMapper.writeValueAsString(message), jacksonTypeRef<Message>())

        assertThat(roundtrippedMessage).isEqualTo(message)
    }
}
