// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async

import app.knock.api.core.ClientOptions
import app.knock.api.core.JsonValue
import app.knock.api.core.RequestOptions
import app.knock.api.core.handlers.errorHandler
import app.knock.api.core.handlers.jsonHandler
import app.knock.api.core.handlers.stringHandler
import app.knock.api.core.handlers.withErrorHandler
import app.knock.api.core.http.HttpMethod
import app.knock.api.core.http.HttpRequest
import app.knock.api.core.http.HttpResponse.Handler
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.core.http.json
import app.knock.api.core.http.parseable
import app.knock.api.core.prepareAsync
import app.knock.api.models.objects.Object
import app.knock.api.models.objects.ObjectDeleteParams
import app.knock.api.models.objects.ObjectGetParams
import app.knock.api.models.objects.ObjectListMessagesPageAsync
import app.knock.api.models.objects.ObjectListMessagesPageResponse
import app.knock.api.models.objects.ObjectListMessagesParams
import app.knock.api.models.objects.ObjectListPageAsync
import app.knock.api.models.objects.ObjectListPageResponse
import app.knock.api.models.objects.ObjectListParams
import app.knock.api.models.objects.ObjectListSchedulesPageAsync
import app.knock.api.models.objects.ObjectListSchedulesPageResponse
import app.knock.api.models.objects.ObjectListSchedulesParams
import app.knock.api.models.objects.ObjectSetParams
import app.knock.api.services.async.objects.BulkServiceAsync
import app.knock.api.services.async.objects.BulkServiceAsyncImpl
import java.util.concurrent.CompletableFuture

class ObjectServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ObjectServiceAsync {

    private val withRawResponse: ObjectServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val bulk: BulkServiceAsync by lazy { BulkServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): ObjectServiceAsync.WithRawResponse = withRawResponse

    override fun bulk(): BulkServiceAsync = bulk

    override fun list(
        params: ObjectListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ObjectListPageAsync> =
        // get /v1/objects/{collection}
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun delete(
        params: ObjectDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<String> =
        // delete /v1/objects/{collection}/{id}
        withRawResponse().delete(params, requestOptions).thenApply { it.parse() }

    override fun get(
        params: ObjectGetParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Object> =
        // get /v1/objects/{collection}/{id}
        withRawResponse().get(params, requestOptions).thenApply { it.parse() }

    override fun listMessages(
        params: ObjectListMessagesParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ObjectListMessagesPageAsync> =
        // get /v1/objects/{collection}/{id}/messages
        withRawResponse().listMessages(params, requestOptions).thenApply { it.parse() }

    override fun listSchedules(
        params: ObjectListSchedulesParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ObjectListSchedulesPageAsync> =
        // get /v1/objects/{collection}/{id}/schedules
        withRawResponse().listSchedules(params, requestOptions).thenApply { it.parse() }

    override fun set(
        params: ObjectSetParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Object> =
        // put /v1/objects/{collection}/{id}
        withRawResponse().set(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ObjectServiceAsync.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val bulk: BulkServiceAsync.WithRawResponse by lazy {
            BulkServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun bulk(): BulkServiceAsync.WithRawResponse = bulk

        private val listHandler: Handler<ObjectListPageResponse> =
            jsonHandler<ObjectListPageResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun list(
            params: ObjectListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ObjectListPageAsync>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "objects", params._pathParam(0))
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
                                ObjectListPageAsync.builder()
                                    .service(ObjectServiceAsyncImpl(clientOptions))
                                    .params(params)
                                    .response(it)
                                    .build()
                            }
                    }
                }
        }

        private val deleteHandler: Handler<String> = stringHandler().withErrorHandler(errorHandler)

        override fun delete(
            params: ObjectDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<String>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments("v1", "objects", params._pathParam(0), params._pathParam(1))
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable { response.use { deleteHandler.handle(it) } }
                }
        }

        private val getHandler: Handler<Object> =
            jsonHandler<Object>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun get(
            params: ObjectGetParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Object>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "objects", params._pathParam(0), params._pathParam(1))
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

        private val listMessagesHandler: Handler<ObjectListMessagesPageResponse> =
            jsonHandler<ObjectListMessagesPageResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun listMessages(
            params: ObjectListMessagesParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ObjectListMessagesPageAsync>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments(
                        "v1",
                        "objects",
                        params._pathParam(0),
                        params._pathParam(1),
                        "messages",
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { listMessagesHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                            .let {
                                ObjectListMessagesPageAsync.builder()
                                    .service(ObjectServiceAsyncImpl(clientOptions))
                                    .params(params)
                                    .response(it)
                                    .build()
                            }
                    }
                }
        }

        private val listSchedulesHandler: Handler<ObjectListSchedulesPageResponse> =
            jsonHandler<ObjectListSchedulesPageResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun listSchedules(
            params: ObjectListSchedulesParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ObjectListSchedulesPageAsync>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments(
                        "v1",
                        "objects",
                        params._pathParam(0),
                        params._pathParam(1),
                        "schedules",
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { listSchedulesHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                            .let {
                                ObjectListSchedulesPageAsync.builder()
                                    .service(ObjectServiceAsyncImpl(clientOptions))
                                    .params(params)
                                    .response(it)
                                    .build()
                            }
                    }
                }
        }

        private val setHandler: Handler<Object> =
            jsonHandler<Object>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun set(
            params: ObjectSetParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Object>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .addPathSegments("v1", "objects", params._pathParam(0), params._pathParam(1))
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
