// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.recipients.channeldata.ChannelData
import app.knock.api.models.recipients.preferences.PreferenceSet
import app.knock.api.models.users.User
import app.knock.api.models.users.UserDeleteParams
import app.knock.api.models.users.UserGetChannelDataParams
import app.knock.api.models.users.UserGetParams
import app.knock.api.models.users.UserGetPreferencesParams
import app.knock.api.models.users.UserListMessagesPageAsync
import app.knock.api.models.users.UserListMessagesParams
import app.knock.api.models.users.UserListPageAsync
import app.knock.api.models.users.UserListParams
import app.knock.api.models.users.UserListPreferencesParams
import app.knock.api.models.users.UserListSchedulesPageAsync
import app.knock.api.models.users.UserListSchedulesParams
import app.knock.api.models.users.UserListSubscriptionsPageAsync
import app.knock.api.models.users.UserListSubscriptionsParams
import app.knock.api.models.users.UserMergeParams
import app.knock.api.models.users.UserSetChannelDataParams
import app.knock.api.models.users.UserSetPreferencesParams
import app.knock.api.models.users.UserUnsetChannelDataParams
import app.knock.api.models.users.UserUpdateParams
import app.knock.api.services.async.users.BulkServiceAsync
import app.knock.api.services.async.users.FeedServiceAsync
import app.knock.api.services.async.users.GuideServiceAsync
import java.util.concurrent.CompletableFuture

