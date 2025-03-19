// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.tenants

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InlineTenantRequestTest {

    @Test
    fun ofString() {
        val string = "string"

        val inlineTenantRequest = InlineTenantRequest.ofString(string)

        assertThat(inlineTenantRequest.string()).contains(string)
        assertThat(inlineTenantRequest.tenantRequest()).isEmpty
    }

    @Test
    fun ofTenantRequest() {
        val tenantRequest = TenantRequest.builder().id("tenant_123").build()

        val inlineTenantRequest = InlineTenantRequest.ofTenantRequest(tenantRequest)

        assertThat(inlineTenantRequest.string()).isEmpty
        assertThat(inlineTenantRequest.tenantRequest()).contains(tenantRequest)
    }
}
