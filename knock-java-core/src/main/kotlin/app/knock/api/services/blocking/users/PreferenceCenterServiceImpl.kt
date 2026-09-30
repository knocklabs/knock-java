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
import app.knock.api.core.http.json
import app.knock.api.core.http.parseable
import app.knock.api.core.prepare
import app.knock.api.models.users.preferencecenter.PreferenceCenterGenerateSignedUrlParams
import app.knock.api.models.users.preferencecenter.PreferenceCenterGenerateSignedUrlResponse
import app.knock.api.models.users.preferencecenter.PreferenceCenterGetConfigParams
import app.knock.api.models.users.preferencecenter.PreferenceCenterGetConfigResponse
import kotlin.jvm.optionals.getOrNull

class PreferenceCenterServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    PreferenceCenterService {

    private val withRawResponse: PreferenceCenterService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): PreferenceCenterService.WithRawResponse = withRawResponse

    override fun getConfig(
        params: PreferenceCenterGetConfigParams,
        requestOptions: RequestOptions,
    ): PreferenceCenterGetConfigResponse =
        // get /v1/users/{user_id}/preference_center/config
        withRawResponse().getConfig(params, requestOptions).parse()

    override fun generateSignedUrl(
        params: PreferenceCenterGenerateSignedUrlParams,
        requestOptions: RequestOptions,
    ): PreferenceCenterGenerateSignedUrlResponse =
        // post /v1/users/{user_id}/preference_center/signed_url
        withRawResponse().generateSignedUrl(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        PreferenceCenterService.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val getConfigHandler: Handler<PreferenceCenterGetConfigResponse> =
            jsonHandler<PreferenceCenterGetConfigResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun getConfig(
            params: PreferenceCenterGetConfigParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PreferenceCenterGetConfigResponse> {
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { getConfigHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
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
        ): HttpResponseFor<PreferenceCenterGenerateSignedUrlResponse> {
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
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
