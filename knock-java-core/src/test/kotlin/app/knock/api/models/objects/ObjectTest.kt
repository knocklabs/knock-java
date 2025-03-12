// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ObjectTest {

    @Test
    fun createObject() {
      val object_ = Object.builder()
          .id("project_1")
          ._typename("Object")
          .collection("projects")
          .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
          .createdAt(null)
          .build()
      assertThat(object_).isNotNull
      assertThat(object_.id()).isEqualTo("project_1")
      assertThat(object_._typename()).isEqualTo("Object")
      assertThat(object_.collection()).isEqualTo("projects")
      assertThat(object_.updatedAt()).isEqualTo(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
      assertThat(object_.createdAt()).isEmpty
    }
}
