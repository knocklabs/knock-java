// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.blocking.users

import com.google.errorprone.annotations.MustBeClosed
import com.knock.api.core.RequestOptions
import com.knock.api.core.http.HttpResponseFor
import com.knock.api.models.BulkOperation
import com.knock.api.models.UserBulkDeleteParams
import com.knock.api.models.UserBulkIdentifyParams
import com.knock.api.models.UserBulkSetPreferencesParams

interface BulkService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Bulk delete users */
    fun delete(params: UserBulkDeleteParams): BulkOperation = delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: UserBulkDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BulkOperation

    /** Bulk identifies users */
    fun identify(params: UserBulkIdentifyParams): BulkOperation =
        identify(params, RequestOptions.none())

    /** @see [identify] */
    fun identify(
        params: UserBulkIdentifyParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BulkOperation

    /** Bulk set preferences */
    fun setPreferences(params: UserBulkSetPreferencesParams): BulkOperation =
        setPreferences(params, RequestOptions.none())

    /** @see [setPreferences] */
    fun setPreferences(
        params: UserBulkSetPreferencesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BulkOperation

    /** A view of [BulkService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/users/bulk/delete`, but is otherwise the same
         * as [BulkService.delete].
         */
        @MustBeClosed
        fun delete(params: UserBulkDeleteParams): HttpResponseFor<BulkOperation> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: UserBulkDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BulkOperation>

        /**
         * Returns a raw HTTP response for `post /v1/users/bulk/identify`, but is otherwise the same
         * as [BulkService.identify].
         */
        @MustBeClosed
        fun identify(params: UserBulkIdentifyParams): HttpResponseFor<BulkOperation> =
            identify(params, RequestOptions.none())

        /** @see [identify] */
        @MustBeClosed
        fun identify(
            params: UserBulkIdentifyParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BulkOperation>

        /**
         * Returns a raw HTTP response for `post /v1/users/bulk/preferences`, but is otherwise the
         * same as [BulkService.setPreferences].
         */
        @MustBeClosed
        fun setPreferences(params: UserBulkSetPreferencesParams): HttpResponseFor<BulkOperation> =
            setPreferences(params, RequestOptions.none())

        /** @see [setPreferences] */
        @MustBeClosed
        fun setPreferences(
            params: UserBulkSetPreferencesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BulkOperation>
    }
}
