// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.blocking

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
import com.knock.api.core.prepare
import com.knock.api.errors.KnockError
import com.knock.api.models.objects.Object
import com.knock.api.models.objects.ObjectAddSubscriptionsParams
import com.knock.api.models.objects.ObjectDeleteParams
import com.knock.api.models.objects.ObjectDeleteSubscriptionsParams
import com.knock.api.models.objects.ObjectGetChannelDataParams
import com.knock.api.models.objects.ObjectGetParams
import com.knock.api.models.objects.ObjectGetPreferencesParams
import com.knock.api.models.objects.ObjectListMessagesPage
import com.knock.api.models.objects.ObjectListMessagesParams
import com.knock.api.models.objects.ObjectListPage
import com.knock.api.models.objects.ObjectListParams
import com.knock.api.models.objects.ObjectListSchedulesPage
import com.knock.api.models.objects.ObjectListSchedulesParams
import com.knock.api.models.objects.ObjectListSubscriptionsPage
import com.knock.api.models.objects.ObjectListSubscriptionsParams
import com.knock.api.models.objects.ObjectSetChannelDataParams
import com.knock.api.models.objects.ObjectSetParams
import com.knock.api.models.objects.ObjectSetPreferencesParams
import com.knock.api.models.objects.ObjectUnsetChannelDataParams
import com.knock.api.models.recipients.ChannelData
import com.knock.api.models.recipients.PreferenceSet
import com.knock.api.models.recipients.Subscription
import com.knock.api.services.blocking.objects.BulkService
import com.knock.api.services.blocking.objects.BulkServiceImpl

