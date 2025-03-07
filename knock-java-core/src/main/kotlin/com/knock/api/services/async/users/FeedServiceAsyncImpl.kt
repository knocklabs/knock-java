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
import com.knock.api.core.http.parseable
import com.knock.api.core.prepareAsync
import com.knock.api.errors.KnockError
import com.knock.api.models.UserFeedGetSettingsParams
import com.knock.api.models.UserFeedGetSettingsResponse
import com.knock.api.models.UserFeedListItemsPageAsync
import com.knock.api.models.UserFeedListItemsParams
import java.util.concurrent.CompletableFuture

class FeedServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    FeedServiceAsync {

    private val withRawResponse: FeedServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): FeedServiceAsync.WithRawResponse = withRawResponse

    override fun getSettings(
        params: UserFeedGetSettingsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<UserFeedGetSettingsResponse> =
        // get /v1/users/{user_id}/feeds/{id}/settings
        withRawResponse().getSettings(params, requestOptions).thenApply { it.parse() }

    override fun listItems(
        params: UserFeedListItemsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<UserFeedListItemsPageAsync> =
        // get /v1/users/{user_id}/feeds/{id}
        withRawResponse().listItems(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        FeedServiceAsync.WithRawResponse {

        private val errorHandler: Handler<KnockError> = errorHandler(clientOptions.jsonMapper)

        private val getSettingsHandler: Handler<UserFeedGetSettingsResponse> =
            jsonHandler<UserFeedGetSettingsResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun getSettings(
            params: UserFeedGetSettingsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UserFeedGetSettingsResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments(
                        "v1",
                        "users",
                        params.getPathParam(0),
                        "feeds",
                        params.getPathParam(1),
                        "settings",
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { getSettingsHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val listItemsHandler: Handler<UserFeedListItemsPageAsync.Response> =
            jsonHandler<UserFeedListItemsPageAsync.Response>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun listItems(
            params: UserFeedListItemsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UserFeedListItemsPageAsync>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments(
                        "v1",
                        "users",
                        params.getPathParam(0),
                        "feeds",
                        params.getPathParam(1),
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { listItemsHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                            .let {
                                UserFeedListItemsPageAsync.of(
                                    FeedServiceAsyncImpl(clientOptions),
                                    params,
                                    it,
                                )
                            }
                    }
                }
        }
    }
}
