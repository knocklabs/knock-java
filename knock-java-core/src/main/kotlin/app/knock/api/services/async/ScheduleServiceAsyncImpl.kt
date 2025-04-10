// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async

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
import app.knock.api.models.schedules.Schedule
import app.knock.api.models.schedules.ScheduleCreateParams
import app.knock.api.models.schedules.ScheduleDeleteParams
import app.knock.api.models.schedules.ScheduleListPageAsync
import app.knock.api.models.schedules.ScheduleListPageResponse
import app.knock.api.models.schedules.ScheduleListParams
import app.knock.api.models.schedules.ScheduleUpdateParams
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

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

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

        private val listHandler: Handler<ScheduleListPageResponse> =
            jsonHandler<ScheduleListPageResponse>(clientOptions.jsonMapper)
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
                                ScheduleListPageAsync.builder()
                                    .service(ScheduleServiceAsyncImpl(clientOptions))
                                    .params(params)
                                    .response(it)
                                    .build()
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
