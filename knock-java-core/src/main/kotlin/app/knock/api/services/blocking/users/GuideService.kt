// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking.users

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
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface GuideService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): GuideService

    /** Returns a list of eligible in-app guides for a specific user and channel. */
    fun getChannel(userId: String, channelId: String): GuideGetChannelResponse =
        getChannel(userId, channelId, GuideGetChannelParams.none())

    /** @see [getChannel] */
    fun getChannel(
        userId: String,
        channelId: String,
        params: GuideGetChannelParams = GuideGetChannelParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GuideGetChannelResponse =
        getChannel(params.toBuilder().userId(userId).channelId(channelId).build(), requestOptions)

    /** @see [getChannel] */
    fun getChannel(
        userId: String,
        channelId: String,
        params: GuideGetChannelParams = GuideGetChannelParams.none(),
    ): GuideGetChannelResponse = getChannel(userId, channelId, params, RequestOptions.none())

    /** @see [getChannel] */
    fun getChannel(
        params: GuideGetChannelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GuideGetChannelResponse

    /** @see [getChannel] */
    fun getChannel(params: GuideGetChannelParams): GuideGetChannelResponse =
        getChannel(params, RequestOptions.none())

    /** @see [getChannel] */
    fun getChannel(
        userId: String,
        channelId: String,
        requestOptions: RequestOptions,
    ): GuideGetChannelResponse =
        getChannel(userId, channelId, GuideGetChannelParams.none(), requestOptions)

    /**
     * Records that a guide has been archived by a user, triggering any associated archived events.
     */
    fun markMessageAsArchived(
        userId: String,
        messageId: String,
        params: GuideMarkMessageAsArchivedParams,
    ): GuideMarkMessageAsArchivedResponse =
        markMessageAsArchived(userId, messageId, params, RequestOptions.none())

    /** @see [markMessageAsArchived] */
    fun markMessageAsArchived(
        userId: String,
        messageId: String,
        params: GuideMarkMessageAsArchivedParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GuideMarkMessageAsArchivedResponse =
        markMessageAsArchived(
            params.toBuilder().userId(userId).messageId(messageId).build(),
            requestOptions,
        )

    /** @see [markMessageAsArchived] */
    fun markMessageAsArchived(
        params: GuideMarkMessageAsArchivedParams
    ): GuideMarkMessageAsArchivedResponse = markMessageAsArchived(params, RequestOptions.none())

    /** @see [markMessageAsArchived] */
    fun markMessageAsArchived(
        params: GuideMarkMessageAsArchivedParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GuideMarkMessageAsArchivedResponse

    /**
     * Records that a user has interacted with a guide, triggering any associated interacted events.
     */
    fun markMessageAsInteracted(
        userId: String,
        messageId: String,
        params: GuideMarkMessageAsInteractedParams,
    ): GuideMarkMessageAsInteractedResponse =
        markMessageAsInteracted(userId, messageId, params, RequestOptions.none())

    /** @see [markMessageAsInteracted] */
    fun markMessageAsInteracted(
        userId: String,
        messageId: String,
        params: GuideMarkMessageAsInteractedParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GuideMarkMessageAsInteractedResponse =
        markMessageAsInteracted(
            params.toBuilder().userId(userId).messageId(messageId).build(),
            requestOptions,
        )

    /** @see [markMessageAsInteracted] */
    fun markMessageAsInteracted(
        params: GuideMarkMessageAsInteractedParams
    ): GuideMarkMessageAsInteractedResponse = markMessageAsInteracted(params, RequestOptions.none())

    /** @see [markMessageAsInteracted] */
    fun markMessageAsInteracted(
        params: GuideMarkMessageAsInteractedParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GuideMarkMessageAsInteractedResponse

    /** Records that a guide has been seen by a user, triggering any associated seen events. */
    fun markMessageAsSeen(
        userId: String,
        messageId: String,
        params: GuideMarkMessageAsSeenParams,
    ): GuideMarkMessageAsSeenResponse =
        markMessageAsSeen(userId, messageId, params, RequestOptions.none())

    /** @see [markMessageAsSeen] */
    fun markMessageAsSeen(
        userId: String,
        messageId: String,
        params: GuideMarkMessageAsSeenParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GuideMarkMessageAsSeenResponse =
        markMessageAsSeen(
            params.toBuilder().userId(userId).messageId(messageId).build(),
            requestOptions,
        )

    /** @see [markMessageAsSeen] */
    fun markMessageAsSeen(params: GuideMarkMessageAsSeenParams): GuideMarkMessageAsSeenResponse =
        markMessageAsSeen(params, RequestOptions.none())

    /** @see [markMessageAsSeen] */
    fun markMessageAsSeen(
        params: GuideMarkMessageAsSeenParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GuideMarkMessageAsSeenResponse

    /** A view of [GuideService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): GuideService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/users/{user_id}/guides/{channel_id}`, but is
         * otherwise the same as [GuideService.getChannel].
         */
        @MustBeClosed
        fun getChannel(
            userId: String,
            channelId: String,
        ): HttpResponseFor<GuideGetChannelResponse> =
            getChannel(userId, channelId, GuideGetChannelParams.none())

        /** @see [getChannel] */
        @MustBeClosed
        fun getChannel(
            userId: String,
            channelId: String,
            params: GuideGetChannelParams = GuideGetChannelParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GuideGetChannelResponse> =
            getChannel(
                params.toBuilder().userId(userId).channelId(channelId).build(),
                requestOptions,
            )

        /** @see [getChannel] */
        @MustBeClosed
        fun getChannel(
            userId: String,
            channelId: String,
            params: GuideGetChannelParams = GuideGetChannelParams.none(),
        ): HttpResponseFor<GuideGetChannelResponse> =
            getChannel(userId, channelId, params, RequestOptions.none())

        /** @see [getChannel] */
        @MustBeClosed
        fun getChannel(
            params: GuideGetChannelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GuideGetChannelResponse>

        /** @see [getChannel] */
        @MustBeClosed
        fun getChannel(params: GuideGetChannelParams): HttpResponseFor<GuideGetChannelResponse> =
            getChannel(params, RequestOptions.none())

        /** @see [getChannel] */
        @MustBeClosed
        fun getChannel(
            userId: String,
            channelId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<GuideGetChannelResponse> =
            getChannel(userId, channelId, GuideGetChannelParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put
         * /v1/users/{user_id}/guides/messages/{message_id}/archived`, but is otherwise the same as
         * [GuideService.markMessageAsArchived].
         */
        @MustBeClosed
        fun markMessageAsArchived(
            userId: String,
            messageId: String,
            params: GuideMarkMessageAsArchivedParams,
        ): HttpResponseFor<GuideMarkMessageAsArchivedResponse> =
            markMessageAsArchived(userId, messageId, params, RequestOptions.none())

        /** @see [markMessageAsArchived] */
        @MustBeClosed
        fun markMessageAsArchived(
            userId: String,
            messageId: String,
            params: GuideMarkMessageAsArchivedParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GuideMarkMessageAsArchivedResponse> =
            markMessageAsArchived(
                params.toBuilder().userId(userId).messageId(messageId).build(),
                requestOptions,
            )

        /** @see [markMessageAsArchived] */
        @MustBeClosed
        fun markMessageAsArchived(
            params: GuideMarkMessageAsArchivedParams
        ): HttpResponseFor<GuideMarkMessageAsArchivedResponse> =
            markMessageAsArchived(params, RequestOptions.none())

        /** @see [markMessageAsArchived] */
        @MustBeClosed
        fun markMessageAsArchived(
            params: GuideMarkMessageAsArchivedParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GuideMarkMessageAsArchivedResponse>

        /**
         * Returns a raw HTTP response for `put
         * /v1/users/{user_id}/guides/messages/{message_id}/interacted`, but is otherwise the same
         * as [GuideService.markMessageAsInteracted].
         */
        @MustBeClosed
        fun markMessageAsInteracted(
            userId: String,
            messageId: String,
            params: GuideMarkMessageAsInteractedParams,
        ): HttpResponseFor<GuideMarkMessageAsInteractedResponse> =
            markMessageAsInteracted(userId, messageId, params, RequestOptions.none())

        /** @see [markMessageAsInteracted] */
        @MustBeClosed
        fun markMessageAsInteracted(
            userId: String,
            messageId: String,
            params: GuideMarkMessageAsInteractedParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GuideMarkMessageAsInteractedResponse> =
            markMessageAsInteracted(
                params.toBuilder().userId(userId).messageId(messageId).build(),
                requestOptions,
            )

        /** @see [markMessageAsInteracted] */
        @MustBeClosed
        fun markMessageAsInteracted(
            params: GuideMarkMessageAsInteractedParams
        ): HttpResponseFor<GuideMarkMessageAsInteractedResponse> =
            markMessageAsInteracted(params, RequestOptions.none())

        /** @see [markMessageAsInteracted] */
        @MustBeClosed
        fun markMessageAsInteracted(
            params: GuideMarkMessageAsInteractedParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GuideMarkMessageAsInteractedResponse>

        /**
         * Returns a raw HTTP response for `put
         * /v1/users/{user_id}/guides/messages/{message_id}/seen`, but is otherwise the same as
         * [GuideService.markMessageAsSeen].
         */
        @MustBeClosed
        fun markMessageAsSeen(
            userId: String,
            messageId: String,
            params: GuideMarkMessageAsSeenParams,
        ): HttpResponseFor<GuideMarkMessageAsSeenResponse> =
            markMessageAsSeen(userId, messageId, params, RequestOptions.none())

        /** @see [markMessageAsSeen] */
        @MustBeClosed
        fun markMessageAsSeen(
            userId: String,
            messageId: String,
            params: GuideMarkMessageAsSeenParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GuideMarkMessageAsSeenResponse> =
            markMessageAsSeen(
                params.toBuilder().userId(userId).messageId(messageId).build(),
                requestOptions,
            )

        /** @see [markMessageAsSeen] */
        @MustBeClosed
        fun markMessageAsSeen(
            params: GuideMarkMessageAsSeenParams
        ): HttpResponseFor<GuideMarkMessageAsSeenResponse> =
            markMessageAsSeen(params, RequestOptions.none())

        /** @see [markMessageAsSeen] */
        @MustBeClosed
        fun markMessageAsSeen(
            params: GuideMarkMessageAsSeenParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GuideMarkMessageAsSeenResponse>
    }
}
