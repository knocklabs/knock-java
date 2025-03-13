// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async

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
import app.knock.api.models.messages.Message
import app.knock.api.models.messages.MessageArchiveParams
import app.knock.api.models.messages.MessageGetContentParams
import app.knock.api.models.messages.MessageGetContentResponse
import app.knock.api.models.messages.MessageGetParams
import app.knock.api.models.messages.MessageListActivitiesPage
import app.knock.api.models.messages.MessageListActivitiesPageAsync
import app.knock.api.models.messages.MessageListActivitiesParams
import app.knock.api.models.messages.MessageListDeliveryLogsPage
import app.knock.api.models.messages.MessageListDeliveryLogsPageAsync
import app.knock.api.models.messages.MessageListDeliveryLogsParams
import app.knock.api.models.messages.MessageListEventsPage
import app.knock.api.models.messages.MessageListEventsPageAsync
import app.knock.api.models.messages.MessageListEventsParams
import app.knock.api.models.messages.MessageListPage
import app.knock.api.models.messages.MessageListPageAsync
import app.knock.api.models.messages.MessageListParams
import app.knock.api.models.messages.MessageMarkAsInteractedParams
import app.knock.api.models.messages.MessageMarkAsReadParams
import app.knock.api.models.messages.MessageMarkAsSeenParams
import app.knock.api.models.messages.MessageMarkAsUnreadParams
import app.knock.api.models.messages.MessageMarkAsUnseenParams
import app.knock.api.models.messages.MessageUnarchiveParams
import app.knock.api.services.async.messages.BatchServiceAsync
import app.knock.api.services.async.messages.BatchServiceAsyncImpl
import java.util.concurrent.CompletableFuture

