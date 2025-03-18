// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.tenants.bulk

import app.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BulkDeleteParamsTest {

    @Test
    fun create() {
        BulkDeleteParams.builder().addTenantId("string").build()
    }

    @Test
    fun queryParams() {
        val params = BulkDeleteParams.builder().addTenantId("string").build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(QueryParams.builder().put("tenant_ids[]", "string").build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = BulkDeleteParams.builder().addTenantId("string").build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(QueryParams.builder().put("tenant_ids[]", "string").build())
    }
}
