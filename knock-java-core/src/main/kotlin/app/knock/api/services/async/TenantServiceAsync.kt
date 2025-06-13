// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async

import app.knock.api.core.ClientOptions
import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.tenants.Tenant
import app.knock.api.models.tenants.TenantDeleteParams
import app.knock.api.models.tenants.TenantGetParams
import app.knock.api.models.tenants.TenantListPageAsync
import app.knock.api.models.tenants.TenantListParams
import app.knock.api.models.tenants.TenantSetParams
import app.knock.api.services.async.tenants.BulkServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface TenantServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): TenantServiceAsync

    fun bulk(): BulkServiceAsync

    /** List tenants for the current environment. */
    fun list(): CompletableFuture<TenantListPageAsync> = list(TenantListParams.none())

    /** @see [list] */
    fun list(
        params: TenantListParams = TenantListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TenantListPageAsync>

    /** @see [list] */
    fun list(
        params: TenantListParams = TenantListParams.none()
    ): CompletableFuture<TenantListPageAsync> = list(params, RequestOptions.none())

    /** @see [list] */
    fun list(requestOptions: RequestOptions): CompletableFuture<TenantListPageAsync> =
        list(TenantListParams.none(), requestOptions)

    /** Delete a tenant and all associated data. This operation cannot be undone. */
    fun delete(id: String): CompletableFuture<String> = delete(id, TenantDeleteParams.none())

    /** @see [delete] */
    fun delete(
        id: String,
        params: TenantDeleteParams = TenantDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<String> = delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see [delete] */
    fun delete(
        id: String,
        params: TenantDeleteParams = TenantDeleteParams.none(),
    ): CompletableFuture<String> = delete(id, params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: TenantDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<String>

    /** @see [delete] */
    fun delete(params: TenantDeleteParams): CompletableFuture<String> =
        delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(id: String, requestOptions: RequestOptions): CompletableFuture<String> =
        delete(id, TenantDeleteParams.none(), requestOptions)

    /** Get a tenant by ID. */
    fun get(id: String): CompletableFuture<Tenant> = get(id, TenantGetParams.none())

    /** @see [get] */
    fun get(
        id: String,
        params: TenantGetParams = TenantGetParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Tenant> = get(params.toBuilder().id(id).build(), requestOptions)

    /** @see [get] */
    fun get(
        id: String,
        params: TenantGetParams = TenantGetParams.none(),
    ): CompletableFuture<Tenant> = get(id, params, RequestOptions.none())

    /** @see [get] */
    fun get(
        params: TenantGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Tenant>

    /** @see [get] */
    fun get(params: TenantGetParams): CompletableFuture<Tenant> = get(params, RequestOptions.none())

    /** @see [get] */
    fun get(id: String, requestOptions: RequestOptions): CompletableFuture<Tenant> =
        get(id, TenantGetParams.none(), requestOptions)

    /**
     * Sets a tenant within an environment, performing an upsert operation. Any existing properties
     * will be merged with the incoming properties.
     */
    fun set(id: String): CompletableFuture<Tenant> = set(id, TenantSetParams.none())

    /** @see [set] */
    fun set(
        id: String,
        params: TenantSetParams = TenantSetParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Tenant> = set(params.toBuilder().id(id).build(), requestOptions)

    /** @see [set] */
    fun set(
        id: String,
        params: TenantSetParams = TenantSetParams.none(),
    ): CompletableFuture<Tenant> = set(id, params, RequestOptions.none())

    /** @see [set] */
    fun set(
        params: TenantSetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Tenant>

    /** @see [set] */
    fun set(params: TenantSetParams): CompletableFuture<Tenant> = set(params, RequestOptions.none())

    /** @see [set] */
    fun set(id: String, requestOptions: RequestOptions): CompletableFuture<Tenant> =
        set(id, TenantSetParams.none(), requestOptions)

    /**
     * A view of [TenantServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): TenantServiceAsync.WithRawResponse

        fun bulk(): BulkServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/tenants`, but is otherwise the same as
         * [TenantServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<TenantListPageAsync>> =
            list(TenantListParams.none())

        /** @see [list] */
        fun list(
            params: TenantListParams = TenantListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TenantListPageAsync>>

        /** @see [list] */
        fun list(
            params: TenantListParams = TenantListParams.none()
        ): CompletableFuture<HttpResponseFor<TenantListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<TenantListPageAsync>> =
            list(TenantListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/tenants/{id}`, but is otherwise the same as
         * [TenantServiceAsync.delete].
         */
        fun delete(id: String): CompletableFuture<HttpResponseFor<String>> =
            delete(id, TenantDeleteParams.none())

        /** @see [delete] */
        fun delete(
            id: String,
            params: TenantDeleteParams = TenantDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<String>> =
            delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see [delete] */
        fun delete(
            id: String,
            params: TenantDeleteParams = TenantDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<String>> = delete(id, params, RequestOptions.none())

        /** @see [delete] */
        fun delete(
            params: TenantDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<String>>

        /** @see [delete] */
        fun delete(params: TenantDeleteParams): CompletableFuture<HttpResponseFor<String>> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        fun delete(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<String>> =
            delete(id, TenantDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/tenants/{id}`, but is otherwise the same as
         * [TenantServiceAsync.get].
         */
        fun get(id: String): CompletableFuture<HttpResponseFor<Tenant>> =
            get(id, TenantGetParams.none())

        /** @see [get] */
        fun get(
            id: String,
            params: TenantGetParams = TenantGetParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Tenant>> =
            get(params.toBuilder().id(id).build(), requestOptions)

        /** @see [get] */
        fun get(
            id: String,
            params: TenantGetParams = TenantGetParams.none(),
        ): CompletableFuture<HttpResponseFor<Tenant>> = get(id, params, RequestOptions.none())

        /** @see [get] */
        fun get(
            params: TenantGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Tenant>>

        /** @see [get] */
        fun get(params: TenantGetParams): CompletableFuture<HttpResponseFor<Tenant>> =
            get(params, RequestOptions.none())

        /** @see [get] */
        fun get(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Tenant>> =
            get(id, TenantGetParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put /v1/tenants/{id}`, but is otherwise the same as
         * [TenantServiceAsync.set].
         */
        fun set(id: String): CompletableFuture<HttpResponseFor<Tenant>> =
            set(id, TenantSetParams.none())

        /** @see [set] */
        fun set(
            id: String,
            params: TenantSetParams = TenantSetParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Tenant>> =
            set(params.toBuilder().id(id).build(), requestOptions)

        /** @see [set] */
        fun set(
            id: String,
            params: TenantSetParams = TenantSetParams.none(),
        ): CompletableFuture<HttpResponseFor<Tenant>> = set(id, params, RequestOptions.none())

        /** @see [set] */
        fun set(
            params: TenantSetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Tenant>>

        /** @see [set] */
        fun set(params: TenantSetParams): CompletableFuture<HttpResponseFor<Tenant>> =
            set(params, RequestOptions.none())

        /** @see [set] */
        fun set(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Tenant>> =
            set(id, TenantSetParams.none(), requestOptions)
    }
}
