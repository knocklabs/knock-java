// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.knock.api.services.blocking

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
import com.knock.api.models.UserListMessagesPage
import com.knock.api.models.UserListMessagesParams
import com.knock.api.models.UserListPage
import com.knock.api.models.UserListParams
import com.knock.api.models.UserListPreferencesParams
import com.knock.api.models.UserListSchedulesPage
import com.knock.api.models.UserListSchedulesParams
import com.knock.api.models.UserListSubscriptionsPage
import com.knock.api.models.UserListSubscriptionsParams
import com.knock.api.models.UserMergeParams
import com.knock.api.models.UserSetChannelDataParams
import com.knock.api.models.UserSetPreferencesParams
import com.knock.api.models.UserUnsetChannelDataParams
import com.knock.api.models.UserUpdateParams
import com.knock.api.services.blocking.users.BulkService
import com.knock.api.services.blocking.users.FeedService

interface UserService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun feeds(): FeedService

    fun bulk(): BulkService

    /** Identify user */
    @JvmOverloads
    fun update(
        params: UserUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): User

    /** List users */
    @JvmOverloads
    fun list(
        params: UserListParams = UserListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UserListPage

    /** List users */
    fun list(requestOptions: RequestOptions): UserListPage =
        list(UserListParams.none(), requestOptions)

    /** Delete user */
    @JvmOverloads
    fun delete(
        params: UserDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): String

    /** Get user */
    @JvmOverloads
    fun get(params: UserGetParams, requestOptions: RequestOptions = RequestOptions.none()): User

    /** Get channel data */
    @JvmOverloads
    fun getChannelData(
        params: UserGetChannelDataParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ChannelData

    /** Get preference set */
    @JvmOverloads
    fun getPreferences(
        params: UserGetPreferencesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PreferenceSet

    /** List messages */
    @JvmOverloads
    fun listMessages(
        params: UserListMessagesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UserListMessagesPage

    /** List preference sets */
    @JvmOverloads
    fun listPreferences(
        params: UserListPreferencesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<PreferenceSet>

    /** List schedules */
    @JvmOverloads
    fun listSchedules(
        params: UserListSchedulesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UserListSchedulesPage

    /** List subscriptions */
    @JvmOverloads
    fun listSubscriptions(
        params: UserListSubscriptionsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UserListSubscriptionsPage

    /**
     * Merge two users together, where the user specified with the `from_user_id` param will be
     * merged into the user specified by `user_id`.
     */
    @JvmOverloads
    fun merge(params: UserMergeParams, requestOptions: RequestOptions = RequestOptions.none()): User

    /** Set channel data */
    @JvmOverloads
    fun setChannelData(
        params: UserSetChannelDataParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ChannelData

    /**
     * Updates a complete preference set for a user. This is a destructive operation that will
     * replace the existing preference set for the user.
     */
    @JvmOverloads
    fun setPreferences(
        params: UserSetPreferencesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PreferenceSet

    /** Unset channel data */
    @JvmOverloads
    fun unsetChannelData(
        params: UserUnsetChannelDataParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): String

    /** A view of [UserService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun feeds(): FeedService.WithRawResponse

        fun bulk(): BulkService.WithRawResponse

        /**
         * Returns a raw HTTP response for `put /v1/users/{user_id}`, but is otherwise the same as
         * [UserService.update].
         */
        @JvmOverloads
        @MustBeClosed
        fun update(
            params: UserUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<User>

        /**
         * Returns a raw HTTP response for `get /v1/users`, but is otherwise the same as
         * [UserService.list].
         */
        @JvmOverloads
        @MustBeClosed
        fun list(
            params: UserListParams = UserListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UserListPage>

        /**
         * Returns a raw HTTP response for `get /v1/users`, but is otherwise the same as
         * [UserService.list].
         */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<UserListPage> =
            list(UserListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/users/{user_id}`, but is otherwise the same
         * as [UserService.delete].
         */
        @JvmOverloads
        @MustBeClosed
        fun delete(
            params: UserDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<String>

        /**
         * Returns a raw HTTP response for `get /v1/users/{user_id}`, but is otherwise the same as
         * [UserService.get].
         */
        @JvmOverloads
        @MustBeClosed
        fun get(
            params: UserGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<User>

        /**
         * Returns a raw HTTP response for `get /v1/users/{user_id}/channel_data/{channel_id}`, but
         * is otherwise the same as [UserService.getChannelData].
         */
        @JvmOverloads
        @MustBeClosed
        fun getChannelData(
            params: UserGetChannelDataParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ChannelData>

        /**
         * Returns a raw HTTP response for `get /v1/users/{user_id}/preferences/{id}`, but is
         * otherwise the same as [UserService.getPreferences].
         */
        @JvmOverloads
        @MustBeClosed
        fun getPreferences(
            params: UserGetPreferencesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PreferenceSet>

        /**
         * Returns a raw HTTP response for `get /v1/users/{user_id}/messages`, but is otherwise the
         * same as [UserService.listMessages].
         */
        @JvmOverloads
        @MustBeClosed
        fun listMessages(
            params: UserListMessagesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UserListMessagesPage>

        /**
         * Returns a raw HTTP response for `get /v1/users/{user_id}/preferences`, but is otherwise
         * the same as [UserService.listPreferences].
         */
        @JvmOverloads
        @MustBeClosed
        fun listPreferences(
            params: UserListPreferencesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<PreferenceSet>>

        /**
         * Returns a raw HTTP response for `get /v1/users/{user_id}/schedules`, but is otherwise the
         * same as [UserService.listSchedules].
         */
        @JvmOverloads
        @MustBeClosed
        fun listSchedules(
            params: UserListSchedulesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UserListSchedulesPage>

        /**
         * Returns a raw HTTP response for `get /v1/users/{user_id}/subscriptions`, but is otherwise
         * the same as [UserService.listSubscriptions].
         */
        @JvmOverloads
        @MustBeClosed
        fun listSubscriptions(
            params: UserListSubscriptionsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UserListSubscriptionsPage>

        /**
         * Returns a raw HTTP response for `post /v1/users/{user_id}/merge`, but is otherwise the
         * same as [UserService.merge].
         */
        @JvmOverloads
        @MustBeClosed
        fun merge(
            params: UserMergeParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<User>

        /**
         * Returns a raw HTTP response for `put /v1/users/{user_id}/channel_data/{channel_id}`, but
         * is otherwise the same as [UserService.setChannelData].
         */
        @JvmOverloads
        @MustBeClosed
        fun setChannelData(
            params: UserSetChannelDataParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ChannelData>

        /**
         * Returns a raw HTTP response for `put /v1/users/{user_id}/preferences/{id}`, but is
         * otherwise the same as [UserService.setPreferences].
         */
        @JvmOverloads
        @MustBeClosed
        fun setPreferences(
            params: UserSetPreferencesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PreferenceSet>

        /**
         * Returns a raw HTTP response for `delete /v1/users/{user_id}/channel_data/{channel_id}`,
         * but is otherwise the same as [UserService.unsetChannelData].
         */
        @JvmOverloads
        @MustBeClosed
        fun unsetChannelData(
            params: UserUnsetChannelDataParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<String>
    }
}
