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
import com.knock.api.models.tenants.Tenant
import com.knock.api.models.tenants.TenantDeleteParams
import com.knock.api.models.tenants.TenantGetParams
import com.knock.api.models.tenants.TenantListPage
import com.knock.api.models.tenants.TenantListParams
import com.knock.api.models.tenants.TenantSetParams
import com.knock.api.services.blocking.tenants.BulkService
import com.knock.api.services.blocking.tenants.BulkServiceImpl

class TenantServiceImpl internal constructor(
    private val clientOptions: ClientOptions,

) : TenantService {

    private val withRawResponse: TenantService.WithRawResponse by lazy { WithRawResponseImpl(clientOptions) }

    private val bulk: BulkService by lazy { BulkServiceImpl(clientOptions) }

    override fun withRawResponse(): TenantService.WithRawResponse = withRawResponse

    override fun bulk(): BulkService = bulk

    override fun list(params: TenantListParams, requestOptions: RequestOptions): TenantListPage =
        // get /v1/tenants
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(params: TenantDeleteParams, requestOptions: RequestOptions): String =
        // delete /v1/tenants/{tenant_id}
        withRawResponse().delete(params, requestOptions).parse()

    override fun get(params: TenantGetParams, requestOptions: RequestOptions): Tenant =
        // get /v1/tenants/{tenant_id}
        withRawResponse().get(params, requestOptions).parse()

    override fun set(params: TenantSetParams, requestOptions: RequestOptions): Tenant =
        // put /v1/tenants/{tenant_id}
        withRawResponse().set(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(
        private val clientOptions: ClientOptions,

    ) : TenantService.WithRawResponse {

        private val errorHandler: Handler<KnockError> = errorHandler(clientOptions.jsonMapper)

        private val bulk: BulkService.WithRawResponse by lazy { BulkServiceImpl.WithRawResponseImpl(clientOptions) }

        override fun bulk(): BulkService.WithRawResponse = bulk

        private val listHandler: Handler<TenantListPage.Response> = jsonHandler<TenantListPage.Response>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun list(params: TenantListParams, requestOptions: RequestOptions): HttpResponseFor<TenantListPage> {
          val request = HttpRequest.builder()
            .method(HttpMethod.GET)
            .addPathSegments("v1", "tenants")
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
                  TenantListPage.of(TenantServiceImpl(clientOptions), params, it)
              }
          }
        }

        private val deleteHandler: Handler<String> = stringHandler().withErrorHandler(errorHandler)

        override fun delete(params: TenantDeleteParams, requestOptions: RequestOptions): HttpResponseFor<String> {
          val request = HttpRequest.builder()
            .method(HttpMethod.DELETE)
            .addPathSegments("v1", "tenants", params.getPathParam(0))
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

        private val getHandler: Handler<Tenant> = jsonHandler<Tenant>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun get(params: TenantGetParams, requestOptions: RequestOptions): HttpResponseFor<Tenant> {
          val request = HttpRequest.builder()
            .method(HttpMethod.GET)
            .addPathSegments("v1", "tenants", params.getPathParam(0))
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

        private val setHandler: Handler<Tenant> = jsonHandler<Tenant>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun set(params: TenantSetParams, requestOptions: RequestOptions): HttpResponseFor<Tenant> {
          val request = HttpRequest.builder()
            .method(HttpMethod.PUT)
            .addPathSegments("v1", "tenants", params.getPathParam(0))
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
    }
}
