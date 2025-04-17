// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async.channels

import app.knock.api.core.ClientOptions
import app.knock.api.core.JsonValue
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
import app.knock.api.models.bulkoperations.BulkOperation
import app.knock.api.models.channels.bulk.BulkUpdateMessageStatusParams
import java.util.concurrent.CompletableFuture

class BulkServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    BulkServiceAsync {

    private val withRawResponse: BulkServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): BulkServiceAsync.WithRawResponse = withRawResponse

    override fun updateMessageStatus(
        params: BulkUpdateMessageStatusParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<BulkOperation> =
        // post /v1/channels/{channel_id}/messages/bulk/{action}
        withRawResponse().updateMessageStatus(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        BulkServiceAsync.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val updateMessageStatusHandler: Handler<BulkOperation> =
            jsonHandler<BulkOperation>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun updateMessageStatus(
            params: BulkUpdateMessageStatusParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<BulkOperation>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments(
                        "v1",
                        "channels",
                        params._pathParam(0),
                        "messages",
                        "bulk",
                        params._pathParam(1),
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
                            .use { updateMessageStatusHandler.handle(it) }
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
