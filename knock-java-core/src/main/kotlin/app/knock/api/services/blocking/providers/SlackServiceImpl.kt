// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking.providers

import app.knock.api.core.ClientOptions
import app.knock.api.core.RequestOptions
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
import app.knock.api.core.prepare
import app.knock.api.errors.KnockError
import app.knock.api.models.providers.slack.SlackCheckAuthParams
import app.knock.api.models.providers.slack.SlackCheckAuthResponse
import app.knock.api.models.providers.slack.SlackListChannelsPage
import app.knock.api.models.providers.slack.SlackListChannelsParams
import app.knock.api.models.providers.slack.SlackRevokeAccessParams

class SlackServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    SlackService {

    private val withRawResponse: SlackService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): SlackService.WithRawResponse = withRawResponse

    override fun checkAuth(
        params: SlackCheckAuthParams,
        requestOptions: RequestOptions,
    ): SlackCheckAuthResponse =
        // get /v1/providers/slack/{channel_id}/auth_check
        withRawResponse().checkAuth(params, requestOptions).parse()

    override fun listChannels(
        params: SlackListChannelsParams,
        requestOptions: RequestOptions,
    ): SlackListChannelsPage =
        // get /v1/providers/slack/{channel_id}/channels
        withRawResponse().listChannels(params, requestOptions).parse()

    override fun revokeAccess(
        params: SlackRevokeAccessParams,
        requestOptions: RequestOptions,
    ): String =
        // put /v1/providers/slack/{channel_id}/revoke_access
        withRawResponse().revokeAccess(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SlackService.WithRawResponse {

        private val errorHandler: Handler<KnockError> = errorHandler(clientOptions.jsonMapper)

        private val checkAuthHandler: Handler<SlackCheckAuthResponse> =
            jsonHandler<SlackCheckAuthResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun checkAuth(
            params: SlackCheckAuthParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SlackCheckAuthResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "providers", "slack", params._pathParam(0), "auth_check")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { checkAuthHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listChannelsHandler: Handler<SlackListChannelsPage.Response> =
            jsonHandler<SlackListChannelsPage.Response>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun listChannels(
            params: SlackListChannelsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SlackListChannelsPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "providers", "slack", params._pathParam(0), "channels")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { listChannelsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let { SlackListChannelsPage.of(SlackServiceImpl(clientOptions), params, it) }
            }
        }

        private val revokeAccessHandler: Handler<String> =
            stringHandler().withErrorHandler(errorHandler)

        override fun revokeAccess(
            params: SlackRevokeAccessParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<String> {
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable { response.use { revokeAccessHandler.handle(it) } }
        }
    }
}
