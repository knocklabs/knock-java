// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.knock.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.knock.api.core.RequestOptions
import com.knock.api.core.http.HttpResponseFor
import com.knock.api.models.ChannelData
import com.knock.api.models.Object
import com.knock.api.models.ObjectAddSubscriptionsParams
import com.knock.api.models.ObjectDeleteParams
import com.knock.api.models.ObjectDeleteSubscriptionsParams
import com.knock.api.models.ObjectGetChannelDataParams
import com.knock.api.models.ObjectGetParams
import com.knock.api.models.ObjectGetPreferencesParams
import com.knock.api.models.ObjectListMessagesPage
import com.knock.api.models.ObjectListMessagesParams
import com.knock.api.models.ObjectListPage
import com.knock.api.models.ObjectListParams
import com.knock.api.models.ObjectListPreferencesParams
import com.knock.api.models.ObjectListSchedulesPage
import com.knock.api.models.ObjectListSchedulesParams
import com.knock.api.models.ObjectListSubscriptionsPage
import com.knock.api.models.ObjectListSubscriptionsParams
import com.knock.api.models.ObjectSetChannelDataParams
import com.knock.api.models.ObjectSetParams
import com.knock.api.models.ObjectSetPreferencesParams
import com.knock.api.models.ObjectUnsetChannelDataParams
import com.knock.api.models.PreferenceSet
import com.knock.api.models.Subscription
import com.knock.api.services.blocking.objects.BulkService

