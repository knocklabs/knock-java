// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking.messages

import app.knock.api.core.ClientOptions
import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.messages.Message
import app.knock.api.models.messages.batch.BatchArchiveParams
import app.knock.api.models.messages.batch.BatchGetContentParams
import app.knock.api.models.messages.batch.BatchGetContentResponse
import app.knock.api.models.messages.batch.BatchMarkAsInteractedParams
import app.knock.api.models.messages.batch.BatchMarkAsReadParams
import app.knock.api.models.messages.batch.BatchMarkAsSeenParams
import app.knock.api.models.messages.batch.BatchMarkAsUnreadParams
import app.knock.api.models.messages.batch.BatchMarkAsUnseenParams
import app.knock.api.models.messages.batch.BatchUnarchiveParams
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface BatchService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): BatchService

    /**
     * Marks the given messages as archived. Archived messages are hidden from the default message
     * list in the feed but can still be accessed and unarchived later.
     */
    fun archive(params: BatchArchiveParams): List<Message> = archive(params, RequestOptions.none())

    /** @see [archive] */
    fun archive(
        params: BatchArchiveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Message>

    /** Get the contents of multiple messages in a single request. */
    fun getContent(params: BatchGetContentParams): List<BatchGetContentResponse> =
        getContent(params, RequestOptions.none())

    /** @see [getContent] */
    fun getContent(
        params: BatchGetContentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<BatchGetContentResponse>

    /**
     * Marks the given messages as interacted with by the user. This can include any user action on
     * the message, with optional metadata about the specific interaction. Cannot include more than
     * 5 key-value pairs, must not contain nested data. Read more about message engagement statuses
     * [here](/send-notifications/message-statuses#engagement-status).
     */
    fun markAsInteracted(params: BatchMarkAsInteractedParams): List<Message> =
        markAsInteracted(params, RequestOptions.none())

    /** @see [markAsInteracted] */
    fun markAsInteracted(
        params: BatchMarkAsInteractedParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Message>

    /**
     * Marks the given messages as `read`. Read more about message engagement statuses
     * [here](/send-notifications/message-statuses#engagement-status).
     */
    fun markAsRead(params: BatchMarkAsReadParams): List<Message> =
        markAsRead(params, RequestOptions.none())

    /** @see [markAsRead] */
    fun markAsRead(
        params: BatchMarkAsReadParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Message>

    /**
     * Marks the given messages as `seen`. This indicates that the user has viewed the message in
     * their feed or inbox. Read more about message engagement statuses
     * [here](/send-notifications/message-statuses#engagement-status).
     */
    fun markAsSeen(params: BatchMarkAsSeenParams): List<Message> =
        markAsSeen(params, RequestOptions.none())

    /** @see [markAsSeen] */
    fun markAsSeen(
        params: BatchMarkAsSeenParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Message>

    /**
     * Marks the given messages as `unread`. This reverses the `read` state. Read more about message
     * engagement statuses [here](/send-notifications/message-statuses#engagement-status).
     */
    fun markAsUnread(params: BatchMarkAsUnreadParams): List<Message> =
        markAsUnread(params, RequestOptions.none())

    /** @see [markAsUnread] */
    fun markAsUnread(
        params: BatchMarkAsUnreadParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Message>

    /**
     * Marks the given messages as `unseen`. This reverses the `seen` state. Read more about message
     * engagement statuses [here](/send-notifications/message-statuses#engagement-status).
     */
    fun markAsUnseen(params: BatchMarkAsUnseenParams): List<Message> =
        markAsUnseen(params, RequestOptions.none())

    /** @see [markAsUnseen] */
    fun markAsUnseen(
        params: BatchMarkAsUnseenParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Message>

    /**
     * Marks the given messages as unarchived. This reverses the `archived` state. Archived messages
     * are hidden from the default message list in the feed but can still be accessed and unarchived
     * later.
     */
    fun unarchive(params: BatchUnarchiveParams): List<Message> =
        unarchive(params, RequestOptions.none())

    /** @see [unarchive] */
    fun unarchive(
        params: BatchUnarchiveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Message>

    /** A view of [BatchService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): BatchService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/archived`, but is otherwise the
         * same as [BatchService.archive].
         */
        @MustBeClosed
        fun archive(params: BatchArchiveParams): HttpResponseFor<List<Message>> =
            archive(params, RequestOptions.none())

        /** @see [archive] */
        @MustBeClosed
        fun archive(
            params: BatchArchiveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Message>>

        /**
         * Returns a raw HTTP response for `get /v1/messages/batch/content`, but is otherwise the
         * same as [BatchService.getContent].
         */
        @MustBeClosed
        fun getContent(
            params: BatchGetContentParams
        ): HttpResponseFor<List<BatchGetContentResponse>> =
            getContent(params, RequestOptions.none())

        /** @see [getContent] */
        @MustBeClosed
        fun getContent(
            params: BatchGetContentParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<BatchGetContentResponse>>

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/interacted`, but is otherwise
         * the same as [BatchService.markAsInteracted].
         */
        @MustBeClosed
        fun markAsInteracted(params: BatchMarkAsInteractedParams): HttpResponseFor<List<Message>> =
            markAsInteracted(params, RequestOptions.none())

        /** @see [markAsInteracted] */
        @MustBeClosed
        fun markAsInteracted(
            params: BatchMarkAsInteractedParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Message>>

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/read`, but is otherwise the same
         * as [BatchService.markAsRead].
         */
        @MustBeClosed
        fun markAsRead(params: BatchMarkAsReadParams): HttpResponseFor<List<Message>> =
            markAsRead(params, RequestOptions.none())

        /** @see [markAsRead] */
        @MustBeClosed
        fun markAsRead(
            params: BatchMarkAsReadParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Message>>

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/seen`, but is otherwise the same
         * as [BatchService.markAsSeen].
         */
        @MustBeClosed
        fun markAsSeen(params: BatchMarkAsSeenParams): HttpResponseFor<List<Message>> =
            markAsSeen(params, RequestOptions.none())

        /** @see [markAsSeen] */
        @MustBeClosed
        fun markAsSeen(
            params: BatchMarkAsSeenParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Message>>

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/unread`, but is otherwise the
         * same as [BatchService.markAsUnread].
         */
        @MustBeClosed
        fun markAsUnread(params: BatchMarkAsUnreadParams): HttpResponseFor<List<Message>> =
            markAsUnread(params, RequestOptions.none())

        /** @see [markAsUnread] */
        @MustBeClosed
        fun markAsUnread(
            params: BatchMarkAsUnreadParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Message>>

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/unseen`, but is otherwise the
         * same as [BatchService.markAsUnseen].
         */
        @MustBeClosed
        fun markAsUnseen(params: BatchMarkAsUnseenParams): HttpResponseFor<List<Message>> =
            markAsUnseen(params, RequestOptions.none())

        /** @see [markAsUnseen] */
        @MustBeClosed
        fun markAsUnseen(
            params: BatchMarkAsUnseenParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Message>>

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/unarchived`, but is otherwise
         * the same as [BatchService.unarchive].
         */
        @MustBeClosed
        fun unarchive(params: BatchUnarchiveParams): HttpResponseFor<List<Message>> =
            unarchive(params, RequestOptions.none())

        /** @see [unarchive] */
        @MustBeClosed
        fun unarchive(
            params: BatchUnarchiveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Message>>
    }
}
