// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.knock.api.services.async.tenants

import com.google.errorprone.annotations.MustBeClosed
import com.knock.api.core.RequestOptions
import com.knock.api.core.http.HttpResponseFor
import com.knock.api.models.TenantBulkDeleteParams
import com.knock.api.models.TenantBulkDeleteResponse
import com.knock.api.models.TenantBulkSetParams
import com.knock.api.models.TenantBulkSetResponse
import java.util.concurrent.CompletableFuture

interface BulkServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Bulk delete tenants */
    @JvmOverloads
    fun delete(
        params: TenantBulkDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TenantBulkDeleteResponse>

    /** Bulk set tenants */
    @JvmOverloads
    fun set(
        params: TenantBulkSetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TenantBulkSetResponse>

    /** A view of [BulkServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/tenants/bulk/delete`, but is otherwise the same
         * as [BulkServiceAsync.delete].
         */
        @JvmOverloads
        @MustBeClosed
        fun delete(
            params: TenantBulkDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TenantBulkDeleteResponse>>

        /**
         * Returns a raw HTTP response for `post /v1/tenants/bulk/set`, but is otherwise the same as
         * [BulkServiceAsync.set].
         */
        @JvmOverloads
        @MustBeClosed
        fun set(
            params: TenantBulkSetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TenantBulkSetResponse>>
    }
}
