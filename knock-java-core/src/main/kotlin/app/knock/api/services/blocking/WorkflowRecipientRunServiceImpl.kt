// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking

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
import app.knock.api.models.workflowrecipientruns.WorkflowRecipientRunDetail
import app.knock.api.models.workflowrecipientruns.WorkflowRecipientRunGetParams
import app.knock.api.models.workflowrecipientruns.WorkflowRecipientRunListPage
import app.knock.api.models.workflowrecipientruns.WorkflowRecipientRunListPageResponse
import app.knock.api.models.workflowrecipientruns.WorkflowRecipientRunListParams
import kotlin.jvm.optionals.getOrNull

class WorkflowRecipientRunServiceImpl
internal constructor(private val clientOptions: ClientOptions) : WorkflowRecipientRunService {

    private val withRawResponse: WorkflowRecipientRunService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): WorkflowRecipientRunService.WithRawResponse = withRawResponse

    override fun get(
        params: WorkflowRecipientRunGetParams,
        requestOptions: RequestOptions,
    ): WorkflowRecipientRunDetail =
        // get /v1/workflow_recipient_runs/{id}
        withRawResponse().get(params, requestOptions).parse()

    override fun list(
        params: WorkflowRecipientRunListParams,
        requestOptions: RequestOptions,
    ): WorkflowRecipientRunListPage =
        // get /v1/workflow_recipient_runs
        withRawResponse().list(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        WorkflowRecipientRunService.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val getHandler: Handler<WorkflowRecipientRunDetail> =
            jsonHandler<WorkflowRecipientRunDetail>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun get(
            params: WorkflowRecipientRunGetParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<WorkflowRecipientRunDetail> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "workflow_recipient_runs", params._pathParam(0))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { getHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
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
        ): HttpResponseFor<WorkflowRecipientRunListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "workflow_recipient_runs")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        WorkflowRecipientRunListPage.builder()
                            .service(WorkflowRecipientRunServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }
    }
}