class ObjectServiceImpl internal constructor(
    private val clientOptions: ClientOptions,

) : ObjectService {

    private val withRawResponse: ObjectService.WithRawResponse by lazy { WithRawResponseImpl(clientOptions) }

    private val bulk: BulkService by lazy { BulkServiceImpl(clientOptions) }

    override fun withRawResponse(): ObjectService.WithRawResponse = withRawResponse

    override fun bulk(): BulkService = bulk

    override fun list(params: ObjectListParams, requestOptions: RequestOptions): ObjectListPage =
        // get /v1/objects/{collection}
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(params: ObjectDeleteParams, requestOptions: RequestOptions): String =
        // delete /v1/objects/{collection}/{object_id}
        withRawResponse().delete(params, requestOptions).parse()

    override fun addSubscriptions(params: ObjectAddSubscriptionsParams, requestOptions: RequestOptions): List<Subscription> =
        // post /v1/objects/{collection}/{object_id}/subscriptions
        withRawResponse().addSubscriptions(params, requestOptions).parse()

    override fun deleteSubscriptions(params: ObjectDeleteSubscriptionsParams, requestOptions: RequestOptions): List<Subscription> =
        // delete /v1/objects/{collection}/{object_id}/subscriptions
        withRawResponse().deleteSubscriptions(params, requestOptions).parse()

    override fun get(params: ObjectGetParams, requestOptions: RequestOptions): Object =
        // get /v1/objects/{collection}/{object_id}
        withRawResponse().get(params, requestOptions).parse()

    override fun getChannelData(params: ObjectGetChannelDataParams, requestOptions: RequestOptions): ChannelData =
        // get /v1/objects/{collection}/{object_id}/channel_data/{channel_id}
        withRawResponse().getChannelData(params, requestOptions).parse()

    override fun getPreferences(params: ObjectGetPreferencesParams, requestOptions: RequestOptions): PreferenceSet =
        // get /v1/objects/{collection}/{object_id}/preferences/{preference_set_id}
        withRawResponse().getPreferences(params, requestOptions).parse()

    override fun listMessages(params: ObjectListMessagesParams, requestOptions: RequestOptions): ObjectListMessagesPage =
        // get /v1/objects/{collection}/{object_id}/messages
        withRawResponse().listMessages(params, requestOptions).parse()

    override fun listSchedules(params: ObjectListSchedulesParams, requestOptions: RequestOptions): ObjectListSchedulesPage =
        // get /v1/objects/{collection}/{object_id}/schedules
        withRawResponse().listSchedules(params, requestOptions).parse()

    override fun listSubscriptions(params: ObjectListSubscriptionsParams, requestOptions: RequestOptions): ObjectListSubscriptionsPage =
        // get /v1/objects/{collection}/{object_id}/subscriptions
        withRawResponse().listSubscriptions(params, requestOptions).parse()

    override fun set(params: ObjectSetParams, requestOptions: RequestOptions): Object =
        // put /v1/objects/{collection}/{object_id}
        withRawResponse().set(params, requestOptions).parse()

    override fun setChannelData(params: ObjectSetChannelDataParams, requestOptions: RequestOptions): ChannelData =
        // put /v1/objects/{collection}/{object_id}/channel_data/{channel_id}
        withRawResponse().setChannelData(params, requestOptions).parse()

    override fun setPreferences(params: ObjectSetPreferencesParams, requestOptions: RequestOptions): PreferenceSet =
        // put /v1/objects/{collection}/{object_id}/preferences/{preference_set_id}
        withRawResponse().setPreferences(params, requestOptions).parse()

    override fun unsetChannelData(params: ObjectUnsetChannelDataParams, requestOptions: RequestOptions): String =
        // delete /v1/objects/{collection}/{object_id}/channel_data/{channel_id}
        withRawResponse().unsetChannelData(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(
        private val clientOptions: ClientOptions,

    ) : ObjectService.WithRawResponse {

        private val errorHandler: Handler<KnockError> = errorHandler(clientOptions.jsonMapper)

        private val bulk: BulkService.WithRawResponse by lazy { BulkServiceImpl.WithRawResponseImpl(clientOptions) }

        override fun bulk(): BulkService.WithRawResponse = bulk

        private val listHandler: Handler<ObjectListPage.Response> = jsonHandler<ObjectListPage.Response>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun list(params: ObjectListParams, requestOptions: RequestOptions): HttpResponseFor<ObjectListPage> {
          val request = HttpRequest.builder()
            .method(HttpMethod.GET)
            .addPathSegments("v1", "objects", params.getPathParam(0))
            .build()
            .prepare(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          val response = clientOptions.httpClient.execute(
            request, requestOptions
          )
          return response.parseable {
              response.use {
                  listHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.validate()
                  }
              }
              .let {
                  ObjectListPage.of(ObjectServiceImpl(clientOptions), params, it)
              }
          }
        }

        private val deleteHandler: Handler<String> = stringHandler().withErrorHandler(errorHandler)

        override fun delete(params: ObjectDeleteParams, requestOptions: RequestOptions): HttpResponseFor<String> {
          val request = HttpRequest.builder()
            .method(HttpMethod.DELETE)
            .addPathSegments("v1", "objects", params.getPathParam(0), params.getPathParam(1))
            .apply { params._body().ifPresent{ body(json(clientOptions.jsonMapper, it)) } }
            .build()
            .prepare(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          val response = clientOptions.httpClient.execute(
            request, requestOptions
          )
          return response.parseable {
              response.use {
                  deleteHandler.handle(it)
              }
          }
        }

        private val addSubscriptionsHandler: Handler<List<Subscription>> = jsonHandler<List<Subscription>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun addSubscriptions(params: ObjectAddSubscriptionsParams, requestOptions: RequestOptions): HttpResponseFor<List<Subscription>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.POST)
            .addPathSegments("v1", "objects", params.getPathParam(0), params.getPathParam(1), "subscriptions")
            .body(json(clientOptions.jsonMapper, params._body()))
            .build()
            .prepare(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          val response = clientOptions.httpClient.execute(
            request, requestOptions
          )
          return response.parseable {
              response.use {
                  addSubscriptionsHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.forEach { it.validate() }
                  }
              }
          }
        }

        private val deleteSubscriptionsHandler: Handler<List<Subscription>> = jsonHandler<List<Subscription>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun deleteSubscriptions(params: ObjectDeleteSubscriptionsParams, requestOptions: RequestOptions): HttpResponseFor<List<Subscription>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.DELETE)
            .addPathSegments("v1", "objects", params.getPathParam(0), params.getPathParam(1), "subscriptions")
            .body(json(clientOptions.jsonMapper, params._body()))
            .build()
            .prepare(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          val response = clientOptions.httpClient.execute(
            request, requestOptions
          )
          return response.parseable {
              response.use {
                  deleteSubscriptionsHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.forEach { it.validate() }
                  }
              }
          }
        }

        private val getHandler: Handler<Object> = jsonHandler<Object>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun get(params: ObjectGetParams, requestOptions: RequestOptions): HttpResponseFor<Object> {
          val request = HttpRequest.builder()
            .method(HttpMethod.GET)
            .addPathSegments("v1", "objects", params.getPathParam(0), params.getPathParam(1))
            .build()
            .prepare(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          val response = clientOptions.httpClient.execute(
            request, requestOptions
          )
          return response.parseable {
              response.use {
                  getHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.validate()
                  }
              }
          }
        }

        private val getChannelDataHandler: Handler<ChannelData> = jsonHandler<ChannelData>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun getChannelData(params: ObjectGetChannelDataParams, requestOptions: RequestOptions): HttpResponseFor<ChannelData> {
          val request = HttpRequest.builder()
            .method(HttpMethod.GET)
            .addPathSegments("v1", "objects", params.getPathParam(0), params.getPathParam(1), "channel_data", params.getPathParam(2))
            .build()
            .prepare(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          val response = clientOptions.httpClient.execute(
            request, requestOptions
          )
          return response.parseable {
              response.use {
                  getChannelDataHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.validate()
                  }
              }
          }
        }

        private val getPreferencesHandler: Handler<PreferenceSet> = jsonHandler<PreferenceSet>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun getPreferences(params: ObjectGetPreferencesParams, requestOptions: RequestOptions): HttpResponseFor<PreferenceSet> {
          val request = HttpRequest.builder()
            .method(HttpMethod.GET)
            .addPathSegments("v1", "objects", params.getPathParam(0), params.getPathParam(1), "preferences", params.getPathParam(2))
            .build()
            .prepare(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          val response = clientOptions.httpClient.execute(
            request, requestOptions
          )
          return response.parseable {
              response.use {
                  getPreferencesHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.validate()
                  }
              }
          }
        }

        private val listMessagesHandler: Handler<ObjectListMessagesPage.Response> = jsonHandler<ObjectListMessagesPage.Response>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun listMessages(params: ObjectListMessagesParams, requestOptions: RequestOptions): HttpResponseFor<ObjectListMessagesPage> {
          val request = HttpRequest.builder()
            .method(HttpMethod.GET)
            .addPathSegments("v1", "objects", params.getPathParam(0), params.getPathParam(1), "messages")
            .build()
            .prepare(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          val response = clientOptions.httpClient.execute(
            request, requestOptions
          )
          return response.parseable {
              response.use {
                  listMessagesHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.validate()
                  }
              }
              .let {
                  ObjectListMessagesPage.of(ObjectServiceImpl(clientOptions), params, it)
              }
          }
        }

        private val listSchedulesHandler: Handler<ObjectListSchedulesPage.Response> = jsonHandler<ObjectListSchedulesPage.Response>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun listSchedules(params: ObjectListSchedulesParams, requestOptions: RequestOptions): HttpResponseFor<ObjectListSchedulesPage> {
          val request = HttpRequest.builder()
            .method(HttpMethod.GET)
            .addPathSegments("v1", "objects", params.getPathParam(0), params.getPathParam(1), "schedules")
            .build()
            .prepare(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          val response = clientOptions.httpClient.execute(
            request, requestOptions
          )
          return response.parseable {
              response.use {
                  listSchedulesHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.validate()
                  }
              }
              .let {
                  ObjectListSchedulesPage.of(ObjectServiceImpl(clientOptions), params, it)
              }
          }
        }

        private val listSubscriptionsHandler: Handler<ObjectListSubscriptionsPage.Response> = jsonHandler<ObjectListSubscriptionsPage.Response>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun listSubscriptions(params: ObjectListSubscriptionsParams, requestOptions: RequestOptions): HttpResponseFor<ObjectListSubscriptionsPage> {
          val request = HttpRequest.builder()
            .method(HttpMethod.GET)
            .addPathSegments("v1", "objects", params.getPathParam(0), params.getPathParam(1), "subscriptions")
            .build()
            .prepare(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          val response = clientOptions.httpClient.execute(
            request, requestOptions
          )
          return response.parseable {
              response.use {
                  listSubscriptionsHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.validate()
                  }
              }
              .let {
                  ObjectListSubscriptionsPage.of(ObjectServiceImpl(clientOptions), params, it)
              }
          }
        }

        private val setHandler: Handler<Object> = jsonHandler<Object>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun set(params: ObjectSetParams, requestOptions: RequestOptions): HttpResponseFor<Object> {
          val request = HttpRequest.builder()
            .method(HttpMethod.PUT)
            .addPathSegments("v1", "objects", params.getPathParam(0), params.getPathParam(1))
            .body(json(clientOptions.jsonMapper, params._body()))
            .build()
            .prepare(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          val response = clientOptions.httpClient.execute(
            request, requestOptions
          )
          return response.parseable {
              response.use {
                  setHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.validate()
                  }
              }
          }
        }

        private val setChannelDataHandler: Handler<ChannelData> = jsonHandler<ChannelData>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun setChannelData(params: ObjectSetChannelDataParams, requestOptions: RequestOptions): HttpResponseFor<ChannelData> {
          val request = HttpRequest.builder()
            .method(HttpMethod.PUT)
            .addPathSegments("v1", "objects", params.getPathParam(0), params.getPathParam(1), "channel_data", params.getPathParam(2))
            .body(json(clientOptions.jsonMapper, params._body()))
            .build()
            .prepare(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          val response = clientOptions.httpClient.execute(
            request, requestOptions
          )
          return response.parseable {
              response.use {
                  setChannelDataHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.validate()
                  }
              }
          }
        }

        private val setPreferencesHandler: Handler<PreferenceSet> = jsonHandler<PreferenceSet>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun setPreferences(params: ObjectSetPreferencesParams, requestOptions: RequestOptions): HttpResponseFor<PreferenceSet> {
          val request = HttpRequest.builder()
            .method(HttpMethod.PUT)
            .addPathSegments("v1", "objects", params.getPathParam(0), params.getPathParam(1), "preferences", params.getPathParam(2))
            .body(json(clientOptions.jsonMapper, params._body()))
            .build()
            .prepare(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          val response = clientOptions.httpClient.execute(
            request, requestOptions
          )
          return response.parseable {
              response.use {
                  setPreferencesHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.validate()
                  }
              }
          }
        }

        private val unsetChannelDataHandler: Handler<String> = stringHandler().withErrorHandler(errorHandler)

        override fun unsetChannelData(params: ObjectUnsetChannelDataParams, requestOptions: RequestOptions): HttpResponseFor<String> {
          val request = HttpRequest.builder()
            .method(HttpMethod.DELETE)
            .addPathSegments("v1", "objects", params.getPathParam(0), params.getPathParam(1), "channel_data", params.getPathParam(2))
            .apply { params._body().ifPresent{ body(json(clientOptions.jsonMapper, it)) } }
            .build()
            .prepare(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          val response = clientOptions.httpClient.execute(
            request, requestOptions
          )
          return response.parseable {
              response.use {
                  unsetChannelDataHandler.handle(it)
              }
          }
        }
    }
}
