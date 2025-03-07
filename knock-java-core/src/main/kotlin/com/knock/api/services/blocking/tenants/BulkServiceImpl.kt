// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.blocking.tenants

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
import com.knock.api.models.TenantBulkDeleteParams
import com.knock.api.models.TenantBulkDeleteResponse
import com.knock.api.models.TenantBulkSetParams
import com.knock.api.models.TenantBulkSetResponse

class BulkServiceImpl internal constructor(private val clientOptions: ClientOptions) : BulkService {

    private val withRawResponse: BulkService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): BulkService.WithRawResponse = withRawResponse

    override fun delete(
        params: TenantBulkDeleteParams,
        requestOptions: RequestOptions,
    ): TenantBulkDeleteResponse =
        // post /v1/tenants/bulk/delete
        withRawResponse().delete(params, requestOptions).parse()

    override fun set(
        params: TenantBulkSetParams,
        requestOptions: RequestOptions,
    ): TenantBulkSetResponse =
        // post /v1/tenants/bulk/set
        withRawResponse().set(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        BulkService.WithRawResponse {

        private val errorHandler: Handler<KnockError> = errorHandler(clientOptions.jsonMapper)

        private val deleteHandler: Handler<TenantBulkDeleteResponse> =
            jsonHandler<TenantBulkDeleteResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun delete(
            params: TenantBulkDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TenantBulkDeleteResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "tenants", "bulk", "delete")
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { deleteHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val setHandler: Handler<TenantBulkSetResponse> =
            jsonHandler<TenantBulkSetResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun set(
            params: TenantBulkSetParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TenantBulkSetResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "tenants", "bulk", "set")
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
