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
import app.knock.api.models.providers.msteams.MsTeamCheckAuthParams
import app.knock.api.models.providers.msteams.MsTeamCheckAuthResponse
import app.knock.api.models.providers.msteams.MsTeamListChannelsParams
import app.knock.api.models.providers.msteams.MsTeamListChannelsResponse
import app.knock.api.models.providers.msteams.MsTeamListTeamsPageAsync
import app.knock.api.models.providers.msteams.MsTeamListTeamsPageResponse
import app.knock.api.models.providers.msteams.MsTeamListTeamsParams
import app.knock.api.models.providers.msteams.MsTeamRevokeAccessParams
import app.knock.api.models.providers.msteams.MsTeamRevokeAccessResponse
import java.util.concurrent.CompletableFuture
import kotlin.jvm.optionals.getOrNull

class MsTeamServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    MsTeamServiceAsync {

    private val withRawResponse: MsTeamServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): MsTeamServiceAsync.WithRawResponse = withRawResponse

    override fun checkAuth(
        params: MsTeamCheckAuthParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<MsTeamCheckAuthResponse> =
        // get /v1/providers/ms-teams/{channel_id}/auth_check
        withRawResponse().checkAuth(params, requestOptions).thenApply { it.parse() }

    override fun listChannels(
        params: MsTeamListChannelsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<MsTeamListChannelsResponse> =
        // get /v1/providers/ms-teams/{channel_id}/channels
        withRawResponse().listChannels(params, requestOptions).thenApply { it.parse() }

    override fun listTeams(
        params: MsTeamListTeamsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<MsTeamListTeamsPageAsync> =
        // get /v1/providers/ms-teams/{channel_id}/teams
        withRawResponse().listTeams(params, requestOptions).thenApply { it.parse() }

    override fun revokeAccess(
        params: MsTeamRevokeAccessParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<MsTeamRevokeAccessResponse> =
        // put /v1/providers/ms-teams/{channel_id}/revoke_access
        withRawResponse().revokeAccess(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        MsTeamServiceAsync.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val checkAuthHandler: Handler<MsTeamCheckAuthResponse> =
            jsonHandler<MsTeamCheckAuthResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun checkAuth(
            params: MsTeamCheckAuthParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<MsTeamCheckAuthResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("channelId", params.channelId().getOrNull())
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

        private val listChannelsHandler: Handler<MsTeamListChannelsResponse> =
            jsonHandler<MsTeamListChannelsResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun listChannels(
            params: MsTeamListChannelsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<MsTeamListChannelsResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("channelId", params.channelId().getOrNull())
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
                    }
                }
        }

        private val listTeamsHandler: Handler<MsTeamListTeamsPageResponse> =
            jsonHandler<MsTeamListTeamsPageResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun listTeams(
            params: MsTeamListTeamsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<MsTeamListTeamsPageAsync>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("channelId", params.channelId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "providers", "ms-teams", params._pathParam(0), "teams")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { listTeamsHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                            .let {
                                MsTeamListTeamsPageAsync.builder()
                                    .service(MsTeamServiceAsyncImpl(clientOptions))
                                    .params(params)
                                    .response(it)
                                    .build()
                            }
                    }
                }
        }

        private val revokeAccessHandler: Handler<MsTeamRevokeAccessResponse> =
            jsonHandler<MsTeamRevokeAccessResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun revokeAccess(
            params: MsTeamRevokeAccessParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<MsTeamRevokeAccessResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("channelId", params.channelId().getOrNull())
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