interface UserServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun feeds(): FeedServiceAsync

    fun guides(): GuideServiceAsync

    fun bulk(): BulkServiceAsync

    /**
     * Create or update a user with the provided identification data. When you identify an existing
     * user, the system merges the properties you specific with what is currently set on the user,
     * updating only the fields included in your requests.
     */
    fun update(userId: String, params: UserUpdateParams): CompletableFuture<User> =
        update(userId, params, RequestOptions.none())

    /** @see [update] */
    fun update(
        userId: String,
        params: UserUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<User> = update(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see [update] */
    fun update(params: UserUpdateParams): CompletableFuture<User> =
        update(params, RequestOptions.none())

    /** @see [update] */
    fun update(
        params: UserUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<User>

    /** Retrieve a paginated list of users in the environment. Defaults to 50 users per page. */
    fun list(): CompletableFuture<UserListPageAsync> = list(UserListParams.none())

    /** @see [list] */
    fun list(
        params: UserListParams = UserListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserListPageAsync>

    /** @see [list] */
    fun list(params: UserListParams = UserListParams.none()): CompletableFuture<UserListPageAsync> =
        list(params, RequestOptions.none())

    /** @see [list] */
    fun list(requestOptions: RequestOptions): CompletableFuture<UserListPageAsync> =
        list(UserListParams.none(), requestOptions)

    /** Permanently delete a user and all associated data. */
    fun delete(userId: String): CompletableFuture<String> = delete(userId, UserDeleteParams.none())

    /** @see [delete] */
    fun delete(
        userId: String,
        params: UserDeleteParams = UserDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<String> = delete(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see [delete] */
    fun delete(
        userId: String,
        params: UserDeleteParams = UserDeleteParams.none(),
    ): CompletableFuture<String> = delete(userId, params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: UserDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<String>

    /** @see [delete] */
    fun delete(params: UserDeleteParams): CompletableFuture<String> =
        delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(userId: String, requestOptions: RequestOptions): CompletableFuture<String> =
        delete(userId, UserDeleteParams.none(), requestOptions)

    /** Retrieve a specific user by their ID. */
    fun get(userId: String): CompletableFuture<User> = get(userId, UserGetParams.none())

    /** @see [get] */
    fun get(
        userId: String,
        params: UserGetParams = UserGetParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<User> = get(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see [get] */
    fun get(userId: String, params: UserGetParams = UserGetParams.none()): CompletableFuture<User> =
        get(userId, params, RequestOptions.none())

    /** @see [get] */
    fun get(
        params: UserGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<User>

    /** @see [get] */
    fun get(params: UserGetParams): CompletableFuture<User> = get(params, RequestOptions.none())

    /** @see [get] */
    fun get(userId: String, requestOptions: RequestOptions): CompletableFuture<User> =
        get(userId, UserGetParams.none(), requestOptions)

    /** Retrieves the channel data for a specific user and channel ID. */
    fun getChannelData(userId: String, channelId: String): CompletableFuture<ChannelData> =
        getChannelData(userId, channelId, UserGetChannelDataParams.none())

    /** @see [getChannelData] */
    fun getChannelData(
        userId: String,
        channelId: String,
        params: UserGetChannelDataParams = UserGetChannelDataParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ChannelData> =
        getChannelData(
            params.toBuilder().userId(userId).channelId(channelId).build(),
            requestOptions,
        )

    /** @see [getChannelData] */
    fun getChannelData(
        userId: String,
        channelId: String,
        params: UserGetChannelDataParams = UserGetChannelDataParams.none(),
    ): CompletableFuture<ChannelData> =
        getChannelData(userId, channelId, params, RequestOptions.none())

    /** @see [getChannelData] */
    fun getChannelData(
        params: UserGetChannelDataParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ChannelData>

    /** @see [getChannelData] */
    fun getChannelData(params: UserGetChannelDataParams): CompletableFuture<ChannelData> =
        getChannelData(params, RequestOptions.none())

    /** @see [getChannelData] */
    fun getChannelData(
        userId: String,
        channelId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ChannelData> =
        getChannelData(userId, channelId, UserGetChannelDataParams.none(), requestOptions)

    /** Retrieves a specific preference set for a user identified by the preference set ID. */
    fun getPreferences(userId: String, id: String): CompletableFuture<PreferenceSet> =
        getPreferences(userId, id, UserGetPreferencesParams.none())

    /** @see [getPreferences] */
    fun getPreferences(
        userId: String,
        id: String,
        params: UserGetPreferencesParams = UserGetPreferencesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PreferenceSet> =
        getPreferences(params.toBuilder().userId(userId).id(id).build(), requestOptions)

    /** @see [getPreferences] */
    fun getPreferences(
        userId: String,
        id: String,
        params: UserGetPreferencesParams = UserGetPreferencesParams.none(),
    ): CompletableFuture<PreferenceSet> = getPreferences(userId, id, params, RequestOptions.none())

    /** @see [getPreferences] */
    fun getPreferences(
        params: UserGetPreferencesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PreferenceSet>

    /** @see [getPreferences] */
    fun getPreferences(params: UserGetPreferencesParams): CompletableFuture<PreferenceSet> =
        getPreferences(params, RequestOptions.none())

    /** @see [getPreferences] */
    fun getPreferences(
        userId: String,
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<PreferenceSet> =
        getPreferences(userId, id, UserGetPreferencesParams.none(), requestOptions)

    /**
     * Returns a paginated list of messages for a specific user. Allows filtering by message status
     * and provides various sorting options. Messages outside the account's retention window will
     * not be included in the results.
     */
    fun listMessages(userId: String): CompletableFuture<UserListMessagesPageAsync> =
        listMessages(userId, UserListMessagesParams.none())

    /** @see [listMessages] */
    fun listMessages(
        userId: String,
        params: UserListMessagesParams = UserListMessagesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserListMessagesPageAsync> =
        listMessages(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see [listMessages] */
    fun listMessages(
        userId: String,
        params: UserListMessagesParams = UserListMessagesParams.none(),
    ): CompletableFuture<UserListMessagesPageAsync> =
        listMessages(userId, params, RequestOptions.none())

    /** @see [listMessages] */
    fun listMessages(
        params: UserListMessagesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserListMessagesPageAsync>

    /** @see [listMessages] */
    fun listMessages(params: UserListMessagesParams): CompletableFuture<UserListMessagesPageAsync> =
        listMessages(params, RequestOptions.none())

    /** @see [listMessages] */
    fun listMessages(
        userId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<UserListMessagesPageAsync> =
        listMessages(userId, UserListMessagesParams.none(), requestOptions)

    /** Retrieves a list of all preference sets for a specific user. */
    fun listPreferences(userId: String): CompletableFuture<List<PreferenceSet>> =
        listPreferences(userId, UserListPreferencesParams.none())

    /** @see [listPreferences] */
    fun listPreferences(
        userId: String,
        params: UserListPreferencesParams = UserListPreferencesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<PreferenceSet>> =
        listPreferences(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see [listPreferences] */
    fun listPreferences(
        userId: String,
        params: UserListPreferencesParams = UserListPreferencesParams.none(),
    ): CompletableFuture<List<PreferenceSet>> =
        listPreferences(userId, params, RequestOptions.none())

    /** @see [listPreferences] */
    fun listPreferences(
        params: UserListPreferencesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<PreferenceSet>>

    /** @see [listPreferences] */
    fun listPreferences(params: UserListPreferencesParams): CompletableFuture<List<PreferenceSet>> =
        listPreferences(params, RequestOptions.none())

    /** @see [listPreferences] */
    fun listPreferences(
        userId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<PreferenceSet>> =
        listPreferences(userId, UserListPreferencesParams.none(), requestOptions)

    /** Returns a paginated list of schedules for a specific user, in descending order. */
    fun listSchedules(userId: String): CompletableFuture<UserListSchedulesPageAsync> =
        listSchedules(userId, UserListSchedulesParams.none())

    /** @see [listSchedules] */
    fun listSchedules(
        userId: String,
        params: UserListSchedulesParams = UserListSchedulesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserListSchedulesPageAsync> =
        listSchedules(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see [listSchedules] */
    fun listSchedules(
        userId: String,
        params: UserListSchedulesParams = UserListSchedulesParams.none(),
    ): CompletableFuture<UserListSchedulesPageAsync> =
        listSchedules(userId, params, RequestOptions.none())

    /** @see [listSchedules] */
    fun listSchedules(
        params: UserListSchedulesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserListSchedulesPageAsync>

    /** @see [listSchedules] */
    fun listSchedules(
        params: UserListSchedulesParams
    ): CompletableFuture<UserListSchedulesPageAsync> = listSchedules(params, RequestOptions.none())

    /** @see [listSchedules] */
    fun listSchedules(
        userId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<UserListSchedulesPageAsync> =
        listSchedules(userId, UserListSchedulesParams.none(), requestOptions)

    /** Retrieves a paginated list of subscriptions for a specific user, in descending order. */
    fun listSubscriptions(userId: String): CompletableFuture<UserListSubscriptionsPageAsync> =
        listSubscriptions(userId, UserListSubscriptionsParams.none())

    /** @see [listSubscriptions] */
    fun listSubscriptions(
        userId: String,
        params: UserListSubscriptionsParams = UserListSubscriptionsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserListSubscriptionsPageAsync> =
        listSubscriptions(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see [listSubscriptions] */
    fun listSubscriptions(
        userId: String,
        params: UserListSubscriptionsParams = UserListSubscriptionsParams.none(),
    ): CompletableFuture<UserListSubscriptionsPageAsync> =
        listSubscriptions(userId, params, RequestOptions.none())

    /** @see [listSubscriptions] */
    fun listSubscriptions(
        params: UserListSubscriptionsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserListSubscriptionsPageAsync>

    /** @see [listSubscriptions] */
    fun listSubscriptions(
        params: UserListSubscriptionsParams
    ): CompletableFuture<UserListSubscriptionsPageAsync> =
        listSubscriptions(params, RequestOptions.none())

    /** @see [listSubscriptions] */
    fun listSubscriptions(
        userId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<UserListSubscriptionsPageAsync> =
        listSubscriptions(userId, UserListSubscriptionsParams.none(), requestOptions)

    /**
     * Merge two users together, where the user specified with the `from_user_id` param will be
     * merged into the user specified by `user_id`.
     */
    fun merge(userId: String, params: UserMergeParams): CompletableFuture<User> =
        merge(userId, params, RequestOptions.none())

    /** @see [merge] */
    fun merge(
        userId: String,
        params: UserMergeParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<User> = merge(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see [merge] */
    fun merge(params: UserMergeParams): CompletableFuture<User> =
        merge(params, RequestOptions.none())

    /** @see [merge] */
    fun merge(
        params: UserMergeParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<User>

    /** Updates or creates channel data for a specific user and channel ID. */
    fun setChannelData(
        userId: String,
        channelId: String,
        params: UserSetChannelDataParams,
    ): CompletableFuture<ChannelData> =
        setChannelData(userId, channelId, params, RequestOptions.none())

    /** @see [setChannelData] */
    fun setChannelData(
        userId: String,
        channelId: String,
        params: UserSetChannelDataParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ChannelData> =
        setChannelData(
            params.toBuilder().userId(userId).channelId(channelId).build(),
            requestOptions,
        )

    /** @see [setChannelData] */
    fun setChannelData(params: UserSetChannelDataParams): CompletableFuture<ChannelData> =
        setChannelData(params, RequestOptions.none())

    /** @see [setChannelData] */
    fun setChannelData(
        params: UserSetChannelDataParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ChannelData>

    /**
     * Updates a complete preference set for a user. This is a destructive operation that will
     * replace the existing preference set for the user.
     */
    fun setPreferences(
        userId: String,
        id: String,
        params: UserSetPreferencesParams,
    ): CompletableFuture<PreferenceSet> = setPreferences(userId, id, params, RequestOptions.none())

    /** @see [setPreferences] */
    fun setPreferences(
        userId: String,
        id: String,
        params: UserSetPreferencesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PreferenceSet> =
        setPreferences(params.toBuilder().userId(userId).id(id).build(), requestOptions)

    /** @see [setPreferences] */
    fun setPreferences(params: UserSetPreferencesParams): CompletableFuture<PreferenceSet> =
        setPreferences(params, RequestOptions.none())

    /** @see [setPreferences] */
    fun setPreferences(
        params: UserSetPreferencesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PreferenceSet>

    /** Deletes channel data for a specific user and channel ID. */
    fun unsetChannelData(userId: String, channelId: String): CompletableFuture<String> =
        unsetChannelData(userId, channelId, UserUnsetChannelDataParams.none())

    /** @see [unsetChannelData] */
    fun unsetChannelData(
        userId: String,
        channelId: String,
        params: UserUnsetChannelDataParams = UserUnsetChannelDataParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<String> =
        unsetChannelData(
            params.toBuilder().userId(userId).channelId(channelId).build(),
            requestOptions,
        )

    /** @see [unsetChannelData] */
    fun unsetChannelData(
        userId: String,
        channelId: String,
        params: UserUnsetChannelDataParams = UserUnsetChannelDataParams.none(),
    ): CompletableFuture<String> =
        unsetChannelData(userId, channelId, params, RequestOptions.none())

    /** @see [unsetChannelData] */
    fun unsetChannelData(
        params: UserUnsetChannelDataParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<String>

    /** @see [unsetChannelData] */
    fun unsetChannelData(params: UserUnsetChannelDataParams): CompletableFuture<String> =
        unsetChannelData(params, RequestOptions.none())

    /** @see [unsetChannelData] */
    fun unsetChannelData(
        userId: String,
        channelId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<String> =
        unsetChannelData(userId, channelId, UserUnsetChannelDataParams.none(), requestOptions)

    /** A view of [UserServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun feeds(): FeedServiceAsync.WithRawResponse

        fun guides(): GuideServiceAsync.WithRawResponse

        fun bulk(): BulkServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `put /v1/users/{user_id}`, but is otherwise the same as
         * [UserServiceAsync.update].
         */
        fun update(
            userId: String,
            params: UserUpdateParams,
        ): CompletableFuture<HttpResponseFor<User>> = update(userId, params, RequestOptions.none())

        /** @see [update] */
        fun update(
            userId: String,
            params: UserUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<User>> =
            update(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see [update] */
        fun update(params: UserUpdateParams): CompletableFuture<HttpResponseFor<User>> =
            update(params, RequestOptions.none())

        /** @see [update] */
        fun update(
            params: UserUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<User>>

        /**
         * Returns a raw HTTP response for `get /v1/users`, but is otherwise the same as
         * [UserServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<UserListPageAsync>> =
            list(UserListParams.none())

        /** @see [list] */
        fun list(
            params: UserListParams = UserListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserListPageAsync>>

        /** @see [list] */
        fun list(
            params: UserListParams = UserListParams.none()
        ): CompletableFuture<HttpResponseFor<UserListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<UserListPageAsync>> =
            list(UserListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/users/{user_id}`, but is otherwise the same
         * as [UserServiceAsync.delete].
         */
        fun delete(userId: String): CompletableFuture<HttpResponseFor<String>> =
            delete(userId, UserDeleteParams.none())

        /** @see [delete] */
        fun delete(
            userId: String,
            params: UserDeleteParams = UserDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<String>> =
            delete(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see [delete] */
        fun delete(
            userId: String,
            params: UserDeleteParams = UserDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<String>> =
            delete(userId, params, RequestOptions.none())

        /** @see [delete] */
        fun delete(
            params: UserDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<String>>

        /** @see [delete] */
        fun delete(params: UserDeleteParams): CompletableFuture<HttpResponseFor<String>> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        fun delete(
            userId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<String>> =
            delete(userId, UserDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/users/{user_id}`, but is otherwise the same as
         * [UserServiceAsync.get].
         */
        fun get(userId: String): CompletableFuture<HttpResponseFor<User>> =
            get(userId, UserGetParams.none())

        /** @see [get] */
        fun get(
            userId: String,
            params: UserGetParams = UserGetParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<User>> =
            get(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see [get] */
        fun get(
            userId: String,
            params: UserGetParams = UserGetParams.none(),
        ): CompletableFuture<HttpResponseFor<User>> = get(userId, params, RequestOptions.none())

        /** @see [get] */
        fun get(
            params: UserGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<User>>

        /** @see [get] */
        fun get(params: UserGetParams): CompletableFuture<HttpResponseFor<User>> =
            get(params, RequestOptions.none())

        /** @see [get] */
        fun get(
            userId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<User>> =
            get(userId, UserGetParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/users/{user_id}/channel_data/{channel_id}`, but
         * is otherwise the same as [UserServiceAsync.getChannelData].
         */
        fun getChannelData(
            userId: String,
            channelId: String,
        ): CompletableFuture<HttpResponseFor<ChannelData>> =
            getChannelData(userId, channelId, UserGetChannelDataParams.none())

        /** @see [getChannelData] */
        fun getChannelData(
            userId: String,
            channelId: String,
            params: UserGetChannelDataParams = UserGetChannelDataParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ChannelData>> =
            getChannelData(
                params.toBuilder().userId(userId).channelId(channelId).build(),
                requestOptions,
            )

        /** @see [getChannelData] */
        fun getChannelData(
            userId: String,
            channelId: String,
            params: UserGetChannelDataParams = UserGetChannelDataParams.none(),
        ): CompletableFuture<HttpResponseFor<ChannelData>> =
            getChannelData(userId, channelId, params, RequestOptions.none())

        /** @see [getChannelData] */
        fun getChannelData(
            params: UserGetChannelDataParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ChannelData>>

        /** @see [getChannelData] */
        fun getChannelData(
            params: UserGetChannelDataParams
        ): CompletableFuture<HttpResponseFor<ChannelData>> =
            getChannelData(params, RequestOptions.none())

        /** @see [getChannelData] */
        fun getChannelData(
            userId: String,
            channelId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ChannelData>> =
            getChannelData(userId, channelId, UserGetChannelDataParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/users/{user_id}/preferences/{id}`, but is
         * otherwise the same as [UserServiceAsync.getPreferences].
         */
        fun getPreferences(
            userId: String,
            id: String,
        ): CompletableFuture<HttpResponseFor<PreferenceSet>> =
            getPreferences(userId, id, UserGetPreferencesParams.none())

        /** @see [getPreferences] */
        fun getPreferences(
            userId: String,
            id: String,
            params: UserGetPreferencesParams = UserGetPreferencesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PreferenceSet>> =
            getPreferences(params.toBuilder().userId(userId).id(id).build(), requestOptions)

        /** @see [getPreferences] */
        fun getPreferences(
            userId: String,
            id: String,
            params: UserGetPreferencesParams = UserGetPreferencesParams.none(),
        ): CompletableFuture<HttpResponseFor<PreferenceSet>> =
            getPreferences(userId, id, params, RequestOptions.none())

        /** @see [getPreferences] */
        fun getPreferences(
            params: UserGetPreferencesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PreferenceSet>>

        /** @see [getPreferences] */
        fun getPreferences(
            params: UserGetPreferencesParams
        ): CompletableFuture<HttpResponseFor<PreferenceSet>> =
            getPreferences(params, RequestOptions.none())

        /** @see [getPreferences] */
        fun getPreferences(
            userId: String,
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PreferenceSet>> =
            getPreferences(userId, id, UserGetPreferencesParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/users/{user_id}/messages`, but is otherwise the
         * same as [UserServiceAsync.listMessages].
         */
        fun listMessages(
            userId: String
        ): CompletableFuture<HttpResponseFor<UserListMessagesPageAsync>> =
            listMessages(userId, UserListMessagesParams.none())

        /** @see [listMessages] */
        fun listMessages(
            userId: String,
            params: UserListMessagesParams = UserListMessagesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserListMessagesPageAsync>> =
            listMessages(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see [listMessages] */
        fun listMessages(
            userId: String,
            params: UserListMessagesParams = UserListMessagesParams.none(),
        ): CompletableFuture<HttpResponseFor<UserListMessagesPageAsync>> =
            listMessages(userId, params, RequestOptions.none())

        /** @see [listMessages] */
        fun listMessages(
            params: UserListMessagesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserListMessagesPageAsync>>

        /** @see [listMessages] */
        fun listMessages(
            params: UserListMessagesParams
        ): CompletableFuture<HttpResponseFor<UserListMessagesPageAsync>> =
            listMessages(params, RequestOptions.none())

        /** @see [listMessages] */
        fun listMessages(
            userId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UserListMessagesPageAsync>> =
            listMessages(userId, UserListMessagesParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/users/{user_id}/preferences`, but is otherwise
         * the same as [UserServiceAsync.listPreferences].
         */
        fun listPreferences(
            userId: String
        ): CompletableFuture<HttpResponseFor<List<PreferenceSet>>> =
            listPreferences(userId, UserListPreferencesParams.none())

        /** @see [listPreferences] */
        fun listPreferences(
            userId: String,
            params: UserListPreferencesParams = UserListPreferencesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<PreferenceSet>>> =
            listPreferences(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see [listPreferences] */
        fun listPreferences(
            userId: String,
            params: UserListPreferencesParams = UserListPreferencesParams.none(),
        ): CompletableFuture<HttpResponseFor<List<PreferenceSet>>> =
            listPreferences(userId, params, RequestOptions.none())

        /** @see [listPreferences] */
        fun listPreferences(
            params: UserListPreferencesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<PreferenceSet>>>

        /** @see [listPreferences] */
        fun listPreferences(
            params: UserListPreferencesParams
        ): CompletableFuture<HttpResponseFor<List<PreferenceSet>>> =
            listPreferences(params, RequestOptions.none())

        /** @see [listPreferences] */
        fun listPreferences(
            userId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<PreferenceSet>>> =
            listPreferences(userId, UserListPreferencesParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/users/{user_id}/schedules`, but is otherwise the
         * same as [UserServiceAsync.listSchedules].
         */
        fun listSchedules(
            userId: String
        ): CompletableFuture<HttpResponseFor<UserListSchedulesPageAsync>> =
            listSchedules(userId, UserListSchedulesParams.none())

        /** @see [listSchedules] */
        fun listSchedules(
            userId: String,
            params: UserListSchedulesParams = UserListSchedulesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserListSchedulesPageAsync>> =
            listSchedules(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see [listSchedules] */
        fun listSchedules(
            userId: String,
            params: UserListSchedulesParams = UserListSchedulesParams.none(),
        ): CompletableFuture<HttpResponseFor<UserListSchedulesPageAsync>> =
            listSchedules(userId, params, RequestOptions.none())

        /** @see [listSchedules] */
        fun listSchedules(
            params: UserListSchedulesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserListSchedulesPageAsync>>

        /** @see [listSchedules] */
        fun listSchedules(
            params: UserListSchedulesParams
        ): CompletableFuture<HttpResponseFor<UserListSchedulesPageAsync>> =
            listSchedules(params, RequestOptions.none())

        /** @see [listSchedules] */
        fun listSchedules(
            userId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UserListSchedulesPageAsync>> =
            listSchedules(userId, UserListSchedulesParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/users/{user_id}/subscriptions`, but is otherwise
         * the same as [UserServiceAsync.listSubscriptions].
         */
        fun listSubscriptions(
            userId: String
        ): CompletableFuture<HttpResponseFor<UserListSubscriptionsPageAsync>> =
            listSubscriptions(userId, UserListSubscriptionsParams.none())

        /** @see [listSubscriptions] */
        fun listSubscriptions(
            userId: String,
            params: UserListSubscriptionsParams = UserListSubscriptionsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserListSubscriptionsPageAsync>> =
            listSubscriptions(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see [listSubscriptions] */
        fun listSubscriptions(
            userId: String,
            params: UserListSubscriptionsParams = UserListSubscriptionsParams.none(),
        ): CompletableFuture<HttpResponseFor<UserListSubscriptionsPageAsync>> =
            listSubscriptions(userId, params, RequestOptions.none())

        /** @see [listSubscriptions] */
        fun listSubscriptions(
            params: UserListSubscriptionsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserListSubscriptionsPageAsync>>

        /** @see [listSubscriptions] */
        fun listSubscriptions(
            params: UserListSubscriptionsParams
        ): CompletableFuture<HttpResponseFor<UserListSubscriptionsPageAsync>> =
            listSubscriptions(params, RequestOptions.none())

        /** @see [listSubscriptions] */
        fun listSubscriptions(
            userId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UserListSubscriptionsPageAsync>> =
            listSubscriptions(userId, UserListSubscriptionsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/users/{user_id}/merge`, but is otherwise the
         * same as [UserServiceAsync.merge].
         */
        fun merge(
            userId: String,
            params: UserMergeParams,
        ): CompletableFuture<HttpResponseFor<User>> = merge(userId, params, RequestOptions.none())

        /** @see [merge] */
        fun merge(
            userId: String,
            params: UserMergeParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<User>> =
            merge(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see [merge] */
        fun merge(params: UserMergeParams): CompletableFuture<HttpResponseFor<User>> =
            merge(params, RequestOptions.none())

        /** @see [merge] */
        fun merge(
            params: UserMergeParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<User>>

        /**
         * Returns a raw HTTP response for `put /v1/users/{user_id}/channel_data/{channel_id}`, but
         * is otherwise the same as [UserServiceAsync.setChannelData].
         */
        fun setChannelData(
            userId: String,
            channelId: String,
            params: UserSetChannelDataParams,
        ): CompletableFuture<HttpResponseFor<ChannelData>> =
            setChannelData(userId, channelId, params, RequestOptions.none())

        /** @see [setChannelData] */
        fun setChannelData(
            userId: String,
            channelId: String,
            params: UserSetChannelDataParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ChannelData>> =
            setChannelData(
                params.toBuilder().userId(userId).channelId(channelId).build(),
                requestOptions,
            )

        /** @see [setChannelData] */
        fun setChannelData(
            params: UserSetChannelDataParams
        ): CompletableFuture<HttpResponseFor<ChannelData>> =
            setChannelData(params, RequestOptions.none())

        /** @see [setChannelData] */
        fun setChannelData(
            params: UserSetChannelDataParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ChannelData>>

        /**
         * Returns a raw HTTP response for `put /v1/users/{user_id}/preferences/{id}`, but is
         * otherwise the same as [UserServiceAsync.setPreferences].
         */
        fun setPreferences(
            userId: String,
            id: String,
            params: UserSetPreferencesParams,
        ): CompletableFuture<HttpResponseFor<PreferenceSet>> =
            setPreferences(userId, id, params, RequestOptions.none())

        /** @see [setPreferences] */
        fun setPreferences(
            userId: String,
            id: String,
            params: UserSetPreferencesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PreferenceSet>> =
            setPreferences(params.toBuilder().userId(userId).id(id).build(), requestOptions)

        /** @see [setPreferences] */
        fun setPreferences(
            params: UserSetPreferencesParams
        ): CompletableFuture<HttpResponseFor<PreferenceSet>> =
            setPreferences(params, RequestOptions.none())

        /** @see [setPreferences] */
        fun setPreferences(
            params: UserSetPreferencesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PreferenceSet>>

        /**
         * Returns a raw HTTP response for `delete /v1/users/{user_id}/channel_data/{channel_id}`,
         * but is otherwise the same as [UserServiceAsync.unsetChannelData].
         */
        fun unsetChannelData(
            userId: String,
            channelId: String,
        ): CompletableFuture<HttpResponseFor<String>> =
            unsetChannelData(userId, channelId, UserUnsetChannelDataParams.none())

        /** @see [unsetChannelData] */
        fun unsetChannelData(
            userId: String,
            channelId: String,
            params: UserUnsetChannelDataParams = UserUnsetChannelDataParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<String>> =
            unsetChannelData(
                params.toBuilder().userId(userId).channelId(channelId).build(),
                requestOptions,
            )

        /** @see [unsetChannelData] */
        fun unsetChannelData(
            userId: String,
            channelId: String,
            params: UserUnsetChannelDataParams = UserUnsetChannelDataParams.none(),
        ): CompletableFuture<HttpResponseFor<String>> =
            unsetChannelData(userId, channelId, params, RequestOptions.none())

        /** @see [unsetChannelData] */
        fun unsetChannelData(
            params: UserUnsetChannelDataParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<String>>

        /** @see [unsetChannelData] */
        fun unsetChannelData(
            params: UserUnsetChannelDataParams
        ): CompletableFuture<HttpResponseFor<String>> =
            unsetChannelData(params, RequestOptions.none())

        /** @see [unsetChannelData] */
        fun unsetChannelData(
            userId: String,
            channelId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<String>> =
            unsetChannelData(userId, channelId, UserUnsetChannelDataParams.none(), requestOptions)
    }
}
