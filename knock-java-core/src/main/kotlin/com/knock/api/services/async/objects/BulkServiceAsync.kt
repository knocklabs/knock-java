// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.async.objects

import com.google.errorprone.annotations.MustBeClosed
import com.knock.api.core.RequestOptions
import com.knock.api.core.http.HttpResponseFor
import com.knock.api.models.BulkOperation
import com.knock.api.models.ObjectBulkAddSubscriptionsParams
import com.knock.api.models.ObjectBulkDeleteParams
import com.knock.api.models.ObjectBulkSetParams
import java.util.concurrent.CompletableFuture

interface BulkServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Bulk delete objects */
    fun delete(params: ObjectBulkDeleteParams): CompletableFuture<BulkOperation> =
        delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: ObjectBulkDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BulkOperation>

    /**
     * Add subscriptions for a set of objects in a single collection. If a subscription already
     * exists, it will be updated.
     */
    fun addSubscriptions(
        params: ObjectBulkAddSubscriptionsParams
    ): CompletableFuture<BulkOperation> = addSubscriptions(params, RequestOptions.none())

    /** @see [addSubscriptions] */
    fun addSubscriptions(
        params: ObjectBulkAddSubscriptionsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BulkOperation>

    /** Bulk set objects */
    fun set(params: ObjectBulkSetParams): CompletableFuture<BulkOperation> =
        set(params, RequestOptions.none())

    /** @see [set] */
    fun set(
        params: ObjectBulkSetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BulkOperation>

    /** A view of [BulkServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/objects/{collection}/bulk/delete`, but is
         * otherwise the same as [BulkServiceAsync.delete].
         */
        @MustBeClosed
        fun delete(
            params: ObjectBulkDeleteParams
        ): CompletableFuture<HttpResponseFor<BulkOperation>> = delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: ObjectBulkDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BulkOperation>>

        /**
         * Returns a raw HTTP response for `post /v1/objects/{collection}/bulk/subscriptions/add`,
         * but is otherwise the same as [BulkServiceAsync.addSubscriptions].
         */
        @MustBeClosed
        fun addSubscriptions(
            params: ObjectBulkAddSubscriptionsParams
        ): CompletableFuture<HttpResponseFor<BulkOperation>> =
            addSubscriptions(params, RequestOptions.none())

        /** @see [addSubscriptions] */
        @MustBeClosed
        fun addSubscriptions(
            params: ObjectBulkAddSubscriptionsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BulkOperation>>

        /**
         * Returns a raw HTTP response for `post /v1/objects/{collection}/bulk/set`, but is
         * otherwise the same as [BulkServiceAsync.set].
         */
        @MustBeClosed
        fun set(params: ObjectBulkSetParams): CompletableFuture<HttpResponseFor<BulkOperation>> =
            set(params, RequestOptions.none())

        /** @see [set] */
        @MustBeClosed
        fun set(
            params: ObjectBulkSetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BulkOperation>>
    }
}
