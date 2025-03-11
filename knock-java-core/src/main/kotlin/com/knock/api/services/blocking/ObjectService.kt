// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.knock.api.core.RequestOptions
import com.knock.api.core.http.HttpResponseFor
import com.knock.api.models.objects.Object
import com.knock.api.models.objects.ObjectAddSubscriptionsParams
import com.knock.api.models.objects.ObjectDeleteParams
import com.knock.api.models.objects.ObjectDeleteSubscriptionsParams
import com.knock.api.models.objects.ObjectGetChannelDataParams
import com.knock.api.models.objects.ObjectGetParams
import com.knock.api.models.objects.ObjectGetPreferencesParams
import com.knock.api.models.objects.ObjectListMessagesPage
import com.knock.api.models.objects.ObjectListMessagesParams
import com.knock.api.models.objects.ObjectListPage
import com.knock.api.models.objects.ObjectListParams
import com.knock.api.models.objects.ObjectListSchedulesPage
import com.knock.api.models.objects.ObjectListSchedulesParams
import com.knock.api.models.objects.ObjectListSubscriptionsPage
import com.knock.api.models.objects.ObjectListSubscriptionsParams
import com.knock.api.models.objects.ObjectSetChannelDataParams
import com.knock.api.models.objects.ObjectSetParams
import com.knock.api.models.objects.ObjectSetPreferencesParams
import com.knock.api.models.objects.ObjectUnsetChannelDataParams
import com.knock.api.models.recipients.ChannelData
import com.knock.api.models.recipients.PreferenceSet
import com.knock.api.models.recipients.Subscription
import com.knock.api.services.blocking.objects.BulkService

