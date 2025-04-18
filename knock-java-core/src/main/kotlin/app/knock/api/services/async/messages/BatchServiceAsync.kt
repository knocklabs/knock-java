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
    fun archive(params: BatchArchiveParams): CompletableFuture<List<Message>> =
        archive(params, RequestOptions.none())

    /** @see [archive] */
    fun archive(
        params: BatchArchiveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Message>>

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
    fun markAsRead(params: BatchMarkAsReadParams): CompletableFuture<List<Message>> =
        markAsRead(params, RequestOptions.none())

    /** @see [markAsRead] */
    fun markAsRead(
        params: BatchMarkAsReadParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Message>>

    /** Marks the given messages as seen. */
    fun markAsSeen(params: BatchMarkAsSeenParams): CompletableFuture<List<Message>> =
        markAsSeen(params, RequestOptions.none())

    /** @see [markAsSeen] */
    fun markAsSeen(
        params: BatchMarkAsSeenParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Message>>

    /** Marks the given messages as unread. */
    fun markAsUnread(params: BatchMarkAsUnreadParams): CompletableFuture<List<Message>> =
        markAsUnread(params, RequestOptions.none())

    /** @see [markAsUnread] */
    fun markAsUnread(
        params: BatchMarkAsUnreadParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Message>>

    /** Marks the given messages as unseen. */
    fun markAsUnseen(params: BatchMarkAsUnseenParams): CompletableFuture<List<Message>> =
        markAsUnseen(params, RequestOptions.none())

    /** @see [markAsUnseen] */
    fun markAsUnseen(
        params: BatchMarkAsUnseenParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Message>>

    /** Marks the given messages as unarchived. */
    fun unarchive(params: BatchUnarchiveParams): CompletableFuture<List<Message>> =
        unarchive(params, RequestOptions.none())

    /** @see [unarchive] */
    fun unarchive(
        params: BatchUnarchiveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Message>>

    /** A view of [BatchServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/archived`, but is otherwise the
         * same as [BatchServiceAsync.archive].
         */
        @MustBeClosed
        fun archive(params: BatchArchiveParams): CompletableFuture<HttpResponseFor<List<Message>>> =
            archive(params, RequestOptions.none())

        /** @see [archive] */
        @MustBeClosed
        fun archive(
            params: BatchArchiveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Message>>>

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
        fun markAsRead(
            params: BatchMarkAsReadParams
        ): CompletableFuture<HttpResponseFor<List<Message>>> =
            markAsRead(params, RequestOptions.none())

        /** @see [markAsRead] */
        @MustBeClosed
        fun markAsRead(
            params: BatchMarkAsReadParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Message>>>

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/seen`, but is otherwise the same
         * as [BatchServiceAsync.markAsSeen].
         */
        @MustBeClosed
        fun markAsSeen(
            params: BatchMarkAsSeenParams
        ): CompletableFuture<HttpResponseFor<List<Message>>> =
            markAsSeen(params, RequestOptions.none())

        /** @see [markAsSeen] */
        @MustBeClosed
        fun markAsSeen(
            params: BatchMarkAsSeenParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Message>>>

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/unread`, but is otherwise the
         * same as [BatchServiceAsync.markAsUnread].
         */
        @MustBeClosed
        fun markAsUnread(
            params: BatchMarkAsUnreadParams
        ): CompletableFuture<HttpResponseFor<List<Message>>> =
            markAsUnread(params, RequestOptions.none())

        /** @see [markAsUnread] */
        @MustBeClosed
        fun markAsUnread(
            params: BatchMarkAsUnreadParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Message>>>

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/unseen`, but is otherwise the
         * same as [BatchServiceAsync.markAsUnseen].
         */
        @MustBeClosed
        fun markAsUnseen(
            params: BatchMarkAsUnseenParams
        ): CompletableFuture<HttpResponseFor<List<Message>>> =
            markAsUnseen(params, RequestOptions.none())

        /** @see [markAsUnseen] */
        @MustBeClosed
        fun markAsUnseen(
            params: BatchMarkAsUnseenParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Message>>>

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/unarchived`, but is otherwise
         * the same as [BatchServiceAsync.unarchive].
         */
        @MustBeClosed
        fun unarchive(
            params: BatchUnarchiveParams
        ): CompletableFuture<HttpResponseFor<List<Message>>> =
            unarchive(params, RequestOptions.none())

        /** @see [unarchive] */
        @MustBeClosed
        fun unarchive(
            params: BatchUnarchiveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Message>>>
    }
}
