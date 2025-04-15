// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects.bulk

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BulkSetParamsTest {

    @Test
    fun create() {
        BulkSetParams.builder().collection("collection").build()
    }

    @Test
    fun pathParams() {
        val params = BulkSetParams.builder().collection("collection").build()

        assertThat(params._pathParam(0)).isEqualTo("collection")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
