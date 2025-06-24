// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking.users

import app.knock.api.core.ClientOptions
import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.users.feeds.FeedGetSettingsParams
import app.knock.api.models.users.feeds.FeedGetSettingsResponse
import app.knock.api.models.users.feeds.FeedListItemsPage
import app.knock.api.models.users.feeds.FeedListItemsParams
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface FeedService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): FeedService

    /** Returns the feed settings for a user. */
    fun getSettings(userId: String, id: String): FeedGetSettingsResponse =
        getSettings(userId, id, FeedGetSettingsParams.none())

    /** @see [getSettings] */
    fun getSettings(
        userId: String,
        id: String,
        params: FeedGetSettingsParams = FeedGetSettingsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeedGetSettingsResponse =
        getSettings(params.toBuilder().userId(userId).id(id).build(), requestOptions)

    /** @see [getSettings] */
    fun getSettings(
        userId: String,
        id: String,
        params: FeedGetSettingsParams = FeedGetSettingsParams.none(),
    ): FeedGetSettingsResponse = getSettings(userId, id, params, RequestOptions.none())

    /** @see [getSettings] */
    fun getSettings(
        params: FeedGetSettingsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeedGetSettingsResponse

    /** @see [getSettings] */
    fun getSettings(params: FeedGetSettingsParams): FeedGetSettingsResponse =
        getSettings(params, RequestOptions.none())

    /** @see [getSettings] */
    fun getSettings(
        userId: String,
        id: String,
        requestOptions: RequestOptions,
    ): FeedGetSettingsResponse =
        getSettings(userId, id, FeedGetSettingsParams.none(), requestOptions)

    /**
     * Returns a paginated list of feed items for a user in reverse chronological order, including
     * metadata about the feed. If the user has not yet been identified within Knock, an empty feed
     * will be returned.
     *
     * You can customize the response using
     * [response filters](/integrations/in-app/knock#customizing-api-response-content) to exclude or
     * only include specific properties on your resources.
     *
     * **Notes:**
     * - When making this call from a client-side environment, use your publishable key along with a
     *   user token.
     * - This endpoint’s rate limit is always scoped per-user and per-environment. This is true even
     *   for requests made without a signed user token.
     */
    fun listItems(userId: String, id: String): FeedListItemsPage =
        listItems(userId, id, FeedListItemsParams.none())

    /** @see [listItems] */
    fun listItems(
        userId: String,
        id: String,
        params: FeedListItemsParams = FeedListItemsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeedListItemsPage =
        listItems(params.toBuilder().userId(userId).id(id).build(), requestOptions)

    /** @see [listItems] */
    fun listItems(
        userId: String,
        id: String,
        params: FeedListItemsParams = FeedListItemsParams.none(),
    ): FeedListItemsPage = listItems(userId, id, params, RequestOptions.none())

    /** @see [listItems] */
    fun listItems(
        params: FeedListItemsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeedListItemsPage

    /** @see [listItems] */
    fun listItems(params: FeedListItemsParams): FeedListItemsPage =
        listItems(params, RequestOptions.none())

    /** @see [listItems] */
    fun listItems(userId: String, id: String, requestOptions: RequestOptions): FeedListItemsPage =
        listItems(userId, id, FeedListItemsParams.none(), requestOptions)

    /** A view of [FeedService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): FeedService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/users/{user_id}/feeds/{id}/settings`, but is
         * otherwise the same as [FeedService.getSettings].
         */
        @MustBeClosed
        fun getSettings(userId: String, id: String): HttpResponseFor<FeedGetSettingsResponse> =
            getSettings(userId, id, FeedGetSettingsParams.none())

        /** @see [getSettings] */
        @MustBeClosed
        fun getSettings(
            userId: String,
            id: String,
            params: FeedGetSettingsParams = FeedGetSettingsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FeedGetSettingsResponse> =
            getSettings(params.toBuilder().userId(userId).id(id).build(), requestOptions)

        /** @see [getSettings] */
        @MustBeClosed
        fun getSettings(
            userId: String,
            id: String,
            params: FeedGetSettingsParams = FeedGetSettingsParams.none(),
        ): HttpResponseFor<FeedGetSettingsResponse> =
            getSettings(userId, id, params, RequestOptions.none())

        /** @see [getSettings] */
        @MustBeClosed
        fun getSettings(
            params: FeedGetSettingsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FeedGetSettingsResponse>

        /** @see [getSettings] */
        @MustBeClosed
        fun getSettings(params: FeedGetSettingsParams): HttpResponseFor<FeedGetSettingsResponse> =
            getSettings(params, RequestOptions.none())

        /** @see [getSettings] */
        @MustBeClosed
        fun getSettings(
            userId: String,
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FeedGetSettingsResponse> =
            getSettings(userId, id, FeedGetSettingsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/users/{user_id}/feeds/{id}`, but is otherwise
         * the same as [FeedService.listItems].
         */
        @MustBeClosed
        fun listItems(userId: String, id: String): HttpResponseFor<FeedListItemsPage> =
            listItems(userId, id, FeedListItemsParams.none())

        /** @see [listItems] */
        @MustBeClosed
        fun listItems(
            userId: String,
            id: String,
            params: FeedListItemsParams = FeedListItemsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FeedListItemsPage> =
            listItems(params.toBuilder().userId(userId).id(id).build(), requestOptions)

        /** @see [listItems] */
        @MustBeClosed
        fun listItems(
            userId: String,
            id: String,
            params: FeedListItemsParams = FeedListItemsParams.none(),
        ): HttpResponseFor<FeedListItemsPage> = listItems(userId, id, params, RequestOptions.none())

        /** @see [listItems] */
        @MustBeClosed
        fun listItems(
            params: FeedListItemsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FeedListItemsPage>

        /** @see [listItems] */
        @MustBeClosed
        fun listItems(params: FeedListItemsParams): HttpResponseFor<FeedListItemsPage> =
            listItems(params, RequestOptions.none())

        /** @see [listItems] */
        @MustBeClosed
        fun listItems(
            userId: String,
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FeedListItemsPage> =
            listItems(userId, id, FeedListItemsParams.none(), requestOptions)
    }
}
