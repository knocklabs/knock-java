// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking.schedules

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.bulkoperations.BulkOperation
import app.knock.api.models.schedules.bulk.BulkCreateParams
import com.google.errorprone.annotations.MustBeClosed

interface BulkService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Creates up to 1,000 schedules in a single asynchronous bulk operation. The list of schedules
     * can include inline-identifications for each recipient, tenant, and actor specified on a
     * schedule.
     */
    fun create(): BulkOperation = create(BulkCreateParams.none())

    /** @see [create] */
    fun create(
        params: BulkCreateParams = BulkCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BulkOperation

    /** @see [create] */
    fun create(params: BulkCreateParams = BulkCreateParams.none()): BulkOperation =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(requestOptions: RequestOptions): BulkOperation =
        create(BulkCreateParams.none(), requestOptions)

    /** A view of [BulkService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/schedules/bulk/create`, but is otherwise the
         * same as [BulkService.create].
         */
        @MustBeClosed fun create(): HttpResponseFor<BulkOperation> = create(BulkCreateParams.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: BulkCreateParams = BulkCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BulkOperation>

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: BulkCreateParams = BulkCreateParams.none()
        ): HttpResponseFor<BulkOperation> = create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(requestOptions: RequestOptions): HttpResponseFor<BulkOperation> =
            create(BulkCreateParams.none(), requestOptions)
    }
}
