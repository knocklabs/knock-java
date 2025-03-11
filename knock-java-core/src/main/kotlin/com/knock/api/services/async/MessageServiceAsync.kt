// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.knock.api.core.RequestOptions
import com.knock.api.core.http.HttpResponseFor
import com.knock.api.models.messages.Message
import com.knock.api.models.messages.MessageArchiveParams
import com.knock.api.models.messages.MessageGetContentParams
import com.knock.api.models.messages.MessageGetContentResponse
import com.knock.api.models.messages.MessageGetParams
import com.knock.api.models.messages.MessageListActivitiesPageAsync
import com.knock.api.models.messages.MessageListActivitiesParams
import com.knock.api.models.messages.MessageListDeliveryLogsPageAsync
import com.knock.api.models.messages.MessageListDeliveryLogsParams
import com.knock.api.models.messages.MessageListEventsPageAsync
import com.knock.api.models.messages.MessageListEventsParams
import com.knock.api.models.messages.MessageListPageAsync
import com.knock.api.models.messages.MessageListParams
import com.knock.api.models.messages.MessageMarkAsInteractedParams
import com.knock.api.models.messages.MessageMarkAsReadParams
import com.knock.api.models.messages.MessageMarkAsSeenParams
import com.knock.api.models.messages.MessageMarkAsUnreadParams
import com.knock.api.models.messages.MessageMarkAsUnseenParams
import com.knock.api.models.messages.MessageUnarchiveParams
import com.knock.api.services.async.messages.BatchServiceAsync
import java.util.concurrent.CompletableFuture

