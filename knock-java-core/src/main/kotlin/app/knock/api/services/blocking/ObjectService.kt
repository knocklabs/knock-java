// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.objects.ObjectAddSubscriptionsParams
import app.knock.api.models.objects.ObjectDeleteSubscriptionsParams
import app.knock.api.models.objects.ObjectGetChannelDataParams
import app.knock.api.models.objects.ObjectListPage
import app.knock.api.models.objects.ObjectListParams
import app.knock.api.models.objects.ObjectListPreferencesParams
import app.knock.api.models.objects.ObjectListSubscriptionsPage
import app.knock.api.models.objects.ObjectListSubscriptionsParams
import app.knock.api.models.objects.ObjectSetChannelDataParams
import app.knock.api.models.objects.ObjectUnsetChannelDataParams
import app.knock.api.models.recipients.channeldata.ChannelData
import app.knock.api.models.recipients.preferences.PreferenceSet
import app.knock.api.models.recipients.subscriptions.Subscription
import app.knock.api.services.blocking.objects.BulkService
import com.google.errorprone.annotations.MustBeClosed

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

    /** Returns the channel data for the specified object and channel. */
    fun getChannelData(params: ObjectGetChannelDataParams): ChannelData =
        getChannelData(params, RequestOptions.none())

    /** @see [getChannelData] */
    fun getChannelData(
        params: ObjectGetChannelDataParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ChannelData

    /** Returns a paginated list of preference sets for the specified object. */
    fun listPreferences(params: ObjectListPreferencesParams): List<PreferenceSet> =
        listPreferences(params, RequestOptions.none())

    /** @see [listPreferences] */
    fun listPreferences(
        params: ObjectListPreferencesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<PreferenceSet>

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

    /** Sets the channel data for the specified object and channel. */
    fun setChannelData(params: ObjectSetChannelDataParams): ChannelData =
        setChannelData(params, RequestOptions.none())

    /** @see [setChannelData] */
    fun setChannelData(
        params: ObjectSetChannelDataParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ChannelData

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
         * Returns a raw HTTP response for `get
         * /v1/objects/{collection}/{object_id}/channel_data/{channel_id}`, but is otherwise the
         * same as [ObjectService.getChannelData].
         */
        @MustBeClosed
        fun getChannelData(params: ObjectGetChannelDataParams): HttpResponseFor<ChannelData> =
            getChannelData(params, RequestOptions.none())

        /** @see [getChannelData] */
        @MustBeClosed
        fun getChannelData(
            params: ObjectGetChannelDataParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ChannelData>

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
         * Returns a raw HTTP response for `put
         * /v1/objects/{collection}/{object_id}/channel_data/{channel_id}`, but is otherwise the
         * same as [ObjectService.setChannelData].
         */
        @MustBeClosed
        fun setChannelData(params: ObjectSetChannelDataParams): HttpResponseFor<ChannelData> =
            setChannelData(params, RequestOptions.none())

        /** @see [setChannelData] */
        @MustBeClosed
        fun setChannelData(
            params: ObjectSetChannelDataParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ChannelData>

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
