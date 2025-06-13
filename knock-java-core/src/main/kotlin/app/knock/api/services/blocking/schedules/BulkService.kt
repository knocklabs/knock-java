// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking.schedules

import app.knock.api.core.ClientOptions
import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.bulkoperations.BulkOperation
import app.knock.api.models.schedules.bulk.BulkCreateParams
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface BulkService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): BulkService

    /**
     * Bulk creates up to 1,000 schedules at a time. This endpoint also handles
     * [inline identifications](/managing-recipients/identifying-recipients#inline-identifying-recipients)
     * for the `actor`, `recipient`, and `tenant` fields.
     */
    fun create(params: BulkCreateParams): BulkOperation = create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: BulkCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BulkOperation

    /** A view of [BulkService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): BulkService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/schedules/bulk/create`, but is otherwise the
         * same as [BulkService.create].
         */
        @MustBeClosed
        fun create(params: BulkCreateParams): HttpResponseFor<BulkOperation> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: BulkCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BulkOperation>
    }
}
