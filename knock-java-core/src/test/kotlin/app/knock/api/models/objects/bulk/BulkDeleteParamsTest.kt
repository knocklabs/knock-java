// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects.bulk

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BulkDeleteParamsTest {

    @Test
    fun create() {
        BulkDeleteParams.builder()
            .collection("collection")
            .objectIds(listOf("obj_123", "obj_456", "obj_789"))
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            BulkDeleteParams.builder()
                .collection("collection")
                .objectIds(listOf("obj_123", "obj_456", "obj_789"))
                .build()

        assertThat(params._pathParam(0)).isEqualTo("collection")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            BulkDeleteParams.builder()
                .collection("collection")
                .objectIds(listOf("obj_123", "obj_456", "obj_789"))
                .build()

        val body = params._body()

        assertThat(body.objectIds()).containsExactly("obj_123", "obj_456", "obj_789")
    }
}
