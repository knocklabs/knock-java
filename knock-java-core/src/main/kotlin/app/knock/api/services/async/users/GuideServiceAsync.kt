// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async.users

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
import java.util.concurrent.CompletableFuture

interface GuideServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

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
        params: GuideMarkMessageAsArchivedParams,
    ): CompletableFuture<GuideActionResponse> =
        markMessageAsArchived(userId, params, RequestOptions.none())

    /** @see [markMessageAsArchived] */
    fun markMessageAsArchived(
        userId: String,
        params: GuideMarkMessageAsArchivedParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<GuideActionResponse> =
        markMessageAsArchived(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see [markMessageAsArchived] */
    fun markMessageAsArchived(
        params: GuideMarkMessageAsArchivedParams
    ): CompletableFuture<GuideActionResponse> = markMessageAsArchived(params, RequestOptions.none())

    /** @see [markMessageAsArchived] */
    fun markMessageAsArchived(
        params: GuideMarkMessageAsArchivedParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<GuideActionResponse>

    /**
     * Records that a user has interacted with a guide, triggering any associated interacted events.
     */
    fun markMessageAsInteracted(
        userId: String,
        params: GuideMarkMessageAsInteractedParams,
    ): CompletableFuture<GuideActionResponse> =
        markMessageAsInteracted(userId, params, RequestOptions.none())

    /** @see [markMessageAsInteracted] */
    fun markMessageAsInteracted(
        userId: String,
        params: GuideMarkMessageAsInteractedParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<GuideActionResponse> =
        markMessageAsInteracted(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see [markMessageAsInteracted] */
    fun markMessageAsInteracted(
        params: GuideMarkMessageAsInteractedParams
    ): CompletableFuture<GuideActionResponse> =
        markMessageAsInteracted(params, RequestOptions.none())

    /** @see [markMessageAsInteracted] */
    fun markMessageAsInteracted(
        params: GuideMarkMessageAsInteractedParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<GuideActionResponse>

    /** Records that a guide has been seen by a user, triggering any associated seen events. */
    fun markMessageAsSeen(
        userId: String,
        params: GuideMarkMessageAsSeenParams,
    ): CompletableFuture<GuideActionResponse> =
        markMessageAsSeen(userId, params, RequestOptions.none())

    /** @see [markMessageAsSeen] */
    fun markMessageAsSeen(
        userId: String,
        params: GuideMarkMessageAsSeenParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<GuideActionResponse> =
        markMessageAsSeen(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see [markMessageAsSeen] */
    fun markMessageAsSeen(
        params: GuideMarkMessageAsSeenParams
    ): CompletableFuture<GuideActionResponse> = markMessageAsSeen(params, RequestOptions.none())

    /** @see [markMessageAsSeen] */
    fun markMessageAsSeen(
        params: GuideMarkMessageAsSeenParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<GuideActionResponse>

    /**
     * Resets the engagement state of a guide for a user, removing the guide's engagement log entry
     * so the next interaction creates a fresh engagement.
     */
    fun resetGuideEngagements(
        userId: String,
        params: GuideResetGuideEngagementsParams,
    ): CompletableFuture<GuideActionResponse> =
        resetGuideEngagements(userId, params, RequestOptions.none())

    /** @see [resetGuideEngagements] */
    fun resetGuideEngagements(
        userId: String,
        params: GuideResetGuideEngagementsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<GuideActionResponse> =
        resetGuideEngagements(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see [resetGuideEngagements] */
    fun resetGuideEngagements(
        params: GuideResetGuideEngagementsParams
    ): CompletableFuture<GuideActionResponse> = resetGuideEngagements(params, RequestOptions.none())

    /** @see [resetGuideEngagements] */
    fun resetGuideEngagements(
        params: GuideResetGuideEngagementsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<GuideActionResponse>

    /** Records that a guide has been unarchived, triggering any associated unarchived events. */
    fun unarchiveGuideMessage(
        userId: String,
        params: GuideUnarchiveGuideMessageParams,
    ): CompletableFuture<GuideActionResponse> =
        unarchiveGuideMessage(userId, params, RequestOptions.none())

    /** @see [unarchiveGuideMessage] */
    fun unarchiveGuideMessage(
        userId: String,
        params: GuideUnarchiveGuideMessageParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<GuideActionResponse> =
        unarchiveGuideMessage(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see [unarchiveGuideMessage] */
    fun unarchiveGuideMessage(
        params: GuideUnarchiveGuideMessageParams
    ): CompletableFuture<GuideActionResponse> = unarchiveGuideMessage(params, RequestOptions.none())

    /** @see [unarchiveGuideMessage] */
    fun unarchiveGuideMessage(
        params: GuideUnarchiveGuideMessageParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<GuideActionResponse>

    /** A view of [GuideServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /v1/users/{user_id}/guides/{channel_id}`, but is
         * otherwise the same as [GuideServiceAsync.getChannel].
         */
        @MustBeClosed
        fun getChannel(
            userId: String,
            channelId: String,
        ): CompletableFuture<HttpResponseFor<GuideGetChannelResponse>> =
            getChannel(userId, channelId, GuideGetChannelParams.none())

        /** @see [getChannel] */
        @MustBeClosed
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
        @MustBeClosed
        fun getChannel(
            userId: String,
            channelId: String,
            params: GuideGetChannelParams = GuideGetChannelParams.none(),
        ): CompletableFuture<HttpResponseFor<GuideGetChannelResponse>> =
            getChannel(userId, channelId, params, RequestOptions.none())

        /** @see [getChannel] */
        @MustBeClosed
        fun getChannel(
            params: GuideGetChannelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<GuideGetChannelResponse>>

        /** @see [getChannel] */
        @MustBeClosed
        fun getChannel(
            params: GuideGetChannelParams
        ): CompletableFuture<HttpResponseFor<GuideGetChannelResponse>> =
            getChannel(params, RequestOptions.none())

        /** @see [getChannel] */
        @MustBeClosed
        fun getChannel(
            userId: String,
            channelId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<GuideGetChannelResponse>> =
            getChannel(userId, channelId, GuideGetChannelParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put /v1/users/{user_id}/guides/messages/archived`, but
         * is otherwise the same as [GuideServiceAsync.markMessageAsArchived].
         */
        @MustBeClosed
        fun markMessageAsArchived(
            userId: String,
            params: GuideMarkMessageAsArchivedParams,
        ): CompletableFuture<HttpResponseFor<GuideActionResponse>> =
            markMessageAsArchived(userId, params, RequestOptions.none())

        /** @see [markMessageAsArchived] */
        @MustBeClosed
        fun markMessageAsArchived(
            userId: String,
            params: GuideMarkMessageAsArchivedParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<GuideActionResponse>> =
            markMessageAsArchived(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see [markMessageAsArchived] */
        @MustBeClosed
        fun markMessageAsArchived(
            params: GuideMarkMessageAsArchivedParams
        ): CompletableFuture<HttpResponseFor<GuideActionResponse>> =
            markMessageAsArchived(params, RequestOptions.none())

        /** @see [markMessageAsArchived] */
        @MustBeClosed
        fun markMessageAsArchived(
            params: GuideMarkMessageAsArchivedParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<GuideActionResponse>>

        /**
         * Returns a raw HTTP response for `put /v1/users/{user_id}/guides/messages/interacted`, but
         * is otherwise the same as [GuideServiceAsync.markMessageAsInteracted].
         */
        @MustBeClosed
        fun markMessageAsInteracted(
            userId: String,
            params: GuideMarkMessageAsInteractedParams,
        ): CompletableFuture<HttpResponseFor<GuideActionResponse>> =
            markMessageAsInteracted(userId, params, RequestOptions.none())

        /** @see [markMessageAsInteracted] */
        @MustBeClosed
        fun markMessageAsInteracted(
            userId: String,
            params: GuideMarkMessageAsInteractedParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<GuideActionResponse>> =
            markMessageAsInteracted(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see [markMessageAsInteracted] */
        @MustBeClosed
        fun markMessageAsInteracted(
            params: GuideMarkMessageAsInteractedParams
        ): CompletableFuture<HttpResponseFor<GuideActionResponse>> =
            markMessageAsInteracted(params, RequestOptions.none())

        /** @see [markMessageAsInteracted] */
        @MustBeClosed
        fun markMessageAsInteracted(
            params: GuideMarkMessageAsInteractedParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<GuideActionResponse>>

        /**
         * Returns a raw HTTP response for `put /v1/users/{user_id}/guides/messages/seen`, but is
         * otherwise the same as [GuideServiceAsync.markMessageAsSeen].
         */
        @MustBeClosed
        fun markMessageAsSeen(
            userId: String,
            params: GuideMarkMessageAsSeenParams,
        ): CompletableFuture<HttpResponseFor<GuideActionResponse>> =
            markMessageAsSeen(userId, params, RequestOptions.none())

        /** @see [markMessageAsSeen] */
        @MustBeClosed
        fun markMessageAsSeen(
            userId: String,
            params: GuideMarkMessageAsSeenParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<GuideActionResponse>> =
            markMessageAsSeen(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see [markMessageAsSeen] */
        @MustBeClosed
        fun markMessageAsSeen(
            params: GuideMarkMessageAsSeenParams
        ): CompletableFuture<HttpResponseFor<GuideActionResponse>> =
            markMessageAsSeen(params, RequestOptions.none())

        /** @see [markMessageAsSeen] */
        @MustBeClosed
        fun markMessageAsSeen(
            params: GuideMarkMessageAsSeenParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<GuideActionResponse>>

        /**
         * Returns a raw HTTP response for `put /v1/users/{user_id}/guides/engagements/reset`, but
         * is otherwise the same as [GuideServiceAsync.resetGuideEngagements].
         */
        @MustBeClosed
        fun resetGuideEngagements(
            userId: String,
            params: GuideResetGuideEngagementsParams,
        ): CompletableFuture<HttpResponseFor<GuideActionResponse>> =
            resetGuideEngagements(userId, params, RequestOptions.none())

        /** @see [resetGuideEngagements] */
        @MustBeClosed
        fun resetGuideEngagements(
            userId: String,
            params: GuideResetGuideEngagementsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<GuideActionResponse>> =
            resetGuideEngagements(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see [resetGuideEngagements] */
        @MustBeClosed
        fun resetGuideEngagements(
            params: GuideResetGuideEngagementsParams
        ): CompletableFuture<HttpResponseFor<GuideActionResponse>> =
            resetGuideEngagements(params, RequestOptions.none())

        /** @see [resetGuideEngagements] */
        @MustBeClosed
        fun resetGuideEngagements(
            params: GuideResetGuideEngagementsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<GuideActionResponse>>

        /**
         * Returns a raw HTTP response for `delete /v1/users/{user_id}/guides/messages/archived`,
         * but is otherwise the same as [GuideServiceAsync.unarchiveGuideMessage].
         */
        @MustBeClosed
        fun unarchiveGuideMessage(
            userId: String,
            params: GuideUnarchiveGuideMessageParams,
        ): CompletableFuture<HttpResponseFor<GuideActionResponse>> =
            unarchiveGuideMessage(userId, params, RequestOptions.none())

        /** @see [unarchiveGuideMessage] */
        @MustBeClosed
        fun unarchiveGuideMessage(
            userId: String,
            params: GuideUnarchiveGuideMessageParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<GuideActionResponse>> =
            unarchiveGuideMessage(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see [unarchiveGuideMessage] */
        @MustBeClosed
        fun unarchiveGuideMessage(
            params: GuideUnarchiveGuideMessageParams
        ): CompletableFuture<HttpResponseFor<GuideActionResponse>> =
            unarchiveGuideMessage(params, RequestOptions.none())

        /** @see [unarchiveGuideMessage] */
        @MustBeClosed
        fun unarchiveGuideMessage(
            params: GuideUnarchiveGuideMessageParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<GuideActionResponse>>
    }
}
