// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.tenants

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TenantGetParamsTest {

    @Test
    fun create() {
        TenantGetParams.builder().id("id").build()
    }

    @Test
    fun pathParams() {
        val params = TenantGetParams.builder().id("id").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
