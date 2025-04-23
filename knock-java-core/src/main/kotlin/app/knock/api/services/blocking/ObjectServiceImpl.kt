// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking

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
import app.knock.api.core.prepare
import app.knock.api.models.objects.Object
import app.knock.api.models.objects.ObjectDeleteParams
import app.knock.api.models.objects.ObjectGetParams
import app.knock.api.models.objects.ObjectListMessagesPage
import app.knock.api.models.objects.ObjectListMessagesPageResponse
import app.knock.api.models.objects.ObjectListMessagesParams
import app.knock.api.models.objects.ObjectListPage
import app.knock.api.models.objects.ObjectListPageResponse
import app.knock.api.models.objects.ObjectListParams
import app.knock.api.models.objects.ObjectListSchedulesPage
import app.knock.api.models.objects.ObjectListSchedulesPageResponse
import app.knock.api.models.objects.ObjectListSchedulesParams
import app.knock.api.models.objects.ObjectSetParams
import app.knock.api.services.blocking.objects.BulkService
import app.knock.api.services.blocking.objects.BulkServiceImpl

class ObjectServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ObjectService {

    private val withRawResponse: ObjectService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val bulk: BulkService by lazy { BulkServiceImpl(clientOptions) }

    override fun withRawResponse(): ObjectService.WithRawResponse = withRawResponse

    override fun bulk(): BulkService = bulk

    override fun list(params: ObjectListParams, requestOptions: RequestOptions): ObjectListPage =
        // get /v1/objects/{collection}
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(params: ObjectDeleteParams, requestOptions: RequestOptions): String =
        // delete /v1/objects/{collection}/{id}
        withRawResponse().delete(params, requestOptions).parse()

    override fun get(params: ObjectGetParams, requestOptions: RequestOptions): Object =
        // get /v1/objects/{collection}/{id}
        withRawResponse().get(params, requestOptions).parse()

    override fun listMessages(
        params: ObjectListMessagesParams,
        requestOptions: RequestOptions,
    ): ObjectListMessagesPage =
        // get /v1/objects/{collection}/{id}/messages
        withRawResponse().listMessages(params, requestOptions).parse()

    override fun listSchedules(
        params: ObjectListSchedulesParams,
        requestOptions: RequestOptions,
    ): ObjectListSchedulesPage =
        // get /v1/objects/{collection}/{id}/schedules
        withRawResponse().listSchedules(params, requestOptions).parse()

    override fun set(params: ObjectSetParams, requestOptions: RequestOptions): Object =
        // put /v1/objects/{collection}/{id}
        withRawResponse().set(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ObjectService.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val bulk: BulkService.WithRawResponse by lazy {
            BulkServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun bulk(): BulkService.WithRawResponse = bulk

        private val listHandler: Handler<ObjectListPageResponse> =
            jsonHandler<ObjectListPageResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun list(
            params: ObjectListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ObjectListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "objects", params._pathParam(0))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        ObjectListPage.builder()
                            .service(ObjectServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<String> = stringHandler().withErrorHandler(errorHandler)

        override fun delete(
            params: ObjectDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<String> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments("v1", "objects", params._pathParam(0), params._pathParam(1))
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable { response.use { deleteHandler.handle(it) } }
        }

        private val getHandler: Handler<Object> =
            jsonHandler<Object>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun get(
            params: ObjectGetParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Object> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "objects", params._pathParam(0), params._pathParam(1))
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

        private val listMessagesHandler: Handler<ObjectListMessagesPageResponse> =
            jsonHandler<ObjectListMessagesPageResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun listMessages(
            params: ObjectListMessagesParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ObjectListMessagesPage> {
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { listMessagesHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        ObjectListMessagesPage.builder()
                            .service(ObjectServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val listSchedulesHandler: Handler<ObjectListSchedulesPageResponse> =
            jsonHandler<ObjectListSchedulesPageResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun listSchedules(
            params: ObjectListSchedulesParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ObjectListSchedulesPage> {
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { listSchedulesHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        ObjectListSchedulesPage.builder()
                            .service(ObjectServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val setHandler: Handler<Object> =
            jsonHandler<Object>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun set(
            params: ObjectSetParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Object> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .addPathSegments("v1", "objects", params._pathParam(0), params._pathParam(1))
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
