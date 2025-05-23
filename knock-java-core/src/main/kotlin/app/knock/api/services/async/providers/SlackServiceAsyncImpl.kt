// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async.providers

import app.knock.api.core.ClientOptions
import app.knock.api.core.JsonValue
import app.knock.api.core.RequestOptions
import app.knock.api.core.checkRequired
import app.knock.api.core.handlers.errorHandler
import app.knock.api.core.handlers.jsonHandler
import app.knock.api.core.handlers.withErrorHandler
import app.knock.api.core.http.HttpMethod
import app.knock.api.core.http.HttpRequest
import app.knock.api.core.http.HttpResponse.Handler
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.core.http.json
import app.knock.api.core.http.parseable
import app.knock.api.core.prepareAsync
import app.knock.api.models.providers.slack.SlackCheckAuthParams
import app.knock.api.models.providers.slack.SlackCheckAuthResponse
import app.knock.api.models.providers.slack.SlackListChannelsPageAsync
import app.knock.api.models.providers.slack.SlackListChannelsPageResponse
import app.knock.api.models.providers.slack.SlackListChannelsParams
import app.knock.api.models.providers.slack.SlackRevokeAccessParams
import app.knock.api.models.providers.slack.SlackRevokeAccessResponse
import java.util.concurrent.CompletableFuture
import kotlin.jvm.optionals.getOrNull

class SlackServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    SlackServiceAsync {

    private val withRawResponse: SlackServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): SlackServiceAsync.WithRawResponse = withRawResponse

    override fun checkAuth(
        params: SlackCheckAuthParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<SlackCheckAuthResponse> =
        // get /v1/providers/slack/{channel_id}/auth_check
        withRawResponse().checkAuth(params, requestOptions).thenApply { it.parse() }

    override fun listChannels(
        params: SlackListChannelsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<SlackListChannelsPageAsync> =
        // get /v1/providers/slack/{channel_id}/channels
        withRawResponse().listChannels(params, requestOptions).thenApply { it.parse() }

    override fun revokeAccess(
        params: SlackRevokeAccessParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<SlackRevokeAccessResponse> =
        // put /v1/providers/slack/{channel_id}/revoke_access
        withRawResponse().revokeAccess(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SlackServiceAsync.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val checkAuthHandler: Handler<SlackCheckAuthResponse> =
            jsonHandler<SlackCheckAuthResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun checkAuth(
            params: SlackCheckAuthParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<SlackCheckAuthResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("channelId", params.channelId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "providers", "slack", params._pathParam(0), "auth_check")
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

        private val listChannelsHandler: Handler<SlackListChannelsPageResponse> =
            jsonHandler<SlackListChannelsPageResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun listChannels(
            params: SlackListChannelsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<SlackListChannelsPageAsync>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("channelId", params.channelId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "providers", "slack", params._pathParam(0), "channels")
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
                                SlackListChannelsPageAsync.builder()
                                    .service(SlackServiceAsyncImpl(clientOptions))
                                    .params(params)
                                    .response(it)
                                    .build()
                            }
                    }
                }
        }

        private val revokeAccessHandler: Handler<SlackRevokeAccessResponse> =
            jsonHandler<SlackRevokeAccessResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun revokeAccess(
            params: SlackRevokeAccessParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<SlackRevokeAccessResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("channelId", params.channelId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .addPathSegments(
                        "v1",
                        "providers",
                        "slack",
                        params._pathParam(0),
                        "revoke_access",
                    )
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { revokeAccessHandler.handle(it) }
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
