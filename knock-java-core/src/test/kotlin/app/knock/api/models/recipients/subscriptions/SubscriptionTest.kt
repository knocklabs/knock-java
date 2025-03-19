// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.recipients.subscriptions

import app.knock.api.core.JsonValue
import app.knock.api.models.objects.Object
import app.knock.api.models.recipients.Recipient
import app.knock.api.models.users.User
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SubscriptionTest {

    @Test
    fun create() {
        val subscription =
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

        assertThat(subscription._typename()).isEqualTo("Subscription")
        assertThat(subscription.insertedAt())
            .isEqualTo(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
        assertThat(subscription.object_())
            .isEqualTo(
                Object.builder()
                    .id("project_1")
                    ._typename("Object")
                    .collection("projects")
                    .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                    .createdAt(null)
                    .build()
            )
        assertThat(subscription.recipient())
            .isEqualTo(
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
        assertThat(subscription.updatedAt()).isEqualTo(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
        assertThat(subscription.properties())
            .contains(
                Subscription.Properties.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
    }
}
