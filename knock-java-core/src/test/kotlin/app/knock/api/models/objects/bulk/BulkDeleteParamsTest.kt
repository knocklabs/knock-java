// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects.bulk

import app.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BulkDeleteParamsTest {

    @Test
    fun create() {
        BulkDeleteParams.builder().collection("collection").addObjectId("string").build()
    }

    @Test
    fun queryParams() {
        val params =
            BulkDeleteParams.builder().collection("collection").addObjectId("string").build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(QueryParams.builder().put("object_ids[]", "string").build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            BulkDeleteParams.builder().collection("collection").addObjectId("string").build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(QueryParams.builder().put("object_ids[]", "string").build())
    }

    @Test
    fun getPathParam() {
        val params =
            BulkDeleteParams.builder().collection("collection").addObjectId("string").build()
        assertThat(params).isNotNull
        // path param "collection"
        assertThat(params.getPathParam(0)).isEqualTo("collection")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
