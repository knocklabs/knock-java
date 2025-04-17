// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async.messages

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
import java.util.concurrent.CompletableFuture

interface BatchServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Marks the given messages as archived. */
    fun archive(): CompletableFuture<List<Message>> = archive(BatchArchiveParams.none())

    /** @see [archive] */
    fun archive(
        params: BatchArchiveParams = BatchArchiveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Message>>

    /** @see [archive] */
    fun archive(
        params: BatchArchiveParams = BatchArchiveParams.none()
    ): CompletableFuture<List<Message>> = archive(params, RequestOptions.none())

    /** @see [archive] */
    fun archive(requestOptions: RequestOptions): CompletableFuture<List<Message>> =
        archive(BatchArchiveParams.none(), requestOptions)

    /** Get the contents of multiple messages in a single request. */
    fun getContent(
        params: BatchGetContentParams
    ): CompletableFuture<List<BatchGetContentResponse>> = getContent(params, RequestOptions.none())

    /** @see [getContent] */
    fun getContent(
        params: BatchGetContentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<BatchGetContentResponse>>

    /** Marks the given messages as interacted with. */
    fun markAsInteracted(params: BatchMarkAsInteractedParams): CompletableFuture<List<Message>> =
        markAsInteracted(params, RequestOptions.none())

    /** @see [markAsInteracted] */
    fun markAsInteracted(
        params: BatchMarkAsInteractedParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Message>>

    /** Marks the given messages as read. */
    fun markAsRead(): CompletableFuture<List<Message>> = markAsRead(BatchMarkAsReadParams.none())

    /** @see [markAsRead] */
    fun markAsRead(
        params: BatchMarkAsReadParams = BatchMarkAsReadParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Message>>

    /** @see [markAsRead] */
    fun markAsRead(
        params: BatchMarkAsReadParams = BatchMarkAsReadParams.none()
    ): CompletableFuture<List<Message>> = markAsRead(params, RequestOptions.none())

    /** @see [markAsRead] */
    fun markAsRead(requestOptions: RequestOptions): CompletableFuture<List<Message>> =
        markAsRead(BatchMarkAsReadParams.none(), requestOptions)

    /** Marks the given messages as seen. */
    fun markAsSeen(): CompletableFuture<List<Message>> = markAsSeen(BatchMarkAsSeenParams.none())

    /** @see [markAsSeen] */
    fun markAsSeen(
        params: BatchMarkAsSeenParams = BatchMarkAsSeenParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Message>>

    /** @see [markAsSeen] */
    fun markAsSeen(
        params: BatchMarkAsSeenParams = BatchMarkAsSeenParams.none()
    ): CompletableFuture<List<Message>> = markAsSeen(params, RequestOptions.none())

    /** @see [markAsSeen] */
    fun markAsSeen(requestOptions: RequestOptions): CompletableFuture<List<Message>> =
        markAsSeen(BatchMarkAsSeenParams.none(), requestOptions)

    /** Marks the given messages as unread. */
    fun markAsUnread(): CompletableFuture<List<Message>> =
        markAsUnread(BatchMarkAsUnreadParams.none())

    /** @see [markAsUnread] */
    fun markAsUnread(
        params: BatchMarkAsUnreadParams = BatchMarkAsUnreadParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Message>>

    /** @see [markAsUnread] */
    fun markAsUnread(
        params: BatchMarkAsUnreadParams = BatchMarkAsUnreadParams.none()
    ): CompletableFuture<List<Message>> = markAsUnread(params, RequestOptions.none())

    /** @see [markAsUnread] */
    fun markAsUnread(requestOptions: RequestOptions): CompletableFuture<List<Message>> =
        markAsUnread(BatchMarkAsUnreadParams.none(), requestOptions)

    /** Marks the given messages as unseen. */
    fun markAsUnseen(): CompletableFuture<List<Message>> =
        markAsUnseen(BatchMarkAsUnseenParams.none())

    /** @see [markAsUnseen] */
    fun markAsUnseen(
        params: BatchMarkAsUnseenParams = BatchMarkAsUnseenParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Message>>

    /** @see [markAsUnseen] */
    fun markAsUnseen(
        params: BatchMarkAsUnseenParams = BatchMarkAsUnseenParams.none()
    ): CompletableFuture<List<Message>> = markAsUnseen(params, RequestOptions.none())

    /** @see [markAsUnseen] */
    fun markAsUnseen(requestOptions: RequestOptions): CompletableFuture<List<Message>> =
        markAsUnseen(BatchMarkAsUnseenParams.none(), requestOptions)

    /** Marks the given messages as unarchived. */
    fun unarchive(): CompletableFuture<List<Message>> = unarchive(BatchUnarchiveParams.none())

    /** @see [unarchive] */
    fun unarchive(
        params: BatchUnarchiveParams = BatchUnarchiveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Message>>

    /** @see [unarchive] */
    fun unarchive(
        params: BatchUnarchiveParams = BatchUnarchiveParams.none()
    ): CompletableFuture<List<Message>> = unarchive(params, RequestOptions.none())

    /** @see [unarchive] */
    fun unarchive(requestOptions: RequestOptions): CompletableFuture<List<Message>> =
        unarchive(BatchUnarchiveParams.none(), requestOptions)

    /** A view of [BatchServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/archived`, but is otherwise the
         * same as [BatchServiceAsync.archive].
         */
        @MustBeClosed
        fun archive(): CompletableFuture<HttpResponseFor<List<Message>>> =
            archive(BatchArchiveParams.none())

        /** @see [archive] */
        @MustBeClosed
        fun archive(
            params: BatchArchiveParams = BatchArchiveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Message>>>

        /** @see [archive] */
        @MustBeClosed
        fun archive(
            params: BatchArchiveParams = BatchArchiveParams.none()
        ): CompletableFuture<HttpResponseFor<List<Message>>> =
            archive(params, RequestOptions.none())

        /** @see [archive] */
        @MustBeClosed
        fun archive(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<List<Message>>> =
            archive(BatchArchiveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/messages/batch/content`, but is otherwise the
         * same as [BatchServiceAsync.getContent].
         */
        @MustBeClosed
        fun getContent(
            params: BatchGetContentParams
        ): CompletableFuture<HttpResponseFor<List<BatchGetContentResponse>>> =
            getContent(params, RequestOptions.none())

        /** @see [getContent] */
        @MustBeClosed
        fun getContent(
            params: BatchGetContentParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<BatchGetContentResponse>>>

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/interacted`, but is otherwise
         * the same as [BatchServiceAsync.markAsInteracted].
         */
        @MustBeClosed
        fun markAsInteracted(
            params: BatchMarkAsInteractedParams
        ): CompletableFuture<HttpResponseFor<List<Message>>> =
            markAsInteracted(params, RequestOptions.none())

        /** @see [markAsInteracted] */
        @MustBeClosed
        fun markAsInteracted(
            params: BatchMarkAsInteractedParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Message>>>

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/read`, but is otherwise the same
         * as [BatchServiceAsync.markAsRead].
         */
        @MustBeClosed
        fun markAsRead(): CompletableFuture<HttpResponseFor<List<Message>>> =
            markAsRead(BatchMarkAsReadParams.none())

        /** @see [markAsRead] */
        @MustBeClosed
        fun markAsRead(
            params: BatchMarkAsReadParams = BatchMarkAsReadParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Message>>>

        /** @see [markAsRead] */
        @MustBeClosed
        fun markAsRead(
            params: BatchMarkAsReadParams = BatchMarkAsReadParams.none()
        ): CompletableFuture<HttpResponseFor<List<Message>>> =
            markAsRead(params, RequestOptions.none())

        /** @see [markAsRead] */
        @MustBeClosed
        fun markAsRead(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<List<Message>>> =
            markAsRead(BatchMarkAsReadParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/seen`, but is otherwise the same
         * as [BatchServiceAsync.markAsSeen].
         */
        @MustBeClosed
        fun markAsSeen(): CompletableFuture<HttpResponseFor<List<Message>>> =
            markAsSeen(BatchMarkAsSeenParams.none())

        /** @see [markAsSeen] */
        @MustBeClosed
        fun markAsSeen(
            params: BatchMarkAsSeenParams = BatchMarkAsSeenParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Message>>>

        /** @see [markAsSeen] */
        @MustBeClosed
        fun markAsSeen(
            params: BatchMarkAsSeenParams = BatchMarkAsSeenParams.none()
        ): CompletableFuture<HttpResponseFor<List<Message>>> =
            markAsSeen(params, RequestOptions.none())

        /** @see [markAsSeen] */
        @MustBeClosed
        fun markAsSeen(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<List<Message>>> =
            markAsSeen(BatchMarkAsSeenParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/unread`, but is otherwise the
         * same as [BatchServiceAsync.markAsUnread].
         */
        @MustBeClosed
        fun markAsUnread(): CompletableFuture<HttpResponseFor<List<Message>>> =
            markAsUnread(BatchMarkAsUnreadParams.none())

        /** @see [markAsUnread] */
        @MustBeClosed
        fun markAsUnread(
            params: BatchMarkAsUnreadParams = BatchMarkAsUnreadParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Message>>>

        /** @see [markAsUnread] */
        @MustBeClosed
        fun markAsUnread(
            params: BatchMarkAsUnreadParams = BatchMarkAsUnreadParams.none()
        ): CompletableFuture<HttpResponseFor<List<Message>>> =
            markAsUnread(params, RequestOptions.none())

        /** @see [markAsUnread] */
        @MustBeClosed
        fun markAsUnread(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<List<Message>>> =
            markAsUnread(BatchMarkAsUnreadParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/unseen`, but is otherwise the
         * same as [BatchServiceAsync.markAsUnseen].
         */
        @MustBeClosed
        fun markAsUnseen(): CompletableFuture<HttpResponseFor<List<Message>>> =
            markAsUnseen(BatchMarkAsUnseenParams.none())

        /** @see [markAsUnseen] */
        @MustBeClosed
        fun markAsUnseen(
            params: BatchMarkAsUnseenParams = BatchMarkAsUnseenParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Message>>>

        /** @see [markAsUnseen] */
        @MustBeClosed
        fun markAsUnseen(
            params: BatchMarkAsUnseenParams = BatchMarkAsUnseenParams.none()
        ): CompletableFuture<HttpResponseFor<List<Message>>> =
            markAsUnseen(params, RequestOptions.none())

        /** @see [markAsUnseen] */
        @MustBeClosed
        fun markAsUnseen(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<List<Message>>> =
            markAsUnseen(BatchMarkAsUnseenParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/unarchived`, but is otherwise
         * the same as [BatchServiceAsync.unarchive].
         */
        @MustBeClosed
        fun unarchive(): CompletableFuture<HttpResponseFor<List<Message>>> =
            unarchive(BatchUnarchiveParams.none())

        /** @see [unarchive] */
        @MustBeClosed
        fun unarchive(
            params: BatchUnarchiveParams = BatchUnarchiveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Message>>>

        /** @see [unarchive] */
        @MustBeClosed
        fun unarchive(
            params: BatchUnarchiveParams = BatchUnarchiveParams.none()
        ): CompletableFuture<HttpResponseFor<List<Message>>> =
            unarchive(params, RequestOptions.none())

        /** @see [unarchive] */
        @MustBeClosed
        fun unarchive(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<List<Message>>> =
            unarchive(BatchUnarchiveParams.none(), requestOptions)
    }
}