interface ObjectService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for
     * each method.
     */
    fun withRawResponse(): WithRawResponse

    fun bulk(): BulkService

    /** List objects in a collection */
    fun list(params: ObjectListParams): ObjectListPage =
        list(
          params, RequestOptions.none()
        )

    /** @see [list] */
    fun list(params: ObjectListParams, requestOptions: RequestOptions = RequestOptions.none()): ObjectListPage

    /** Delete an object */
    fun delete(params: ObjectDeleteParams): String =
        delete(
          params, RequestOptions.none()
        )

    /** @see [delete] */
    fun delete(params: ObjectDeleteParams, requestOptions: RequestOptions = RequestOptions.none()): String

    /**
     * Add subscriptions for an object. If a subscription already exists, it will be
     * updated.
     */
    fun addSubscriptions(params: ObjectAddSubscriptionsParams): List<Subscription> =
        addSubscriptions(
          params, RequestOptions.none()
        )

    /** @see [addSubscriptions] */
    fun addSubscriptions(params: ObjectAddSubscriptionsParams, requestOptions: RequestOptions = RequestOptions.none()): List<Subscription>

    /** Delete subscriptions */
    fun deleteSubscriptions(params: ObjectDeleteSubscriptionsParams): List<Subscription> =
        deleteSubscriptions(
          params, RequestOptions.none()
        )

    /** @see [deleteSubscriptions] */
    fun deleteSubscriptions(params: ObjectDeleteSubscriptionsParams, requestOptions: RequestOptions = RequestOptions.none()): List<Subscription>

    /** Get an object */
    fun get(params: ObjectGetParams): Object =
        get(
          params, RequestOptions.none()
        )

    /** @see [get] */
    fun get(params: ObjectGetParams, requestOptions: RequestOptions = RequestOptions.none()): Object

    /** Get channel data */
    fun getChannelData(params: ObjectGetChannelDataParams): ChannelData =
        getChannelData(
          params, RequestOptions.none()
        )

    /** @see [getChannelData] */
    fun getChannelData(params: ObjectGetChannelDataParams, requestOptions: RequestOptions = RequestOptions.none()): ChannelData

    /** Get a preference set */
    fun getPreferences(params: ObjectGetPreferencesParams): PreferenceSet =
        getPreferences(
          params, RequestOptions.none()
        )

    /** @see [getPreferences] */
    fun getPreferences(params: ObjectGetPreferencesParams, requestOptions: RequestOptions = RequestOptions.none()): PreferenceSet

    /** List messages */
    fun listMessages(params: ObjectListMessagesParams): ObjectListMessagesPage =
        listMessages(
          params, RequestOptions.none()
        )

    /** @see [listMessages] */
    fun listMessages(params: ObjectListMessagesParams, requestOptions: RequestOptions = RequestOptions.none()): ObjectListMessagesPage

    /** List schedules */
    fun listSchedules(params: ObjectListSchedulesParams): ObjectListSchedulesPage =
        listSchedules(
          params, RequestOptions.none()
        )

    /** @see [listSchedules] */
    fun listSchedules(params: ObjectListSchedulesParams, requestOptions: RequestOptions = RequestOptions.none()): ObjectListSchedulesPage

    /**
     * List subscriptions for an object. Either list all subscriptions that belong to
     * the object, or all subscriptions that this object has. Determined by the `mode`
     * query parameter.
     */
    fun listSubscriptions(params: ObjectListSubscriptionsParams): ObjectListSubscriptionsPage =
        listSubscriptions(
          params, RequestOptions.none()
        )

    /** @see [listSubscriptions] */
    fun listSubscriptions(params: ObjectListSubscriptionsParams, requestOptions: RequestOptions = RequestOptions.none()): ObjectListSubscriptionsPage

    /** Set (identify) an object */
    fun set(params: ObjectSetParams): Object =
        set(
          params, RequestOptions.none()
        )

    /** @see [set] */
    fun set(params: ObjectSetParams, requestOptions: RequestOptions = RequestOptions.none()): Object

    /** Set channel data */
    fun setChannelData(params: ObjectSetChannelDataParams): ChannelData =
        setChannelData(
          params, RequestOptions.none()
        )

    /** @see [setChannelData] */
    fun setChannelData(params: ObjectSetChannelDataParams, requestOptions: RequestOptions = RequestOptions.none()): ChannelData

    /** Update a preference set */
    fun setPreferences(params: ObjectSetPreferencesParams): PreferenceSet =
        setPreferences(
          params, RequestOptions.none()
        )

    /** @see [setPreferences] */
    fun setPreferences(params: ObjectSetPreferencesParams, requestOptions: RequestOptions = RequestOptions.none()): PreferenceSet

    /** Unset channel data */
    fun unsetChannelData(params: ObjectUnsetChannelDataParams): String =
        unsetChannelData(
          params, RequestOptions.none()
        )

    /** @see [unsetChannelData] */
    fun unsetChannelData(params: ObjectUnsetChannelDataParams, requestOptions: RequestOptions = RequestOptions.none()): String

    /**
     * A view of [ObjectService] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        fun bulk(): BulkService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/objects/{collection}`, but is otherwise
         * the same as [ObjectService.list].
         */
        @MustBeClosed
        fun list(params: ObjectListParams): HttpResponseFor<ObjectListPage> =
            list(
              params, RequestOptions.none()
            )

        /** @see [list] */
        @MustBeClosed
        fun list(params: ObjectListParams, requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<ObjectListPage>

        /**
         * Returns a raw HTTP response for `delete /v1/objects/{collection}/{object_id}`,
         * but is otherwise the same as [ObjectService.delete].
         */
        @MustBeClosed
        fun delete(params: ObjectDeleteParams): HttpResponseFor<String> =
            delete(
              params, RequestOptions.none()
            )

        /** @see [delete] */
        @MustBeClosed
        fun delete(params: ObjectDeleteParams, requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<String>

        /**
         * Returns a raw HTTP response for
         * `post /v1/objects/{collection}/{object_id}/subscriptions`, but is otherwise the
         * same as [ObjectService.addSubscriptions].
         */
        @MustBeClosed
        fun addSubscriptions(params: ObjectAddSubscriptionsParams): HttpResponseFor<List<Subscription>> =
            addSubscriptions(
              params, RequestOptions.none()
            )

        /** @see [addSubscriptions] */
        @MustBeClosed
        fun addSubscriptions(params: ObjectAddSubscriptionsParams, requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<List<Subscription>>

        /**
         * Returns a raw HTTP response for
         * `delete /v1/objects/{collection}/{object_id}/subscriptions`, but is otherwise
         * the same as [ObjectService.deleteSubscriptions].
         */
        @MustBeClosed
        fun deleteSubscriptions(params: ObjectDeleteSubscriptionsParams): HttpResponseFor<List<Subscription>> =
            deleteSubscriptions(
              params, RequestOptions.none()
            )

        /** @see [deleteSubscriptions] */
        @MustBeClosed
        fun deleteSubscriptions(params: ObjectDeleteSubscriptionsParams, requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<List<Subscription>>

        /**
         * Returns a raw HTTP response for `get /v1/objects/{collection}/{object_id}`, but
         * is otherwise the same as [ObjectService.get].
         */
        @MustBeClosed
        fun get(params: ObjectGetParams): HttpResponseFor<Object> =
            get(
              params, RequestOptions.none()
            )

        /** @see [get] */
        @MustBeClosed
        fun get(params: ObjectGetParams, requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<Object>

        /**
         * Returns a raw HTTP response for
         * `get /v1/objects/{collection}/{object_id}/channel_data/{channel_id}`, but is
         * otherwise the same as [ObjectService.getChannelData].
         */
        @MustBeClosed
        fun getChannelData(params: ObjectGetChannelDataParams): HttpResponseFor<ChannelData> =
            getChannelData(
              params, RequestOptions.none()
            )

        /** @see [getChannelData] */
        @MustBeClosed
        fun getChannelData(params: ObjectGetChannelDataParams, requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<ChannelData>

        /**
         * Returns a raw HTTP response for
         * `get /v1/objects/{collection}/{object_id}/preferences/{preference_set_id}`, but
         * is otherwise the same as [ObjectService.getPreferences].
         */
        @MustBeClosed
        fun getPreferences(params: ObjectGetPreferencesParams): HttpResponseFor<PreferenceSet> =
            getPreferences(
              params, RequestOptions.none()
            )

        /** @see [getPreferences] */
        @MustBeClosed
        fun getPreferences(params: ObjectGetPreferencesParams, requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<PreferenceSet>

        /**
         * Returns a raw HTTP response for
         * `get /v1/objects/{collection}/{object_id}/messages`, but is otherwise the same
         * as [ObjectService.listMessages].
         */
        @MustBeClosed
        fun listMessages(params: ObjectListMessagesParams): HttpResponseFor<ObjectListMessagesPage> =
            listMessages(
              params, RequestOptions.none()
            )

        /** @see [listMessages] */
        @MustBeClosed
        fun listMessages(params: ObjectListMessagesParams, requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<ObjectListMessagesPage>

        /**
         * Returns a raw HTTP response for
         * `get /v1/objects/{collection}/{object_id}/schedules`, but is otherwise the same
         * as [ObjectService.listSchedules].
         */
        @MustBeClosed
        fun listSchedules(params: ObjectListSchedulesParams): HttpResponseFor<ObjectListSchedulesPage> =
            listSchedules(
              params, RequestOptions.none()
            )

        /** @see [listSchedules] */
        @MustBeClosed
        fun listSchedules(params: ObjectListSchedulesParams, requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<ObjectListSchedulesPage>

        /**
         * Returns a raw HTTP response for
         * `get /v1/objects/{collection}/{object_id}/subscriptions`, but is otherwise the
         * same as [ObjectService.listSubscriptions].
         */
        @MustBeClosed
        fun listSubscriptions(params: ObjectListSubscriptionsParams): HttpResponseFor<ObjectListSubscriptionsPage> =
            listSubscriptions(
              params, RequestOptions.none()
            )

        /** @see [listSubscriptions] */
        @MustBeClosed
        fun listSubscriptions(params: ObjectListSubscriptionsParams, requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<ObjectListSubscriptionsPage>

        /**
         * Returns a raw HTTP response for `put /v1/objects/{collection}/{object_id}`, but
         * is otherwise the same as [ObjectService.set].
         */
        @MustBeClosed
        fun set(params: ObjectSetParams): HttpResponseFor<Object> =
            set(
              params, RequestOptions.none()
            )

        /** @see [set] */
        @MustBeClosed
        fun set(params: ObjectSetParams, requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<Object>

        /**
         * Returns a raw HTTP response for
         * `put /v1/objects/{collection}/{object_id}/channel_data/{channel_id}`, but is
         * otherwise the same as [ObjectService.setChannelData].
         */
        @MustBeClosed
        fun setChannelData(params: ObjectSetChannelDataParams): HttpResponseFor<ChannelData> =
            setChannelData(
              params, RequestOptions.none()
            )

        /** @see [setChannelData] */
        @MustBeClosed
        fun setChannelData(params: ObjectSetChannelDataParams, requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<ChannelData>

        /**
         * Returns a raw HTTP response for
         * `put /v1/objects/{collection}/{object_id}/preferences/{preference_set_id}`, but
         * is otherwise the same as [ObjectService.setPreferences].
         */
        @MustBeClosed
        fun setPreferences(params: ObjectSetPreferencesParams): HttpResponseFor<PreferenceSet> =
            setPreferences(
              params, RequestOptions.none()
            )

        /** @see [setPreferences] */
        @MustBeClosed
        fun setPreferences(params: ObjectSetPreferencesParams, requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<PreferenceSet>

        /**
         * Returns a raw HTTP response for
         * `delete /v1/objects/{collection}/{object_id}/channel_data/{channel_id}`, but is
         * otherwise the same as [ObjectService.unsetChannelData].
         */
        @MustBeClosed
        fun unsetChannelData(params: ObjectUnsetChannelDataParams): HttpResponseFor<String> =
            unsetChannelData(
              params, RequestOptions.none()
            )

        /** @see [unsetChannelData] */
        @MustBeClosed
        fun unsetChannelData(params: ObjectUnsetChannelDataParams, requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<String>
    }
}
