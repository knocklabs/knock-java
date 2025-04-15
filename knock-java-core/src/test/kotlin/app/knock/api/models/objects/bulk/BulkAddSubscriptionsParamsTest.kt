// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects.bulk

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BulkAddSubscriptionsParamsTest {

    @Test
    fun create() {
        BulkAddSubscriptionsParams.builder().collection("projects").build()
    }

    @Test
    fun pathParams() {
        val params = BulkAddSubscriptionsParams.builder().collection("projects").build()

        assertThat(params._pathParam(0)).isEqualTo("projects")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
