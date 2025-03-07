// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.blocking.objects

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
import com.knock.api.core.prepare
import com.knock.api.errors.KnockError
import com.knock.api.models.ObjectBulkAddSubscriptionsParams
import com.knock.api.models.ObjectBulkAddSubscriptionsResponse
import com.knock.api.models.ObjectBulkDeleteParams
import com.knock.api.models.ObjectBulkDeleteResponse
import com.knock.api.models.ObjectBulkSetParams
import com.knock.api.models.ObjectBulkSetResponse

class BulkServiceImpl internal constructor(private val clientOptions: ClientOptions) : BulkService {

    private val withRawResponse: BulkService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): BulkService.WithRawResponse = withRawResponse

    override fun delete(
        params: ObjectBulkDeleteParams,
        requestOptions: RequestOptions,
    ): ObjectBulkDeleteResponse =
        // post /v1/objects/{collection}/bulk/delete
        withRawResponse().delete(params, requestOptions).parse()

    override fun addSubscriptions(
        params: ObjectBulkAddSubscriptionsParams,
        requestOptions: RequestOptions,
    ): ObjectBulkAddSubscriptionsResponse =
        // post /v1/objects/{collection}/bulk/subscriptions/add
        withRawResponse().addSubscriptions(params, requestOptions).parse()

    override fun set(
        params: ObjectBulkSetParams,
        requestOptions: RequestOptions,
    ): ObjectBulkSetResponse =
        // post /v1/objects/{collection}/bulk/set
        withRawResponse().set(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        BulkService.WithRawResponse {

        private val errorHandler: Handler<KnockError> = errorHandler(clientOptions.jsonMapper)

        private val deleteHandler: Handler<ObjectBulkDeleteResponse> =
            jsonHandler<ObjectBulkDeleteResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun delete(
            params: ObjectBulkDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ObjectBulkDeleteResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "objects", params.getPathParam(0), "bulk", "delete")
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

        private val addSubscriptionsHandler: Handler<ObjectBulkAddSubscriptionsResponse> =
            jsonHandler<ObjectBulkAddSubscriptionsResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun addSubscriptions(
            params: ObjectBulkAddSubscriptionsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ObjectBulkAddSubscriptionsResponse> {
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { addSubscriptionsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
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
        ): HttpResponseFor<ObjectBulkSetResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "objects", params.getPathParam(0), "bulk", "set")
                    .body(json(clientOptions.jsonMapper, params._body()))
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
