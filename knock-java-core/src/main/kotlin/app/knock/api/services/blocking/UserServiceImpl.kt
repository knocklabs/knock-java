// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking

import app.knock.api.core.ClientOptions
import app.knock.api.core.JsonValue
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
import app.knock.api.models.recipients.channeldata.ChannelData
import app.knock.api.models.recipients.preferences.PreferenceSet
import app.knock.api.models.users.User
import app.knock.api.models.users.UserDeleteParams
import app.knock.api.models.users.UserGetChannelDataParams
import app.knock.api.models.users.UserGetParams
import app.knock.api.models.users.UserListMessagesPage
import app.knock.api.models.users.UserListMessagesPageResponse
import app.knock.api.models.users.UserListMessagesParams
import app.knock.api.models.users.UserListPage
import app.knock.api.models.users.UserListPageResponse
import app.knock.api.models.users.UserListParams
import app.knock.api.models.users.UserListPreferencesParams
import app.knock.api.models.users.UserListSchedulesPage
import app.knock.api.models.users.UserListSchedulesPageResponse
import app.knock.api.models.users.UserListSchedulesParams
import app.knock.api.models.users.UserListSubscriptionsPage
import app.knock.api.models.users.UserListSubscriptionsPageResponse
import app.knock.api.models.users.UserListSubscriptionsParams
import app.knock.api.models.users.UserMergeParams
import app.knock.api.models.users.UserSetChannelDataParams
import app.knock.api.models.users.UserUnsetChannelDataParams
import app.knock.api.models.users.UserUpdateParams
import app.knock.api.services.blocking.users.BulkService
import app.knock.api.services.blocking.users.BulkServiceImpl
import app.knock.api.services.blocking.users.FeedService
import app.knock.api.services.blocking.users.FeedServiceImpl

class UserServiceImpl internal constructor(private val clientOptions: ClientOptions) : UserService {

    private val withRawResponse: UserService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val feeds: FeedService by lazy { FeedServiceImpl(clientOptions) }

    private val bulk: BulkService by lazy { BulkServiceImpl(clientOptions) }

    override fun withRawResponse(): UserService.WithRawResponse = withRawResponse

    override fun feeds(): FeedService = feeds

    override fun bulk(): BulkService = bulk

    override fun update(params: UserUpdateParams, requestOptions: RequestOptions): User =
        // put /v1/users/{user_id}
        withRawResponse().update(params, requestOptions).parse()

    override fun list(params: UserListParams, requestOptions: RequestOptions): UserListPage =
        // get /v1/users
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(params: UserDeleteParams, requestOptions: RequestOptions): String =
        // delete /v1/users/{user_id}
        withRawResponse().delete(params, requestOptions).parse()

    override fun get(params: UserGetParams, requestOptions: RequestOptions): User =
        // get /v1/users/{user_id}
        withRawResponse().get(params, requestOptions).parse()

    override fun getChannelData(
        params: UserGetChannelDataParams,
        requestOptions: RequestOptions,
    ): ChannelData =
        // get /v1/users/{user_id}/channel_data/{channel_id}
        withRawResponse().getChannelData(params, requestOptions).parse()

    override fun listMessages(
        params: UserListMessagesParams,
        requestOptions: RequestOptions,
    ): UserListMessagesPage =
        // get /v1/users/{user_id}/messages
        withRawResponse().listMessages(params, requestOptions).parse()

    override fun listPreferences(
        params: UserListPreferencesParams,
        requestOptions: RequestOptions,
    ): List<PreferenceSet> =
        // get /v1/users/{user_id}/preferences
        withRawResponse().listPreferences(params, requestOptions).parse()

    override fun listSchedules(
        params: UserListSchedulesParams,
        requestOptions: RequestOptions,
    ): UserListSchedulesPage =
        // get /v1/users/{user_id}/schedules
        withRawResponse().listSchedules(params, requestOptions).parse()

    override fun listSubscriptions(
        params: UserListSubscriptionsParams,
        requestOptions: RequestOptions,
    ): UserListSubscriptionsPage =
        // get /v1/users/{user_id}/subscriptions
        withRawResponse().listSubscriptions(params, requestOptions).parse()

    override fun merge(params: UserMergeParams, requestOptions: RequestOptions): User =
        // post /v1/users/{user_id}/merge
        withRawResponse().merge(params, requestOptions).parse()

