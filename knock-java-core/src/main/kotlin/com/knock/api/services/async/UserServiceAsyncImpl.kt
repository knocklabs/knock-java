// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.async

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
import com.knock.api.core.prepareAsync
import com.knock.api.errors.KnockError
import com.knock.api.models.ChannelData
import com.knock.api.models.PreferenceSet
import com.knock.api.models.User
import com.knock.api.models.UserDeleteParams
import com.knock.api.models.UserGetChannelDataParams
import com.knock.api.models.UserGetParams
import com.knock.api.models.UserGetPreferencesParams
import com.knock.api.models.UserListMessagesPageAsync
import com.knock.api.models.UserListMessagesParams
import com.knock.api.models.UserListPageAsync
import com.knock.api.models.UserListParams
import com.knock.api.models.UserListPreferencesParams
import com.knock.api.models.UserListSchedulesPageAsync
import com.knock.api.models.UserListSchedulesParams
import com.knock.api.models.UserListSubscriptionsPageAsync
import com.knock.api.models.UserListSubscriptionsParams
import com.knock.api.models.UserMergeParams
import com.knock.api.models.UserSetChannelDataParams
import com.knock.api.models.UserSetPreferencesParams
import com.knock.api.models.UserUnsetChannelDataParams
import com.knock.api.models.UserUpdateParams
import com.knock.api.services.async.users.BulkServiceAsync
import com.knock.api.services.async.users.BulkServiceAsyncImpl
import com.knock.api.services.async.users.FeedServiceAsync
import com.knock.api.services.async.users.FeedServiceAsyncImpl
import java.util.concurrent.CompletableFuture

class UserServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    UserServiceAsync {

    private val withRawResponse: UserServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val feeds: FeedServiceAsync by lazy { FeedServiceAsyncImpl(clientOptions) }

    private val bulk: BulkServiceAsync by lazy { BulkServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): UserServiceAsync.WithRawResponse = withRawResponse

    override fun feeds(): FeedServiceAsync = feeds

    override fun bulk(): BulkServiceAsync = bulk

