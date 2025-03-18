// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ObjectListParamsTest {

    @Test
    fun create() {
        ObjectListParams.builder()
            .collection("collection")
            .after("after")
            .before("before")
            .pageSize(0L)
            .build()
    }

    @Test
    fun pathParams() {
        val params = ObjectListParams.builder().collection("collection").build()

        assertThat(params._pathParam(0)).isEqualTo("collection")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            ObjectListParams.builder()
                .collection("collection")
                .after("after")
                .before("before")
                .pageSize(0L)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "after")
                    .put("before", "before")
                    .put("page_size", "0")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = ObjectListParams.builder().collection("collection").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
