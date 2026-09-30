// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking.users

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.users.guides.GuideActionResponse
import app.knock.api.models.users.guides.GuideGetChannelParams
import app.knock.api.models.users.guides.GuideGetChannelResponse
import app.knock.api.models.users.guides.GuideMarkMessageAsArchivedParams
import app.knock.api.models.users.guides.GuideMarkMessageAsInteractedParams
import app.knock.api.models.users.guides.GuideMarkMessageAsSeenParams
import app.knock.api.models.users.guides.GuideResetGuideEngagementsParams
import app.knock.api.models.users.guides.GuideUnarchiveGuideMessageParams
import com.google.errorprone.annotations.MustBeClosed

interface GuideService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

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
        params: GuideMarkMessageAsArchivedParams,
    ): GuideActionResponse = markMessageAsArchived(userId, params, RequestOptions.none())

    /** @see [markMessageAsArchived] */
    fun markMessageAsArchived(
        userId: String,
        params: GuideMarkMessageAsArchivedParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GuideActionResponse =
        markMessageAsArchived(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see [markMessageAsArchived] */
    fun markMessageAsArchived(params: GuideMarkMessageAsArchivedParams): GuideActionResponse =
        markMessageAsArchived(params, RequestOptions.none())

    /** @see [markMessageAsArchived] */
    fun markMessageAsArchived(
        params: GuideMarkMessageAsArchivedParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GuideActionResponse

    /**
     * Records that a user has interacted with a guide, triggering any associated interacted events.
     */
    fun markMessageAsInteracted(
        userId: String,
        params: GuideMarkMessageAsInteractedParams,
    ): GuideActionResponse = markMessageAsInteracted(userId, params, RequestOptions.none())

    /** @see [markMessageAsInteracted] */
    fun markMessageAsInteracted(
        userId: String,
        params: GuideMarkMessageAsInteractedParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GuideActionResponse =
        markMessageAsInteracted(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see [markMessageAsInteracted] */
    fun markMessageAsInteracted(params: GuideMarkMessageAsInteractedParams): GuideActionResponse =
        markMessageAsInteracted(params, RequestOptions.none())

    /** @see [markMessageAsInteracted] */
    fun markMessageAsInteracted(
        params: GuideMarkMessageAsInteractedParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GuideActionResponse

    /** Records that a guide has been seen by a user, triggering any associated seen events. */
    fun markMessageAsSeen(
        userId: String,
        params: GuideMarkMessageAsSeenParams,
    ): GuideActionResponse = markMessageAsSeen(userId, params, RequestOptions.none())

    /** @see [markMessageAsSeen] */
    fun markMessageAsSeen(
        userId: String,
        params: GuideMarkMessageAsSeenParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GuideActionResponse =
        markMessageAsSeen(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see [markMessageAsSeen] */
    fun markMessageAsSeen(params: GuideMarkMessageAsSeenParams): GuideActionResponse =
        markMessageAsSeen(params, RequestOptions.none())

    /** @see [markMessageAsSeen] */
    fun markMessageAsSeen(
        params: GuideMarkMessageAsSeenParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GuideActionResponse

    /**
     * Resets the engagement state of a guide for a user, removing the guide's engagement log entry
     * so the next interaction creates a fresh engagement.
     */
    fun resetGuideEngagements(
        userId: String,
        params: GuideResetGuideEngagementsParams,
    ): GuideActionResponse = resetGuideEngagements(userId, params, RequestOptions.none())

    /** @see [resetGuideEngagements] */
    fun resetGuideEngagements(
        userId: String,
        params: GuideResetGuideEngagementsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GuideActionResponse =
        resetGuideEngagements(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see [resetGuideEngagements] */
    fun resetGuideEngagements(params: GuideResetGuideEngagementsParams): GuideActionResponse =
        resetGuideEngagements(params, RequestOptions.none())

    /** @see [resetGuideEngagements] */
    fun resetGuideEngagements(
        params: GuideResetGuideEngagementsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GuideActionResponse

    /** Records that a guide has been unarchived, triggering any associated unarchived events. */
    fun unarchiveGuideMessage(
        userId: String,
        params: GuideUnarchiveGuideMessageParams,
    ): GuideActionResponse = unarchiveGuideMessage(userId, params, RequestOptions.none())

    /** @see [unarchiveGuideMessage] */
    fun unarchiveGuideMessage(
        userId: String,
        params: GuideUnarchiveGuideMessageParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GuideActionResponse =
        unarchiveGuideMessage(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see [unarchiveGuideMessage] */
    fun unarchiveGuideMessage(params: GuideUnarchiveGuideMessageParams): GuideActionResponse =
        unarchiveGuideMessage(params, RequestOptions.none())

    /** @see [unarchiveGuideMessage] */
    fun unarchiveGuideMessage(
        params: GuideUnarchiveGuideMessageParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GuideActionResponse

    /** A view of [GuideService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

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
         * Returns a raw HTTP response for `put /v1/users/{user_id}/guides/messages/archived`, but
         * is otherwise the same as [GuideService.markMessageAsArchived].
         */
        @MustBeClosed
        fun markMessageAsArchived(
            userId: String,
            params: GuideMarkMessageAsArchivedParams,
        ): HttpResponseFor<GuideActionResponse> =
            markMessageAsArchived(userId, params, RequestOptions.none())

        /** @see [markMessageAsArchived] */
        @MustBeClosed
        fun markMessageAsArchived(
            userId: String,
            params: GuideMarkMessageAsArchivedParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GuideActionResponse> =
            markMessageAsArchived(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see [markMessageAsArchived] */
        @MustBeClosed
        fun markMessageAsArchived(
            params: GuideMarkMessageAsArchivedParams
        ): HttpResponseFor<GuideActionResponse> =
            markMessageAsArchived(params, RequestOptions.none())

        /** @see [markMessageAsArchived] */
        @MustBeClosed
        fun markMessageAsArchived(
            params: GuideMarkMessageAsArchivedParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GuideActionResponse>

        /**
         * Returns a raw HTTP response for `put /v1/users/{user_id}/guides/messages/interacted`, but
         * is otherwise the same as [GuideService.markMessageAsInteracted].
         */
        @MustBeClosed
        fun markMessageAsInteracted(
            userId: String,
            params: GuideMarkMessageAsInteractedParams,
        ): HttpResponseFor<GuideActionResponse> =
            markMessageAsInteracted(userId, params, RequestOptions.none())

        /** @see [markMessageAsInteracted] */
        @MustBeClosed
        fun markMessageAsInteracted(
            userId: String,
            params: GuideMarkMessageAsInteractedParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GuideActionResponse> =
            markMessageAsInteracted(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see [markMessageAsInteracted] */
        @MustBeClosed
        fun markMessageAsInteracted(
            params: GuideMarkMessageAsInteractedParams
        ): HttpResponseFor<GuideActionResponse> =
            markMessageAsInteracted(params, RequestOptions.none())

        /** @see [markMessageAsInteracted] */
        @MustBeClosed
        fun markMessageAsInteracted(
            params: GuideMarkMessageAsInteractedParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GuideActionResponse>

        /**
         * Returns a raw HTTP response for `put /v1/users/{user_id}/guides/messages/seen`, but is
         * otherwise the same as [GuideService.markMessageAsSeen].
         */
        @MustBeClosed
        fun markMessageAsSeen(
            userId: String,
            params: GuideMarkMessageAsSeenParams,
        ): HttpResponseFor<GuideActionResponse> =
            markMessageAsSeen(userId, params, RequestOptions.none())

        /** @see [markMessageAsSeen] */
        @MustBeClosed
        fun markMessageAsSeen(
            userId: String,
            params: GuideMarkMessageAsSeenParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GuideActionResponse> =
            markMessageAsSeen(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see [markMessageAsSeen] */
        @MustBeClosed
        fun markMessageAsSeen(
            params: GuideMarkMessageAsSeenParams
        ): HttpResponseFor<GuideActionResponse> = markMessageAsSeen(params, RequestOptions.none())

        /** @see [markMessageAsSeen] */
        @MustBeClosed
        fun markMessageAsSeen(
            params: GuideMarkMessageAsSeenParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GuideActionResponse>

        /**
         * Returns a raw HTTP response for `put /v1/users/{user_id}/guides/engagements/reset`, but
         * is otherwise the same as [GuideService.resetGuideEngagements].
         */
        @MustBeClosed
        fun resetGuideEngagements(
            userId: String,
            params: GuideResetGuideEngagementsParams,
        ): HttpResponseFor<GuideActionResponse> =
            resetGuideEngagements(userId, params, RequestOptions.none())

        /** @see [resetGuideEngagements] */
        @MustBeClosed
        fun resetGuideEngagements(
            userId: String,
            params: GuideResetGuideEngagementsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GuideActionResponse> =
            resetGuideEngagements(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see [resetGuideEngagements] */
        @MustBeClosed
        fun resetGuideEngagements(
            params: GuideResetGuideEngagementsParams
        ): HttpResponseFor<GuideActionResponse> =
            resetGuideEngagements(params, RequestOptions.none())

        /** @see [resetGuideEngagements] */
        @MustBeClosed
        fun resetGuideEngagements(
            params: GuideResetGuideEngagementsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GuideActionResponse>

        /**
         * Returns a raw HTTP response for `delete /v1/users/{user_id}/guides/messages/archived`,
         * but is otherwise the same as [GuideService.unarchiveGuideMessage].
         */
        @MustBeClosed
        fun unarchiveGuideMessage(
            userId: String,
            params: GuideUnarchiveGuideMessageParams,
        ): HttpResponseFor<GuideActionResponse> =
            unarchiveGuideMessage(userId, params, RequestOptions.none())

        /** @see [unarchiveGuideMessage] */
        @MustBeClosed
        fun unarchiveGuideMessage(
            userId: String,
            params: GuideUnarchiveGuideMessageParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GuideActionResponse> =
            unarchiveGuideMessage(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see [unarchiveGuideMessage] */
        @MustBeClosed
        fun unarchiveGuideMessage(
            params: GuideUnarchiveGuideMessageParams
        ): HttpResponseFor<GuideActionResponse> =
            unarchiveGuideMessage(params, RequestOptions.none())

        /** @see [unarchiveGuideMessage] */
        @MustBeClosed
        fun unarchiveGuideMessage(
            params: GuideUnarchiveGuideMessageParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GuideActionResponse>
    }
}
