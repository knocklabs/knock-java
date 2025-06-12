// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async

import app.knock.api.core.ClientOptions
import app.knock.api.core.JsonValue
import app.knock.api.core.RequestOptions
import app.knock.api.core.checkRequired
import app.knock.api.core.handlers.errorHandler
import app.knock.api.core.handlers.jsonHandler
import app.knock.api.core.handlers.stringHandler
import app.knock.api.core.handlers.withErrorHandler
import app.knock.api.core.http.HttpMethod
import app.knock.api.core.http.HttpRequest
import app.knock.api.core.http.HttpResponse.Handler
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.core.http.json
import app.knock.api.core.http.parseable
import app.knock.api.core.prepareAsync
import app.knock.api.models.workflows.WorkflowCancelParams
import app.knock.api.models.workflows.WorkflowTriggerParams
import app.knock.api.models.workflows.WorkflowTriggerResponse
import java.util.concurrent.CompletableFuture
import kotlin.jvm.optionals.getOrNull

class WorkflowServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    WorkflowServiceAsync {

    private val withRawResponse: WorkflowServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): WorkflowServiceAsync.WithRawResponse = withRawResponse

    override fun cancel(
        params: WorkflowCancelParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<String> =
        // post /v1/workflows/{key}/cancel
        withRawResponse().cancel(params, requestOptions).thenApply { it.parse() }

    override fun trigger(
        params: WorkflowTriggerParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<WorkflowTriggerResponse> =
        // post /v1/workflows/{key}/trigger
        withRawResponse().trigger(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        WorkflowServiceAsync.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val cancelHandler: Handler<String> = stringHandler().withErrorHandler(errorHandler)

        override fun cancel(
            params: WorkflowCancelParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<String>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("key", params.key().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "workflows", params._pathParam(0), "cancel")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable { response.use { cancelHandler.handle(it) } }
                }
        }

        private val triggerHandler: Handler<WorkflowTriggerResponse> =
            jsonHandler<WorkflowTriggerResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun trigger(
            params: WorkflowTriggerParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<WorkflowTriggerResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("key", params.key().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "workflows", params._pathParam(0), "trigger")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { triggerHandler.handle(it) }
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
