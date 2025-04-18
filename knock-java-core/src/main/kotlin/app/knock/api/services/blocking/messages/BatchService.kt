// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking.messages

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

interface BatchService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Marks the given messages as archived. */
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

    /** Marks the given messages as interacted with. */
    fun markAsInteracted(params: BatchMarkAsInteractedParams): List<Message> =
        markAsInteracted(params, RequestOptions.none())

    /** @see [markAsInteracted] */
    fun markAsInteracted(
        params: BatchMarkAsInteractedParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Message>

    /** Marks the given messages as read. */
    fun markAsRead(params: BatchMarkAsReadParams): List<Message> =
        markAsRead(params, RequestOptions.none())

    /** @see [markAsRead] */
    fun markAsRead(
        params: BatchMarkAsReadParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Message>

    /** Marks the given messages as seen. */
    fun markAsSeen(params: BatchMarkAsSeenParams): List<Message> =
        markAsSeen(params, RequestOptions.none())

    /** @see [markAsSeen] */
    fun markAsSeen(
        params: BatchMarkAsSeenParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Message>

    /** Marks the given messages as unread. */
    fun markAsUnread(params: BatchMarkAsUnreadParams): List<Message> =
        markAsUnread(params, RequestOptions.none())

    /** @see [markAsUnread] */
    fun markAsUnread(
        params: BatchMarkAsUnreadParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Message>

    /** Marks the given messages as unseen. */
    fun markAsUnseen(params: BatchMarkAsUnseenParams): List<Message> =
        markAsUnseen(params, RequestOptions.none())

    /** @see [markAsUnseen] */
    fun markAsUnseen(
        params: BatchMarkAsUnseenParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Message>

    /** Marks the given messages as unarchived. */
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
