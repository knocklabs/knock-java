// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models.objects.bulk

import com.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BulkDeleteParamsTest {

    @Test
    fun create() {
        BulkDeleteParams.builder().collection("collection").addObjectId("string").build()
    }

    @Test
    fun queryParams() {
        val params =
            BulkDeleteParams.builder().collection("collection").addObjectId("string").build()
        val expected = QueryParams.builder()
        expected.put("object_ids[]", "string")
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            BulkDeleteParams.builder().collection("collection").addObjectId("string").build()
        val expected = QueryParams.builder()
        expected.put("object_ids[]", "string")
        assertThat(params._queryParams()).isEqualTo(expected.build())
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
