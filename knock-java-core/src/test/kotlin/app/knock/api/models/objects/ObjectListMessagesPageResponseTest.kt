// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.core.JsonValue
import app.knock.api.core.jsonMapper
import app.knock.api.models.messages.Message
import app.knock.api.models.shared.PageInfo
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ObjectListMessagesPageResponseTest {

    @Test
    fun create() {
        val objectListMessagesPageResponse =
            ObjectListMessagesPageResponse.builder()
                .addEntry(
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
                        .recipient("dr_grant")
                        .scheduledAt(null)
                        .seenAt(OffsetDateTime.parse("1993-06-11T21:29:45Z"))
                        .source(
                            Message.Source.builder()
                                ._typename("Workflow")
                                .addCategory("security")
                                .addCategory("emergency")
                                .key("security-breach-alert")
                                .versionId("raptor-containment-protocols-v3")
                                .build()
                        )
                        .status(Message.Status.SENT)
                        .tenant("ingen_isla_nublar")
                        .updatedAt(OffsetDateTime.parse("1993-06-11T21:30:05Z"))
                        .workflow("security-breach-alert")
                        .build()
                )
                .pageInfo(
                    PageInfo.builder()
                        ._typename("PageInfo")
                        .pageSize(25L)
                        .after(null)
                        .before(null)
                        .build()
                )
                .build()

        assertThat(objectListMessagesPageResponse.entries())
            .containsExactly(
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
                    .recipient("dr_grant")
                    .scheduledAt(null)
                    .seenAt(OffsetDateTime.parse("1993-06-11T21:29:45Z"))
                    .source(
                        Message.Source.builder()
                            ._typename("Workflow")
                            .addCategory("security")
                            .addCategory("emergency")
                            .key("security-breach-alert")
                            .versionId("raptor-containment-protocols-v3")
                            .build()
                    )
                    .status(Message.Status.SENT)
                    .tenant("ingen_isla_nublar")
                    .updatedAt(OffsetDateTime.parse("1993-06-11T21:30:05Z"))
                    .workflow("security-breach-alert")
                    .build()
            )
        assertThat(objectListMessagesPageResponse.pageInfo())
            .isEqualTo(
                PageInfo.builder()
                    ._typename("PageInfo")
                    .pageSize(25L)
                    .after(null)
                    .before(null)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val objectListMessagesPageResponse =
            ObjectListMessagesPageResponse.builder()
                .addEntry(
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
                        .recipient("dr_grant")
                        .scheduledAt(null)
                        .seenAt(OffsetDateTime.parse("1993-06-11T21:29:45Z"))
                        .source(
                            Message.Source.builder()
                                ._typename("Workflow")
                                .addCategory("security")
                                .addCategory("emergency")
                                .key("security-breach-alert")
                                .versionId("raptor-containment-protocols-v3")
                                .build()
                        )
                        .status(Message.Status.SENT)
                        .tenant("ingen_isla_nublar")
                        .updatedAt(OffsetDateTime.parse("1993-06-11T21:30:05Z"))
                        .workflow("security-breach-alert")
                        .build()
                )
                .pageInfo(
                    PageInfo.builder()
                        ._typename("PageInfo")
                        .pageSize(25L)
                        .after(null)
                        .before(null)
                        .build()
                )
                .build()

        val roundtrippedObjectListMessagesPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(objectListMessagesPageResponse),
                jacksonTypeRef<ObjectListMessagesPageResponse>(),
            )

        assertThat(roundtrippedObjectListMessagesPageResponse)
            .isEqualTo(objectListMessagesPageResponse)
    }
}
