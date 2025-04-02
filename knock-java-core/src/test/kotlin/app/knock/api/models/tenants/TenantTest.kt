// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.tenants

import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TenantTest {

    @Test
    fun create() {
        val tenant = Tenant.builder().id("tenant_123")._typename("Tenant").build()

        assertThat(tenant.id()).isEqualTo("tenant_123")
        assertThat(tenant._typename()).isEqualTo("Tenant")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val tenant = Tenant.builder().id("tenant_123")._typename("Tenant").build()

        val roundtrippedTenant =
            jsonMapper.readValue(jsonMapper.writeValueAsString(tenant), jacksonTypeRef<Tenant>())

        assertThat(roundtrippedTenant).isEqualTo(tenant)
    }
}
