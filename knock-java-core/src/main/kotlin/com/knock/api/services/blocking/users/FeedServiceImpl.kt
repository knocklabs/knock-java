// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.blocking.users

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
import com.knock.api.core.prepare
import com.knock.api.errors.KnockError
import com.knock.api.models.users.feeds.FeedGetSettingsParams
import com.knock.api.models.users.feeds.FeedGetSettingsResponse
import com.knock.api.models.users.feeds.FeedListItemsPage
import com.knock.api.models.users.feeds.FeedListItemsParams

class FeedServiceImpl internal constructor(private val clientOptions: ClientOptions) : FeedService {

    private val withRawResponse: FeedService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): FeedService.WithRawResponse = withRawResponse

    override fun getSettings(
        params: FeedGetSettingsParams,
        requestOptions: RequestOptions,
    ): FeedGetSettingsResponse =
        // get /v1/users/{user_id}/feeds/{channel_id}/settings
        withRawResponse().getSettings(params, requestOptions).parse()

    override fun listItems(
        params: FeedListItemsParams,
        requestOptions: RequestOptions,
    ): FeedListItemsPage =
        // get /v1/users/{user_id}/feeds/{channel_id}
        withRawResponse().listItems(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        FeedService.WithRawResponse {

        private val errorHandler: Handler<KnockError> = errorHandler(clientOptions.jsonMapper)

        private val getSettingsHandler: Handler<FeedGetSettingsResponse> =
            jsonHandler<FeedGetSettingsResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun getSettings(
            params: FeedGetSettingsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FeedGetSettingsResponse> {
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { getSettingsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listItemsHandler: Handler<FeedListItemsPage.Response> =
            jsonHandler<FeedListItemsPage.Response>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun listItems(
            params: FeedListItemsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FeedListItemsPage> {
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { listItemsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let { FeedListItemsPage.of(FeedServiceImpl(clientOptions), params, it) }
            }
        }
    }
}
