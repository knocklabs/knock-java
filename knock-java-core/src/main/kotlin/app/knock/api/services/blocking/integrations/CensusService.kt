// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking.integrations

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.integrations.census.CensusCustomDestinationParams
import app.knock.api.models.integrations.census.CensusCustomDestinationResponse
import com.google.errorprone.annotations.MustBeClosed

interface CensusService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Processes a Census custom destination RPC request. */
    fun customDestination(params: CensusCustomDestinationParams): CensusCustomDestinationResponse =
        customDestination(params, RequestOptions.none())

    /** @see [customDestination] */
    fun customDestination(
        params: CensusCustomDestinationParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CensusCustomDestinationResponse

    /** A view of [CensusService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/integrations/census/custom-destination`, but is
         * otherwise the same as [CensusService.customDestination].
         */
        @MustBeClosed
        fun customDestination(
            params: CensusCustomDestinationParams
        ): HttpResponseFor<CensusCustomDestinationResponse> =
            customDestination(params, RequestOptions.none())

        /** @see [customDestination] */
        @MustBeClosed
        fun customDestination(
            params: CensusCustomDestinationParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CensusCustomDestinationResponse>
    }
}
