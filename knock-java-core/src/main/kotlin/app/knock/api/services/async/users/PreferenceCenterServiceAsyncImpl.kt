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
import app.knock.api.models.users.preferencecenter.PreferenceCenterGenerateSignedUrlParams
import app.knock.api.models.users.preferencecenter.PreferenceCenterGenerateSignedUrlResponse
import app.knock.api.models.users.preferencecenter.PreferenceCenterGetConfigParams
import app.knock.api.models.users.preferencecenter.PreferenceCenterGetConfigResponse
import java.util.concurrent.CompletableFuture
import kotlin.jvm.optionals.getOrNull

class PreferenceCenterServiceAsyncImpl
internal constructor(private val clientOptions: ClientOptions) : PreferenceCenterServiceAsync {

    private val withRawResponse: PreferenceCenterServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): PreferenceCenterServiceAsync.WithRawResponse = withRawResponse

    override fun getConfig(
        params: PreferenceCenterGetConfigParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<PreferenceCenterGetConfigResponse> =
        // get /v1/users/{user_id}/preference_center/config
        withRawResponse().getConfig(params, requestOptions).thenApply { it.parse() }

    override fun generateSignedUrl(
        params: PreferenceCenterGenerateSignedUrlParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<PreferenceCenterGenerateSignedUrlResponse> =
        // post /v1/users/{user_id}/preference_center/signed_url
        withRawResponse().generateSignedUrl(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        PreferenceCenterServiceAsync.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val getConfigHandler: Handler<PreferenceCenterGetConfigResponse> =
            jsonHandler<PreferenceCenterGetConfigResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun getConfig(
            params: PreferenceCenterGetConfigParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PreferenceCenterGetConfigResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("userId", params.userId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments(
                        "v1",
                        "users",
                        params._pathParam(0),
                        "preference_center",
                        "config",
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { getConfigHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val generateSignedUrlHandler: Handler<PreferenceCenterGenerateSignedUrlResponse> =
            jsonHandler<PreferenceCenterGenerateSignedUrlResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun generateSignedUrl(
            params: PreferenceCenterGenerateSignedUrlParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PreferenceCenterGenerateSignedUrlResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("userId", params.userId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments(
                        "v1",
                        "users",
                        params._pathParam(0),
                        "preference_center",
                        "signed_url",
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
                            .use { generateSignedUrlHandler.handle(it) }
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
