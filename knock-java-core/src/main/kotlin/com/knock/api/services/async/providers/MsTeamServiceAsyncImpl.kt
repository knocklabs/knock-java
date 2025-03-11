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
import com.knock.api.models.providers.msteams.MsTeamCheckAuthParams
import com.knock.api.models.providers.msteams.MsTeamCheckAuthResponse
import com.knock.api.models.providers.msteams.MsTeamListChannelsParams
import com.knock.api.models.providers.msteams.MsTeamListChannelsResponse
import com.knock.api.models.providers.msteams.MsTeamListTeamsParams
import com.knock.api.models.providers.msteams.MsTeamListTeamsResponse
import com.knock.api.models.providers.msteams.MsTeamRevokeAccessParams
import java.util.concurrent.CompletableFuture

class MsTeamServiceAsyncImpl internal constructor(
    private val clientOptions: ClientOptions,

) : MsTeamServiceAsync {

    private val withRawResponse: MsTeamServiceAsync.WithRawResponse by lazy { WithRawResponseImpl(clientOptions) }

    override fun withRawResponse(): MsTeamServiceAsync.WithRawResponse = withRawResponse

    override fun checkAuth(params: MsTeamCheckAuthParams, requestOptions: RequestOptions): CompletableFuture<MsTeamCheckAuthResponse> =
        // get /v1/providers/ms-teams/{channel_id}/auth_check
        withRawResponse().checkAuth(params, requestOptions).thenApply { it.parse() }

    override fun listChannels(params: MsTeamListChannelsParams, requestOptions: RequestOptions): CompletableFuture<MsTeamListChannelsResponse> =
        // get /v1/providers/ms-teams/{channel_id}/channels
        withRawResponse().listChannels(params, requestOptions).thenApply { it.parse() }

    override fun listTeams(params: MsTeamListTeamsParams, requestOptions: RequestOptions): CompletableFuture<MsTeamListTeamsResponse> =
        // get /v1/providers/ms-teams/{channel_id}/teams
        withRawResponse().listTeams(params, requestOptions).thenApply { it.parse() }

    override fun revokeAccess(params: MsTeamRevokeAccessParams, requestOptions: RequestOptions): CompletableFuture<String> =
        // put /v1/providers/ms-teams/{channel_id}/revoke_access
        withRawResponse().revokeAccess(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(
        private val clientOptions: ClientOptions,

    ) : MsTeamServiceAsync.WithRawResponse {

        private val errorHandler: Handler<KnockError> = errorHandler(clientOptions.jsonMapper)

        private val checkAuthHandler: Handler<MsTeamCheckAuthResponse> = jsonHandler<MsTeamCheckAuthResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun checkAuth(params: MsTeamCheckAuthParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<MsTeamCheckAuthResponse>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.GET)
            .addPathSegments("v1", "providers", "ms-teams", params.getPathParam(0), "auth_check")
            .build()
            .prepareAsync(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          return request.thenComposeAsync { clientOptions.httpClient.executeAsync(
            it, requestOptions
          ) }.thenApply { response -> response.parseable {
              response.use {
                  checkAuthHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.validate()
                  }
              }
          } }
        }

        private val listChannelsHandler: Handler<MsTeamListChannelsResponse> = jsonHandler<MsTeamListChannelsResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun listChannels(params: MsTeamListChannelsParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<MsTeamListChannelsResponse>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.GET)
            .addPathSegments("v1", "providers", "ms-teams", params.getPathParam(0), "channels")
            .build()
            .prepareAsync(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          return request.thenComposeAsync { clientOptions.httpClient.executeAsync(
            it, requestOptions
          ) }.thenApply { response -> response.parseable {
              response.use {
                  listChannelsHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.validate()
                  }
              }
          } }
        }

        private val listTeamsHandler: Handler<MsTeamListTeamsResponse> = jsonHandler<MsTeamListTeamsResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun listTeams(params: MsTeamListTeamsParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<MsTeamListTeamsResponse>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.GET)
            .addPathSegments("v1", "providers", "ms-teams", params.getPathParam(0), "teams")
            .build()
            .prepareAsync(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          return request.thenComposeAsync { clientOptions.httpClient.executeAsync(
            it, requestOptions
          ) }.thenApply { response -> response.parseable {
              response.use {
                  listTeamsHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.validate()
                  }
              }
          } }
        }

        private val revokeAccessHandler: Handler<String> = stringHandler().withErrorHandler(errorHandler)

        override fun revokeAccess(params: MsTeamRevokeAccessParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<String>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.PUT)
            .addPathSegments("v1", "providers", "ms-teams", params.getPathParam(0), "revoke_access")
            .apply { params._body().ifPresent{ body(json(clientOptions.jsonMapper, it)) } }
            .build()
            .prepareAsync(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          return request.thenComposeAsync { clientOptions.httpClient.executeAsync(
            it, requestOptions
          ) }.thenApply { response -> response.parseable {
              response.use {
                  revokeAccessHandler.handle(it)
              }
          } }
        }
    }
}
