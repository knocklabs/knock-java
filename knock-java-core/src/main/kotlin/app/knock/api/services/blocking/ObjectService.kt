// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.objects.Object
import app.knock.api.models.objects.ObjectAddSubscriptionsParams
import app.knock.api.models.objects.ObjectDeleteParams
import app.knock.api.models.objects.ObjectDeleteSubscriptionsParams
import app.knock.api.models.objects.ObjectGetChannelDataParams
import app.knock.api.models.objects.ObjectGetParams
import app.knock.api.models.objects.ObjectGetPreferencesParams
import app.knock.api.models.objects.ObjectListMessagesPage
import app.knock.api.models.objects.ObjectListMessagesParams
import app.knock.api.models.objects.ObjectListPage
import app.knock.api.models.objects.ObjectListParams
import app.knock.api.models.objects.ObjectListPreferencesParams
import app.knock.api.models.objects.ObjectListSchedulesPage
import app.knock.api.models.objects.ObjectListSchedulesParams
import app.knock.api.models.objects.ObjectListSubscriptionsPage
import app.knock.api.models.objects.ObjectListSubscriptionsParams
import app.knock.api.models.objects.ObjectSetChannelDataParams
import app.knock.api.models.objects.ObjectSetChannelDataResponse
import app.knock.api.models.objects.ObjectSetParams
import app.knock.api.models.objects.ObjectSetPreferencesParams
import app.knock.api.models.objects.ObjectUnsetChannelDataParams
import app.knock.api.models.recipients.preferences.PreferenceSet
import app.knock.api.models.recipients.subscriptions.Subscription
import app.knock.api.services.blocking.objects.BulkService
import com.google.errorprone.annotations.MustBeClosed
import java.util.Optional

