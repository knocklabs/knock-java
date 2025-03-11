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
import com.knock.api.models.tenants.Tenant
import com.knock.api.models.tenants.TenantDeleteParams
import com.knock.api.models.tenants.TenantGetParams
import com.knock.api.models.tenants.TenantListPage
import com.knock.api.models.tenants.TenantListPageAsync
import com.knock.api.models.tenants.TenantListParams
import com.knock.api.models.tenants.TenantSetParams
import com.knock.api.services.async.tenants.BulkServiceAsync
import com.knock.api.services.async.tenants.BulkServiceAsyncImpl
import java.util.concurrent.CompletableFuture

class TenantServiceAsyncImpl internal constructor(
    private val clientOptions: ClientOptions,

) : TenantServiceAsync {

    private val withRawResponse: TenantServiceAsync.WithRawResponse by lazy { WithRawResponseImpl(clientOptions) }

    private val bulk: BulkServiceAsync by lazy { BulkServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): TenantServiceAsync.WithRawResponse = withRawResponse

    override fun bulk(): BulkServiceAsync = bulk

    override fun list(params: TenantListParams, requestOptions: RequestOptions): CompletableFuture<TenantListPageAsync> =
        // get /v1/tenants
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun delete(params: TenantDeleteParams, requestOptions: RequestOptions): CompletableFuture<String> =
        // delete /v1/tenants/{tenant_id}
        withRawResponse().delete(params, requestOptions).thenApply { it.parse() }

    override fun get(params: TenantGetParams, requestOptions: RequestOptions): CompletableFuture<Tenant> =
        // get /v1/tenants/{tenant_id}
        withRawResponse().get(params, requestOptions).thenApply { it.parse() }

    override fun set(params: TenantSetParams, requestOptions: RequestOptions): CompletableFuture<Tenant> =
        // put /v1/tenants/{tenant_id}
        withRawResponse().set(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(
        private val clientOptions: ClientOptions,

    ) : TenantServiceAsync.WithRawResponse {

        private val errorHandler: Handler<KnockError> = errorHandler(clientOptions.jsonMapper)

        private val bulk: BulkServiceAsync.WithRawResponse by lazy { BulkServiceAsyncImpl.WithRawResponseImpl(clientOptions) }

        override fun bulk(): BulkServiceAsync.WithRawResponse = bulk

        private val listHandler: Handler<TenantListPageAsync.Response> = jsonHandler<TenantListPageAsync.Response>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun list(params: TenantListParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<TenantListPageAsync>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.GET)
            .addPathSegments("v1", "tenants")
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
                  TenantListPageAsync.of(TenantServiceAsyncImpl(clientOptions), params, it)
              }
          } }
        }

        private val deleteHandler: Handler<String> = stringHandler().withErrorHandler(errorHandler)

        override fun delete(params: TenantDeleteParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<String>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.DELETE)
            .addPathSegments("v1", "tenants", params.getPathParam(0))
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

        private val getHandler: Handler<Tenant> = jsonHandler<Tenant>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun get(params: TenantGetParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<Tenant>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.GET)
            .addPathSegments("v1", "tenants", params.getPathParam(0))
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

        private val setHandler: Handler<Tenant> = jsonHandler<Tenant>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun set(params: TenantSetParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<Tenant>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.PUT)
            .addPathSegments("v1", "tenants", params.getPathParam(0))
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
    }
}
