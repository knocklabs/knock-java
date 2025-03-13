// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ObjectDeleteParamsTest {

    @Test
    fun create() {
        ObjectDeleteParams.builder().collection("collection").objectId("object_id").build()
    }

    @Test
    fun getPathParam() {
        val params =
            ObjectDeleteParams.builder().collection("collection").objectId("object_id").build()
        assertThat(params).isNotNull
        // path param "collection"
        assertThat(params.getPathParam(0)).isEqualTo("collection")
        // path param "objectId"
        assertThat(params.getPathParam(1)).isEqualTo("object_id")
        // out-of-bound path param
        assertThat(params.getPathParam(2)).isEqualTo("")
    }
}