class MessageServiceAsyncImpl internal constructor(
    private val clientOptions: ClientOptions,

) : MessageServiceAsync {

    private val withRawResponse: MessageServiceAsync.WithRawResponse by lazy { WithRawResponseImpl(clientOptions) }

    private val batch: BatchServiceAsync by lazy { BatchServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): MessageServiceAsync.WithRawResponse = withRawResponse

    override fun batch(): BatchServiceAsync = batch

    override fun list(params: MessageListParams, requestOptions: RequestOptions): CompletableFuture<MessageListPageAsync> =
        // get /v1/messages
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun archive(params: MessageArchiveParams, requestOptions: RequestOptions): CompletableFuture<Message> =
        // put /v1/messages/{message_id}/archived
        withRawResponse().archive(params, requestOptions).thenApply { it.parse() }

    override fun get(params: MessageGetParams, requestOptions: RequestOptions): CompletableFuture<Message> =
        // get /v1/messages/{message_id}
        withRawResponse().get(params, requestOptions).thenApply { it.parse() }

    override fun getContent(params: MessageGetContentParams, requestOptions: RequestOptions): CompletableFuture<MessageGetContentResponse> =
        // get /v1/messages/{message_id}/content
        withRawResponse().getContent(params, requestOptions).thenApply { it.parse() }

    override fun listActivities(params: MessageListActivitiesParams, requestOptions: RequestOptions): CompletableFuture<MessageListActivitiesPageAsync> =
        // get /v1/messages/{message_id}/activities
        withRawResponse().listActivities(params, requestOptions).thenApply { it.parse() }

    override fun listDeliveryLogs(params: MessageListDeliveryLogsParams, requestOptions: RequestOptions): CompletableFuture<MessageListDeliveryLogsPageAsync> =
        // get /v1/messages/{message_id}/delivery_logs
        withRawResponse().listDeliveryLogs(params, requestOptions).thenApply { it.parse() }

    override fun listEvents(params: MessageListEventsParams, requestOptions: RequestOptions): CompletableFuture<MessageListEventsPageAsync> =
        // get /v1/messages/{message_id}/events
        withRawResponse().listEvents(params, requestOptions).thenApply { it.parse() }

    override fun markAsInteracted(params: MessageMarkAsInteractedParams, requestOptions: RequestOptions): CompletableFuture<Message> =
        // put /v1/messages/{message_id}/interacted
        withRawResponse().markAsInteracted(params, requestOptions).thenApply { it.parse() }

    override fun markAsRead(params: MessageMarkAsReadParams, requestOptions: RequestOptions): CompletableFuture<Message> =
        // put /v1/messages/{message_id}/read
        withRawResponse().markAsRead(params, requestOptions).thenApply { it.parse() }

    override fun markAsSeen(params: MessageMarkAsSeenParams, requestOptions: RequestOptions): CompletableFuture<Message> =
        // put /v1/messages/{message_id}/seen
        withRawResponse().markAsSeen(params, requestOptions).thenApply { it.parse() }

    override fun markAsUnread(params: MessageMarkAsUnreadParams, requestOptions: RequestOptions): CompletableFuture<Message> =
        // delete /v1/messages/{message_id}/unread
        withRawResponse().markAsUnread(params, requestOptions).thenApply { it.parse() }

    override fun markAsUnseen(params: MessageMarkAsUnseenParams, requestOptions: RequestOptions): CompletableFuture<Message> =
        // delete /v1/messages/{message_id}/unseen
        withRawResponse().markAsUnseen(params, requestOptions).thenApply { it.parse() }

    override fun unarchive(params: MessageUnarchiveParams, requestOptions: RequestOptions): CompletableFuture<Message> =
        // delete /v1/messages/{message_id}/unarchived
        withRawResponse().unarchive(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(
        private val clientOptions: ClientOptions,

    ) : MessageServiceAsync.WithRawResponse {

        private val errorHandler: Handler<KnockError> = errorHandler(clientOptions.jsonMapper)

        private val batch: BatchServiceAsync.WithRawResponse by lazy { BatchServiceAsyncImpl.WithRawResponseImpl(clientOptions) }

        override fun batch(): BatchServiceAsync.WithRawResponse = batch

        private val listHandler: Handler<MessageListPageAsync.Response> = jsonHandler<MessageListPageAsync.Response>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun list(params: MessageListParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<MessageListPageAsync>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.GET)
            .addPathSegments("v1", "messages")
            .build()
            .prepareAsync(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          return request.thenComposeAsync { clientOptions.httpClient.executeAsync(
            it, requestOptions
          ) }.thenApply { response -> response.parseable {
              response.use {
                  listHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.validate()
                  }
              }
              .let {
                  MessageListPageAsync.of(MessageServiceAsyncImpl(clientOptions), params, it)
              }
          } }
        }

        private val archiveHandler: Handler<Message> = jsonHandler<Message>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun archive(params: MessageArchiveParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<Message>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.PUT)
            .addPathSegments("v1", "messages", params.getPathParam(0), "archived")
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
                    it.validate()
                  }
              }
          } }
        }

        private val getHandler: Handler<Message> = jsonHandler<Message>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun get(params: MessageGetParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<Message>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.GET)
            .addPathSegments("v1", "messages", params.getPathParam(0))
            .build()
            .prepareAsync(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          return request.thenComposeAsync { clientOptions.httpClient.executeAsync(
            it, requestOptions
          ) }.thenApply { response -> response.parseable {
              response.use {
                  getHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.validate()
                  }
              }
          } }
        }

        private val getContentHandler: Handler<MessageGetContentResponse> = jsonHandler<MessageGetContentResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun getContent(params: MessageGetContentParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<MessageGetContentResponse>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.GET)
            .addPathSegments("v1", "messages", params.getPathParam(0), "content")
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
                    it.validate()
                  }
              }
          } }
        }

        private val listActivitiesHandler: Handler<MessageListActivitiesPageAsync.Response> = jsonHandler<MessageListActivitiesPageAsync.Response>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun listActivities(params: MessageListActivitiesParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<MessageListActivitiesPageAsync>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.GET)
            .addPathSegments("v1", "messages", params.getPathParam(0), "activities")
            .build()
            .prepareAsync(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          return request.thenComposeAsync { clientOptions.httpClient.executeAsync(
            it, requestOptions
          ) }.thenApply { response -> response.parseable {
              response.use {
                  listActivitiesHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.validate()
                  }
              }
              .let {
                  MessageListActivitiesPageAsync.of(MessageServiceAsyncImpl(clientOptions), params, it)
              }
          } }
        }

        private val listDeliveryLogsHandler: Handler<MessageListDeliveryLogsPageAsync.Response> = jsonHandler<MessageListDeliveryLogsPageAsync.Response>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun listDeliveryLogs(params: MessageListDeliveryLogsParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<MessageListDeliveryLogsPageAsync>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.GET)
            .addPathSegments("v1", "messages", params.getPathParam(0), "delivery_logs")
            .build()
            .prepareAsync(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          return request.thenComposeAsync { clientOptions.httpClient.executeAsync(
            it, requestOptions
          ) }.thenApply { response -> response.parseable {
              response.use {
                  listDeliveryLogsHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.validate()
                  }
              }
              .let {
                  MessageListDeliveryLogsPageAsync.of(MessageServiceAsyncImpl(clientOptions), params, it)
              }
          } }
        }

        private val listEventsHandler: Handler<MessageListEventsPageAsync.Response> = jsonHandler<MessageListEventsPageAsync.Response>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun listEvents(params: MessageListEventsParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<MessageListEventsPageAsync>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.GET)
            .addPathSegments("v1", "messages", params.getPathParam(0), "events")
            .build()
            .prepareAsync(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          return request.thenComposeAsync { clientOptions.httpClient.executeAsync(
            it, requestOptions
          ) }.thenApply { response -> response.parseable {
              response.use {
                  listEventsHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.validate()
                  }
              }
              .let {
                  MessageListEventsPageAsync.of(MessageServiceAsyncImpl(clientOptions), params, it)
              }
          } }
        }

        private val markAsInteractedHandler: Handler<Message> = jsonHandler<Message>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun markAsInteracted(params: MessageMarkAsInteractedParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<Message>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.PUT)
            .addPathSegments("v1", "messages", params.getPathParam(0), "interacted")
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
                    it.validate()
                  }
              }
          } }
        }

        private val markAsReadHandler: Handler<Message> = jsonHandler<Message>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun markAsRead(params: MessageMarkAsReadParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<Message>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.PUT)
            .addPathSegments("v1", "messages", params.getPathParam(0), "read")
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
                    it.validate()
                  }
              }
          } }
        }

        private val markAsSeenHandler: Handler<Message> = jsonHandler<Message>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun markAsSeen(params: MessageMarkAsSeenParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<Message>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.PUT)
            .addPathSegments("v1", "messages", params.getPathParam(0), "seen")
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
                    it.validate()
                  }
              }
          } }
        }

        private val markAsUnreadHandler: Handler<Message> = jsonHandler<Message>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun markAsUnread(params: MessageMarkAsUnreadParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<Message>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.DELETE)
            .addPathSegments("v1", "messages", params.getPathParam(0), "unread")
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
                    it.validate()
                  }
              }
          } }
        }

        private val markAsUnseenHandler: Handler<Message> = jsonHandler<Message>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun markAsUnseen(params: MessageMarkAsUnseenParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<Message>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.DELETE)
            .addPathSegments("v1", "messages", params.getPathParam(0), "unseen")
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
                    it.validate()
                  }
              }
          } }
        }

        private val unarchiveHandler: Handler<Message> = jsonHandler<Message>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun unarchive(params: MessageUnarchiveParams, requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<Message>> {
          val request = HttpRequest.builder()
            .method(HttpMethod.DELETE)
            .addPathSegments("v1", "messages", params.getPathParam(0), "unarchived")
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
                    it.validate()
                  }
              }
          } }
        }
    }
}
