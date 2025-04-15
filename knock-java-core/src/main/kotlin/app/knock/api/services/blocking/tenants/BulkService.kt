// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking.tenants

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.bulkoperations.BulkOperation
import app.knock.api.models.tenants.bulk.BulkDeleteParams
import app.knock.api.models.tenants.bulk.BulkSetParams
import com.google.errorprone.annotations.MustBeClosed

interface BulkService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Deletes tenants in bulk */
    fun delete(params: BulkDeleteParams): BulkOperation = delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: BulkDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BulkOperation

    /** Sets tenants in bulk */
    fun set(): BulkOperation = set(BulkSetParams.none())

    /** @see [set] */
    fun set(
        params: BulkSetParams = BulkSetParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BulkOperation

    /** @see [set] */
    fun set(params: BulkSetParams = BulkSetParams.none()): BulkOperation =
        set(params, RequestOptions.none())

    /** @see [set] */
    fun set(requestOptions: RequestOptions): BulkOperation =
        set(BulkSetParams.none(), requestOptions)

    /** A view of [BulkService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/tenants/bulk/delete`, but is otherwise the same
         * as [BulkService.delete].
         */
        @MustBeClosed
        fun delete(params: BulkDeleteParams): HttpResponseFor<BulkOperation> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: BulkDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BulkOperation>

        /**
         * Returns a raw HTTP response for `post /v1/tenants/bulk/set`, but is otherwise the same as
         * [BulkService.set].
         */
        @MustBeClosed fun set(): HttpResponseFor<BulkOperation> = set(BulkSetParams.none())

        /** @see [set] */
        @MustBeClosed
        fun set(
            params: BulkSetParams = BulkSetParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BulkOperation>

        /** @see [set] */
        @MustBeClosed
        fun set(params: BulkSetParams = BulkSetParams.none()): HttpResponseFor<BulkOperation> =
            set(params, RequestOptions.none())

        /** @see [set] */
        @MustBeClosed
        fun set(requestOptions: RequestOptions): HttpResponseFor<BulkOperation> =
            set(BulkSetParams.none(), requestOptions)
    }
}
