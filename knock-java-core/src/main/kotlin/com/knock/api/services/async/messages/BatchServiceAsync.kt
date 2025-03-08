// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.async.messages

import com.google.errorprone.annotations.MustBeClosed
import com.knock.api.core.RequestOptions
import com.knock.api.core.http.HttpResponseFor
import com.knock.api.models.Message
import com.knock.api.models.MessageBatchArchiveParams
import com.knock.api.models.MessageBatchGetContentParams
import com.knock.api.models.MessageBatchMarkAsInteractedParams
import com.knock.api.models.MessageBatchMarkAsReadParams
import com.knock.api.models.MessageBatchMarkAsSeenParams
import com.knock.api.models.MessageBatchMarkAsUnreadParams
import com.knock.api.models.MessageBatchMarkAsUnseenParams
import com.knock.api.models.MessageBatchUnarchiveParams
import java.util.concurrent.CompletableFuture

interface BatchServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Mark messages as archived */
    fun archive(): CompletableFuture<List<Message>> = archive(MessageBatchArchiveParams.none())

    /** @see [archive] */
    fun archive(
        params: MessageBatchArchiveParams = MessageBatchArchiveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Message>>

    /** @see [archive] */
    fun archive(
        params: MessageBatchArchiveParams = MessageBatchArchiveParams.none()
    ): CompletableFuture<List<Message>> = archive(params, RequestOptions.none())

    /** @see [archive] */
    fun archive(requestOptions: RequestOptions): CompletableFuture<List<Message>> =
        archive(MessageBatchArchiveParams.none(), requestOptions)

    /** Get the contents of multiple messages in a single request. */
    fun getContent(params: MessageBatchGetContentParams): CompletableFuture<List<MessageContent>> =
        getContent(params, RequestOptions.none())

    /** @see [getContent] */
    fun getContent(
        params: MessageBatchGetContentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<MessageContent>>

    /** Mark messages as interacted */
    fun markAsInteracted(
        params: MessageBatchMarkAsInteractedParams
    ): CompletableFuture<List<Message>> = markAsInteracted(params, RequestOptions.none())

    /** @see [markAsInteracted] */
    fun markAsInteracted(
        params: MessageBatchMarkAsInteractedParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Message>>

    /** Mark messages as read */
    fun markAsRead(): CompletableFuture<List<Message>> =
        markAsRead(MessageBatchMarkAsReadParams.none())

    /** @see [markAsRead] */
    fun markAsRead(
        params: MessageBatchMarkAsReadParams = MessageBatchMarkAsReadParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Message>>

    /** @see [markAsRead] */
    fun markAsRead(
        params: MessageBatchMarkAsReadParams = MessageBatchMarkAsReadParams.none()
    ): CompletableFuture<List<Message>> = markAsRead(params, RequestOptions.none())

    /** @see [markAsRead] */
    fun markAsRead(requestOptions: RequestOptions): CompletableFuture<List<Message>> =
        markAsRead(MessageBatchMarkAsReadParams.none(), requestOptions)

    /** Mark messages as seen */
    fun markAsSeen(): CompletableFuture<List<Message>> =
        markAsSeen(MessageBatchMarkAsSeenParams.none())

    /** @see [markAsSeen] */
    fun markAsSeen(
        params: MessageBatchMarkAsSeenParams = MessageBatchMarkAsSeenParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Message>>

    /** @see [markAsSeen] */
    fun markAsSeen(
        params: MessageBatchMarkAsSeenParams = MessageBatchMarkAsSeenParams.none()
    ): CompletableFuture<List<Message>> = markAsSeen(params, RequestOptions.none())

    /** @see [markAsSeen] */
    fun markAsSeen(requestOptions: RequestOptions): CompletableFuture<List<Message>> =
        markAsSeen(MessageBatchMarkAsSeenParams.none(), requestOptions)

    /** Mark messages as unread */
    fun markAsUnread(): CompletableFuture<List<Message>> =
        markAsUnread(MessageBatchMarkAsUnreadParams.none())

    /** @see [markAsUnread] */
    fun markAsUnread(
        params: MessageBatchMarkAsUnreadParams = MessageBatchMarkAsUnreadParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Message>>

    /** @see [markAsUnread] */
    fun markAsUnread(
        params: MessageBatchMarkAsUnreadParams = MessageBatchMarkAsUnreadParams.none()
    ): CompletableFuture<List<Message>> = markAsUnread(params, RequestOptions.none())

    /** @see [markAsUnread] */
    fun markAsUnread(requestOptions: RequestOptions): CompletableFuture<List<Message>> =
        markAsUnread(MessageBatchMarkAsUnreadParams.none(), requestOptions)

    /** Mark messages as unseen */
    fun markAsUnseen(): CompletableFuture<List<Message>> =
        markAsUnseen(MessageBatchMarkAsUnseenParams.none())

    /** @see [markAsUnseen] */
    fun markAsUnseen(
        params: MessageBatchMarkAsUnseenParams = MessageBatchMarkAsUnseenParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Message>>

    /** @see [markAsUnseen] */
    fun markAsUnseen(
        params: MessageBatchMarkAsUnseenParams = MessageBatchMarkAsUnseenParams.none()
    ): CompletableFuture<List<Message>> = markAsUnseen(params, RequestOptions.none())

    /** @see [markAsUnseen] */
    fun markAsUnseen(requestOptions: RequestOptions): CompletableFuture<List<Message>> =
        markAsUnseen(MessageBatchMarkAsUnseenParams.none(), requestOptions)

    /** Mark messages as unarchived */
    fun unarchive(): CompletableFuture<List<Message>> =
        unarchive(MessageBatchUnarchiveParams.none())

    /** @see [unarchive] */
    fun unarchive(
        params: MessageBatchUnarchiveParams = MessageBatchUnarchiveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Message>>

    /** @see [unarchive] */
    fun unarchive(
        params: MessageBatchUnarchiveParams = MessageBatchUnarchiveParams.none()
    ): CompletableFuture<List<Message>> = unarchive(params, RequestOptions.none())

    /** @see [unarchive] */
    fun unarchive(requestOptions: RequestOptions): CompletableFuture<List<Message>> =
        unarchive(MessageBatchUnarchiveParams.none(), requestOptions)

    /** A view of [BatchServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/archived`, but is otherwise the
         * same as [BatchServiceAsync.archive].
         */
        @MustBeClosed
        fun archive(): CompletableFuture<HttpResponseFor<List<Message>>> =
            archive(MessageBatchArchiveParams.none())

        /** @see [archive] */
        @MustBeClosed
        fun archive(
            params: MessageBatchArchiveParams = MessageBatchArchiveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Message>>>

        /** @see [archive] */
        @MustBeClosed
        fun archive(
            params: MessageBatchArchiveParams = MessageBatchArchiveParams.none()
        ): CompletableFuture<HttpResponseFor<List<Message>>> =
            archive(params, RequestOptions.none())

        /** @see [archive] */
        @MustBeClosed
        fun archive(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<List<Message>>> =
            archive(MessageBatchArchiveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/messages/batch/content`, but is otherwise the
         * same as [BatchServiceAsync.getContent].
         */
        @MustBeClosed
        fun getContent(
            params: MessageBatchGetContentParams
        ): CompletableFuture<HttpResponseFor<List<MessageContent>>> =
            getContent(params, RequestOptions.none())

        /** @see [getContent] */
        @MustBeClosed
        fun getContent(
            params: MessageBatchGetContentParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<MessageContent>>>

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/interacted`, but is otherwise
         * the same as [BatchServiceAsync.markAsInteracted].
         */
        @MustBeClosed
        fun markAsInteracted(
            params: MessageBatchMarkAsInteractedParams
        ): CompletableFuture<HttpResponseFor<List<Message>>> =
            markAsInteracted(params, RequestOptions.none())

        /** @see [markAsInteracted] */
        @MustBeClosed
        fun markAsInteracted(
            params: MessageBatchMarkAsInteractedParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Message>>>

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/read`, but is otherwise the same
         * as [BatchServiceAsync.markAsRead].
         */
        @MustBeClosed
        fun markAsRead(): CompletableFuture<HttpResponseFor<List<Message>>> =
            markAsRead(MessageBatchMarkAsReadParams.none())

        /** @see [markAsRead] */
        @MustBeClosed
        fun markAsRead(
            params: MessageBatchMarkAsReadParams = MessageBatchMarkAsReadParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Message>>>

        /** @see [markAsRead] */
        @MustBeClosed
        fun markAsRead(
            params: MessageBatchMarkAsReadParams = MessageBatchMarkAsReadParams.none()
        ): CompletableFuture<HttpResponseFor<List<Message>>> =
            markAsRead(params, RequestOptions.none())

        /** @see [markAsRead] */
        @MustBeClosed
        fun markAsRead(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<List<Message>>> =
            markAsRead(MessageBatchMarkAsReadParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/seen`, but is otherwise the same
         * as [BatchServiceAsync.markAsSeen].
         */
        @MustBeClosed
        fun markAsSeen(): CompletableFuture<HttpResponseFor<List<Message>>> =
            markAsSeen(MessageBatchMarkAsSeenParams.none())

        /** @see [markAsSeen] */
        @MustBeClosed
        fun markAsSeen(
            params: MessageBatchMarkAsSeenParams = MessageBatchMarkAsSeenParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Message>>>

        /** @see [markAsSeen] */
        @MustBeClosed
        fun markAsSeen(
            params: MessageBatchMarkAsSeenParams = MessageBatchMarkAsSeenParams.none()
        ): CompletableFuture<HttpResponseFor<List<Message>>> =
            markAsSeen(params, RequestOptions.none())

        /** @see [markAsSeen] */
        @MustBeClosed
        fun markAsSeen(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<List<Message>>> =
            markAsSeen(MessageBatchMarkAsSeenParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/unread`, but is otherwise the
         * same as [BatchServiceAsync.markAsUnread].
         */
        @MustBeClosed
        fun markAsUnread(): CompletableFuture<HttpResponseFor<List<Message>>> =
            markAsUnread(MessageBatchMarkAsUnreadParams.none())

        /** @see [markAsUnread] */
        @MustBeClosed
        fun markAsUnread(
            params: MessageBatchMarkAsUnreadParams = MessageBatchMarkAsUnreadParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Message>>>

        /** @see [markAsUnread] */
        @MustBeClosed
        fun markAsUnread(
            params: MessageBatchMarkAsUnreadParams = MessageBatchMarkAsUnreadParams.none()
        ): CompletableFuture<HttpResponseFor<List<Message>>> =
            markAsUnread(params, RequestOptions.none())

        /** @see [markAsUnread] */
        @MustBeClosed
        fun markAsUnread(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<List<Message>>> =
            markAsUnread(MessageBatchMarkAsUnreadParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/unseen`, but is otherwise the
         * same as [BatchServiceAsync.markAsUnseen].
         */
        @MustBeClosed
        fun markAsUnseen(): CompletableFuture<HttpResponseFor<List<Message>>> =
            markAsUnseen(MessageBatchMarkAsUnseenParams.none())

        /** @see [markAsUnseen] */
        @MustBeClosed
        fun markAsUnseen(
            params: MessageBatchMarkAsUnseenParams = MessageBatchMarkAsUnseenParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Message>>>

        /** @see [markAsUnseen] */
        @MustBeClosed
        fun markAsUnseen(
            params: MessageBatchMarkAsUnseenParams = MessageBatchMarkAsUnseenParams.none()
        ): CompletableFuture<HttpResponseFor<List<Message>>> =
            markAsUnseen(params, RequestOptions.none())

        /** @see [markAsUnseen] */
        @MustBeClosed
        fun markAsUnseen(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<List<Message>>> =
            markAsUnseen(MessageBatchMarkAsUnseenParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/unarchived`, but is otherwise
         * the same as [BatchServiceAsync.unarchive].
         */
        @MustBeClosed
        fun unarchive(): CompletableFuture<HttpResponseFor<List<Message>>> =
            unarchive(MessageBatchUnarchiveParams.none())

        /** @see [unarchive] */
        @MustBeClosed
        fun unarchive(
            params: MessageBatchUnarchiveParams = MessageBatchUnarchiveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Message>>>

        /** @see [unarchive] */
        @MustBeClosed
        fun unarchive(
            params: MessageBatchUnarchiveParams = MessageBatchUnarchiveParams.none()
        ): CompletableFuture<HttpResponseFor<List<Message>>> =
            unarchive(params, RequestOptions.none())

        /** @see [unarchive] */
        @MustBeClosed
        fun unarchive(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<List<Message>>> =
            unarchive(MessageBatchUnarchiveParams.none(), requestOptions)
    }
}
