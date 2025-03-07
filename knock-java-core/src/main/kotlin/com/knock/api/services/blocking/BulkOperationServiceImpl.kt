// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.blocking

import com.knock.api.core.ClientOptions
import com.knock.api.core.RequestOptions
import com.knock.api.core.handlers.errorHandler
import com.knock.api.core.handlers.jsonHandler
import com.knock.api.core.handlers.withErrorHandler
import com.knock.api.core.http.HttpMethod
import com.knock.api.core.http.HttpRequest
import com.knock.api.core.http.HttpResponse.Handler
import com.knock.api.core.http.HttpResponseFor
import com.knock.api.core.http.parseable
import com.knock.api.core.prepare
import com.knock.api.errors.KnockError
import com.knock.api.models.BulkOperationGetParams
import com.knock.api.models.BulkOperationGetResponse

class BulkOperationServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    BulkOperationService {

    private val withRawResponse: BulkOperationService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): BulkOperationService.WithRawResponse = withRawResponse

    override fun get(
        params: BulkOperationGetParams,
        requestOptions: RequestOptions,
    ): BulkOperationGetResponse =
        // get /v1/bulk_operations/{id}
        withRawResponse().get(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        BulkOperationService.WithRawResponse {

        private val errorHandler: Handler<KnockError> = errorHandler(clientOptions.jsonMapper)

        private val getHandler: Handler<BulkOperationGetResponse> =
            jsonHandler<BulkOperationGetResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun get(
            params: BulkOperationGetParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BulkOperationGetResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "bulk_operations", params.getPathParam(0))
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
