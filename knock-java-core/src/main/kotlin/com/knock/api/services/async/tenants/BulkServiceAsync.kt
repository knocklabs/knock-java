// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.async.tenants

import com.google.errorprone.annotations.MustBeClosed
import com.knock.api.core.RequestOptions
import com.knock.api.core.http.HttpResponseFor
import com.knock.api.models.BulkOperation
import com.knock.api.models.TenantBulkDeleteParams
import com.knock.api.models.TenantBulkSetParams
import java.util.concurrent.CompletableFuture

interface BulkServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Bulk delete tenants */
    fun delete(params: TenantBulkDeleteParams): CompletableFuture<BulkOperation> =
        delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: TenantBulkDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BulkOperation>

    /** Bulk set tenants */
    fun set(params: TenantBulkSetParams): CompletableFuture<BulkOperation> =
        set(params, RequestOptions.none())

    /** @see [set] */
    fun set(
        params: TenantBulkSetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BulkOperation>

    /** A view of [BulkServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/tenants/bulk/delete`, but is otherwise the same
         * as [BulkServiceAsync.delete].
         */
        @MustBeClosed
        fun delete(
            params: TenantBulkDeleteParams
        ): CompletableFuture<HttpResponseFor<BulkOperation>> = delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: TenantBulkDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BulkOperation>>

        /**
         * Returns a raw HTTP response for `post /v1/tenants/bulk/set`, but is otherwise the same as
         * [BulkServiceAsync.set].
         */
        @MustBeClosed
        fun set(params: TenantBulkSetParams): CompletableFuture<HttpResponseFor<BulkOperation>> =
            set(params, RequestOptions.none())

        /** @see [set] */
        @MustBeClosed
        fun set(
            params: TenantBulkSetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BulkOperation>>
    }
}