interface MessageServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for
     * each method.
     */
    fun withRawResponse(): WithRawResponse

    fun batch(): BatchServiceAsync

    /** List messages */
    fun list(): CompletableFuture<MessageListPageAsync> = list(MessageListParams.none())

    /** @see [list] */
    fun list(params: MessageListParams = MessageListParams.none(), requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<MessageListPageAsync>

    /** @see [list] */
    fun list(params: MessageListParams = MessageListParams.none()): CompletableFuture<MessageListPageAsync> =
        list(
          params, RequestOptions.none()
        )

    /** @see [list] */
    fun list(requestOptions: RequestOptions): CompletableFuture<MessageListPageAsync> = list(MessageListParams.none(), requestOptions)

    /** Archive message */
    fun archive(params: MessageArchiveParams): CompletableFuture<Message> =
        archive(
          params, RequestOptions.none()
        )

    /** @see [archive] */
    fun archive(params: MessageArchiveParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<Message>

    /** Get message */
    fun get(params: MessageGetParams): CompletableFuture<Message> =
        get(
          params, RequestOptions.none()
        )

    /** @see [get] */
    fun get(params: MessageGetParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<Message>

    /**
     * Returns the fully rendered contents of a message, where the response depends on
     * the channel the message was sent on.
     */
    fun getContent(params: MessageGetContentParams): CompletableFuture<MessageGetContentResponse> =
        getContent(
          params, RequestOptions.none()
        )

    /** @see [getContent] */
    fun getContent(params: MessageGetContentParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<MessageGetContentResponse>

    /** List activities */
    fun listActivities(params: MessageListActivitiesParams): CompletableFuture<MessageListActivitiesPageAsync> =
        listActivities(
          params, RequestOptions.none()
        )

    /** @see [listActivities] */
    fun listActivities(params: MessageListActivitiesParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<MessageListActivitiesPageAsync>

    /** List delivery logs */
    fun listDeliveryLogs(params: MessageListDeliveryLogsParams): CompletableFuture<MessageListDeliveryLogsPageAsync> =
        listDeliveryLogs(
          params, RequestOptions.none()
        )

    /** @see [listDeliveryLogs] */
    fun listDeliveryLogs(params: MessageListDeliveryLogsParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<MessageListDeliveryLogsPageAsync>

    /** List events */
    fun listEvents(params: MessageListEventsParams): CompletableFuture<MessageListEventsPageAsync> =
        listEvents(
          params, RequestOptions.none()
        )

    /** @see [listEvents] */
    fun listEvents(params: MessageListEventsParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<MessageListEventsPageAsync>

    /** Mark message as interacted */
    fun markAsInteracted(params: MessageMarkAsInteractedParams): CompletableFuture<Message> =
        markAsInteracted(
          params, RequestOptions.none()
        )

    /** @see [markAsInteracted] */
    fun markAsInteracted(params: MessageMarkAsInteractedParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<Message>

    /** Mark message as read */
    fun markAsRead(params: MessageMarkAsReadParams): CompletableFuture<Message> =
        markAsRead(
          params, RequestOptions.none()
        )

    /** @see [markAsRead] */
    fun markAsRead(params: MessageMarkAsReadParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<Message>

    /** Mark message as seen */
    fun markAsSeen(params: MessageMarkAsSeenParams): CompletableFuture<Message> =
        markAsSeen(
          params, RequestOptions.none()
        )

    /** @see [markAsSeen] */
    fun markAsSeen(params: MessageMarkAsSeenParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<Message>

    /** Mark message as unread */
    fun markAsUnread(params: MessageMarkAsUnreadParams): CompletableFuture<Message> =
        markAsUnread(
          params, RequestOptions.none()
        )

    /** @see [markAsUnread] */
    fun markAsUnread(params: MessageMarkAsUnreadParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<Message>

    /** Mark message as unseen */
    fun markAsUnseen(params: MessageMarkAsUnseenParams): CompletableFuture<Message> =
        markAsUnseen(
          params, RequestOptions.none()
        )

    /** @see [markAsUnseen] */
    fun markAsUnseen(params: MessageMarkAsUnseenParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<Message>

    /** Unarchive message */
    fun unarchive(params: MessageUnarchiveParams): CompletableFuture<Message> =
        unarchive(
          params, RequestOptions.none()
        )

    /** @see [unarchive] */
    fun unarchive(params: MessageUnarchiveParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<Message>

    /**
     * A view of [MessageServiceAsync] that provides access to raw HTTP responses for
     * each method.
     */
    interface WithRawResponse {

        fun batch(): BatchServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/messages`, but is otherwise the same as
         * [MessageServiceAsync.list].
         */
        @MustBeClosed
        fun list(): CompletableFuture<HttpResponseFor<MessageListPageAsync>> = list(MessageListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(params: MessageListParams = MessageListParams.none(), requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<HttpResponseFor<MessageListPageAsync>>

        /** @see [list] */
        @MustBeClosed
        fun list(params: MessageListParams = MessageListParams.none()): CompletableFuture<HttpResponseFor<MessageListPageAsync>> =
            list(
              params, RequestOptions.none()
            )

        /** @see [list] */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<MessageListPageAsync>> = list(MessageListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put /v1/messages/{message_id}/archived`, but is
         * otherwise the same as [MessageServiceAsync.archive].
         */
        @MustBeClosed
        fun archive(params: MessageArchiveParams): CompletableFuture<HttpResponseFor<Message>> =
            archive(
              params, RequestOptions.none()
            )

        /** @see [archive] */
        @MustBeClosed
        fun archive(params: MessageArchiveParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<HttpResponseFor<Message>>

        /**
         * Returns a raw HTTP response for `get /v1/messages/{message_id}`, but is
         * otherwise the same as [MessageServiceAsync.get].
         */
        @MustBeClosed
        fun get(params: MessageGetParams): CompletableFuture<HttpResponseFor<Message>> =
            get(
              params, RequestOptions.none()
            )

        /** @see [get] */
        @MustBeClosed
        fun get(params: MessageGetParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<HttpResponseFor<Message>>

        /**
         * Returns a raw HTTP response for `get /v1/messages/{message_id}/content`, but is
         * otherwise the same as [MessageServiceAsync.getContent].
         */
        @MustBeClosed
        fun getContent(params: MessageGetContentParams): CompletableFuture<HttpResponseFor<MessageGetContentResponse>> =
            getContent(
              params, RequestOptions.none()
            )

        /** @see [getContent] */
        @MustBeClosed
        fun getContent(params: MessageGetContentParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<HttpResponseFor<MessageGetContentResponse>>

        /**
         * Returns a raw HTTP response for `get /v1/messages/{message_id}/activities`, but
         * is otherwise the same as [MessageServiceAsync.listActivities].
         */
        @MustBeClosed
        fun listActivities(params: MessageListActivitiesParams): CompletableFuture<HttpResponseFor<MessageListActivitiesPageAsync>> =
            listActivities(
              params, RequestOptions.none()
            )

        /** @see [listActivities] */
        @MustBeClosed
        fun listActivities(params: MessageListActivitiesParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<HttpResponseFor<MessageListActivitiesPageAsync>>

        /**
         * Returns a raw HTTP response for `get /v1/messages/{message_id}/delivery_logs`,
         * but is otherwise the same as [MessageServiceAsync.listDeliveryLogs].
         */
        @MustBeClosed
        fun listDeliveryLogs(params: MessageListDeliveryLogsParams): CompletableFuture<HttpResponseFor<MessageListDeliveryLogsPageAsync>> =
            listDeliveryLogs(
              params, RequestOptions.none()
            )

        /** @see [listDeliveryLogs] */
        @MustBeClosed
        fun listDeliveryLogs(params: MessageListDeliveryLogsParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<HttpResponseFor<MessageListDeliveryLogsPageAsync>>

        /**
         * Returns a raw HTTP response for `get /v1/messages/{message_id}/events`, but is
         * otherwise the same as [MessageServiceAsync.listEvents].
         */
        @MustBeClosed
        fun listEvents(params: MessageListEventsParams): CompletableFuture<HttpResponseFor<MessageListEventsPageAsync>> =
            listEvents(
              params, RequestOptions.none()
            )

        /** @see [listEvents] */
        @MustBeClosed
        fun listEvents(params: MessageListEventsParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<HttpResponseFor<MessageListEventsPageAsync>>

        /**
         * Returns a raw HTTP response for `put /v1/messages/{message_id}/interacted`, but
         * is otherwise the same as [MessageServiceAsync.markAsInteracted].
         */
        @MustBeClosed
        fun markAsInteracted(params: MessageMarkAsInteractedParams): CompletableFuture<HttpResponseFor<Message>> =
            markAsInteracted(
              params, RequestOptions.none()
            )

        /** @see [markAsInteracted] */
        @MustBeClosed
        fun markAsInteracted(params: MessageMarkAsInteractedParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<HttpResponseFor<Message>>

        /**
         * Returns a raw HTTP response for `put /v1/messages/{message_id}/read`, but is
         * otherwise the same as [MessageServiceAsync.markAsRead].
         */
        @MustBeClosed
        fun markAsRead(params: MessageMarkAsReadParams): CompletableFuture<HttpResponseFor<Message>> =
            markAsRead(
              params, RequestOptions.none()
            )

        /** @see [markAsRead] */
        @MustBeClosed
        fun markAsRead(params: MessageMarkAsReadParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<HttpResponseFor<Message>>

        /**
         * Returns a raw HTTP response for `put /v1/messages/{message_id}/seen`, but is
         * otherwise the same as [MessageServiceAsync.markAsSeen].
         */
        @MustBeClosed
        fun markAsSeen(params: MessageMarkAsSeenParams): CompletableFuture<HttpResponseFor<Message>> =
            markAsSeen(
              params, RequestOptions.none()
            )

        /** @see [markAsSeen] */
        @MustBeClosed
        fun markAsSeen(params: MessageMarkAsSeenParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<HttpResponseFor<Message>>

        /**
         * Returns a raw HTTP response for `delete /v1/messages/{message_id}/unread`, but
         * is otherwise the same as [MessageServiceAsync.markAsUnread].
         */
        @MustBeClosed
        fun markAsUnread(params: MessageMarkAsUnreadParams): CompletableFuture<HttpResponseFor<Message>> =
            markAsUnread(
              params, RequestOptions.none()
            )

        /** @see [markAsUnread] */
        @MustBeClosed
        fun markAsUnread(params: MessageMarkAsUnreadParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<HttpResponseFor<Message>>

        /**
         * Returns a raw HTTP response for `delete /v1/messages/{message_id}/unseen`, but
         * is otherwise the same as [MessageServiceAsync.markAsUnseen].
         */
        @MustBeClosed
        fun markAsUnseen(params: MessageMarkAsUnseenParams): CompletableFuture<HttpResponseFor<Message>> =
            markAsUnseen(
              params, RequestOptions.none()
            )

        /** @see [markAsUnseen] */
        @MustBeClosed
        fun markAsUnseen(params: MessageMarkAsUnseenParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<HttpResponseFor<Message>>

        /**
         * Returns a raw HTTP response for `delete /v1/messages/{message_id}/unarchived`,
         * but is otherwise the same as [MessageServiceAsync.unarchive].
         */
        @MustBeClosed
        fun unarchive(params: MessageUnarchiveParams): CompletableFuture<HttpResponseFor<Message>> =
            unarchive(
              params, RequestOptions.none()
            )

        /** @see [unarchive] */
        @MustBeClosed
        fun unarchive(params: MessageUnarchiveParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<HttpResponseFor<Message>>
    }
}
