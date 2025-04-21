// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.core.jsonMapper
import app.knock.api.models.shared.PageInfo
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ObjectListPageResponseTest {

    @Test
    fun create() {
        val objectListPageResponse =
            ObjectListPageResponse.builder()
                .addEntry(
                    Object.builder()
                        .id("project_1")
                        ._typename("Object")
                        .collection("projects")
                        .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                        .createdAt(null)
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

        assertThat(objectListPageResponse.entries())
            .containsExactly(
                Object.builder()
                    .id("project_1")
                    ._typename("Object")
                    .collection("projects")
                    .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                    .createdAt(null)
                    .build()
            )
        assertThat(objectListPageResponse.pageInfo())
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
        val objectListPageResponse =
            ObjectListPageResponse.builder()
                .addEntry(
                    Object.builder()
                        .id("project_1")
                        ._typename("Object")
                        .collection("projects")
                        .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                        .createdAt(null)
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

        val roundtrippedObjectListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(objectListPageResponse),
                jacksonTypeRef<ObjectListPageResponse>(),
            )

        assertThat(roundtrippedObjectListPageResponse).isEqualTo(objectListPageResponse)
    }
}
