// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.core.JsonValue
import app.knock.api.core.jsonMapper
import app.knock.api.models.messages.Message
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
                        .addEngagementStatus(Message.EngagementStatus.READ)
                        .addEngagementStatus(Message.EngagementStatus.SEEN)
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
                        .status(Message.Status.SENT)
                        .tenant("tenant_123")
                        .updatedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                        .workflow("comment-created")
                        .build()
                )
                .pageInfo(
                    ObjectListMessagesPageResponse.PageInfo.builder()
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
                    .addEngagementStatus(Message.EngagementStatus.READ)
                    .addEngagementStatus(Message.EngagementStatus.SEEN)
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
                    .status(Message.Status.SENT)
                    .tenant("tenant_123")
                    .updatedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                    .workflow("comment-created")
                    .build()
            )
        assertThat(objectListMessagesPageResponse.pageInfo())
            .isEqualTo(
                ObjectListMessagesPageResponse.PageInfo.builder()
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
                        .addEngagementStatus(Message.EngagementStatus.READ)
                        .addEngagementStatus(Message.EngagementStatus.SEEN)
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
                        .status(Message.Status.SENT)
                        .tenant("tenant_123")
                        .updatedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                        .workflow("comment-created")
                        .build()
                )
                .pageInfo(
                    ObjectListMessagesPageResponse.PageInfo.builder()
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
