// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.blocking

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
import com.knock.api.core.prepare
import com.knock.api.errors.KnockError
import com.knock.api.models.MessageArchiveParams
import com.knock.api.models.MessageArchiveResponse
import com.knock.api.models.MessageGetContentParams
import com.knock.api.models.MessageGetContentResponse
import com.knock.api.models.MessageGetParams
import com.knock.api.models.MessageGetResponse
import com.knock.api.models.MessageListActivitiesPage
import com.knock.api.models.MessageListActivitiesParams
import com.knock.api.models.MessageListDeliveryLogsPage
import com.knock.api.models.MessageListDeliveryLogsParams
import com.knock.api.models.MessageListEventsPage
import com.knock.api.models.MessageListEventsParams
import com.knock.api.models.MessageListPage
import com.knock.api.models.MessageListParams
import com.knock.api.models.MessageMarkAsInteractedParams
import com.knock.api.models.MessageMarkAsInteractedResponse
import com.knock.api.models.MessageMarkAsReadParams
import com.knock.api.models.MessageMarkAsReadResponse
import com.knock.api.models.MessageMarkAsSeenParams
import com.knock.api.models.MessageMarkAsSeenResponse
import com.knock.api.models.MessageMarkAsUnreadParams
import com.knock.api.models.MessageMarkAsUnreadResponse
import com.knock.api.models.MessageMarkAsUnseenParams
import com.knock.api.models.MessageMarkAsUnseenResponse
import com.knock.api.models.MessageUnarchiveParams
import com.knock.api.models.MessageUnarchiveResponse
import com.knock.api.services.blocking.messages.BatchService
import com.knock.api.services.blocking.messages.BatchServiceImpl

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

    override fun archive(
        params: MessageArchiveParams,
        requestOptions: RequestOptions,
    ): MessageArchiveResponse =
        // put /v1/messages/{message_id}/archived
        withRawResponse().archive(params, requestOptions).parse()

    override fun get(params: MessageGetParams, requestOptions: RequestOptions): MessageGetResponse =
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
    ): MessageMarkAsInteractedResponse =
        // put /v1/messages/{message_id}/interacted
        withRawResponse().markAsInteracted(params, requestOptions).parse()

    override fun markAsRead(
        params: MessageMarkAsReadParams,
        requestOptions: RequestOptions,
    ): MessageMarkAsReadResponse =
        // put /v1/messages/{message_id}/read
        withRawResponse().markAsRead(params, requestOptions).parse()

    override fun markAsSeen(
        params: MessageMarkAsSeenParams,
        requestOptions: RequestOptions,
    ): MessageMarkAsSeenResponse =
        // put /v1/messages/{message_id}/seen
        withRawResponse().markAsSeen(params, requestOptions).parse()

    override fun markAsUnread(
        params: MessageMarkAsUnreadParams,
        requestOptions: RequestOptions,
    ): MessageMarkAsUnreadResponse =
        // delete /v1/messages/{message_id}/unread
        withRawResponse().markAsUnread(params, requestOptions).parse()

    override fun markAsUnseen(
        params: MessageMarkAsUnseenParams,
        requestOptions: RequestOptions,
    ): MessageMarkAsUnseenResponse =
        // delete /v1/messages/{message_id}/unseen
        withRawResponse().markAsUnseen(params, requestOptions).parse()

    override fun unarchive(
        params: MessageUnarchiveParams,
        requestOptions: RequestOptions,
    ): MessageUnarchiveResponse =
        // delete /v1/messages/{message_id}/unarchived
        withRawResponse().unarchive(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        MessageService.WithRawResponse {

        private val errorHandler: Handler<KnockError> = errorHandler(clientOptions.jsonMapper)

        private val batch: BatchService.WithRawResponse by lazy {
            BatchServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun batch(): BatchService.WithRawResponse = batch

        private val listHandler: Handler<MessageListPage.Response> =
            jsonHandler<MessageListPage.Response>(clientOptions.jsonMapper)
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
                    .let { MessageListPage.of(MessageServiceImpl(clientOptions), params, it) }
            }
        }

        private val archiveHandler: Handler<MessageArchiveResponse> =
            jsonHandler<MessageArchiveResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun archive(
            params: MessageArchiveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageArchiveResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .addPathSegments("v1", "messages", params.getPathParam(0), "archived")
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

        private val getHandler: Handler<MessageGetResponse> =
            jsonHandler<MessageGetResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun get(
            params: MessageGetParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageGetResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "messages", params.getPathParam(0))
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
                    .addPathSegments("v1", "messages", params.getPathParam(0), "content")
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

        private val listActivitiesHandler: Handler<MessageListActivitiesPage.Response> =
            jsonHandler<MessageListActivitiesPage.Response>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun listActivities(
            params: MessageListActivitiesParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageListActivitiesPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "messages", params.getPathParam(0), "activities")
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
                        MessageListActivitiesPage.of(MessageServiceImpl(clientOptions), params, it)
                    }
            }
        }

        private val listDeliveryLogsHandler: Handler<MessageListDeliveryLogsPage.Response> =
            jsonHandler<MessageListDeliveryLogsPage.Response>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun listDeliveryLogs(
            params: MessageListDeliveryLogsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageListDeliveryLogsPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "messages", params.getPathParam(0), "delivery_logs")
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
                        MessageListDeliveryLogsPage.of(
                            MessageServiceImpl(clientOptions),
                            params,
                            it,
                        )
                    }
            }
        }

        private val listEventsHandler: Handler<MessageListEventsPage.Response> =
            jsonHandler<MessageListEventsPage.Response>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun listEvents(
            params: MessageListEventsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageListEventsPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "messages", params.getPathParam(0), "events")
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
                    .let { MessageListEventsPage.of(MessageServiceImpl(clientOptions), params, it) }
            }
        }

        private val markAsInteractedHandler: Handler<MessageMarkAsInteractedResponse> =
            jsonHandler<MessageMarkAsInteractedResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun markAsInteracted(
            params: MessageMarkAsInteractedParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageMarkAsInteractedResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .addPathSegments("v1", "messages", params.getPathParam(0), "interacted")
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

        private val markAsReadHandler: Handler<MessageMarkAsReadResponse> =
            jsonHandler<MessageMarkAsReadResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun markAsRead(
            params: MessageMarkAsReadParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageMarkAsReadResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .addPathSegments("v1", "messages", params.getPathParam(0), "read")
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

        private val markAsSeenHandler: Handler<MessageMarkAsSeenResponse> =
            jsonHandler<MessageMarkAsSeenResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun markAsSeen(
            params: MessageMarkAsSeenParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageMarkAsSeenResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .addPathSegments("v1", "messages", params.getPathParam(0), "seen")
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

        private val markAsUnreadHandler: Handler<MessageMarkAsUnreadResponse> =
            jsonHandler<MessageMarkAsUnreadResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun markAsUnread(
            params: MessageMarkAsUnreadParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageMarkAsUnreadResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments("v1", "messages", params.getPathParam(0), "unread")
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

        private val markAsUnseenHandler: Handler<MessageMarkAsUnseenResponse> =
            jsonHandler<MessageMarkAsUnseenResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun markAsUnseen(
            params: MessageMarkAsUnseenParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageMarkAsUnseenResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments("v1", "messages", params.getPathParam(0), "unseen")
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

        private val unarchiveHandler: Handler<MessageUnarchiveResponse> =
            jsonHandler<MessageUnarchiveResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun unarchive(
            params: MessageUnarchiveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageUnarchiveResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments("v1", "messages", params.getPathParam(0), "unarchived")
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
