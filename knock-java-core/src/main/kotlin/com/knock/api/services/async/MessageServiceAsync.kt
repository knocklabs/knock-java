// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.knock.api.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.knock.api.core.RequestOptions
import com.knock.api.core.http.HttpResponseFor
import com.knock.api.models.Message
import com.knock.api.models.MessageArchiveParams
import com.knock.api.models.MessageGetContentParams
import com.knock.api.models.MessageGetContentResponse
import com.knock.api.models.MessageGetParams
import com.knock.api.models.MessageListActivitiesPageAsync
import com.knock.api.models.MessageListActivitiesParams
import com.knock.api.models.MessageListDeliveryLogsPageAsync
import com.knock.api.models.MessageListDeliveryLogsParams
import com.knock.api.models.MessageListEventsPageAsync
import com.knock.api.models.MessageListEventsParams
import com.knock.api.models.MessageListPageAsync
import com.knock.api.models.MessageListParams
import com.knock.api.models.MessageMarkAsInteractedParams
import com.knock.api.models.MessageMarkAsReadParams
import com.knock.api.models.MessageMarkAsSeenParams
import com.knock.api.models.MessageMarkAsUnreadParams
import com.knock.api.models.MessageMarkAsUnseenParams
import com.knock.api.models.MessageUnarchiveParams
import com.knock.api.services.async.messages.BatchServiceAsync
import java.util.concurrent.CompletableFuture

interface MessageServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun batch(): BatchServiceAsync

    /** List messages */
    @JvmOverloads
    fun list(
        params: MessageListParams = MessageListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageListPageAsync>

    /** List messages */
    fun list(requestOptions: RequestOptions): CompletableFuture<MessageListPageAsync> =
        list(MessageListParams.none(), requestOptions)

    /** Archive message */
    @JvmOverloads
    fun archive(
        params: MessageArchiveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message>

    /** Get message */
    @JvmOverloads
    fun get(
        params: MessageGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message>

    /**
     * Returns the fully rendered contents of a message, where the response depends on the channel
     * the message was sent on.
     */
    @JvmOverloads
    fun getContent(
        params: MessageGetContentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageGetContentResponse>

    /** List activities */
    @JvmOverloads
    fun listActivities(
        params: MessageListActivitiesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageListActivitiesPageAsync>

    /** List delivery logs */
    @JvmOverloads
    fun listDeliveryLogs(
        params: MessageListDeliveryLogsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageListDeliveryLogsPageAsync>

    /** List events */
    @JvmOverloads
    fun listEvents(
        params: MessageListEventsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageListEventsPageAsync>

    /** Mark message as interacted */
    @JvmOverloads
    fun markAsInteracted(
        params: MessageMarkAsInteractedParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message>

    /** Mark message as read */
    @JvmOverloads
    fun markAsRead(
        params: MessageMarkAsReadParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message>

    /** Mark message as seen */
    @JvmOverloads
    fun markAsSeen(
        params: MessageMarkAsSeenParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message>

    /** Mark message as unread */
    @JvmOverloads
    fun markAsUnread(
        params: MessageMarkAsUnreadParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message>

    /** Mark message as unseen */
    @JvmOverloads
    fun markAsUnseen(
        params: MessageMarkAsUnseenParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message>

    /** Unarchive message */
    @JvmOverloads
    fun unarchive(
        params: MessageUnarchiveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message>

    /**
     * A view of [MessageServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        fun batch(): BatchServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/messages`, but is otherwise the same as
         * [MessageServiceAsync.list].
         */
        @JvmOverloads
        @MustBeClosed
        fun list(
            params: MessageListParams = MessageListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageListPageAsync>>

        /**
         * Returns a raw HTTP response for `get /v1/messages`, but is otherwise the same as
         * [MessageServiceAsync.list].
         */
        @MustBeClosed
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<MessageListPageAsync>> =
            list(MessageListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put /v1/messages/{message_id}/archived`, but is
         * otherwise the same as [MessageServiceAsync.archive].
         */
        @JvmOverloads
        @MustBeClosed
        fun archive(
            params: MessageArchiveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>>

        /**
         * Returns a raw HTTP response for `get /v1/messages/{message_id}`, but is otherwise the
         * same as [MessageServiceAsync.get].
         */
        @JvmOverloads
        @MustBeClosed
        fun get(
            params: MessageGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>>

        /**
         * Returns a raw HTTP response for `get /v1/messages/{message_id}/content`, but is otherwise
         * the same as [MessageServiceAsync.getContent].
         */
        @JvmOverloads
        @MustBeClosed
        fun getContent(
            params: MessageGetContentParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageGetContentResponse>>

        /**
         * Returns a raw HTTP response for `get /v1/messages/{message_id}/activities`, but is
         * otherwise the same as [MessageServiceAsync.listActivities].
         */
        @JvmOverloads
        @MustBeClosed
        fun listActivities(
            params: MessageListActivitiesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageListActivitiesPageAsync>>

        /**
         * Returns a raw HTTP response for `get /v1/messages/{message_id}/delivery_logs`, but is
         * otherwise the same as [MessageServiceAsync.listDeliveryLogs].
         */
        @JvmOverloads
        @MustBeClosed
        fun listDeliveryLogs(
            params: MessageListDeliveryLogsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageListDeliveryLogsPageAsync>>

        /**
         * Returns a raw HTTP response for `get /v1/messages/{message_id}/events`, but is otherwise
         * the same as [MessageServiceAsync.listEvents].
         */
        @JvmOverloads
        @MustBeClosed
        fun listEvents(
            params: MessageListEventsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageListEventsPageAsync>>

        /**
         * Returns a raw HTTP response for `put /v1/messages/{message_id}/interacted`, but is
         * otherwise the same as [MessageServiceAsync.markAsInteracted].
         */
        @JvmOverloads
        @MustBeClosed
        fun markAsInteracted(
            params: MessageMarkAsInteractedParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>>

        /**
         * Returns a raw HTTP response for `put /v1/messages/{message_id}/read`, but is otherwise
         * the same as [MessageServiceAsync.markAsRead].
         */
        @JvmOverloads
        @MustBeClosed
        fun markAsRead(
            params: MessageMarkAsReadParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>>

        /**
         * Returns a raw HTTP response for `put /v1/messages/{message_id}/seen`, but is otherwise
         * the same as [MessageServiceAsync.markAsSeen].
         */
        @JvmOverloads
        @MustBeClosed
        fun markAsSeen(
            params: MessageMarkAsSeenParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>>

        /**
         * Returns a raw HTTP response for `delete /v1/messages/{message_id}/unread`, but is
         * otherwise the same as [MessageServiceAsync.markAsUnread].
         */
        @JvmOverloads
        @MustBeClosed
        fun markAsUnread(
            params: MessageMarkAsUnreadParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>>

        /**
         * Returns a raw HTTP response for `delete /v1/messages/{message_id}/unseen`, but is
         * otherwise the same as [MessageServiceAsync.markAsUnseen].
         */
        @JvmOverloads
        @MustBeClosed
        fun markAsUnseen(
            params: MessageMarkAsUnseenParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>>

        /**
         * Returns a raw HTTP response for `delete /v1/messages/{message_id}/unarchived`, but is
         * otherwise the same as [MessageServiceAsync.unarchive].
         */
        @JvmOverloads
        @MustBeClosed
        fun unarchive(
            params: MessageUnarchiveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>>
    }
}
