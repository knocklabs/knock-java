// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking

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
import app.knock.api.models.schedules.Schedule
import app.knock.api.models.schedules.ScheduleCreateParams
import app.knock.api.models.schedules.ScheduleDeleteParams
import app.knock.api.models.schedules.ScheduleListPage
import app.knock.api.models.schedules.ScheduleListPageResponse
import app.knock.api.models.schedules.ScheduleListParams
import app.knock.api.models.schedules.ScheduleUpdateParams
import app.knock.api.services.blocking.schedules.BulkService
import app.knock.api.services.blocking.schedules.BulkServiceImpl

class ScheduleServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ScheduleService {

    private val withRawResponse: ScheduleService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val bulk: BulkService by lazy { BulkServiceImpl(clientOptions) }

    override fun withRawResponse(): ScheduleService.WithRawResponse = withRawResponse

    override fun bulk(): BulkService = bulk

    override fun create(
        params: ScheduleCreateParams,
        requestOptions: RequestOptions,
    ): List<Schedule> =
        // post /v1/schedules
        withRawResponse().create(params, requestOptions).parse()

    override fun update(
        params: ScheduleUpdateParams,
        requestOptions: RequestOptions,
    ): List<Schedule> =
        // put /v1/schedules
        withRawResponse().update(params, requestOptions).parse()

    override fun list(
        params: ScheduleListParams,
        requestOptions: RequestOptions,
    ): ScheduleListPage =
        // get /v1/schedules
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(
        params: ScheduleDeleteParams,
        requestOptions: RequestOptions,
    ): List<Schedule> =
        // delete /v1/schedules
        withRawResponse().delete(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ScheduleService.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val bulk: BulkService.WithRawResponse by lazy {
            BulkServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun bulk(): BulkService.WithRawResponse = bulk

        private val createHandler: Handler<List<Schedule>> =
            jsonHandler<List<Schedule>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun create(
            params: ScheduleCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<Schedule>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "schedules")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.forEach { it.validate() }
                        }
                    }
            }
        }

        private val updateHandler: Handler<List<Schedule>> =
            jsonHandler<List<Schedule>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun update(
            params: ScheduleUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<Schedule>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "schedules")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { updateHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.forEach { it.validate() }
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
        ): HttpResponseFor<ScheduleListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "schedules")
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
                        ScheduleListPage.builder()
                            .service(ScheduleServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<List<Schedule>> =
            jsonHandler<List<Schedule>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun delete(
            params: ScheduleDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<Schedule>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "schedules")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
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