interface ObjectService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun bulk(): BulkService

    /**
     * Returns a paginated list of objects from the specified collection. Optionally includes
     * preference data for the objects.
     */
    fun list(params: ObjectListParams): ObjectListPage = list(params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: ObjectListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ObjectListPage

    /**
     * Permanently removes an object from the specified collection. This operation cannot be undone.
     */
    fun delete(params: ObjectDeleteParams): String = delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: ObjectDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): String

    /**
     * Add subscriptions for an object. If a subscription already exists, it will be updated. This
     * endpoint also handles
     * [inline identifications](/managing-recipients/identifying-recipients#inline-identifying-recipients)
     * for the `recipient`.
     */
    fun addSubscriptions(params: ObjectAddSubscriptionsParams): List<Subscription> =
        addSubscriptions(params, RequestOptions.none())

    /** @see [addSubscriptions] */
    fun addSubscriptions(
        params: ObjectAddSubscriptionsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Subscription>

    /**
     * Delete subscriptions for the specified recipients from an object. Returns the list of deleted
     * subscriptions.
     */
    fun deleteSubscriptions(params: ObjectDeleteSubscriptionsParams): List<Subscription> =
        deleteSubscriptions(params, RequestOptions.none())

    /** @see [deleteSubscriptions] */
    fun deleteSubscriptions(
        params: ObjectDeleteSubscriptionsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Subscription>

    /**
     * Retrieves a specific object by its ID from the specified collection. Returns the object with
     * all its properties.
     */
    fun get(params: ObjectGetParams): Object = get(params, RequestOptions.none())

    /** @see [get] */
    fun get(params: ObjectGetParams, requestOptions: RequestOptions = RequestOptions.none()): Object

    /** Returns the channel data for the specified object and channel. */
    fun getChannelData(
        params: ObjectGetChannelDataParams
    ): Optional<List<ObjectSetChannelDataResponse>> = getChannelData(params, RequestOptions.none())

    /** @see [getChannelData] */
    fun getChannelData(
        params: ObjectGetChannelDataParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Optional<List<ObjectSetChannelDataResponse>>

    /** Returns the preference set for the specified object. */
    fun getPreferences(params: ObjectGetPreferencesParams): PreferenceSet =
        getPreferences(params, RequestOptions.none())

    /** @see [getPreferences] */
    fun getPreferences(
        params: ObjectGetPreferencesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PreferenceSet

    /**
     * Returns a paginated list of messages for a specific object in the given collection. Allows
     * filtering by message status and provides various sorting options.
     */
    fun listMessages(params: ObjectListMessagesParams): ObjectListMessagesPage =
        listMessages(params, RequestOptions.none())

    /** @see [listMessages] */
    fun listMessages(
        params: ObjectListMessagesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ObjectListMessagesPage

    /** Returns a paginated list of preference sets for the specified object. */
    fun listPreferences(params: ObjectListPreferencesParams): List<PreferenceSet> =
        listPreferences(params, RequestOptions.none())

    /** @see [listPreferences] */
    fun listPreferences(
        params: ObjectListPreferencesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<PreferenceSet>

    /** Returns a paginated list of schedules for an object. */
    fun listSchedules(params: ObjectListSchedulesParams): ObjectListSchedulesPage =
        listSchedules(params, RequestOptions.none())

    /** @see [listSchedules] */
    fun listSchedules(
        params: ObjectListSchedulesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ObjectListSchedulesPage

    /**
     * List subscriptions for an object. Either list the recipients that subscribe to the provided
     * object, or list the objects that the provided object is subscribed to. Determined by the
     * `mode` query parameter.
     */
    fun listSubscriptions(params: ObjectListSubscriptionsParams): ObjectListSubscriptionsPage =
        listSubscriptions(params, RequestOptions.none())

    /** @see [listSubscriptions] */
    fun listSubscriptions(
        params: ObjectListSubscriptionsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ObjectListSubscriptionsPage

    /**
     * Creates a new object or updates an existing one in the specified collection. This operation
     * is used to identify objects with their properties, as well as optional preferences and
     * channel data.
     */
    fun set(params: ObjectSetParams): Object = set(params, RequestOptions.none())

    /** @see [set] */
    fun set(params: ObjectSetParams, requestOptions: RequestOptions = RequestOptions.none()): Object

    /** Sets the channel data for the specified object and channel. */
    fun setChannelData(
        params: ObjectSetChannelDataParams
    ): Optional<List<ObjectSetChannelDataResponse>> = setChannelData(params, RequestOptions.none())

    /** @see [setChannelData] */
    fun setChannelData(
        params: ObjectSetChannelDataParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Optional<List<ObjectSetChannelDataResponse>>

    /** Updates the preference set for the specified object. */
    fun setPreferences(params: ObjectSetPreferencesParams): PreferenceSet =
        setPreferences(params, RequestOptions.none())

    /** @see [setPreferences] */
    fun setPreferences(
        params: ObjectSetPreferencesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PreferenceSet

    /** Unsets the channel data for the specified object and channel. */
    fun unsetChannelData(params: ObjectUnsetChannelDataParams): String =
        unsetChannelData(params, RequestOptions.none())

    /** @see [unsetChannelData] */
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
        @MustBeClosed
        fun list(params: ObjectListParams): HttpResponseFor<ObjectListPage> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: ObjectListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ObjectListPage>

        /**
         * Returns a raw HTTP response for `delete /v1/objects/{collection}/{object_id}`, but is
         * otherwise the same as [ObjectService.delete].
         */
        @MustBeClosed
        fun delete(params: ObjectDeleteParams): HttpResponseFor<String> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
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
        @MustBeClosed
        fun addSubscriptions(
            params: ObjectAddSubscriptionsParams
        ): HttpResponseFor<List<Subscription>> = addSubscriptions(params, RequestOptions.none())

        /** @see [addSubscriptions] */
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
        @MustBeClosed
        fun deleteSubscriptions(
            params: ObjectDeleteSubscriptionsParams
        ): HttpResponseFor<List<Subscription>> = deleteSubscriptions(params, RequestOptions.none())

        /** @see [deleteSubscriptions] */
        @MustBeClosed
        fun deleteSubscriptions(
            params: ObjectDeleteSubscriptionsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Subscription>>

        /**
         * Returns a raw HTTP response for `get /v1/objects/{collection}/{object_id}`, but is
         * otherwise the same as [ObjectService.get].
         */
        @MustBeClosed
        fun get(params: ObjectGetParams): HttpResponseFor<Object> =
            get(params, RequestOptions.none())

        /** @see [get] */
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
        @MustBeClosed
        fun getChannelData(
            params: ObjectGetChannelDataParams
        ): HttpResponseFor<Optional<List<ObjectSetChannelDataResponse>>> =
            getChannelData(params, RequestOptions.none())

        /** @see [getChannelData] */
        @MustBeClosed
        fun getChannelData(
            params: ObjectGetChannelDataParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Optional<List<ObjectSetChannelDataResponse>>>

        /**
         * Returns a raw HTTP response for `get
         * /v1/objects/{collection}/{object_id}/preferences/{preference_set_id}`, but is otherwise
         * the same as [ObjectService.getPreferences].
         */
        @MustBeClosed
        fun getPreferences(params: ObjectGetPreferencesParams): HttpResponseFor<PreferenceSet> =
            getPreferences(params, RequestOptions.none())

        /** @see [getPreferences] */
        @MustBeClosed
        fun getPreferences(
            params: ObjectGetPreferencesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PreferenceSet>

        /**
         * Returns a raw HTTP response for `get /v1/objects/{collection}/{object_id}/messages`, but
         * is otherwise the same as [ObjectService.listMessages].
         */
        @MustBeClosed
        fun listMessages(
            params: ObjectListMessagesParams
        ): HttpResponseFor<ObjectListMessagesPage> = listMessages(params, RequestOptions.none())

        /** @see [listMessages] */
        @MustBeClosed
        fun listMessages(
            params: ObjectListMessagesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ObjectListMessagesPage>

        /**
         * Returns a raw HTTP response for `get /v1/objects/{collection}/{object_id}/preferences`,
         * but is otherwise the same as [ObjectService.listPreferences].
         */
        @MustBeClosed
        fun listPreferences(
            params: ObjectListPreferencesParams
        ): HttpResponseFor<List<PreferenceSet>> = listPreferences(params, RequestOptions.none())

        /** @see [listPreferences] */
        @MustBeClosed
        fun listPreferences(
            params: ObjectListPreferencesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<PreferenceSet>>

        /**
         * Returns a raw HTTP response for `get /v1/objects/{collection}/{object_id}/schedules`, but
         * is otherwise the same as [ObjectService.listSchedules].
         */
        @MustBeClosed
        fun listSchedules(
            params: ObjectListSchedulesParams
        ): HttpResponseFor<ObjectListSchedulesPage> = listSchedules(params, RequestOptions.none())

        /** @see [listSchedules] */
        @MustBeClosed
        fun listSchedules(
            params: ObjectListSchedulesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ObjectListSchedulesPage>

        /**
         * Returns a raw HTTP response for `get /v1/objects/{collection}/{object_id}/subscriptions`,
         * but is otherwise the same as [ObjectService.listSubscriptions].
         */
        @MustBeClosed
        fun listSubscriptions(
            params: ObjectListSubscriptionsParams
        ): HttpResponseFor<ObjectListSubscriptionsPage> =
            listSubscriptions(params, RequestOptions.none())

        /** @see [listSubscriptions] */
        @MustBeClosed
        fun listSubscriptions(
            params: ObjectListSubscriptionsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ObjectListSubscriptionsPage>

        /**
         * Returns a raw HTTP response for `put /v1/objects/{collection}/{object_id}`, but is
         * otherwise the same as [ObjectService.set].
         */
        @MustBeClosed
        fun set(params: ObjectSetParams): HttpResponseFor<Object> =
            set(params, RequestOptions.none())

        /** @see [set] */
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
        @MustBeClosed
        fun setChannelData(
            params: ObjectSetChannelDataParams
        ): HttpResponseFor<Optional<List<ObjectSetChannelDataResponse>>> =
            setChannelData(params, RequestOptions.none())

        /** @see [setChannelData] */
        @MustBeClosed
        fun setChannelData(
            params: ObjectSetChannelDataParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Optional<List<ObjectSetChannelDataResponse>>>

        /**
         * Returns a raw HTTP response for `put
         * /v1/objects/{collection}/{object_id}/preferences/{preference_set_id}`, but is otherwise
         * the same as [ObjectService.setPreferences].
         */
        @MustBeClosed
        fun setPreferences(params: ObjectSetPreferencesParams): HttpResponseFor<PreferenceSet> =
            setPreferences(params, RequestOptions.none())

        /** @see [setPreferences] */
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
        @MustBeClosed
        fun unsetChannelData(params: ObjectUnsetChannelDataParams): HttpResponseFor<String> =
            unsetChannelData(params, RequestOptions.none())

        /** @see [unsetChannelData] */
        @MustBeClosed
        fun unsetChannelData(
            params: ObjectUnsetChannelDataParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<String>
    }
}
