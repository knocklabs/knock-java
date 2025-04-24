// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async.tenants

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.bulkoperations.BulkOperation
import app.knock.api.models.tenants.bulk.BulkDeleteParams
import app.knock.api.models.tenants.bulk.BulkSetParams
import com.google.errorprone.annotations.MustBeClosed
import java.util.concurrent.CompletableFuture

interface BulkServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Delete multiple tenants in a single operation. This operation cannot be undone. */
    fun delete(params: BulkDeleteParams): CompletableFuture<BulkOperation> =
        delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: BulkDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BulkOperation>

    /** Set or update up to 1,000 tenants in a single operation. */
    fun set(params: BulkSetParams): CompletableFuture<BulkOperation> =
        set(params, RequestOptions.none())

    /** @see [set] */
    fun set(
        params: BulkSetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BulkOperation>

    /** A view of [BulkServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/tenants/bulk/delete`, but is otherwise the same
         * as [BulkServiceAsync.delete].
         */
        @MustBeClosed
        fun delete(params: BulkDeleteParams): CompletableFuture<HttpResponseFor<BulkOperation>> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: BulkDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BulkOperation>>

        /**
         * Returns a raw HTTP response for `post /v1/tenants/bulk/set`, but is otherwise the same as
         * [BulkServiceAsync.set].
         */
        @MustBeClosed
        fun set(params: BulkSetParams): CompletableFuture<HttpResponseFor<BulkOperation>> =
            set(params, RequestOptions.none())

        /** @see [set] */
        @MustBeClosed
        fun set(
            params: BulkSetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BulkOperation>>
    }
}
