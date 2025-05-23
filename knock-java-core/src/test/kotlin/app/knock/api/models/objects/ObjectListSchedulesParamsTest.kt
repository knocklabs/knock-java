// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ObjectListSchedulesParamsTest {

    @Test
    fun create() {
        ObjectListSchedulesParams.builder()
            .collection("collection")
            .id("id")
            .after("after")
            .before("before")
            .pageSize(0L)
            .tenant("tenant")
            .workflow("workflow")
            .build()
    }

    @Test
    fun pathParams() {
        val params = ObjectListSchedulesParams.builder().collection("collection").id("id").build()

        assertThat(params._pathParam(0)).isEqualTo("collection")
        assertThat(params._pathParam(1)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            ObjectListSchedulesParams.builder()
                .collection("collection")
                .id("id")
                .after("after")
                .before("before")
                .pageSize(0L)
                .tenant("tenant")
                .workflow("workflow")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "after")
                    .put("before", "before")
                    .put("page_size", "0")
                    .put("tenant", "tenant")
                    .put("workflow", "workflow")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = ObjectListSchedulesParams.builder().collection("collection").id("id").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
