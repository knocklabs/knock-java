// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.async.users

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
import com.knock.api.core.prepareAsync
import com.knock.api.errors.KnockError
import com.knock.api.models.UserBulkDeleteParams
import com.knock.api.models.UserBulkDeleteResponse
import com.knock.api.models.UserBulkIdentifyParams
import com.knock.api.models.UserBulkIdentifyResponse
import com.knock.api.models.UserBulkSetPreferencesParams
import com.knock.api.models.UserBulkSetPreferencesResponse
import java.util.concurrent.CompletableFuture

class BulkServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    BulkServiceAsync {

    private val withRawResponse: BulkServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): BulkServiceAsync.WithRawResponse = withRawResponse

    override fun delete(
        params: UserBulkDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<UserBulkDeleteResponse> =
        // post /v1/users/bulk/delete
        withRawResponse().delete(params, requestOptions).thenApply { it.parse() }

    override fun identify(
        params: UserBulkIdentifyParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<UserBulkIdentifyResponse> =
        // post /v1/users/bulk/identify
        withRawResponse().identify(params, requestOptions).thenApply { it.parse() }

    override fun setPreferences(
        params: UserBulkSetPreferencesParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<UserBulkSetPreferencesResponse> =
        // post /v1/users/bulk/preferences
        withRawResponse().setPreferences(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        BulkServiceAsync.WithRawResponse {

        private val errorHandler: Handler<KnockError> = errorHandler(clientOptions.jsonMapper)

        private val deleteHandler: Handler<UserBulkDeleteResponse> =
            jsonHandler<UserBulkDeleteResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun delete(
            params: UserBulkDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UserBulkDeleteResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "users", "bulk", "delete")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { deleteHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
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
        ): CompletableFuture<HttpResponseFor<UserBulkIdentifyResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "users", "bulk", "identify")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { identifyHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
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
        ): CompletableFuture<HttpResponseFor<UserBulkSetPreferencesResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "users", "bulk", "preferences")
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
    }
}
