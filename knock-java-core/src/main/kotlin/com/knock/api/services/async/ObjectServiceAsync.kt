// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.knock.api.services.async

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
import com.knock.api.models.ObjectListMessagesPageAsync
import com.knock.api.models.ObjectListMessagesParams
import com.knock.api.models.ObjectListPageAsync
import com.knock.api.models.ObjectListParams
import com.knock.api.models.ObjectListPreferencesParams
import com.knock.api.models.ObjectListSchedulesPageAsync
import com.knock.api.models.ObjectListSchedulesParams
import com.knock.api.models.ObjectListSubscriptionsPageAsync
import com.knock.api.models.ObjectListSubscriptionsParams
import com.knock.api.models.ObjectSetChannelDataParams
import com.knock.api.models.ObjectSetParams
import com.knock.api.models.ObjectSetPreferencesParams
import com.knock.api.models.ObjectUnsetChannelDataParams
import com.knock.api.models.PreferenceSet
import com.knock.api.models.Subscription
import com.knock.api.services.async.objects.BulkServiceAsync
import java.util.concurrent.CompletableFuture

interface ObjectServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun bulk(): BulkServiceAsync

    /** List objects in a collection */
    @JvmOverloads
    fun list(
        params: ObjectListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ObjectListPageAsync>

    /** Delete an object */
    @JvmOverloads
    fun delete(
        params: ObjectDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<String>

    /** Add subscriptions for an object. If a subscription already exists, it will be updated. */
    @JvmOverloads
    fun addSubscriptions(
        params: ObjectAddSubscriptionsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Subscription>>

    /** Delete subscriptions */
    @JvmOverloads
    fun deleteSubscriptions(
        params: ObjectDeleteSubscriptionsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Subscription>>

    /** Get an object */
    @JvmOverloads
    fun get(
        params: ObjectGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Object>

    /** Get channel data */
    @JvmOverloads
    fun getChannelData(
        params: ObjectGetChannelDataParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ChannelData>

    /** Get a preference set */
    @JvmOverloads
    fun getPreferences(
        params: ObjectGetPreferencesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PreferenceSet>

    /** List messages */
    @JvmOverloads
    fun listMessages(
        params: ObjectListMessagesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ObjectListMessagesPageAsync>

    /** List preference sets */
    @JvmOverloads
    fun listPreferences(
        params: ObjectListPreferencesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<PreferenceSet>>

    /** List schedules */
    @JvmOverloads
    fun listSchedules(
        params: ObjectListSchedulesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ObjectListSchedulesPageAsync>

    /**
     * List subscriptions for an object. Either list all subscriptions that belong to the object, or
     * all subscriptions that this object has. Determined by the `mode` query parameter.
     */
    @JvmOverloads
    fun listSubscriptions(
        params: ObjectListSubscriptionsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ObjectListSubscriptionsPageAsync>

    /** Set (identify) an object */
    @JvmOverloads
    fun set(
        params: ObjectSetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Object>

    /** Set channel data */
    @JvmOverloads
    fun setChannelData(
        params: ObjectSetChannelDataParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ChannelData>

    /** Update a preference set */
    @JvmOverloads
    fun setPreferences(
        params: ObjectSetPreferencesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PreferenceSet>

    /** Unset channel data */
    @JvmOverloads
    fun unsetChannelData(
        params: ObjectUnsetChannelDataParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<String>

    /**
     * A view of [ObjectServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        fun bulk(): BulkServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/objects/{collection}`, but is otherwise the same
         * as [ObjectServiceAsync.list].
         */
        @JvmOverloads
        @MustBeClosed
        fun list(
            params: ObjectListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ObjectListPageAsync>>

        /**
         * Returns a raw HTTP response for `delete /v1/objects/{collection}/{id}`, but is otherwise
         * the same as [ObjectServiceAsync.delete].
         */
        @JvmOverloads
        @MustBeClosed
        fun delete(
            params: ObjectDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<String>>

        /**
         * Returns a raw HTTP response for `post
         * /v1/objects/{collection}/{object_id}/subscriptions`, but is otherwise the same as
         * [ObjectServiceAsync.addSubscriptions].
         */
        @JvmOverloads
        @MustBeClosed
        fun addSubscriptions(
            params: ObjectAddSubscriptionsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Subscription>>>

        /**
         * Returns a raw HTTP response for `delete
         * /v1/objects/{collection}/{object_id}/subscriptions`, but is otherwise the same as
         * [ObjectServiceAsync.deleteSubscriptions].
         */
        @JvmOverloads
        @MustBeClosed
        fun deleteSubscriptions(
            params: ObjectDeleteSubscriptionsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Subscription>>>

        /**
         * Returns a raw HTTP response for `get /v1/objects/{collection}/{id}`, but is otherwise the
         * same as [ObjectServiceAsync.get].
         */
        @JvmOverloads
        @MustBeClosed
        fun get(
            params: ObjectGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Object>>

        /**
         * Returns a raw HTTP response for `get
         * /v1/objects/{collection}/{object_id}/channel_data/{channel_id}`, but is otherwise the
         * same as [ObjectServiceAsync.getChannelData].
         */
        @JvmOverloads
        @MustBeClosed
        fun getChannelData(
            params: ObjectGetChannelDataParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ChannelData>>

        /**
         * Returns a raw HTTP response for `get
         * /v1/objects/{collection}/{object_id}/preferences/{id}`, but is otherwise the same as
         * [ObjectServiceAsync.getPreferences].
         */
        @JvmOverloads
        @MustBeClosed
        fun getPreferences(
            params: ObjectGetPreferencesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PreferenceSet>>

        /**
         * Returns a raw HTTP response for `get /v1/objects/{collection}/{id}/messages`, but is
         * otherwise the same as [ObjectServiceAsync.listMessages].
         */
        @JvmOverloads
        @MustBeClosed
        fun listMessages(
            params: ObjectListMessagesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ObjectListMessagesPageAsync>>

        /**
         * Returns a raw HTTP response for `get /v1/objects/{collection}/{object_id}/preferences`,
         * but is otherwise the same as [ObjectServiceAsync.listPreferences].
         */
        @JvmOverloads
        @MustBeClosed
        fun listPreferences(
            params: ObjectListPreferencesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<PreferenceSet>>>

        /**
         * Returns a raw HTTP response for `get /v1/objects/{collection}/{id}/schedules`, but is
         * otherwise the same as [ObjectServiceAsync.listSchedules].
         */
        @JvmOverloads
        @MustBeClosed
        fun listSchedules(
            params: ObjectListSchedulesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ObjectListSchedulesPageAsync>>

        /**
         * Returns a raw HTTP response for `get /v1/objects/{collection}/{object_id}/subscriptions`,
         * but is otherwise the same as [ObjectServiceAsync.listSubscriptions].
         */
        @JvmOverloads
        @MustBeClosed
        fun listSubscriptions(
            params: ObjectListSubscriptionsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ObjectListSubscriptionsPageAsync>>

        /**
         * Returns a raw HTTP response for `put /v1/objects/{collection}/{id}`, but is otherwise the
         * same as [ObjectServiceAsync.set].
         */
        @JvmOverloads
        @MustBeClosed
        fun set(
            params: ObjectSetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Object>>

        /**
         * Returns a raw HTTP response for `put
         * /v1/objects/{collection}/{object_id}/channel_data/{channel_id}`, but is otherwise the
         * same as [ObjectServiceAsync.setChannelData].
         */
        @JvmOverloads
        @MustBeClosed
        fun setChannelData(
            params: ObjectSetChannelDataParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ChannelData>>

        /**
         * Returns a raw HTTP response for `put
         * /v1/objects/{collection}/{object_id}/preferences/{id}`, but is otherwise the same as
         * [ObjectServiceAsync.setPreferences].
         */
        @JvmOverloads
        @MustBeClosed
        fun setPreferences(
            params: ObjectSetPreferencesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PreferenceSet>>

        /**
         * Returns a raw HTTP response for `delete
         * /v1/objects/{collection}/{object_id}/channel_data/{channel_id}`, but is otherwise the
         * same as [ObjectServiceAsync.unsetChannelData].
         */
        @JvmOverloads
        @MustBeClosed
        fun unsetChannelData(
            params: ObjectUnsetChannelDataParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<String>>
    }
}
