// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.objects.Object
import app.knock.api.models.objects.ObjectAddSubscriptionsParams
import app.knock.api.models.objects.ObjectDeleteParams
import app.knock.api.models.objects.ObjectDeleteSubscriptionsParams
import app.knock.api.models.objects.ObjectGetChannelDataParams
import app.knock.api.models.objects.ObjectGetParams
import app.knock.api.models.objects.ObjectGetPreferencesParams
import app.knock.api.models.objects.ObjectListMessagesPageAsync
import app.knock.api.models.objects.ObjectListMessagesParams
import app.knock.api.models.objects.ObjectListPageAsync
import app.knock.api.models.objects.ObjectListParams
import app.knock.api.models.objects.ObjectListSchedulesPageAsync
import app.knock.api.models.objects.ObjectListSchedulesParams
import app.knock.api.models.objects.ObjectListSubscriptionsPageAsync
import app.knock.api.models.objects.ObjectListSubscriptionsParams
import app.knock.api.models.objects.ObjectSetChannelDataParams
import app.knock.api.models.objects.ObjectSetParams
import app.knock.api.models.objects.ObjectSetPreferencesParams
import app.knock.api.models.objects.ObjectUnsetChannelDataParams
import app.knock.api.models.recipients.channeldata.ChannelData
import app.knock.api.models.recipients.preferences.PreferenceSet
import app.knock.api.models.recipients.subscriptions.Subscription
import app.knock.api.services.async.objects.BulkServiceAsync
import com.google.errorprone.annotations.MustBeClosed
import java.util.concurrent.CompletableFuture

