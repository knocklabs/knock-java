// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async.users

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.users.feeds.FeedGetSettingsParams
import app.knock.api.models.users.feeds.FeedGetSettingsResponse
import app.knock.api.models.users.feeds.FeedListItemsPageAsync
import app.knock.api.models.users.feeds.FeedListItemsParams
import com.google.errorprone.annotations.MustBeClosed
import java.util.concurrent.CompletableFuture

interface FeedServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Returns the feed settings for a user. */
    fun getSettings(params: FeedGetSettingsParams): CompletableFuture<FeedGetSettingsResponse> =
        getSettings(params, RequestOptions.none())

    /** @see [getSettings] */
    fun getSettings(
        params: FeedGetSettingsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FeedGetSettingsResponse>

    /** Returns a paginated list of feed items for a user, including metadata about the feed. */
    fun listItems(params: FeedListItemsParams): CompletableFuture<FeedListItemsPageAsync> =
        listItems(params, RequestOptions.none())

    /** @see [listItems] */
    fun listItems(
        params: FeedListItemsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FeedListItemsPageAsync>

    /** A view of [FeedServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /v1/users/{user_id}/feeds/{channel_id}/settings`,
         * but is otherwise the same as [FeedServiceAsync.getSettings].
         */
        @MustBeClosed
        fun getSettings(
            params: FeedGetSettingsParams
        ): CompletableFuture<HttpResponseFor<FeedGetSettingsResponse>> =
            getSettings(params, RequestOptions.none())

        /** @see [getSettings] */
        @MustBeClosed
        fun getSettings(
            params: FeedGetSettingsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FeedGetSettingsResponse>>

        /**
         * Returns a raw HTTP response for `get /v1/users/{user_id}/feeds/{channel_id}`, but is
         * otherwise the same as [FeedServiceAsync.listItems].
         */
        @MustBeClosed
        fun listItems(
            params: FeedListItemsParams
        ): CompletableFuture<HttpResponseFor<FeedListItemsPageAsync>> =
            listItems(params, RequestOptions.none())

        /** @see [listItems] */
        @MustBeClosed
        fun listItems(
            params: FeedListItemsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FeedListItemsPageAsync>>
    }
}
