// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async.messages

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.messages.activities.ActivityListPageAsync
import app.knock.api.models.messages.activities.ActivityListParams
import com.google.errorprone.annotations.MustBeClosed
import java.util.concurrent.CompletableFuture

interface ActivityServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Returns a paginated list of activities for the specified message. */
    fun list(messageId: String): CompletableFuture<ActivityListPageAsync> =
        list(messageId, ActivityListParams.none())

    /** @see [list] */
    fun list(
        messageId: String,
        params: ActivityListParams = ActivityListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ActivityListPageAsync> =
        list(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see [list] */
    fun list(
        messageId: String,
        params: ActivityListParams = ActivityListParams.none(),
    ): CompletableFuture<ActivityListPageAsync> = list(messageId, params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: ActivityListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ActivityListPageAsync>

    /** @see [list] */
    fun list(params: ActivityListParams): CompletableFuture<ActivityListPageAsync> =
        list(params, RequestOptions.none())

    /** @see [list] */
    fun list(
        messageId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ActivityListPageAsync> =
        list(messageId, ActivityListParams.none(), requestOptions)

    /**
     * A view of [ActivityServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /v1/messages/{message_id}/activities`, but is
         * otherwise the same as [ActivityServiceAsync.list].
         */
        @MustBeClosed
        fun list(messageId: String): CompletableFuture<HttpResponseFor<ActivityListPageAsync>> =
            list(messageId, ActivityListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            messageId: String,
            params: ActivityListParams = ActivityListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ActivityListPageAsync>> =
            list(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see [list] */
        @MustBeClosed
        fun list(
            messageId: String,
            params: ActivityListParams = ActivityListParams.none(),
        ): CompletableFuture<HttpResponseFor<ActivityListPageAsync>> =
            list(messageId, params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: ActivityListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ActivityListPageAsync>>

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: ActivityListParams
        ): CompletableFuture<HttpResponseFor<ActivityListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            messageId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ActivityListPageAsync>> =
            list(messageId, ActivityListParams.none(), requestOptions)
    }
}