interface ObjectServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for
     * each method.
     */
    fun withRawResponse(): WithRawResponse

    fun bulk(): BulkServiceAsync

    /** List objects in a collection */
    fun list(params: ObjectListParams): CompletableFuture<ObjectListPageAsync> =
        list(
          params, RequestOptions.none()
        )

    /** @see [list] */
    fun list(params: ObjectListParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<ObjectListPageAsync>

    /** Delete an object */
    fun delete(params: ObjectDeleteParams): CompletableFuture<String> =
        delete(
          params, RequestOptions.none()
        )

    /** @see [delete] */
    fun delete(params: ObjectDeleteParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<String>

    /**
     * Add subscriptions for an object. If a subscription already exists, it will be
     * updated.
     */
    fun addSubscriptions(params: ObjectAddSubscriptionsParams): CompletableFuture<List<Subscription>> =
        addSubscriptions(
          params, RequestOptions.none()
        )

    /** @see [addSubscriptions] */
    fun addSubscriptions(params: ObjectAddSubscriptionsParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<List<Subscription>>

    /** Delete subscriptions */
    fun deleteSubscriptions(params: ObjectDeleteSubscriptionsParams): CompletableFuture<List<Subscription>> =
        deleteSubscriptions(
          params, RequestOptions.none()
        )

    /** @see [deleteSubscriptions] */
    fun deleteSubscriptions(params: ObjectDeleteSubscriptionsParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<List<Subscription>>

    /** Get an object */
    fun get(params: ObjectGetParams): CompletableFuture<Object> =
        get(
          params, RequestOptions.none()
        )

    /** @see [get] */
    fun get(params: ObjectGetParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<Object>

    /** Get channel data */
    fun getChannelData(params: ObjectGetChannelDataParams): CompletableFuture<ChannelData> =
        getChannelData(
          params, RequestOptions.none()
        )

    /** @see [getChannelData] */
    fun getChannelData(params: ObjectGetChannelDataParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<ChannelData>

    /** Get a preference set */
    fun getPreferences(params: ObjectGetPreferencesParams): CompletableFuture<PreferenceSet> =
        getPreferences(
          params, RequestOptions.none()
        )

    /** @see [getPreferences] */
    fun getPreferences(params: ObjectGetPreferencesParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<PreferenceSet>

    /** List messages */
    fun listMessages(params: ObjectListMessagesParams): CompletableFuture<ObjectListMessagesPageAsync> =
        listMessages(
          params, RequestOptions.none()
        )

    /** @see [listMessages] */
    fun listMessages(params: ObjectListMessagesParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<ObjectListMessagesPageAsync>

    /** List schedules */
    fun listSchedules(params: ObjectListSchedulesParams): CompletableFuture<ObjectListSchedulesPageAsync> =
        listSchedules(
          params, RequestOptions.none()
        )

    /** @see [listSchedules] */
    fun listSchedules(params: ObjectListSchedulesParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<ObjectListSchedulesPageAsync>

    /**
     * List subscriptions for an object. Either list all subscriptions that belong to
     * the object, or all subscriptions that this object has. Determined by the `mode`
     * query parameter.
     */
    fun listSubscriptions(params: ObjectListSubscriptionsParams): CompletableFuture<ObjectListSubscriptionsPageAsync> =
        listSubscriptions(
          params, RequestOptions.none()
        )

    /** @see [listSubscriptions] */
    fun listSubscriptions(params: ObjectListSubscriptionsParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<ObjectListSubscriptionsPageAsync>

    /** Set (identify) an object */
    fun set(params: ObjectSetParams): CompletableFuture<Object> =
        set(
          params, RequestOptions.none()
        )

    /** @see [set] */
    fun set(params: ObjectSetParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<Object>

    /** Set channel data */
    fun setChannelData(params: ObjectSetChannelDataParams): CompletableFuture<ChannelData> =
        setChannelData(
          params, RequestOptions.none()
        )

    /** @see [setChannelData] */
    fun setChannelData(params: ObjectSetChannelDataParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<ChannelData>

    /** Update a preference set */
    fun setPreferences(params: ObjectSetPreferencesParams): CompletableFuture<PreferenceSet> =
        setPreferences(
          params, RequestOptions.none()
        )

    /** @see [setPreferences] */
    fun setPreferences(params: ObjectSetPreferencesParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<PreferenceSet>

    /** Unset channel data */
    fun unsetChannelData(params: ObjectUnsetChannelDataParams): CompletableFuture<String> =
        unsetChannelData(
          params, RequestOptions.none()
        )

    /** @see [unsetChannelData] */
    fun unsetChannelData(params: ObjectUnsetChannelDataParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<String>

    /**
     * A view of [ObjectServiceAsync] that provides access to raw HTTP responses for
     * each method.
     */
    interface WithRawResponse {

        fun bulk(): BulkServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/objects/{collection}`, but is otherwise
         * the same as [ObjectServiceAsync.list].
         */
        @MustBeClosed
        fun list(params: ObjectListParams): CompletableFuture<HttpResponseFor<ObjectListPageAsync>> =
            list(
              params, RequestOptions.none()
            )

        /** @see [list] */
        @MustBeClosed
        fun list(params: ObjectListParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<HttpResponseFor<ObjectListPageAsync>>

        /**
         * Returns a raw HTTP response for `delete /v1/objects/{collection}/{object_id}`,
         * but is otherwise the same as [ObjectServiceAsync.delete].
         */
        @MustBeClosed
        fun delete(params: ObjectDeleteParams): CompletableFuture<HttpResponseFor<String>> =
            delete(
              params, RequestOptions.none()
            )

        /** @see [delete] */
        @MustBeClosed
        fun delete(params: ObjectDeleteParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<HttpResponseFor<String>>

        /**
         * Returns a raw HTTP response for
         * `post /v1/objects/{collection}/{object_id}/subscriptions`, but is otherwise the
         * same as [ObjectServiceAsync.addSubscriptions].
         */
        @MustBeClosed
        fun addSubscriptions(params: ObjectAddSubscriptionsParams): CompletableFuture<HttpResponseFor<List<Subscription>>> =
            addSubscriptions(
              params, RequestOptions.none()
            )

        /** @see [addSubscriptions] */
        @MustBeClosed
        fun addSubscriptions(params: ObjectAddSubscriptionsParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<HttpResponseFor<List<Subscription>>>

        /**
         * Returns a raw HTTP response for
         * `delete /v1/objects/{collection}/{object_id}/subscriptions`, but is otherwise
         * the same as [ObjectServiceAsync.deleteSubscriptions].
         */
        @MustBeClosed
        fun deleteSubscriptions(params: ObjectDeleteSubscriptionsParams): CompletableFuture<HttpResponseFor<List<Subscription>>> =
            deleteSubscriptions(
              params, RequestOptions.none()
            )

        /** @see [deleteSubscriptions] */
        @MustBeClosed
        fun deleteSubscriptions(params: ObjectDeleteSubscriptionsParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<HttpResponseFor<List<Subscription>>>

        /**
         * Returns a raw HTTP response for `get /v1/objects/{collection}/{object_id}`, but
         * is otherwise the same as [ObjectServiceAsync.get].
         */
        @MustBeClosed
        fun get(params: ObjectGetParams): CompletableFuture<HttpResponseFor<Object>> =
            get(
              params, RequestOptions.none()
            )

        /** @see [get] */
        @MustBeClosed
        fun get(params: ObjectGetParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<HttpResponseFor<Object>>

        /**
         * Returns a raw HTTP response for
         * `get /v1/objects/{collection}/{object_id}/channel_data/{channel_id}`, but is
         * otherwise the same as [ObjectServiceAsync.getChannelData].
         */
        @MustBeClosed
        fun getChannelData(params: ObjectGetChannelDataParams): CompletableFuture<HttpResponseFor<ChannelData>> =
            getChannelData(
              params, RequestOptions.none()
            )

        /** @see [getChannelData] */
        @MustBeClosed
        fun getChannelData(params: ObjectGetChannelDataParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<HttpResponseFor<ChannelData>>

        /**
         * Returns a raw HTTP response for
         * `get /v1/objects/{collection}/{object_id}/preferences/{preference_set_id}`, but
         * is otherwise the same as [ObjectServiceAsync.getPreferences].
         */
        @MustBeClosed
        fun getPreferences(params: ObjectGetPreferencesParams): CompletableFuture<HttpResponseFor<PreferenceSet>> =
            getPreferences(
              params, RequestOptions.none()
            )

        /** @see [getPreferences] */
        @MustBeClosed
        fun getPreferences(params: ObjectGetPreferencesParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<HttpResponseFor<PreferenceSet>>

        /**
         * Returns a raw HTTP response for
         * `get /v1/objects/{collection}/{object_id}/messages`, but is otherwise the same
         * as [ObjectServiceAsync.listMessages].
         */
        @MustBeClosed
        fun listMessages(params: ObjectListMessagesParams): CompletableFuture<HttpResponseFor<ObjectListMessagesPageAsync>> =
            listMessages(
              params, RequestOptions.none()
            )

        /** @see [listMessages] */
        @MustBeClosed
        fun listMessages(params: ObjectListMessagesParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<HttpResponseFor<ObjectListMessagesPageAsync>>

        /**
         * Returns a raw HTTP response for
         * `get /v1/objects/{collection}/{object_id}/schedules`, but is otherwise the same
         * as [ObjectServiceAsync.listSchedules].
         */
        @MustBeClosed
        fun listSchedules(params: ObjectListSchedulesParams): CompletableFuture<HttpResponseFor<ObjectListSchedulesPageAsync>> =
            listSchedules(
              params, RequestOptions.none()
            )

        /** @see [listSchedules] */
        @MustBeClosed
        fun listSchedules(params: ObjectListSchedulesParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<HttpResponseFor<ObjectListSchedulesPageAsync>>

        /**
         * Returns a raw HTTP response for
         * `get /v1/objects/{collection}/{object_id}/subscriptions`, but is otherwise the
         * same as [ObjectServiceAsync.listSubscriptions].
         */
        @MustBeClosed
        fun listSubscriptions(params: ObjectListSubscriptionsParams): CompletableFuture<HttpResponseFor<ObjectListSubscriptionsPageAsync>> =
            listSubscriptions(
              params, RequestOptions.none()
            )

        /** @see [listSubscriptions] */
        @MustBeClosed
        fun listSubscriptions(params: ObjectListSubscriptionsParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<HttpResponseFor<ObjectListSubscriptionsPageAsync>>

        /**
         * Returns a raw HTTP response for `put /v1/objects/{collection}/{object_id}`, but
         * is otherwise the same as [ObjectServiceAsync.set].
         */
        @MustBeClosed
        fun set(params: ObjectSetParams): CompletableFuture<HttpResponseFor<Object>> =
            set(
              params, RequestOptions.none()
            )

        /** @see [set] */
        @MustBeClosed
        fun set(params: ObjectSetParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<HttpResponseFor<Object>>

        /**
         * Returns a raw HTTP response for
         * `put /v1/objects/{collection}/{object_id}/channel_data/{channel_id}`, but is
         * otherwise the same as [ObjectServiceAsync.setChannelData].
         */
        @MustBeClosed
        fun setChannelData(params: ObjectSetChannelDataParams): CompletableFuture<HttpResponseFor<ChannelData>> =
            setChannelData(
              params, RequestOptions.none()
            )

        /** @see [setChannelData] */
        @MustBeClosed
        fun setChannelData(params: ObjectSetChannelDataParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<HttpResponseFor<ChannelData>>

        /**
         * Returns a raw HTTP response for
         * `put /v1/objects/{collection}/{object_id}/preferences/{preference_set_id}`, but
         * is otherwise the same as [ObjectServiceAsync.setPreferences].
         */
        @MustBeClosed
        fun setPreferences(params: ObjectSetPreferencesParams): CompletableFuture<HttpResponseFor<PreferenceSet>> =
            setPreferences(
              params, RequestOptions.none()
            )

        /** @see [setPreferences] */
        @MustBeClosed
        fun setPreferences(params: ObjectSetPreferencesParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<HttpResponseFor<PreferenceSet>>

        /**
         * Returns a raw HTTP response for
         * `delete /v1/objects/{collection}/{object_id}/channel_data/{channel_id}`, but is
         * otherwise the same as [ObjectServiceAsync.unsetChannelData].
         */
        @MustBeClosed
        fun unsetChannelData(params: ObjectUnsetChannelDataParams): CompletableFuture<HttpResponseFor<String>> =
            unsetChannelData(
              params, RequestOptions.none()
            )

        /** @see [unsetChannelData] */
        @MustBeClosed
        fun unsetChannelData(params: ObjectUnsetChannelDataParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<HttpResponseFor<String>>
    }
}
