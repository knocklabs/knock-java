// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.knock.api.services.blocking.users

import com.google.errorprone.annotations.MustBeClosed
import com.knock.api.core.RequestOptions
import com.knock.api.core.http.HttpResponseFor
import com.knock.api.models.UserFeedGetSettingsParams
import com.knock.api.models.UserFeedGetSettingsResponse
import com.knock.api.models.UserFeedListItemsPage
import com.knock.api.models.UserFeedListItemsParams

interface FeedService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Returns the feed settings for a user. */
    @JvmOverloads
    fun getSettings(
        params: UserFeedGetSettingsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UserFeedGetSettingsResponse

    /** Returns a paginated list of feed items for a user, including metadata about the feed. */
    @JvmOverloads
    fun listItems(
        params: UserFeedListItemsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UserFeedListItemsPage

    /** A view of [FeedService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /v1/users/{user_id}/feeds/{id}/settings`, but is
         * otherwise the same as [FeedService.getSettings].
         */
        @JvmOverloads
        @MustBeClosed
        fun getSettings(
            params: UserFeedGetSettingsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UserFeedGetSettingsResponse>

        /**
         * Returns a raw HTTP response for `get /v1/users/{user_id}/feeds/{id}`, but is otherwise
         * the same as [FeedService.listItems].
         */
        @JvmOverloads
        @MustBeClosed
        fun listItems(
            params: UserFeedListItemsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UserFeedListItemsPage>
    }
}
