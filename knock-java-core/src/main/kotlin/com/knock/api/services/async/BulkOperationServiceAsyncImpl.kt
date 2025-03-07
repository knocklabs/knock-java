// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.async

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
import com.knock.api.core.prepareAsync
import com.knock.api.errors.KnockError
import com.knock.api.models.BulkOperationGetParams
import com.knock.api.models.BulkOperationGetResponse
import java.util.concurrent.CompletableFuture

class BulkOperationServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    BulkOperationServiceAsync {

    private val withRawResponse: BulkOperationServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): BulkOperationServiceAsync.WithRawResponse = withRawResponse

    override fun get(
        params: BulkOperationGetParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<BulkOperationGetResponse> =
        // get /v1/bulk_operations/{id}
        withRawResponse().get(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        BulkOperationServiceAsync.WithRawResponse {

        private val errorHandler: Handler<KnockError> = errorHandler(clientOptions.jsonMapper)

        private val getHandler: Handler<BulkOperationGetResponse> =
            jsonHandler<BulkOperationGetResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun get(
            params: BulkOperationGetParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<BulkOperationGetResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "bulk_operations", params.getPathParam(0))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
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
}
