// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking

import app.knock.api.core.ClientOptions
import app.knock.api.core.RequestOptions
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
import app.knock.api.core.prepare
import app.knock.api.errors.KnockError
import app.knock.api.models.audiences.AudienceAddMembersParams
import app.knock.api.models.audiences.AudienceListMembersParams
import app.knock.api.models.audiences.AudienceListMembersResponse
import app.knock.api.models.audiences.AudienceRemoveMembersParams

class AudienceServiceImpl internal constructor(
    private val clientOptions: ClientOptions,

) : AudienceService {

    private val withRawResponse: AudienceService.WithRawResponse by lazy { WithRawResponseImpl(clientOptions) }

    override fun withRawResponse(): AudienceService.WithRawResponse = withRawResponse

    override fun addMembers(params: AudienceAddMembersParams, requestOptions: RequestOptions): String =
        // post /v1/audiences/{key}/members
        withRawResponse().addMembers(params, requestOptions).parse()

    override fun listMembers(params: AudienceListMembersParams, requestOptions: RequestOptions): AudienceListMembersResponse =
        // get /v1/audiences/{key}/members
        withRawResponse().listMembers(params, requestOptions).parse()

    override fun removeMembers(params: AudienceRemoveMembersParams, requestOptions: RequestOptions): String =
        // delete /v1/audiences/{key}/members
        withRawResponse().removeMembers(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(
        private val clientOptions: ClientOptions,

    ) : AudienceService.WithRawResponse {

        private val errorHandler: Handler<KnockError> = errorHandler(clientOptions.jsonMapper)

        private val addMembersHandler: Handler<String> = stringHandler().withErrorHandler(errorHandler)

        override fun addMembers(params: AudienceAddMembersParams, requestOptions: RequestOptions): HttpResponseFor<String> {
          val request = HttpRequest.builder()
            .method(HttpMethod.POST)
            .addPathSegments("v1", "audiences", params.getPathParam(0), "members")
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
                  addMembersHandler.handle(it)
              }
          }
        }

        private val listMembersHandler: Handler<AudienceListMembersResponse> = jsonHandler<AudienceListMembersResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun listMembers(params: AudienceListMembersParams, requestOptions: RequestOptions): HttpResponseFor<AudienceListMembersResponse> {
          val request = HttpRequest.builder()
            .method(HttpMethod.GET)
            .addPathSegments("v1", "audiences", params.getPathParam(0), "members")
            .build()
            .prepare(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          val response = clientOptions.httpClient.execute(
            request, requestOptions
          )
          return response.parseable {
              response.use {
                  listMembersHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.validate()
                  }
              }
          }
        }

        private val removeMembersHandler: Handler<String> = stringHandler().withErrorHandler(errorHandler)

        override fun removeMembers(params: AudienceRemoveMembersParams, requestOptions: RequestOptions): HttpResponseFor<String> {
          val request = HttpRequest.builder()
            .method(HttpMethod.DELETE)
            .addPathSegments("v1", "audiences", params.getPathParam(0), "members")
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
                  removeMembersHandler.handle(it)
              }
          }
        }
    }
}
