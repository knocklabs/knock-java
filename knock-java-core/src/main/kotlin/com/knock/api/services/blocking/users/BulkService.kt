// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.knock.api.services.blocking.users

import com.google.errorprone.annotations.MustBeClosed
import com.knock.api.core.RequestOptions
import com.knock.api.core.http.HttpResponseFor
import com.knock.api.models.UserBulkDeleteParams
import com.knock.api.models.UserBulkDeleteResponse
import com.knock.api.models.UserBulkIdentifyParams
import com.knock.api.models.UserBulkIdentifyResponse
import com.knock.api.models.UserBulkSetPreferencesParams
import com.knock.api.models.UserBulkSetPreferencesResponse

interface BulkService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Bulk delete users */
    @JvmOverloads
    fun delete(
        params: UserBulkDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UserBulkDeleteResponse

    /** Bulk identifies users */
    @JvmOverloads
    fun identify(
        params: UserBulkIdentifyParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UserBulkIdentifyResponse

    /** Bulk set preferences */
    @JvmOverloads
    fun setPreferences(
        params: UserBulkSetPreferencesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UserBulkSetPreferencesResponse

    /** A view of [BulkService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/users/bulk/delete`, but is otherwise the same
         * as [BulkService.delete].
         */
        @JvmOverloads
        @MustBeClosed
        fun delete(
            params: UserBulkDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UserBulkDeleteResponse>

        /**
         * Returns a raw HTTP response for `post /v1/users/bulk/identify`, but is otherwise the same
         * as [BulkService.identify].
         */
        @JvmOverloads
        @MustBeClosed
        fun identify(
            params: UserBulkIdentifyParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UserBulkIdentifyResponse>

        /**
         * Returns a raw HTTP response for `post /v1/users/bulk/preferences`, but is otherwise the
         * same as [BulkService.setPreferences].
         */
        @JvmOverloads
        @MustBeClosed
        fun setPreferences(
            params: UserBulkSetPreferencesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UserBulkSetPreferencesResponse>
    }
}
