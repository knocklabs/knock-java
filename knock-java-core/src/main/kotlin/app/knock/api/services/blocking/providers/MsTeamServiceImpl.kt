// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking.providers

import app.knock.api.core.ClientOptions
import app.knock.api.core.JsonValue
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
import app.knock.api.models.providers.msteams.MsTeamCheckAuthParams
import app.knock.api.models.providers.msteams.MsTeamCheckAuthResponse
import app.knock.api.models.providers.msteams.MsTeamListChannelsParams
import app.knock.api.models.providers.msteams.MsTeamListChannelsResponse
import app.knock.api.models.providers.msteams.MsTeamListTeamsParams
import app.knock.api.models.providers.msteams.MsTeamListTeamsResponse
import app.knock.api.models.providers.msteams.MsTeamRevokeAccessParams

class MsTeamServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    MsTeamService {

    private val withRawResponse: MsTeamService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): MsTeamService.WithRawResponse = withRawResponse

    override fun checkAuth(
        params: MsTeamCheckAuthParams,
        requestOptions: RequestOptions,
    ): MsTeamCheckAuthResponse =
        // get /v1/providers/ms-teams/{channel_id}/auth_check
        withRawResponse().checkAuth(params, requestOptions).parse()

    override fun listChannels(
        params: MsTeamListChannelsParams,
        requestOptions: RequestOptions,
    ): MsTeamListChannelsResponse =
        // get /v1/providers/ms-teams/{channel_id}/channels
        withRawResponse().listChannels(params, requestOptions).parse()

    override fun listTeams(
        params: MsTeamListTeamsParams,
        requestOptions: RequestOptions,
    ): MsTeamListTeamsResponse =
        // get /v1/providers/ms-teams/{channel_id}/teams
        withRawResponse().listTeams(params, requestOptions).parse()

    override fun revokeAccess(
        params: MsTeamRevokeAccessParams,
        requestOptions: RequestOptions,
    ): String =
        // put /v1/providers/ms-teams/{channel_id}/revoke_access
        withRawResponse().revokeAccess(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        MsTeamService.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val checkAuthHandler: Handler<MsTeamCheckAuthResponse> =
            jsonHandler<MsTeamCheckAuthResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun checkAuth(
            params: MsTeamCheckAuthParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MsTeamCheckAuthResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments(
                        "v1",
                        "providers",
                        "ms-teams",
                        params._pathParam(0),
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

        private val listChannelsHandler: Handler<MsTeamListChannelsResponse> =
            jsonHandler<MsTeamListChannelsResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun listChannels(
            params: MsTeamListChannelsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MsTeamListChannelsResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments(
                        "v1",
                        "providers",
                        "ms-teams",
                        params._pathParam(0),
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

        private val listTeamsHandler: Handler<MsTeamListTeamsResponse> =
            jsonHandler<MsTeamListTeamsResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun listTeams(
            params: MsTeamListTeamsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MsTeamListTeamsResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "providers", "ms-teams", params._pathParam(0), "teams")
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
            params: MsTeamRevokeAccessParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<String> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .addPathSegments(
                        "v1",
                        "providers",
                        "ms-teams",
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
