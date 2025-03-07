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
import com.knock.api.core.http.json
import com.knock.api.core.http.parseable
import com.knock.api.core.prepareAsync
import com.knock.api.errors.KnockError
import com.knock.api.models.Schedule
import com.knock.api.models.ScheduleCreateParams
import com.knock.api.models.ScheduleDeleteParams
import com.knock.api.models.ScheduleListPageAsync
import com.knock.api.models.ScheduleListParams
import com.knock.api.models.ScheduleUpdateParams
import java.util.concurrent.CompletableFuture

class ScheduleServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ScheduleServiceAsync {

    private val withRawResponse: ScheduleServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ScheduleServiceAsync.WithRawResponse = withRawResponse

    override fun create(
        params: ScheduleCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<Schedule>> =
        // post /v1/schedules
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun update(
        params: ScheduleUpdateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<Schedule>> =
        // put /v1/schedules
        withRawResponse().update(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: ScheduleListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ScheduleListPageAsync> =
        // get /v1/schedules
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun delete(
        params: ScheduleDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<Schedule>> =
        // delete /v1/schedules
        withRawResponse().delete(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ScheduleServiceAsync.WithRawResponse {

        private val errorHandler: Handler<KnockError> = errorHandler(clientOptions.jsonMapper)

        private val createHandler: Handler<List<Schedule>> =
            jsonHandler<List<Schedule>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun create(
            params: ScheduleCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<Schedule>>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "schedules")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { createHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.forEach { it.validate() }
                                }
                            }
                    }
                }
        }

        private val updateHandler: Handler<List<Schedule>> =
            jsonHandler<List<Schedule>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun update(
            params: ScheduleUpdateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<Schedule>>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .addPathSegments("v1", "schedules")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { updateHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.forEach { it.validate() }
                                }
                            }
                    }
                }
        }

        private val listHandler: Handler<ScheduleListPageAsync.Response> =
            jsonHandler<ScheduleListPageAsync.Response>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun list(
            params: ScheduleListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ScheduleListPageAsync>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "schedules")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { listHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                            .let {
                                ScheduleListPageAsync.of(
                                    ScheduleServiceAsyncImpl(clientOptions),
                                    params,
                                    it,
                                )
                            }
                    }
                }
        }

        private val deleteHandler: Handler<List<Schedule>> =
            jsonHandler<List<Schedule>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun delete(
            params: ScheduleDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<Schedule>>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments("v1", "schedules")
                    .body(json(clientOptions.jsonMapper, params._body()))
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
                                    it.forEach { it.validate() }
                                }
                            }
                    }
                }
        }
    }
}
