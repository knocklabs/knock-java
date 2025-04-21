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
