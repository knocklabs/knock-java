// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.async

import com.knock.api.core.ClientOptions
import com.knock.api.core.RequestOptions
import com.knock.api.core.handlers.errorHandler
import com.knock.api.core.handlers.jsonHandler
import com.knock.api.core.handlers.stringHandler
import com.knock.api.core.handlers.withErrorHandler
import com.knock.api.core.http.HttpMethod
import com.knock.api.core.http.HttpRequest
import com.knock.api.core.http.HttpResponse.Handler
import com.knock.api.core.http.HttpResponseFor
import com.knock.api.core.http.json
import com.knock.api.core.http.parseable
import com.knock.api.core.prepareAsync
import com.knock.api.errors.KnockError
import com.knock.api.models.objects.Object
import com.knock.api.models.objects.ObjectAddSubscriptionsParams
import com.knock.api.models.objects.ObjectDeleteParams
import com.knock.api.models.objects.ObjectDeleteSubscriptionsParams
import com.knock.api.models.objects.ObjectGetChannelDataParams
import com.knock.api.models.objects.ObjectGetParams
import com.knock.api.models.objects.ObjectGetPreferencesParams
import com.knock.api.models.objects.ObjectListMessagesPage
import com.knock.api.models.objects.ObjectListMessagesPageAsync
import com.knock.api.models.objects.ObjectListMessagesParams
import com.knock.api.models.objects.ObjectListPage
import com.knock.api.models.objects.ObjectListPageAsync
import com.knock.api.models.objects.ObjectListParams
import com.knock.api.models.objects.ObjectListSchedulesPage
import com.knock.api.models.objects.ObjectListSchedulesPageAsync
import com.knock.api.models.objects.ObjectListSchedulesParams
import com.knock.api.models.objects.ObjectListSubscriptionsPage
import com.knock.api.models.objects.ObjectListSubscriptionsPageAsync
import com.knock.api.models.objects.ObjectListSubscriptionsParams
import com.knock.api.models.objects.ObjectSetChannelDataParams
import com.knock.api.models.objects.ObjectSetParams
import com.knock.api.models.objects.ObjectSetPreferencesParams
import com.knock.api.models.objects.ObjectUnsetChannelDataParams
import com.knock.api.models.recipients.ChannelData
import com.knock.api.models.recipients.PreferenceSet
import com.knock.api.models.recipients.Subscription
import com.knock.api.services.async.objects.BulkServiceAsync
import com.knock.api.services.async.objects.BulkServiceAsyncImpl
import java.util.concurrent.CompletableFuture

