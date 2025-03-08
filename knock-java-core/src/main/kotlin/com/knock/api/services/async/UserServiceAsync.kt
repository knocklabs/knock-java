// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.knock.api.core.RequestOptions
import com.knock.api.core.http.HttpResponseFor
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
import com.knock.api.services.async.users.FeedServiceAsync
import java.util.concurrent.CompletableFuture

interface UserServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun feeds(): FeedServiceAsync

    fun bulk(): BulkServiceAsync

    /** Identify user */
    fun update(params: UserUpdateParams): CompletableFuture<User> =
        update(params, RequestOptions.none())

    /** @see [update] */
    fun update(
        params: UserUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<User>

    /** List users */
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

    /** Delete user */
    fun delete(params: UserDeleteParams): CompletableFuture<String> =
        delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: UserDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<String>

    /** Get user */
    fun get(params: UserGetParams): CompletableFuture<User> = get(params, RequestOptions.none())

    /** @see [get] */
    fun get(
        params: UserGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<User>

    /** Get channel data */
    fun getChannelData(params: UserGetChannelDataParams): CompletableFuture<ChannelData> =
        getChannelData(params, RequestOptions.none())

    /** @see [getChannelData] */
    fun getChannelData(
        params: UserGetChannelDataParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ChannelData>

    /** Get preference set */
    fun getPreferences(params: UserGetPreferencesParams): CompletableFuture<PreferenceSet> =
        getPreferences(params, RequestOptions.none())

    /** @see [getPreferences] */
    fun getPreferences(
        params: UserGetPreferencesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PreferenceSet>

    /** List messages */
    fun listMessages(params: UserListMessagesParams): CompletableFuture<UserListMessagesPageAsync> =
        listMessages(params, RequestOptions.none())

    /** @see [listMessages] */
    fun listMessages(
        params: UserListMessagesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserListMessagesPageAsync>

    /** List preference sets */
    fun listPreferences(params: UserListPreferencesParams): CompletableFuture<List<PreferenceSet>> =
        listPreferences(params, RequestOptions.none())

    /** @see [listPreferences] */
    fun listPreferences(
        params: UserListPreferencesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<PreferenceSet>>

    /** List schedules */
    fun listSchedules(
        params: UserListSchedulesParams
    ): CompletableFuture<UserListSchedulesPageAsync> = listSchedules(params, RequestOptions.none())

    /** @see [listSchedules] */
    fun listSchedules(
        params: UserListSchedulesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserListSchedulesPageAsync>

    /** List subscriptions */
    fun listSubscriptions(
        params: UserListSubscriptionsParams
    ): CompletableFuture<UserListSubscriptionsPageAsync> =
        listSubscriptions(params, RequestOptions.none())

    /** @see [listSubscriptions] */
    fun listSubscriptions(
        params: UserListSubscriptionsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserListSubscriptionsPageAsync>

    /**
     * Merge two users together, where the user specified with the `from_user_id` param will be
     * merged into the user specified by `user_id`.
     */
    fun merge(params: UserMergeParams): CompletableFuture<User> =
        merge(params, RequestOptions.none())

    /** @see [merge] */
    fun merge(
        params: UserMergeParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<User>

    /** Set channel data */
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
    fun setPreferences(params: UserSetPreferencesParams): CompletableFuture<PreferenceSet> =
        setPreferences(params, RequestOptions.none())

    /** @see [setPreferences] */
    fun setPreferences(
        params: UserSetPreferencesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PreferenceSet>

    /** Unset channel data */
    fun unsetChannelData(params: UserUnsetChannelDataParams): CompletableFuture<String> =
        unsetChannelData(params, RequestOptions.none())

    /** @see [unsetChannelData] */
    fun unsetChannelData(
        params: UserUnsetChannelDataParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<String>

    /** A view of [UserServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun feeds(): FeedServiceAsync.WithRawResponse

        fun bulk(): BulkServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `put /v1/users/{user_id}`, but is otherwise the same as
         * [UserServiceAsync.update].
         */
        @MustBeClosed
        fun update(params: UserUpdateParams): CompletableFuture<HttpResponseFor<User>> =
            update(params, RequestOptions.none())

        /** @see [update] */
        @MustBeClosed
        fun update(
            params: UserUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<User>>

        /**
         * Returns a raw HTTP response for `get /v1/users`, but is otherwise the same as
         * [UserServiceAsync.list].
         */
        @MustBeClosed
        fun list(): CompletableFuture<HttpResponseFor<UserListPageAsync>> =
            list(UserListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: UserListParams = UserListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserListPageAsync>>

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: UserListParams = UserListParams.none()
        ): CompletableFuture<HttpResponseFor<UserListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<UserListPageAsync>> =
            list(UserListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/users/{user_id}`, but is otherwise the same
         * as [UserServiceAsync.delete].
         */
        @MustBeClosed
        fun delete(params: UserDeleteParams): CompletableFuture<HttpResponseFor<String>> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: UserDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<String>>

        /**
         * Returns a raw HTTP response for `get /v1/users/{user_id}`, but is otherwise the same as
         * [UserServiceAsync.get].
         */
        @MustBeClosed
        fun get(params: UserGetParams): CompletableFuture<HttpResponseFor<User>> =
            get(params, RequestOptions.none())

        /** @see [get] */
        @MustBeClosed
        fun get(
            params: UserGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<User>>

        /**
         * Returns a raw HTTP response for `get /v1/users/{user_id}/channel_data/{channel_id}`, but
         * is otherwise the same as [UserServiceAsync.getChannelData].
         */
        @MustBeClosed
        fun getChannelData(
            params: UserGetChannelDataParams
        ): CompletableFuture<HttpResponseFor<ChannelData>> =
            getChannelData(params, RequestOptions.none())

        /** @see [getChannelData] */
        @MustBeClosed
        fun getChannelData(
            params: UserGetChannelDataParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ChannelData>>

        /**
         * Returns a raw HTTP response for `get /v1/users/{user_id}/preferences/{id}`, but is
         * otherwise the same as [UserServiceAsync.getPreferences].
         */
        @MustBeClosed
        fun getPreferences(
            params: UserGetPreferencesParams
        ): CompletableFuture<HttpResponseFor<PreferenceSet>> =
            getPreferences(params, RequestOptions.none())

        /** @see [getPreferences] */
        @MustBeClosed
        fun getPreferences(
            params: UserGetPreferencesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PreferenceSet>>

        /**
         * Returns a raw HTTP response for `get /v1/users/{user_id}/messages`, but is otherwise the
         * same as [UserServiceAsync.listMessages].
         */
        @MustBeClosed
        fun listMessages(
            params: UserListMessagesParams
        ): CompletableFuture<HttpResponseFor<UserListMessagesPageAsync>> =
            listMessages(params, RequestOptions.none())

        /** @see [listMessages] */
        @MustBeClosed
        fun listMessages(
            params: UserListMessagesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserListMessagesPageAsync>>

        /**
         * Returns a raw HTTP response for `get /v1/users/{user_id}/preferences`, but is otherwise
         * the same as [UserServiceAsync.listPreferences].
         */
        @MustBeClosed
        fun listPreferences(
            params: UserListPreferencesParams
        ): CompletableFuture<HttpResponseFor<List<PreferenceSet>>> =
            listPreferences(params, RequestOptions.none())

        /** @see [listPreferences] */
        @MustBeClosed
        fun listPreferences(
            params: UserListPreferencesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<PreferenceSet>>>

        /**
         * Returns a raw HTTP response for `get /v1/users/{user_id}/schedules`, but is otherwise the
         * same as [UserServiceAsync.listSchedules].
         */
        @MustBeClosed
        fun listSchedules(
            params: UserListSchedulesParams
        ): CompletableFuture<HttpResponseFor<UserListSchedulesPageAsync>> =
            listSchedules(params, RequestOptions.none())

        /** @see [listSchedules] */
        @MustBeClosed
        fun listSchedules(
            params: UserListSchedulesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserListSchedulesPageAsync>>

        /**
         * Returns a raw HTTP response for `get /v1/users/{user_id}/subscriptions`, but is otherwise
         * the same as [UserServiceAsync.listSubscriptions].
         */
        @MustBeClosed
        fun listSubscriptions(
            params: UserListSubscriptionsParams
        ): CompletableFuture<HttpResponseFor<UserListSubscriptionsPageAsync>> =
            listSubscriptions(params, RequestOptions.none())

        /** @see [listSubscriptions] */
        @MustBeClosed
        fun listSubscriptions(
            params: UserListSubscriptionsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserListSubscriptionsPageAsync>>

        /**
         * Returns a raw HTTP response for `post /v1/users/{user_id}/merge`, but is otherwise the
         * same as [UserServiceAsync.merge].
         */
        @MustBeClosed
        fun merge(params: UserMergeParams): CompletableFuture<HttpResponseFor<User>> =
            merge(params, RequestOptions.none())

        /** @see [merge] */
        @MustBeClosed
        fun merge(
            params: UserMergeParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<User>>

        /**
         * Returns a raw HTTP response for `put /v1/users/{user_id}/channel_data/{channel_id}`, but
         * is otherwise the same as [UserServiceAsync.setChannelData].
         */
        @MustBeClosed
        fun setChannelData(
            params: UserSetChannelDataParams
        ): CompletableFuture<HttpResponseFor<ChannelData>> =
            setChannelData(params, RequestOptions.none())

        /** @see [setChannelData] */
        @MustBeClosed
        fun setChannelData(
            params: UserSetChannelDataParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ChannelData>>

        /**
         * Returns a raw HTTP response for `put /v1/users/{user_id}/preferences/{id}`, but is
         * otherwise the same as [UserServiceAsync.setPreferences].
         */
        @MustBeClosed
        fun setPreferences(
            params: UserSetPreferencesParams
        ): CompletableFuture<HttpResponseFor<PreferenceSet>> =
            setPreferences(params, RequestOptions.none())

        /** @see [setPreferences] */
        @MustBeClosed
        fun setPreferences(
            params: UserSetPreferencesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PreferenceSet>>

        /**
         * Returns a raw HTTP response for `delete /v1/users/{user_id}/channel_data/{channel_id}`,
         * but is otherwise the same as [UserServiceAsync.unsetChannelData].
         */
        @MustBeClosed
        fun unsetChannelData(
            params: UserUnsetChannelDataParams
        ): CompletableFuture<HttpResponseFor<String>> =
            unsetChannelData(params, RequestOptions.none())

        /** @see [unsetChannelData] */
        @MustBeClosed
        fun unsetChannelData(
            params: UserUnsetChannelDataParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<String>>
    }
}
