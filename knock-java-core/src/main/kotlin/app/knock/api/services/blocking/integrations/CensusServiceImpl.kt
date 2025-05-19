// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking.integrations

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
import app.knock.api.core.prepare
import app.knock.api.models.integrations.census.CensusCustomDestinationParams
import app.knock.api.models.integrations.census.CensusCustomDestinationResponse

class CensusServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    CensusService {

    private val withRawResponse: CensusService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): CensusService.WithRawResponse = withRawResponse

    override fun customDestination(
        params: CensusCustomDestinationParams,
        requestOptions: RequestOptions,
    ): CensusCustomDestinationResponse =
        // post /v1/integrations/census/custom-destination
        withRawResponse().customDestination(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CensusService.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val customDestinationHandler: Handler<CensusCustomDestinationResponse> =
            jsonHandler<CensusCustomDestinationResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun customDestination(
            params: CensusCustomDestinationParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CensusCustomDestinationResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "integrations", "census", "custom-destination")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
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
