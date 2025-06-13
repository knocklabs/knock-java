// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async.channels

import app.knock.api.core.ClientOptions
import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.bulkoperations.BulkOperation
import app.knock.api.models.channels.bulk.BulkUpdateMessageStatusParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface BulkServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): BulkServiceAsync

    /**
     * Bulk update the status of messages for a specific channel. The channel is specified by the
     * `channel_id` parameter. The action to perform is specified by the `action` parameter, where
     * the action is a status change action (e.g. `archive`, `unarchive`).
     */
    fun updateMessageStatus(
        channelId: String,
        action: BulkUpdateMessageStatusParams.Action,
    ): CompletableFuture<BulkOperation> =
        updateMessageStatus(channelId, action, BulkUpdateMessageStatusParams.none())

    /** @see [updateMessageStatus] */
    fun updateMessageStatus(
        channelId: String,
        action: BulkUpdateMessageStatusParams.Action,
        params: BulkUpdateMessageStatusParams = BulkUpdateMessageStatusParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BulkOperation> =
        updateMessageStatus(
            params.toBuilder().channelId(channelId).action(action).build(),
            requestOptions,
        )

    /** @see [updateMessageStatus] */
    fun updateMessageStatus(
        channelId: String,
        action: BulkUpdateMessageStatusParams.Action,
        params: BulkUpdateMessageStatusParams = BulkUpdateMessageStatusParams.none(),
    ): CompletableFuture<BulkOperation> =
        updateMessageStatus(channelId, action, params, RequestOptions.none())

    /** @see [updateMessageStatus] */
    fun updateMessageStatus(
        params: BulkUpdateMessageStatusParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BulkOperation>

    /** @see [updateMessageStatus] */
    fun updateMessageStatus(
        params: BulkUpdateMessageStatusParams
    ): CompletableFuture<BulkOperation> = updateMessageStatus(params, RequestOptions.none())

    /** @see [updateMessageStatus] */
    fun updateMessageStatus(
        channelId: String,
        action: BulkUpdateMessageStatusParams.Action,
        requestOptions: RequestOptions,
    ): CompletableFuture<BulkOperation> =
        updateMessageStatus(channelId, action, BulkUpdateMessageStatusParams.none(), requestOptions)

    /** A view of [BulkServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): BulkServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/channels/{channel_id}/messages/bulk/{action}`,
         * but is otherwise the same as [BulkServiceAsync.updateMessageStatus].
         */
        fun updateMessageStatus(
            channelId: String,
            action: BulkUpdateMessageStatusParams.Action,
        ): CompletableFuture<HttpResponseFor<BulkOperation>> =
            updateMessageStatus(channelId, action, BulkUpdateMessageStatusParams.none())

        /** @see [updateMessageStatus] */
        fun updateMessageStatus(
            channelId: String,
            action: BulkUpdateMessageStatusParams.Action,
            params: BulkUpdateMessageStatusParams = BulkUpdateMessageStatusParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BulkOperation>> =
            updateMessageStatus(
                params.toBuilder().channelId(channelId).action(action).build(),
                requestOptions,
            )

        /** @see [updateMessageStatus] */
        fun updateMessageStatus(
            channelId: String,
            action: BulkUpdateMessageStatusParams.Action,
            params: BulkUpdateMessageStatusParams = BulkUpdateMessageStatusParams.none(),
        ): CompletableFuture<HttpResponseFor<BulkOperation>> =
            updateMessageStatus(channelId, action, params, RequestOptions.none())

        /** @see [updateMessageStatus] */
        fun updateMessageStatus(
            params: BulkUpdateMessageStatusParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BulkOperation>>

        /** @see [updateMessageStatus] */
        fun updateMessageStatus(
            params: BulkUpdateMessageStatusParams
        ): CompletableFuture<HttpResponseFor<BulkOperation>> =
            updateMessageStatus(params, RequestOptions.none())

        /** @see [updateMessageStatus] */
        fun updateMessageStatus(
            channelId: String,
            action: BulkUpdateMessageStatusParams.Action,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<BulkOperation>> =
            updateMessageStatus(
                channelId,
                action,
                BulkUpdateMessageStatusParams.none(),
                requestOptions,
            )
    }
}
