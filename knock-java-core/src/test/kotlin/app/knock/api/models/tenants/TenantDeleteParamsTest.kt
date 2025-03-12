// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.tenants

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TenantDeleteParamsTest {

    @Test
    fun create() {
      TenantDeleteParams.builder()
          .tenantId("tenant_id")
          .build()
    }

    @Test
    fun getPathParam() {
      val params = TenantDeleteParams.builder()
          .tenantId("tenant_id")
          .build()
      assertThat(params).isNotNull
      // path param "tenantId"
      assertThat(params.getPathParam(0)).isEqualTo("tenant_id")
      // out-of-bound path param
      assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
