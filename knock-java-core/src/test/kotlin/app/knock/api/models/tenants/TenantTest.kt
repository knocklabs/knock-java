// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.tenants

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TenantTest {

    @Test
    fun createTenant() {
        val tenant = Tenant.builder().id("tenant_123")._typename("Tenant").build()
        assertThat(tenant).isNotNull
        assertThat(tenant.id()).isEqualTo("tenant_123")
        assertThat(tenant._typename()).isEqualTo("Tenant")
    }
}
