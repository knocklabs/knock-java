// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.async.messages

import com.knock.api.core.ClientOptions
import com.knock.api.core.RequestOptions
import com.knock.api.core.handlers.errorHandler
import com.knock.api.core.handlers.jsonHandler
import com.knock.api.core.handlers.withErrorHandler
import com.knock.api.core.http.HttpMethod
import com.knock.api.core.http.HttpRequest
import com.knock.api.core.http.HttpResponse.Handler
import com.knock.api.core.http.HttpResponseFor
import com.knock.api.core.http.json
import com.knock.api.core.http.parseable
import com.knock.api.core.prepareAsync
import com.knock.api.errors.KnockError
import com.knock.api.models.messages.Message
import com.knock.api.models.messages.batch
import com.knock.api.models.messages.batch.BatchArchiveParams
import com.knock.api.models.messages.batch.BatchGetContentParams
import com.knock.api.models.messages.batch.BatchMarkAsInteractedParams
import com.knock.api.models.messages.batch.BatchMarkAsReadParams
import com.knock.api.models.messages.batch.BatchMarkAsSeenParams
import com.knock.api.models.messages.batch.BatchMarkAsUnreadParams
import com.knock.api.models.messages.batch.BatchMarkAsUnseenParams
import com.knock.api.models.messages.batch.BatchUnarchiveParams
import java.util.concurrent.CompletableFuture

