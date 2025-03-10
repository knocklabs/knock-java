// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.async.providers

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
import com.knock.api.models.ProviderSlackCheckAuthParams
import com.knock.api.models.ProviderSlackCheckAuthResponse
import com.knock.api.models.ProviderSlackListChannelsPageAsync
import com.knock.api.models.ProviderSlackListChannelsParams
import com.knock.api.models.ProviderSlackRevokeAccessParams
import java.util.concurrent.CompletableFuture

class SlackServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    SlackServiceAsync {

    private val withRawResponse: SlackServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): SlackServiceAsync.WithRawResponse = withRawResponse

    override fun checkAuth(
        params: ProviderSlackCheckAuthParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ProviderSlackCheckAuthResponse> =
        // get /v1/providers/slack/{channel_id}/auth_check
        withRawResponse().checkAuth(params, requestOptions).thenApply { it.parse() }

    override fun listChannels(
        params: ProviderSlackListChannelsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ProviderSlackListChannelsPageAsync> =
        // get /v1/providers/slack/{channel_id}/channels
        withRawResponse().listChannels(params, requestOptions).thenApply { it.parse() }

    override fun revokeAccess(
        params: ProviderSlackRevokeAccessParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<String> =
        // put /v1/providers/slack/{channel_id}/revoke_access
        withRawResponse().revokeAccess(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SlackServiceAsync.WithRawResponse {

        private val errorHandler: Handler<KnockError> = errorHandler(clientOptions.jsonMapper)

        private val checkAuthHandler: Handler<ProviderSlackCheckAuthResponse> =
            jsonHandler<ProviderSlackCheckAuthResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun checkAuth(
            params: ProviderSlackCheckAuthParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ProviderSlackCheckAuthResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments(
                        "v1",
                        "providers",
                        "slack",
                        params.getPathParam(0),
                        "auth_check",
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { checkAuthHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val listChannelsHandler: Handler<ProviderSlackListChannelsPageAsync.Response> =
            jsonHandler<ProviderSlackListChannelsPageAsync.Response>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun listChannels(
            params: ProviderSlackListChannelsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ProviderSlackListChannelsPageAsync>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "providers", "slack", params.getPathParam(0), "channels")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { listChannelsHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                            .let {
                                ProviderSlackListChannelsPageAsync.of(
                                    SlackServiceAsyncImpl(clientOptions),
                                    params,
                                    it,
                                )
                            }
                    }
                }
        }

        private val revokeAccessHandler: Handler<String> =
            stringHandler().withErrorHandler(errorHandler)

        override fun revokeAccess(
            params: ProviderSlackRevokeAccessParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<String>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .addPathSegments(
                        "v1",
                        "providers",
                        "slack",
                        params.getPathParam(0),
                        "revoke_access",
                    )
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable { response.use { revokeAccessHandler.handle(it) } }
                }
        }
    }
}
