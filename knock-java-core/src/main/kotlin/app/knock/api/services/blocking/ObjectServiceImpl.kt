// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking

import app.knock.api.core.ClientOptions
import app.knock.api.core.JsonValue
import app.knock.api.core.RequestOptions
import app.knock.api.core.checkRequired
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
import app.knock.api.models.objects.ObjectAddSubscriptionsParams
import app.knock.api.models.objects.ObjectDeleteParams
import app.knock.api.models.objects.ObjectDeleteSubscriptionsParams
import app.knock.api.models.objects.ObjectGetChannelDataParams
import app.knock.api.models.objects.ObjectGetParams
import app.knock.api.models.objects.ObjectGetPreferencesParams
import app.knock.api.models.objects.ObjectListMessagesPage
import app.knock.api.models.objects.ObjectListMessagesPageResponse
import app.knock.api.models.objects.ObjectListMessagesParams
import app.knock.api.models.objects.ObjectListPage
import app.knock.api.models.objects.ObjectListPageResponse
import app.knock.api.models.objects.ObjectListParams
import app.knock.api.models.objects.ObjectListPreferencesParams
import app.knock.api.models.objects.ObjectListSchedulesPage
import app.knock.api.models.objects.ObjectListSchedulesPageResponse
import app.knock.api.models.objects.ObjectListSchedulesParams
import app.knock.api.models.objects.ObjectListSubscriptionsPage
import app.knock.api.models.objects.ObjectListSubscriptionsPageResponse
import app.knock.api.models.objects.ObjectListSubscriptionsParams
import app.knock.api.models.objects.ObjectSetChannelDataParams
import app.knock.api.models.objects.ObjectSetParams
import app.knock.api.models.objects.ObjectSetPreferencesParams
import app.knock.api.models.objects.ObjectUnsetChannelDataParams
import app.knock.api.models.recipients.channeldata.ChannelData
import app.knock.api.models.recipients.preferences.PreferenceSet
import app.knock.api.models.recipients.subscriptions.Subscription
import app.knock.api.services.blocking.objects.BulkService
import app.knock.api.services.blocking.objects.BulkServiceImpl
import kotlin.jvm.optionals.getOrNull

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

    override fun get(params: ObjectGetParams, requestOptions: RequestOptions): Object =
        // get /v1/objects/{collection}/{id}
        withRawResponse().get(params, requestOptions).parse()

    override fun getChannelData(
        params: ObjectGetChannelDataParams,
        requestOptions: RequestOptions,
    ): ChannelData =
        // get /v1/objects/{collection}/{object_id}/channel_data/{channel_id}
        withRawResponse().getChannelData(params, requestOptions).parse()

    override fun getPreferences(
        params: ObjectGetPreferencesParams,
        requestOptions: RequestOptions,
    ): PreferenceSet =
        // get /v1/objects/{collection}/{object_id}/preferences/{id}
        withRawResponse().getPreferences(params, requestOptions).parse()

    override fun listMessages(
        params: ObjectListMessagesParams,
        requestOptions: RequestOptions,
    ): ObjectListMessagesPage =
        // get /v1/objects/{collection}/{id}/messages
        withRawResponse().listMessages(params, requestOptions).parse()

    override fun listPreferences(
        params: ObjectListPreferencesParams,
        requestOptions: RequestOptions,
    ): List<PreferenceSet> =
        // get /v1/objects/{collection}/{object_id}/preferences
        withRawResponse().listPreferences(params, requestOptions).parse()

    override fun listSchedules(
        params: ObjectListSchedulesParams,
        requestOptions: RequestOptions,
    ): ObjectListSchedulesPage =
        // get /v1/objects/{collection}/{id}/schedules
        withRawResponse().listSchedules(params, requestOptions).parse()

    override fun listSubscriptions(
        params: ObjectListSubscriptionsParams,
        requestOptions: RequestOptions,
    ): ObjectListSubscriptionsPage =
        // get /v1/objects/{collection}/{object_id}/subscriptions
        withRawResponse().listSubscriptions(params, requestOptions).parse()

    override fun set(params: ObjectSetParams, requestOptions: RequestOptions): Object =
        // put /v1/objects/{collection}/{id}
        withRawResponse().set(params, requestOptions).parse()

    override fun setChannelData(
        params: ObjectSetChannelDataParams,
        requestOptions: RequestOptions,
    ): ChannelData =
        // put /v1/objects/{collection}/{object_id}/channel_data/{channel_id}
        withRawResponse().setChannelData(params, requestOptions).parse()

    override fun setPreferences(
        params: ObjectSetPreferencesParams,
        requestOptions: RequestOptions,
    ): PreferenceSet =
        // put /v1/objects/{collection}/{object_id}/preferences/{id}
        withRawResponse().setPreferences(params, requestOptions).parse()

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
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("collection", params.collection().getOrNull())
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
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("collection", params.collection().getOrNull())
            checkRequired("id", params.id().getOrNull())
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

        private val addSubscriptionsHandler: Handler<List<Subscription>> =
            jsonHandler<List<Subscription>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun addSubscriptions(
            params: ObjectAddSubscriptionsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<Subscription>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("collection", params.collection().getOrNull())
            checkRequired("objectId", params.objectId().getOrNull())
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
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("collection", params.collection().getOrNull())
            checkRequired("objectId", params.objectId().getOrNull())
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

        private val getHandler: Handler<Object> =
            jsonHandler<Object>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun get(
            params: ObjectGetParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Object> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("collection", params.collection().getOrNull())
            checkRequired("id", params.id().getOrNull())
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

        private val getChannelDataHandler: Handler<ChannelData> =
            jsonHandler<ChannelData>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun getChannelData(
            params: ObjectGetChannelDataParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ChannelData> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("collection", params.collection().getOrNull())
            checkRequired("objectId", params.objectId().getOrNull())
            checkRequired("channelId", params.channelId().getOrNull())
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

        private val getPreferencesHandler: Handler<PreferenceSet> =
            jsonHandler<PreferenceSet>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun getPreferences(
            params: ObjectGetPreferencesParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PreferenceSet> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("collection", params.collection().getOrNull())
            checkRequired("objectId", params.objectId().getOrNull())
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments(
                        "v1",
                        "objects",
                        params._pathParam(0),
                        params._pathParam(1),
                        "preferences",
                        params._pathParam(2),
                    )
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { getPreferencesHandler.handle(it) }
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
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("collection", params.collection().getOrNull())
            checkRequired("id", params.id().getOrNull())
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

        private val listPreferencesHandler: Handler<List<PreferenceSet>> =
            jsonHandler<List<PreferenceSet>>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun listPreferences(
            params: ObjectListPreferencesParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<PreferenceSet>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("collection", params.collection().getOrNull())
            checkRequired("objectId", params.objectId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments(
                        "v1",
                        "objects",
                        params._pathParam(0),
                        params._pathParam(1),
                        "preferences",
                    )
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { listPreferencesHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.forEach { it.validate() }
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
        ): HttpResponseFor<ObjectListSchedulesPage> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("collection", params.collection().getOrNull())
            checkRequired("id", params.id().getOrNull())
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

        private val listSubscriptionsHandler: Handler<ObjectListSubscriptionsPageResponse> =
            jsonHandler<ObjectListSubscriptionsPageResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun listSubscriptions(
            params: ObjectListSubscriptionsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ObjectListSubscriptionsPage> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("collection", params.collection().getOrNull())
            checkRequired("objectId", params.objectId().getOrNull())
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

        private val setHandler: Handler<Object> =
            jsonHandler<Object>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun set(
            params: ObjectSetParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Object> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("collection", params.collection().getOrNull())
            checkRequired("id", params.id().getOrNull())
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

        private val setChannelDataHandler: Handler<ChannelData> =
            jsonHandler<ChannelData>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun setChannelData(
            params: ObjectSetChannelDataParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ChannelData> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("collection", params.collection().getOrNull())
            checkRequired("objectId", params.objectId().getOrNull())
            checkRequired("channelId", params.channelId().getOrNull())
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
                    .body(json(clientOptions.jsonMapper, params._body()))
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

        private val setPreferencesHandler: Handler<PreferenceSet> =
            jsonHandler<PreferenceSet>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun setPreferences(
            params: ObjectSetPreferencesParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PreferenceSet> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("collection", params.collection().getOrNull())
            checkRequired("objectId", params.objectId().getOrNull())
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .addPathSegments(
                        "v1",
                        "objects",
                        params._pathParam(0),
                        params._pathParam(1),
                        "preferences",
                        params._pathParam(2),
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { setPreferencesHandler.handle(it) }
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
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("collection", params.collection().getOrNull())
            checkRequired("objectId", params.objectId().getOrNull())
            checkRequired("channelId", params.channelId().getOrNull())
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
