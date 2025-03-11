// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models.objects

import com.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ObjectGetPreferencesParamsTest {

    @Test
    fun create() {
        ObjectGetPreferencesParams.builder()
            .collection("collection")
            .objectId("object_id")
            .preferenceSetId("default")
            .tenant("tenant")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            ObjectGetPreferencesParams.builder()
                .collection("collection")
                .objectId("object_id")
                .preferenceSetId("default")
                .tenant("tenant")
                .build()
        val expected = QueryParams.builder()
        expected.put("tenant", "tenant")
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            ObjectGetPreferencesParams.builder()
                .collection("collection")
                .objectId("object_id")
                .preferenceSetId("default")
                .build()
        val expected = QueryParams.builder()
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun getPathParam() {
        val params =
            ObjectGetPreferencesParams.builder()
                .collection("collection")
                .objectId("object_id")
                .preferenceSetId("default")
                .build()
        assertThat(params).isNotNull
        // path param "collection"
        assertThat(params.getPathParam(0)).isEqualTo("collection")
        // path param "objectId"
        assertThat(params.getPathParam(1)).isEqualTo("object_id")
        // path param "preferenceSetId"
        assertThat(params.getPathParam(2)).isEqualTo("default")
        // out-of-bound path param
        assertThat(params.getPathParam(3)).isEqualTo("")
    }
}
