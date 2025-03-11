// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.knock.api.core.RequestOptions
import com.knock.api.core.http.HttpResponseFor
import com.knock.api.models.tenants.Tenant
import com.knock.api.models.tenants.TenantDeleteParams
import com.knock.api.models.tenants.TenantGetParams
import com.knock.api.models.tenants.TenantListPage
import com.knock.api.models.tenants.TenantListParams
import com.knock.api.models.tenants.TenantSetParams
import com.knock.api.services.blocking.tenants.BulkService

interface TenantService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun bulk(): BulkService

    /** List tenants */
    fun list(): TenantListPage = list(TenantListParams.none())

    /** @see [list] */
    fun list(
        params: TenantListParams = TenantListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TenantListPage

    /** @see [list] */
    fun list(params: TenantListParams = TenantListParams.none()): TenantListPage =
        list(params, RequestOptions.none())

    /** @see [list] */
    fun list(requestOptions: RequestOptions): TenantListPage =
        list(TenantListParams.none(), requestOptions)

    /** Delete a tenant */
    fun delete(params: TenantDeleteParams): String = delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: TenantDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): String

    /** Get a tenant */
    fun get(params: TenantGetParams): Tenant = get(params, RequestOptions.none())

    /** @see [get] */
    fun get(params: TenantGetParams, requestOptions: RequestOptions = RequestOptions.none()): Tenant

    /** Set a tenant */
    fun set(params: TenantSetParams): Tenant = set(params, RequestOptions.none())

    /** @see [set] */
    fun set(params: TenantSetParams, requestOptions: RequestOptions = RequestOptions.none()): Tenant

    /** A view of [TenantService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun bulk(): BulkService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/tenants`, but is otherwise the same as
         * [TenantService.list].
         */
        @MustBeClosed fun list(): HttpResponseFor<TenantListPage> = list(TenantListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: TenantListParams = TenantListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TenantListPage>

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: TenantListParams = TenantListParams.none()
        ): HttpResponseFor<TenantListPage> = list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<TenantListPage> =
            list(TenantListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/tenants/{tenant_id}`, but is otherwise the
         * same as [TenantService.delete].
         */
        @MustBeClosed
        fun delete(params: TenantDeleteParams): HttpResponseFor<String> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: TenantDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<String>

        /**
         * Returns a raw HTTP response for `get /v1/tenants/{tenant_id}`, but is otherwise the same
         * as [TenantService.get].
         */
        @MustBeClosed
        fun get(params: TenantGetParams): HttpResponseFor<Tenant> =
            get(params, RequestOptions.none())

        /** @see [get] */
        @MustBeClosed
        fun get(
            params: TenantGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Tenant>

        /**
         * Returns a raw HTTP response for `put /v1/tenants/{tenant_id}`, but is otherwise the same
         * as [TenantService.set].
         */
        @MustBeClosed
        fun set(params: TenantSetParams): HttpResponseFor<Tenant> =
            set(params, RequestOptions.none())

        /** @see [set] */
        @MustBeClosed
        fun set(
            params: TenantSetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Tenant>
    }
}
