// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ObjectTest {

    @Test
    fun create() {
        val object_ =
            Object.builder()
                .id("specimen_25")
                ._typename("Object")
                .collection("assets")
                .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                .createdAt(null)
                .build()

        assertThat(object_.id()).isEqualTo("specimen_25")
        assertThat(object_._typename()).isEqualTo("Object")
        assertThat(object_.collection()).isEqualTo("assets")
        assertThat(object_.updatedAt()).isEqualTo(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
        assertThat(object_.createdAt()).isEmpty
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val object_ =
            Object.builder()
                .id("specimen_25")
                ._typename("Object")
                .collection("assets")
                .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                .createdAt(null)
                .build()

        val roundtrippedObject =
            jsonMapper.readValue(jsonMapper.writeValueAsString(object_), jacksonTypeRef<Object>())

        assertThat(roundtrippedObject).isEqualTo(object_)
    }
}
