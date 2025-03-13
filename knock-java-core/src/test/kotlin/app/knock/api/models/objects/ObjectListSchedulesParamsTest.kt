// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ObjectListSchedulesParamsTest {

    @Test
    fun create() {
        ObjectListSchedulesParams.builder()
            .collection("collection")
            .objectId("object_id")
            .after("after")
            .before("before")
            .pageSize(0L)
            .tenant("tenant")
            .workflow("workflow")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            ObjectListSchedulesParams.builder()
                .collection("collection")
                .objectId("object_id")
                .after("after")
                .before("before")
                .pageSize(0L)
                .tenant("tenant")
                .workflow("workflow")
                .build()
        val expected = QueryParams.builder()
        expected.put("after", "after")
        expected.put("before", "before")
        expected.put("page_size", "0")
        expected.put("tenant", "tenant")
        expected.put("workflow", "workflow")
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            ObjectListSchedulesParams.builder()
                .collection("collection")
                .objectId("object_id")
                .build()
        val expected = QueryParams.builder()
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun getPathParam() {
        val params =
            ObjectListSchedulesParams.builder()
                .collection("collection")
                .objectId("object_id")
                .build()
        assertThat(params).isNotNull
        // path param "collection"
        assertThat(params.getPathParam(0)).isEqualTo("collection")
        // path param "objectId"
        assertThat(params.getPathParam(1)).isEqualTo("object_id")
        // out-of-bound path param
        assertThat(params.getPathParam(2)).isEqualTo("")
    }
}
