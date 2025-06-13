// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async.users

import app.knock.api.core.ClientOptions
import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.users.guides.GuideGetChannelParams
import app.knock.api.models.users.guides.GuideGetChannelResponse
import app.knock.api.models.users.guides.GuideMarkMessageAsArchivedParams
import app.knock.api.models.users.guides.GuideMarkMessageAsArchivedResponse
import app.knock.api.models.users.guides.GuideMarkMessageAsInteractedParams
import app.knock.api.models.users.guides.GuideMarkMessageAsInteractedResponse
import app.knock.api.models.users.guides.GuideMarkMessageAsSeenParams
import app.knock.api.models.users.guides.GuideMarkMessageAsSeenResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface GuideServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): GuideServiceAsync

    /** Returns a list of eligible in-app guides for a specific user and channel. */
    fun getChannel(userId: String, channelId: String): CompletableFuture<GuideGetChannelResponse> =
        getChannel(userId, channelId, GuideGetChannelParams.none())

    /** @see [getChannel] */
    fun getChannel(
        userId: String,
        channelId: String,
        params: GuideGetChannelParams = GuideGetChannelParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<GuideGetChannelResponse> =
        getChannel(params.toBuilder().userId(userId).channelId(channelId).build(), requestOptions)

    /** @see [getChannel] */
    fun getChannel(
        userId: String,
        channelId: String,
        params: GuideGetChannelParams = GuideGetChannelParams.none(),
    ): CompletableFuture<GuideGetChannelResponse> =
        getChannel(userId, channelId, params, RequestOptions.none())

    /** @see [getChannel] */
    fun getChannel(
        params: GuideGetChannelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<GuideGetChannelResponse>

    /** @see [getChannel] */
    fun getChannel(params: GuideGetChannelParams): CompletableFuture<GuideGetChannelResponse> =
        getChannel(params, RequestOptions.none())

    /** @see [getChannel] */
    fun getChannel(
        userId: String,
        channelId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<GuideGetChannelResponse> =
        getChannel(userId, channelId, GuideGetChannelParams.none(), requestOptions)

    /**
     * Records that a guide has been archived by a user, triggering any associated archived events.
     */
    fun markMessageAsArchived(
        userId: String,
        messageId: String,
        params: GuideMarkMessageAsArchivedParams,
    ): CompletableFuture<GuideMarkMessageAsArchivedResponse> =
        markMessageAsArchived(userId, messageId, params, RequestOptions.none())

    /** @see [markMessageAsArchived] */
    fun markMessageAsArchived(
        userId: String,
        messageId: String,
        params: GuideMarkMessageAsArchivedParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<GuideMarkMessageAsArchivedResponse> =
        markMessageAsArchived(
            params.toBuilder().userId(userId).messageId(messageId).build(),
            requestOptions,
        )

    /** @see [markMessageAsArchived] */
    fun markMessageAsArchived(
        params: GuideMarkMessageAsArchivedParams
    ): CompletableFuture<GuideMarkMessageAsArchivedResponse> =
        markMessageAsArchived(params, RequestOptions.none())

    /** @see [markMessageAsArchived] */
    fun markMessageAsArchived(
        params: GuideMarkMessageAsArchivedParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<GuideMarkMessageAsArchivedResponse>

    /**
     * Records that a user has interacted with a guide, triggering any associated interacted events.
     */
    fun markMessageAsInteracted(
        userId: String,
        messageId: String,
        params: GuideMarkMessageAsInteractedParams,
    ): CompletableFuture<GuideMarkMessageAsInteractedResponse> =
        markMessageAsInteracted(userId, messageId, params, RequestOptions.none())

    /** @see [markMessageAsInteracted] */
    fun markMessageAsInteracted(
        userId: String,
        messageId: String,
        params: GuideMarkMessageAsInteractedParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<GuideMarkMessageAsInteractedResponse> =
        markMessageAsInteracted(
            params.toBuilder().userId(userId).messageId(messageId).build(),
            requestOptions,
        )

    /** @see [markMessageAsInteracted] */
    fun markMessageAsInteracted(
        params: GuideMarkMessageAsInteractedParams
    ): CompletableFuture<GuideMarkMessageAsInteractedResponse> =
        markMessageAsInteracted(params, RequestOptions.none())

    /** @see [markMessageAsInteracted] */
    fun markMessageAsInteracted(
        params: GuideMarkMessageAsInteractedParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<GuideMarkMessageAsInteractedResponse>

    /** Records that a guide has been seen by a user, triggering any associated seen events. */
    fun markMessageAsSeen(
        userId: String,
        messageId: String,
        params: GuideMarkMessageAsSeenParams,
    ): CompletableFuture<GuideMarkMessageAsSeenResponse> =
        markMessageAsSeen(userId, messageId, params, RequestOptions.none())

    /** @see [markMessageAsSeen] */
    fun markMessageAsSeen(
        userId: String,
        messageId: String,
        params: GuideMarkMessageAsSeenParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<GuideMarkMessageAsSeenResponse> =
        markMessageAsSeen(
            params.toBuilder().userId(userId).messageId(messageId).build(),
            requestOptions,
        )

    /** @see [markMessageAsSeen] */
    fun markMessageAsSeen(
        params: GuideMarkMessageAsSeenParams
    ): CompletableFuture<GuideMarkMessageAsSeenResponse> =
        markMessageAsSeen(params, RequestOptions.none())

    /** @see [markMessageAsSeen] */
    fun markMessageAsSeen(
        params: GuideMarkMessageAsSeenParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<GuideMarkMessageAsSeenResponse>

    /** A view of [GuideServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): GuideServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/users/{user_id}/guides/{channel_id}`, but is
         * otherwise the same as [GuideServiceAsync.getChannel].
         */
        fun getChannel(
            userId: String,
            channelId: String,
        ): CompletableFuture<HttpResponseFor<GuideGetChannelResponse>> =
            getChannel(userId, channelId, GuideGetChannelParams.none())

        /** @see [getChannel] */
        fun getChannel(
            userId: String,
            channelId: String,
            params: GuideGetChannelParams = GuideGetChannelParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<GuideGetChannelResponse>> =
            getChannel(
                params.toBuilder().userId(userId).channelId(channelId).build(),
                requestOptions,
            )

        /** @see [getChannel] */
        fun getChannel(
            userId: String,
            channelId: String,
            params: GuideGetChannelParams = GuideGetChannelParams.none(),
        ): CompletableFuture<HttpResponseFor<GuideGetChannelResponse>> =
            getChannel(userId, channelId, params, RequestOptions.none())

        /** @see [getChannel] */
        fun getChannel(
            params: GuideGetChannelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<GuideGetChannelResponse>>

        /** @see [getChannel] */
        fun getChannel(
            params: GuideGetChannelParams
        ): CompletableFuture<HttpResponseFor<GuideGetChannelResponse>> =
            getChannel(params, RequestOptions.none())

        /** @see [getChannel] */
        fun getChannel(
            userId: String,
            channelId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<GuideGetChannelResponse>> =
            getChannel(userId, channelId, GuideGetChannelParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put
         * /v1/users/{user_id}/guides/messages/{message_id}/archived`, but is otherwise the same as
         * [GuideServiceAsync.markMessageAsArchived].
         */
        fun markMessageAsArchived(
            userId: String,
            messageId: String,
            params: GuideMarkMessageAsArchivedParams,
        ): CompletableFuture<HttpResponseFor<GuideMarkMessageAsArchivedResponse>> =
            markMessageAsArchived(userId, messageId, params, RequestOptions.none())

        /** @see [markMessageAsArchived] */
        fun markMessageAsArchived(
            userId: String,
            messageId: String,
            params: GuideMarkMessageAsArchivedParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<GuideMarkMessageAsArchivedResponse>> =
            markMessageAsArchived(
                params.toBuilder().userId(userId).messageId(messageId).build(),
                requestOptions,
            )

        /** @see [markMessageAsArchived] */
        fun markMessageAsArchived(
            params: GuideMarkMessageAsArchivedParams
        ): CompletableFuture<HttpResponseFor<GuideMarkMessageAsArchivedResponse>> =
            markMessageAsArchived(params, RequestOptions.none())

        /** @see [markMessageAsArchived] */
        fun markMessageAsArchived(
            params: GuideMarkMessageAsArchivedParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<GuideMarkMessageAsArchivedResponse>>

        /**
         * Returns a raw HTTP response for `put
         * /v1/users/{user_id}/guides/messages/{message_id}/interacted`, but is otherwise the same
         * as [GuideServiceAsync.markMessageAsInteracted].
         */
        fun markMessageAsInteracted(
            userId: String,
            messageId: String,
            params: GuideMarkMessageAsInteractedParams,
        ): CompletableFuture<HttpResponseFor<GuideMarkMessageAsInteractedResponse>> =
            markMessageAsInteracted(userId, messageId, params, RequestOptions.none())

        /** @see [markMessageAsInteracted] */
        fun markMessageAsInteracted(
            userId: String,
            messageId: String,
            params: GuideMarkMessageAsInteractedParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<GuideMarkMessageAsInteractedResponse>> =
            markMessageAsInteracted(
                params.toBuilder().userId(userId).messageId(messageId).build(),
                requestOptions,
            )

        /** @see [markMessageAsInteracted] */
        fun markMessageAsInteracted(
            params: GuideMarkMessageAsInteractedParams
        ): CompletableFuture<HttpResponseFor<GuideMarkMessageAsInteractedResponse>> =
            markMessageAsInteracted(params, RequestOptions.none())

        /** @see [markMessageAsInteracted] */
        fun markMessageAsInteracted(
            params: GuideMarkMessageAsInteractedParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<GuideMarkMessageAsInteractedResponse>>

        /**
         * Returns a raw HTTP response for `put
         * /v1/users/{user_id}/guides/messages/{message_id}/seen`, but is otherwise the same as
         * [GuideServiceAsync.markMessageAsSeen].
         */
        fun markMessageAsSeen(
            userId: String,
            messageId: String,
            params: GuideMarkMessageAsSeenParams,
        ): CompletableFuture<HttpResponseFor<GuideMarkMessageAsSeenResponse>> =
            markMessageAsSeen(userId, messageId, params, RequestOptions.none())

        /** @see [markMessageAsSeen] */
        fun markMessageAsSeen(
            userId: String,
            messageId: String,
            params: GuideMarkMessageAsSeenParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<GuideMarkMessageAsSeenResponse>> =
            markMessageAsSeen(
                params.toBuilder().userId(userId).messageId(messageId).build(),
                requestOptions,
            )

        /** @see [markMessageAsSeen] */
        fun markMessageAsSeen(
            params: GuideMarkMessageAsSeenParams
        ): CompletableFuture<HttpResponseFor<GuideMarkMessageAsSeenResponse>> =
            markMessageAsSeen(params, RequestOptions.none())

        /** @see [markMessageAsSeen] */
        fun markMessageAsSeen(
            params: GuideMarkMessageAsSeenParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<GuideMarkMessageAsSeenResponse>>
    }
}
