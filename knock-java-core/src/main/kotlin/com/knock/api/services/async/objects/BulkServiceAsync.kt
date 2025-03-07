// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.knock.api.services.async.objects

import com.google.errorprone.annotations.MustBeClosed
import com.knock.api.core.RequestOptions
import com.knock.api.core.http.HttpResponseFor
import com.knock.api.models.ObjectBulkAddSubscriptionsParams
import com.knock.api.models.ObjectBulkAddSubscriptionsResponse
import com.knock.api.models.ObjectBulkDeleteParams
import com.knock.api.models.ObjectBulkDeleteResponse
import com.knock.api.models.ObjectBulkSetParams
import com.knock.api.models.ObjectBulkSetResponse
import java.util.concurrent.CompletableFuture

interface BulkServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Bulk delete objects */
    @JvmOverloads
    fun delete(
        params: ObjectBulkDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ObjectBulkDeleteResponse>

    /**
     * Add subscriptions for a set of objects in a single collection. If a subscription already
     * exists, it will be updated.
     */
    @JvmOverloads
    fun addSubscriptions(
        params: ObjectBulkAddSubscriptionsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ObjectBulkAddSubscriptionsResponse>

    /** Bulk set objects */
    @JvmOverloads
    fun set(
        params: ObjectBulkSetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ObjectBulkSetResponse>

    /** A view of [BulkServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/objects/{collection}/bulk/delete`, but is
         * otherwise the same as [BulkServiceAsync.delete].
         */
        @JvmOverloads
        @MustBeClosed
        fun delete(
            params: ObjectBulkDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ObjectBulkDeleteResponse>>

        /**
         * Returns a raw HTTP response for `post /v1/objects/{collection}/bulk/subscriptions/add`,
         * but is otherwise the same as [BulkServiceAsync.addSubscriptions].
         */
        @JvmOverloads
        @MustBeClosed
        fun addSubscriptions(
            params: ObjectBulkAddSubscriptionsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ObjectBulkAddSubscriptionsResponse>>

        /**
         * Returns a raw HTTP response for `post /v1/objects/{collection}/bulk/set`, but is
         * otherwise the same as [BulkServiceAsync.set].
         */
        @JvmOverloads
        @MustBeClosed
        fun set(
            params: ObjectBulkSetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ObjectBulkSetResponse>>
    }
}
