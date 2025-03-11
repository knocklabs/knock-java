// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.knock.api.core.RequestOptions
import com.knock.api.core.http.HttpResponseFor
import com.knock.api.models.bulkoperations.BulkOperation
import com.knock.api.models.bulkoperations.BulkOperationGetParams
import java.util.concurrent.CompletableFuture

interface BulkOperationServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Retrieves a bulk operation (if it exists) and displays the current state of it. */
    fun get(params: BulkOperationGetParams): CompletableFuture<BulkOperation> =
        get(params, RequestOptions.none())

    /** @see [get] */
    fun get(
        params: BulkOperationGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BulkOperation>

    /**
     * A view of [BulkOperationServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /v1/bulk_operations/{id}`, but is otherwise the same
         * as [BulkOperationServiceAsync.get].
         */
        @MustBeClosed
        fun get(params: BulkOperationGetParams): CompletableFuture<HttpResponseFor<BulkOperation>> =
            get(params, RequestOptions.none())

        /** @see [get] */
        @MustBeClosed
        fun get(
            params: BulkOperationGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BulkOperation>>
    }
}
