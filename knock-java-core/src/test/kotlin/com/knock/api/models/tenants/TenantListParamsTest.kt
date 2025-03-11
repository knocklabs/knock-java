// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models.tenants

import com.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TenantListParamsTest {

    @Test
    fun create() {
        TenantListParams.builder().after("after").before("before").pageSize(0L).build()
    }

    @Test
    fun queryParams() {
        val params = TenantListParams.builder().after("after").before("before").pageSize(0L).build()
        val expected = QueryParams.builder()
        expected.put("after", "after")
        expected.put("before", "before")
        expected.put("page_size", "0")
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = TenantListParams.builder().build()
        val expected = QueryParams.builder()
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }
}
