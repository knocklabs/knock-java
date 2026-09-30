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
import app.knock.api.models.users.guides.GuideActionResponse
import app.knock.api.models.users.guides.GuideGetChannelParams
import app.knock.api.models.users.guides.GuideGetChannelResponse
import app.knock.api.models.users.guides.GuideMarkMessageAsArchivedParams
import app.knock.api.models.users.guides.GuideMarkMessageAsInteractedParams
import app.knock.api.models.users.guides.GuideMarkMessageAsSeenParams
import app.knock.api.models.users.guides.GuideResetGuideEngagementsParams
import app.knock.api.models.users.guides.GuideUnarchiveGuideMessageParams
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
    ): CompletableFuture<GuideActionResponse> =
        // put /v1/users/{user_id}/guides/messages/archived
        withRawResponse().markMessageAsArchived(params, requestOptions).thenApply { it.parse() }

    override fun markMessageAsInteracted(
        params: GuideMarkMessageAsInteractedParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<GuideActionResponse> =
        // put /v1/users/{user_id}/guides/messages/interacted
        withRawResponse().markMessageAsInteracted(params, requestOptions).thenApply { it.parse() }

    override fun markMessageAsSeen(
        params: GuideMarkMessageAsSeenParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<GuideActionResponse> =
        // put /v1/users/{user_id}/guides/messages/seen
        withRawResponse().markMessageAsSeen(params, requestOptions).thenApply { it.parse() }

    override fun resetGuideEngagements(
        params: GuideResetGuideEngagementsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<GuideActionResponse> =
        // put /v1/users/{user_id}/guides/engagements/reset
        withRawResponse().resetGuideEngagements(params, requestOptions).thenApply { it.parse() }

    override fun unarchiveGuideMessage(
        params: GuideUnarchiveGuideMessageParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<GuideActionResponse> =
        // delete /v1/users/{user_id}/guides/messages/archived
        withRawResponse().unarchiveGuideMessage(params, requestOptions).thenApply { it.parse() }

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

        private val markMessageAsArchivedHandler: Handler<GuideActionResponse> =
            jsonHandler<GuideActionResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun markMessageAsArchived(
            params: GuideMarkMessageAsArchivedParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<GuideActionResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("userId", params.userId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .addPathSegments(
                        "v1",
                        "users",
                        params._pathParam(0),
                        "guides",
                        "messages",
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

        private val markMessageAsInteractedHandler: Handler<GuideActionResponse> =
            jsonHandler<GuideActionResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun markMessageAsInteracted(
            params: GuideMarkMessageAsInteractedParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<GuideActionResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("userId", params.userId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .addPathSegments(
                        "v1",
                        "users",
                        params._pathParam(0),
                        "guides",
                        "messages",
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

        private val markMessageAsSeenHandler: Handler<GuideActionResponse> =
            jsonHandler<GuideActionResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun markMessageAsSeen(
            params: GuideMarkMessageAsSeenParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<GuideActionResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("userId", params.userId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .addPathSegments(
                        "v1",
                        "users",
                        params._pathParam(0),
                        "guides",
                        "messages",
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

        private val resetGuideEngagementsHandler: Handler<GuideActionResponse> =
            jsonHandler<GuideActionResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun resetGuideEngagements(
            params: GuideResetGuideEngagementsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<GuideActionResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("userId", params.userId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .addPathSegments(
                        "v1",
                        "users",
                        params._pathParam(0),
                        "guides",
                        "engagements",
                        "reset",
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
                            .use { resetGuideEngagementsHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val unarchiveGuideMessageHandler: Handler<GuideActionResponse> =
            jsonHandler<GuideActionResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun unarchiveGuideMessage(
            params: GuideUnarchiveGuideMessageParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<GuideActionResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("userId", params.userId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments(
                        "v1",
                        "users",
                        params._pathParam(0),
                        "guides",
                        "messages",
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
                            .use { unarchiveGuideMessageHandler.handle(it) }
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
