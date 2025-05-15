// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.core.JsonValue
import app.knock.api.core.jsonMapper
import app.knock.api.models.objects.Object
import app.knock.api.models.recipients.subscriptions.Subscription
import app.knock.api.models.shared.PageInfo
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserListSubscriptionsPageResponseTest {

    @Test
    fun create() {
        val userListSubscriptionsPageResponse =
            UserListSubscriptionsPageResponse.builder()
                .addEntry(
                    Subscription.builder()
                        ._typename("Subscription")
                        .insertedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                        .object_(
                            Object.builder()
                                .id("specimen_25")
                                ._typename("Object")
                                .collection("assets")
                                .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                                .createdAt(null)
                                .properties(
                                    Object.Properties.builder()
                                        .putAdditionalProperty(
                                            "classification",
                                            JsonValue.from("bar"),
                                        )
                                        .putAdditionalProperty("config", JsonValue.from("bar"))
                                        .putAdditionalProperty("name", JsonValue.from("bar"))
                                        .putAdditionalProperty("status", JsonValue.from("bar"))
                                        .build()
                                )
                                .build()
                        )
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
                        .updatedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                        .properties(
                            Subscription.Properties.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
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

        assertThat(userListSubscriptionsPageResponse.entries())
            .containsExactly(
                Subscription.builder()
                    ._typename("Subscription")
                    .insertedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                    .object_(
                        Object.builder()
                            .id("specimen_25")
                            ._typename("Object")
                            .collection("assets")
                            .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                            .createdAt(null)
                            .properties(
                                Object.Properties.builder()
                                    .putAdditionalProperty("classification", JsonValue.from("bar"))
                                    .putAdditionalProperty("config", JsonValue.from("bar"))
                                    .putAdditionalProperty("name", JsonValue.from("bar"))
                                    .putAdditionalProperty("status", JsonValue.from("bar"))
                                    .build()
                            )
                            .build()
                    )
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
                    .updatedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                    .properties(
                        Subscription.Properties.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .build()
            )
        assertThat(userListSubscriptionsPageResponse.pageInfo())
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
        val userListSubscriptionsPageResponse =
            UserListSubscriptionsPageResponse.builder()
                .addEntry(
                    Subscription.builder()
                        ._typename("Subscription")
                        .insertedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                        .object_(
                            Object.builder()
                                .id("specimen_25")
                                ._typename("Object")
                                .collection("assets")
                                .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                                .createdAt(null)
                                .properties(
                                    Object.Properties.builder()
                                        .putAdditionalProperty(
                                            "classification",
                                            JsonValue.from("bar"),
                                        )
                                        .putAdditionalProperty("config", JsonValue.from("bar"))
                                        .putAdditionalProperty("name", JsonValue.from("bar"))
                                        .putAdditionalProperty("status", JsonValue.from("bar"))
                                        .build()
                                )
                                .build()
                        )
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
                        .updatedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                        .properties(
                            Subscription.Properties.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
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

        val roundtrippedUserListSubscriptionsPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(userListSubscriptionsPageResponse),
                jacksonTypeRef<UserListSubscriptionsPageResponse>(),
            )

        assertThat(roundtrippedUserListSubscriptionsPageResponse)
            .isEqualTo(userListSubscriptionsPageResponse)
    }
}
