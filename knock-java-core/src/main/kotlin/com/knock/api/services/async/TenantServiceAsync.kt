// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.knock.api.core.RequestOptions
import com.knock.api.core.http.HttpResponseFor
import com.knock.api.models.tenants.Tenant
import com.knock.api.models.tenants.TenantDeleteParams
import com.knock.api.models.tenants.TenantGetParams
import com.knock.api.models.tenants.TenantListPageAsync
import com.knock.api.models.tenants.TenantListParams
import com.knock.api.models.tenants.TenantSetParams
import com.knock.api.services.async.tenants.BulkServiceAsync
import java.util.concurrent.CompletableFuture

interface TenantServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for
     * each method.
     */
    fun withRawResponse(): WithRawResponse

    fun bulk(): BulkServiceAsync

    /** List tenants */
    fun list(): CompletableFuture<TenantListPageAsync> = list(TenantListParams.none())

    /** @see [list] */
    fun list(params: TenantListParams = TenantListParams.none(), requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<TenantListPageAsync>

    /** @see [list] */
    fun list(params: TenantListParams = TenantListParams.none()): CompletableFuture<TenantListPageAsync> =
        list(
          params, RequestOptions.none()
        )

    /** @see [list] */
    fun list(requestOptions: RequestOptions): CompletableFuture<TenantListPageAsync> = list(TenantListParams.none(), requestOptions)

    /** Delete a tenant */
    fun delete(params: TenantDeleteParams): CompletableFuture<String> =
        delete(
          params, RequestOptions.none()
        )

    /** @see [delete] */
    fun delete(params: TenantDeleteParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<String>

    /** Get a tenant */
    fun get(params: TenantGetParams): CompletableFuture<Tenant> =
        get(
          params, RequestOptions.none()
        )

    /** @see [get] */
    fun get(params: TenantGetParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<Tenant>

    /** Set a tenant */
    fun set(params: TenantSetParams): CompletableFuture<Tenant> =
        set(
          params, RequestOptions.none()
        )

    /** @see [set] */
    fun set(params: TenantSetParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<Tenant>

    /**
     * A view of [TenantServiceAsync] that provides access to raw HTTP responses for
     * each method.
     */
    interface WithRawResponse {

        fun bulk(): BulkServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/tenants`, but is otherwise the same as
         * [TenantServiceAsync.list].
         */
        @MustBeClosed
        fun list(): CompletableFuture<HttpResponseFor<TenantListPageAsync>> = list(TenantListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(params: TenantListParams = TenantListParams.none(), requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<HttpResponseFor<TenantListPageAsync>>

        /** @see [list] */
        @MustBeClosed
        fun list(params: TenantListParams = TenantListParams.none()): CompletableFuture<HttpResponseFor<TenantListPageAsync>> =
            list(
              params, RequestOptions.none()
            )

        /** @see [list] */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<TenantListPageAsync>> = list(TenantListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/tenants/{tenant_id}`, but is
         * otherwise the same as [TenantServiceAsync.delete].
         */
        @MustBeClosed
        fun delete(params: TenantDeleteParams): CompletableFuture<HttpResponseFor<String>> =
            delete(
              params, RequestOptions.none()
            )

        /** @see [delete] */
        @MustBeClosed
        fun delete(params: TenantDeleteParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<HttpResponseFor<String>>

        /**
         * Returns a raw HTTP response for `get /v1/tenants/{tenant_id}`, but is otherwise
         * the same as [TenantServiceAsync.get].
         */
        @MustBeClosed
        fun get(params: TenantGetParams): CompletableFuture<HttpResponseFor<Tenant>> =
            get(
              params, RequestOptions.none()
            )

        /** @see [get] */
        @MustBeClosed
        fun get(params: TenantGetParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<HttpResponseFor<Tenant>>

        /**
         * Returns a raw HTTP response for `put /v1/tenants/{tenant_id}`, but is otherwise
         * the same as [TenantServiceAsync.set].
         */
        @MustBeClosed
        fun set(params: TenantSetParams): CompletableFuture<HttpResponseFor<Tenant>> =
            set(
              params, RequestOptions.none()
            )

        /** @see [set] */
        @MustBeClosed
        fun set(params: TenantSetParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<HttpResponseFor<Tenant>>
    }
}
