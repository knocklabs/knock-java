// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking.providers

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
import app.knock.api.core.prepare
import app.knock.api.models.providers.msteams.MsTeamCheckAuthParams
import app.knock.api.models.providers.msteams.MsTeamCheckAuthResponse
import app.knock.api.models.providers.msteams.MsTeamListChannelsParams
import app.knock.api.models.providers.msteams.MsTeamListChannelsResponse
import app.knock.api.models.providers.msteams.MsTeamListTeamsPage
import app.knock.api.models.providers.msteams.MsTeamListTeamsPageResponse
import app.knock.api.models.providers.msteams.MsTeamListTeamsParams
import app.knock.api.models.providers.msteams.MsTeamRevokeAccessParams
import app.knock.api.models.providers.msteams.MsTeamRevokeAccessResponse
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class MsTeamServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    MsTeamService {

    private val withRawResponse: MsTeamService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): MsTeamService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): MsTeamService =
        MsTeamServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

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
    ): MsTeamListTeamsPage =
        // get /v1/providers/ms-teams/{channel_id}/teams
        withRawResponse().listTeams(params, requestOptions).parse()

    override fun revokeAccess(
        params: MsTeamRevokeAccessParams,
        requestOptions: RequestOptions,
    ): MsTeamRevokeAccessResponse =
        // put /v1/providers/ms-teams/{channel_id}/revoke_access
        withRawResponse().revokeAccess(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        MsTeamService.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): MsTeamService.WithRawResponse =
            MsTeamServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val checkAuthHandler: Handler<MsTeamCheckAuthResponse> =
            jsonHandler<MsTeamCheckAuthResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun checkAuth(
            params: MsTeamCheckAuthParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MsTeamCheckAuthResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("channelId", params.channelId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
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
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("channelId", params.channelId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
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

        private val listTeamsHandler: Handler<MsTeamListTeamsPageResponse> =
            jsonHandler<MsTeamListTeamsPageResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun listTeams(
            params: MsTeamListTeamsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MsTeamListTeamsPage> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("channelId", params.channelId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
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
                    .let {
                        MsTeamListTeamsPage.builder()
                            .service(MsTeamServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val revokeAccessHandler: Handler<MsTeamRevokeAccessResponse> =
            jsonHandler<MsTeamRevokeAccessResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun revokeAccess(
            params: MsTeamRevokeAccessParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MsTeamRevokeAccessResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("channelId", params.channelId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .baseUrl(clientOptions.baseUrl())
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
            return response.parseable {
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
