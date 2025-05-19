// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async.integrations

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.integrations.census.CensusCustomDestinationParams
import app.knock.api.models.integrations.census.CensusCustomDestinationResponse
import com.google.errorprone.annotations.MustBeClosed
import java.util.concurrent.CompletableFuture

interface CensusServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Processes a Census custom destination RPC request. */
    fun customDestination(
        params: CensusCustomDestinationParams
    ): CompletableFuture<CensusCustomDestinationResponse> =
        customDestination(params, RequestOptions.none())

    /** @see [customDestination] */
    fun customDestination(
        params: CensusCustomDestinationParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CensusCustomDestinationResponse>

    /**
     * A view of [CensusServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/integrations/census/custom-destination`, but is
         * otherwise the same as [CensusServiceAsync.customDestination].
         */
        @MustBeClosed
        fun customDestination(
            params: CensusCustomDestinationParams
        ): CompletableFuture<HttpResponseFor<CensusCustomDestinationResponse>> =
            customDestination(params, RequestOptions.none())

        /** @see [customDestination] */
        @MustBeClosed
        fun customDestination(
            params: CensusCustomDestinationParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CensusCustomDestinationResponse>>
    }
}