interface ObjectService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun bulk(): BulkService

    /** List objects in a collection */
    @JvmOverloads
    fun list(
        params: ObjectListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ObjectListPage

    /** Delete an object */
    @JvmOverloads
    fun delete(
        params: ObjectDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): String

    /** Add subscriptions for an object. If a subscription already exists, it will be updated. */
    @JvmOverloads
    fun addSubscriptions(
        params: ObjectAddSubscriptionsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Subscription>

    /** Delete subscriptions */
    @JvmOverloads
    fun deleteSubscriptions(
        params: ObjectDeleteSubscriptionsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Subscription>

    /** Get an object */
    @JvmOverloads
    fun get(params: ObjectGetParams, requestOptions: RequestOptions = RequestOptions.none()): Object

    /** Get channel data */
    @JvmOverloads
    fun getChannelData(
        params: ObjectGetChannelDataParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ChannelData

    /** Get a preference set */
    @JvmOverloads
    fun getPreferences(
        params: ObjectGetPreferencesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PreferenceSet

    /** List messages */
    @JvmOverloads
    fun listMessages(
        params: ObjectListMessagesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ObjectListMessagesPage

    /** List preference sets */
    @JvmOverloads
    fun listPreferences(
        params: ObjectListPreferencesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<PreferenceSet>

    /** List schedules */
    @JvmOverloads
    fun listSchedules(
        params: ObjectListSchedulesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ObjectListSchedulesPage

    /**
     * List subscriptions for an object. Either list all subscriptions that belong to the object, or
     * all subscriptions that this object has. Determined by the `mode` query parameter.
     */
    @JvmOverloads
    fun listSubscriptions(
        params: ObjectListSubscriptionsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ObjectListSubscriptionsPage

    /** Set (identify) an object */
    @JvmOverloads
    fun set(params: ObjectSetParams, requestOptions: RequestOptions = RequestOptions.none()): Object

    /** Set channel data */
    @JvmOverloads
    fun setChannelData(
        params: ObjectSetChannelDataParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ChannelData

    /** Update a preference set */
    @JvmOverloads
    fun setPreferences(
        params: ObjectSetPreferencesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PreferenceSet

    /** Unset channel data */
    @JvmOverloads
    fun unsetChannelData(
        params: ObjectUnsetChannelDataParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): String

    /** A view of [ObjectService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun bulk(): BulkService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/objects/{collection}`, but is otherwise the same
         * as [ObjectService.list].
         */
        @JvmOverloads
        @MustBeClosed
        fun list(
            params: ObjectListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ObjectListPage>

        /**
         * Returns a raw HTTP response for `delete /v1/objects/{collection}/{id}`, but is otherwise
         * the same as [ObjectService.delete].
         */
        @JvmOverloads
        @MustBeClosed
        fun delete(
            params: ObjectDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<String>

        /**
         * Returns a raw HTTP response for `post
         * /v1/objects/{collection}/{object_id}/subscriptions`, but is otherwise the same as
         * [ObjectService.addSubscriptions].
         */
        @JvmOverloads
        @MustBeClosed
        fun addSubscriptions(
            params: ObjectAddSubscriptionsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Subscription>>

        /**
         * Returns a raw HTTP response for `delete
         * /v1/objects/{collection}/{object_id}/subscriptions`, but is otherwise the same as
         * [ObjectService.deleteSubscriptions].
         */
        @JvmOverloads
        @MustBeClosed
        fun deleteSubscriptions(
            params: ObjectDeleteSubscriptionsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Subscription>>

        /**
         * Returns a raw HTTP response for `get /v1/objects/{collection}/{id}`, but is otherwise the
         * same as [ObjectService.get].
         */
        @JvmOverloads
        @MustBeClosed
        fun get(
            params: ObjectGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Object>

        /**
         * Returns a raw HTTP response for `get
         * /v1/objects/{collection}/{object_id}/channel_data/{channel_id}`, but is otherwise the
         * same as [ObjectService.getChannelData].
         */
        @JvmOverloads
        @MustBeClosed
        fun getChannelData(
            params: ObjectGetChannelDataParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ChannelData>

        /**
         * Returns a raw HTTP response for `get
         * /v1/objects/{collection}/{object_id}/preferences/{id}`, but is otherwise the same as
         * [ObjectService.getPreferences].
         */
        @JvmOverloads
        @MustBeClosed
        fun getPreferences(
            params: ObjectGetPreferencesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PreferenceSet>

        /**
         * Returns a raw HTTP response for `get /v1/objects/{collection}/{id}/messages`, but is
         * otherwise the same as [ObjectService.listMessages].
         */
        @JvmOverloads
        @MustBeClosed
        fun listMessages(
            params: ObjectListMessagesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ObjectListMessagesPage>

        /**
         * Returns a raw HTTP response for `get /v1/objects/{collection}/{object_id}/preferences`,
         * but is otherwise the same as [ObjectService.listPreferences].
         */
        @JvmOverloads
        @MustBeClosed
        fun listPreferences(
            params: ObjectListPreferencesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<PreferenceSet>>

        /**
         * Returns a raw HTTP response for `get /v1/objects/{collection}/{id}/schedules`, but is
         * otherwise the same as [ObjectService.listSchedules].
         */
        @JvmOverloads
        @MustBeClosed
        fun listSchedules(
            params: ObjectListSchedulesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ObjectListSchedulesPage>

        /**
         * Returns a raw HTTP response for `get /v1/objects/{collection}/{object_id}/subscriptions`,
         * but is otherwise the same as [ObjectService.listSubscriptions].
         */
        @JvmOverloads
        @MustBeClosed
        fun listSubscriptions(
            params: ObjectListSubscriptionsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ObjectListSubscriptionsPage>

        /**
         * Returns a raw HTTP response for `put /v1/objects/{collection}/{id}`, but is otherwise the
         * same as [ObjectService.set].
         */
        @JvmOverloads
        @MustBeClosed
        fun set(
            params: ObjectSetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Object>

        /**
         * Returns a raw HTTP response for `put
         * /v1/objects/{collection}/{object_id}/channel_data/{channel_id}`, but is otherwise the
         * same as [ObjectService.setChannelData].
         */
        @JvmOverloads
        @MustBeClosed
        fun setChannelData(
            params: ObjectSetChannelDataParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ChannelData>

        /**
         * Returns a raw HTTP response for `put
         * /v1/objects/{collection}/{object_id}/preferences/{id}`, but is otherwise the same as
         * [ObjectService.setPreferences].
         */
        @JvmOverloads
        @MustBeClosed
        fun setPreferences(
            params: ObjectSetPreferencesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PreferenceSet>

        /**
         * Returns a raw HTTP response for `delete
         * /v1/objects/{collection}/{object_id}/channel_data/{channel_id}`, but is otherwise the
         * same as [ObjectService.unsetChannelData].
         */
        @JvmOverloads
        @MustBeClosed
        fun unsetChannelData(
            params: ObjectUnsetChannelDataParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<String>
    }
}
