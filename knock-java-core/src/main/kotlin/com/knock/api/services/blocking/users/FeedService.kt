// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.blocking.users

import com.google.errorprone.annotations.MustBeClosed
import com.knock.api.core.RequestOptions
import com.knock.api.core.http.HttpResponseFor
import com.knock.api.models.users.feeds.FeedGetSettingsParams
import com.knock.api.models.users.feeds.FeedGetSettingsResponse
import com.knock.api.models.users.feeds.FeedListItemsPage
import com.knock.api.models.users.feeds.FeedListItemsParams

interface FeedService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for
     * each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Returns the feed settings for a user. */
    fun getSettings(params: FeedGetSettingsParams): FeedGetSettingsResponse =
        getSettings(
          params, RequestOptions.none()
        )

    /** @see [getSettings] */
    fun getSettings(params: FeedGetSettingsParams, requestOptions: RequestOptions = RequestOptions.none()): FeedGetSettingsResponse

    /**
     * Returns a paginated list of feed items for a user, including metadata about the
     * feed.
     */
    fun listItems(params: FeedListItemsParams): FeedListItemsPage =
        listItems(
          params, RequestOptions.none()
        )

    /** @see [listItems] */
    fun listItems(params: FeedListItemsParams, requestOptions: RequestOptions = RequestOptions.none()): FeedListItemsPage

    /**
     * A view of [FeedService] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for
         * `get /v1/users/{user_id}/feeds/{channel_id}/settings`, but is otherwise the same
         * as [FeedService.getSettings].
         */
        @MustBeClosed
        fun getSettings(params: FeedGetSettingsParams): HttpResponseFor<FeedGetSettingsResponse> =
            getSettings(
              params, RequestOptions.none()
            )

        /** @see [getSettings] */
        @MustBeClosed
        fun getSettings(params: FeedGetSettingsParams, requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<FeedGetSettingsResponse>

        /**
         * Returns a raw HTTP response for `get /v1/users/{user_id}/feeds/{channel_id}`,
         * but is otherwise the same as [FeedService.listItems].
         */
        @MustBeClosed
        fun listItems(params: FeedListItemsParams): HttpResponseFor<FeedListItemsPage> =
            listItems(
              params, RequestOptions.none()
            )

        /** @see [listItems] */
        @MustBeClosed
        fun listItems(params: FeedListItemsParams, requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<FeedListItemsPage>
    }
}
