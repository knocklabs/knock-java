// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking

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
import app.knock.api.core.prepare
import app.knock.api.models.messages.Message
import app.knock.api.models.messages.MessageArchiveParams
import app.knock.api.models.messages.MessageGetContentParams
import app.knock.api.models.messages.MessageGetContentResponse
import app.knock.api.models.messages.MessageGetParams
import app.knock.api.models.messages.MessageListActivitiesPage
import app.knock.api.models.messages.MessageListActivitiesPageResponse
import app.knock.api.models.messages.MessageListActivitiesParams
import app.knock.api.models.messages.MessageListDeliveryLogsPage
import app.knock.api.models.messages.MessageListDeliveryLogsPageResponse
import app.knock.api.models.messages.MessageListDeliveryLogsParams
import app.knock.api.models.messages.MessageListEventsPage
import app.knock.api.models.messages.MessageListEventsPageResponse
import app.knock.api.models.messages.MessageListEventsParams
import app.knock.api.models.messages.MessageListPage
import app.knock.api.models.messages.MessageListPageResponse
import app.knock.api.models.messages.MessageListParams
import app.knock.api.models.messages.MessageMarkAsInteractedParams
import app.knock.api.models.messages.MessageMarkAsReadParams
import app.knock.api.models.messages.MessageMarkAsSeenParams
import app.knock.api.models.messages.MessageMarkAsUnreadParams
import app.knock.api.models.messages.MessageMarkAsUnseenParams
import app.knock.api.models.messages.MessageUnarchiveParams
import app.knock.api.services.blocking.messages.BatchService
import app.knock.api.services.blocking.messages.BatchServiceImpl

class MessageServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    MessageService {

    private val withRawResponse: MessageService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val batch: BatchService by lazy { BatchServiceImpl(clientOptions) }

    override fun withRawResponse(): MessageService.WithRawResponse = withRawResponse

    override fun batch(): BatchService = batch

    override fun list(params: MessageListParams, requestOptions: RequestOptions): MessageListPage =
        // get /v1/messages
        withRawResponse().list(params, requestOptions).parse()

    override fun archive(params: MessageArchiveParams, requestOptions: RequestOptions): Message =
        // put /v1/messages/{message_id}/archived
        withRawResponse().archive(params, requestOptions).parse()

    override fun get(params: MessageGetParams, requestOptions: RequestOptions): Message =
        // get /v1/messages/{message_id}
        withRawResponse().get(params, requestOptions).parse()

    override fun getContent(
        params: MessageGetContentParams,
        requestOptions: RequestOptions,
    ): MessageGetContentResponse =
        // get /v1/messages/{message_id}/content
        withRawResponse().getContent(params, requestOptions).parse()

    override fun listActivities(
        params: MessageListActivitiesParams,
        requestOptions: RequestOptions,
    ): MessageListActivitiesPage =
        // get /v1/messages/{message_id}/activities
        withRawResponse().listActivities(params, requestOptions).parse()

    override fun listDeliveryLogs(
        params: MessageListDeliveryLogsParams,
        requestOptions: RequestOptions,
    ): MessageListDeliveryLogsPage =
        // get /v1/messages/{message_id}/delivery_logs
        withRawResponse().listDeliveryLogs(params, requestOptions).parse()

    override fun listEvents(
        params: MessageListEventsParams,
        requestOptions: RequestOptions,
    ): MessageListEventsPage =
        // get /v1/messages/{message_id}/events
        withRawResponse().listEvents(params, requestOptions).parse()

    override fun markAsInteracted(
        params: MessageMarkAsInteractedParams,
        requestOptions: RequestOptions,
    ): Message =
        // put /v1/messages/{message_id}/interacted
        withRawResponse().markAsInteracted(params, requestOptions).parse()

    override fun markAsRead(
        params: MessageMarkAsReadParams,
        requestOptions: RequestOptions,
    ): Message =
        // put /v1/messages/{message_id}/read
        withRawResponse().markAsRead(params, requestOptions).parse()

    override fun markAsSeen(
        params: MessageMarkAsSeenParams,
        requestOptions: RequestOptions,
    ): Message =
        // put /v1/messages/{message_id}/seen
        withRawResponse().markAsSeen(params, requestOptions).parse()

