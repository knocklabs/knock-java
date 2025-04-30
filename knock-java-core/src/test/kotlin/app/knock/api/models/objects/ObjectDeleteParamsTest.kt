// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ObjectDeleteParamsTest {

    @Test
    fun create() {
        ObjectDeleteParams.builder().collection("collection").id("id").build()
    }

    @Test
    fun pathParams() {
        val params = ObjectDeleteParams.builder().collection("collection").id("id").build()

        assertThat(params._pathParam(0)).isEqualTo("collection")
        assertThat(params._pathParam(1)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }
}
