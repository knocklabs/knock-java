// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.knock.api.services.async.users

import com.google.errorprone.annotations.MustBeClosed
import com.knock.api.core.RequestOptions
import com.knock.api.core.http.HttpResponseFor
import com.knock.api.models.UserBulkDeleteParams
import com.knock.api.models.UserBulkDeleteResponse
import com.knock.api.models.UserBulkIdentifyParams
import com.knock.api.models.UserBulkIdentifyResponse
import com.knock.api.models.UserBulkSetPreferencesParams
import com.knock.api.models.UserBulkSetPreferencesResponse
import java.util.concurrent.CompletableFuture

interface BulkServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Bulk delete users */
    @JvmOverloads
    fun delete(
        params: UserBulkDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserBulkDeleteResponse>

    /** Bulk identifies users */
    @JvmOverloads
    fun identify(
        params: UserBulkIdentifyParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserBulkIdentifyResponse>

    /** Bulk set preferences */
    @JvmOverloads
    fun setPreferences(
        params: UserBulkSetPreferencesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserBulkSetPreferencesResponse>

    /** A view of [BulkServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/users/bulk/delete`, but is otherwise the same
         * as [BulkServiceAsync.delete].
         */
        @JvmOverloads
        @MustBeClosed
        fun delete(
            params: UserBulkDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserBulkDeleteResponse>>

        /**
         * Returns a raw HTTP response for `post /v1/users/bulk/identify`, but is otherwise the same
         * as [BulkServiceAsync.identify].
         */
        @JvmOverloads
        @MustBeClosed
        fun identify(
            params: UserBulkIdentifyParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserBulkIdentifyResponse>>

        /**
         * Returns a raw HTTP response for `post /v1/users/bulk/preferences`, but is otherwise the
         * same as [BulkServiceAsync.setPreferences].
         */
        @JvmOverloads
        @MustBeClosed
        fun setPreferences(
            params: UserBulkSetPreferencesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserBulkSetPreferencesResponse>>
    }
}
