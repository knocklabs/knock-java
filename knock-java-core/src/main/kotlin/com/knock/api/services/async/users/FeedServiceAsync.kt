// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

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
    @JvmOverloads
    fun getSettings(
        params: UserFeedGetSettingsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserFeedGetSettingsResponse>

    /** Returns a paginated list of feed items for a user, including metadata about the feed. */
    @JvmOverloads
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
        @JvmOverloads
        @MustBeClosed
        fun getSettings(
            params: UserFeedGetSettingsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserFeedGetSettingsResponse>>

        /**
         * Returns a raw HTTP response for `get /v1/users/{user_id}/feeds/{id}`, but is otherwise
         * the same as [FeedServiceAsync.listItems].
         */
        @JvmOverloads
        @MustBeClosed
        fun listItems(
            params: UserFeedListItemsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserFeedListItemsPageAsync>>
    }
}
