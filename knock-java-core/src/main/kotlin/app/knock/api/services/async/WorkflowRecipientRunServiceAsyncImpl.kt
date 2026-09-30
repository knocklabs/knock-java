// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async

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
import app.knock.api.core.prepareAsync
import app.knock.api.models.workflowrecipientruns.WorkflowRecipientRunDetail
import app.knock.api.models.workflowrecipientruns.WorkflowRecipientRunGetParams
import app.knock.api.models.workflowrecipientruns.WorkflowRecipientRunListPageAsync
import app.knock.api.models.workflowrecipientruns.WorkflowRecipientRunListPageResponse
import app.knock.api.models.workflowrecipientruns.WorkflowRecipientRunListParams
import java.util.concurrent.CompletableFuture
import kotlin.jvm.optionals.getOrNull

class WorkflowRecipientRunServiceAsyncImpl
internal constructor(private val clientOptions: ClientOptions) : WorkflowRecipientRunServiceAsync {

    private val withRawResponse: WorkflowRecipientRunServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): WorkflowRecipientRunServiceAsync.WithRawResponse =
        withRawResponse

    override fun get(
        params: WorkflowRecipientRunGetParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<WorkflowRecipientRunDetail> =
        // get /v1/workflow_recipient_runs/{id}
        withRawResponse().get(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: WorkflowRecipientRunListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<WorkflowRecipientRunListPageAsync> =
        // get /v1/workflow_recipient_runs
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        WorkflowRecipientRunServiceAsync.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val getHandler: Handler<WorkflowRecipientRunDetail> =
            jsonHandler<WorkflowRecipientRunDetail>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun get(
            params: WorkflowRecipientRunGetParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<WorkflowRecipientRunDetail>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "workflow_recipient_runs", params._pathParam(0))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { getHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val listHandler: Handler<WorkflowRecipientRunListPageResponse> =
            jsonHandler<WorkflowRecipientRunListPageResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun list(
            params: WorkflowRecipientRunListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<WorkflowRecipientRunListPageAsync>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "workflow_recipient_runs")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { listHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                            .let {
                                WorkflowRecipientRunListPageAsync.builder()
                                    .service(WorkflowRecipientRunServiceAsyncImpl(clientOptions))
                                    .params(params)
                                    .response(it)
                                    .build()
                            }
                    }
                }
        }
    }
}
