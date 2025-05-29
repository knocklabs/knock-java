// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.bulkoperations.BulkOperation
import app.knock.api.models.bulkoperations.BulkOperationGetParams
import java.util.concurrent.CompletableFuture

interface BulkOperationServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Retrieves a bulk operation (if it exists) and displays the current state of it. */
    fun get(id: String): CompletableFuture<BulkOperation> = get(id, BulkOperationGetParams.none())

    /** @see [get] */
    fun get(
        id: String,
        params: BulkOperationGetParams = BulkOperationGetParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BulkOperation> = get(params.toBuilder().id(id).build(), requestOptions)

    /** @see [get] */
    fun get(
        id: String,
        params: BulkOperationGetParams = BulkOperationGetParams.none(),
    ): CompletableFuture<BulkOperation> = get(id, params, RequestOptions.none())

    /** @see [get] */
    fun get(
        params: BulkOperationGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BulkOperation>

    /** @see [get] */
    fun get(params: BulkOperationGetParams): CompletableFuture<BulkOperation> =
        get(params, RequestOptions.none())

    /** @see [get] */
    fun get(id: String, requestOptions: RequestOptions): CompletableFuture<BulkOperation> =
        get(id, BulkOperationGetParams.none(), requestOptions)

    /**
     * A view of [BulkOperationServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /v1/bulk_operations/{id}`, but is otherwise the same
         * as [BulkOperationServiceAsync.get].
         */
        fun get(id: String): CompletableFuture<HttpResponseFor<BulkOperation>> =
            get(id, BulkOperationGetParams.none())

        /** @see [get] */
        fun get(
            id: String,
            params: BulkOperationGetParams = BulkOperationGetParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BulkOperation>> =
            get(params.toBuilder().id(id).build(), requestOptions)

        /** @see [get] */
        fun get(
            id: String,
            params: BulkOperationGetParams = BulkOperationGetParams.none(),
        ): CompletableFuture<HttpResponseFor<BulkOperation>> =
            get(id, params, RequestOptions.none())

        /** @see [get] */
        fun get(
            params: BulkOperationGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BulkOperation>>

        /** @see [get] */
        fun get(params: BulkOperationGetParams): CompletableFuture<HttpResponseFor<BulkOperation>> =
            get(params, RequestOptions.none())

        /** @see [get] */
        fun get(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<BulkOperation>> =
            get(id, BulkOperationGetParams.none(), requestOptions)
    }
}
