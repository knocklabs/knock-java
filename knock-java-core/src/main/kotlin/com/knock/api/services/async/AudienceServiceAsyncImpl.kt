// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.async

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
import com.knock.api.models.AudienceAddMembersParams
import com.knock.api.models.AudienceListMembersParams
import com.knock.api.models.AudienceListMembersResponse
import com.knock.api.models.AudienceRemoveMembersParams
import java.util.concurrent.CompletableFuture

class AudienceServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    AudienceServiceAsync {

    private val withRawResponse: AudienceServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): AudienceServiceAsync.WithRawResponse = withRawResponse

    override fun addMembers(
        params: AudienceAddMembersParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<String> =
        // post /v1/audiences/{key}/members
        withRawResponse().addMembers(params, requestOptions).thenApply { it.parse() }

    override fun listMembers(
        params: AudienceListMembersParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<AudienceListMembersResponse> =
        // get /v1/audiences/{key}/members
        withRawResponse().listMembers(params, requestOptions).thenApply { it.parse() }

    override fun removeMembers(
        params: AudienceRemoveMembersParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<String> =
        // delete /v1/audiences/{key}/members
        withRawResponse().removeMembers(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        AudienceServiceAsync.WithRawResponse {

        private val errorHandler: Handler<KnockError> = errorHandler(clientOptions.jsonMapper)

        private val addMembersHandler: Handler<String> =
            stringHandler().withErrorHandler(errorHandler)

        override fun addMembers(
            params: AudienceAddMembersParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<String>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "audiences", params.getPathParam(0), "members")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable { response.use { addMembersHandler.handle(it) } }
                }
        }

        private val listMembersHandler: Handler<AudienceListMembersResponse> =
            jsonHandler<AudienceListMembersResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun listMembers(
            params: AudienceListMembersParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<AudienceListMembersResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "audiences", params.getPathParam(0), "members")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { listMembersHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val removeMembersHandler: Handler<String> =
            stringHandler().withErrorHandler(errorHandler)

        override fun removeMembers(
            params: AudienceRemoveMembersParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<String>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments("v1", "audiences", params.getPathParam(0), "members")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable { response.use { removeMembersHandler.handle(it) } }
                }
        }
    }
}
