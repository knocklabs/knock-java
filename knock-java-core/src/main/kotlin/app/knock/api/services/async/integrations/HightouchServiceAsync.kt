// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async.integrations

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.integrations.hightouch.HightouchEmbeddedDestinationParams
import app.knock.api.models.integrations.hightouch.HightouchEmbeddedDestinationResponse
import java.util.concurrent.CompletableFuture

interface HightouchServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Processes a Hightouch embedded destination RPC request. */
    fun embeddedDestination(
        params: HightouchEmbeddedDestinationParams
    ): CompletableFuture<HightouchEmbeddedDestinationResponse> =
        embeddedDestination(params, RequestOptions.none())

    /** @see [embeddedDestination] */
    fun embeddedDestination(
        params: HightouchEmbeddedDestinationParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<HightouchEmbeddedDestinationResponse>

    /**
     * A view of [HightouchServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/integrations/hightouch/embedded-destination`,
         * but is otherwise the same as [HightouchServiceAsync.embeddedDestination].
         */
        fun embeddedDestination(
            params: HightouchEmbeddedDestinationParams
        ): CompletableFuture<HttpResponseFor<HightouchEmbeddedDestinationResponse>> =
            embeddedDestination(params, RequestOptions.none())

        /** @see [embeddedDestination] */
        fun embeddedDestination(
            params: HightouchEmbeddedDestinationParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<HightouchEmbeddedDestinationResponse>>
    }
}
