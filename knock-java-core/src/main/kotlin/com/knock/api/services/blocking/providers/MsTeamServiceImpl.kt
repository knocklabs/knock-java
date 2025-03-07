// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.blocking.providers

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
import com.knock.api.models.ProviderMsTeamCheckAuthParams
import com.knock.api.models.ProviderMsTeamCheckAuthResponse
import com.knock.api.models.ProviderMsTeamListChannelsParams
import com.knock.api.models.ProviderMsTeamListChannelsResponse
import com.knock.api.models.ProviderMsTeamListTeamsParams
import com.knock.api.models.ProviderMsTeamListTeamsResponse
import com.knock.api.models.ProviderMsTeamRevokeAccessParams

class MsTeamServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    MsTeamService {

    private val withRawResponse: MsTeamService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): MsTeamService.WithRawResponse = withRawResponse

    override fun checkAuth(
        params: ProviderMsTeamCheckAuthParams,
        requestOptions: RequestOptions,
    ): ProviderMsTeamCheckAuthResponse =
        // get /v1/providers/ms-teams/{channel_id}/auth_check
        withRawResponse().checkAuth(params, requestOptions).parse()

    override fun listChannels(
        params: ProviderMsTeamListChannelsParams,
        requestOptions: RequestOptions,
    ): ProviderMsTeamListChannelsResponse =
        // get /v1/providers/ms-teams/{channel_id}/channels
        withRawResponse().listChannels(params, requestOptions).parse()

    override fun listTeams(
        params: ProviderMsTeamListTeamsParams,
        requestOptions: RequestOptions,
    ): ProviderMsTeamListTeamsResponse =
        // get /v1/providers/ms-teams/{channel_id}/teams
        withRawResponse().listTeams(params, requestOptions).parse()

    override fun revokeAccess(
        params: ProviderMsTeamRevokeAccessParams,
        requestOptions: RequestOptions,
    ): String =
        // put /v1/providers/ms-teams/{channel_id}/revoke_access
        withRawResponse().revokeAccess(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        MsTeamService.WithRawResponse {

        private val errorHandler: Handler<KnockError> = errorHandler(clientOptions.jsonMapper)

        private val checkAuthHandler: Handler<ProviderMsTeamCheckAuthResponse> =
            jsonHandler<ProviderMsTeamCheckAuthResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun checkAuth(
            params: ProviderMsTeamCheckAuthParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProviderMsTeamCheckAuthResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments(
                        "v1",
                        "providers",
                        "ms-teams",
                        params.getPathParam(0),
                        "auth_check",
                    )
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

        private val listChannelsHandler: Handler<ProviderMsTeamListChannelsResponse> =
            jsonHandler<ProviderMsTeamListChannelsResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun listChannels(
            params: ProviderMsTeamListChannelsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProviderMsTeamListChannelsResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments(
                        "v1",
                        "providers",
                        "ms-teams",
                        params.getPathParam(0),
                        "channels",
                    )
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
            }
        }

        private val listTeamsHandler: Handler<ProviderMsTeamListTeamsResponse> =
            jsonHandler<ProviderMsTeamListTeamsResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun listTeams(
            params: ProviderMsTeamListTeamsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProviderMsTeamListTeamsResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "providers", "ms-teams", params.getPathParam(0), "teams")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { listTeamsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val revokeAccessHandler: Handler<String> =
            stringHandler().withErrorHandler(errorHandler)

        override fun revokeAccess(
            params: ProviderMsTeamRevokeAccessParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<String> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .addPathSegments(
                        "v1",
                        "providers",
                        "ms-teams",
                        params.getPathParam(0),
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
