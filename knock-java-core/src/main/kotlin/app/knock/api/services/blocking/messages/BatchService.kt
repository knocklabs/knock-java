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

    /** Marks one or more messages as archived */
    fun archive(): List<Message> = archive(BatchArchiveParams.none())

    /** @see [archive] */
    fun archive(
        params: BatchArchiveParams = BatchArchiveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Message>

    /** @see [archive] */
    fun archive(params: BatchArchiveParams = BatchArchiveParams.none()): List<Message> =
        archive(params, RequestOptions.none())

    /** @see [archive] */
    fun archive(requestOptions: RequestOptions): List<Message> =
        archive(BatchArchiveParams.none(), requestOptions)

    /** Get the contents of multiple messages */
    fun getContent(params: BatchGetContentParams): List<BatchGetContentResponse> =
        getContent(params, RequestOptions.none())

    /** @see [getContent] */
    fun getContent(
        params: BatchGetContentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<BatchGetContentResponse>

    /** Marks one or more messages as interacted */
    fun markAsInteracted(): List<Message> = markAsInteracted(BatchMarkAsInteractedParams.none())

    /** @see [markAsInteracted] */
    fun markAsInteracted(
        params: BatchMarkAsInteractedParams = BatchMarkAsInteractedParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Message>

    /** @see [markAsInteracted] */
    fun markAsInteracted(
        params: BatchMarkAsInteractedParams = BatchMarkAsInteractedParams.none()
    ): List<Message> = markAsInteracted(params, RequestOptions.none())

    /** @see [markAsInteracted] */
    fun markAsInteracted(requestOptions: RequestOptions): List<Message> =
        markAsInteracted(BatchMarkAsInteractedParams.none(), requestOptions)

    /** Marks one or more messages as read */
    fun markAsRead(): List<Message> = markAsRead(BatchMarkAsReadParams.none())

    /** @see [markAsRead] */
    fun markAsRead(
        params: BatchMarkAsReadParams = BatchMarkAsReadParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Message>

    /** @see [markAsRead] */
    fun markAsRead(params: BatchMarkAsReadParams = BatchMarkAsReadParams.none()): List<Message> =
        markAsRead(params, RequestOptions.none())

    /** @see [markAsRead] */
    fun markAsRead(requestOptions: RequestOptions): List<Message> =
        markAsRead(BatchMarkAsReadParams.none(), requestOptions)

    /** Marks one or more messages as seen */
    fun markAsSeen(): List<Message> = markAsSeen(BatchMarkAsSeenParams.none())

    /** @see [markAsSeen] */
    fun markAsSeen(
        params: BatchMarkAsSeenParams = BatchMarkAsSeenParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Message>

    /** @see [markAsSeen] */
    fun markAsSeen(params: BatchMarkAsSeenParams = BatchMarkAsSeenParams.none()): List<Message> =
        markAsSeen(params, RequestOptions.none())

    /** @see [markAsSeen] */
    fun markAsSeen(requestOptions: RequestOptions): List<Message> =
        markAsSeen(BatchMarkAsSeenParams.none(), requestOptions)

    /** Marks one or more messages as unread */
    fun markAsUnread(): List<Message> = markAsUnread(BatchMarkAsUnreadParams.none())

    /** @see [markAsUnread] */
    fun markAsUnread(
        params: BatchMarkAsUnreadParams = BatchMarkAsUnreadParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Message>

    /** @see [markAsUnread] */
    fun markAsUnread(
        params: BatchMarkAsUnreadParams = BatchMarkAsUnreadParams.none()
    ): List<Message> = markAsUnread(params, RequestOptions.none())

    /** @see [markAsUnread] */
    fun markAsUnread(requestOptions: RequestOptions): List<Message> =
        markAsUnread(BatchMarkAsUnreadParams.none(), requestOptions)

    /** Marks one or more messages as unseen */
    fun markAsUnseen(): List<Message> = markAsUnseen(BatchMarkAsUnseenParams.none())

    /** @see [markAsUnseen] */
    fun markAsUnseen(
        params: BatchMarkAsUnseenParams = BatchMarkAsUnseenParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Message>

    /** @see [markAsUnseen] */
    fun markAsUnseen(
        params: BatchMarkAsUnseenParams = BatchMarkAsUnseenParams.none()
    ): List<Message> = markAsUnseen(params, RequestOptions.none())

    /** @see [markAsUnseen] */
    fun markAsUnseen(requestOptions: RequestOptions): List<Message> =
        markAsUnseen(BatchMarkAsUnseenParams.none(), requestOptions)

    /** Marks one or more messages as unarchived */
    fun unarchive(): List<Message> = unarchive(BatchUnarchiveParams.none())

    /** @see [unarchive] */
    fun unarchive(
        params: BatchUnarchiveParams = BatchUnarchiveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Message>

    /** @see [unarchive] */
    fun unarchive(params: BatchUnarchiveParams = BatchUnarchiveParams.none()): List<Message> =
        unarchive(params, RequestOptions.none())

    /** @see [unarchive] */
    fun unarchive(requestOptions: RequestOptions): List<Message> =
        unarchive(BatchUnarchiveParams.none(), requestOptions)

    /** A view of [BatchService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/archived`, but is otherwise the
         * same as [BatchService.archive].
         */
        @MustBeClosed
        fun archive(): HttpResponseFor<List<Message>> = archive(BatchArchiveParams.none())

        /** @see [archive] */
        @MustBeClosed
        fun archive(
            params: BatchArchiveParams = BatchArchiveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Message>>

        /** @see [archive] */
        @MustBeClosed
        fun archive(
            params: BatchArchiveParams = BatchArchiveParams.none()
        ): HttpResponseFor<List<Message>> = archive(params, RequestOptions.none())

        /** @see [archive] */
        @MustBeClosed
        fun archive(requestOptions: RequestOptions): HttpResponseFor<List<Message>> =
            archive(BatchArchiveParams.none(), requestOptions)

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
        fun markAsInteracted(): HttpResponseFor<List<Message>> =
            markAsInteracted(BatchMarkAsInteractedParams.none())

        /** @see [markAsInteracted] */
        @MustBeClosed
        fun markAsInteracted(
            params: BatchMarkAsInteractedParams = BatchMarkAsInteractedParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Message>>

        /** @see [markAsInteracted] */
        @MustBeClosed
        fun markAsInteracted(
            params: BatchMarkAsInteractedParams = BatchMarkAsInteractedParams.none()
        ): HttpResponseFor<List<Message>> = markAsInteracted(params, RequestOptions.none())

        /** @see [markAsInteracted] */
        @MustBeClosed
        fun markAsInteracted(requestOptions: RequestOptions): HttpResponseFor<List<Message>> =
            markAsInteracted(BatchMarkAsInteractedParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/read`, but is otherwise the same
         * as [BatchService.markAsRead].
         */
        @MustBeClosed
        fun markAsRead(): HttpResponseFor<List<Message>> = markAsRead(BatchMarkAsReadParams.none())

        /** @see [markAsRead] */
        @MustBeClosed
        fun markAsRead(
            params: BatchMarkAsReadParams = BatchMarkAsReadParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Message>>

        /** @see [markAsRead] */
        @MustBeClosed
        fun markAsRead(
            params: BatchMarkAsReadParams = BatchMarkAsReadParams.none()
        ): HttpResponseFor<List<Message>> = markAsRead(params, RequestOptions.none())

        /** @see [markAsRead] */
        @MustBeClosed
        fun markAsRead(requestOptions: RequestOptions): HttpResponseFor<List<Message>> =
            markAsRead(BatchMarkAsReadParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/seen`, but is otherwise the same
         * as [BatchService.markAsSeen].
         */
        @MustBeClosed
        fun markAsSeen(): HttpResponseFor<List<Message>> = markAsSeen(BatchMarkAsSeenParams.none())

        /** @see [markAsSeen] */
        @MustBeClosed
        fun markAsSeen(
            params: BatchMarkAsSeenParams = BatchMarkAsSeenParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Message>>

        /** @see [markAsSeen] */
        @MustBeClosed
        fun markAsSeen(
            params: BatchMarkAsSeenParams = BatchMarkAsSeenParams.none()
        ): HttpResponseFor<List<Message>> = markAsSeen(params, RequestOptions.none())

        /** @see [markAsSeen] */
        @MustBeClosed
        fun markAsSeen(requestOptions: RequestOptions): HttpResponseFor<List<Message>> =
            markAsSeen(BatchMarkAsSeenParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/unread`, but is otherwise the
         * same as [BatchService.markAsUnread].
         */
        @MustBeClosed
        fun markAsUnread(): HttpResponseFor<List<Message>> =
            markAsUnread(BatchMarkAsUnreadParams.none())

        /** @see [markAsUnread] */
        @MustBeClosed
        fun markAsUnread(
            params: BatchMarkAsUnreadParams = BatchMarkAsUnreadParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Message>>

        /** @see [markAsUnread] */
        @MustBeClosed
        fun markAsUnread(
            params: BatchMarkAsUnreadParams = BatchMarkAsUnreadParams.none()
        ): HttpResponseFor<List<Message>> = markAsUnread(params, RequestOptions.none())

        /** @see [markAsUnread] */
        @MustBeClosed
        fun markAsUnread(requestOptions: RequestOptions): HttpResponseFor<List<Message>> =
            markAsUnread(BatchMarkAsUnreadParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/unseen`, but is otherwise the
         * same as [BatchService.markAsUnseen].
         */
        @MustBeClosed
        fun markAsUnseen(): HttpResponseFor<List<Message>> =
            markAsUnseen(BatchMarkAsUnseenParams.none())

        /** @see [markAsUnseen] */
        @MustBeClosed
        fun markAsUnseen(
            params: BatchMarkAsUnseenParams = BatchMarkAsUnseenParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Message>>

        /** @see [markAsUnseen] */
        @MustBeClosed
        fun markAsUnseen(
            params: BatchMarkAsUnseenParams = BatchMarkAsUnseenParams.none()
        ): HttpResponseFor<List<Message>> = markAsUnseen(params, RequestOptions.none())

        /** @see [markAsUnseen] */
        @MustBeClosed
        fun markAsUnseen(requestOptions: RequestOptions): HttpResponseFor<List<Message>> =
            markAsUnseen(BatchMarkAsUnseenParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/unarchived`, but is otherwise
         * the same as [BatchService.unarchive].
         */
        @MustBeClosed
        fun unarchive(): HttpResponseFor<List<Message>> = unarchive(BatchUnarchiveParams.none())

        /** @see [unarchive] */
        @MustBeClosed
        fun unarchive(
            params: BatchUnarchiveParams = BatchUnarchiveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Message>>

        /** @see [unarchive] */
        @MustBeClosed
        fun unarchive(
            params: BatchUnarchiveParams = BatchUnarchiveParams.none()
        ): HttpResponseFor<List<Message>> = unarchive(params, RequestOptions.none())

        /** @see [unarchive] */
        @MustBeClosed
        fun unarchive(requestOptions: RequestOptions): HttpResponseFor<List<Message>> =
            unarchive(BatchUnarchiveParams.none(), requestOptions)
    }
}
