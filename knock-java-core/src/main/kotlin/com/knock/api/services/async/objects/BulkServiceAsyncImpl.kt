// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.async.objects

import com.knock.api.core.ClientOptions
import com.knock.api.core.RequestOptions
import com.knock.api.core.handlers.errorHandler
import com.knock.api.core.handlers.jsonHandler
import com.knock.api.core.handlers.withErrorHandler
import com.knock.api.core.http.HttpMethod
import com.knock.api.core.http.HttpRequest
import com.knock.api.core.http.HttpResponse.Handler
import com.knock.api.core.http.HttpResponseFor
import com.knock.api.core.http.json
import com.knock.api.core.http.parseable
import com.knock.api.core.prepareAsync
import com.knock.api.errors.KnockError
import com.knock.api.models.ObjectBulkAddSubscriptionsParams
import com.knock.api.models.ObjectBulkAddSubscriptionsResponse
import com.knock.api.models.ObjectBulkDeleteParams
import com.knock.api.models.ObjectBulkDeleteResponse
import com.knock.api.models.ObjectBulkSetParams
import com.knock.api.models.ObjectBulkSetResponse
import java.util.concurrent.CompletableFuture

class BulkServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    BulkServiceAsync {

    private val withRawResponse: BulkServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): BulkServiceAsync.WithRawResponse = withRawResponse

    override fun delete(
        params: ObjectBulkDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ObjectBulkDeleteResponse> =
        // post /v1/objects/{collection}/bulk/delete
        withRawResponse().delete(params, requestOptions).thenApply { it.parse() }

    override fun addSubscriptions(
        params: ObjectBulkAddSubscriptionsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ObjectBulkAddSubscriptionsResponse> =
        // post /v1/objects/{collection}/bulk/subscriptions/add
        withRawResponse().addSubscriptions(params, requestOptions).thenApply { it.parse() }

    override fun set(
        params: ObjectBulkSetParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ObjectBulkSetResponse> =
        // post /v1/objects/{collection}/bulk/set
        withRawResponse().set(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        BulkServiceAsync.WithRawResponse {

        private val errorHandler: Handler<KnockError> = errorHandler(clientOptions.jsonMapper)

        private val deleteHandler: Handler<ObjectBulkDeleteResponse> =
            jsonHandler<ObjectBulkDeleteResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun delete(
            params: ObjectBulkDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ObjectBulkDeleteResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "objects", params.getPathParam(0), "bulk", "delete")
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { deleteHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val addSubscriptionsHandler: Handler<ObjectBulkAddSubscriptionsResponse> =
            jsonHandler<ObjectBulkAddSubscriptionsResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun addSubscriptions(
            params: ObjectBulkAddSubscriptionsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ObjectBulkAddSubscriptionsResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments(
                        "v1",
                        "objects",
                        params.getPathParam(0),
                        "bulk",
                        "subscriptions",
                        "add",
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { addSubscriptionsHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val setHandler: Handler<ObjectBulkSetResponse> =
            jsonHandler<ObjectBulkSetResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun set(
            params: ObjectBulkSetParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ObjectBulkSetResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "objects", params.getPathParam(0), "bulk", "set")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
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
}
