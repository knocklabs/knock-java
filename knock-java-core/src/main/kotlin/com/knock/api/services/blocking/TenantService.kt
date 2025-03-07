// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.knock.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.knock.api.core.RequestOptions
import com.knock.api.core.http.HttpResponseFor
import com.knock.api.models.Tenant
import com.knock.api.models.TenantDeleteParams
import com.knock.api.models.TenantGetParams
import com.knock.api.models.TenantListPage
import com.knock.api.models.TenantListParams
import com.knock.api.models.TenantSetParams
import com.knock.api.services.blocking.tenants.BulkService

interface TenantService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun bulk(): BulkService

    /** List tenants */
    @JvmOverloads
    fun list(
        params: TenantListParams = TenantListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TenantListPage

    /** List tenants */
    fun list(requestOptions: RequestOptions): TenantListPage =
        list(TenantListParams.none(), requestOptions)

    /** Delete a tenant */
    @JvmOverloads
    fun delete(
        params: TenantDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): String

    /** Get a tenant */
    @JvmOverloads
    fun get(params: TenantGetParams, requestOptions: RequestOptions = RequestOptions.none()): Tenant

    /** Set a tenant */
    @JvmOverloads
    fun set(params: TenantSetParams, requestOptions: RequestOptions = RequestOptions.none()): Tenant

    /** A view of [TenantService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun bulk(): BulkService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/tenants`, but is otherwise the same as
         * [TenantService.list].
         */
        @JvmOverloads
        @MustBeClosed
        fun list(
            params: TenantListParams = TenantListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TenantListPage>

        /**
         * Returns a raw HTTP response for `get /v1/tenants`, but is otherwise the same as
         * [TenantService.list].
         */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<TenantListPage> =
            list(TenantListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/tenants/{id}`, but is otherwise the same as
         * [TenantService.delete].
         */
        @JvmOverloads
        @MustBeClosed
        fun delete(
            params: TenantDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<String>

        /**
         * Returns a raw HTTP response for `get /v1/tenants/{id}`, but is otherwise the same as
         * [TenantService.get].
         */
        @JvmOverloads
        @MustBeClosed
        fun get(
            params: TenantGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Tenant>

        /**
         * Returns a raw HTTP response for `put /v1/tenants/{id}`, but is otherwise the same as
         * [TenantService.set].
         */
        @JvmOverloads
        @MustBeClosed
        fun set(
            params: TenantSetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Tenant>
    }
}
