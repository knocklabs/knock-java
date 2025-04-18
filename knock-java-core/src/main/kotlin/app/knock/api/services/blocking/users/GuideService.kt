// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking.users

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

interface GuideService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Returns a list of eligible in-app guides for a specific user and channel. */
    fun getChannel(params: GuideGetChannelParams): GuideGetChannelResponse =
        getChannel(params, RequestOptions.none())

    /** @see [getChannel] */
    fun getChannel(
        params: GuideGetChannelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GuideGetChannelResponse

    /**
     * Records that a guide has been archived by a user, triggering any associated archived events.
     */
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
        params: GuideMarkMessageAsInteractedParams
    ): GuideMarkMessageAsInteractedResponse = markMessageAsInteracted(params, RequestOptions.none())

    /** @see [markMessageAsInteracted] */
    fun markMessageAsInteracted(
        params: GuideMarkMessageAsInteractedParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GuideMarkMessageAsInteractedResponse

    /** Records that a guide has been seen by a user, triggering any associated seen events. */
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
         * Returns a raw HTTP response for `get /v1/users/{user_id}/guides/{channel_id}`, but is
         * otherwise the same as [GuideService.getChannel].
         */
        @MustBeClosed
        fun getChannel(params: GuideGetChannelParams): HttpResponseFor<GuideGetChannelResponse> =
            getChannel(params, RequestOptions.none())

        /** @see [getChannel] */
        @MustBeClosed
        fun getChannel(
            params: GuideGetChannelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GuideGetChannelResponse>

        /**
         * Returns a raw HTTP response for `put
         * /v1/users/{user_id}/guides/messages/{message_id}/archived`, but is otherwise the same as
         * [GuideService.markMessageAsArchived].
         */
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
