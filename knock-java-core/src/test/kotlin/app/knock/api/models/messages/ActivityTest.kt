// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages

import app.knock.api.core.JsonValue
import app.knock.api.models.recipients.Recipient
import app.knock.api.models.users.User
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ActivityTest {

    @Test
    fun createActivity() {
      val activity = Activity.builder()
          .id("2FVHPWxRqNuXQ9krvNP5A6Z4qXe")
          ._typename("Activity")
          .actor(User.builder()
              .id("id")
              ._typename("User")
              .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
              .avatar("avatar")
              .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
              .email("email")
              .name("name")
              .phoneNumber("phone_number")
              .timezone("timezone")
              .build())
          .data(Activity.Data.builder()
              .putAdditionalProperty("foo", JsonValue.from("bar"))
              .build())
          .insertedAt(OffsetDateTime.parse("2024-01-01T00:00:00Z"))
          .recipient(User.builder()
              .id("jane")
              ._typename("User")
              .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
              .avatar(null)
              .createdAt(null)
              .email("jane@ingen.net")
              .name("Jane Doe")
              .phoneNumber(null)
              .timezone(null)
              .build())
          .updatedAt(OffsetDateTime.parse("2024-01-01T00:00:00Z"))
          .build()
      assertThat(activity).isNotNull
      assertThat(activity.id()).contains("2FVHPWxRqNuXQ9krvNP5A6Z4qXe")
      assertThat(activity._typename()).contains("Activity")
      assertThat(activity.actor()).contains(Recipient.ofUser(User.builder()
          .id("id")
          ._typename("User")
          .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .avatar("avatar")
          .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .email("email")
          .name("name")
          .phoneNumber("phone_number")
          .timezone("timezone")
          .build()))
      assertThat(activity.data()).contains(Activity.Data.builder()
          .putAdditionalProperty("foo", JsonValue.from("bar"))
          .build())
      assertThat(activity.insertedAt()).contains(OffsetDateTime.parse("2024-01-01T00:00:00Z"))
      assertThat(activity.recipient()).contains(Recipient.ofUser(User.builder()
          .id("jane")
          ._typename("User")
          .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
          .avatar(null)
          .createdAt(null)
          .email("jane@ingen.net")
          .name("Jane Doe")
          .phoneNumber(null)
          .timezone(null)
          .build()))
      assertThat(activity.updatedAt()).contains(OffsetDateTime.parse("2024-01-01T00:00:00Z"))
    }
}
