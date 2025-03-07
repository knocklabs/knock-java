// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.knock.api.services.async.messages

import com.google.errorprone.annotations.MustBeClosed
import com.knock.api.core.RequestOptions
import com.knock.api.core.http.HttpResponseFor
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
    @JvmOverloads
    fun archive(
        params: MessageBatchArchiveParams = MessageBatchArchiveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Message>>

    /** Mark messages as archived */
    fun archive(requestOptions: RequestOptions): CompletableFuture<List<Message>> =
        archive(MessageBatchArchiveParams.none(), requestOptions)

    /** Get the contents of multiple messages in a single request. */
    @JvmOverloads
    fun getContent(
        params: MessageBatchGetContentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<MessageContent>>

    /** Mark messages as interacted */
    @JvmOverloads
    fun markAsInteracted(
        params: MessageBatchMarkAsInteractedParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Message>>

    /** Mark messages as read */
    @JvmOverloads
    fun markAsRead(
        params: MessageBatchMarkAsReadParams = MessageBatchMarkAsReadParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Message>>

    /** Mark messages as read */
    fun markAsRead(requestOptions: RequestOptions): CompletableFuture<List<Message>> =
        markAsRead(MessageBatchMarkAsReadParams.none(), requestOptions)

    /** Mark messages as seen */
    @JvmOverloads
    fun markAsSeen(
        params: MessageBatchMarkAsSeenParams = MessageBatchMarkAsSeenParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Message>>

    /** Mark messages as seen */
    fun markAsSeen(requestOptions: RequestOptions): CompletableFuture<List<Message>> =
        markAsSeen(MessageBatchMarkAsSeenParams.none(), requestOptions)

    /** Mark messages as unread */
    @JvmOverloads
    fun markAsUnread(
        params: MessageBatchMarkAsUnreadParams = MessageBatchMarkAsUnreadParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Message>>

    /** Mark messages as unread */
    fun markAsUnread(requestOptions: RequestOptions): CompletableFuture<List<Message>> =
        markAsUnread(MessageBatchMarkAsUnreadParams.none(), requestOptions)

    /** Mark messages as unseen */
    @JvmOverloads
    fun markAsUnseen(
        params: MessageBatchMarkAsUnseenParams = MessageBatchMarkAsUnseenParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Message>>

    /** Mark messages as unseen */
    fun markAsUnseen(requestOptions: RequestOptions): CompletableFuture<List<Message>> =
        markAsUnseen(MessageBatchMarkAsUnseenParams.none(), requestOptions)

    /** Mark messages as unarchived */
    @JvmOverloads
    fun unarchive(
        params: MessageBatchUnarchiveParams = MessageBatchUnarchiveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Message>>

    /** Mark messages as unarchived */
    fun unarchive(requestOptions: RequestOptions): CompletableFuture<List<Message>> =
        unarchive(MessageBatchUnarchiveParams.none(), requestOptions)

    /** A view of [BatchServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/archived`, but is otherwise the
         * same as [BatchServiceAsync.archive].
         */
        @JvmOverloads
        @MustBeClosed
        fun archive(
            params: MessageBatchArchiveParams = MessageBatchArchiveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Message>>>

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/archived`, but is otherwise the
         * same as [BatchServiceAsync.archive].
         */
        @MustBeClosed
        fun archive(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<List<Message>>> =
            archive(MessageBatchArchiveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/messages/batch/content`, but is otherwise the
         * same as [BatchServiceAsync.getContent].
         */
        @JvmOverloads
        @MustBeClosed
        fun getContent(
            params: MessageBatchGetContentParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<MessageContent>>>

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/interacted`, but is otherwise
         * the same as [BatchServiceAsync.markAsInteracted].
         */
        @JvmOverloads
        @MustBeClosed
        fun markAsInteracted(
            params: MessageBatchMarkAsInteractedParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Message>>>

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/read`, but is otherwise the same
         * as [BatchServiceAsync.markAsRead].
         */
        @JvmOverloads
        @MustBeClosed
        fun markAsRead(
            params: MessageBatchMarkAsReadParams = MessageBatchMarkAsReadParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Message>>>

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/read`, but is otherwise the same
         * as [BatchServiceAsync.markAsRead].
         */
        @MustBeClosed
        fun markAsRead(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<List<Message>>> =
            markAsRead(MessageBatchMarkAsReadParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/seen`, but is otherwise the same
         * as [BatchServiceAsync.markAsSeen].
         */
        @JvmOverloads
        @MustBeClosed
        fun markAsSeen(
            params: MessageBatchMarkAsSeenParams = MessageBatchMarkAsSeenParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Message>>>

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/seen`, but is otherwise the same
         * as [BatchServiceAsync.markAsSeen].
         */
        @MustBeClosed
        fun markAsSeen(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<List<Message>>> =
            markAsSeen(MessageBatchMarkAsSeenParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/unread`, but is otherwise the
         * same as [BatchServiceAsync.markAsUnread].
         */
        @JvmOverloads
        @MustBeClosed
        fun markAsUnread(
            params: MessageBatchMarkAsUnreadParams = MessageBatchMarkAsUnreadParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Message>>>

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/unread`, but is otherwise the
         * same as [BatchServiceAsync.markAsUnread].
         */
        @MustBeClosed
        fun markAsUnread(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<List<Message>>> =
            markAsUnread(MessageBatchMarkAsUnreadParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/unseen`, but is otherwise the
         * same as [BatchServiceAsync.markAsUnseen].
         */
        @JvmOverloads
        @MustBeClosed
        fun markAsUnseen(
            params: MessageBatchMarkAsUnseenParams = MessageBatchMarkAsUnseenParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Message>>>

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/unseen`, but is otherwise the
         * same as [BatchServiceAsync.markAsUnseen].
         */
        @MustBeClosed
        fun markAsUnseen(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<List<Message>>> =
            markAsUnseen(MessageBatchMarkAsUnseenParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/unarchived`, but is otherwise
         * the same as [BatchServiceAsync.unarchive].
         */
        @JvmOverloads
        @MustBeClosed
        fun unarchive(
            params: MessageBatchUnarchiveParams = MessageBatchUnarchiveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Message>>>

        /**
         * Returns a raw HTTP response for `post /v1/messages/batch/unarchived`, but is otherwise
         * the same as [BatchServiceAsync.unarchive].
         */
        @MustBeClosed
        fun unarchive(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<List<Message>>> =
            unarchive(MessageBatchUnarchiveParams.none(), requestOptions)
    }
}
