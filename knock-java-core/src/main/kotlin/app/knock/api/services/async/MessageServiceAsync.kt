// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.messages.Message
import app.knock.api.models.messages.MessageArchiveParams
import app.knock.api.models.messages.MessageGetContentParams
import app.knock.api.models.messages.MessageGetContentResponse
import app.knock.api.models.messages.MessageGetParams
import app.knock.api.models.messages.MessageListActivitiesPageAsync
import app.knock.api.models.messages.MessageListActivitiesParams
import app.knock.api.models.messages.MessageListDeliveryLogsPageAsync
import app.knock.api.models.messages.MessageListDeliveryLogsParams
import app.knock.api.models.messages.MessageListEventsPageAsync
import app.knock.api.models.messages.MessageListEventsParams
import app.knock.api.models.messages.MessageListPageAsync
import app.knock.api.models.messages.MessageListParams
import app.knock.api.models.messages.MessageMarkAsInteractedParams
import app.knock.api.models.messages.MessageMarkAsReadParams
import app.knock.api.models.messages.MessageMarkAsSeenParams
import app.knock.api.models.messages.MessageMarkAsUnreadParams
import app.knock.api.models.messages.MessageMarkAsUnseenParams
import app.knock.api.models.messages.MessageUnarchiveParams
import app.knock.api.services.async.messages.BatchServiceAsync
import com.google.errorprone.annotations.MustBeClosed
import java.util.concurrent.CompletableFuture

