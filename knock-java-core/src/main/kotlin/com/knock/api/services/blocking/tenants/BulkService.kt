// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.blocking.tenants

import com.google.errorprone.annotations.MustBeClosed
import com.knock.api.core.RequestOptions
import com.knock.api.core.http.HttpResponseFor
import com.knock.api.models.BulkOperation
import com.knock.api.models.TenantBulkDeleteParams
import com.knock.api.models.TenantBulkSetParams

interface BulkService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Bulk delete tenants */
    fun delete(params: TenantBulkDeleteParams): BulkOperation =
        delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: TenantBulkDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BulkOperation

    /** Bulk set tenants */
    fun set(params: TenantBulkSetParams): BulkOperation = set(params, RequestOptions.none())

    /** @see [set] */
    fun set(
        params: TenantBulkSetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BulkOperation

    /** A view of [BulkService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/tenants/bulk/delete`, but is otherwise the same
         * as [BulkService.delete].
         */
        @MustBeClosed
        fun delete(params: TenantBulkDeleteParams): HttpResponseFor<BulkOperation> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: TenantBulkDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BulkOperation>

        /**
         * Returns a raw HTTP response for `post /v1/tenants/bulk/set`, but is otherwise the same as
         * [BulkService.set].
         */
        @MustBeClosed
        fun set(params: TenantBulkSetParams): HttpResponseFor<BulkOperation> =
            set(params, RequestOptions.none())

        /** @see [set] */
        @MustBeClosed
        fun set(
            params: TenantBulkSetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BulkOperation>
    }
}
