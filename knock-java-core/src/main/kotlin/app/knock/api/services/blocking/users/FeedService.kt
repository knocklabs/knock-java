// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking.users

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.users.feeds.FeedGetSettingsParams
import app.knock.api.models.users.feeds.FeedGetSettingsResponse
import app.knock.api.models.users.feeds.FeedListItemsPage
import app.knock.api.models.users.feeds.FeedListItemsParams
import com.google.errorprone.annotations.MustBeClosed

interface FeedService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Returns the feed settings for a user. */
    fun getSettings(params: FeedGetSettingsParams): FeedGetSettingsResponse =
        getSettings(params, RequestOptions.none())

    /** @see [getSettings] */
    fun getSettings(
        params: FeedGetSettingsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeedGetSettingsResponse

    /** Returns a paginated list of feed items for a user, including metadata about the feed. */
    fun listItems(params: FeedListItemsParams): FeedListItemsPage =
        listItems(params, RequestOptions.none())

    /** @see [listItems] */
    fun listItems(
        params: FeedListItemsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeedListItemsPage

    /** A view of [FeedService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /v1/users/{user_id}/feeds/{id}/settings`, but is
         * otherwise the same as [FeedService.getSettings].
         */
        @MustBeClosed
        fun getSettings(params: FeedGetSettingsParams): HttpResponseFor<FeedGetSettingsResponse> =
            getSettings(params, RequestOptions.none())

        /** @see [getSettings] */
        @MustBeClosed
        fun getSettings(
            params: FeedGetSettingsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FeedGetSettingsResponse>

        /**
         * Returns a raw HTTP response for `get /v1/users/{user_id}/feeds/{id}`, but is otherwise
         * the same as [FeedService.listItems].
         */
        @MustBeClosed
        fun listItems(params: FeedListItemsParams): HttpResponseFor<FeedListItemsPage> =
            listItems(params, RequestOptions.none())

        /** @see [listItems] */
        @MustBeClosed
        fun listItems(
            params: FeedListItemsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FeedListItemsPage>
    }
}
