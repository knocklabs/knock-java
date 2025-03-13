// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.tenants.bulk

import app.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BulkDeleteParamsTest {

    @Test
    fun create() {
        BulkDeleteParams.builder().addTenantId("string").build()
    }

    @Test
    fun queryParams() {
        val params = BulkDeleteParams.builder().addTenantId("string").build()
        val expected = QueryParams.builder()
        expected.put("tenant_ids[]", "string")
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = BulkDeleteParams.builder().addTenantId("string").build()
        val expected = QueryParams.builder()
        expected.put("tenant_ids[]", "string")
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }
}
