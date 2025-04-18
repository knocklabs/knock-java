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
import app.knock.api.models.integrations.hightouch.HightouchEmbeddedDestinationParams
import app.knock.api.models.integrations.hightouch.HightouchEmbeddedDestinationResponse
import java.util.concurrent.CompletableFuture

class HightouchServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    HightouchServiceAsync {

    private val withRawResponse: HightouchServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): HightouchServiceAsync.WithRawResponse = withRawResponse

    override fun embeddedDestination(
        params: HightouchEmbeddedDestinationParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<HightouchEmbeddedDestinationResponse> =
        // post /v1/integrations/hightouch/embedded-destination
        withRawResponse().embeddedDestination(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        HightouchServiceAsync.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val embeddedDestinationHandler: Handler<HightouchEmbeddedDestinationResponse> =
            jsonHandler<HightouchEmbeddedDestinationResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun embeddedDestination(
            params: HightouchEmbeddedDestinationParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<HightouchEmbeddedDestinationResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "integrations", "hightouch", "embedded-destination")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { embeddedDestinationHandler.handle(it) }
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
