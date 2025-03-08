// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.blocking.objects

import com.google.errorprone.annotations.MustBeClosed
import com.knock.api.core.RequestOptions
import com.knock.api.core.http.HttpResponseFor
import com.knock.api.models.BulkOperation
import com.knock.api.models.ObjectBulkAddSubscriptionsParams
import com.knock.api.models.ObjectBulkDeleteParams
import com.knock.api.models.ObjectBulkSetParams

interface BulkService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Bulk delete objects */
    fun delete(params: ObjectBulkDeleteParams): BulkOperation =
        delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: ObjectBulkDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BulkOperation

    /**
     * Add subscriptions for a set of objects in a single collection. If a subscription already
     * exists, it will be updated.
     */
    fun addSubscriptions(params: ObjectBulkAddSubscriptionsParams): BulkOperation =
        addSubscriptions(params, RequestOptions.none())

    /** @see [addSubscriptions] */
    fun addSubscriptions(
        params: ObjectBulkAddSubscriptionsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BulkOperation

    /** Bulk set objects */
    fun set(params: ObjectBulkSetParams): BulkOperation = set(params, RequestOptions.none())

    /** @see [set] */
    fun set(
        params: ObjectBulkSetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BulkOperation

    /** A view of [BulkService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/objects/{collection}/bulk/delete`, but is
         * otherwise the same as [BulkService.delete].
         */
        @MustBeClosed
        fun delete(params: ObjectBulkDeleteParams): HttpResponseFor<BulkOperation> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: ObjectBulkDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BulkOperation>

        /**
         * Returns a raw HTTP response for `post /v1/objects/{collection}/bulk/subscriptions/add`,
         * but is otherwise the same as [BulkService.addSubscriptions].
         */
        @MustBeClosed
        fun addSubscriptions(
            params: ObjectBulkAddSubscriptionsParams
        ): HttpResponseFor<BulkOperation> = addSubscriptions(params, RequestOptions.none())

        /** @see [addSubscriptions] */
        @MustBeClosed
        fun addSubscriptions(
            params: ObjectBulkAddSubscriptionsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BulkOperation>

        /**
         * Returns a raw HTTP response for `post /v1/objects/{collection}/bulk/set`, but is
         * otherwise the same as [BulkService.set].
         */
        @MustBeClosed
        fun set(params: ObjectBulkSetParams): HttpResponseFor<BulkOperation> =
            set(params, RequestOptions.none())

        /** @see [set] */
        @MustBeClosed
        fun set(
            params: ObjectBulkSetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BulkOperation>
    }
}
