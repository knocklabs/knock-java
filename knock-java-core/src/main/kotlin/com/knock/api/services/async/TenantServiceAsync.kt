// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.knock.api.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.knock.api.core.RequestOptions
import com.knock.api.core.http.HttpResponseFor
import com.knock.api.models.Tenant
import com.knock.api.models.TenantDeleteParams
import com.knock.api.models.TenantGetParams
import com.knock.api.models.TenantListPageAsync
import com.knock.api.models.TenantListParams
import com.knock.api.models.TenantSetParams
import com.knock.api.services.async.tenants.BulkServiceAsync
import java.util.concurrent.CompletableFuture

interface TenantServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun bulk(): BulkServiceAsync

    /** List tenants */
    @JvmOverloads
    fun list(
        params: TenantListParams = TenantListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TenantListPageAsync>

    /** List tenants */
    fun list(requestOptions: RequestOptions): CompletableFuture<TenantListPageAsync> =
        list(TenantListParams.none(), requestOptions)

    /** Delete a tenant */
    @JvmOverloads
    fun delete(
        params: TenantDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<String>

    /** Get a tenant */
    @JvmOverloads
    fun get(
        params: TenantGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Tenant>

    /** Set a tenant */
    @JvmOverloads
    fun set(
        params: TenantSetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Tenant>

    /**
     * A view of [TenantServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        fun bulk(): BulkServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/tenants`, but is otherwise the same as
         * [TenantServiceAsync.list].
         */
        @JvmOverloads
        @MustBeClosed
        fun list(
            params: TenantListParams = TenantListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TenantListPageAsync>>

        /**
         * Returns a raw HTTP response for `get /v1/tenants`, but is otherwise the same as
         * [TenantServiceAsync.list].
         */
        @MustBeClosed
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<TenantListPageAsync>> =
            list(TenantListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/tenants/{id}`, but is otherwise the same as
         * [TenantServiceAsync.delete].
         */
        @JvmOverloads
        @MustBeClosed
        fun delete(
            params: TenantDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<String>>

        /**
         * Returns a raw HTTP response for `get /v1/tenants/{id}`, but is otherwise the same as
         * [TenantServiceAsync.get].
         */
        @JvmOverloads
        @MustBeClosed
        fun get(
            params: TenantGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Tenant>>

        /**
         * Returns a raw HTTP response for `put /v1/tenants/{id}`, but is otherwise the same as
         * [TenantServiceAsync.set].
         */
        @JvmOverloads
        @MustBeClosed
        fun set(
            params: TenantSetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Tenant>>
    }
}
