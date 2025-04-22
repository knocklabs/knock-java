// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages

import app.knock.api.core.JsonValue
import app.knock.api.core.jsonMapper
import app.knock.api.models.shared.PageInfo
import app.knock.api.models.users.User
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageListActivitiesResponseTest {

    @Test
    fun create() {
        val messageListActivitiesResponse =
            MessageListActivitiesResponse.builder()
                .addEntry(
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
                .pageInfo(
                    PageInfo.builder()
                        ._typename("PageInfo")
                        .pageSize(25L)
                        .after(null)
                        .before(null)
                        .build()
                )
                .build()

        assertThat(messageListActivitiesResponse.entries())
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
        assertThat(messageListActivitiesResponse.pageInfo())
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
        val messageListActivitiesResponse =
            MessageListActivitiesResponse.builder()
                .addEntry(
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
                .pageInfo(
                    PageInfo.builder()
                        ._typename("PageInfo")
                        .pageSize(25L)
                        .after(null)
                        .before(null)
                        .build()
                )
                .build()

        val roundtrippedMessageListActivitiesResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageListActivitiesResponse),
                jacksonTypeRef<MessageListActivitiesResponse>(),
            )

        assertThat(roundtrippedMessageListActivitiesResponse)
            .isEqualTo(messageListActivitiesResponse)
    }
}