    override fun markAsUnread(
        params: MessageMarkAsUnreadParams,
        requestOptions: RequestOptions,
    ): Message =
        // delete /v1/messages/{message_id}/unread
        withRawResponse().markAsUnread(params, requestOptions).parse()

    override fun markAsUnseen(
        params: MessageMarkAsUnseenParams,
        requestOptions: RequestOptions,
    ): Message =
        // delete /v1/messages/{message_id}/unseen
        withRawResponse().markAsUnseen(params, requestOptions).parse()

    override fun unarchive(
        params: MessageUnarchiveParams,
        requestOptions: RequestOptions,
    ): Message =
        // delete /v1/messages/{message_id}/unarchived
        withRawResponse().unarchive(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        MessageService.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val batch: BatchService.WithRawResponse by lazy {
            BatchServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun batch(): BatchService.WithRawResponse = batch

        private val listHandler: Handler<MessageListPageResponse> =
            jsonHandler<MessageListPageResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun list(
            params: MessageListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "messages")
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
                        MessageListPage.builder()
                            .service(MessageServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val archiveHandler: Handler<Message> =
            jsonHandler<Message>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun archive(
            params: MessageArchiveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Message> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .addPathSegments("v1", "messages", params._pathParam(0), "archived")
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { archiveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val getHandler: Handler<Message> =
            jsonHandler<Message>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun get(
            params: MessageGetParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Message> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "messages", params._pathParam(0))
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

        private val getContentHandler: Handler<MessageGetContentResponse> =
            jsonHandler<MessageGetContentResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun getContent(
            params: MessageGetContentParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageGetContentResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "messages", params._pathParam(0), "content")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { getContentHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listActivitiesHandler: Handler<MessageListActivitiesPageResponse> =
            jsonHandler<MessageListActivitiesPageResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun listActivities(
            params: MessageListActivitiesParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageListActivitiesPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "messages", params._pathParam(0), "activities")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { listActivitiesHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        MessageListActivitiesPage.builder()
                            .service(MessageServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val listDeliveryLogsHandler: Handler<MessageListDeliveryLogsPageResponse> =
            jsonHandler<MessageListDeliveryLogsPageResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun listDeliveryLogs(
            params: MessageListDeliveryLogsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageListDeliveryLogsPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "messages", params._pathParam(0), "delivery_logs")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { listDeliveryLogsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        MessageListDeliveryLogsPage.builder()
                            .service(MessageServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val listEventsHandler: Handler<MessageListEventsPageResponse> =
            jsonHandler<MessageListEventsPageResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun listEvents(
            params: MessageListEventsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageListEventsPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "messages", params._pathParam(0), "events")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { listEventsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        MessageListEventsPage.builder()
                            .service(MessageServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val markAsInteractedHandler: Handler<Message> =
            jsonHandler<Message>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun markAsInteracted(
            params: MessageMarkAsInteractedParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Message> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .addPathSegments("v1", "messages", params._pathParam(0), "interacted")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { markAsInteractedHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val markAsReadHandler: Handler<Message> =
            jsonHandler<Message>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun markAsRead(
            params: MessageMarkAsReadParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Message> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .addPathSegments("v1", "messages", params._pathParam(0), "read")
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { markAsReadHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val markAsSeenHandler: Handler<Message> =
            jsonHandler<Message>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun markAsSeen(
            params: MessageMarkAsSeenParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Message> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .addPathSegments("v1", "messages", params._pathParam(0), "seen")
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { markAsSeenHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val markAsUnreadHandler: Handler<Message> =
            jsonHandler<Message>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun markAsUnread(
            params: MessageMarkAsUnreadParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Message> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments("v1", "messages", params._pathParam(0), "unread")
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { markAsUnreadHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val markAsUnseenHandler: Handler<Message> =
            jsonHandler<Message>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun markAsUnseen(
            params: MessageMarkAsUnseenParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Message> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments("v1", "messages", params._pathParam(0), "unseen")
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { markAsUnseenHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val unarchiveHandler: Handler<Message> =
            jsonHandler<Message>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun unarchive(
            params: MessageUnarchiveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Message> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments("v1", "messages", params._pathParam(0), "unarchived")
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { unarchiveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
