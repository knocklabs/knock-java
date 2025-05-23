// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking.channels

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.bulkoperations.BulkOperation
import app.knock.api.models.channels.bulk.BulkUpdateMessageStatusParams
import com.google.errorprone.annotations.MustBeClosed

interface BulkService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Bulk update the status of messages for a specific channel. The channel is specified by the
     * `channel_id` parameter. The action to perform is specified by the `action` parameter, where
     * the action is a status change action (e.g. `archive`, `unarchive`).
     */
    fun updateMessageStatus(
        channelId: String,
        action: BulkUpdateMessageStatusParams.Action,
    ): BulkOperation = updateMessageStatus(channelId, action, BulkUpdateMessageStatusParams.none())

    /** @see [updateMessageStatus] */
    fun updateMessageStatus(
        channelId: String,
        action: BulkUpdateMessageStatusParams.Action,
        params: BulkUpdateMessageStatusParams = BulkUpdateMessageStatusParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BulkOperation =
        updateMessageStatus(
            params.toBuilder().channelId(channelId).action(action).build(),
            requestOptions,
        )

    /** @see [updateMessageStatus] */
    fun updateMessageStatus(
        channelId: String,
        action: BulkUpdateMessageStatusParams.Action,
        params: BulkUpdateMessageStatusParams = BulkUpdateMessageStatusParams.none(),
    ): BulkOperation = updateMessageStatus(channelId, action, params, RequestOptions.none())

    /** @see [updateMessageStatus] */
    fun updateMessageStatus(
        params: BulkUpdateMessageStatusParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BulkOperation

    /** @see [updateMessageStatus] */
    fun updateMessageStatus(params: BulkUpdateMessageStatusParams): BulkOperation =
        updateMessageStatus(params, RequestOptions.none())

    /** @see [updateMessageStatus] */
    fun updateMessageStatus(
        channelId: String,
        action: BulkUpdateMessageStatusParams.Action,
        requestOptions: RequestOptions,
    ): BulkOperation =
        updateMessageStatus(channelId, action, BulkUpdateMessageStatusParams.none(), requestOptions)

    /** A view of [BulkService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/channels/{channel_id}/messages/bulk/{action}`,
         * but is otherwise the same as [BulkService.updateMessageStatus].
         */
        @MustBeClosed
        fun updateMessageStatus(
            channelId: String,
            action: BulkUpdateMessageStatusParams.Action,
        ): HttpResponseFor<BulkOperation> =
            updateMessageStatus(channelId, action, BulkUpdateMessageStatusParams.none())

        /** @see [updateMessageStatus] */
        @MustBeClosed
        fun updateMessageStatus(
            channelId: String,
            action: BulkUpdateMessageStatusParams.Action,
            params: BulkUpdateMessageStatusParams = BulkUpdateMessageStatusParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BulkOperation> =
            updateMessageStatus(
                params.toBuilder().channelId(channelId).action(action).build(),
                requestOptions,
            )

        /** @see [updateMessageStatus] */
        @MustBeClosed
        fun updateMessageStatus(
            channelId: String,
            action: BulkUpdateMessageStatusParams.Action,
            params: BulkUpdateMessageStatusParams = BulkUpdateMessageStatusParams.none(),
        ): HttpResponseFor<BulkOperation> =
            updateMessageStatus(channelId, action, params, RequestOptions.none())

        /** @see [updateMessageStatus] */
        @MustBeClosed
        fun updateMessageStatus(
            params: BulkUpdateMessageStatusParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BulkOperation>

        /** @see [updateMessageStatus] */
        @MustBeClosed
        fun updateMessageStatus(
            params: BulkUpdateMessageStatusParams
        ): HttpResponseFor<BulkOperation> = updateMessageStatus(params, RequestOptions.none())

        /** @see [updateMessageStatus] */
        @MustBeClosed
        fun updateMessageStatus(
            channelId: String,
            action: BulkUpdateMessageStatusParams.Action,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BulkOperation> =
            updateMessageStatus(
                channelId,
                action,
                BulkUpdateMessageStatusParams.none(),
                requestOptions,
            )
    }
}
