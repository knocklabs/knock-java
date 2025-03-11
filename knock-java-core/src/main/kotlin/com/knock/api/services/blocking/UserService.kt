// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.knock.api.core.RequestOptions
import com.knock.api.core.http.HttpResponseFor
import com.knock.api.models.recipients.ChannelData
import com.knock.api.models.recipients.PreferenceSet
import com.knock.api.models.users.User
import com.knock.api.models.users.UserDeleteParams
import com.knock.api.models.users.UserGetChannelDataParams
import com.knock.api.models.users.UserGetParams
import com.knock.api.models.users.UserGetPreferencesParams
import com.knock.api.models.users.UserListMessagesPage
import com.knock.api.models.users.UserListMessagesParams
import com.knock.api.models.users.UserListPage
import com.knock.api.models.users.UserListParams
import com.knock.api.models.users.UserListPreferencesParams
import com.knock.api.models.users.UserListSchedulesPage
import com.knock.api.models.users.UserListSchedulesParams
import com.knock.api.models.users.UserListSubscriptionsPage
import com.knock.api.models.users.UserListSubscriptionsParams
import com.knock.api.models.users.UserMergeParams
import com.knock.api.models.users.UserSetChannelDataParams
import com.knock.api.models.users.UserSetPreferencesParams
import com.knock.api.models.users.UserUnsetChannelDataParams
import com.knock.api.models.users.UserUpdateParams
import com.knock.api.services.blocking.users.BulkService
import com.knock.api.services.blocking.users.FeedService

