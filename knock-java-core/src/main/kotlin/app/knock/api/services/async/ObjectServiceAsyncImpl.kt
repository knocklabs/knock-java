// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async

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
import app.knock.api.core.prepareAsync
import app.knock.api.models.objects.Object
import app.knock.api.models.objects.ObjectAddSubscriptionsParams
import app.knock.api.models.objects.ObjectDeleteParams
import app.knock.api.models.objects.ObjectDeleteSubscriptionsParams
import app.knock.api.models.objects.ObjectGetChannelDataParams
import app.knock.api.models.objects.ObjectGetParams
import app.knock.api.models.objects.ObjectGetPreferencesParams
import app.knock.api.models.objects.ObjectListMessagesPageAsync
import app.knock.api.models.objects.ObjectListMessagesPageResponse
import app.knock.api.models.objects.ObjectListMessagesParams
import app.knock.api.models.objects.ObjectListPageAsync
import app.knock.api.models.objects.ObjectListPageResponse
import app.knock.api.models.objects.ObjectListParams
import app.knock.api.models.objects.ObjectListPreferencesParams
import app.knock.api.models.objects.ObjectListSchedulesPageAsync
import app.knock.api.models.objects.ObjectListSchedulesPageResponse
import app.knock.api.models.objects.ObjectListSchedulesParams
import app.knock.api.models.objects.ObjectListSubscriptionsPageAsync
import app.knock.api.models.objects.ObjectListSubscriptionsPageResponse
import app.knock.api.models.objects.ObjectListSubscriptionsParams
import app.knock.api.models.objects.ObjectSetChannelDataParams
import app.knock.api.models.objects.ObjectSetParams
import app.knock.api.models.objects.ObjectSetPreferencesParams
import app.knock.api.models.objects.ObjectUnsetChannelDataParams
import app.knock.api.models.recipients.channeldata.ChannelData
import app.knock.api.models.recipients.preferences.PreferenceSet
import app.knock.api.models.recipients.subscriptions.Subscription
import app.knock.api.services.async.objects.BulkServiceAsync
import app.knock.api.services.async.objects.BulkServiceAsyncImpl
import java.util.concurrent.CompletableFuture
import kotlin.jvm.optionals.getOrNull

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

    override fun addSubscriptions(
        params: ObjectAddSubscriptionsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<Subscription>> =
        // post /v1/objects/{collection}/{object_id}/subscriptions
        withRawResponse().addSubscriptions(params, requestOptions).thenApply { it.parse() }

    override fun deleteSubscriptions(
        params: ObjectDeleteSubscriptionsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<Subscription>> =
        // delete /v1/objects/{collection}/{object_id}/subscriptions
        withRawResponse().deleteSubscriptions(params, requestOptions).thenApply { it.parse() }

    override fun get(
        params: ObjectGetParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Object> =
        // get /v1/objects/{collection}/{id}
        withRawResponse().get(params, requestOptions).thenApply { it.parse() }

    override fun getChannelData(
        params: ObjectGetChannelDataParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ChannelData> =
        // get /v1/objects/{collection}/{object_id}/channel_data/{channel_id}
        withRawResponse().getChannelData(params, requestOptions).thenApply { it.parse() }

    override fun getPreferences(
        params: ObjectGetPreferencesParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<PreferenceSet> =
        // get /v1/objects/{collection}/{object_id}/preferences/{id}
        withRawResponse().getPreferences(params, requestOptions).thenApply { it.parse() }

    override fun listMessages(
        params: ObjectListMessagesParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ObjectListMessagesPageAsync> =
        // get /v1/objects/{collection}/{id}/messages
        withRawResponse().listMessages(params, requestOptions).thenApply { it.parse() }

    override fun listPreferences(
        params: ObjectListPreferencesParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<PreferenceSet>> =
        // get /v1/objects/{collection}/{object_id}/preferences
        withRawResponse().listPreferences(params, requestOptions).thenApply { it.parse() }

    override fun listSchedules(
        params: ObjectListSchedulesParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ObjectListSchedulesPageAsync> =
        // get /v1/objects/{collection}/{id}/schedules
        withRawResponse().listSchedules(params, requestOptions).thenApply { it.parse() }

    override fun listSubscriptions(
        params: ObjectListSubscriptionsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ObjectListSubscriptionsPageAsync> =
        // get /v1/objects/{collection}/{object_id}/subscriptions
        withRawResponse().listSubscriptions(params, requestOptions).thenApply { it.parse() }

    override fun set(
        params: ObjectSetParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Object> =
        // put /v1/objects/{collection}/{id}
        withRawResponse().set(params, requestOptions).thenApply { it.parse() }

    override fun setChannelData(
        params: ObjectSetChannelDataParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ChannelData> =
        // put /v1/objects/{collection}/{object_id}/channel_data/{channel_id}
        withRawResponse().setChannelData(params, requestOptions).thenApply { it.parse() }

    override fun setPreferences(
        params: ObjectSetPreferencesParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<PreferenceSet> =
        // put /v1/objects/{collection}/{object_id}/preferences/{id}
        withRawResponse().setPreferences(params, requestOptions).thenApply { it.parse() }

    override fun unsetChannelData(
        params: ObjectUnsetChannelDataParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<String> =
        // delete /v1/objects/{collection}/{object_id}/channel_data/{channel_id}
        withRawResponse().unsetChannelData(params, requestOptions).thenApply { it.parse() }

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
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("collection", params.collection().getOrNull())
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
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable { response.use { deleteHandler.handle(it) } }
                }
        }

        private val addSubscriptionsHandler: Handler<List<Subscription>> =
            jsonHandler<List<Subscription>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun addSubscriptions(
            params: ObjectAddSubscriptionsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<Subscription>>> {
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
                                    it.forEach { it.validate() }
                                }
                            }
                    }
                }
        }

        private val deleteSubscriptionsHandler: Handler<List<Subscription>> =
            jsonHandler<List<Subscription>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun deleteSubscriptions(
            params: ObjectDeleteSubscriptionsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<Subscription>>> {
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
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { deleteSubscriptionsHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.forEach { it.validate() }
                                }
                            }
                    }
                }
        }

        private val getHandler: Handler<Object> =
            jsonHandler<Object>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun get(
            params: ObjectGetParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Object>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("collection", params.collection().getOrNull())
            checkRequired("id", params.id().getOrNull())
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

        private val getChannelDataHandler: Handler<ChannelData> =
            jsonHandler<ChannelData>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun getChannelData(
            params: ObjectGetChannelDataParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ChannelData>> {
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
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { getChannelDataHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val getPreferencesHandler: Handler<PreferenceSet> =
            jsonHandler<PreferenceSet>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun getPreferences(
            params: ObjectGetPreferencesParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PreferenceSet>> {
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
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { getPreferencesHandler.handle(it) }
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

        private val listPreferencesHandler: Handler<List<PreferenceSet>> =
            jsonHandler<List<PreferenceSet>>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun listPreferences(
            params: ObjectListPreferencesParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<PreferenceSet>>> {
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
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { listPreferencesHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.forEach { it.validate() }
                                }
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

        private val listSubscriptionsHandler: Handler<ObjectListSubscriptionsPageResponse> =
            jsonHandler<ObjectListSubscriptionsPageResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun listSubscriptions(
            params: ObjectListSubscriptionsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ObjectListSubscriptionsPageAsync>> {
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
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { listSubscriptionsHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                            .let {
                                ObjectListSubscriptionsPageAsync.builder()
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

        private val setChannelDataHandler: Handler<ChannelData> =
            jsonHandler<ChannelData>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun setChannelData(
            params: ObjectSetChannelDataParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ChannelData>> {
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
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { setChannelDataHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val setPreferencesHandler: Handler<PreferenceSet> =
            jsonHandler<PreferenceSet>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun setPreferences(
            params: ObjectSetPreferencesParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PreferenceSet>> {
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
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { setPreferencesHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val unsetChannelDataHandler: Handler<String> =
            stringHandler().withErrorHandler(errorHandler)

        override fun unsetChannelData(
            params: ObjectUnsetChannelDataParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<String>> {
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
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable { response.use { unsetChannelDataHandler.handle(it) } }
                }
        }
    }
}