    override fun setChannelData(
        params: UserSetChannelDataParams,
        requestOptions: RequestOptions,
    ): ChannelData =
        // put /v1/users/{user_id}/channel_data/{channel_id}
        withRawResponse().setChannelData(params, requestOptions).parse()

    override fun unsetChannelData(
        params: UserUnsetChannelDataParams,
        requestOptions: RequestOptions,
    ): String =
        // delete /v1/users/{user_id}/channel_data/{channel_id}
        withRawResponse().unsetChannelData(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        UserService.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val feeds: FeedService.WithRawResponse by lazy {
            FeedServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val bulk: BulkService.WithRawResponse by lazy {
            BulkServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun feeds(): FeedService.WithRawResponse = feeds

        override fun bulk(): BulkService.WithRawResponse = bulk

        private val updateHandler: Handler<User> =
            jsonHandler<User>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun update(
            params: UserUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<User> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .addPathSegments("v1", "users", params._pathParam(0))
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { updateHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listHandler: Handler<UserListPageResponse> =
            jsonHandler<UserListPageResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun list(
            params: UserListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<UserListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "users")
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
                        UserListPage.builder()
                            .service(UserServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<String> = stringHandler().withErrorHandler(errorHandler)

        override fun delete(
            params: UserDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<String> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments("v1", "users", params._pathParam(0))
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable { response.use { deleteHandler.handle(it) } }
        }

        private val getHandler: Handler<User> =
            jsonHandler<User>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun get(
            params: UserGetParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<User> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "users", params._pathParam(0))
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

        private val getChannelDataHandler: Handler<ChannelData> =
            jsonHandler<ChannelData>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun getChannelData(
            params: UserGetChannelDataParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ChannelData> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments(
                        "v1",
                        "users",
                        params._pathParam(0),
                        "channel_data",
                        params._pathParam(1),
                    )
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { getChannelDataHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listMessagesHandler: Handler<UserListMessagesPageResponse> =
            jsonHandler<UserListMessagesPageResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun listMessages(
            params: UserListMessagesParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<UserListMessagesPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "users", params._pathParam(0), "messages")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { listMessagesHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        UserListMessagesPage.builder()
                            .service(UserServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val listPreferencesHandler: Handler<List<PreferenceSet>> =
            jsonHandler<List<PreferenceSet>>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun listPreferences(
            params: UserListPreferencesParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<PreferenceSet>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "users", params._pathParam(0), "preferences")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { listPreferencesHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.forEach { it.validate() }
                        }
                    }
            }
        }

        private val listSchedulesHandler: Handler<UserListSchedulesPageResponse> =
            jsonHandler<UserListSchedulesPageResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun listSchedules(
            params: UserListSchedulesParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<UserListSchedulesPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "users", params._pathParam(0), "schedules")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { listSchedulesHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        UserListSchedulesPage.builder()
                            .service(UserServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val listSubscriptionsHandler: Handler<UserListSubscriptionsPageResponse> =
            jsonHandler<UserListSubscriptionsPageResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun listSubscriptions(
            params: UserListSubscriptionsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<UserListSubscriptionsPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "users", params._pathParam(0), "subscriptions")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { listSubscriptionsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        UserListSubscriptionsPage.builder()
                            .service(UserServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val mergeHandler: Handler<User> =
            jsonHandler<User>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun merge(
            params: UserMergeParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<User> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "users", params._pathParam(0), "merge")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { mergeHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val setChannelDataHandler: Handler<ChannelData> =
            jsonHandler<ChannelData>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun setChannelData(
            params: UserSetChannelDataParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ChannelData> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .addPathSegments(
                        "v1",
                        "users",
                        params._pathParam(0),
                        "channel_data",
                        params._pathParam(1),
                    )
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { setChannelDataHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val unsetChannelDataHandler: Handler<String> =
            stringHandler().withErrorHandler(errorHandler)

        override fun unsetChannelData(
            params: UserUnsetChannelDataParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<String> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments(
                        "v1",
                        "users",
                        params._pathParam(0),
                        "channel_data",
                        params._pathParam(1),
                    )
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable { response.use { unsetChannelDataHandler.handle(it) } }
        }
    }
}
