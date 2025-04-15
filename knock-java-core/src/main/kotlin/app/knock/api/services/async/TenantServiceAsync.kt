// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.tenants.TenantListPageAsync
import app.knock.api.models.tenants.TenantListParams
import app.knock.api.services.async.tenants.BulkServiceAsync
import com.google.errorprone.annotations.MustBeClosed
import java.util.concurrent.CompletableFuture

interface TenantServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun bulk(): BulkServiceAsync

    /** List tenants */
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

    /**
     * A view of [TenantServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        fun bulk(): BulkServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/tenants`, but is otherwise the same as
         * [TenantServiceAsync.list].
         */
        @MustBeClosed
        fun list(): CompletableFuture<HttpResponseFor<TenantListPageAsync>> =
            list(TenantListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: TenantListParams = TenantListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TenantListPageAsync>>

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: TenantListParams = TenantListParams.none()
        ): CompletableFuture<HttpResponseFor<TenantListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<TenantListPageAsync>> =
            list(TenantListParams.none(), requestOptions)
    }
}
