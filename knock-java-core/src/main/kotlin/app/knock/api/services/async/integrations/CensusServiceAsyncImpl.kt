// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async.integrations

import app.knock.api.core.ClientOptions
import app.knock.api.core.JsonValue
import app.knock.api.core.RequestOptions
import app.knock.api.core.handlers.errorHandler
import app.knock.api.core.handlers.jsonHandler
import app.knock.api.core.handlers.withErrorHandler
import app.knock.api.core.http.HttpMethod
import app.knock.api.core.http.HttpRequest
import app.knock.api.core.http.HttpResponse.Handler
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.core.http.json
import app.knock.api.core.http.parseable
import app.knock.api.core.prepareAsync
import app.knock.api.models.integrations.census.CensusCustomDestinationParams
import app.knock.api.models.integrations.census.CensusCustomDestinationResponse
import java.util.concurrent.CompletableFuture

class CensusServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    CensusServiceAsync {

    private val withRawResponse: CensusServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): CensusServiceAsync.WithRawResponse = withRawResponse

    override fun customDestination(
        params: CensusCustomDestinationParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CensusCustomDestinationResponse> =
        // post /v1/integrations/census/custom-destination
        withRawResponse().customDestination(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CensusServiceAsync.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val customDestinationHandler: Handler<CensusCustomDestinationResponse> =
            jsonHandler<CensusCustomDestinationResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun customDestination(
            params: CensusCustomDestinationParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CensusCustomDestinationResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "integrations", "census", "custom-destination")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { customDestinationHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }
    }
}