    override fun update(
        params: UserUpdateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<User> =
        // put /v1/users/{user_id}
        withRawResponse().update(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: UserListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<UserListPageAsync> =
        // get /v1/users
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun delete(
        params: UserDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<String> =
        // delete /v1/users/{user_id}
        withRawResponse().delete(params, requestOptions).thenApply { it.parse() }

    override fun get(
        params: UserGetParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<User> =
        // get /v1/users/{user_id}
        withRawResponse().get(params, requestOptions).thenApply { it.parse() }

    override fun getChannelData(
        params: UserGetChannelDataParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ChannelData> =
        // get /v1/users/{user_id}/channel_data/{channel_id}
        withRawResponse().getChannelData(params, requestOptions).thenApply { it.parse() }

    override fun getPreferences(
        params: UserGetPreferencesParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<PreferenceSet> =
        // get /v1/users/{user_id}/preferences/{preference_set_id}
        withRawResponse().getPreferences(params, requestOptions).thenApply { it.parse() }

    override fun listMessages(
        params: UserListMessagesParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<UserListMessagesPageAsync> =
        // get /v1/users/{user_id}/messages
        withRawResponse().listMessages(params, requestOptions).thenApply { it.parse() }

    override fun listPreferences(
        params: UserListPreferencesParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<PreferenceSet>> =
        // get /v1/users/{user_id}/preferences
        withRawResponse().listPreferences(params, requestOptions).thenApply { it.parse() }

    override fun listSchedules(
        params: UserListSchedulesParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<UserListSchedulesPageAsync> =
        // get /v1/users/{user_id}/schedules
        withRawResponse().listSchedules(params, requestOptions).thenApply { it.parse() }

    override fun listSubscriptions(
        params: UserListSubscriptionsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<UserListSubscriptionsPageAsync> =
        // get /v1/users/{user_id}/subscriptions
        withRawResponse().listSubscriptions(params, requestOptions).thenApply { it.parse() }

    override fun merge(
        params: UserMergeParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<User> =
        // post /v1/users/{user_id}/merge
        withRawResponse().merge(params, requestOptions).thenApply { it.parse() }

    override fun setChannelData(
        params: UserSetChannelDataParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ChannelData> =
        // put /v1/users/{user_id}/channel_data/{channel_id}
        withRawResponse().setChannelData(params, requestOptions).thenApply { it.parse() }

    override fun setPreferences(
        params: UserSetPreferencesParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<PreferenceSet> =
        // put /v1/users/{user_id}/preferences/{preference_set_id}
        withRawResponse().setPreferences(params, requestOptions).thenApply { it.parse() }

    override fun unsetChannelData(
        params: UserUnsetChannelDataParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<String> =
        // delete /v1/users/{user_id}/channel_data/{channel_id}
        withRawResponse().unsetChannelData(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        UserServiceAsync.WithRawResponse {

        private val errorHandler: Handler<KnockError> = errorHandler(clientOptions.jsonMapper)

        private val feeds: FeedServiceAsync.WithRawResponse by lazy {
            FeedServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val bulk: BulkServiceAsync.WithRawResponse by lazy {
            BulkServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun feeds(): FeedServiceAsync.WithRawResponse = feeds

        override fun bulk(): BulkServiceAsync.WithRawResponse = bulk

        private val updateHandler: Handler<User> =
            jsonHandler<User>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun update(
            params: UserUpdateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<User>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .addPathSegments("v1", "users", params.getPathParam(0))
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { updateHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val listHandler: Handler<UserListPageAsync.Response> =
            jsonHandler<UserListPageAsync.Response>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun list(
            params: UserListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UserListPageAsync>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "users")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { listHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                            .let {
                                UserListPageAsync.of(
                                    UserServiceAsyncImpl(clientOptions),
                                    params,
                                    it,
                                )
                            }
                    }
                }
        }

        private val deleteHandler: Handler<String> = stringHandler().withErrorHandler(errorHandler)

        override fun delete(
            params: UserDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<String>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments("v1", "users", params.getPathParam(0))
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable { response.use { deleteHandler.handle(it) } }
                }
        }

        private val getHandler: Handler<User> =
            jsonHandler<User>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun get(
            params: UserGetParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<User>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "users", params.getPathParam(0))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { getHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val getChannelDataHandler: Handler<ChannelData> =
            jsonHandler<ChannelData>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun getChannelData(
            params: UserGetChannelDataParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ChannelData>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments(
                        "v1",
                        "users",
                        params.getPathParam(0),
                        "channel_data",
                        params.getPathParam(1),
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { getChannelDataHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val getPreferencesHandler: Handler<PreferenceSet> =
            jsonHandler<PreferenceSet>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun getPreferences(
            params: UserGetPreferencesParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PreferenceSet>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments(
                        "v1",
                        "users",
                        params.getPathParam(0),
                        "preferences",
                        params.getPathParam(1),
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { getPreferencesHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val listMessagesHandler: Handler<UserListMessagesPageAsync.Response> =
            jsonHandler<UserListMessagesPageAsync.Response>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun listMessages(
            params: UserListMessagesParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UserListMessagesPageAsync>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "users", params.getPathParam(0), "messages")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { listMessagesHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                            .let {
                                UserListMessagesPageAsync.of(
                                    UserServiceAsyncImpl(clientOptions),
                                    params,
                                    it,
                                )
                            }
                    }
                }
        }

        private val listPreferencesHandler: Handler<List<PreferenceSet>> =
            jsonHandler<List<PreferenceSet>>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun listPreferences(
            params: UserListPreferencesParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<PreferenceSet>>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "users", params.getPathParam(0), "preferences")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { listPreferencesHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.forEach { it.validate() }
                                }
                            }
                    }
                }
        }

        private val listSchedulesHandler: Handler<UserListSchedulesPageAsync.Response> =
            jsonHandler<UserListSchedulesPageAsync.Response>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun listSchedules(
            params: UserListSchedulesParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UserListSchedulesPageAsync>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "users", params.getPathParam(0), "schedules")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { listSchedulesHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                            .let {
                                UserListSchedulesPageAsync.of(
                                    UserServiceAsyncImpl(clientOptions),
                                    params,
                                    it,
                                )
                            }
                    }
                }
        }

        private val listSubscriptionsHandler: Handler<UserListSubscriptionsPageAsync.Response> =
            jsonHandler<UserListSubscriptionsPageAsync.Response>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun listSubscriptions(
            params: UserListSubscriptionsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UserListSubscriptionsPageAsync>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "users", params.getPathParam(0), "subscriptions")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { listSubscriptionsHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                            .let {
                                UserListSubscriptionsPageAsync.of(
                                    UserServiceAsyncImpl(clientOptions),
                                    params,
                                    it,
                                )
                            }
                    }
                }
        }

        private val mergeHandler: Handler<User> =
            jsonHandler<User>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun merge(
            params: UserMergeParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<User>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "users", params.getPathParam(0), "merge")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { mergeHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val setChannelDataHandler: Handler<ChannelData> =
            jsonHandler<ChannelData>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun setChannelData(
            params: UserSetChannelDataParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ChannelData>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .addPathSegments(
                        "v1",
                        "users",
                        params.getPathParam(0),
                        "channel_data",
                        params.getPathParam(1),
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
                            .use { setChannelDataHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val setPreferencesHandler: Handler<PreferenceSet> =
            jsonHandler<PreferenceSet>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun setPreferences(
            params: UserSetPreferencesParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PreferenceSet>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .addPathSegments(
                        "v1",
                        "users",
                        params.getPathParam(0),
                        "preferences",
                        params.getPathParam(1),
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
                            .use { setPreferencesHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val unsetChannelDataHandler: Handler<String> =
            stringHandler().withErrorHandler(errorHandler)

        override fun unsetChannelData(
            params: UserUnsetChannelDataParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<String>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments(
                        "v1",
                        "users",
                        params.getPathParam(0),
                        "channel_data",
                        params.getPathParam(1),
                    )
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable { response.use { unsetChannelDataHandler.handle(it) } }
                }
        }
    }
}
