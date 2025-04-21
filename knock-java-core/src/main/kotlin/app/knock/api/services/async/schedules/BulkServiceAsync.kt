// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async.schedules

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.bulkoperations.BulkOperation
import app.knock.api.models.schedules.bulk.BulkCreateParams
import com.google.errorprone.annotations.MustBeClosed
import java.util.concurrent.CompletableFuture

interface BulkServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Creates up to 1,000 schedules in a single asynchronous bulk operation. The list of schedules
     * can include inline-identifications for each recipient, tenant, and actor specified on a
     * schedule.
     */
    fun create(): CompletableFuture<BulkOperation> = create(BulkCreateParams.none())

    /** @see [create] */
    fun create(
        params: BulkCreateParams = BulkCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BulkOperation>

    /** @see [create] */
    fun create(
        params: BulkCreateParams = BulkCreateParams.none()
    ): CompletableFuture<BulkOperation> = create(params, RequestOptions.none())

    /** @see [create] */
    fun create(requestOptions: RequestOptions): CompletableFuture<BulkOperation> =
        create(BulkCreateParams.none(), requestOptions)

    /** A view of [BulkServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/schedules/bulk/create`, but is otherwise the
         * same as [BulkServiceAsync.create].
         */
        @MustBeClosed
        fun create(): CompletableFuture<HttpResponseFor<BulkOperation>> =
            create(BulkCreateParams.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: BulkCreateParams = BulkCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BulkOperation>>

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: BulkCreateParams = BulkCreateParams.none()
        ): CompletableFuture<HttpResponseFor<BulkOperation>> = create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<BulkOperation>> =
            create(BulkCreateParams.none(), requestOptions)
    }
}
