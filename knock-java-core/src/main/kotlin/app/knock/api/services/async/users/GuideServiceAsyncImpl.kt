// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async.users

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
import app.knock.api.models.users.guides.GuideGetChannelParams
import app.knock.api.models.users.guides.GuideGetChannelResponse
import app.knock.api.models.users.guides.GuideMarkMessageAsArchivedParams
import app.knock.api.models.users.guides.GuideMarkMessageAsArchivedResponse
import app.knock.api.models.users.guides.GuideMarkMessageAsInteractedParams
import app.knock.api.models.users.guides.GuideMarkMessageAsInteractedResponse
import app.knock.api.models.users.guides.GuideMarkMessageAsSeenParams
import app.knock.api.models.users.guides.GuideMarkMessageAsSeenResponse
import java.util.concurrent.CompletableFuture
import kotlin.jvm.optionals.getOrNull

class GuideServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    GuideServiceAsync {

    private val withRawResponse: GuideServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): GuideServiceAsync.WithRawResponse = withRawResponse

    override fun getChannel(
        params: GuideGetChannelParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<GuideGetChannelResponse> =
        // get /v1/users/{user_id}/guides/{channel_id}
        withRawResponse().getChannel(params, requestOptions).thenApply { it.parse() }

    override fun markMessageAsArchived(
        params: GuideMarkMessageAsArchivedParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<GuideMarkMessageAsArchivedResponse> =
        // put /v1/users/{user_id}/guides/messages/{message_id}/archived
        withRawResponse().markMessageAsArchived(params, requestOptions).thenApply { it.parse() }

    override fun markMessageAsInteracted(
        params: GuideMarkMessageAsInteractedParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<GuideMarkMessageAsInteractedResponse> =
        // put /v1/users/{user_id}/guides/messages/{message_id}/interacted
        withRawResponse().markMessageAsInteracted(params, requestOptions).thenApply { it.parse() }

    override fun markMessageAsSeen(
        params: GuideMarkMessageAsSeenParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<GuideMarkMessageAsSeenResponse> =
        // put /v1/users/{user_id}/guides/messages/{message_id}/seen
        withRawResponse().markMessageAsSeen(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        GuideServiceAsync.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val getChannelHandler: Handler<GuideGetChannelResponse> =
            jsonHandler<GuideGetChannelResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun getChannel(
            params: GuideGetChannelParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<GuideGetChannelResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("userId", params.userId().getOrNull())
            checkRequired("channelId", params.channelId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v1",
                        "users",
                        params._pathParam(0),
                        "guides",
                        params._pathParam(1),
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { getChannelHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val markMessageAsArchivedHandler: Handler<GuideMarkMessageAsArchivedResponse> =
            jsonHandler<GuideMarkMessageAsArchivedResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun markMessageAsArchived(
            params: GuideMarkMessageAsArchivedParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<GuideMarkMessageAsArchivedResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("userId", params.userId().getOrNull())
            checkRequired("messageId", params.messageId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v1",
                        "users",
                        params._pathParam(0),
                        "guides",
                        "messages",
                        params._pathParam(1),
                        "archived",
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { markMessageAsArchivedHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val markMessageAsInteractedHandler: Handler<GuideMarkMessageAsInteractedResponse> =
            jsonHandler<GuideMarkMessageAsInteractedResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun markMessageAsInteracted(
            params: GuideMarkMessageAsInteractedParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<GuideMarkMessageAsInteractedResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("userId", params.userId().getOrNull())
            checkRequired("messageId", params.messageId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v1",
                        "users",
                        params._pathParam(0),
                        "guides",
                        "messages",
                        params._pathParam(1),
                        "interacted",
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { markMessageAsInteractedHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val markMessageAsSeenHandler: Handler<GuideMarkMessageAsSeenResponse> =
            jsonHandler<GuideMarkMessageAsSeenResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun markMessageAsSeen(
            params: GuideMarkMessageAsSeenParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<GuideMarkMessageAsSeenResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("userId", params.userId().getOrNull())
            checkRequired("messageId", params.messageId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v1",
                        "users",
                        params._pathParam(0),
                        "guides",
                        "messages",
                        params._pathParam(1),
                        "seen",
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { markMessageAsSeenHandler.handle(it) }
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
