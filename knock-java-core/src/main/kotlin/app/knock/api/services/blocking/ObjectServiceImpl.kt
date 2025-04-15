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
import app.knock.api.models.objects.ObjectAddSubscriptionsParams
import app.knock.api.models.objects.ObjectDeleteSubscriptionsParams
import app.knock.api.models.objects.ObjectGetChannelDataParams
import app.knock.api.models.objects.ObjectListPage
import app.knock.api.models.objects.ObjectListPageResponse
import app.knock.api.models.objects.ObjectListParams
import app.knock.api.models.objects.ObjectListSubscriptionsPage
import app.knock.api.models.objects.ObjectListSubscriptionsPageResponse
import app.knock.api.models.objects.ObjectListSubscriptionsParams
import app.knock.api.models.objects.ObjectSetChannelDataParams
import app.knock.api.models.objects.ObjectUnsetChannelDataParams
import app.knock.api.models.recipients.channeldata.ChannelData
import app.knock.api.models.recipients.subscriptions.Subscription
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

    override fun addSubscriptions(
        params: ObjectAddSubscriptionsParams,
        requestOptions: RequestOptions,
    ): List<Subscription> =
        // post /v1/objects/{collection}/{object_id}/subscriptions
        withRawResponse().addSubscriptions(params, requestOptions).parse()

    override fun deleteSubscriptions(
        params: ObjectDeleteSubscriptionsParams,
        requestOptions: RequestOptions,
    ): List<Subscription> =
        // delete /v1/objects/{collection}/{object_id}/subscriptions
        withRawResponse().deleteSubscriptions(params, requestOptions).parse()

    override fun getChannelData(
        params: ObjectGetChannelDataParams,
        requestOptions: RequestOptions,
    ): ChannelData =
        // get /v1/objects/{collection}/{object_id}/channel_data/{channel_id}
        withRawResponse().getChannelData(params, requestOptions).parse()

    override fun listSubscriptions(
        params: ObjectListSubscriptionsParams,
        requestOptions: RequestOptions,
    ): ObjectListSubscriptionsPage =
        // get /v1/objects/{collection}/{object_id}/subscriptions
        withRawResponse().listSubscriptions(params, requestOptions).parse()

    override fun setChannelData(
        params: ObjectSetChannelDataParams,
        requestOptions: RequestOptions,
    ): ChannelData =
        // put /v1/objects/{collection}/{object_id}/channel_data/{channel_id}
        withRawResponse().setChannelData(params, requestOptions).parse()

    override fun unsetChannelData(
        params: ObjectUnsetChannelDataParams,
        requestOptions: RequestOptions,
    ): String =
        // delete /v1/objects/{collection}/{object_id}/channel_data/{channel_id}
        withRawResponse().unsetChannelData(params, requestOptions).parse()

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

        private val addSubscriptionsHandler: Handler<List<Subscription>> =
            jsonHandler<List<Subscription>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun addSubscriptions(
            params: ObjectAddSubscriptionsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<Subscription>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments(
                        "v1",
                        "objects",
                        params._pathParam(0),
                        params._pathParam(1),
                        "subscriptions",
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
                            it.forEach { it.validate() }
                        }
                    }
            }
        }

        private val deleteSubscriptionsHandler: Handler<List<Subscription>> =
            jsonHandler<List<Subscription>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun deleteSubscriptions(
            params: ObjectDeleteSubscriptionsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<Subscription>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments(
                        "v1",
                        "objects",
                        params._pathParam(0),
                        params._pathParam(1),
                        "subscriptions",
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { deleteSubscriptionsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.forEach { it.validate() }
                        }
                    }
            }
        }

        private val getChannelDataHandler: Handler<ChannelData> =
            jsonHandler<ChannelData>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun getChannelData(
            params: ObjectGetChannelDataParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ChannelData> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments(
                        "v1",
                        "objects",
                        params._pathParam(0),
                        params._pathParam(1),
                        "channel_data",
                        params._pathParam(2),
                    )
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { getChannelDataHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listSubscriptionsHandler: Handler<ObjectListSubscriptionsPageResponse> =
            jsonHandler<ObjectListSubscriptionsPageResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun listSubscriptions(
            params: ObjectListSubscriptionsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ObjectListSubscriptionsPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments(
                        "v1",
                        "objects",
                        params._pathParam(0),
                        params._pathParam(1),
                        "subscriptions",
                    )
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { listSubscriptionsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        ObjectListSubscriptionsPage.builder()
                            .service(ObjectServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val setChannelDataHandler: Handler<ChannelData> =
            jsonHandler<ChannelData>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun setChannelData(
            params: ObjectSetChannelDataParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ChannelData> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .addPathSegments(
                        "v1",
                        "objects",
                        params._pathParam(0),
                        params._pathParam(1),
                        "channel_data",
                        params._pathParam(2),
                    )
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { setChannelDataHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val unsetChannelDataHandler: Handler<String> =
            stringHandler().withErrorHandler(errorHandler)

        override fun unsetChannelData(
            params: ObjectUnsetChannelDataParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<String> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments(
                        "v1",
                        "objects",
                        params._pathParam(0),
                        params._pathParam(1),
                        "channel_data",
                        params._pathParam(2),
                    )
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable { response.use { unsetChannelDataHandler.handle(it) } }
        }
    }
}
