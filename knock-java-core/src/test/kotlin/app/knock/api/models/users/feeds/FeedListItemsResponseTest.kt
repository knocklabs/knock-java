// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users.feeds

import app.knock.api.core.JsonValue
import app.knock.api.core.jsonMapper
import app.knock.api.models.messages.Activity
import app.knock.api.models.recipients.Recipient
import app.knock.api.models.users.User
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FeedListItemsResponseTest {

    @Test
    fun create() {
        val feedListItemsResponse =
            FeedListItemsResponse.builder()
                .id("2FVHPWxRqNuXQ9krvNP5A6Z4qXe")
                ._typename("FeedItem")
                .addActivity(
                    Activity.builder()
                        .id("2FVHPWxRqNuXQ9krvNP5A6Z4qXe")
                        ._typename("Activity")
                        .actor(
                            User.builder()
                                .id("id")
                                ._typename("User")
                                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .avatar("avatar")
                                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .email("email")
                                .name("name")
                                .phoneNumber("phone_number")
                                .timezone("timezone")
                                .build()
                        )
                        .data(
                            Activity.Data.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .insertedAt(OffsetDateTime.parse("2024-01-01T00:00:00Z"))
                        .recipient(
                            User.builder()
                                .id("jane")
                                ._typename("User")
                                .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                                .avatar(null)
                                .createdAt(null)
                                .email("jane@ingen.net")
                                .name("Jane Doe")
                                .phoneNumber(null)
                                .timezone(null)
                                .build()
                        )
                        .updatedAt(OffsetDateTime.parse("2024-01-01T00:00:00Z"))
                        .build()
                )
                .addActor(
                    User.builder()
                        .id("jane")
                        ._typename("User")
                        .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                        .avatar(null)
                        .createdAt(null)
                        .email("jane@ingen.net")
                        .name("Jane Doe")
                        .phoneNumber(null)
                        .timezone(null)
                        .build()
                )
                .addBlock(
                    FeedListItemsResponse.Block.MessageInAppFeedContentBlock.builder()
                        .content("This is a message in an app feed")
                        .name("body")
                        .rendered("<p>This is a message in an app feed</p>")
                        .type(
                            FeedListItemsResponse.Block.MessageInAppFeedContentBlock.Type.MARKDOWN
                        )
                        .build()
                )
                .data(
                    FeedListItemsResponse.Data.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .insertedAt("2021-01-01T00:00:00Z")
                .source(
                    FeedListItemsResponse.Source.builder()
                        ._typename("NotificationSource")
                        .addCategory("collaboration")
                        .key("my_source")
                        .versionId("123e4567-e89b-12d3-a456-426614174000")
                        .build()
                )
                .tenant("acme_corp")
                .totalActivities(10L)
                .totalActors(5L)
                .updatedAt("2021-01-01T00:00:00Z")
                .archivedAt("archived_at")
                .clickedAt("clicked_at")
                .interactedAt("interacted_at")
                .linkClickedAt("link_clicked_at")
                .readAt("read_at")
                .seenAt("seen_at")
                .build()

        assertThat(feedListItemsResponse.id()).isEqualTo("2FVHPWxRqNuXQ9krvNP5A6Z4qXe")
        assertThat(feedListItemsResponse._typename()).isEqualTo("FeedItem")
        assertThat(feedListItemsResponse.activities())
            .containsExactly(
                Activity.builder()
                    .id("2FVHPWxRqNuXQ9krvNP5A6Z4qXe")
                    ._typename("Activity")
                    .actor(
                        User.builder()
                            .id("id")
                            ._typename("User")
                            .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .avatar("avatar")
                            .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .email("email")
                            .name("name")
                            .phoneNumber("phone_number")
                            .timezone("timezone")
                            .build()
                    )
                    .data(
                        Activity.Data.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .insertedAt(OffsetDateTime.parse("2024-01-01T00:00:00Z"))
                    .recipient(
                        User.builder()
                            .id("jane")
                            ._typename("User")
                            .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                            .avatar(null)
                            .createdAt(null)
                            .email("jane@ingen.net")
                            .name("Jane Doe")
                            .phoneNumber(null)
                            .timezone(null)
                            .build()
                    )
                    .updatedAt(OffsetDateTime.parse("2024-01-01T00:00:00Z"))
                    .build()
            )
        assertThat(feedListItemsResponse.actors())
            .containsExactly(
                Recipient.ofUser(
                    User.builder()
                        .id("jane")
                        ._typename("User")
                        .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                        .avatar(null)
                        .createdAt(null)
                        .email("jane@ingen.net")
                        .name("Jane Doe")
                        .phoneNumber(null)
                        .timezone(null)
                        .build()
                )
            )
        assertThat(feedListItemsResponse.blocks())
            .containsExactly(
                FeedListItemsResponse.Block.ofMessageInAppFeedContent(
                    FeedListItemsResponse.Block.MessageInAppFeedContentBlock.builder()
                        .content("This is a message in an app feed")
                        .name("body")
                        .rendered("<p>This is a message in an app feed</p>")
                        .type(
                            FeedListItemsResponse.Block.MessageInAppFeedContentBlock.Type.MARKDOWN
                        )
                        .build()
                )
            )
        assertThat(feedListItemsResponse.data())
            .contains(
                FeedListItemsResponse.Data.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(feedListItemsResponse.insertedAt()).isEqualTo("2021-01-01T00:00:00Z")
        assertThat(feedListItemsResponse.source())
            .isEqualTo(
                FeedListItemsResponse.Source.builder()
                    ._typename("NotificationSource")
                    .addCategory("collaboration")
                    .key("my_source")
                    .versionId("123e4567-e89b-12d3-a456-426614174000")
                    .build()
            )
        assertThat(feedListItemsResponse.tenant()).contains("acme_corp")
        assertThat(feedListItemsResponse.totalActivities()).isEqualTo(10L)
        assertThat(feedListItemsResponse.totalActors()).isEqualTo(5L)
        assertThat(feedListItemsResponse.updatedAt()).isEqualTo("2021-01-01T00:00:00Z")
        assertThat(feedListItemsResponse.archivedAt()).contains("archived_at")
        assertThat(feedListItemsResponse.clickedAt()).contains("clicked_at")
        assertThat(feedListItemsResponse.interactedAt()).contains("interacted_at")
        assertThat(feedListItemsResponse.linkClickedAt()).contains("link_clicked_at")
        assertThat(feedListItemsResponse.readAt()).contains("read_at")
        assertThat(feedListItemsResponse.seenAt()).contains("seen_at")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val feedListItemsResponse =
            FeedListItemsResponse.builder()
                .id("2FVHPWxRqNuXQ9krvNP5A6Z4qXe")
                ._typename("FeedItem")
                .addActivity(
                    Activity.builder()
                        .id("2FVHPWxRqNuXQ9krvNP5A6Z4qXe")
                        ._typename("Activity")
                        .actor(
                            User.builder()
                                .id("id")
                                ._typename("User")
                                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .avatar("avatar")
                                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .email("email")
                                .name("name")
                                .phoneNumber("phone_number")
                                .timezone("timezone")
                                .build()
                        )
                        .data(
                            Activity.Data.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .insertedAt(OffsetDateTime.parse("2024-01-01T00:00:00Z"))
                        .recipient(
                            User.builder()
                                .id("jane")
                                ._typename("User")
                                .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                                .avatar(null)
                                .createdAt(null)
                                .email("jane@ingen.net")
                                .name("Jane Doe")
                                .phoneNumber(null)
                                .timezone(null)
                                .build()
                        )
                        .updatedAt(OffsetDateTime.parse("2024-01-01T00:00:00Z"))
                        .build()
                )
                .addActor(
                    User.builder()
                        .id("jane")
                        ._typename("User")
                        .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                        .avatar(null)
                        .createdAt(null)
                        .email("jane@ingen.net")
                        .name("Jane Doe")
                        .phoneNumber(null)
                        .timezone(null)
                        .build()
                )
                .addBlock(
                    FeedListItemsResponse.Block.MessageInAppFeedContentBlock.builder()
                        .content("This is a message in an app feed")
                        .name("body")
                        .rendered("<p>This is a message in an app feed</p>")
                        .type(
                            FeedListItemsResponse.Block.MessageInAppFeedContentBlock.Type.MARKDOWN
                        )
                        .build()
                )
                .data(
                    FeedListItemsResponse.Data.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .insertedAt("2021-01-01T00:00:00Z")
                .source(
                    FeedListItemsResponse.Source.builder()
                        ._typename("NotificationSource")
                        .addCategory("collaboration")
                        .key("my_source")
                        .versionId("123e4567-e89b-12d3-a456-426614174000")
                        .build()
                )
                .tenant("acme_corp")
                .totalActivities(10L)
                .totalActors(5L)
                .updatedAt("2021-01-01T00:00:00Z")
                .archivedAt("archived_at")
                .clickedAt("clicked_at")
                .interactedAt("interacted_at")
                .linkClickedAt("link_clicked_at")
                .readAt("read_at")
                .seenAt("seen_at")
                .build()

        val roundtrippedFeedListItemsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(feedListItemsResponse),
                jacksonTypeRef<FeedListItemsResponse>(),
            )

        assertThat(roundtrippedFeedListItemsResponse).isEqualTo(feedListItemsResponse)
    }
}
