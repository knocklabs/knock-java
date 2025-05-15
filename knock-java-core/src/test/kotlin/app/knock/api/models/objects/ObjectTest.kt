// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.core.JsonValue
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
                .properties(
                    Object.Properties.builder()
                        .putAdditionalProperty("classification", JsonValue.from("bar"))
                        .putAdditionalProperty("config", JsonValue.from("bar"))
                        .putAdditionalProperty("name", JsonValue.from("bar"))
                        .putAdditionalProperty("status", JsonValue.from("bar"))
                        .build()
                )
                .build()

        assertThat(object_.id()).isEqualTo("specimen_25")
        assertThat(object_._typename()).isEqualTo("Object")
        assertThat(object_.collection()).isEqualTo("assets")
        assertThat(object_.updatedAt()).isEqualTo(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
        assertThat(object_.createdAt()).isEmpty
        assertThat(object_.properties())
            .contains(
                Object.Properties.builder()
                    .putAdditionalProperty("classification", JsonValue.from("bar"))
                    .putAdditionalProperty("config", JsonValue.from("bar"))
                    .putAdditionalProperty("name", JsonValue.from("bar"))
                    .putAdditionalProperty("status", JsonValue.from("bar"))
                    .build()
            )
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
                .properties(
                    Object.Properties.builder()
                        .putAdditionalProperty("classification", JsonValue.from("bar"))
                        .putAdditionalProperty("config", JsonValue.from("bar"))
                        .putAdditionalProperty("name", JsonValue.from("bar"))
                        .putAdditionalProperty("status", JsonValue.from("bar"))
                        .build()
                )
                .build()

        val roundtrippedObject =
            jsonMapper.readValue(jsonMapper.writeValueAsString(object_), jacksonTypeRef<Object>())

        assertThat(roundtrippedObject).isEqualTo(object_)
    }
}
