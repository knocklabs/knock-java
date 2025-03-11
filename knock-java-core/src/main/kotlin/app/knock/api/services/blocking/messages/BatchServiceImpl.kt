// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking.messages

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
import app.knock.api.core.prepare
import app.knock.api.errors.KnockError
import app.knock.api.models.messages.Message
import app.knock.api.models.messages.batch.BatchArchiveParams
import app.knock.api.models.messages.batch.BatchGetContentParams
import app.knock.api.models.messages.batch.BatchMarkAsInteractedParams
import app.knock.api.models.messages.batch.BatchMarkAsReadParams
import app.knock.api.models.messages.batch.BatchMarkAsSeenParams
import app.knock.api.models.messages.batch.BatchMarkAsUnreadParams
import app.knock.api.models.messages.batch.BatchMarkAsUnseenParams
import app.knock.api.models.messages.batch.BatchUnarchiveParams

class BatchServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    BatchService {

    private val withRawResponse: BatchService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): BatchService.WithRawResponse = withRawResponse

    override fun archive(
        params: BatchArchiveParams,
        requestOptions: RequestOptions,
    ): List<Message> =
        // post /v1/messages/batch/archived
        withRawResponse().archive(params, requestOptions).parse()

    override fun getContent(
        params: BatchGetContentParams,
        requestOptions: RequestOptions,
    ): List<MessageContent> =
        // get /v1/messages/batch/content
        withRawResponse().getContent(params, requestOptions).parse()

    override fun markAsInteracted(
        params: BatchMarkAsInteractedParams,
        requestOptions: RequestOptions,
    ): List<Message> =
        // post /v1/messages/batch/interacted
        withRawResponse().markAsInteracted(params, requestOptions).parse()

    override fun markAsRead(
        params: BatchMarkAsReadParams,
        requestOptions: RequestOptions,
    ): List<Message> =
        // post /v1/messages/batch/read
        withRawResponse().markAsRead(params, requestOptions).parse()

    override fun markAsSeen(
        params: BatchMarkAsSeenParams,
        requestOptions: RequestOptions,
    ): List<Message> =
        // post /v1/messages/batch/seen
        withRawResponse().markAsSeen(params, requestOptions).parse()

    override fun markAsUnread(
        params: BatchMarkAsUnreadParams,
        requestOptions: RequestOptions,
    ): List<Message> =
        // post /v1/messages/batch/unread
        withRawResponse().markAsUnread(params, requestOptions).parse()

    override fun markAsUnseen(
        params: BatchMarkAsUnseenParams,
        requestOptions: RequestOptions,
    ): List<Message> =
        // post /v1/messages/batch/unseen
        withRawResponse().markAsUnseen(params, requestOptions).parse()

    override fun unarchive(
        params: BatchUnarchiveParams,
        requestOptions: RequestOptions,
    ): List<Message> =
        // post /v1/messages/batch/unarchived
        withRawResponse().unarchive(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        BatchService.WithRawResponse {

        private val errorHandler: Handler<KnockError> = errorHandler(clientOptions.jsonMapper)

        private val archiveHandler: Handler<List<Message>> =
            jsonHandler<List<Message>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun archive(
            params: BatchArchiveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<Message>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "messages", "batch", "archived")
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
                            it.forEach { it.validate() }
                        }
                    }
            }
        }

        private val getContentHandler: Handler<List<MessageContent>> =
            jsonHandler<List<MessageContent>>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun getContent(
            params: BatchGetContentParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<MessageContent>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "messages", "batch", "content")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { getContentHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.forEach { it.validate() }
                        }
                    }
            }
        }

        private val markAsInteractedHandler: Handler<List<Message>> =
            jsonHandler<List<Message>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun markAsInteracted(
            params: BatchMarkAsInteractedParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<Message>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "messages", "batch", "interacted")
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
                            it.forEach { it.validate() }
                        }
                    }
            }
        }

        private val markAsReadHandler: Handler<List<Message>> =
            jsonHandler<List<Message>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun markAsRead(
            params: BatchMarkAsReadParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<Message>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "messages", "batch", "read")
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
                            it.forEach { it.validate() }
                        }
                    }
            }
        }

        private val markAsSeenHandler: Handler<List<Message>> =
            jsonHandler<List<Message>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun markAsSeen(
            params: BatchMarkAsSeenParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<Message>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "messages", "batch", "seen")
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
                            it.forEach { it.validate() }
                        }
                    }
            }
        }

        private val markAsUnreadHandler: Handler<List<Message>> =
            jsonHandler<List<Message>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun markAsUnread(
            params: BatchMarkAsUnreadParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<Message>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "messages", "batch", "unread")
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
                            it.forEach { it.validate() }
                        }
                    }
            }
        }

        private val markAsUnseenHandler: Handler<List<Message>> =
            jsonHandler<List<Message>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun markAsUnseen(
            params: BatchMarkAsUnseenParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<Message>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "messages", "batch", "unseen")
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
                            it.forEach { it.validate() }
                        }
                    }
            }
        }

        private val unarchiveHandler: Handler<List<Message>> =
            jsonHandler<List<Message>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun unarchive(
            params: BatchUnarchiveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<Message>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "messages", "batch", "unarchived")
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
                            it.forEach { it.validate() }
                        }
                    }
            }
        }
    }
}
