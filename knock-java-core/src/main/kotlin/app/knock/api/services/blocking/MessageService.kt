// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking

import app.knock.api.core.ClientOptions
import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.messages.Message
import app.knock.api.models.messages.MessageArchiveParams
import app.knock.api.models.messages.MessageGetContentParams
import app.knock.api.models.messages.MessageGetContentResponse
import app.knock.api.models.messages.MessageGetParams
import app.knock.api.models.messages.MessageListActivitiesPage
import app.knock.api.models.messages.MessageListActivitiesParams
import app.knock.api.models.messages.MessageListDeliveryLogsPage
import app.knock.api.models.messages.MessageListDeliveryLogsParams
import app.knock.api.models.messages.MessageListEventsPage
import app.knock.api.models.messages.MessageListEventsParams
import app.knock.api.models.messages.MessageListPage
import app.knock.api.models.messages.MessageListParams
import app.knock.api.models.messages.MessageMarkAsInteractedParams
import app.knock.api.models.messages.MessageMarkAsReadParams
import app.knock.api.models.messages.MessageMarkAsSeenParams
import app.knock.api.models.messages.MessageMarkAsUnreadParams
import app.knock.api.models.messages.MessageMarkAsUnseenParams
import app.knock.api.models.messages.MessageUnarchiveParams
import app.knock.api.services.blocking.messages.BatchService
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface MessageService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): MessageService

    fun batch(): BatchService

    /** Returns a paginated list of messages for the current environment. */
    fun list(): MessageListPage = list(MessageListParams.none())

    /** @see [list] */
    fun list(
        params: MessageListParams = MessageListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageListPage

    /** @see [list] */
    fun list(params: MessageListParams = MessageListParams.none()): MessageListPage =
        list(params, RequestOptions.none())

    /** @see [list] */
    fun list(requestOptions: RequestOptions): MessageListPage =
        list(MessageListParams.none(), requestOptions)

    /**
     * Archives a message for the user. Archived messages are hidden from the default message list
     * in the feed but can still be accessed and unarchived later.
     */
    fun archive(messageId: String): Message = archive(messageId, MessageArchiveParams.none())

    /** @see [archive] */
    fun archive(
        messageId: String,
        params: MessageArchiveParams = MessageArchiveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Message = archive(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see [archive] */
    fun archive(
        messageId: String,
        params: MessageArchiveParams = MessageArchiveParams.none(),
    ): Message = archive(messageId, params, RequestOptions.none())

    /** @see [archive] */
    fun archive(
        params: MessageArchiveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Message

    /** @see [archive] */
    fun archive(params: MessageArchiveParams): Message = archive(params, RequestOptions.none())

    /** @see [archive] */
    fun archive(messageId: String, requestOptions: RequestOptions): Message =
        archive(messageId, MessageArchiveParams.none(), requestOptions)

    /** Retrieves a specific message by its ID. */
    fun get(messageId: String): Message = get(messageId, MessageGetParams.none())

    /** @see [get] */
    fun get(
        messageId: String,
        params: MessageGetParams = MessageGetParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Message = get(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see [get] */
    fun get(messageId: String, params: MessageGetParams = MessageGetParams.none()): Message =
        get(messageId, params, RequestOptions.none())

    /** @see [get] */
    fun get(
        params: MessageGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Message

    /** @see [get] */
    fun get(params: MessageGetParams): Message = get(params, RequestOptions.none())

    /** @see [get] */
    fun get(messageId: String, requestOptions: RequestOptions): Message =
        get(messageId, MessageGetParams.none(), requestOptions)

    /**
     * Returns the fully rendered contents of a message, where the response depends on which channel
     * the message was sent through.
     */
    fun getContent(messageId: String): MessageGetContentResponse =
        getContent(messageId, MessageGetContentParams.none())

    /** @see [getContent] */
    fun getContent(
        messageId: String,
        params: MessageGetContentParams = MessageGetContentParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageGetContentResponse =
        getContent(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see [getContent] */
    fun getContent(
        messageId: String,
        params: MessageGetContentParams = MessageGetContentParams.none(),
    ): MessageGetContentResponse = getContent(messageId, params, RequestOptions.none())

    /** @see [getContent] */
    fun getContent(
        params: MessageGetContentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageGetContentResponse

    /** @see [getContent] */
    fun getContent(params: MessageGetContentParams): MessageGetContentResponse =
        getContent(params, RequestOptions.none())

    /** @see [getContent] */
    fun getContent(messageId: String, requestOptions: RequestOptions): MessageGetContentResponse =
        getContent(messageId, MessageGetContentParams.none(), requestOptions)

    /** Returns a paginated list of activities for the specified message. */
    fun listActivities(messageId: String): MessageListActivitiesPage =
        listActivities(messageId, MessageListActivitiesParams.none())

    /** @see [listActivities] */
    fun listActivities(
        messageId: String,
        params: MessageListActivitiesParams = MessageListActivitiesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageListActivitiesPage =
        listActivities(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see [listActivities] */
    fun listActivities(
        messageId: String,
        params: MessageListActivitiesParams = MessageListActivitiesParams.none(),
    ): MessageListActivitiesPage = listActivities(messageId, params, RequestOptions.none())

    /** @see [listActivities] */
    fun listActivities(
        params: MessageListActivitiesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageListActivitiesPage

    /** @see [listActivities] */
    fun listActivities(params: MessageListActivitiesParams): MessageListActivitiesPage =
        listActivities(params, RequestOptions.none())

    /** @see [listActivities] */
    fun listActivities(
        messageId: String,
        requestOptions: RequestOptions,
    ): MessageListActivitiesPage =
        listActivities(messageId, MessageListActivitiesParams.none(), requestOptions)

    /** Returns a paginated list of delivery logs for the specified message. */
    fun listDeliveryLogs(messageId: String): MessageListDeliveryLogsPage =
        listDeliveryLogs(messageId, MessageListDeliveryLogsParams.none())

    /** @see [listDeliveryLogs] */
    fun listDeliveryLogs(
        messageId: String,
        params: MessageListDeliveryLogsParams = MessageListDeliveryLogsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageListDeliveryLogsPage =
        listDeliveryLogs(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see [listDeliveryLogs] */
    fun listDeliveryLogs(
        messageId: String,
        params: MessageListDeliveryLogsParams = MessageListDeliveryLogsParams.none(),
    ): MessageListDeliveryLogsPage = listDeliveryLogs(messageId, params, RequestOptions.none())

    /** @see [listDeliveryLogs] */
    fun listDeliveryLogs(
        params: MessageListDeliveryLogsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageListDeliveryLogsPage

    /** @see [listDeliveryLogs] */
    fun listDeliveryLogs(params: MessageListDeliveryLogsParams): MessageListDeliveryLogsPage =
        listDeliveryLogs(params, RequestOptions.none())

    /** @see [listDeliveryLogs] */
    fun listDeliveryLogs(
        messageId: String,
        requestOptions: RequestOptions,
    ): MessageListDeliveryLogsPage =
        listDeliveryLogs(messageId, MessageListDeliveryLogsParams.none(), requestOptions)

    /** Returns a paginated list of events for the specified message. */
    fun listEvents(messageId: String): MessageListEventsPage =
        listEvents(messageId, MessageListEventsParams.none())

    /** @see [listEvents] */
    fun listEvents(
        messageId: String,
        params: MessageListEventsParams = MessageListEventsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageListEventsPage =
        listEvents(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see [listEvents] */
    fun listEvents(
        messageId: String,
        params: MessageListEventsParams = MessageListEventsParams.none(),
    ): MessageListEventsPage = listEvents(messageId, params, RequestOptions.none())

    /** @see [listEvents] */
    fun listEvents(
        params: MessageListEventsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageListEventsPage

    /** @see [listEvents] */
    fun listEvents(params: MessageListEventsParams): MessageListEventsPage =
        listEvents(params, RequestOptions.none())

    /** @see [listEvents] */
    fun listEvents(messageId: String, requestOptions: RequestOptions): MessageListEventsPage =
        listEvents(messageId, MessageListEventsParams.none(), requestOptions)

    /**
     * Marks a message as `interacted` with by the user. This can include any user action on the
     * message, with optional metadata about the specific interaction. Cannot include more than 5
     * key-value pairs, must not contain nested data. Read more about message engagement statuses
     * [here](/send-notifications/message-statuses#engagement-status).
     */
    fun markAsInteracted(messageId: String): Message =
        markAsInteracted(messageId, MessageMarkAsInteractedParams.none())

    /** @see [markAsInteracted] */
    fun markAsInteracted(
        messageId: String,
        params: MessageMarkAsInteractedParams = MessageMarkAsInteractedParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Message = markAsInteracted(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see [markAsInteracted] */
    fun markAsInteracted(
        messageId: String,
        params: MessageMarkAsInteractedParams = MessageMarkAsInteractedParams.none(),
    ): Message = markAsInteracted(messageId, params, RequestOptions.none())

    /** @see [markAsInteracted] */
    fun markAsInteracted(
        params: MessageMarkAsInteractedParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Message

    /** @see [markAsInteracted] */
    fun markAsInteracted(params: MessageMarkAsInteractedParams): Message =
        markAsInteracted(params, RequestOptions.none())

    /** @see [markAsInteracted] */
    fun markAsInteracted(messageId: String, requestOptions: RequestOptions): Message =
        markAsInteracted(messageId, MessageMarkAsInteractedParams.none(), requestOptions)

    /**
     * Marks a message as `read`. This indicates that the user has read the message content. Read
     * more about message engagement statuses
     * [here](/send-notifications/message-statuses#engagement-status).
     */
    fun markAsRead(messageId: String): Message =
        markAsRead(messageId, MessageMarkAsReadParams.none())

    /** @see [markAsRead] */
    fun markAsRead(
        messageId: String,
        params: MessageMarkAsReadParams = MessageMarkAsReadParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Message = markAsRead(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see [markAsRead] */
    fun markAsRead(
        messageId: String,
        params: MessageMarkAsReadParams = MessageMarkAsReadParams.none(),
    ): Message = markAsRead(messageId, params, RequestOptions.none())

    /** @see [markAsRead] */
    fun markAsRead(
        params: MessageMarkAsReadParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Message

    /** @see [markAsRead] */
    fun markAsRead(params: MessageMarkAsReadParams): Message =
        markAsRead(params, RequestOptions.none())

    /** @see [markAsRead] */
    fun markAsRead(messageId: String, requestOptions: RequestOptions): Message =
        markAsRead(messageId, MessageMarkAsReadParams.none(), requestOptions)

    /**
     * Marks a message as `seen`. This indicates that the user has viewed the message in their feed
     * or inbox. Read more about message engagement statuses
     * [here](/send-notifications/message-statuses#engagement-status).
     */
    fun markAsSeen(messageId: String): Message =
        markAsSeen(messageId, MessageMarkAsSeenParams.none())

    /** @see [markAsSeen] */
    fun markAsSeen(
        messageId: String,
        params: MessageMarkAsSeenParams = MessageMarkAsSeenParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Message = markAsSeen(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see [markAsSeen] */
    fun markAsSeen(
        messageId: String,
        params: MessageMarkAsSeenParams = MessageMarkAsSeenParams.none(),
    ): Message = markAsSeen(messageId, params, RequestOptions.none())

    /** @see [markAsSeen] */
    fun markAsSeen(
        params: MessageMarkAsSeenParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Message

    /** @see [markAsSeen] */
    fun markAsSeen(params: MessageMarkAsSeenParams): Message =
        markAsSeen(params, RequestOptions.none())

    /** @see [markAsSeen] */
    fun markAsSeen(messageId: String, requestOptions: RequestOptions): Message =
        markAsSeen(messageId, MessageMarkAsSeenParams.none(), requestOptions)

    /**
     * Marks a message as `unread`. This reverses the `read` state. Read more about message
     * engagement statuses [here](/send-notifications/message-statuses#engagement-status).
     */
    fun markAsUnread(messageId: String): Message =
        markAsUnread(messageId, MessageMarkAsUnreadParams.none())

    /** @see [markAsUnread] */
    fun markAsUnread(
        messageId: String,
        params: MessageMarkAsUnreadParams = MessageMarkAsUnreadParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Message = markAsUnread(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see [markAsUnread] */
    fun markAsUnread(
        messageId: String,
        params: MessageMarkAsUnreadParams = MessageMarkAsUnreadParams.none(),
    ): Message = markAsUnread(messageId, params, RequestOptions.none())

    /** @see [markAsUnread] */
    fun markAsUnread(
        params: MessageMarkAsUnreadParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Message

    /** @see [markAsUnread] */
    fun markAsUnread(params: MessageMarkAsUnreadParams): Message =
        markAsUnread(params, RequestOptions.none())

    /** @see [markAsUnread] */
    fun markAsUnread(messageId: String, requestOptions: RequestOptions): Message =
        markAsUnread(messageId, MessageMarkAsUnreadParams.none(), requestOptions)

    /**
     * Marks a message as `unseen`. This reverses the `seen` state. Read more about message
     * engagement statuses [here](/send-notifications/message-statuses#engagement-status).
     */
    fun markAsUnseen(messageId: String): Message =
        markAsUnseen(messageId, MessageMarkAsUnseenParams.none())

    /** @see [markAsUnseen] */
    fun markAsUnseen(
        messageId: String,
        params: MessageMarkAsUnseenParams = MessageMarkAsUnseenParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Message = markAsUnseen(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see [markAsUnseen] */
    fun markAsUnseen(
        messageId: String,
        params: MessageMarkAsUnseenParams = MessageMarkAsUnseenParams.none(),
    ): Message = markAsUnseen(messageId, params, RequestOptions.none())

    /** @see [markAsUnseen] */
    fun markAsUnseen(
        params: MessageMarkAsUnseenParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Message

    /** @see [markAsUnseen] */
    fun markAsUnseen(params: MessageMarkAsUnseenParams): Message =
        markAsUnseen(params, RequestOptions.none())

    /** @see [markAsUnseen] */
    fun markAsUnseen(messageId: String, requestOptions: RequestOptions): Message =
        markAsUnseen(messageId, MessageMarkAsUnseenParams.none(), requestOptions)

    /**
     * Removes a message from the archived state, making it visible in the default message list in
     * the feed again.
     */
    fun unarchive(messageId: String): Message = unarchive(messageId, MessageUnarchiveParams.none())

    /** @see [unarchive] */
    fun unarchive(
        messageId: String,
        params: MessageUnarchiveParams = MessageUnarchiveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Message = unarchive(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see [unarchive] */
    fun unarchive(
        messageId: String,
        params: MessageUnarchiveParams = MessageUnarchiveParams.none(),
    ): Message = unarchive(messageId, params, RequestOptions.none())

    /** @see [unarchive] */
    fun unarchive(
        params: MessageUnarchiveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Message

    /** @see [unarchive] */
    fun unarchive(params: MessageUnarchiveParams): Message =
        unarchive(params, RequestOptions.none())

    /** @see [unarchive] */
    fun unarchive(messageId: String, requestOptions: RequestOptions): Message =
        unarchive(messageId, MessageUnarchiveParams.none(), requestOptions)

    /** A view of [MessageService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): MessageService.WithRawResponse

        fun batch(): BatchService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/messages`, but is otherwise the same as
         * [MessageService.list].
         */
        @MustBeClosed fun list(): HttpResponseFor<MessageListPage> = list(MessageListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: MessageListParams = MessageListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageListPage>

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: MessageListParams = MessageListParams.none()
        ): HttpResponseFor<MessageListPage> = list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<MessageListPage> =
            list(MessageListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put /v1/messages/{message_id}/archived`, but is
         * otherwise the same as [MessageService.archive].
         */
        @MustBeClosed
        fun archive(messageId: String): HttpResponseFor<Message> =
            archive(messageId, MessageArchiveParams.none())

        /** @see [archive] */
        @MustBeClosed
        fun archive(
            messageId: String,
            params: MessageArchiveParams = MessageArchiveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Message> =
            archive(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see [archive] */
        @MustBeClosed
        fun archive(
            messageId: String,
            params: MessageArchiveParams = MessageArchiveParams.none(),
        ): HttpResponseFor<Message> = archive(messageId, params, RequestOptions.none())

        /** @see [archive] */
        @MustBeClosed
        fun archive(
            params: MessageArchiveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Message>

        /** @see [archive] */
        @MustBeClosed
        fun archive(params: MessageArchiveParams): HttpResponseFor<Message> =
            archive(params, RequestOptions.none())

        /** @see [archive] */
        @MustBeClosed
        fun archive(messageId: String, requestOptions: RequestOptions): HttpResponseFor<Message> =
            archive(messageId, MessageArchiveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/messages/{message_id}`, but is otherwise the
         * same as [MessageService.get].
         */
        @MustBeClosed
        fun get(messageId: String): HttpResponseFor<Message> =
            get(messageId, MessageGetParams.none())

        /** @see [get] */
        @MustBeClosed
        fun get(
            messageId: String,
            params: MessageGetParams = MessageGetParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Message> =
            get(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see [get] */
        @MustBeClosed
        fun get(
            messageId: String,
            params: MessageGetParams = MessageGetParams.none(),
        ): HttpResponseFor<Message> = get(messageId, params, RequestOptions.none())

        /** @see [get] */
        @MustBeClosed
        fun get(
            params: MessageGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Message>

        /** @see [get] */
        @MustBeClosed
        fun get(params: MessageGetParams): HttpResponseFor<Message> =
            get(params, RequestOptions.none())

        /** @see [get] */
        @MustBeClosed
        fun get(messageId: String, requestOptions: RequestOptions): HttpResponseFor<Message> =
            get(messageId, MessageGetParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/messages/{message_id}/content`, but is otherwise
         * the same as [MessageService.getContent].
         */
        @MustBeClosed
        fun getContent(messageId: String): HttpResponseFor<MessageGetContentResponse> =
            getContent(messageId, MessageGetContentParams.none())

        /** @see [getContent] */
        @MustBeClosed
        fun getContent(
            messageId: String,
            params: MessageGetContentParams = MessageGetContentParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageGetContentResponse> =
            getContent(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see [getContent] */
        @MustBeClosed
        fun getContent(
            messageId: String,
            params: MessageGetContentParams = MessageGetContentParams.none(),
        ): HttpResponseFor<MessageGetContentResponse> =
            getContent(messageId, params, RequestOptions.none())

        /** @see [getContent] */
        @MustBeClosed
        fun getContent(
            params: MessageGetContentParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageGetContentResponse>

        /** @see [getContent] */
        @MustBeClosed
        fun getContent(
            params: MessageGetContentParams
        ): HttpResponseFor<MessageGetContentResponse> = getContent(params, RequestOptions.none())

        /** @see [getContent] */
        @MustBeClosed
        fun getContent(
            messageId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageGetContentResponse> =
            getContent(messageId, MessageGetContentParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/messages/{message_id}/activities`, but is
         * otherwise the same as [MessageService.listActivities].
         */
        @MustBeClosed
        fun listActivities(messageId: String): HttpResponseFor<MessageListActivitiesPage> =
            listActivities(messageId, MessageListActivitiesParams.none())

        /** @see [listActivities] */
        @MustBeClosed
        fun listActivities(
            messageId: String,
            params: MessageListActivitiesParams = MessageListActivitiesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageListActivitiesPage> =
            listActivities(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see [listActivities] */
        @MustBeClosed
        fun listActivities(
            messageId: String,
            params: MessageListActivitiesParams = MessageListActivitiesParams.none(),
        ): HttpResponseFor<MessageListActivitiesPage> =
            listActivities(messageId, params, RequestOptions.none())

        /** @see [listActivities] */
        @MustBeClosed
        fun listActivities(
            params: MessageListActivitiesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageListActivitiesPage>

        /** @see [listActivities] */
        @MustBeClosed
        fun listActivities(
            params: MessageListActivitiesParams
        ): HttpResponseFor<MessageListActivitiesPage> =
            listActivities(params, RequestOptions.none())

        /** @see [listActivities] */
        @MustBeClosed
        fun listActivities(
            messageId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageListActivitiesPage> =
            listActivities(messageId, MessageListActivitiesParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/messages/{message_id}/delivery_logs`, but is
         * otherwise the same as [MessageService.listDeliveryLogs].
         */
        @MustBeClosed
        fun listDeliveryLogs(messageId: String): HttpResponseFor<MessageListDeliveryLogsPage> =
            listDeliveryLogs(messageId, MessageListDeliveryLogsParams.none())

        /** @see [listDeliveryLogs] */
        @MustBeClosed
        fun listDeliveryLogs(
            messageId: String,
            params: MessageListDeliveryLogsParams = MessageListDeliveryLogsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageListDeliveryLogsPage> =
            listDeliveryLogs(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see [listDeliveryLogs] */
        @MustBeClosed
        fun listDeliveryLogs(
            messageId: String,
            params: MessageListDeliveryLogsParams = MessageListDeliveryLogsParams.none(),
        ): HttpResponseFor<MessageListDeliveryLogsPage> =
            listDeliveryLogs(messageId, params, RequestOptions.none())

        /** @see [listDeliveryLogs] */
        @MustBeClosed
        fun listDeliveryLogs(
            params: MessageListDeliveryLogsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageListDeliveryLogsPage>

        /** @see [listDeliveryLogs] */
        @MustBeClosed
        fun listDeliveryLogs(
            params: MessageListDeliveryLogsParams
        ): HttpResponseFor<MessageListDeliveryLogsPage> =
            listDeliveryLogs(params, RequestOptions.none())

        /** @see [listDeliveryLogs] */
        @MustBeClosed
        fun listDeliveryLogs(
            messageId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageListDeliveryLogsPage> =
            listDeliveryLogs(messageId, MessageListDeliveryLogsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/messages/{message_id}/events`, but is otherwise
         * the same as [MessageService.listEvents].
         */
        @MustBeClosed
        fun listEvents(messageId: String): HttpResponseFor<MessageListEventsPage> =
            listEvents(messageId, MessageListEventsParams.none())

        /** @see [listEvents] */
        @MustBeClosed
        fun listEvents(
            messageId: String,
            params: MessageListEventsParams = MessageListEventsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageListEventsPage> =
            listEvents(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see [listEvents] */
        @MustBeClosed
        fun listEvents(
            messageId: String,
            params: MessageListEventsParams = MessageListEventsParams.none(),
        ): HttpResponseFor<MessageListEventsPage> =
            listEvents(messageId, params, RequestOptions.none())

        /** @see [listEvents] */
        @MustBeClosed
        fun listEvents(
            params: MessageListEventsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageListEventsPage>

        /** @see [listEvents] */
        @MustBeClosed
        fun listEvents(params: MessageListEventsParams): HttpResponseFor<MessageListEventsPage> =
            listEvents(params, RequestOptions.none())

        /** @see [listEvents] */
        @MustBeClosed
        fun listEvents(
            messageId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageListEventsPage> =
            listEvents(messageId, MessageListEventsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put /v1/messages/{message_id}/interacted`, but is
         * otherwise the same as [MessageService.markAsInteracted].
         */
        @MustBeClosed
        fun markAsInteracted(messageId: String): HttpResponseFor<Message> =
            markAsInteracted(messageId, MessageMarkAsInteractedParams.none())

        /** @see [markAsInteracted] */
        @MustBeClosed
        fun markAsInteracted(
            messageId: String,
            params: MessageMarkAsInteractedParams = MessageMarkAsInteractedParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Message> =
            markAsInteracted(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see [markAsInteracted] */
        @MustBeClosed
        fun markAsInteracted(
            messageId: String,
            params: MessageMarkAsInteractedParams = MessageMarkAsInteractedParams.none(),
        ): HttpResponseFor<Message> = markAsInteracted(messageId, params, RequestOptions.none())

        /** @see [markAsInteracted] */
        @MustBeClosed
        fun markAsInteracted(
            params: MessageMarkAsInteractedParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Message>

        /** @see [markAsInteracted] */
        @MustBeClosed
        fun markAsInteracted(params: MessageMarkAsInteractedParams): HttpResponseFor<Message> =
            markAsInteracted(params, RequestOptions.none())

        /** @see [markAsInteracted] */
        @MustBeClosed
        fun markAsInteracted(
            messageId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Message> =
            markAsInteracted(messageId, MessageMarkAsInteractedParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put /v1/messages/{message_id}/read`, but is otherwise
         * the same as [MessageService.markAsRead].
         */
        @MustBeClosed
        fun markAsRead(messageId: String): HttpResponseFor<Message> =
            markAsRead(messageId, MessageMarkAsReadParams.none())

        /** @see [markAsRead] */
        @MustBeClosed
        fun markAsRead(
            messageId: String,
            params: MessageMarkAsReadParams = MessageMarkAsReadParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Message> =
            markAsRead(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see [markAsRead] */
        @MustBeClosed
        fun markAsRead(
            messageId: String,
            params: MessageMarkAsReadParams = MessageMarkAsReadParams.none(),
        ): HttpResponseFor<Message> = markAsRead(messageId, params, RequestOptions.none())

        /** @see [markAsRead] */
        @MustBeClosed
        fun markAsRead(
            params: MessageMarkAsReadParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Message>

        /** @see [markAsRead] */
        @MustBeClosed
        fun markAsRead(params: MessageMarkAsReadParams): HttpResponseFor<Message> =
            markAsRead(params, RequestOptions.none())

        /** @see [markAsRead] */
        @MustBeClosed
        fun markAsRead(
            messageId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Message> =
            markAsRead(messageId, MessageMarkAsReadParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put /v1/messages/{message_id}/seen`, but is otherwise
         * the same as [MessageService.markAsSeen].
         */
        @MustBeClosed
        fun markAsSeen(messageId: String): HttpResponseFor<Message> =
            markAsSeen(messageId, MessageMarkAsSeenParams.none())

        /** @see [markAsSeen] */
        @MustBeClosed
        fun markAsSeen(
            messageId: String,
            params: MessageMarkAsSeenParams = MessageMarkAsSeenParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Message> =
            markAsSeen(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see [markAsSeen] */
        @MustBeClosed
        fun markAsSeen(
            messageId: String,
            params: MessageMarkAsSeenParams = MessageMarkAsSeenParams.none(),
        ): HttpResponseFor<Message> = markAsSeen(messageId, params, RequestOptions.none())

        /** @see [markAsSeen] */
        @MustBeClosed
        fun markAsSeen(
            params: MessageMarkAsSeenParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Message>

        /** @see [markAsSeen] */
        @MustBeClosed
        fun markAsSeen(params: MessageMarkAsSeenParams): HttpResponseFor<Message> =
            markAsSeen(params, RequestOptions.none())

        /** @see [markAsSeen] */
        @MustBeClosed
        fun markAsSeen(
            messageId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Message> =
            markAsSeen(messageId, MessageMarkAsSeenParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/messages/{message_id}/read`, but is otherwise
         * the same as [MessageService.markAsUnread].
         */
        @MustBeClosed
        fun markAsUnread(messageId: String): HttpResponseFor<Message> =
            markAsUnread(messageId, MessageMarkAsUnreadParams.none())

        /** @see [markAsUnread] */
        @MustBeClosed
        fun markAsUnread(
            messageId: String,
            params: MessageMarkAsUnreadParams = MessageMarkAsUnreadParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Message> =
            markAsUnread(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see [markAsUnread] */
        @MustBeClosed
        fun markAsUnread(
            messageId: String,
            params: MessageMarkAsUnreadParams = MessageMarkAsUnreadParams.none(),
        ): HttpResponseFor<Message> = markAsUnread(messageId, params, RequestOptions.none())

        /** @see [markAsUnread] */
        @MustBeClosed
        fun markAsUnread(
            params: MessageMarkAsUnreadParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Message>

        /** @see [markAsUnread] */
        @MustBeClosed
        fun markAsUnread(params: MessageMarkAsUnreadParams): HttpResponseFor<Message> =
            markAsUnread(params, RequestOptions.none())

        /** @see [markAsUnread] */
        @MustBeClosed
        fun markAsUnread(
            messageId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Message> =
            markAsUnread(messageId, MessageMarkAsUnreadParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/messages/{message_id}/seen`, but is otherwise
         * the same as [MessageService.markAsUnseen].
         */
        @MustBeClosed
        fun markAsUnseen(messageId: String): HttpResponseFor<Message> =
            markAsUnseen(messageId, MessageMarkAsUnseenParams.none())

        /** @see [markAsUnseen] */
        @MustBeClosed
        fun markAsUnseen(
            messageId: String,
            params: MessageMarkAsUnseenParams = MessageMarkAsUnseenParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Message> =
            markAsUnseen(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see [markAsUnseen] */
        @MustBeClosed
        fun markAsUnseen(
            messageId: String,
            params: MessageMarkAsUnseenParams = MessageMarkAsUnseenParams.none(),
        ): HttpResponseFor<Message> = markAsUnseen(messageId, params, RequestOptions.none())

        /** @see [markAsUnseen] */
        @MustBeClosed
        fun markAsUnseen(
            params: MessageMarkAsUnseenParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Message>

        /** @see [markAsUnseen] */
        @MustBeClosed
        fun markAsUnseen(params: MessageMarkAsUnseenParams): HttpResponseFor<Message> =
            markAsUnseen(params, RequestOptions.none())

        /** @see [markAsUnseen] */
        @MustBeClosed
        fun markAsUnseen(
            messageId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Message> =
            markAsUnseen(messageId, MessageMarkAsUnseenParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/messages/{message_id}/archived`, but is
         * otherwise the same as [MessageService.unarchive].
         */
        @MustBeClosed
        fun unarchive(messageId: String): HttpResponseFor<Message> =
            unarchive(messageId, MessageUnarchiveParams.none())

        /** @see [unarchive] */
        @MustBeClosed
        fun unarchive(
            messageId: String,
            params: MessageUnarchiveParams = MessageUnarchiveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Message> =
            unarchive(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see [unarchive] */
        @MustBeClosed
        fun unarchive(
            messageId: String,
            params: MessageUnarchiveParams = MessageUnarchiveParams.none(),
        ): HttpResponseFor<Message> = unarchive(messageId, params, RequestOptions.none())

        /** @see [unarchive] */
        @MustBeClosed
        fun unarchive(
            params: MessageUnarchiveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Message>

        /** @see [unarchive] */
        @MustBeClosed
        fun unarchive(params: MessageUnarchiveParams): HttpResponseFor<Message> =
            unarchive(params, RequestOptions.none())

        /** @see [unarchive] */
        @MustBeClosed
        fun unarchive(messageId: String, requestOptions: RequestOptions): HttpResponseFor<Message> =
            unarchive(messageId, MessageUnarchiveParams.none(), requestOptions)
    }
}
