// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.async.users

import com.google.errorprone.annotations.MustBeClosed
import com.knock.api.core.RequestOptions
import com.knock.api.core.http.HttpResponseFor
import com.knock.api.models.UserFeedGetSettingsParams
import com.knock.api.models.UserFeedGetSettingsResponse
import com.knock.api.models.UserFeedListItemsPageAsync
import com.knock.api.models.UserFeedListItemsParams
import java.util.concurrent.CompletableFuture

interface FeedServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Returns the feed settings for a user. */
    fun getSettings(
        params: UserFeedGetSettingsParams
    ): CompletableFuture<UserFeedGetSettingsResponse> = getSettings(params, RequestOptions.none())

    /** @see [getSettings] */
    fun getSettings(
        params: UserFeedGetSettingsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserFeedGetSettingsResponse>

    /** Returns a paginated list of feed items for a user, including metadata about the feed. */
    fun listItems(params: UserFeedListItemsParams): CompletableFuture<UserFeedListItemsPageAsync> =
        listItems(params, RequestOptions.none())

    /** @see [listItems] */
    fun listItems(
        params: UserFeedListItemsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserFeedListItemsPageAsync>

    /** A view of [FeedServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /v1/users/{user_id}/feeds/{id}/settings`, but is
         * otherwise the same as [FeedServiceAsync.getSettings].
         */
        @MustBeClosed
        fun getSettings(
            params: UserFeedGetSettingsParams
        ): CompletableFuture<HttpResponseFor<UserFeedGetSettingsResponse>> =
            getSettings(params, RequestOptions.none())

        /** @see [getSettings] */
        @MustBeClosed
        fun getSettings(
            params: UserFeedGetSettingsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserFeedGetSettingsResponse>>

        /**
         * Returns a raw HTTP response for `get /v1/users/{user_id}/feeds/{id}`, but is otherwise
         * the same as [FeedServiceAsync.listItems].
         */
        @MustBeClosed
        fun listItems(
            params: UserFeedListItemsParams
        ): CompletableFuture<HttpResponseFor<UserFeedListItemsPageAsync>> =
            listItems(params, RequestOptions.none())

        /** @see [listItems] */
        @MustBeClosed
        fun listItems(
            params: UserFeedListItemsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserFeedListItemsPageAsync>>
    }
}
