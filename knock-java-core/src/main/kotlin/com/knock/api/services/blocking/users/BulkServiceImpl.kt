// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.blocking.users

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
import com.knock.api.models.UserBulkDeleteParams
import com.knock.api.models.UserBulkDeleteResponse
import com.knock.api.models.UserBulkIdentifyParams
import com.knock.api.models.UserBulkIdentifyResponse
import com.knock.api.models.UserBulkSetPreferencesParams
import com.knock.api.models.UserBulkSetPreferencesResponse

class BulkServiceImpl internal constructor(private val clientOptions: ClientOptions) : BulkService {

    private val withRawResponse: BulkService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): BulkService.WithRawResponse = withRawResponse

    override fun delete(
        params: UserBulkDeleteParams,
        requestOptions: RequestOptions,
    ): UserBulkDeleteResponse =
        // post /v1/users/bulk/delete
        withRawResponse().delete(params, requestOptions).parse()

    override fun identify(
        params: UserBulkIdentifyParams,
        requestOptions: RequestOptions,
    ): UserBulkIdentifyResponse =
        // post /v1/users/bulk/identify
        withRawResponse().identify(params, requestOptions).parse()

    override fun setPreferences(
        params: UserBulkSetPreferencesParams,
        requestOptions: RequestOptions,
    ): UserBulkSetPreferencesResponse =
        // post /v1/users/bulk/preferences
        withRawResponse().setPreferences(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        BulkService.WithRawResponse {

        private val errorHandler: Handler<KnockError> = errorHandler(clientOptions.jsonMapper)

        private val deleteHandler: Handler<UserBulkDeleteResponse> =
            jsonHandler<UserBulkDeleteResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun delete(
            params: UserBulkDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<UserBulkDeleteResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "users", "bulk", "delete")
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
                            it.validate()
                        }
                    }
            }
        }

        private val identifyHandler: Handler<UserBulkIdentifyResponse> =
            jsonHandler<UserBulkIdentifyResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun identify(
            params: UserBulkIdentifyParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<UserBulkIdentifyResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "users", "bulk", "identify")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { identifyHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val setPreferencesHandler: Handler<UserBulkSetPreferencesResponse> =
            jsonHandler<UserBulkSetPreferencesResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun setPreferences(
            params: UserBulkSetPreferencesParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<UserBulkSetPreferencesResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "users", "bulk", "preferences")
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
    }
}
