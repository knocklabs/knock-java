// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async.messages

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.messages.activities.ActivityListParams
import app.knock.api.models.messages.activities.ActivityListResponse
import com.google.errorprone.annotations.MustBeClosed
import java.util.concurrent.CompletableFuture

interface ActivityServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Returns a paginated list of activities for the specified message. */
    fun list(params: ActivityListParams): CompletableFuture<ActivityListResponse> =
        list(params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: ActivityListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ActivityListResponse>

    /**
     * A view of [ActivityServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /v1/messages/{message_id}/activities`, but is
         * otherwise the same as [ActivityServiceAsync.list].
         */
        @MustBeClosed
        fun list(
            params: ActivityListParams
        ): CompletableFuture<HttpResponseFor<ActivityListResponse>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: ActivityListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ActivityListResponse>>
    }
}
