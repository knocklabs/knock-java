// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async.users

import app.knock.api.core.ClientOptions
import app.knock.api.core.RequestOptions
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
import app.knock.api.errors.KnockError
import app.knock.api.models.bulkoperations.BulkOperation
import app.knock.api.models.users.bulk.BulkDeleteParams
import app.knock.api.models.users.bulk.BulkIdentifyParams
import app.knock.api.models.users.bulk.BulkSetPreferencesParams
import java.util.concurrent.CompletableFuture

class BulkServiceAsyncImpl internal constructor(
    private val clientOptions: ClientOptions,

) : BulkServiceAsync {

    private val withRawResponse: BulkServiceAsync.WithRawResponse by lazy { WithRawResponseImpl(clientOptions) }

    override fun withRawResponse(): BulkServiceAsync.WithRawResponse = withRawResponse

    override fun delete(params: BulkDeleteParams, requestOptions: RequestOptions): CompletableFuture<BulkOperation> =
        // post /v1/users/bulk/delete
        withRawResponse().delete(params, requestOptions).thenApply { it.parse() }

    override fun identify(params: BulkIdentifyParams, requestOptions: RequestOptions): CompletableFuture<BulkOperation> =
        // post /v1/users/bulk/identify
        withRawResponse().identify(params, requestOptions).thenApply { it.parse() }

    override fun setPreferences(params: BulkSetPreferencesParams, requestOptions: RequestOptions): CompletableFuture<BulkOperation> =
        // post /v1/users/bulk/preferences
        withRawResponse().setPreferences(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(
        private val clientOptions: ClientOptions,

    ) : BulkServiceAsync.WithRawResponse {

        private val errorHandler: Handler<KnockError> = errorHandler(clientOptions.jsonMapper)

        private val deleteHandler: Handler<BulkOperation> = jsonHandler<BulkOperation>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun delete(params: BulkDeleteParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<BulkOperation>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.POST)
            .addPathSegments("v1", "users", "bulk", "delete")
            .body(json(clientOptions.jsonMapper, params._body()))
            .build()
            .prepareAsync(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          return request.thenComposeAsync { clientOptions.httpClient.executeAsync(
            it, requestOptions
          ) }.thenApply { response -> response.parseable {
              response.use {
                  deleteHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.validate()
                  }
              }
          } }
        }

        private val identifyHandler: Handler<BulkOperation> = jsonHandler<BulkOperation>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun identify(params: BulkIdentifyParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<BulkOperation>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.POST)
            .addPathSegments("v1", "users", "bulk", "identify")
            .body(json(clientOptions.jsonMapper, params._body()))
            .build()
            .prepareAsync(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          return request.thenComposeAsync { clientOptions.httpClient.executeAsync(
            it, requestOptions
          ) }.thenApply { response -> response.parseable {
              response.use {
                  identifyHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.validate()
                  }
              }
          } }
        }

        private val setPreferencesHandler: Handler<BulkOperation> = jsonHandler<BulkOperation>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun setPreferences(params: BulkSetPreferencesParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<BulkOperation>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.POST)
            .addPathSegments("v1", "users", "bulk", "preferences")
            .body(json(clientOptions.jsonMapper, params._body()))
            .build()
            .prepareAsync(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          return request.thenComposeAsync { clientOptions.httpClient.executeAsync(
            it, requestOptions
          ) }.thenApply { response -> response.parseable {
              response.use {
                  setPreferencesHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.validate()
                  }
              }
          } }
        }
    }
}
