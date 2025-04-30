// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking.messages

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.messages.activities.ActivityListPage
import app.knock.api.models.messages.activities.ActivityListParams
import com.google.errorprone.annotations.MustBeClosed

interface ActivityService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Returns a paginated list of activities for the specified message. */
    fun list(params: ActivityListParams): ActivityListPage = list(params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: ActivityListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ActivityListPage

    /** A view of [ActivityService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /v1/messages/{message_id}/activities`, but is
         * otherwise the same as [ActivityService.list].
         */
        @MustBeClosed
        fun list(params: ActivityListParams): HttpResponseFor<ActivityListPage> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: ActivityListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ActivityListPage>
    }
}
