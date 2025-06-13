// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking.integrations

import app.knock.api.core.ClientOptions
import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.integrations.hightouch.HightouchEmbeddedDestinationParams
import app.knock.api.models.integrations.hightouch.HightouchEmbeddedDestinationResponse
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface HightouchService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): HightouchService

    /** Processes a Hightouch embedded destination RPC request. */
    fun embeddedDestination(
        params: HightouchEmbeddedDestinationParams
    ): HightouchEmbeddedDestinationResponse = embeddedDestination(params, RequestOptions.none())

    /** @see [embeddedDestination] */
    fun embeddedDestination(
        params: HightouchEmbeddedDestinationParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): HightouchEmbeddedDestinationResponse

    /** A view of [HightouchService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): HightouchService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/integrations/hightouch/embedded-destination`,
         * but is otherwise the same as [HightouchService.embeddedDestination].
         */
        @MustBeClosed
        fun embeddedDestination(
            params: HightouchEmbeddedDestinationParams
        ): HttpResponseFor<HightouchEmbeddedDestinationResponse> =
            embeddedDestination(params, RequestOptions.none())

        /** @see [embeddedDestination] */
        @MustBeClosed
        fun embeddedDestination(
            params: HightouchEmbeddedDestinationParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<HightouchEmbeddedDestinationResponse>
    }
}
