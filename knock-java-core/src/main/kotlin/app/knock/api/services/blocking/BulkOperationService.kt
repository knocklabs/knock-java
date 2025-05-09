// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.bulkoperations.BulkOperation
import app.knock.api.models.bulkoperations.BulkOperationGetParams
import com.google.errorprone.annotations.MustBeClosed

interface BulkOperationService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Retrieves a bulk operation (if it exists) and displays the current state of it. */
    fun get(id: String): BulkOperation = get(id, BulkOperationGetParams.none())

    /** @see [get] */
    fun get(
        id: String,
        params: BulkOperationGetParams = BulkOperationGetParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BulkOperation = get(params.toBuilder().id(id).build(), requestOptions)

    /** @see [get] */
    fun get(
        id: String,
        params: BulkOperationGetParams = BulkOperationGetParams.none(),
    ): BulkOperation = get(id, params, RequestOptions.none())

    /** @see [get] */
    fun get(
        params: BulkOperationGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BulkOperation

    /** @see [get] */
    fun get(params: BulkOperationGetParams): BulkOperation = get(params, RequestOptions.none())

    /** @see [get] */
    fun get(id: String, requestOptions: RequestOptions): BulkOperation =
        get(id, BulkOperationGetParams.none(), requestOptions)

    /**
     * A view of [BulkOperationService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /v1/bulk_operations/{id}`, but is otherwise the same
         * as [BulkOperationService.get].
         */
        @MustBeClosed
        fun get(id: String): HttpResponseFor<BulkOperation> = get(id, BulkOperationGetParams.none())

        /** @see [get] */
        @MustBeClosed
        fun get(
            id: String,
            params: BulkOperationGetParams = BulkOperationGetParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BulkOperation> = get(params.toBuilder().id(id).build(), requestOptions)

        /** @see [get] */
        @MustBeClosed
        fun get(
            id: String,
            params: BulkOperationGetParams = BulkOperationGetParams.none(),
        ): HttpResponseFor<BulkOperation> = get(id, params, RequestOptions.none())

        /** @see [get] */
        @MustBeClosed
        fun get(
            params: BulkOperationGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BulkOperation>

        /** @see [get] */
        @MustBeClosed
        fun get(params: BulkOperationGetParams): HttpResponseFor<BulkOperation> =
            get(params, RequestOptions.none())

        /** @see [get] */
        @MustBeClosed
        fun get(id: String, requestOptions: RequestOptions): HttpResponseFor<BulkOperation> =
            get(id, BulkOperationGetParams.none(), requestOptions)
    }
}
