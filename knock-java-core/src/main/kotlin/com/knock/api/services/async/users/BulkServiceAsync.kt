// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.async.users

import com.google.errorprone.annotations.MustBeClosed
import com.knock.api.core.RequestOptions
import com.knock.api.core.http.HttpResponseFor
import com.knock.api.models.BulkOperation
import com.knock.api.models.UserBulkDeleteParams
import com.knock.api.models.UserBulkIdentifyParams
import com.knock.api.models.UserBulkSetPreferencesParams
import java.util.concurrent.CompletableFuture

interface BulkServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Bulk delete users */
    fun delete(params: UserBulkDeleteParams): CompletableFuture<BulkOperation> =
        delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: UserBulkDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BulkOperation>

    /** Bulk identifies users */
    fun identify(params: UserBulkIdentifyParams): CompletableFuture<BulkOperation> =
        identify(params, RequestOptions.none())

    /** @see [identify] */
    fun identify(
        params: UserBulkIdentifyParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BulkOperation>

    /** Bulk set preferences */
    fun setPreferences(params: UserBulkSetPreferencesParams): CompletableFuture<BulkOperation> =
        setPreferences(params, RequestOptions.none())

    /** @see [setPreferences] */
    fun setPreferences(
        params: UserBulkSetPreferencesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BulkOperation>

    /** A view of [BulkServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/users/bulk/delete`, but is otherwise the same
         * as [BulkServiceAsync.delete].
         */
        @MustBeClosed
        fun delete(
            params: UserBulkDeleteParams
        ): CompletableFuture<HttpResponseFor<BulkOperation>> = delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: UserBulkDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BulkOperation>>

        /**
         * Returns a raw HTTP response for `post /v1/users/bulk/identify`, but is otherwise the same
         * as [BulkServiceAsync.identify].
         */
        @MustBeClosed
        fun identify(
            params: UserBulkIdentifyParams
        ): CompletableFuture<HttpResponseFor<BulkOperation>> =
            identify(params, RequestOptions.none())

        /** @see [identify] */
        @MustBeClosed
        fun identify(
            params: UserBulkIdentifyParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BulkOperation>>

        /**
         * Returns a raw HTTP response for `post /v1/users/bulk/preferences`, but is otherwise the
         * same as [BulkServiceAsync.setPreferences].
         */
        @MustBeClosed
        fun setPreferences(
            params: UserBulkSetPreferencesParams
        ): CompletableFuture<HttpResponseFor<BulkOperation>> =
            setPreferences(params, RequestOptions.none())

        /** @see [setPreferences] */
        @MustBeClosed
        fun setPreferences(
            params: UserBulkSetPreferencesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BulkOperation>>
    }
}
