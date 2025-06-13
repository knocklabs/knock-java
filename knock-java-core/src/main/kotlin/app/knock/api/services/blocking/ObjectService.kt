// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking

import app.knock.api.core.ClientOptions
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
import app.knock.api.models.objects.ObjectSetParams
import app.knock.api.models.objects.ObjectSetPreferencesParams
import app.knock.api.models.objects.ObjectUnsetChannelDataParams
import app.knock.api.models.recipients.channeldata.ChannelData
import app.knock.api.models.recipients.preferences.PreferenceSet
import app.knock.api.models.recipients.subscriptions.Subscription
import app.knock.api.services.blocking.objects.BulkService
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface ObjectService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ObjectService

    fun bulk(): BulkService

    /**
     * Returns a paginated list of objects from the specified collection. Optionally includes
     * preference data for the objects.
     */
    fun list(collection: String): ObjectListPage = list(collection, ObjectListParams.none())

    /** @see [list] */
    fun list(
        collection: String,
        params: ObjectListParams = ObjectListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ObjectListPage = list(params.toBuilder().collection(collection).build(), requestOptions)

    /** @see [list] */
    fun list(
        collection: String,
        params: ObjectListParams = ObjectListParams.none(),
    ): ObjectListPage = list(collection, params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: ObjectListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ObjectListPage

    /** @see [list] */
    fun list(params: ObjectListParams): ObjectListPage = list(params, RequestOptions.none())

    /** @see [list] */
    fun list(collection: String, requestOptions: RequestOptions): ObjectListPage =
        list(collection, ObjectListParams.none(), requestOptions)

    /**
     * Permanently removes an object from the specified collection. This operation cannot be undone.
     */
    fun delete(collection: String, id: String): String =
        delete(collection, id, ObjectDeleteParams.none())

    /** @see [delete] */
    fun delete(
        collection: String,
        id: String,
        params: ObjectDeleteParams = ObjectDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): String = delete(params.toBuilder().collection(collection).id(id).build(), requestOptions)

    /** @see [delete] */
    fun delete(
        collection: String,
        id: String,
        params: ObjectDeleteParams = ObjectDeleteParams.none(),
    ): String = delete(collection, id, params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: ObjectDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): String

    /** @see [delete] */
    fun delete(params: ObjectDeleteParams): String = delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(collection: String, id: String, requestOptions: RequestOptions): String =
        delete(collection, id, ObjectDeleteParams.none(), requestOptions)

    /**
     * Add subscriptions for an object. If a subscription already exists, it will be updated. This
     * endpoint also handles
     * [inline identifications](/managing-recipients/identifying-recipients#inline-identifying-recipients)
     * for the `recipient`.
     */
    fun addSubscriptions(
        collection: String,
        objectId: String,
        params: ObjectAddSubscriptionsParams,
    ): List<Subscription> = addSubscriptions(collection, objectId, params, RequestOptions.none())

    /** @see [addSubscriptions] */
    fun addSubscriptions(
        collection: String,
        objectId: String,
        params: ObjectAddSubscriptionsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Subscription> =
        addSubscriptions(
            params.toBuilder().collection(collection).objectId(objectId).build(),
            requestOptions,
        )

    /** @see [addSubscriptions] */
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
    fun deleteSubscriptions(
        collection: String,
        objectId: String,
        params: ObjectDeleteSubscriptionsParams,
    ): List<Subscription> = deleteSubscriptions(collection, objectId, params, RequestOptions.none())

    /** @see [deleteSubscriptions] */
    fun deleteSubscriptions(
        collection: String,
        objectId: String,
        params: ObjectDeleteSubscriptionsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Subscription> =
        deleteSubscriptions(
            params.toBuilder().collection(collection).objectId(objectId).build(),
            requestOptions,
        )

    /** @see [deleteSubscriptions] */
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
    fun get(collection: String, id: String): Object = get(collection, id, ObjectGetParams.none())

    /** @see [get] */
    fun get(
        collection: String,
        id: String,
        params: ObjectGetParams = ObjectGetParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Object = get(params.toBuilder().collection(collection).id(id).build(), requestOptions)

    /** @see [get] */
    fun get(
        collection: String,
        id: String,
        params: ObjectGetParams = ObjectGetParams.none(),
    ): Object = get(collection, id, params, RequestOptions.none())

    /** @see [get] */
    fun get(params: ObjectGetParams, requestOptions: RequestOptions = RequestOptions.none()): Object

    /** @see [get] */
    fun get(params: ObjectGetParams): Object = get(params, RequestOptions.none())

    /** @see [get] */
    fun get(collection: String, id: String, requestOptions: RequestOptions): Object =
        get(collection, id, ObjectGetParams.none(), requestOptions)

    /** Returns the channel data for the specified object and channel. */
    fun getChannelData(collection: String, objectId: String, channelId: String): ChannelData =
        getChannelData(collection, objectId, channelId, ObjectGetChannelDataParams.none())

    /** @see [getChannelData] */
    fun getChannelData(
        collection: String,
        objectId: String,
        channelId: String,
        params: ObjectGetChannelDataParams = ObjectGetChannelDataParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ChannelData =
        getChannelData(
            params
                .toBuilder()
                .collection(collection)
                .objectId(objectId)
                .channelId(channelId)
                .build(),
            requestOptions,
        )

    /** @see [getChannelData] */
    fun getChannelData(
        collection: String,
        objectId: String,
        channelId: String,
        params: ObjectGetChannelDataParams = ObjectGetChannelDataParams.none(),
    ): ChannelData = getChannelData(collection, objectId, channelId, params, RequestOptions.none())

    /** @see [getChannelData] */
    fun getChannelData(
        params: ObjectGetChannelDataParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ChannelData

    /** @see [getChannelData] */
    fun getChannelData(params: ObjectGetChannelDataParams): ChannelData =
        getChannelData(params, RequestOptions.none())

    /** @see [getChannelData] */
    fun getChannelData(
        collection: String,
        objectId: String,
        channelId: String,
        requestOptions: RequestOptions,
    ): ChannelData =
        getChannelData(
            collection,
            objectId,
            channelId,
            ObjectGetChannelDataParams.none(),
            requestOptions,
        )

    /** Returns the preference set for the specified object and preference set `id`. */
    fun getPreferences(collection: String, objectId: String, id: String): PreferenceSet =
        getPreferences(collection, objectId, id, ObjectGetPreferencesParams.none())

    /** @see [getPreferences] */
    fun getPreferences(
        collection: String,
        objectId: String,
        id: String,
        params: ObjectGetPreferencesParams = ObjectGetPreferencesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PreferenceSet =
        getPreferences(
            params.toBuilder().collection(collection).objectId(objectId).id(id).build(),
            requestOptions,
        )

    /** @see [getPreferences] */
    fun getPreferences(
        collection: String,
        objectId: String,
        id: String,
        params: ObjectGetPreferencesParams = ObjectGetPreferencesParams.none(),
    ): PreferenceSet = getPreferences(collection, objectId, id, params, RequestOptions.none())

    /** @see [getPreferences] */
    fun getPreferences(
        params: ObjectGetPreferencesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PreferenceSet

    /** @see [getPreferences] */
    fun getPreferences(params: ObjectGetPreferencesParams): PreferenceSet =
        getPreferences(params, RequestOptions.none())

    /** @see [getPreferences] */
    fun getPreferences(
        collection: String,
        objectId: String,
        id: String,
        requestOptions: RequestOptions,
    ): PreferenceSet =
        getPreferences(collection, objectId, id, ObjectGetPreferencesParams.none(), requestOptions)

    /**
     * Returns a paginated list of messages for a specific object in the given collection. Allows
     * filtering by message status and provides various sorting options.
     */
    fun listMessages(collection: String, id: String): ObjectListMessagesPage =
        listMessages(collection, id, ObjectListMessagesParams.none())

    /** @see [listMessages] */
    fun listMessages(
        collection: String,
        id: String,
        params: ObjectListMessagesParams = ObjectListMessagesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ObjectListMessagesPage =
        listMessages(params.toBuilder().collection(collection).id(id).build(), requestOptions)

    /** @see [listMessages] */
    fun listMessages(
        collection: String,
        id: String,
        params: ObjectListMessagesParams = ObjectListMessagesParams.none(),
    ): ObjectListMessagesPage = listMessages(collection, id, params, RequestOptions.none())

    /** @see [listMessages] */
    fun listMessages(
        params: ObjectListMessagesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ObjectListMessagesPage

    /** @see [listMessages] */
    fun listMessages(params: ObjectListMessagesParams): ObjectListMessagesPage =
        listMessages(params, RequestOptions.none())

    /** @see [listMessages] */
    fun listMessages(
        collection: String,
        id: String,
        requestOptions: RequestOptions,
    ): ObjectListMessagesPage =
        listMessages(collection, id, ObjectListMessagesParams.none(), requestOptions)

    /** Returns a paginated list of preference sets for the specified object. */
    fun listPreferences(collection: String, objectId: String): List<PreferenceSet> =
        listPreferences(collection, objectId, ObjectListPreferencesParams.none())

    /** @see [listPreferences] */
    fun listPreferences(
        collection: String,
        objectId: String,
        params: ObjectListPreferencesParams = ObjectListPreferencesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<PreferenceSet> =
        listPreferences(
            params.toBuilder().collection(collection).objectId(objectId).build(),
            requestOptions,
        )

    /** @see [listPreferences] */
    fun listPreferences(
        collection: String,
        objectId: String,
        params: ObjectListPreferencesParams = ObjectListPreferencesParams.none(),
    ): List<PreferenceSet> = listPreferences(collection, objectId, params, RequestOptions.none())

    /** @see [listPreferences] */
    fun listPreferences(
        params: ObjectListPreferencesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<PreferenceSet>

    /** @see [listPreferences] */
    fun listPreferences(params: ObjectListPreferencesParams): List<PreferenceSet> =
        listPreferences(params, RequestOptions.none())

    /** @see [listPreferences] */
    fun listPreferences(
        collection: String,
        objectId: String,
        requestOptions: RequestOptions,
    ): List<PreferenceSet> =
        listPreferences(collection, objectId, ObjectListPreferencesParams.none(), requestOptions)

    /** Returns a paginated list of schedules for an object. */
    fun listSchedules(collection: String, id: String): ObjectListSchedulesPage =
        listSchedules(collection, id, ObjectListSchedulesParams.none())

    /** @see [listSchedules] */
    fun listSchedules(
        collection: String,
        id: String,
        params: ObjectListSchedulesParams = ObjectListSchedulesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ObjectListSchedulesPage =
        listSchedules(params.toBuilder().collection(collection).id(id).build(), requestOptions)

    /** @see [listSchedules] */
    fun listSchedules(
        collection: String,
        id: String,
        params: ObjectListSchedulesParams = ObjectListSchedulesParams.none(),
    ): ObjectListSchedulesPage = listSchedules(collection, id, params, RequestOptions.none())

    /** @see [listSchedules] */
    fun listSchedules(
        params: ObjectListSchedulesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ObjectListSchedulesPage

    /** @see [listSchedules] */
    fun listSchedules(params: ObjectListSchedulesParams): ObjectListSchedulesPage =
        listSchedules(params, RequestOptions.none())

    /** @see [listSchedules] */
    fun listSchedules(
        collection: String,
        id: String,
        requestOptions: RequestOptions,
    ): ObjectListSchedulesPage =
        listSchedules(collection, id, ObjectListSchedulesParams.none(), requestOptions)

    /**
     * List subscriptions for an object. Either list the recipients that subscribe to the provided
     * object, or list the objects that the provided object is subscribed to. Determined by the
     * `mode` query parameter.
     */
    fun listSubscriptions(collection: String, objectId: String): ObjectListSubscriptionsPage =
        listSubscriptions(collection, objectId, ObjectListSubscriptionsParams.none())

    /** @see [listSubscriptions] */
    fun listSubscriptions(
        collection: String,
        objectId: String,
        params: ObjectListSubscriptionsParams = ObjectListSubscriptionsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ObjectListSubscriptionsPage =
        listSubscriptions(
            params.toBuilder().collection(collection).objectId(objectId).build(),
            requestOptions,
        )

    /** @see [listSubscriptions] */
    fun listSubscriptions(
        collection: String,
        objectId: String,
        params: ObjectListSubscriptionsParams = ObjectListSubscriptionsParams.none(),
    ): ObjectListSubscriptionsPage =
        listSubscriptions(collection, objectId, params, RequestOptions.none())

    /** @see [listSubscriptions] */
    fun listSubscriptions(
        params: ObjectListSubscriptionsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ObjectListSubscriptionsPage

    /** @see [listSubscriptions] */
    fun listSubscriptions(params: ObjectListSubscriptionsParams): ObjectListSubscriptionsPage =
        listSubscriptions(params, RequestOptions.none())

    /** @see [listSubscriptions] */
    fun listSubscriptions(
        collection: String,
        objectId: String,
        requestOptions: RequestOptions,
    ): ObjectListSubscriptionsPage =
        listSubscriptions(
            collection,
            objectId,
            ObjectListSubscriptionsParams.none(),
            requestOptions,
        )

    /**
     * Creates a new object or updates an existing one in the specified collection. This operation
     * is used to identify objects with their properties, as well as optional preferences and
     * channel data.
     */
    fun set(collection: String, id: String): Object = set(collection, id, ObjectSetParams.none())

    /** @see [set] */
    fun set(
        collection: String,
        id: String,
        params: ObjectSetParams = ObjectSetParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Object = set(params.toBuilder().collection(collection).id(id).build(), requestOptions)

    /** @see [set] */
    fun set(
        collection: String,
        id: String,
        params: ObjectSetParams = ObjectSetParams.none(),
    ): Object = set(collection, id, params, RequestOptions.none())

    /** @see [set] */
    fun set(params: ObjectSetParams, requestOptions: RequestOptions = RequestOptions.none()): Object

    /** @see [set] */
    fun set(params: ObjectSetParams): Object = set(params, RequestOptions.none())

    /** @see [set] */
    fun set(collection: String, id: String, requestOptions: RequestOptions): Object =
        set(collection, id, ObjectSetParams.none(), requestOptions)

    /**
     * Sets the channel data for the specified object and channel. If no object exists in the
     * current environment for the given `collection` and `object_id`, Knock will create the object
     * as part of this request.
     */
    fun setChannelData(
        collection: String,
        objectId: String,
        channelId: String,
        params: ObjectSetChannelDataParams,
    ): ChannelData = setChannelData(collection, objectId, channelId, params, RequestOptions.none())

    /** @see [setChannelData] */
    fun setChannelData(
        collection: String,
        objectId: String,
        channelId: String,
        params: ObjectSetChannelDataParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ChannelData =
        setChannelData(
            params
                .toBuilder()
                .collection(collection)
                .objectId(objectId)
                .channelId(channelId)
                .build(),
            requestOptions,
        )

    /** @see [setChannelData] */
    fun setChannelData(params: ObjectSetChannelDataParams): ChannelData =
        setChannelData(params, RequestOptions.none())

    /** @see [setChannelData] */
    fun setChannelData(
        params: ObjectSetChannelDataParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ChannelData

    /**
     * Sets preferences within the given preference set. This is a destructive operation and will
     * replace any existing preferences with the preferences given. If no object exists in the
     * current environment for the given `:collection` and `:object_id`, Knock will create the
     * object as part of this request. The preference set `:id` can be either `default` or a
     * `tenant.id`. Learn more about [per-tenant preferences](/preferences/tenant-preferences).
     */
    fun setPreferences(
        collection: String,
        objectId: String,
        id: String,
        params: ObjectSetPreferencesParams,
    ): PreferenceSet = setPreferences(collection, objectId, id, params, RequestOptions.none())

    /** @see [setPreferences] */
    fun setPreferences(
        collection: String,
        objectId: String,
        id: String,
        params: ObjectSetPreferencesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PreferenceSet =
        setPreferences(
            params.toBuilder().collection(collection).objectId(objectId).id(id).build(),
            requestOptions,
        )

    /** @see [setPreferences] */
    fun setPreferences(params: ObjectSetPreferencesParams): PreferenceSet =
        setPreferences(params, RequestOptions.none())

    /** @see [setPreferences] */
    fun setPreferences(
        params: ObjectSetPreferencesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PreferenceSet

    /** Unsets the channel data for the specified object and channel. */
    fun unsetChannelData(collection: String, objectId: String, channelId: String): String =
        unsetChannelData(collection, objectId, channelId, ObjectUnsetChannelDataParams.none())

    /** @see [unsetChannelData] */
    fun unsetChannelData(
        collection: String,
        objectId: String,
        channelId: String,
        params: ObjectUnsetChannelDataParams = ObjectUnsetChannelDataParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): String =
        unsetChannelData(
            params
                .toBuilder()
                .collection(collection)
                .objectId(objectId)
                .channelId(channelId)
                .build(),
            requestOptions,
        )

    /** @see [unsetChannelData] */
    fun unsetChannelData(
        collection: String,
        objectId: String,
        channelId: String,
        params: ObjectUnsetChannelDataParams = ObjectUnsetChannelDataParams.none(),
    ): String = unsetChannelData(collection, objectId, channelId, params, RequestOptions.none())

    /** @see [unsetChannelData] */
    fun unsetChannelData(
        params: ObjectUnsetChannelDataParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): String

    /** @see [unsetChannelData] */
    fun unsetChannelData(params: ObjectUnsetChannelDataParams): String =
        unsetChannelData(params, RequestOptions.none())

    /** @see [unsetChannelData] */
    fun unsetChannelData(
        collection: String,
        objectId: String,
        channelId: String,
        requestOptions: RequestOptions,
    ): String =
        unsetChannelData(
            collection,
            objectId,
            channelId,
            ObjectUnsetChannelDataParams.none(),
            requestOptions,
        )

    /** A view of [ObjectService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ObjectService.WithRawResponse

        fun bulk(): BulkService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/objects/{collection}`, but is otherwise the same
         * as [ObjectService.list].
         */
        @MustBeClosed
        fun list(collection: String): HttpResponseFor<ObjectListPage> =
            list(collection, ObjectListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            collection: String,
            params: ObjectListParams = ObjectListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ObjectListPage> =
            list(params.toBuilder().collection(collection).build(), requestOptions)

        /** @see [list] */
        @MustBeClosed
        fun list(
            collection: String,
            params: ObjectListParams = ObjectListParams.none(),
        ): HttpResponseFor<ObjectListPage> = list(collection, params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: ObjectListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ObjectListPage>

        /** @see [list] */
        @MustBeClosed
        fun list(params: ObjectListParams): HttpResponseFor<ObjectListPage> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            collection: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ObjectListPage> =
            list(collection, ObjectListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/objects/{collection}/{id}`, but is otherwise
         * the same as [ObjectService.delete].
         */
        @MustBeClosed
        fun delete(collection: String, id: String): HttpResponseFor<String> =
            delete(collection, id, ObjectDeleteParams.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            collection: String,
            id: String,
            params: ObjectDeleteParams = ObjectDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<String> =
            delete(params.toBuilder().collection(collection).id(id).build(), requestOptions)

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            collection: String,
            id: String,
            params: ObjectDeleteParams = ObjectDeleteParams.none(),
        ): HttpResponseFor<String> = delete(collection, id, params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: ObjectDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<String>

        /** @see [delete] */
        @MustBeClosed
        fun delete(params: ObjectDeleteParams): HttpResponseFor<String> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            collection: String,
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<String> =
            delete(collection, id, ObjectDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post
         * /v1/objects/{collection}/{object_id}/subscriptions`, but is otherwise the same as
         * [ObjectService.addSubscriptions].
         */
        @MustBeClosed
        fun addSubscriptions(
            collection: String,
            objectId: String,
            params: ObjectAddSubscriptionsParams,
        ): HttpResponseFor<List<Subscription>> =
            addSubscriptions(collection, objectId, params, RequestOptions.none())

        /** @see [addSubscriptions] */
        @MustBeClosed
        fun addSubscriptions(
            collection: String,
            objectId: String,
            params: ObjectAddSubscriptionsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Subscription>> =
            addSubscriptions(
                params.toBuilder().collection(collection).objectId(objectId).build(),
                requestOptions,
            )

        /** @see [addSubscriptions] */
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
            collection: String,
            objectId: String,
            params: ObjectDeleteSubscriptionsParams,
        ): HttpResponseFor<List<Subscription>> =
            deleteSubscriptions(collection, objectId, params, RequestOptions.none())

        /** @see [deleteSubscriptions] */
        @MustBeClosed
        fun deleteSubscriptions(
            collection: String,
            objectId: String,
            params: ObjectDeleteSubscriptionsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Subscription>> =
            deleteSubscriptions(
                params.toBuilder().collection(collection).objectId(objectId).build(),
                requestOptions,
            )

        /** @see [deleteSubscriptions] */
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
         * Returns a raw HTTP response for `get /v1/objects/{collection}/{id}`, but is otherwise the
         * same as [ObjectService.get].
         */
        @MustBeClosed
        fun get(collection: String, id: String): HttpResponseFor<Object> =
            get(collection, id, ObjectGetParams.none())

        /** @see [get] */
        @MustBeClosed
        fun get(
            collection: String,
            id: String,
            params: ObjectGetParams = ObjectGetParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Object> =
            get(params.toBuilder().collection(collection).id(id).build(), requestOptions)

        /** @see [get] */
        @MustBeClosed
        fun get(
            collection: String,
            id: String,
            params: ObjectGetParams = ObjectGetParams.none(),
        ): HttpResponseFor<Object> = get(collection, id, params, RequestOptions.none())

        /** @see [get] */
        @MustBeClosed
        fun get(
            params: ObjectGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Object>

        /** @see [get] */
        @MustBeClosed
        fun get(params: ObjectGetParams): HttpResponseFor<Object> =
            get(params, RequestOptions.none())

        /** @see [get] */
        @MustBeClosed
        fun get(
            collection: String,
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Object> = get(collection, id, ObjectGetParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get
         * /v1/objects/{collection}/{object_id}/channel_data/{channel_id}`, but is otherwise the
         * same as [ObjectService.getChannelData].
         */
        @MustBeClosed
        fun getChannelData(
            collection: String,
            objectId: String,
            channelId: String,
        ): HttpResponseFor<ChannelData> =
            getChannelData(collection, objectId, channelId, ObjectGetChannelDataParams.none())

        /** @see [getChannelData] */
        @MustBeClosed
        fun getChannelData(
            collection: String,
            objectId: String,
            channelId: String,
            params: ObjectGetChannelDataParams = ObjectGetChannelDataParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ChannelData> =
            getChannelData(
                params
                    .toBuilder()
                    .collection(collection)
                    .objectId(objectId)
                    .channelId(channelId)
                    .build(),
                requestOptions,
            )

        /** @see [getChannelData] */
        @MustBeClosed
        fun getChannelData(
            collection: String,
            objectId: String,
            channelId: String,
            params: ObjectGetChannelDataParams = ObjectGetChannelDataParams.none(),
        ): HttpResponseFor<ChannelData> =
            getChannelData(collection, objectId, channelId, params, RequestOptions.none())

        /** @see [getChannelData] */
        @MustBeClosed
        fun getChannelData(
            params: ObjectGetChannelDataParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ChannelData>

        /** @see [getChannelData] */
        @MustBeClosed
        fun getChannelData(params: ObjectGetChannelDataParams): HttpResponseFor<ChannelData> =
            getChannelData(params, RequestOptions.none())

        /** @see [getChannelData] */
        @MustBeClosed
        fun getChannelData(
            collection: String,
            objectId: String,
            channelId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ChannelData> =
            getChannelData(
                collection,
                objectId,
                channelId,
                ObjectGetChannelDataParams.none(),
                requestOptions,
            )

        /**
         * Returns a raw HTTP response for `get
         * /v1/objects/{collection}/{object_id}/preferences/{id}`, but is otherwise the same as
         * [ObjectService.getPreferences].
         */
        @MustBeClosed
        fun getPreferences(
            collection: String,
            objectId: String,
            id: String,
        ): HttpResponseFor<PreferenceSet> =
            getPreferences(collection, objectId, id, ObjectGetPreferencesParams.none())

        /** @see [getPreferences] */
        @MustBeClosed
        fun getPreferences(
            collection: String,
            objectId: String,
            id: String,
            params: ObjectGetPreferencesParams = ObjectGetPreferencesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PreferenceSet> =
            getPreferences(
                params.toBuilder().collection(collection).objectId(objectId).id(id).build(),
                requestOptions,
            )

        /** @see [getPreferences] */
        @MustBeClosed
        fun getPreferences(
            collection: String,
            objectId: String,
            id: String,
            params: ObjectGetPreferencesParams = ObjectGetPreferencesParams.none(),
        ): HttpResponseFor<PreferenceSet> =
            getPreferences(collection, objectId, id, params, RequestOptions.none())

        /** @see [getPreferences] */
        @MustBeClosed
        fun getPreferences(
            params: ObjectGetPreferencesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PreferenceSet>

        /** @see [getPreferences] */
        @MustBeClosed
        fun getPreferences(params: ObjectGetPreferencesParams): HttpResponseFor<PreferenceSet> =
            getPreferences(params, RequestOptions.none())

        /** @see [getPreferences] */
        @MustBeClosed
        fun getPreferences(
            collection: String,
            objectId: String,
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PreferenceSet> =
            getPreferences(
                collection,
                objectId,
                id,
                ObjectGetPreferencesParams.none(),
                requestOptions,
            )

        /**
         * Returns a raw HTTP response for `get /v1/objects/{collection}/{id}/messages`, but is
         * otherwise the same as [ObjectService.listMessages].
         */
        @MustBeClosed
        fun listMessages(collection: String, id: String): HttpResponseFor<ObjectListMessagesPage> =
            listMessages(collection, id, ObjectListMessagesParams.none())

        /** @see [listMessages] */
        @MustBeClosed
        fun listMessages(
            collection: String,
            id: String,
            params: ObjectListMessagesParams = ObjectListMessagesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ObjectListMessagesPage> =
            listMessages(params.toBuilder().collection(collection).id(id).build(), requestOptions)

        /** @see [listMessages] */
        @MustBeClosed
        fun listMessages(
            collection: String,
            id: String,
            params: ObjectListMessagesParams = ObjectListMessagesParams.none(),
        ): HttpResponseFor<ObjectListMessagesPage> =
            listMessages(collection, id, params, RequestOptions.none())

        /** @see [listMessages] */
        @MustBeClosed
        fun listMessages(
            params: ObjectListMessagesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ObjectListMessagesPage>

        /** @see [listMessages] */
        @MustBeClosed
        fun listMessages(
            params: ObjectListMessagesParams
        ): HttpResponseFor<ObjectListMessagesPage> = listMessages(params, RequestOptions.none())

        /** @see [listMessages] */
        @MustBeClosed
        fun listMessages(
            collection: String,
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ObjectListMessagesPage> =
            listMessages(collection, id, ObjectListMessagesParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/objects/{collection}/{object_id}/preferences`,
         * but is otherwise the same as [ObjectService.listPreferences].
         */
        @MustBeClosed
        fun listPreferences(
            collection: String,
            objectId: String,
        ): HttpResponseFor<List<PreferenceSet>> =
            listPreferences(collection, objectId, ObjectListPreferencesParams.none())

        /** @see [listPreferences] */
        @MustBeClosed
        fun listPreferences(
            collection: String,
            objectId: String,
            params: ObjectListPreferencesParams = ObjectListPreferencesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<PreferenceSet>> =
            listPreferences(
                params.toBuilder().collection(collection).objectId(objectId).build(),
                requestOptions,
            )

        /** @see [listPreferences] */
        @MustBeClosed
        fun listPreferences(
            collection: String,
            objectId: String,
            params: ObjectListPreferencesParams = ObjectListPreferencesParams.none(),
        ): HttpResponseFor<List<PreferenceSet>> =
            listPreferences(collection, objectId, params, RequestOptions.none())

        /** @see [listPreferences] */
        @MustBeClosed
        fun listPreferences(
            params: ObjectListPreferencesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<PreferenceSet>>

        /** @see [listPreferences] */
        @MustBeClosed
        fun listPreferences(
            params: ObjectListPreferencesParams
        ): HttpResponseFor<List<PreferenceSet>> = listPreferences(params, RequestOptions.none())

        /** @see [listPreferences] */
        @MustBeClosed
        fun listPreferences(
            collection: String,
            objectId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<PreferenceSet>> =
            listPreferences(
                collection,
                objectId,
                ObjectListPreferencesParams.none(),
                requestOptions,
            )

        /**
         * Returns a raw HTTP response for `get /v1/objects/{collection}/{id}/schedules`, but is
         * otherwise the same as [ObjectService.listSchedules].
         */
        @MustBeClosed
        fun listSchedules(
            collection: String,
            id: String,
        ): HttpResponseFor<ObjectListSchedulesPage> =
            listSchedules(collection, id, ObjectListSchedulesParams.none())

        /** @see [listSchedules] */
        @MustBeClosed
        fun listSchedules(
            collection: String,
            id: String,
            params: ObjectListSchedulesParams = ObjectListSchedulesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ObjectListSchedulesPage> =
            listSchedules(params.toBuilder().collection(collection).id(id).build(), requestOptions)

        /** @see [listSchedules] */
        @MustBeClosed
        fun listSchedules(
            collection: String,
            id: String,
            params: ObjectListSchedulesParams = ObjectListSchedulesParams.none(),
        ): HttpResponseFor<ObjectListSchedulesPage> =
            listSchedules(collection, id, params, RequestOptions.none())

        /** @see [listSchedules] */
        @MustBeClosed
        fun listSchedules(
            params: ObjectListSchedulesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ObjectListSchedulesPage>

        /** @see [listSchedules] */
        @MustBeClosed
        fun listSchedules(
            params: ObjectListSchedulesParams
        ): HttpResponseFor<ObjectListSchedulesPage> = listSchedules(params, RequestOptions.none())

        /** @see [listSchedules] */
        @MustBeClosed
        fun listSchedules(
            collection: String,
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ObjectListSchedulesPage> =
            listSchedules(collection, id, ObjectListSchedulesParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/objects/{collection}/{object_id}/subscriptions`,
         * but is otherwise the same as [ObjectService.listSubscriptions].
         */
        @MustBeClosed
        fun listSubscriptions(
            collection: String,
            objectId: String,
        ): HttpResponseFor<ObjectListSubscriptionsPage> =
            listSubscriptions(collection, objectId, ObjectListSubscriptionsParams.none())

        /** @see [listSubscriptions] */
        @MustBeClosed
        fun listSubscriptions(
            collection: String,
            objectId: String,
            params: ObjectListSubscriptionsParams = ObjectListSubscriptionsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ObjectListSubscriptionsPage> =
            listSubscriptions(
                params.toBuilder().collection(collection).objectId(objectId).build(),
                requestOptions,
            )

        /** @see [listSubscriptions] */
        @MustBeClosed
        fun listSubscriptions(
            collection: String,
            objectId: String,
            params: ObjectListSubscriptionsParams = ObjectListSubscriptionsParams.none(),
        ): HttpResponseFor<ObjectListSubscriptionsPage> =
            listSubscriptions(collection, objectId, params, RequestOptions.none())

        /** @see [listSubscriptions] */
        @MustBeClosed
        fun listSubscriptions(
            params: ObjectListSubscriptionsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ObjectListSubscriptionsPage>

        /** @see [listSubscriptions] */
        @MustBeClosed
        fun listSubscriptions(
            params: ObjectListSubscriptionsParams
        ): HttpResponseFor<ObjectListSubscriptionsPage> =
            listSubscriptions(params, RequestOptions.none())

        /** @see [listSubscriptions] */
        @MustBeClosed
        fun listSubscriptions(
            collection: String,
            objectId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ObjectListSubscriptionsPage> =
            listSubscriptions(
                collection,
                objectId,
                ObjectListSubscriptionsParams.none(),
                requestOptions,
            )

        /**
         * Returns a raw HTTP response for `put /v1/objects/{collection}/{id}`, but is otherwise the
         * same as [ObjectService.set].
         */
        @MustBeClosed
        fun set(collection: String, id: String): HttpResponseFor<Object> =
            set(collection, id, ObjectSetParams.none())

        /** @see [set] */
        @MustBeClosed
        fun set(
            collection: String,
            id: String,
            params: ObjectSetParams = ObjectSetParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Object> =
            set(params.toBuilder().collection(collection).id(id).build(), requestOptions)

        /** @see [set] */
        @MustBeClosed
        fun set(
            collection: String,
            id: String,
            params: ObjectSetParams = ObjectSetParams.none(),
        ): HttpResponseFor<Object> = set(collection, id, params, RequestOptions.none())

        /** @see [set] */
        @MustBeClosed
        fun set(
            params: ObjectSetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Object>

        /** @see [set] */
        @MustBeClosed
        fun set(params: ObjectSetParams): HttpResponseFor<Object> =
            set(params, RequestOptions.none())

        /** @see [set] */
        @MustBeClosed
        fun set(
            collection: String,
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Object> = set(collection, id, ObjectSetParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put
         * /v1/objects/{collection}/{object_id}/channel_data/{channel_id}`, but is otherwise the
         * same as [ObjectService.setChannelData].
         */
        @MustBeClosed
        fun setChannelData(
            collection: String,
            objectId: String,
            channelId: String,
            params: ObjectSetChannelDataParams,
        ): HttpResponseFor<ChannelData> =
            setChannelData(collection, objectId, channelId, params, RequestOptions.none())

        /** @see [setChannelData] */
        @MustBeClosed
        fun setChannelData(
            collection: String,
            objectId: String,
            channelId: String,
            params: ObjectSetChannelDataParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ChannelData> =
            setChannelData(
                params
                    .toBuilder()
                    .collection(collection)
                    .objectId(objectId)
                    .channelId(channelId)
                    .build(),
                requestOptions,
            )

        /** @see [setChannelData] */
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
         * Returns a raw HTTP response for `put
         * /v1/objects/{collection}/{object_id}/preferences/{id}`, but is otherwise the same as
         * [ObjectService.setPreferences].
         */
        @MustBeClosed
        fun setPreferences(
            collection: String,
            objectId: String,
            id: String,
            params: ObjectSetPreferencesParams,
        ): HttpResponseFor<PreferenceSet> =
            setPreferences(collection, objectId, id, params, RequestOptions.none())

        /** @see [setPreferences] */
        @MustBeClosed
        fun setPreferences(
            collection: String,
            objectId: String,
            id: String,
            params: ObjectSetPreferencesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PreferenceSet> =
            setPreferences(
                params.toBuilder().collection(collection).objectId(objectId).id(id).build(),
                requestOptions,
            )

        /** @see [setPreferences] */
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
        fun unsetChannelData(
            collection: String,
            objectId: String,
            channelId: String,
        ): HttpResponseFor<String> =
            unsetChannelData(collection, objectId, channelId, ObjectUnsetChannelDataParams.none())

        /** @see [unsetChannelData] */
        @MustBeClosed
        fun unsetChannelData(
            collection: String,
            objectId: String,
            channelId: String,
            params: ObjectUnsetChannelDataParams = ObjectUnsetChannelDataParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<String> =
            unsetChannelData(
                params
                    .toBuilder()
                    .collection(collection)
                    .objectId(objectId)
                    .channelId(channelId)
                    .build(),
                requestOptions,
            )

        /** @see [unsetChannelData] */
        @MustBeClosed
        fun unsetChannelData(
            collection: String,
            objectId: String,
            channelId: String,
            params: ObjectUnsetChannelDataParams = ObjectUnsetChannelDataParams.none(),
        ): HttpResponseFor<String> =
            unsetChannelData(collection, objectId, channelId, params, RequestOptions.none())

        /** @see [unsetChannelData] */
        @MustBeClosed
        fun unsetChannelData(
            params: ObjectUnsetChannelDataParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<String>

        /** @see [unsetChannelData] */
        @MustBeClosed
        fun unsetChannelData(params: ObjectUnsetChannelDataParams): HttpResponseFor<String> =
            unsetChannelData(params, RequestOptions.none())

        /** @see [unsetChannelData] */
        @MustBeClosed
        fun unsetChannelData(
            collection: String,
            objectId: String,
            channelId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<String> =
            unsetChannelData(
                collection,
                objectId,
                channelId,
                ObjectUnsetChannelDataParams.none(),
                requestOptions,
            )
    }
}
