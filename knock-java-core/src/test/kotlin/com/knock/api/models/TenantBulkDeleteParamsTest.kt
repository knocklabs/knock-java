// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import com.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TenantBulkDeleteParamsTest {

    @Test
    fun create() {
        TenantBulkDeleteParams.builder().addTenantId("string").build()
    }

    @Test
    fun queryParams() {
        val params = TenantBulkDeleteParams.builder().addTenantId("string").build()
        val expected = QueryParams.builder()
        expected.put("tenant_ids[]", "string")
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = TenantBulkDeleteParams.builder().addTenantId("string").build()
        val expected = QueryParams.builder()
        expected.put("tenant_ids[]", "string")
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }
}
