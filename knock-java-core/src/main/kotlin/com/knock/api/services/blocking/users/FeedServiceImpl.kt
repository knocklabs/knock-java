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
import com.knock.api.models.UserFeedGetSettingsParams
import com.knock.api.models.UserFeedGetSettingsResponse
import com.knock.api.models.UserFeedListItemsPage
import com.knock.api.models.UserFeedListItemsParams

class FeedServiceImpl internal constructor(private val clientOptions: ClientOptions) : FeedService {

    private val withRawResponse: FeedService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): FeedService.WithRawResponse = withRawResponse

    override fun getSettings(
        params: UserFeedGetSettingsParams,
        requestOptions: RequestOptions,
    ): UserFeedGetSettingsResponse =
        // get /v1/users/{user_id}/feeds/{channel_id}/settings
        withRawResponse().getSettings(params, requestOptions).parse()

    override fun listItems(
        params: UserFeedListItemsParams,
        requestOptions: RequestOptions,
    ): UserFeedListItemsPage =
        // get /v1/users/{user_id}/feeds/{channel_id}
        withRawResponse().listItems(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        FeedService.WithRawResponse {

        private val errorHandler: Handler<KnockError> = errorHandler(clientOptions.jsonMapper)

        private val getSettingsHandler: Handler<UserFeedGetSettingsResponse> =
            jsonHandler<UserFeedGetSettingsResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun getSettings(
            params: UserFeedGetSettingsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<UserFeedGetSettingsResponse> {
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

        private val listItemsHandler: Handler<UserFeedListItemsPage.Response> =
            jsonHandler<UserFeedListItemsPage.Response>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun listItems(
            params: UserFeedListItemsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<UserFeedListItemsPage> {
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
                    .let { UserFeedListItemsPage.of(FeedServiceImpl(clientOptions), params, it) }
            }
        }
    }
}
