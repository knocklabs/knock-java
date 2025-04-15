// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking.tenants

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
import app.knock.api.models.bulkoperations.BulkOperation
import app.knock.api.models.tenants.bulk.BulkDeleteParams
import app.knock.api.models.tenants.bulk.BulkSetParams

class BulkServiceImpl internal constructor(private val clientOptions: ClientOptions) : BulkService {

    private val withRawResponse: BulkService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): BulkService.WithRawResponse = withRawResponse

    override fun delete(params: BulkDeleteParams, requestOptions: RequestOptions): BulkOperation =
        // post /v1/tenants/bulk/delete
        withRawResponse().delete(params, requestOptions).parse()

    override fun set(params: BulkSetParams, requestOptions: RequestOptions): BulkOperation =
        // post /v1/tenants/bulk/set
        withRawResponse().set(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        BulkService.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val deleteHandler: Handler<BulkOperation> =
            jsonHandler<BulkOperation>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun delete(
            params: BulkDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BulkOperation> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "tenants", "bulk", "delete")
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { deleteHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val setHandler: Handler<BulkOperation> =
            jsonHandler<BulkOperation>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun set(
            params: BulkSetParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BulkOperation> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "tenants", "bulk", "set")
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { setHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
