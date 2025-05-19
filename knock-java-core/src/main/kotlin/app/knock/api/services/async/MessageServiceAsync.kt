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
import app.knock.api.services.async.messages.ActivityServiceAsync
import app.knock.api.services.async.messages.BatchServiceAsync
import com.google.errorprone.annotations.MustBeClosed
import java.util.concurrent.CompletableFuture

interface MessageServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun batch(): BatchServiceAsync

    fun activities(): ActivityServiceAsync

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
    fun archive(messageId: String): CompletableFuture<Message> =
        archive(messageId, MessageArchiveParams.none())

    /** @see [archive] */
    fun archive(
        messageId: String,
        params: MessageArchiveParams = MessageArchiveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message> =
        archive(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see [archive] */
    fun archive(
        messageId: String,
        params: MessageArchiveParams = MessageArchiveParams.none(),
    ): CompletableFuture<Message> = archive(messageId, params, RequestOptions.none())

    /** @see [archive] */
    fun archive(
        params: MessageArchiveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message>

    /** @see [archive] */
    fun archive(params: MessageArchiveParams): CompletableFuture<Message> =
        archive(params, RequestOptions.none())

    /** @see [archive] */
    fun archive(messageId: String, requestOptions: RequestOptions): CompletableFuture<Message> =
        archive(messageId, MessageArchiveParams.none(), requestOptions)

    /** Retrieves a specific message by its ID. */
    fun get(messageId: String): CompletableFuture<Message> = get(messageId, MessageGetParams.none())

    /** @see [get] */
    fun get(
        messageId: String,
        params: MessageGetParams = MessageGetParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message> =
        get(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see [get] */
    fun get(
        messageId: String,
        params: MessageGetParams = MessageGetParams.none(),
    ): CompletableFuture<Message> = get(messageId, params, RequestOptions.none())

    /** @see [get] */
    fun get(
        params: MessageGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message>

    /** @see [get] */
    fun get(params: MessageGetParams): CompletableFuture<Message> =
        get(params, RequestOptions.none())

    /** @see [get] */
    fun get(messageId: String, requestOptions: RequestOptions): CompletableFuture<Message> =
        get(messageId, MessageGetParams.none(), requestOptions)

    /**
     * Returns the fully rendered contents of a message, where the response depends on which channel
     * the message was sent through.
     */
    fun getContent(messageId: String): CompletableFuture<MessageGetContentResponse> =
        getContent(messageId, MessageGetContentParams.none())

    /** @see [getContent] */
    fun getContent(
        messageId: String,
        params: MessageGetContentParams = MessageGetContentParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageGetContentResponse> =
        getContent(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see [getContent] */
    fun getContent(
        messageId: String,
        params: MessageGetContentParams = MessageGetContentParams.none(),
    ): CompletableFuture<MessageGetContentResponse> =
        getContent(messageId, params, RequestOptions.none())

    /** @see [getContent] */
    fun getContent(
        params: MessageGetContentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageGetContentResponse>

    /** @see [getContent] */
    fun getContent(params: MessageGetContentParams): CompletableFuture<MessageGetContentResponse> =
        getContent(params, RequestOptions.none())

    /** @see [getContent] */
    fun getContent(
        messageId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<MessageGetContentResponse> =
        getContent(messageId, MessageGetContentParams.none(), requestOptions)

    /** Returns a paginated list of activities for the specified message. */
    fun listActivities(messageId: String): CompletableFuture<MessageListActivitiesPageAsync> =
        listActivities(messageId, MessageListActivitiesParams.none())

    /** @see [listActivities] */
    fun listActivities(
        messageId: String,
        params: MessageListActivitiesParams = MessageListActivitiesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageListActivitiesPageAsync> =
        listActivities(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see [listActivities] */
    fun listActivities(
        messageId: String,
        params: MessageListActivitiesParams = MessageListActivitiesParams.none(),
    ): CompletableFuture<MessageListActivitiesPageAsync> =
        listActivities(messageId, params, RequestOptions.none())

    /** @see [listActivities] */
    fun listActivities(
        params: MessageListActivitiesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageListActivitiesPageAsync>

    /** @see [listActivities] */
    fun listActivities(
        params: MessageListActivitiesParams
    ): CompletableFuture<MessageListActivitiesPageAsync> =
        listActivities(params, RequestOptions.none())

    /** @see [listActivities] */
    fun listActivities(
        messageId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<MessageListActivitiesPageAsync> =
        listActivities(messageId, MessageListActivitiesParams.none(), requestOptions)

    /** Returns a paginated list of delivery logs for the specified message. */
    fun listDeliveryLogs(messageId: String): CompletableFuture<MessageListDeliveryLogsPageAsync> =
        listDeliveryLogs(messageId, MessageListDeliveryLogsParams.none())

    /** @see [listDeliveryLogs] */
    fun listDeliveryLogs(
        messageId: String,
        params: MessageListDeliveryLogsParams = MessageListDeliveryLogsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageListDeliveryLogsPageAsync> =
        listDeliveryLogs(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see [listDeliveryLogs] */
    fun listDeliveryLogs(
        messageId: String,
        params: MessageListDeliveryLogsParams = MessageListDeliveryLogsParams.none(),
    ): CompletableFuture<MessageListDeliveryLogsPageAsync> =
        listDeliveryLogs(messageId, params, RequestOptions.none())

    /** @see [listDeliveryLogs] */
    fun listDeliveryLogs(
        params: MessageListDeliveryLogsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageListDeliveryLogsPageAsync>

    /** @see [listDeliveryLogs] */
    fun listDeliveryLogs(
        params: MessageListDeliveryLogsParams
    ): CompletableFuture<MessageListDeliveryLogsPageAsync> =
        listDeliveryLogs(params, RequestOptions.none())

    /** @see [listDeliveryLogs] */
    fun listDeliveryLogs(
        messageId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<MessageListDeliveryLogsPageAsync> =
        listDeliveryLogs(messageId, MessageListDeliveryLogsParams.none(), requestOptions)

    /** Returns a paginated list of events for the specified message. */
    fun listEvents(messageId: String): CompletableFuture<MessageListEventsPageAsync> =
        listEvents(messageId, MessageListEventsParams.none())

    /** @see [listEvents] */
    fun listEvents(
        messageId: String,
        params: MessageListEventsParams = MessageListEventsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageListEventsPageAsync> =
        listEvents(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see [listEvents] */
    fun listEvents(
        messageId: String,
        params: MessageListEventsParams = MessageListEventsParams.none(),
    ): CompletableFuture<MessageListEventsPageAsync> =
        listEvents(messageId, params, RequestOptions.none())

    /** @see [listEvents] */
    fun listEvents(
        params: MessageListEventsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MessageListEventsPageAsync>

    /** @see [listEvents] */
    fun listEvents(params: MessageListEventsParams): CompletableFuture<MessageListEventsPageAsync> =
        listEvents(params, RequestOptions.none())

    /** @see [listEvents] */
    fun listEvents(
        messageId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<MessageListEventsPageAsync> =
        listEvents(messageId, MessageListEventsParams.none(), requestOptions)

    /**
     * Marks a message as `interacted` with by the user. This can include any user action on the
     * message, with optional metadata about the specific interaction. Cannot include more than 5
     * key-value pairs, must not contain nested data. Read more about message engagement statuses
     * [here](/send-notifications/message-statuses#engagement-status).
     */
    fun markAsInteracted(messageId: String): CompletableFuture<Message> =
        markAsInteracted(messageId, MessageMarkAsInteractedParams.none())

    /** @see [markAsInteracted] */
    fun markAsInteracted(
        messageId: String,
        params: MessageMarkAsInteractedParams = MessageMarkAsInteractedParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message> =
        markAsInteracted(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see [markAsInteracted] */
    fun markAsInteracted(
        messageId: String,
        params: MessageMarkAsInteractedParams = MessageMarkAsInteractedParams.none(),
    ): CompletableFuture<Message> = markAsInteracted(messageId, params, RequestOptions.none())

    /** @see [markAsInteracted] */
    fun markAsInteracted(
        params: MessageMarkAsInteractedParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message>

    /** @see [markAsInteracted] */
    fun markAsInteracted(params: MessageMarkAsInteractedParams): CompletableFuture<Message> =
        markAsInteracted(params, RequestOptions.none())

    /** @see [markAsInteracted] */
    fun markAsInteracted(
        messageId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<Message> =
        markAsInteracted(messageId, MessageMarkAsInteractedParams.none(), requestOptions)

    /**
     * Marks a message as `read`. This indicates that the user has read the message content. Read
     * more about message engagement statuses
     * [here](/send-notifications/message-statuses#engagement-status).
     */
    fun markAsRead(messageId: String): CompletableFuture<Message> =
        markAsRead(messageId, MessageMarkAsReadParams.none())

    /** @see [markAsRead] */
    fun markAsRead(
        messageId: String,
        params: MessageMarkAsReadParams = MessageMarkAsReadParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message> =
        markAsRead(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see [markAsRead] */
    fun markAsRead(
        messageId: String,
        params: MessageMarkAsReadParams = MessageMarkAsReadParams.none(),
    ): CompletableFuture<Message> = markAsRead(messageId, params, RequestOptions.none())

    /** @see [markAsRead] */
    fun markAsRead(
        params: MessageMarkAsReadParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message>

    /** @see [markAsRead] */
    fun markAsRead(params: MessageMarkAsReadParams): CompletableFuture<Message> =
        markAsRead(params, RequestOptions.none())

    /** @see [markAsRead] */
    fun markAsRead(messageId: String, requestOptions: RequestOptions): CompletableFuture<Message> =
        markAsRead(messageId, MessageMarkAsReadParams.none(), requestOptions)

    /**
     * Marks a message as `seen`. This indicates that the user has viewed the message in their feed
     * or inbox. Read more about message engagement statuses
     * [here](/send-notifications/message-statuses#engagement-status).
     */
    fun markAsSeen(messageId: String): CompletableFuture<Message> =
        markAsSeen(messageId, MessageMarkAsSeenParams.none())

    /** @see [markAsSeen] */
    fun markAsSeen(
        messageId: String,
        params: MessageMarkAsSeenParams = MessageMarkAsSeenParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message> =
        markAsSeen(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see [markAsSeen] */
    fun markAsSeen(
        messageId: String,
        params: MessageMarkAsSeenParams = MessageMarkAsSeenParams.none(),
    ): CompletableFuture<Message> = markAsSeen(messageId, params, RequestOptions.none())

    /** @see [markAsSeen] */
    fun markAsSeen(
        params: MessageMarkAsSeenParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message>

    /** @see [markAsSeen] */
    fun markAsSeen(params: MessageMarkAsSeenParams): CompletableFuture<Message> =
        markAsSeen(params, RequestOptions.none())

    /** @see [markAsSeen] */
    fun markAsSeen(messageId: String, requestOptions: RequestOptions): CompletableFuture<Message> =
        markAsSeen(messageId, MessageMarkAsSeenParams.none(), requestOptions)

    /**
     * Marks a message as `unread`. This reverses the `read` state. Read more about message
     * engagement statuses [here](/send-notifications/message-statuses#engagement-status).
     */
    fun markAsUnread(messageId: String): CompletableFuture<Message> =
        markAsUnread(messageId, MessageMarkAsUnreadParams.none())

    /** @see [markAsUnread] */
    fun markAsUnread(
        messageId: String,
        params: MessageMarkAsUnreadParams = MessageMarkAsUnreadParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message> =
        markAsUnread(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see [markAsUnread] */
    fun markAsUnread(
        messageId: String,
        params: MessageMarkAsUnreadParams = MessageMarkAsUnreadParams.none(),
    ): CompletableFuture<Message> = markAsUnread(messageId, params, RequestOptions.none())

    /** @see [markAsUnread] */
    fun markAsUnread(
        params: MessageMarkAsUnreadParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message>

    /** @see [markAsUnread] */
    fun markAsUnread(params: MessageMarkAsUnreadParams): CompletableFuture<Message> =
        markAsUnread(params, RequestOptions.none())

    /** @see [markAsUnread] */
    fun markAsUnread(
        messageId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<Message> =
        markAsUnread(messageId, MessageMarkAsUnreadParams.none(), requestOptions)

    /**
     * Marks a message as `unseen`. This reverses the `seen` state. Read more about message
     * engagement statuses [here](/send-notifications/message-statuses#engagement-status).
     */
    fun markAsUnseen(messageId: String): CompletableFuture<Message> =
        markAsUnseen(messageId, MessageMarkAsUnseenParams.none())

    /** @see [markAsUnseen] */
    fun markAsUnseen(
        messageId: String,
        params: MessageMarkAsUnseenParams = MessageMarkAsUnseenParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message> =
        markAsUnseen(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see [markAsUnseen] */
    fun markAsUnseen(
        messageId: String,
        params: MessageMarkAsUnseenParams = MessageMarkAsUnseenParams.none(),
    ): CompletableFuture<Message> = markAsUnseen(messageId, params, RequestOptions.none())

    /** @see [markAsUnseen] */
    fun markAsUnseen(
        params: MessageMarkAsUnseenParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message>

    /** @see [markAsUnseen] */
    fun markAsUnseen(params: MessageMarkAsUnseenParams): CompletableFuture<Message> =
        markAsUnseen(params, RequestOptions.none())

    /** @see [markAsUnseen] */
    fun markAsUnseen(
        messageId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<Message> =
        markAsUnseen(messageId, MessageMarkAsUnseenParams.none(), requestOptions)

    /**
     * Removes a message from the archived state, making it visible in the default message list in
     * the feed again.
     */
    fun unarchive(messageId: String): CompletableFuture<Message> =
        unarchive(messageId, MessageUnarchiveParams.none())

    /** @see [unarchive] */
    fun unarchive(
        messageId: String,
        params: MessageUnarchiveParams = MessageUnarchiveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message> =
        unarchive(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see [unarchive] */
    fun unarchive(
        messageId: String,
        params: MessageUnarchiveParams = MessageUnarchiveParams.none(),
    ): CompletableFuture<Message> = unarchive(messageId, params, RequestOptions.none())

    /** @see [unarchive] */
    fun unarchive(
        params: MessageUnarchiveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Message>

    /** @see [unarchive] */
    fun unarchive(params: MessageUnarchiveParams): CompletableFuture<Message> =
        unarchive(params, RequestOptions.none())

    /** @see [unarchive] */
    fun unarchive(messageId: String, requestOptions: RequestOptions): CompletableFuture<Message> =
        unarchive(messageId, MessageUnarchiveParams.none(), requestOptions)

    /**
     * A view of [MessageServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        fun batch(): BatchServiceAsync.WithRawResponse

        fun activities(): ActivityServiceAsync.WithRawResponse

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
        fun archive(messageId: String): CompletableFuture<HttpResponseFor<Message>> =
            archive(messageId, MessageArchiveParams.none())

        /** @see [archive] */
        @MustBeClosed
        fun archive(
            messageId: String,
            params: MessageArchiveParams = MessageArchiveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>> =
            archive(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see [archive] */
        @MustBeClosed
        fun archive(
            messageId: String,
            params: MessageArchiveParams = MessageArchiveParams.none(),
        ): CompletableFuture<HttpResponseFor<Message>> =
            archive(messageId, params, RequestOptions.none())

        /** @see [archive] */
        @MustBeClosed
        fun archive(
            params: MessageArchiveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>>

        /** @see [archive] */
        @MustBeClosed
        fun archive(params: MessageArchiveParams): CompletableFuture<HttpResponseFor<Message>> =
            archive(params, RequestOptions.none())

        /** @see [archive] */
        @MustBeClosed
        fun archive(
            messageId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Message>> =
            archive(messageId, MessageArchiveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/messages/{message_id}`, but is otherwise the
         * same as [MessageServiceAsync.get].
         */
        @MustBeClosed
        fun get(messageId: String): CompletableFuture<HttpResponseFor<Message>> =
            get(messageId, MessageGetParams.none())

        /** @see [get] */
        @MustBeClosed
        fun get(
            messageId: String,
            params: MessageGetParams = MessageGetParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>> =
            get(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see [get] */
        @MustBeClosed
        fun get(
            messageId: String,
            params: MessageGetParams = MessageGetParams.none(),
        ): CompletableFuture<HttpResponseFor<Message>> =
            get(messageId, params, RequestOptions.none())

        /** @see [get] */
        @MustBeClosed
        fun get(
            params: MessageGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>>

        /** @see [get] */
        @MustBeClosed
        fun get(params: MessageGetParams): CompletableFuture<HttpResponseFor<Message>> =
            get(params, RequestOptions.none())

        /** @see [get] */
        @MustBeClosed
        fun get(
            messageId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Message>> =
            get(messageId, MessageGetParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/messages/{message_id}/content`, but is otherwise
         * the same as [MessageServiceAsync.getContent].
         */
        @MustBeClosed
        fun getContent(
            messageId: String
        ): CompletableFuture<HttpResponseFor<MessageGetContentResponse>> =
            getContent(messageId, MessageGetContentParams.none())

        /** @see [getContent] */
        @MustBeClosed
        fun getContent(
            messageId: String,
            params: MessageGetContentParams = MessageGetContentParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageGetContentResponse>> =
            getContent(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see [getContent] */
        @MustBeClosed
        fun getContent(
            messageId: String,
            params: MessageGetContentParams = MessageGetContentParams.none(),
        ): CompletableFuture<HttpResponseFor<MessageGetContentResponse>> =
            getContent(messageId, params, RequestOptions.none())

        /** @see [getContent] */
        @MustBeClosed
        fun getContent(
            params: MessageGetContentParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageGetContentResponse>>

        /** @see [getContent] */
        @MustBeClosed
        fun getContent(
            params: MessageGetContentParams
        ): CompletableFuture<HttpResponseFor<MessageGetContentResponse>> =
            getContent(params, RequestOptions.none())

        /** @see [getContent] */
        @MustBeClosed
        fun getContent(
            messageId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<MessageGetContentResponse>> =
            getContent(messageId, MessageGetContentParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/messages/{message_id}/activities`, but is
         * otherwise the same as [MessageServiceAsync.listActivities].
         */
        @MustBeClosed
        fun listActivities(
            messageId: String
        ): CompletableFuture<HttpResponseFor<MessageListActivitiesPageAsync>> =
            listActivities(messageId, MessageListActivitiesParams.none())

        /** @see [listActivities] */
        @MustBeClosed
        fun listActivities(
            messageId: String,
            params: MessageListActivitiesParams = MessageListActivitiesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageListActivitiesPageAsync>> =
            listActivities(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see [listActivities] */
        @MustBeClosed
        fun listActivities(
            messageId: String,
            params: MessageListActivitiesParams = MessageListActivitiesParams.none(),
        ): CompletableFuture<HttpResponseFor<MessageListActivitiesPageAsync>> =
            listActivities(messageId, params, RequestOptions.none())

        /** @see [listActivities] */
        @MustBeClosed
        fun listActivities(
            params: MessageListActivitiesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageListActivitiesPageAsync>>

        /** @see [listActivities] */
        @MustBeClosed
        fun listActivities(
            params: MessageListActivitiesParams
        ): CompletableFuture<HttpResponseFor<MessageListActivitiesPageAsync>> =
            listActivities(params, RequestOptions.none())

        /** @see [listActivities] */
        @MustBeClosed
        fun listActivities(
            messageId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<MessageListActivitiesPageAsync>> =
            listActivities(messageId, MessageListActivitiesParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/messages/{message_id}/delivery_logs`, but is
         * otherwise the same as [MessageServiceAsync.listDeliveryLogs].
         */
        @MustBeClosed
        fun listDeliveryLogs(
            messageId: String
        ): CompletableFuture<HttpResponseFor<MessageListDeliveryLogsPageAsync>> =
            listDeliveryLogs(messageId, MessageListDeliveryLogsParams.none())

        /** @see [listDeliveryLogs] */
        @MustBeClosed
        fun listDeliveryLogs(
            messageId: String,
            params: MessageListDeliveryLogsParams = MessageListDeliveryLogsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageListDeliveryLogsPageAsync>> =
            listDeliveryLogs(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see [listDeliveryLogs] */
        @MustBeClosed
        fun listDeliveryLogs(
            messageId: String,
            params: MessageListDeliveryLogsParams = MessageListDeliveryLogsParams.none(),
        ): CompletableFuture<HttpResponseFor<MessageListDeliveryLogsPageAsync>> =
            listDeliveryLogs(messageId, params, RequestOptions.none())

        /** @see [listDeliveryLogs] */
        @MustBeClosed
        fun listDeliveryLogs(
            params: MessageListDeliveryLogsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageListDeliveryLogsPageAsync>>

        /** @see [listDeliveryLogs] */
        @MustBeClosed
        fun listDeliveryLogs(
            params: MessageListDeliveryLogsParams
        ): CompletableFuture<HttpResponseFor<MessageListDeliveryLogsPageAsync>> =
            listDeliveryLogs(params, RequestOptions.none())

        /** @see [listDeliveryLogs] */
        @MustBeClosed
        fun listDeliveryLogs(
            messageId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<MessageListDeliveryLogsPageAsync>> =
            listDeliveryLogs(messageId, MessageListDeliveryLogsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/messages/{message_id}/events`, but is otherwise
         * the same as [MessageServiceAsync.listEvents].
         */
        @MustBeClosed
        fun listEvents(
            messageId: String
        ): CompletableFuture<HttpResponseFor<MessageListEventsPageAsync>> =
            listEvents(messageId, MessageListEventsParams.none())

        /** @see [listEvents] */
        @MustBeClosed
        fun listEvents(
            messageId: String,
            params: MessageListEventsParams = MessageListEventsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageListEventsPageAsync>> =
            listEvents(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see [listEvents] */
        @MustBeClosed
        fun listEvents(
            messageId: String,
            params: MessageListEventsParams = MessageListEventsParams.none(),
        ): CompletableFuture<HttpResponseFor<MessageListEventsPageAsync>> =
            listEvents(messageId, params, RequestOptions.none())

        /** @see [listEvents] */
        @MustBeClosed
        fun listEvents(
            params: MessageListEventsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MessageListEventsPageAsync>>

        /** @see [listEvents] */
        @MustBeClosed
        fun listEvents(
            params: MessageListEventsParams
        ): CompletableFuture<HttpResponseFor<MessageListEventsPageAsync>> =
            listEvents(params, RequestOptions.none())

        /** @see [listEvents] */
        @MustBeClosed
        fun listEvents(
            messageId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<MessageListEventsPageAsync>> =
            listEvents(messageId, MessageListEventsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put /v1/messages/{message_id}/interacted`, but is
         * otherwise the same as [MessageServiceAsync.markAsInteracted].
         */
        @MustBeClosed
        fun markAsInteracted(messageId: String): CompletableFuture<HttpResponseFor<Message>> =
            markAsInteracted(messageId, MessageMarkAsInteractedParams.none())

        /** @see [markAsInteracted] */
        @MustBeClosed
        fun markAsInteracted(
            messageId: String,
            params: MessageMarkAsInteractedParams = MessageMarkAsInteractedParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>> =
            markAsInteracted(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see [markAsInteracted] */
        @MustBeClosed
        fun markAsInteracted(
            messageId: String,
            params: MessageMarkAsInteractedParams = MessageMarkAsInteractedParams.none(),
        ): CompletableFuture<HttpResponseFor<Message>> =
            markAsInteracted(messageId, params, RequestOptions.none())

        /** @see [markAsInteracted] */
        @MustBeClosed
        fun markAsInteracted(
            params: MessageMarkAsInteractedParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>>

        /** @see [markAsInteracted] */
        @MustBeClosed
        fun markAsInteracted(
            params: MessageMarkAsInteractedParams
        ): CompletableFuture<HttpResponseFor<Message>> =
            markAsInteracted(params, RequestOptions.none())

        /** @see [markAsInteracted] */
        @MustBeClosed
        fun markAsInteracted(
            messageId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Message>> =
            markAsInteracted(messageId, MessageMarkAsInteractedParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put /v1/messages/{message_id}/read`, but is otherwise
         * the same as [MessageServiceAsync.markAsRead].
         */
        @MustBeClosed
        fun markAsRead(messageId: String): CompletableFuture<HttpResponseFor<Message>> =
            markAsRead(messageId, MessageMarkAsReadParams.none())

        /** @see [markAsRead] */
        @MustBeClosed
        fun markAsRead(
            messageId: String,
            params: MessageMarkAsReadParams = MessageMarkAsReadParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>> =
            markAsRead(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see [markAsRead] */
        @MustBeClosed
        fun markAsRead(
            messageId: String,
            params: MessageMarkAsReadParams = MessageMarkAsReadParams.none(),
        ): CompletableFuture<HttpResponseFor<Message>> =
            markAsRead(messageId, params, RequestOptions.none())

        /** @see [markAsRead] */
        @MustBeClosed
        fun markAsRead(
            params: MessageMarkAsReadParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>>

        /** @see [markAsRead] */
        @MustBeClosed
        fun markAsRead(
            params: MessageMarkAsReadParams
        ): CompletableFuture<HttpResponseFor<Message>> = markAsRead(params, RequestOptions.none())

        /** @see [markAsRead] */
        @MustBeClosed
        fun markAsRead(
            messageId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Message>> =
            markAsRead(messageId, MessageMarkAsReadParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put /v1/messages/{message_id}/seen`, but is otherwise
         * the same as [MessageServiceAsync.markAsSeen].
         */
        @MustBeClosed
        fun markAsSeen(messageId: String): CompletableFuture<HttpResponseFor<Message>> =
            markAsSeen(messageId, MessageMarkAsSeenParams.none())

        /** @see [markAsSeen] */
        @MustBeClosed
        fun markAsSeen(
            messageId: String,
            params: MessageMarkAsSeenParams = MessageMarkAsSeenParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>> =
            markAsSeen(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see [markAsSeen] */
        @MustBeClosed
        fun markAsSeen(
            messageId: String,
            params: MessageMarkAsSeenParams = MessageMarkAsSeenParams.none(),
        ): CompletableFuture<HttpResponseFor<Message>> =
            markAsSeen(messageId, params, RequestOptions.none())

        /** @see [markAsSeen] */
        @MustBeClosed
        fun markAsSeen(
            params: MessageMarkAsSeenParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>>

        /** @see [markAsSeen] */
        @MustBeClosed
        fun markAsSeen(
            params: MessageMarkAsSeenParams
        ): CompletableFuture<HttpResponseFor<Message>> = markAsSeen(params, RequestOptions.none())

        /** @see [markAsSeen] */
        @MustBeClosed
        fun markAsSeen(
            messageId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Message>> =
            markAsSeen(messageId, MessageMarkAsSeenParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/messages/{message_id}/read`, but is otherwise
         * the same as [MessageServiceAsync.markAsUnread].
         */
        @MustBeClosed
        fun markAsUnread(messageId: String): CompletableFuture<HttpResponseFor<Message>> =
            markAsUnread(messageId, MessageMarkAsUnreadParams.none())

        /** @see [markAsUnread] */
        @MustBeClosed
        fun markAsUnread(
            messageId: String,
            params: MessageMarkAsUnreadParams = MessageMarkAsUnreadParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>> =
            markAsUnread(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see [markAsUnread] */
        @MustBeClosed
        fun markAsUnread(
            messageId: String,
            params: MessageMarkAsUnreadParams = MessageMarkAsUnreadParams.none(),
        ): CompletableFuture<HttpResponseFor<Message>> =
            markAsUnread(messageId, params, RequestOptions.none())

        /** @see [markAsUnread] */
        @MustBeClosed
        fun markAsUnread(
            params: MessageMarkAsUnreadParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>>

        /** @see [markAsUnread] */
        @MustBeClosed
        fun markAsUnread(
            params: MessageMarkAsUnreadParams
        ): CompletableFuture<HttpResponseFor<Message>> = markAsUnread(params, RequestOptions.none())

        /** @see [markAsUnread] */
        @MustBeClosed
        fun markAsUnread(
            messageId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Message>> =
            markAsUnread(messageId, MessageMarkAsUnreadParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/messages/{message_id}/seen`, but is otherwise
         * the same as [MessageServiceAsync.markAsUnseen].
         */
        @MustBeClosed
        fun markAsUnseen(messageId: String): CompletableFuture<HttpResponseFor<Message>> =
            markAsUnseen(messageId, MessageMarkAsUnseenParams.none())

        /** @see [markAsUnseen] */
        @MustBeClosed
        fun markAsUnseen(
            messageId: String,
            params: MessageMarkAsUnseenParams = MessageMarkAsUnseenParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>> =
            markAsUnseen(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see [markAsUnseen] */
        @MustBeClosed
        fun markAsUnseen(
            messageId: String,
            params: MessageMarkAsUnseenParams = MessageMarkAsUnseenParams.none(),
        ): CompletableFuture<HttpResponseFor<Message>> =
            markAsUnseen(messageId, params, RequestOptions.none())

        /** @see [markAsUnseen] */
        @MustBeClosed
        fun markAsUnseen(
            params: MessageMarkAsUnseenParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>>

        /** @see [markAsUnseen] */
        @MustBeClosed
        fun markAsUnseen(
            params: MessageMarkAsUnseenParams
        ): CompletableFuture<HttpResponseFor<Message>> = markAsUnseen(params, RequestOptions.none())

        /** @see [markAsUnseen] */
        @MustBeClosed
        fun markAsUnseen(
            messageId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Message>> =
            markAsUnseen(messageId, MessageMarkAsUnseenParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/messages/{message_id}/archived`, but is
         * otherwise the same as [MessageServiceAsync.unarchive].
         */
        @MustBeClosed
        fun unarchive(messageId: String): CompletableFuture<HttpResponseFor<Message>> =
            unarchive(messageId, MessageUnarchiveParams.none())

        /** @see [unarchive] */
        @MustBeClosed
        fun unarchive(
            messageId: String,
            params: MessageUnarchiveParams = MessageUnarchiveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>> =
            unarchive(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see [unarchive] */
        @MustBeClosed
        fun unarchive(
            messageId: String,
            params: MessageUnarchiveParams = MessageUnarchiveParams.none(),
        ): CompletableFuture<HttpResponseFor<Message>> =
            unarchive(messageId, params, RequestOptions.none())

        /** @see [unarchive] */
        @MustBeClosed
        fun unarchive(
            params: MessageUnarchiveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Message>>

        /** @see [unarchive] */
        @MustBeClosed
        fun unarchive(params: MessageUnarchiveParams): CompletableFuture<HttpResponseFor<Message>> =
            unarchive(params, RequestOptions.none())

        /** @see [unarchive] */
        @MustBeClosed
        fun unarchive(
            messageId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Message>> =
            unarchive(messageId, MessageUnarchiveParams.none(), requestOptions)
    }
}
