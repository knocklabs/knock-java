// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking

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

interface MessageService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

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
     * Archives a message for the current user. Archived messages are hidden from the default
     * message list but can still be accessed and unarchived later.
     */
    fun archive(params: MessageArchiveParams): Message = archive(params, RequestOptions.none())

    /** @see [archive] */
    fun archive(
        params: MessageArchiveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Message

    /** Retrieves a specific message by its ID. */
    fun get(params: MessageGetParams): Message = get(params, RequestOptions.none())

    /** @see [get] */
    fun get(
        params: MessageGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Message

    /**
     * Returns the fully rendered contents of a message, where the response depends on which channel
     * the message was sent through.
     */
    fun getContent(params: MessageGetContentParams): MessageGetContentResponse =
        getContent(params, RequestOptions.none())

    /** @see [getContent] */
    fun getContent(
        params: MessageGetContentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageGetContentResponse

    /** Returns a paginated list of activities for the specified message. */
    fun listActivities(params: MessageListActivitiesParams): MessageListActivitiesPage =
        listActivities(params, RequestOptions.none())

    /** @see [listActivities] */
    fun listActivities(
        params: MessageListActivitiesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageListActivitiesPage

    /** Returns a paginated list of delivery logs for the specified message. */
    fun listDeliveryLogs(params: MessageListDeliveryLogsParams): MessageListDeliveryLogsPage =
        listDeliveryLogs(params, RequestOptions.none())

    /** @see [listDeliveryLogs] */
    fun listDeliveryLogs(
        params: MessageListDeliveryLogsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageListDeliveryLogsPage

    /** Returns a paginated list of events for the specified message. */
    fun listEvents(params: MessageListEventsParams): MessageListEventsPage =
        listEvents(params, RequestOptions.none())

    /** @see [listEvents] */
    fun listEvents(
        params: MessageListEventsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageListEventsPage

    /**
     * Marks a message as interacted with by the current user. This can include any user action on
     * the message, with optional metadata about the specific interaction.
     */
    fun markAsInteracted(params: MessageMarkAsInteractedParams): Message =
        markAsInteracted(params, RequestOptions.none())

    /** @see [markAsInteracted] */
    fun markAsInteracted(
        params: MessageMarkAsInteractedParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Message

    /**
     * Marks a message as read for the current user. This indicates that the user has read the
     * message content.
     */
    fun markAsRead(params: MessageMarkAsReadParams): Message =
        markAsRead(params, RequestOptions.none())

    /** @see [markAsRead] */
    fun markAsRead(
        params: MessageMarkAsReadParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Message

    /**
     * Marks a message as seen for the current user. This indicates that the user has viewed the
     * message in their feed or inbox.
     */
    fun markAsSeen(params: MessageMarkAsSeenParams): Message =
        markAsSeen(params, RequestOptions.none())

    /** @see [markAsSeen] */
    fun markAsSeen(
        params: MessageMarkAsSeenParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Message

    /** Marks a message as unread for the current user, reversing the read state. */
    fun markAsUnread(params: MessageMarkAsUnreadParams): Message =
        markAsUnread(params, RequestOptions.none())

    /** @see [markAsUnread] */
    fun markAsUnread(
        params: MessageMarkAsUnreadParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Message

    /** Marks a message as unseen for the current user, reversing the seen state. */
    fun markAsUnseen(params: MessageMarkAsUnseenParams): Message =
        markAsUnseen(params, RequestOptions.none())

    /** @see [markAsUnseen] */
    fun markAsUnseen(
        params: MessageMarkAsUnseenParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Message

    /**
     * Removes a message from the archived state, making it visible in the default message list
     * again.
     */
    fun unarchive(params: MessageUnarchiveParams): Message =
        unarchive(params, RequestOptions.none())

    /** @see [unarchive] */
    fun unarchive(
        params: MessageUnarchiveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Message

    /** A view of [MessageService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

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
        fun archive(params: MessageArchiveParams): HttpResponseFor<Message> =
            archive(params, RequestOptions.none())

        /** @see [archive] */
        @MustBeClosed
        fun archive(
            params: MessageArchiveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Message>

        /**
         * Returns a raw HTTP response for `get /v1/messages/{message_id}`, but is otherwise the
         * same as [MessageService.get].
         */
        @MustBeClosed
        fun get(params: MessageGetParams): HttpResponseFor<Message> =
            get(params, RequestOptions.none())

        /** @see [get] */
        @MustBeClosed
        fun get(
            params: MessageGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Message>

        /**
         * Returns a raw HTTP response for `get /v1/messages/{message_id}/content`, but is otherwise
         * the same as [MessageService.getContent].
         */
        @MustBeClosed
        fun getContent(
            params: MessageGetContentParams
        ): HttpResponseFor<MessageGetContentResponse> = getContent(params, RequestOptions.none())

        /** @see [getContent] */
        @MustBeClosed
        fun getContent(
            params: MessageGetContentParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageGetContentResponse>

        /**
         * Returns a raw HTTP response for `get /v1/messages/{message_id}/activities`, but is
         * otherwise the same as [MessageService.listActivities].
         */
        @MustBeClosed
        fun listActivities(
            params: MessageListActivitiesParams
        ): HttpResponseFor<MessageListActivitiesPage> =
            listActivities(params, RequestOptions.none())

        /** @see [listActivities] */
        @MustBeClosed
        fun listActivities(
            params: MessageListActivitiesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageListActivitiesPage>

        /**
         * Returns a raw HTTP response for `get /v1/messages/{message_id}/delivery_logs`, but is
         * otherwise the same as [MessageService.listDeliveryLogs].
         */
        @MustBeClosed
        fun listDeliveryLogs(
            params: MessageListDeliveryLogsParams
        ): HttpResponseFor<MessageListDeliveryLogsPage> =
            listDeliveryLogs(params, RequestOptions.none())

        /** @see [listDeliveryLogs] */
        @MustBeClosed
        fun listDeliveryLogs(
            params: MessageListDeliveryLogsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageListDeliveryLogsPage>

        /**
         * Returns a raw HTTP response for `get /v1/messages/{message_id}/events`, but is otherwise
         * the same as [MessageService.listEvents].
         */
        @MustBeClosed
        fun listEvents(params: MessageListEventsParams): HttpResponseFor<MessageListEventsPage> =
            listEvents(params, RequestOptions.none())

        /** @see [listEvents] */
        @MustBeClosed
        fun listEvents(
            params: MessageListEventsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageListEventsPage>

        /**
         * Returns a raw HTTP response for `put /v1/messages/{message_id}/interacted`, but is
         * otherwise the same as [MessageService.markAsInteracted].
         */
        @MustBeClosed
        fun markAsInteracted(params: MessageMarkAsInteractedParams): HttpResponseFor<Message> =
            markAsInteracted(params, RequestOptions.none())

        /** @see [markAsInteracted] */
        @MustBeClosed
        fun markAsInteracted(
            params: MessageMarkAsInteractedParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Message>

        /**
         * Returns a raw HTTP response for `put /v1/messages/{message_id}/read`, but is otherwise
         * the same as [MessageService.markAsRead].
         */
        @MustBeClosed
        fun markAsRead(params: MessageMarkAsReadParams): HttpResponseFor<Message> =
            markAsRead(params, RequestOptions.none())

        /** @see [markAsRead] */
        @MustBeClosed
        fun markAsRead(
            params: MessageMarkAsReadParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Message>

        /**
         * Returns a raw HTTP response for `put /v1/messages/{message_id}/seen`, but is otherwise
         * the same as [MessageService.markAsSeen].
         */
        @MustBeClosed
        fun markAsSeen(params: MessageMarkAsSeenParams): HttpResponseFor<Message> =
            markAsSeen(params, RequestOptions.none())

        /** @see [markAsSeen] */
        @MustBeClosed
        fun markAsSeen(
            params: MessageMarkAsSeenParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Message>

        /**
         * Returns a raw HTTP response for `delete /v1/messages/{message_id}/unread`, but is
         * otherwise the same as [MessageService.markAsUnread].
         */
        @MustBeClosed
        fun markAsUnread(params: MessageMarkAsUnreadParams): HttpResponseFor<Message> =
            markAsUnread(params, RequestOptions.none())

        /** @see [markAsUnread] */
        @MustBeClosed
        fun markAsUnread(
            params: MessageMarkAsUnreadParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Message>

        /**
         * Returns a raw HTTP response for `delete /v1/messages/{message_id}/unseen`, but is
         * otherwise the same as [MessageService.markAsUnseen].
         */
        @MustBeClosed
        fun markAsUnseen(params: MessageMarkAsUnseenParams): HttpResponseFor<Message> =
            markAsUnseen(params, RequestOptions.none())

        /** @see [markAsUnseen] */
        @MustBeClosed
        fun markAsUnseen(
            params: MessageMarkAsUnseenParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Message>

        /**
         * Returns a raw HTTP response for `delete /v1/messages/{message_id}/unarchived`, but is
         * otherwise the same as [MessageService.unarchive].
         */
        @MustBeClosed
        fun unarchive(params: MessageUnarchiveParams): HttpResponseFor<Message> =
            unarchive(params, RequestOptions.none())

        /** @see [unarchive] */
        @MustBeClosed
        fun unarchive(
            params: MessageUnarchiveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Message>
    }
}
