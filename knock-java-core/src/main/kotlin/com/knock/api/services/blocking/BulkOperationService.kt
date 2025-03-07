// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.knock.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.knock.api.core.RequestOptions
import com.knock.api.core.http.HttpResponseFor
import com.knock.api.models.BulkOperationGetParams
import com.knock.api.models.BulkOperationGetResponse

interface BulkOperationService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Retrieves a bulk operation (if it exists) and displays the current state of it. */
    @JvmOverloads
    fun get(
        params: BulkOperationGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BulkOperationGetResponse

    /**
     * A view of [BulkOperationService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /v1/bulk_operations/{id}`, but is otherwise the same
         * as [BulkOperationService.get].
         */
        @JvmOverloads
        @MustBeClosed
        fun get(
            params: BulkOperationGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BulkOperationGetResponse>
    }
}