class BatchServiceAsyncImpl internal constructor(
    private val clientOptions: ClientOptions,

) : BatchServiceAsync {

    private val withRawResponse: BatchServiceAsync.WithRawResponse by lazy { WithRawResponseImpl(clientOptions) }

    override fun withRawResponse(): BatchServiceAsync.WithRawResponse = withRawResponse

    override fun archive(params: BatchArchiveParams, requestOptions: RequestOptions): CompletableFuture<List<Message>> =
        // post /v1/messages/batch/archived
        withRawResponse().archive(params, requestOptions).thenApply { it.parse() }

    override fun getContent(params: BatchGetContentParams, requestOptions: RequestOptions): CompletableFuture<List<MessageContent>> =
        // get /v1/messages/batch/content
        withRawResponse().getContent(params, requestOptions).thenApply { it.parse() }

    override fun markAsInteracted(params: BatchMarkAsInteractedParams, requestOptions: RequestOptions): CompletableFuture<List<Message>> =
        // post /v1/messages/batch/interacted
        withRawResponse().markAsInteracted(params, requestOptions).thenApply { it.parse() }

    override fun markAsRead(params: BatchMarkAsReadParams, requestOptions: RequestOptions): CompletableFuture<List<Message>> =
        // post /v1/messages/batch/read
        withRawResponse().markAsRead(params, requestOptions).thenApply { it.parse() }

    override fun markAsSeen(params: BatchMarkAsSeenParams, requestOptions: RequestOptions): CompletableFuture<List<Message>> =
        // post /v1/messages/batch/seen
        withRawResponse().markAsSeen(params, requestOptions).thenApply { it.parse() }

    override fun markAsUnread(params: BatchMarkAsUnreadParams, requestOptions: RequestOptions): CompletableFuture<List<Message>> =
        // post /v1/messages/batch/unread
        withRawResponse().markAsUnread(params, requestOptions).thenApply { it.parse() }

    override fun markAsUnseen(params: BatchMarkAsUnseenParams, requestOptions: RequestOptions): CompletableFuture<List<Message>> =
        // post /v1/messages/batch/unseen
        withRawResponse().markAsUnseen(params, requestOptions).thenApply { it.parse() }

    override fun unarchive(params: BatchUnarchiveParams, requestOptions: RequestOptions): CompletableFuture<List<Message>> =
        // post /v1/messages/batch/unarchived
        withRawResponse().unarchive(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(
        private val clientOptions: ClientOptions,

    ) : BatchServiceAsync.WithRawResponse {

        private val errorHandler: Handler<KnockError> = errorHandler(clientOptions.jsonMapper)

        private val archiveHandler: Handler<List<Message>> = jsonHandler<List<Message>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun archive(params: BatchArchiveParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<List<Message>>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.POST)
            .addPathSegments("v1", "messages", "batch", "archived")
            .apply { params._body().ifPresent{ body(json(clientOptions.jsonMapper, it)) } }
            .build()
            .prepareAsync(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          return request.thenComposeAsync { clientOptions.httpClient.executeAsync(
            it, requestOptions
          ) }.thenApply { response -> response.parseable {
              response.use {
                  archiveHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.forEach { it.validate() }
                  }
              }
          } }
        }

        private val getContentHandler: Handler<List<MessageContent>> = jsonHandler<List<MessageContent>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun getContent(params: BatchGetContentParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<List<MessageContent>>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.GET)
            .addPathSegments("v1", "messages", "batch", "content")
            .build()
            .prepareAsync(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          return request.thenComposeAsync { clientOptions.httpClient.executeAsync(
            it, requestOptions
          ) }.thenApply { response -> response.parseable {
              response.use {
                  getContentHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.forEach { it.validate() }
                  }
              }
          } }
        }

        private val markAsInteractedHandler: Handler<List<Message>> = jsonHandler<List<Message>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun markAsInteracted(params: BatchMarkAsInteractedParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<List<Message>>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.POST)
            .addPathSegments("v1", "messages", "batch", "interacted")
            .body(json(clientOptions.jsonMapper, params._body()))
            .build()
            .prepareAsync(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          return request.thenComposeAsync { clientOptions.httpClient.executeAsync(
            it, requestOptions
          ) }.thenApply { response -> response.parseable {
              response.use {
                  markAsInteractedHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.forEach { it.validate() }
                  }
              }
          } }
        }

        private val markAsReadHandler: Handler<List<Message>> = jsonHandler<List<Message>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun markAsRead(params: BatchMarkAsReadParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<List<Message>>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.POST)
            .addPathSegments("v1", "messages", "batch", "read")
            .apply { params._body().ifPresent{ body(json(clientOptions.jsonMapper, it)) } }
            .build()
            .prepareAsync(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          return request.thenComposeAsync { clientOptions.httpClient.executeAsync(
            it, requestOptions
          ) }.thenApply { response -> response.parseable {
              response.use {
                  markAsReadHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.forEach { it.validate() }
                  }
              }
          } }
        }

        private val markAsSeenHandler: Handler<List<Message>> = jsonHandler<List<Message>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun markAsSeen(params: BatchMarkAsSeenParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<List<Message>>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.POST)
            .addPathSegments("v1", "messages", "batch", "seen")
            .apply { params._body().ifPresent{ body(json(clientOptions.jsonMapper, it)) } }
            .build()
            .prepareAsync(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          return request.thenComposeAsync { clientOptions.httpClient.executeAsync(
            it, requestOptions
          ) }.thenApply { response -> response.parseable {
              response.use {
                  markAsSeenHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.forEach { it.validate() }
                  }
              }
          } }
        }

        private val markAsUnreadHandler: Handler<List<Message>> = jsonHandler<List<Message>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun markAsUnread(params: BatchMarkAsUnreadParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<List<Message>>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.POST)
            .addPathSegments("v1", "messages", "batch", "unread")
            .apply { params._body().ifPresent{ body(json(clientOptions.jsonMapper, it)) } }
            .build()
            .prepareAsync(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          return request.thenComposeAsync { clientOptions.httpClient.executeAsync(
            it, requestOptions
          ) }.thenApply { response -> response.parseable {
              response.use {
                  markAsUnreadHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.forEach { it.validate() }
                  }
              }
          } }
        }

        private val markAsUnseenHandler: Handler<List<Message>> = jsonHandler<List<Message>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun markAsUnseen(params: BatchMarkAsUnseenParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<List<Message>>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.POST)
            .addPathSegments("v1", "messages", "batch", "unseen")
            .apply { params._body().ifPresent{ body(json(clientOptions.jsonMapper, it)) } }
            .build()
            .prepareAsync(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          return request.thenComposeAsync { clientOptions.httpClient.executeAsync(
            it, requestOptions
          ) }.thenApply { response -> response.parseable {
              response.use {
                  markAsUnseenHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.forEach { it.validate() }
                  }
              }
          } }
        }

        private val unarchiveHandler: Handler<List<Message>> = jsonHandler<List<Message>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun unarchive(params: BatchUnarchiveParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<List<Message>>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.POST)
            .addPathSegments("v1", "messages", "batch", "unarchived")
            .apply { params._body().ifPresent{ body(json(clientOptions.jsonMapper, it)) } }
            .build()
            .prepareAsync(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          return request.thenComposeAsync { clientOptions.httpClient.executeAsync(
            it, requestOptions
          ) }.thenApply { response -> response.parseable {
              response.use {
                  unarchiveHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.forEach { it.validate() }
                  }
              }
          } }
        }
    }
}
