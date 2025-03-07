// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import kotlin.test.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TenantBulkSetParamsTest {

    @Test
    fun create() {
        TenantBulkSetParams.builder().addTenant("string").build()
    }

    @Test
    fun body() {
        val params = TenantBulkSetParams.builder().addTenant("string").build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.tenants()).isEqualTo(listOf(InlineTenantRequest.ofString("string")))
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = TenantBulkSetParams.builder().addTenant("string").build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.tenants()).isEqualTo(listOf(InlineTenantRequest.ofString("string")))
    }
}
