// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking.objects

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.bulkoperations.BulkOperation
import app.knock.api.models.objects.bulk.BulkAddSubscriptionsParams
import app.knock.api.models.objects.bulk.BulkDeleteParams
import app.knock.api.models.objects.bulk.BulkSetParams
import com.google.errorprone.annotations.MustBeClosed

interface BulkService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for
     * each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Bulk delete objects */
    fun delete(params: BulkDeleteParams): BulkOperation =
        delete(
          params, RequestOptions.none()
        )

    /** @see [delete] */
    fun delete(params: BulkDeleteParams, requestOptions: RequestOptions = RequestOptions.none()): BulkOperation

    /**
     * Add subscriptions for a set of objects in a single collection. If a subscription
     * already exists, it will be updated.
     */
    fun addSubscriptions(params: BulkAddSubscriptionsParams): BulkOperation =
        addSubscriptions(
          params, RequestOptions.none()
        )

    /** @see [addSubscriptions] */
    fun addSubscriptions(params: BulkAddSubscriptionsParams, requestOptions: RequestOptions = RequestOptions.none()): BulkOperation

    /** Bulk set objects */
    fun set(params: BulkSetParams): BulkOperation =
        set(
          params, RequestOptions.none()
        )

    /** @see [set] */
    fun set(params: BulkSetParams, requestOptions: RequestOptions = RequestOptions.none()): BulkOperation

    /**
     * A view of [BulkService] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/objects/{collection}/bulk/delete`, but
         * is otherwise the same as [BulkService.delete].
         */
        @MustBeClosed
        fun delete(params: BulkDeleteParams): HttpResponseFor<BulkOperation> =
            delete(
              params, RequestOptions.none()
            )

        /** @see [delete] */
        @MustBeClosed
        fun delete(params: BulkDeleteParams, requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<BulkOperation>

        /**
         * Returns a raw HTTP response for
         * `post /v1/objects/{collection}/bulk/subscriptions/add`, but is otherwise the
         * same as [BulkService.addSubscriptions].
         */
        @MustBeClosed
        fun addSubscriptions(params: BulkAddSubscriptionsParams): HttpResponseFor<BulkOperation> =
            addSubscriptions(
              params, RequestOptions.none()
            )

        /** @see [addSubscriptions] */
        @MustBeClosed
        fun addSubscriptions(params: BulkAddSubscriptionsParams, requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<BulkOperation>

        /**
         * Returns a raw HTTP response for `post /v1/objects/{collection}/bulk/set`, but is
         * otherwise the same as [BulkService.set].
         */
        @MustBeClosed
        fun set(params: BulkSetParams): HttpResponseFor<BulkOperation> =
            set(
              params, RequestOptions.none()
            )

        /** @see [set] */
        @MustBeClosed
        fun set(params: BulkSetParams, requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<BulkOperation>
    }
}
