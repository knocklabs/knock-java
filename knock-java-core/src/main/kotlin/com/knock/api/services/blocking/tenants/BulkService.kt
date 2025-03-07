// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.knock.api.services.blocking.tenants

import com.google.errorprone.annotations.MustBeClosed
import com.knock.api.core.RequestOptions
import com.knock.api.core.http.HttpResponseFor
import com.knock.api.models.TenantBulkDeleteParams
import com.knock.api.models.TenantBulkDeleteResponse
import com.knock.api.models.TenantBulkSetParams
import com.knock.api.models.TenantBulkSetResponse

interface BulkService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Bulk delete tenants */
    @JvmOverloads
    fun delete(
        params: TenantBulkDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TenantBulkDeleteResponse

    /** Bulk set tenants */
    @JvmOverloads
    fun set(
        params: TenantBulkSetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TenantBulkSetResponse

    /** A view of [BulkService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/tenants/bulk/delete`, but is otherwise the same
         * as [BulkService.delete].
         */
        @JvmOverloads
        @MustBeClosed
        fun delete(
            params: TenantBulkDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TenantBulkDeleteResponse>

        /**
         * Returns a raw HTTP response for `post /v1/tenants/bulk/set`, but is otherwise the same as
         * [BulkService.set].
         */
        @JvmOverloads
        @MustBeClosed
        fun set(
            params: TenantBulkSetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TenantBulkSetResponse>
    }
}
