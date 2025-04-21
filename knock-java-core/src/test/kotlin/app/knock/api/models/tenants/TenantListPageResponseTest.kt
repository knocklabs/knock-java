// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.tenants

import app.knock.api.core.jsonMapper
import app.knock.api.models.shared.PageInfo
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TenantListPageResponseTest {

    @Test
    fun create() {
        val tenantListPageResponse =
            TenantListPageResponse.builder()
                .addEntry(Tenant.builder().id("tenant_123")._typename("Tenant").build())
                .pageInfo(
                    PageInfo.builder()
                        ._typename("PageInfo")
                        .pageSize(25L)
                        .after(null)
                        .before(null)
                        .build()
                )
                .build()

        assertThat(tenantListPageResponse.entries())
            .containsExactly(Tenant.builder().id("tenant_123")._typename("Tenant").build())
        assertThat(tenantListPageResponse.pageInfo())
            .isEqualTo(
                PageInfo.builder()
                    ._typename("PageInfo")
                    .pageSize(25L)
                    .after(null)
                    .before(null)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val tenantListPageResponse =
            TenantListPageResponse.builder()
                .addEntry(Tenant.builder().id("tenant_123")._typename("Tenant").build())
                .pageInfo(
                    PageInfo.builder()
                        ._typename("PageInfo")
                        .pageSize(25L)
                        .after(null)
                        .before(null)
                        .build()
                )
                .build()

        val roundtrippedTenantListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tenantListPageResponse),
                jacksonTypeRef<TenantListPageResponse>(),
            )

        assertThat(roundtrippedTenantListPageResponse).isEqualTo(tenantListPageResponse)
    }
}