interface MessageServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun batch(): BatchServiceAsync

    /** Returns a paginated list of messages for the current environment. */
    fun list(): CompletableFuture<MessageListPageAsync> = list(MessageListParams.none())

    /** @see [list] */
    fun list(
        params: MessageListParams = MessageListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageListPageAsync>

    /** @see [list] */
    fun list(
        params: MessageListParams = MessageListParams.none()
    ): CompletableFuture<MessageListPageAsync> = list(params, RequestOptions.none())

    /** @see [list] */
    fun list(requestOptions: RequestOptions): CompletableFuture<MessageListPageAsync> =
        list(MessageListParams.none(), requestOptions)

    /**
     * Archives a message for the user. Archived messages are hidden from the default message list
     * in the feed but can still be accessed and unarchived later.
     */
    fun archive(params: MessageArchiveParams): CompletableFuture<Message> =
        archive(params, RequestOptions.none())

    /** @see [archive] */
    fun archive(
        params: MessageArchiveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message>

    /** Retrieves a specific message by its ID. */
    fun get(params: MessageGetParams): CompletableFuture<Message> =
        get(params, RequestOptions.none())

    /** @see [get] */
    fun get(
        params: MessageGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message>

    /**
     * Returns the fully rendered contents of a message, where the response depends on which channel
     * the message was sent through.
     */
    fun getContent(params: MessageGetContentParams): CompletableFuture<MessageGetContentResponse> =
        getContent(params, RequestOptions.none())

    /** @see [getContent] */
    fun getContent(
        params: MessageGetContentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageGetContentResponse>

    /** Returns a paginated list of activities for the specified message. */
    fun listActivities(
        params: MessageListActivitiesParams
    ): CompletableFuture<MessageListActivitiesPageAsync> =
        listActivities(params, RequestOptions.none())

    /** @see [listActivities] */
    fun listActivities(
        params: MessageListActivitiesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageListActivitiesPageAsync>

    /** Returns a paginated list of delivery logs for the specified message. */
    fun listDeliveryLogs(
        params: MessageListDeliveryLogsParams
    ): CompletableFuture<MessageListDeliveryLogsPageAsync> =
        listDeliveryLogs(params, RequestOptions.none())

    /** @see [listDeliveryLogs] */
    fun listDeliveryLogs(
        params: MessageListDeliveryLogsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageListDeliveryLogsPageAsync>

    /** Returns a paginated list of events for the specified message. */
    fun listEvents(params: MessageListEventsParams): CompletableFuture<MessageListEventsPageAsync> =
        listEvents(params, RequestOptions.none())

    /** @see [listEvents] */
    fun listEvents(
        params: MessageListEventsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageListEventsPageAsync>

    /**
     * Marks a message as `interacted` with by the user. This can include any user action on the
     * message, with optional metadata about the specific interaction. Cannot include more than 5
     * key-value pairs, must not contain nested data. Read more about message engagement statuses
     * [here](/send-notifications/message-statuses#engagement-status).
     */
    fun markAsInteracted(params: MessageMarkAsInteractedParams): CompletableFuture<Message> =
        markAsInteracted(params, RequestOptions.none())

    /** @see [markAsInteracted] */
    fun markAsInteracted(
        params: MessageMarkAsInteractedParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message>

    /**
     * Marks a message as `read`. This indicates that the user has read the message content. Read
     * more about message engagement statuses
     * [here](/send-notifications/message-statuses#engagement-status).
     */
    fun markAsRead(params: MessageMarkAsReadParams): CompletableFuture<Message> =
        markAsRead(params, RequestOptions.none())

    /** @see [markAsRead] */
    fun markAsRead(
        params: MessageMarkAsReadParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message>

    /**
     * Marks a message as `seen`. This indicates that the user has viewed the message in their feed
     * or inbox. Read more about message engagement statuses
     * [here](/send-notifications/message-statuses#engagement-status).
     */
    fun markAsSeen(params: MessageMarkAsSeenParams): CompletableFuture<Message> =
        markAsSeen(params, RequestOptions.none())

    /** @see [markAsSeen] */
    fun markAsSeen(
        params: MessageMarkAsSeenParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message>

    /**
     * Marks a message as `unread`. This reverses the `read` state. Read more about message
     * engagement statuses [here](/send-notifications/message-statuses#engagement-status).
     */
    fun markAsUnread(params: MessageMarkAsUnreadParams): CompletableFuture<Message> =
        markAsUnread(params, RequestOptions.none())

    /** @see [markAsUnread] */
    fun markAsUnread(
        params: MessageMarkAsUnreadParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message>

    /**
     * Marks a message as `unseen`. This reverses the `seen` state. Read more about message
     * engagement statuses [here](/send-notifications/message-statuses#engagement-status).
     */
    fun markAsUnseen(params: MessageMarkAsUnseenParams): CompletableFuture<Message> =
        markAsUnseen(params, RequestOptions.none())

    /** @see [markAsUnseen] */
    fun markAsUnseen(
        params: MessageMarkAsUnseenParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message>

    /**
     * Removes a message from the archived state, making it visible in the default message list in
     * the feed again.
     */
    fun unarchive(params: MessageUnarchiveParams): CompletableFuture<Message> =
        unarchive(params, RequestOptions.none())

    /** @see [unarchive] */
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
        @MustBeClosed
        fun list(): CompletableFuture<HttpResponseFor<MessageListPageAsync>> =
            list(MessageListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: MessageListParams = MessageListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageListPageAsync>>

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: MessageListParams = MessageListParams.none()
        ): CompletableFuture<HttpResponseFor<MessageListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<MessageListPageAsync>> =
            list(MessageListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put /v1/messages/{message_id}/archived`, but is
         * otherwise the same as [MessageServiceAsync.archive].
         */
        @MustBeClosed
        fun archive(params: MessageArchiveParams): CompletableFuture<HttpResponseFor<Message>> =
            archive(params, RequestOptions.none())

        /** @see [archive] */
        @MustBeClosed
        fun archive(
            params: MessageArchiveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>>

        /**
         * Returns a raw HTTP response for `get /v1/messages/{message_id}`, but is otherwise the
         * same as [MessageServiceAsync.get].
         */
        @MustBeClosed
        fun get(params: MessageGetParams): CompletableFuture<HttpResponseFor<Message>> =
            get(params, RequestOptions.none())

        /** @see [get] */
        @MustBeClosed
        fun get(
            params: MessageGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>>

        /**
         * Returns a raw HTTP response for `get /v1/messages/{message_id}/content`, but is otherwise
         * the same as [MessageServiceAsync.getContent].
         */
        @MustBeClosed
        fun getContent(
            params: MessageGetContentParams
        ): CompletableFuture<HttpResponseFor<MessageGetContentResponse>> =
            getContent(params, RequestOptions.none())

        /** @see [getContent] */
        @MustBeClosed
        fun getContent(
            params: MessageGetContentParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageGetContentResponse>>

        /**
         * Returns a raw HTTP response for `get /v1/messages/{message_id}/activities`, but is
         * otherwise the same as [MessageServiceAsync.listActivities].
         */
        @MustBeClosed
        fun listActivities(
            params: MessageListActivitiesParams
        ): CompletableFuture<HttpResponseFor<MessageListActivitiesPageAsync>> =
            listActivities(params, RequestOptions.none())

        /** @see [listActivities] */
        @MustBeClosed
        fun listActivities(
            params: MessageListActivitiesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageListActivitiesPageAsync>>

        /**
         * Returns a raw HTTP response for `get /v1/messages/{message_id}/delivery_logs`, but is
         * otherwise the same as [MessageServiceAsync.listDeliveryLogs].
         */
        @MustBeClosed
        fun listDeliveryLogs(
            params: MessageListDeliveryLogsParams
        ): CompletableFuture<HttpResponseFor<MessageListDeliveryLogsPageAsync>> =
            listDeliveryLogs(params, RequestOptions.none())

        /** @see [listDeliveryLogs] */
        @MustBeClosed
        fun listDeliveryLogs(
            params: MessageListDeliveryLogsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageListDeliveryLogsPageAsync>>

        /**
         * Returns a raw HTTP response for `get /v1/messages/{message_id}/events`, but is otherwise
         * the same as [MessageServiceAsync.listEvents].
         */
        @MustBeClosed
        fun listEvents(
            params: MessageListEventsParams
        ): CompletableFuture<HttpResponseFor<MessageListEventsPageAsync>> =
            listEvents(params, RequestOptions.none())

        /** @see [listEvents] */
        @MustBeClosed
        fun listEvents(
            params: MessageListEventsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageListEventsPageAsync>>

        /**
         * Returns a raw HTTP response for `put /v1/messages/{message_id}/interacted`, but is
         * otherwise the same as [MessageServiceAsync.markAsInteracted].
         */
        @MustBeClosed
        fun markAsInteracted(
            params: MessageMarkAsInteractedParams
        ): CompletableFuture<HttpResponseFor<Message>> =
            markAsInteracted(params, RequestOptions.none())

        /** @see [markAsInteracted] */
        @MustBeClosed
        fun markAsInteracted(
            params: MessageMarkAsInteractedParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>>

        /**
         * Returns a raw HTTP response for `put /v1/messages/{message_id}/read`, but is otherwise
         * the same as [MessageServiceAsync.markAsRead].
         */
        @MustBeClosed
        fun markAsRead(
            params: MessageMarkAsReadParams
        ): CompletableFuture<HttpResponseFor<Message>> = markAsRead(params, RequestOptions.none())

        /** @see [markAsRead] */
        @MustBeClosed
        fun markAsRead(
            params: MessageMarkAsReadParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>>

        /**
         * Returns a raw HTTP response for `put /v1/messages/{message_id}/seen`, but is otherwise
         * the same as [MessageServiceAsync.markAsSeen].
         */
        @MustBeClosed
        fun markAsSeen(
            params: MessageMarkAsSeenParams
        ): CompletableFuture<HttpResponseFor<Message>> = markAsSeen(params, RequestOptions.none())

        /** @see [markAsSeen] */
        @MustBeClosed
        fun markAsSeen(
            params: MessageMarkAsSeenParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>>

        /**
         * Returns a raw HTTP response for `delete /v1/messages/{message_id}/read`, but is otherwise
         * the same as [MessageServiceAsync.markAsUnread].
         */
        @MustBeClosed
        fun markAsUnread(
            params: MessageMarkAsUnreadParams
        ): CompletableFuture<HttpResponseFor<Message>> = markAsUnread(params, RequestOptions.none())

        /** @see [markAsUnread] */
        @MustBeClosed
        fun markAsUnread(
            params: MessageMarkAsUnreadParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>>

        /**
         * Returns a raw HTTP response for `delete /v1/messages/{message_id}/seen`, but is otherwise
         * the same as [MessageServiceAsync.markAsUnseen].
         */
        @MustBeClosed
        fun markAsUnseen(
            params: MessageMarkAsUnseenParams
        ): CompletableFuture<HttpResponseFor<Message>> = markAsUnseen(params, RequestOptions.none())

        /** @see [markAsUnseen] */
        @MustBeClosed
        fun markAsUnseen(
            params: MessageMarkAsUnseenParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>>

        /**
         * Returns a raw HTTP response for `delete /v1/messages/{message_id}/archived`, but is
         * otherwise the same as [MessageServiceAsync.unarchive].
         */
        @MustBeClosed
        fun unarchive(params: MessageUnarchiveParams): CompletableFuture<HttpResponseFor<Message>> =
            unarchive(params, RequestOptions.none())

        /** @see [unarchive] */
        @MustBeClosed
        fun unarchive(
            params: MessageUnarchiveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>>
    }
}
