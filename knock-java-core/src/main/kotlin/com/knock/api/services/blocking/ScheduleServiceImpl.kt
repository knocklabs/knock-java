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
import com.knock.api.core.http.json
import com.knock.api.core.http.parseable
import com.knock.api.core.prepare
import com.knock.api.errors.KnockError
import com.knock.api.models.Schedule
import com.knock.api.models.ScheduleCreateParams
import com.knock.api.models.ScheduleDeleteParams
import com.knock.api.models.ScheduleListPage
import com.knock.api.models.ScheduleListParams
import com.knock.api.models.ScheduleUpdateParams

class ScheduleServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ScheduleService {

    private val withRawResponse: ScheduleService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ScheduleService.WithRawResponse = withRawResponse

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

        private val errorHandler: Handler<KnockError> = errorHandler(clientOptions.jsonMapper)

        private val createHandler: Handler<List<Schedule>> =
            jsonHandler<List<Schedule>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun create(
            params: ScheduleCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<Schedule>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
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

        private val listHandler: Handler<ScheduleListPage.Response> =
            jsonHandler<ScheduleListPage.Response>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun list(
            params: ScheduleListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ScheduleListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
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
                    .let { ScheduleListPage.of(ScheduleServiceImpl(clientOptions), params, it) }
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
