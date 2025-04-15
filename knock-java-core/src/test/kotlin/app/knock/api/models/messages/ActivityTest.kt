// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages

import app.knock.api.core.JsonValue
import app.knock.api.core.jsonMapper
import app.knock.api.models.recipients.Recipient
import app.knock.api.models.users.User
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ActivityTest {

    @Test
    fun create() {
        val activity =
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
                        .email("dev@stainless.com")
                        .name("name")
                        .phoneNumber("phone_number")
                        .timezone("timezone")
                        .build()
                )
                .data(JsonValue.from(mapOf("foo" to "bar")))
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

        assertThat(activity.id()).contains("2FVHPWxRqNuXQ9krvNP5A6Z4qXe")
        assertThat(activity._typename()).contains("Activity")
        assertThat(activity.actor())
            .contains(
                Recipient.ofUser(
                    User.builder()
                        .id("id")
                        ._typename("User")
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .avatar("avatar")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .email("dev@stainless.com")
                        .name("name")
                        .phoneNumber("phone_number")
                        .timezone("timezone")
                        .build()
                )
            )
        assertThat(activity._data()).isEqualTo(JsonValue.from(mapOf("foo" to "bar")))
        assertThat(activity.insertedAt()).contains(OffsetDateTime.parse("2024-01-01T00:00:00Z"))
        assertThat(activity.recipient())
            .contains(
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
        assertThat(activity.updatedAt()).contains(OffsetDateTime.parse("2024-01-01T00:00:00Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val activity =
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
                        .email("dev@stainless.com")
                        .name("name")
                        .phoneNumber("phone_number")
                        .timezone("timezone")
                        .build()
                )
                .data(JsonValue.from(mapOf("foo" to "bar")))
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

        val roundtrippedActivity =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(activity),
                jacksonTypeRef<Activity>(),
            )

        assertThat(roundtrippedActivity).isEqualTo(activity)
    }
}
