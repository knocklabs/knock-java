// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.tenants

import app.knock.api.core.http.QueryParams
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

    @Test
    fun queryParams() {
        val params = TenantGetParams.builder().id("id").resolveFullPreferenceSettings(true).build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder().put("resolve_full_preference_settings", "true").build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = TenantGetParams.builder().id("id").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
