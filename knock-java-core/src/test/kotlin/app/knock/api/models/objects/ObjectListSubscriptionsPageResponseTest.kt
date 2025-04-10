// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.core.JsonValue
import app.knock.api.core.jsonMapper
import app.knock.api.models.recipients.subscriptions.Subscription
import app.knock.api.models.users.User
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ObjectListSubscriptionsPageResponseTest {

    @Test
    fun create() {
        val objectListSubscriptionsPageResponse =
            ObjectListSubscriptionsPageResponse.builder()
                .addEntry(
                    Subscription.builder()
                        ._typename("Subscription")
                        .insertedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                        .object_(
                            Object.builder()
                                .id("project_1")
                                ._typename("Object")
                                .collection("projects")
                                .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                                .createdAt(null)
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
                    ObjectListSubscriptionsPageResponse.PageInfo.builder()
                        ._typename("PageInfo")
                        .pageSize(25L)
                        .after(null)
                        .before(null)
                        .build()
                )
                .build()

        assertThat(objectListSubscriptionsPageResponse.entries())
            .containsExactly(
                Subscription.builder()
                    ._typename("Subscription")
                    .insertedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                    .object_(
                        Object.builder()
                            .id("project_1")
                            ._typename("Object")
                            .collection("projects")
                            .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                            .createdAt(null)
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
        assertThat(objectListSubscriptionsPageResponse.pageInfo())
            .isEqualTo(
                ObjectListSubscriptionsPageResponse.PageInfo.builder()
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
        val objectListSubscriptionsPageResponse =
            ObjectListSubscriptionsPageResponse.builder()
                .addEntry(
                    Subscription.builder()
                        ._typename("Subscription")
                        .insertedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                        .object_(
                            Object.builder()
                                .id("project_1")
                                ._typename("Object")
                                .collection("projects")
                                .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                                .createdAt(null)
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
                    ObjectListSubscriptionsPageResponse.PageInfo.builder()
                        ._typename("PageInfo")
                        .pageSize(25L)
                        .after(null)
                        .before(null)
                        .build()
                )
                .build()

        val roundtrippedObjectListSubscriptionsPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(objectListSubscriptionsPageResponse),
                jacksonTypeRef<ObjectListSubscriptionsPageResponse>(),
            )

        assertThat(roundtrippedObjectListSubscriptionsPageResponse)
            .isEqualTo(objectListSubscriptionsPageResponse)
    }
}
