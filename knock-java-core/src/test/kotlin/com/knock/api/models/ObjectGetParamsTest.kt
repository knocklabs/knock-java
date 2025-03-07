// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ObjectGetParamsTest {

    @Test
    fun create() {
        ObjectGetParams.builder().collection("collection").id("id").build()
    }

    @Test
    fun getPathParam() {
        val params = ObjectGetParams.builder().collection("collection").id("id").build()
        assertThat(params).isNotNull
        // path param "collection"
        assertThat(params.getPathParam(0)).isEqualTo("collection")
        // path param "id"
        assertThat(params.getPathParam(1)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params.getPathParam(2)).isEqualTo("")
    }
}
