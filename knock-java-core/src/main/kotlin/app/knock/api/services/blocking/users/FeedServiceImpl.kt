// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking.users

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
import app.knock.api.core.http.parseable
import app.knock.api.core.prepare
import app.knock.api.models.users.feeds.FeedGetSettingsParams
import app.knock.api.models.users.feeds.FeedGetSettingsResponse
import app.knock.api.models.users.feeds.FeedListItemsPage
import app.knock.api.models.users.feeds.FeedListItemsPageResponse
import app.knock.api.models.users.feeds.FeedListItemsParams
import kotlin.jvm.optionals.getOrNull

class FeedServiceImpl internal constructor(private val clientOptions: ClientOptions) : FeedService {

    private val withRawResponse: FeedService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): FeedService.WithRawResponse = withRawResponse

    override fun getSettings(
        params: FeedGetSettingsParams,
        requestOptions: RequestOptions,
    ): FeedGetSettingsResponse =
        // get /v1/users/{user_id}/feeds/{id}/settings
        withRawResponse().getSettings(params, requestOptions).parse()

    override fun listItems(
        params: FeedListItemsParams,
        requestOptions: RequestOptions,
    ): FeedListItemsPage =
        // get /v1/users/{user_id}/feeds/{id}
        withRawResponse().listItems(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        FeedService.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val getSettingsHandler: Handler<FeedGetSettingsResponse> =
            jsonHandler<FeedGetSettingsResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun getSettings(
            params: FeedGetSettingsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FeedGetSettingsResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("userId", params.userId().getOrNull())
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments(
                        "v1",
                        "users",
                        params._pathParam(0),
                        "feeds",
                        params._pathParam(1),
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

        private val listItemsHandler: Handler<FeedListItemsPageResponse> =
            jsonHandler<FeedListItemsPageResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun listItems(
            params: FeedListItemsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FeedListItemsPage> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("userId", params.userId().getOrNull())
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments(
                        "v1",
                        "users",
                        params._pathParam(0),
                        "feeds",
                        params._pathParam(1),
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
                    .let {
                        FeedListItemsPage.builder()
                            .service(FeedServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }
    }
}
