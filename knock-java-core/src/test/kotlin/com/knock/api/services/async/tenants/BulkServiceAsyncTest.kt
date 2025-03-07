// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.async.tenants

import com.knock.api.TestServerExtension
import com.knock.api.client.okhttp.KnockOkHttpClientAsync
import com.knock.api.models.TenantBulkDeleteParams
import com.knock.api.models.TenantBulkSetParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class BulkServiceAsyncTest {

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun delete() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val bulkServiceAsync = client.tenants().bulk()

        val bulkFuture =
            bulkServiceAsync.delete(TenantBulkDeleteParams.builder().addTenantId("string").build())

        val bulk = bulkFuture.get()
        bulk.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun set() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val bulkServiceAsync = client.tenants().bulk()

        val responseFuture =
            bulkServiceAsync.set(TenantBulkSetParams.builder().addTenant("string").build())

        val response = responseFuture.get()
        response.validate()
    }
}
