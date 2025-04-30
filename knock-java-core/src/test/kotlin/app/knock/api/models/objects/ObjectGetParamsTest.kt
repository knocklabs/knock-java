// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ObjectGetParamsTest {

    @Test
    fun create() {
        ObjectGetParams.builder().collection("collection").id("id").build()
    }

    @Test
    fun pathParams() {
        val params = ObjectGetParams.builder().collection("collection").id("id").build()

        assertThat(params._pathParam(0)).isEqualTo("collection")
        assertThat(params._pathParam(1)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }
}