interface UserService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for
     * each method.
     */
    fun withRawResponse(): WithRawResponse

    fun feeds(): FeedService

    fun bulk(): BulkService

    /** Identify user */
    fun update(params: UserUpdateParams): User =
        update(
          params, RequestOptions.none()
        )

    /** @see [update] */
    fun update(params: UserUpdateParams, requestOptions: RequestOptions = RequestOptions.none()): User

    /** List users */
    fun list(): UserListPage = list(UserListParams.none())

    /** @see [list] */
    fun list(params: UserListParams = UserListParams.none(), requestOptions: RequestOptions = RequestOptions.none()): UserListPage

    /** @see [list] */
    fun list(params: UserListParams = UserListParams.none()): UserListPage =
        list(
          params, RequestOptions.none()
        )

    /** @see [list] */
    fun list(requestOptions: RequestOptions): UserListPage = list(UserListParams.none(), requestOptions)

    /** Delete user */
    fun delete(params: UserDeleteParams): String =
        delete(
          params, RequestOptions.none()
        )

    /** @see [delete] */
    fun delete(params: UserDeleteParams, requestOptions: RequestOptions = RequestOptions.none()): String

    /** Get user */
    fun get(params: UserGetParams): User =
        get(
          params, RequestOptions.none()
        )

    /** @see [get] */
    fun get(params: UserGetParams, requestOptions: RequestOptions = RequestOptions.none()): User

    /** Get channel data */
    fun getChannelData(params: UserGetChannelDataParams): ChannelData =
        getChannelData(
          params, RequestOptions.none()
        )

    /** @see [getChannelData] */
    fun getChannelData(params: UserGetChannelDataParams, requestOptions: RequestOptions = RequestOptions.none()): ChannelData

    /** Get preference set */
    fun getPreferences(params: UserGetPreferencesParams): PreferenceSet =
        getPreferences(
          params, RequestOptions.none()
        )

    /** @see [getPreferences] */
    fun getPreferences(params: UserGetPreferencesParams, requestOptions: RequestOptions = RequestOptions.none()): PreferenceSet

    /** List messages */
    fun listMessages(params: UserListMessagesParams): UserListMessagesPage =
        listMessages(
          params, RequestOptions.none()
        )

    /** @see [listMessages] */
    fun listMessages(params: UserListMessagesParams, requestOptions: RequestOptions = RequestOptions.none()): UserListMessagesPage

    /** List preference sets */
    fun listPreferences(params: UserListPreferencesParams): List<PreferenceSet> =
        listPreferences(
          params, RequestOptions.none()
        )

    /** @see [listPreferences] */
    fun listPreferences(params: UserListPreferencesParams, requestOptions: RequestOptions = RequestOptions.none()): List<PreferenceSet>

    /** List schedules */
    fun listSchedules(params: UserListSchedulesParams): UserListSchedulesPage =
        listSchedules(
          params, RequestOptions.none()
        )

    /** @see [listSchedules] */
    fun listSchedules(params: UserListSchedulesParams, requestOptions: RequestOptions = RequestOptions.none()): UserListSchedulesPage

    /** List subscriptions */
    fun listSubscriptions(params: UserListSubscriptionsParams): UserListSubscriptionsPage =
        listSubscriptions(
          params, RequestOptions.none()
        )

    /** @see [listSubscriptions] */
    fun listSubscriptions(params: UserListSubscriptionsParams, requestOptions: RequestOptions = RequestOptions.none()): UserListSubscriptionsPage

    /**
     * Merge two users together, where the user specified with the `from_user_id` param
     * will be merged into the user specified by `user_id`.
     */
    fun merge(params: UserMergeParams): User =
        merge(
          params, RequestOptions.none()
        )

    /** @see [merge] */
    fun merge(params: UserMergeParams, requestOptions: RequestOptions = RequestOptions.none()): User

    /** Set channel data */
    fun setChannelData(params: UserSetChannelDataParams): ChannelData =
        setChannelData(
          params, RequestOptions.none()
        )

    /** @see [setChannelData] */
    fun setChannelData(params: UserSetChannelDataParams, requestOptions: RequestOptions = RequestOptions.none()): ChannelData

    /**
     * Updates a complete preference set for a user. This is a destructive operation
     * that will replace the existing preference set for the user.
     */
    fun setPreferences(params: UserSetPreferencesParams): PreferenceSet =
        setPreferences(
          params, RequestOptions.none()
        )

    /** @see [setPreferences] */
    fun setPreferences(params: UserSetPreferencesParams, requestOptions: RequestOptions = RequestOptions.none()): PreferenceSet

    /** Unset channel data */
    fun unsetChannelData(params: UserUnsetChannelDataParams): String =
        unsetChannelData(
          params, RequestOptions.none()
        )

    /** @see [unsetChannelData] */
    fun unsetChannelData(params: UserUnsetChannelDataParams, requestOptions: RequestOptions = RequestOptions.none()): String

    /**
     * A view of [UserService] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        fun feeds(): FeedService.WithRawResponse

        fun bulk(): BulkService.WithRawResponse

        /**
         * Returns a raw HTTP response for `put /v1/users/{user_id}`, but is otherwise the
         * same as [UserService.update].
         */
        @MustBeClosed
        fun update(params: UserUpdateParams): HttpResponseFor<User> =
            update(
              params, RequestOptions.none()
            )

        /** @see [update] */
        @MustBeClosed
        fun update(params: UserUpdateParams, requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<User>

        /**
         * Returns a raw HTTP response for `get /v1/users`, but is otherwise the same as
         * [UserService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<UserListPage> = list(UserListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(params: UserListParams = UserListParams.none(), requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<UserListPage>

        /** @see [list] */
        @MustBeClosed
        fun list(params: UserListParams = UserListParams.none()): HttpResponseFor<UserListPage> =
            list(
              params, RequestOptions.none()
            )

        /** @see [list] */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<UserListPage> = list(UserListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/users/{user_id}`, but is otherwise
         * the same as [UserService.delete].
         */
        @MustBeClosed
        fun delete(params: UserDeleteParams): HttpResponseFor<String> =
            delete(
              params, RequestOptions.none()
            )

        /** @see [delete] */
        @MustBeClosed
        fun delete(params: UserDeleteParams, requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<String>

        /**
         * Returns a raw HTTP response for `get /v1/users/{user_id}`, but is otherwise the
         * same as [UserService.get].
         */
        @MustBeClosed
        fun get(params: UserGetParams): HttpResponseFor<User> =
            get(
              params, RequestOptions.none()
            )

        /** @see [get] */
        @MustBeClosed
        fun get(params: UserGetParams, requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<User>

        /**
         * Returns a raw HTTP response for
         * `get /v1/users/{user_id}/channel_data/{channel_id}`, but is otherwise the same
         * as [UserService.getChannelData].
         */
        @MustBeClosed
        fun getChannelData(params: UserGetChannelDataParams): HttpResponseFor<ChannelData> =
            getChannelData(
              params, RequestOptions.none()
            )

        /** @see [getChannelData] */
        @MustBeClosed
        fun getChannelData(params: UserGetChannelDataParams, requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<ChannelData>

        /**
         * Returns a raw HTTP response for
         * `get /v1/users/{user_id}/preferences/{preference_set_id}`, but is otherwise the
         * same as [UserService.getPreferences].
         */
        @MustBeClosed
        fun getPreferences(params: UserGetPreferencesParams): HttpResponseFor<PreferenceSet> =
            getPreferences(
              params, RequestOptions.none()
            )

        /** @see [getPreferences] */
        @MustBeClosed
        fun getPreferences(params: UserGetPreferencesParams, requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<PreferenceSet>

        /**
         * Returns a raw HTTP response for `get /v1/users/{user_id}/messages`, but is
         * otherwise the same as [UserService.listMessages].
         */
        @MustBeClosed
        fun listMessages(params: UserListMessagesParams): HttpResponseFor<UserListMessagesPage> =
            listMessages(
              params, RequestOptions.none()
            )

        /** @see [listMessages] */
        @MustBeClosed
        fun listMessages(params: UserListMessagesParams, requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<UserListMessagesPage>

        /**
         * Returns a raw HTTP response for `get /v1/users/{user_id}/preferences`, but is
         * otherwise the same as [UserService.listPreferences].
         */
        @MustBeClosed
        fun listPreferences(params: UserListPreferencesParams): HttpResponseFor<List<PreferenceSet>> =
            listPreferences(
              params, RequestOptions.none()
            )

        /** @see [listPreferences] */
        @MustBeClosed
        fun listPreferences(params: UserListPreferencesParams, requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<List<PreferenceSet>>

        /**
         * Returns a raw HTTP response for `get /v1/users/{user_id}/schedules`, but is
         * otherwise the same as [UserService.listSchedules].
         */
        @MustBeClosed
        fun listSchedules(params: UserListSchedulesParams): HttpResponseFor<UserListSchedulesPage> =
            listSchedules(
              params, RequestOptions.none()
            )

        /** @see [listSchedules] */
        @MustBeClosed
        fun listSchedules(params: UserListSchedulesParams, requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<UserListSchedulesPage>

        /**
         * Returns a raw HTTP response for `get /v1/users/{user_id}/subscriptions`, but is
         * otherwise the same as [UserService.listSubscriptions].
         */
        @MustBeClosed
        fun listSubscriptions(params: UserListSubscriptionsParams): HttpResponseFor<UserListSubscriptionsPage> =
            listSubscriptions(
              params, RequestOptions.none()
            )

        /** @see [listSubscriptions] */
        @MustBeClosed
        fun listSubscriptions(params: UserListSubscriptionsParams, requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<UserListSubscriptionsPage>

        /**
         * Returns a raw HTTP response for `post /v1/users/{user_id}/merge`, but is
         * otherwise the same as [UserService.merge].
         */
        @MustBeClosed
        fun merge(params: UserMergeParams): HttpResponseFor<User> =
            merge(
              params, RequestOptions.none()
            )

        /** @see [merge] */
        @MustBeClosed
        fun merge(params: UserMergeParams, requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<User>

        /**
         * Returns a raw HTTP response for
         * `put /v1/users/{user_id}/channel_data/{channel_id}`, but is otherwise the same
         * as [UserService.setChannelData].
         */
        @MustBeClosed
        fun setChannelData(params: UserSetChannelDataParams): HttpResponseFor<ChannelData> =
            setChannelData(
              params, RequestOptions.none()
            )

        /** @see [setChannelData] */
        @MustBeClosed
        fun setChannelData(params: UserSetChannelDataParams, requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<ChannelData>

        /**
         * Returns a raw HTTP response for
         * `put /v1/users/{user_id}/preferences/{preference_set_id}`, but is otherwise the
         * same as [UserService.setPreferences].
         */
        @MustBeClosed
        fun setPreferences(params: UserSetPreferencesParams): HttpResponseFor<PreferenceSet> =
            setPreferences(
              params, RequestOptions.none()
            )

        /** @see [setPreferences] */
        @MustBeClosed
        fun setPreferences(params: UserSetPreferencesParams, requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<PreferenceSet>

        /**
         * Returns a raw HTTP response for
         * `delete /v1/users/{user_id}/channel_data/{channel_id}`, but is otherwise the
         * same as [UserService.unsetChannelData].
         */
        @MustBeClosed
        fun unsetChannelData(params: UserUnsetChannelDataParams): HttpResponseFor<String> =
            unsetChannelData(
              params, RequestOptions.none()
            )

        /** @see [unsetChannelData] */
        @MustBeClosed
        fun unsetChannelData(params: UserUnsetChannelDataParams, requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<String>
    }
}