class ObjectServiceAsyncImpl internal constructor(
    private val clientOptions: ClientOptions,

) : ObjectServiceAsync {

    private val withRawResponse: ObjectServiceAsync.WithRawResponse by lazy { WithRawResponseImpl(clientOptions) }

    private val bulk: BulkServiceAsync by lazy { BulkServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): ObjectServiceAsync.WithRawResponse = withRawResponse

    override fun bulk(): BulkServiceAsync = bulk

    override fun list(params: ObjectListParams, requestOptions: RequestOptions): CompletableFuture<ObjectListPageAsync> =
        // get /v1/objects/{collection}
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun delete(params: ObjectDeleteParams, requestOptions: RequestOptions): CompletableFuture<String> =
        // delete /v1/objects/{collection}/{object_id}
        withRawResponse().delete(params, requestOptions).thenApply { it.parse() }

    override fun addSubscriptions(params: ObjectAddSubscriptionsParams, requestOptions: RequestOptions): CompletableFuture<List<Subscription>> =
        // post /v1/objects/{collection}/{object_id}/subscriptions
        withRawResponse().addSubscriptions(params, requestOptions).thenApply { it.parse() }

    override fun deleteSubscriptions(params: ObjectDeleteSubscriptionsParams, requestOptions: RequestOptions): CompletableFuture<List<Subscription>> =
        // delete /v1/objects/{collection}/{object_id}/subscriptions
        withRawResponse().deleteSubscriptions(params, requestOptions).thenApply { it.parse() }

    override fun get(params: ObjectGetParams, requestOptions: RequestOptions): CompletableFuture<Object> =
        // get /v1/objects/{collection}/{object_id}
        withRawResponse().get(params, requestOptions).thenApply { it.parse() }

    override fun getChannelData(params: ObjectGetChannelDataParams, requestOptions: RequestOptions): CompletableFuture<ChannelData> =
        // get /v1/objects/{collection}/{object_id}/channel_data/{channel_id}
        withRawResponse().getChannelData(params, requestOptions).thenApply { it.parse() }

    override fun getPreferences(params: ObjectGetPreferencesParams, requestOptions: RequestOptions): CompletableFuture<PreferenceSet> =
        // get /v1/objects/{collection}/{object_id}/preferences/{preference_set_id}
        withRawResponse().getPreferences(params, requestOptions).thenApply { it.parse() }

    override fun listMessages(params: ObjectListMessagesParams, requestOptions: RequestOptions): CompletableFuture<ObjectListMessagesPageAsync> =
        // get /v1/objects/{collection}/{object_id}/messages
        withRawResponse().listMessages(params, requestOptions).thenApply { it.parse() }

    override fun listSchedules(params: ObjectListSchedulesParams, requestOptions: RequestOptions): CompletableFuture<ObjectListSchedulesPageAsync> =
        // get /v1/objects/{collection}/{object_id}/schedules
        withRawResponse().listSchedules(params, requestOptions).thenApply { it.parse() }

    override fun listSubscriptions(params: ObjectListSubscriptionsParams, requestOptions: RequestOptions): CompletableFuture<ObjectListSubscriptionsPageAsync> =
        // get /v1/objects/{collection}/{object_id}/subscriptions
        withRawResponse().listSubscriptions(params, requestOptions).thenApply { it.parse() }

    override fun set(params: ObjectSetParams, requestOptions: RequestOptions): CompletableFuture<Object> =
        // put /v1/objects/{collection}/{object_id}
        withRawResponse().set(params, requestOptions).thenApply { it.parse() }

    override fun setChannelData(params: ObjectSetChannelDataParams, requestOptions: RequestOptions): CompletableFuture<ChannelData> =
        // put /v1/objects/{collection}/{object_id}/channel_data/{channel_id}
        withRawResponse().setChannelData(params, requestOptions).thenApply { it.parse() }

    override fun setPreferences(params: ObjectSetPreferencesParams, requestOptions: RequestOptions): CompletableFuture<PreferenceSet> =
        // put /v1/objects/{collection}/{object_id}/preferences/{preference_set_id}
        withRawResponse().setPreferences(params, requestOptions).thenApply { it.parse() }

    override fun unsetChannelData(params: ObjectUnsetChannelDataParams, requestOptions: RequestOptions): CompletableFuture<String> =
        // delete /v1/objects/{collection}/{object_id}/channel_data/{channel_id}
        withRawResponse().unsetChannelData(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(
        private val clientOptions: ClientOptions,

    ) : ObjectServiceAsync.WithRawResponse {

        private val errorHandler: Handler<KnockError> = errorHandler(clientOptions.jsonMapper)

        private val bulk: BulkServiceAsync.WithRawResponse by lazy { BulkServiceAsyncImpl.WithRawResponseImpl(clientOptions) }

        override fun bulk(): BulkServiceAsync.WithRawResponse = bulk

        private val listHandler: Handler<ObjectListPageAsync.Response> = jsonHandler<ObjectListPageAsync.Response>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun list(params: ObjectListParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<ObjectListPageAsync>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.GET)
            .addPathSegments("v1", "objects", params.getPathParam(0))
            .build()
            .prepareAsync(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          return request.thenComposeAsync { clientOptions.httpClient.executeAsync(
            it, requestOptions
          ) }.thenApply { response -> response.parseable {
              response.use {
                  listHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.validate()
                  }
              }
              .let {
                  ObjectListPageAsync.of(ObjectServiceAsyncImpl(clientOptions), params, it)
              }
          } }
        }

        private val deleteHandler: Handler<String> = stringHandler().withErrorHandler(errorHandler)

        override fun delete(params: ObjectDeleteParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<String>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.DELETE)
            .addPathSegments("v1", "objects", params.getPathParam(0), params.getPathParam(1))
            .apply { params._body().ifPresent{ body(json(clientOptions.jsonMapper, it)) } }
            .build()
            .prepareAsync(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          return request.thenComposeAsync { clientOptions.httpClient.executeAsync(
            it, requestOptions
          ) }.thenApply { response -> response.parseable {
              response.use {
                  deleteHandler.handle(it)
              }
          } }
        }

        private val addSubscriptionsHandler: Handler<List<Subscription>> = jsonHandler<List<Subscription>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun addSubscriptions(params: ObjectAddSubscriptionsParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<List<Subscription>>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.POST)
            .addPathSegments("v1", "objects", params.getPathParam(0), params.getPathParam(1), "subscriptions")
            .body(json(clientOptions.jsonMapper, params._body()))
            .build()
            .prepareAsync(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          return request.thenComposeAsync { clientOptions.httpClient.executeAsync(
            it, requestOptions
          ) }.thenApply { response -> response.parseable {
              response.use {
                  addSubscriptionsHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.forEach { it.validate() }
                  }
              }
          } }
        }

        private val deleteSubscriptionsHandler: Handler<List<Subscription>> = jsonHandler<List<Subscription>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun deleteSubscriptions(params: ObjectDeleteSubscriptionsParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<List<Subscription>>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.DELETE)
            .addPathSegments("v1", "objects", params.getPathParam(0), params.getPathParam(1), "subscriptions")
            .body(json(clientOptions.jsonMapper, params._body()))
            .build()
            .prepareAsync(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          return request.thenComposeAsync { clientOptions.httpClient.executeAsync(
            it, requestOptions
          ) }.thenApply { response -> response.parseable {
              response.use {
                  deleteSubscriptionsHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.forEach { it.validate() }
                  }
              }
          } }
        }

        private val getHandler: Handler<Object> = jsonHandler<Object>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun get(params: ObjectGetParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<Object>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.GET)
            .addPathSegments("v1", "objects", params.getPathParam(0), params.getPathParam(1))
            .build()
            .prepareAsync(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          return request.thenComposeAsync { clientOptions.httpClient.executeAsync(
            it, requestOptions
          ) }.thenApply { response -> response.parseable {
              response.use {
                  getHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.validate()
                  }
              }
          } }
        }

        private val getChannelDataHandler: Handler<ChannelData> = jsonHandler<ChannelData>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun getChannelData(params: ObjectGetChannelDataParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<ChannelData>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.GET)
            .addPathSegments("v1", "objects", params.getPathParam(0), params.getPathParam(1), "channel_data", params.getPathParam(2))
            .build()
            .prepareAsync(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          return request.thenComposeAsync { clientOptions.httpClient.executeAsync(
            it, requestOptions
          ) }.thenApply { response -> response.parseable {
              response.use {
                  getChannelDataHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.validate()
                  }
              }
          } }
        }

        private val getPreferencesHandler: Handler<PreferenceSet> = jsonHandler<PreferenceSet>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun getPreferences(params: ObjectGetPreferencesParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<PreferenceSet>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.GET)
            .addPathSegments("v1", "objects", params.getPathParam(0), params.getPathParam(1), "preferences", params.getPathParam(2))
            .build()
            .prepareAsync(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          return request.thenComposeAsync { clientOptions.httpClient.executeAsync(
            it, requestOptions
          ) }.thenApply { response -> response.parseable {
              response.use {
                  getPreferencesHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.validate()
                  }
              }
          } }
        }

        private val listMessagesHandler: Handler<ObjectListMessagesPageAsync.Response> = jsonHandler<ObjectListMessagesPageAsync.Response>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun listMessages(params: ObjectListMessagesParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<ObjectListMessagesPageAsync>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.GET)
            .addPathSegments("v1", "objects", params.getPathParam(0), params.getPathParam(1), "messages")
            .build()
            .prepareAsync(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          return request.thenComposeAsync { clientOptions.httpClient.executeAsync(
            it, requestOptions
          ) }.thenApply { response -> response.parseable {
              response.use {
                  listMessagesHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.validate()
                  }
              }
              .let {
                  ObjectListMessagesPageAsync.of(ObjectServiceAsyncImpl(clientOptions), params, it)
              }
          } }
        }

        private val listSchedulesHandler: Handler<ObjectListSchedulesPageAsync.Response> = jsonHandler<ObjectListSchedulesPageAsync.Response>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun listSchedules(params: ObjectListSchedulesParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<ObjectListSchedulesPageAsync>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.GET)
            .addPathSegments("v1", "objects", params.getPathParam(0), params.getPathParam(1), "schedules")
            .build()
            .prepareAsync(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          return request.thenComposeAsync { clientOptions.httpClient.executeAsync(
            it, requestOptions
          ) }.thenApply { response -> response.parseable {
              response.use {
                  listSchedulesHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.validate()
                  }
              }
              .let {
                  ObjectListSchedulesPageAsync.of(ObjectServiceAsyncImpl(clientOptions), params, it)
              }
          } }
        }

        private val listSubscriptionsHandler: Handler<ObjectListSubscriptionsPageAsync.Response> = jsonHandler<ObjectListSubscriptionsPageAsync.Response>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun listSubscriptions(params: ObjectListSubscriptionsParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<ObjectListSubscriptionsPageAsync>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.GET)
            .addPathSegments("v1", "objects", params.getPathParam(0), params.getPathParam(1), "subscriptions")
            .build()
            .prepareAsync(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          return request.thenComposeAsync { clientOptions.httpClient.executeAsync(
            it, requestOptions
          ) }.thenApply { response -> response.parseable {
              response.use {
                  listSubscriptionsHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.validate()
                  }
              }
              .let {
                  ObjectListSubscriptionsPageAsync.of(ObjectServiceAsyncImpl(clientOptions), params, it)
              }
          } }
        }

        private val setHandler: Handler<Object> = jsonHandler<Object>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun set(params: ObjectSetParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<Object>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.PUT)
            .addPathSegments("v1", "objects", params.getPathParam(0), params.getPathParam(1))
            .body(json(clientOptions.jsonMapper, params._body()))
            .build()
            .prepareAsync(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          return request.thenComposeAsync { clientOptions.httpClient.executeAsync(
            it, requestOptions
          ) }.thenApply { response -> response.parseable {
              response.use {
                  setHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.validate()
                  }
              }
          } }
        }

        private val setChannelDataHandler: Handler<ChannelData> = jsonHandler<ChannelData>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun setChannelData(params: ObjectSetChannelDataParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<ChannelData>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.PUT)
            .addPathSegments("v1", "objects", params.getPathParam(0), params.getPathParam(1), "channel_data", params.getPathParam(2))
            .body(json(clientOptions.jsonMapper, params._body()))
            .build()
            .prepareAsync(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          return request.thenComposeAsync { clientOptions.httpClient.executeAsync(
            it, requestOptions
          ) }.thenApply { response -> response.parseable {
              response.use {
                  setChannelDataHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.validate()
                  }
              }
          } }
        }

        private val setPreferencesHandler: Handler<PreferenceSet> = jsonHandler<PreferenceSet>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun setPreferences(params: ObjectSetPreferencesParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<PreferenceSet>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.PUT)
            .addPathSegments("v1", "objects", params.getPathParam(0), params.getPathParam(1), "preferences", params.getPathParam(2))
            .body(json(clientOptions.jsonMapper, params._body()))
            .build()
            .prepareAsync(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          return request.thenComposeAsync { clientOptions.httpClient.executeAsync(
            it, requestOptions
          ) }.thenApply { response -> response.parseable {
              response.use {
                  setPreferencesHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.validate()
                  }
              }
          } }
        }

        private val unsetChannelDataHandler: Handler<String> = stringHandler().withErrorHandler(errorHandler)

        override fun unsetChannelData(params: ObjectUnsetChannelDataParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<String>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.DELETE)
            .addPathSegments("v1", "objects", params.getPathParam(0), params.getPathParam(1), "channel_data", params.getPathParam(2))
            .apply { params._body().ifPresent{ body(json(clientOptions.jsonMapper, it)) } }
            .build()
            .prepareAsync(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          return request.thenComposeAsync { clientOptions.httpClient.executeAsync(
            it, requestOptions
          ) }.thenApply { response -> response.parseable {
              response.use {
                  unsetChannelDataHandler.handle(it)
              }
          } }
        }
    }
}
