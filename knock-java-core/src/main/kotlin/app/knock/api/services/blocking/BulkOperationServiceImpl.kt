// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking

import app.knock.api.core.ClientOptions
import app.knock.api.core.JsonValue
import app.knock.api.core.RequestOptions
import app.knock.api.core.checkRequired
import app.knock.api.core.handlers.errorHandler
import app.knock.api.core.handlers.jsonHandler
import app.knock.api.core.handlers.withErrorHandler
import app.knock.api.core.http.HttpMethod
import app.knock.api.core.http.HttpRequest
import app.knock.api.core.http.HttpResponse.Handler
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.core.http.parseable
import app.knock.api.core.prepare
import app.knock.api.models.bulkoperations.BulkOperation
import app.knock.api.models.bulkoperations.BulkOperationGetParams
import kotlin.jvm.optionals.getOrNull

class BulkOperationServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    BulkOperationService {

    private val withRawResponse: BulkOperationService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): BulkOperationService.WithRawResponse = withRawResponse

    override fun get(
        params: BulkOperationGetParams,
        requestOptions: RequestOptions,
    ): BulkOperation =
        // get /v1/bulk_operations/{id}
        withRawResponse().get(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        BulkOperationService.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val getHandler: Handler<BulkOperation> =
            jsonHandler<BulkOperation>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun get(
            params: BulkOperationGetParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BulkOperation> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "bulk_operations", params._pathParam(0))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { getHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
