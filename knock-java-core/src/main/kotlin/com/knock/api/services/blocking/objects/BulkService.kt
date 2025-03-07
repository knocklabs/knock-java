// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.knock.api.services.blocking.objects

import com.google.errorprone.annotations.MustBeClosed
import com.knock.api.core.RequestOptions
import com.knock.api.core.http.HttpResponseFor
import com.knock.api.models.ObjectBulkAddSubscriptionsParams
import com.knock.api.models.ObjectBulkAddSubscriptionsResponse
import com.knock.api.models.ObjectBulkDeleteParams
import com.knock.api.models.ObjectBulkDeleteResponse
import com.knock.api.models.ObjectBulkSetParams
import com.knock.api.models.ObjectBulkSetResponse

interface BulkService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Bulk delete objects */
    @JvmOverloads
    fun delete(
        params: ObjectBulkDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ObjectBulkDeleteResponse

    /**
     * Add subscriptions for a set of objects in a single collection. If a subscription already
     * exists, it will be updated.
     */
    @JvmOverloads
    fun addSubscriptions(
        params: ObjectBulkAddSubscriptionsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ObjectBulkAddSubscriptionsResponse

    /** Bulk set objects */
    @JvmOverloads
    fun set(
        params: ObjectBulkSetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ObjectBulkSetResponse

    /** A view of [BulkService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/objects/{collection}/bulk/delete`, but is
         * otherwise the same as [BulkService.delete].
         */
        @JvmOverloads
        @MustBeClosed
        fun delete(
            params: ObjectBulkDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ObjectBulkDeleteResponse>

        /**
         * Returns a raw HTTP response for `post /v1/objects/{collection}/bulk/subscriptions/add`,
         * but is otherwise the same as [BulkService.addSubscriptions].
         */
        @JvmOverloads
        @MustBeClosed
        fun addSubscriptions(
            params: ObjectBulkAddSubscriptionsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ObjectBulkAddSubscriptionsResponse>

        /**
         * Returns a raw HTTP response for `post /v1/objects/{collection}/bulk/set`, but is
         * otherwise the same as [BulkService.set].
         */
        @JvmOverloads
        @MustBeClosed
        fun set(
            params: ObjectBulkSetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ObjectBulkSetResponse>
    }
}
