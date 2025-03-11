// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.blocking

import com.knock.api.core.ClientOptions
import com.knock.api.core.RequestOptions
import com.knock.api.core.handlers.errorHandler
import com.knock.api.core.handlers.jsonHandler
import com.knock.api.core.handlers.stringHandler
import com.knock.api.core.handlers.withErrorHandler
import com.knock.api.core.http.HttpMethod
import com.knock.api.core.http.HttpRequest
import com.knock.api.core.http.HttpResponse.Handler
import com.knock.api.core.http.HttpResponseFor
import com.knock.api.core.http.json
import com.knock.api.core.http.parseable
import com.knock.api.core.prepare
import com.knock.api.errors.KnockError
import com.knock.api.models.workflows.WorkflowCancelParams
import com.knock.api.models.workflows.WorkflowTriggerParams
import com.knock.api.models.workflows.WorkflowTriggerResponse

class WorkflowServiceImpl internal constructor(
    private val clientOptions: ClientOptions,

) : WorkflowService {

    private val withRawResponse: WorkflowService.WithRawResponse by lazy { WithRawResponseImpl(clientOptions) }

    override fun withRawResponse(): WorkflowService.WithRawResponse = withRawResponse

    override fun cancel(params: WorkflowCancelParams, requestOptions: RequestOptions): String =
        // post /v1/workflows/{key}/cancel
        withRawResponse().cancel(params, requestOptions).parse()

    override fun trigger(params: WorkflowTriggerParams, requestOptions: RequestOptions): WorkflowTriggerResponse =
        // post /v1/workflows/{key}/trigger
        withRawResponse().trigger(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(
        private val clientOptions: ClientOptions,

    ) : WorkflowService.WithRawResponse {

        private val errorHandler: Handler<KnockError> = errorHandler(clientOptions.jsonMapper)

        private val cancelHandler: Handler<String> = stringHandler().withErrorHandler(errorHandler)

        override fun cancel(params: WorkflowCancelParams, requestOptions: RequestOptions): HttpResponseFor<String> {
          val request = HttpRequest.builder()
            .method(HttpMethod.POST)
            .addPathSegments("v1", "workflows", params.getPathParam(0), "cancel")
            .body(json(clientOptions.jsonMapper, params._body()))
            .build()
            .prepare(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          val response = clientOptions.httpClient.execute(
            request, requestOptions
          )
          return response.parseable {
              response.use {
                  cancelHandler.handle(it)
              }
          }
        }

        private val triggerHandler: Handler<WorkflowTriggerResponse> = jsonHandler<WorkflowTriggerResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun trigger(params: WorkflowTriggerParams, requestOptions: RequestOptions): HttpResponseFor<WorkflowTriggerResponse> {
          val request = HttpRequest.builder()
            .method(HttpMethod.POST)
            .addPathSegments("v1", "workflows", params.getPathParam(0), "trigger")
            .body(json(clientOptions.jsonMapper, params._body()))
            .build()
            .prepare(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          val response = clientOptions.httpClient.execute(
            request, requestOptions
          )
          return response.parseable {
              response.use {
                  triggerHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.validate()
                  }
              }
          }
        }
    }
}
