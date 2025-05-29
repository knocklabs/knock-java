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
import app.knock.api.models.objects.ObjectListPreferencesParams
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
import java.util.concurrent.CompletableFuture

interface ObjectServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun bulk(): BulkServiceAsync

    /**
     * Returns a paginated list of objects from the specified collection. Optionally includes
     * preference data for the objects.
     */
    fun list(collection: String): CompletableFuture<ObjectListPageAsync> =
        list(collection, ObjectListParams.none())

    /** @see [list] */
    fun list(
        collection: String,
        params: ObjectListParams = ObjectListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ObjectListPageAsync> =
        list(params.toBuilder().collection(collection).build(), requestOptions)

    /** @see [list] */
    fun list(
        collection: String,
        params: ObjectListParams = ObjectListParams.none(),
    ): CompletableFuture<ObjectListPageAsync> = list(collection, params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: ObjectListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ObjectListPageAsync>

    /** @see [list] */
    fun list(params: ObjectListParams): CompletableFuture<ObjectListPageAsync> =
        list(params, RequestOptions.none())

    /** @see [list] */
    fun list(
        collection: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ObjectListPageAsync> =
        list(collection, ObjectListParams.none(), requestOptions)

    /**
     * Permanently removes an object from the specified collection. This operation cannot be undone.
     */
    fun delete(collection: String, id: String): CompletableFuture<String> =
        delete(collection, id, ObjectDeleteParams.none())

    /** @see [delete] */
    fun delete(
        collection: String,
        id: String,
        params: ObjectDeleteParams = ObjectDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<String> =
        delete(params.toBuilder().collection(collection).id(id).build(), requestOptions)

    /** @see [delete] */
    fun delete(
        collection: String,
        id: String,
        params: ObjectDeleteParams = ObjectDeleteParams.none(),
    ): CompletableFuture<String> = delete(collection, id, params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: ObjectDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<String>

    /** @see [delete] */
    fun delete(params: ObjectDeleteParams): CompletableFuture<String> =
        delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        collection: String,
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<String> = delete(collection, id, ObjectDeleteParams.none(), requestOptions)

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
    ): CompletableFuture<List<Subscription>> =
        addSubscriptions(collection, objectId, params, RequestOptions.none())

    /** @see [addSubscriptions] */
    fun addSubscriptions(
        collection: String,
        objectId: String,
        params: ObjectAddSubscriptionsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Subscription>> =
        addSubscriptions(
            params.toBuilder().collection(collection).objectId(objectId).build(),
            requestOptions,
        )

    /** @see [addSubscriptions] */
    fun addSubscriptions(
        params: ObjectAddSubscriptionsParams
    ): CompletableFuture<List<Subscription>> = addSubscriptions(params, RequestOptions.none())

    /** @see [addSubscriptions] */
    fun addSubscriptions(
        params: ObjectAddSubscriptionsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Subscription>>

    /**
     * Delete subscriptions for the specified recipients from an object. Returns the list of deleted
     * subscriptions.
     */
    fun deleteSubscriptions(
        collection: String,
        objectId: String,
        params: ObjectDeleteSubscriptionsParams,
    ): CompletableFuture<List<Subscription>> =
        deleteSubscriptions(collection, objectId, params, RequestOptions.none())

    /** @see [deleteSubscriptions] */
    fun deleteSubscriptions(
        collection: String,
        objectId: String,
        params: ObjectDeleteSubscriptionsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Subscription>> =
        deleteSubscriptions(
            params.toBuilder().collection(collection).objectId(objectId).build(),
            requestOptions,
        )

    /** @see [deleteSubscriptions] */
    fun deleteSubscriptions(
        params: ObjectDeleteSubscriptionsParams
    ): CompletableFuture<List<Subscription>> = deleteSubscriptions(params, RequestOptions.none())

    /** @see [deleteSubscriptions] */
    fun deleteSubscriptions(
        params: ObjectDeleteSubscriptionsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Subscription>>

    /**
     * Retrieves a specific object by its ID from the specified collection. Returns the object with
     * all its properties.
     */
    fun get(collection: String, id: String): CompletableFuture<Object> =
        get(collection, id, ObjectGetParams.none())

    /** @see [get] */
    fun get(
        collection: String,
        id: String,
        params: ObjectGetParams = ObjectGetParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Object> =
        get(params.toBuilder().collection(collection).id(id).build(), requestOptions)

    /** @see [get] */
    fun get(
        collection: String,
        id: String,
        params: ObjectGetParams = ObjectGetParams.none(),
    ): CompletableFuture<Object> = get(collection, id, params, RequestOptions.none())

    /** @see [get] */
    fun get(
        params: ObjectGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Object>

    /** @see [get] */
    fun get(params: ObjectGetParams): CompletableFuture<Object> = get(params, RequestOptions.none())

    /** @see [get] */
    fun get(
        collection: String,
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<Object> = get(collection, id, ObjectGetParams.none(), requestOptions)

    /** Returns the channel data for the specified object and channel. */
    fun getChannelData(
        collection: String,
        objectId: String,
        channelId: String,
    ): CompletableFuture<ChannelData> =
        getChannelData(collection, objectId, channelId, ObjectGetChannelDataParams.none())

    /** @see [getChannelData] */
    fun getChannelData(
        collection: String,
        objectId: String,
        channelId: String,
        params: ObjectGetChannelDataParams = ObjectGetChannelDataParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ChannelData> =
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
    ): CompletableFuture<ChannelData> =
        getChannelData(collection, objectId, channelId, params, RequestOptions.none())

    /** @see [getChannelData] */
    fun getChannelData(
        params: ObjectGetChannelDataParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ChannelData>

    /** @see [getChannelData] */
    fun getChannelData(params: ObjectGetChannelDataParams): CompletableFuture<ChannelData> =
        getChannelData(params, RequestOptions.none())

    /** @see [getChannelData] */
    fun getChannelData(
        collection: String,
        objectId: String,
        channelId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ChannelData> =
        getChannelData(
            collection,
            objectId,
            channelId,
            ObjectGetChannelDataParams.none(),
            requestOptions,
        )

    /** Returns the preference set for the specified object and preference set `id`. */
    fun getPreferences(
        collection: String,
        objectId: String,
        id: String,
    ): CompletableFuture<PreferenceSet> =
        getPreferences(collection, objectId, id, ObjectGetPreferencesParams.none())

    /** @see [getPreferences] */
    fun getPreferences(
        collection: String,
        objectId: String,
        id: String,
        params: ObjectGetPreferencesParams = ObjectGetPreferencesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PreferenceSet> =
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
    ): CompletableFuture<PreferenceSet> =
        getPreferences(collection, objectId, id, params, RequestOptions.none())

    /** @see [getPreferences] */
    fun getPreferences(
        params: ObjectGetPreferencesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PreferenceSet>

    /** @see [getPreferences] */
    fun getPreferences(params: ObjectGetPreferencesParams): CompletableFuture<PreferenceSet> =
        getPreferences(params, RequestOptions.none())

    /** @see [getPreferences] */
    fun getPreferences(
        collection: String,
        objectId: String,
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<PreferenceSet> =
        getPreferences(collection, objectId, id, ObjectGetPreferencesParams.none(), requestOptions)

    /**
     * Returns a paginated list of messages for a specific object in the given collection. Allows
     * filtering by message status and provides various sorting options.
     */
    fun listMessages(
        collection: String,
        id: String,
    ): CompletableFuture<ObjectListMessagesPageAsync> =
        listMessages(collection, id, ObjectListMessagesParams.none())

    /** @see [listMessages] */
    fun listMessages(
        collection: String,
        id: String,
        params: ObjectListMessagesParams = ObjectListMessagesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ObjectListMessagesPageAsync> =
        listMessages(params.toBuilder().collection(collection).id(id).build(), requestOptions)

    /** @see [listMessages] */
    fun listMessages(
        collection: String,
        id: String,
        params: ObjectListMessagesParams = ObjectListMessagesParams.none(),
    ): CompletableFuture<ObjectListMessagesPageAsync> =
        listMessages(collection, id, params, RequestOptions.none())

    /** @see [listMessages] */
    fun listMessages(
        params: ObjectListMessagesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ObjectListMessagesPageAsync>

    /** @see [listMessages] */
    fun listMessages(
        params: ObjectListMessagesParams
    ): CompletableFuture<ObjectListMessagesPageAsync> = listMessages(params, RequestOptions.none())

    /** @see [listMessages] */
    fun listMessages(
        collection: String,
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ObjectListMessagesPageAsync> =
        listMessages(collection, id, ObjectListMessagesParams.none(), requestOptions)

    /** Returns a paginated list of preference sets for the specified object. */
    fun listPreferences(
        collection: String,
        objectId: String,
    ): CompletableFuture<List<PreferenceSet>> =
        listPreferences(collection, objectId, ObjectListPreferencesParams.none())

    /** @see [listPreferences] */
    fun listPreferences(
        collection: String,
        objectId: String,
        params: ObjectListPreferencesParams = ObjectListPreferencesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<PreferenceSet>> =
        listPreferences(
            params.toBuilder().collection(collection).objectId(objectId).build(),
            requestOptions,
        )

    /** @see [listPreferences] */
    fun listPreferences(
        collection: String,
        objectId: String,
        params: ObjectListPreferencesParams = ObjectListPreferencesParams.none(),
    ): CompletableFuture<List<PreferenceSet>> =
        listPreferences(collection, objectId, params, RequestOptions.none())

    /** @see [listPreferences] */
    fun listPreferences(
        params: ObjectListPreferencesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<PreferenceSet>>

    /** @see [listPreferences] */
    fun listPreferences(
        params: ObjectListPreferencesParams
    ): CompletableFuture<List<PreferenceSet>> = listPreferences(params, RequestOptions.none())

    /** @see [listPreferences] */
    fun listPreferences(
        collection: String,
        objectId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<PreferenceSet>> =
        listPreferences(collection, objectId, ObjectListPreferencesParams.none(), requestOptions)

    /** Returns a paginated list of schedules for an object. */
    fun listSchedules(
        collection: String,
        id: String,
    ): CompletableFuture<ObjectListSchedulesPageAsync> =
        listSchedules(collection, id, ObjectListSchedulesParams.none())

    /** @see [listSchedules] */
    fun listSchedules(
        collection: String,
        id: String,
        params: ObjectListSchedulesParams = ObjectListSchedulesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ObjectListSchedulesPageAsync> =
        listSchedules(params.toBuilder().collection(collection).id(id).build(), requestOptions)

    /** @see [listSchedules] */
    fun listSchedules(
        collection: String,
        id: String,
        params: ObjectListSchedulesParams = ObjectListSchedulesParams.none(),
    ): CompletableFuture<ObjectListSchedulesPageAsync> =
        listSchedules(collection, id, params, RequestOptions.none())

    /** @see [listSchedules] */
    fun listSchedules(
        params: ObjectListSchedulesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ObjectListSchedulesPageAsync>

    /** @see [listSchedules] */
    fun listSchedules(
        params: ObjectListSchedulesParams
    ): CompletableFuture<ObjectListSchedulesPageAsync> =
        listSchedules(params, RequestOptions.none())

    /** @see [listSchedules] */
    fun listSchedules(
        collection: String,
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ObjectListSchedulesPageAsync> =
        listSchedules(collection, id, ObjectListSchedulesParams.none(), requestOptions)

    /**
     * List subscriptions for an object. Either list the recipients that subscribe to the provided
     * object, or list the objects that the provided object is subscribed to. Determined by the
     * `mode` query parameter.
     */
    fun listSubscriptions(
        collection: String,
        objectId: String,
    ): CompletableFuture<ObjectListSubscriptionsPageAsync> =
        listSubscriptions(collection, objectId, ObjectListSubscriptionsParams.none())

    /** @see [listSubscriptions] */
    fun listSubscriptions(
        collection: String,
        objectId: String,
        params: ObjectListSubscriptionsParams = ObjectListSubscriptionsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ObjectListSubscriptionsPageAsync> =
        listSubscriptions(
            params.toBuilder().collection(collection).objectId(objectId).build(),
            requestOptions,
        )

    /** @see [listSubscriptions] */
    fun listSubscriptions(
        collection: String,
        objectId: String,
        params: ObjectListSubscriptionsParams = ObjectListSubscriptionsParams.none(),
    ): CompletableFuture<ObjectListSubscriptionsPageAsync> =
        listSubscriptions(collection, objectId, params, RequestOptions.none())

    /** @see [listSubscriptions] */
    fun listSubscriptions(
        params: ObjectListSubscriptionsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ObjectListSubscriptionsPageAsync>

    /** @see [listSubscriptions] */
    fun listSubscriptions(
        params: ObjectListSubscriptionsParams
    ): CompletableFuture<ObjectListSubscriptionsPageAsync> =
        listSubscriptions(params, RequestOptions.none())

    /** @see [listSubscriptions] */
    fun listSubscriptions(
        collection: String,
        objectId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ObjectListSubscriptionsPageAsync> =
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
    fun set(collection: String, id: String): CompletableFuture<Object> =
        set(collection, id, ObjectSetParams.none())

    /** @see [set] */
    fun set(
        collection: String,
        id: String,
        params: ObjectSetParams = ObjectSetParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Object> =
        set(params.toBuilder().collection(collection).id(id).build(), requestOptions)

    /** @see [set] */
    fun set(
        collection: String,
        id: String,
        params: ObjectSetParams = ObjectSetParams.none(),
    ): CompletableFuture<Object> = set(collection, id, params, RequestOptions.none())

    /** @see [set] */
    fun set(
        params: ObjectSetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Object>

    /** @see [set] */
    fun set(params: ObjectSetParams): CompletableFuture<Object> = set(params, RequestOptions.none())

    /** @see [set] */
    fun set(
        collection: String,
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<Object> = set(collection, id, ObjectSetParams.none(), requestOptions)

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
    ): CompletableFuture<ChannelData> =
        setChannelData(collection, objectId, channelId, params, RequestOptions.none())

    /** @see [setChannelData] */
    fun setChannelData(
        collection: String,
        objectId: String,
        channelId: String,
        params: ObjectSetChannelDataParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ChannelData> =
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
    fun setChannelData(params: ObjectSetChannelDataParams): CompletableFuture<ChannelData> =
        setChannelData(params, RequestOptions.none())

    /** @see [setChannelData] */
    fun setChannelData(
        params: ObjectSetChannelDataParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ChannelData>

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
    ): CompletableFuture<PreferenceSet> =
        setPreferences(collection, objectId, id, params, RequestOptions.none())

    /** @see [setPreferences] */
    fun setPreferences(
        collection: String,
        objectId: String,
        id: String,
        params: ObjectSetPreferencesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PreferenceSet> =
        setPreferences(
            params.toBuilder().collection(collection).objectId(objectId).id(id).build(),
            requestOptions,
        )

    /** @see [setPreferences] */
    fun setPreferences(params: ObjectSetPreferencesParams): CompletableFuture<PreferenceSet> =
        setPreferences(params, RequestOptions.none())

    /** @see [setPreferences] */
    fun setPreferences(
        params: ObjectSetPreferencesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PreferenceSet>

    /** Unsets the channel data for the specified object and channel. */
    fun unsetChannelData(
        collection: String,
        objectId: String,
        channelId: String,
    ): CompletableFuture<String> =
        unsetChannelData(collection, objectId, channelId, ObjectUnsetChannelDataParams.none())

    /** @see [unsetChannelData] */
    fun unsetChannelData(
        collection: String,
        objectId: String,
        channelId: String,
        params: ObjectUnsetChannelDataParams = ObjectUnsetChannelDataParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<String> =
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
    ): CompletableFuture<String> =
        unsetChannelData(collection, objectId, channelId, params, RequestOptions.none())

    /** @see [unsetChannelData] */
    fun unsetChannelData(
        params: ObjectUnsetChannelDataParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<String>

    /** @see [unsetChannelData] */
    fun unsetChannelData(params: ObjectUnsetChannelDataParams): CompletableFuture<String> =
        unsetChannelData(params, RequestOptions.none())

    /** @see [unsetChannelData] */
    fun unsetChannelData(
        collection: String,
        objectId: String,
        channelId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<String> =
        unsetChannelData(
            collection,
            objectId,
            channelId,
            ObjectUnsetChannelDataParams.none(),
            requestOptions,
        )

    /**
     * A view of [ObjectServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        fun bulk(): BulkServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/objects/{collection}`, but is otherwise the same
         * as [ObjectServiceAsync.list].
         */
        fun list(collection: String): CompletableFuture<HttpResponseFor<ObjectListPageAsync>> =
            list(collection, ObjectListParams.none())

        /** @see [list] */
        fun list(
            collection: String,
            params: ObjectListParams = ObjectListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ObjectListPageAsync>> =
            list(params.toBuilder().collection(collection).build(), requestOptions)

        /** @see [list] */
        fun list(
            collection: String,
            params: ObjectListParams = ObjectListParams.none(),
        ): CompletableFuture<HttpResponseFor<ObjectListPageAsync>> =
            list(collection, params, RequestOptions.none())

        /** @see [list] */
        fun list(
            params: ObjectListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ObjectListPageAsync>>

        /** @see [list] */
        fun list(
            params: ObjectListParams
        ): CompletableFuture<HttpResponseFor<ObjectListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        fun list(
            collection: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ObjectListPageAsync>> =
            list(collection, ObjectListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/objects/{collection}/{id}`, but is otherwise
         * the same as [ObjectServiceAsync.delete].
         */
        fun delete(collection: String, id: String): CompletableFuture<HttpResponseFor<String>> =
            delete(collection, id, ObjectDeleteParams.none())

        /** @see [delete] */
        fun delete(
            collection: String,
            id: String,
            params: ObjectDeleteParams = ObjectDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<String>> =
            delete(params.toBuilder().collection(collection).id(id).build(), requestOptions)

        /** @see [delete] */
        fun delete(
            collection: String,
            id: String,
            params: ObjectDeleteParams = ObjectDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<String>> =
            delete(collection, id, params, RequestOptions.none())

        /** @see [delete] */
        fun delete(
            params: ObjectDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<String>>

        /** @see [delete] */
        fun delete(params: ObjectDeleteParams): CompletableFuture<HttpResponseFor<String>> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        fun delete(
            collection: String,
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<String>> =
            delete(collection, id, ObjectDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post
         * /v1/objects/{collection}/{object_id}/subscriptions`, but is otherwise the same as
         * [ObjectServiceAsync.addSubscriptions].
         */
        fun addSubscriptions(
            collection: String,
            objectId: String,
            params: ObjectAddSubscriptionsParams,
        ): CompletableFuture<HttpResponseFor<List<Subscription>>> =
            addSubscriptions(collection, objectId, params, RequestOptions.none())

        /** @see [addSubscriptions] */
        fun addSubscriptions(
            collection: String,
            objectId: String,
            params: ObjectAddSubscriptionsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Subscription>>> =
            addSubscriptions(
                params.toBuilder().collection(collection).objectId(objectId).build(),
                requestOptions,
            )

        /** @see [addSubscriptions] */
        fun addSubscriptions(
            params: ObjectAddSubscriptionsParams
        ): CompletableFuture<HttpResponseFor<List<Subscription>>> =
            addSubscriptions(params, RequestOptions.none())

        /** @see [addSubscriptions] */
        fun addSubscriptions(
            params: ObjectAddSubscriptionsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Subscription>>>

        /**
         * Returns a raw HTTP response for `delete
         * /v1/objects/{collection}/{object_id}/subscriptions`, but is otherwise the same as
         * [ObjectServiceAsync.deleteSubscriptions].
         */
        fun deleteSubscriptions(
            collection: String,
            objectId: String,
            params: ObjectDeleteSubscriptionsParams,
        ): CompletableFuture<HttpResponseFor<List<Subscription>>> =
            deleteSubscriptions(collection, objectId, params, RequestOptions.none())

        /** @see [deleteSubscriptions] */
        fun deleteSubscriptions(
            collection: String,
            objectId: String,
            params: ObjectDeleteSubscriptionsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Subscription>>> =
            deleteSubscriptions(
                params.toBuilder().collection(collection).objectId(objectId).build(),
                requestOptions,
            )

        /** @see [deleteSubscriptions] */
        fun deleteSubscriptions(
            params: ObjectDeleteSubscriptionsParams
        ): CompletableFuture<HttpResponseFor<List<Subscription>>> =
            deleteSubscriptions(params, RequestOptions.none())

        /** @see [deleteSubscriptions] */
        fun deleteSubscriptions(
            params: ObjectDeleteSubscriptionsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Subscription>>>

        /**
         * Returns a raw HTTP response for `get /v1/objects/{collection}/{id}`, but is otherwise the
         * same as [ObjectServiceAsync.get].
         */
        fun get(collection: String, id: String): CompletableFuture<HttpResponseFor<Object>> =
            get(collection, id, ObjectGetParams.none())

        /** @see [get] */
        fun get(
            collection: String,
            id: String,
            params: ObjectGetParams = ObjectGetParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Object>> =
            get(params.toBuilder().collection(collection).id(id).build(), requestOptions)

        /** @see [get] */
        fun get(
            collection: String,
            id: String,
            params: ObjectGetParams = ObjectGetParams.none(),
        ): CompletableFuture<HttpResponseFor<Object>> =
            get(collection, id, params, RequestOptions.none())

        /** @see [get] */
        fun get(
            params: ObjectGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Object>>

        /** @see [get] */
        fun get(params: ObjectGetParams): CompletableFuture<HttpResponseFor<Object>> =
            get(params, RequestOptions.none())

        /** @see [get] */
        fun get(
            collection: String,
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Object>> =
            get(collection, id, ObjectGetParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get
         * /v1/objects/{collection}/{object_id}/channel_data/{channel_id}`, but is otherwise the
         * same as [ObjectServiceAsync.getChannelData].
         */
        fun getChannelData(
            collection: String,
            objectId: String,
            channelId: String,
        ): CompletableFuture<HttpResponseFor<ChannelData>> =
            getChannelData(collection, objectId, channelId, ObjectGetChannelDataParams.none())

        /** @see [getChannelData] */
        fun getChannelData(
            collection: String,
            objectId: String,
            channelId: String,
            params: ObjectGetChannelDataParams = ObjectGetChannelDataParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ChannelData>> =
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
        ): CompletableFuture<HttpResponseFor<ChannelData>> =
            getChannelData(collection, objectId, channelId, params, RequestOptions.none())

        /** @see [getChannelData] */
        fun getChannelData(
            params: ObjectGetChannelDataParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ChannelData>>

        /** @see [getChannelData] */
        fun getChannelData(
            params: ObjectGetChannelDataParams
        ): CompletableFuture<HttpResponseFor<ChannelData>> =
            getChannelData(params, RequestOptions.none())

        /** @see [getChannelData] */
        fun getChannelData(
            collection: String,
            objectId: String,
            channelId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ChannelData>> =
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
         * [ObjectServiceAsync.getPreferences].
         */
        fun getPreferences(
            collection: String,
            objectId: String,
            id: String,
        ): CompletableFuture<HttpResponseFor<PreferenceSet>> =
            getPreferences(collection, objectId, id, ObjectGetPreferencesParams.none())

        /** @see [getPreferences] */
        fun getPreferences(
            collection: String,
            objectId: String,
            id: String,
            params: ObjectGetPreferencesParams = ObjectGetPreferencesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PreferenceSet>> =
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
        ): CompletableFuture<HttpResponseFor<PreferenceSet>> =
            getPreferences(collection, objectId, id, params, RequestOptions.none())

        /** @see [getPreferences] */
        fun getPreferences(
            params: ObjectGetPreferencesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PreferenceSet>>

        /** @see [getPreferences] */
        fun getPreferences(
            params: ObjectGetPreferencesParams
        ): CompletableFuture<HttpResponseFor<PreferenceSet>> =
            getPreferences(params, RequestOptions.none())

        /** @see [getPreferences] */
        fun getPreferences(
            collection: String,
            objectId: String,
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PreferenceSet>> =
            getPreferences(
                collection,
                objectId,
                id,
                ObjectGetPreferencesParams.none(),
                requestOptions,
            )

        /**
         * Returns a raw HTTP response for `get /v1/objects/{collection}/{id}/messages`, but is
         * otherwise the same as [ObjectServiceAsync.listMessages].
         */
        fun listMessages(
            collection: String,
            id: String,
        ): CompletableFuture<HttpResponseFor<ObjectListMessagesPageAsync>> =
            listMessages(collection, id, ObjectListMessagesParams.none())

        /** @see [listMessages] */
        fun listMessages(
            collection: String,
            id: String,
            params: ObjectListMessagesParams = ObjectListMessagesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ObjectListMessagesPageAsync>> =
            listMessages(params.toBuilder().collection(collection).id(id).build(), requestOptions)

        /** @see [listMessages] */
        fun listMessages(
            collection: String,
            id: String,
            params: ObjectListMessagesParams = ObjectListMessagesParams.none(),
        ): CompletableFuture<HttpResponseFor<ObjectListMessagesPageAsync>> =
            listMessages(collection, id, params, RequestOptions.none())

        /** @see [listMessages] */
        fun listMessages(
            params: ObjectListMessagesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ObjectListMessagesPageAsync>>

        /** @see [listMessages] */
        fun listMessages(
            params: ObjectListMessagesParams
        ): CompletableFuture<HttpResponseFor<ObjectListMessagesPageAsync>> =
            listMessages(params, RequestOptions.none())

        /** @see [listMessages] */
        fun listMessages(
            collection: String,
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ObjectListMessagesPageAsync>> =
            listMessages(collection, id, ObjectListMessagesParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/objects/{collection}/{object_id}/preferences`,
         * but is otherwise the same as [ObjectServiceAsync.listPreferences].
         */
        fun listPreferences(
            collection: String,
            objectId: String,
        ): CompletableFuture<HttpResponseFor<List<PreferenceSet>>> =
            listPreferences(collection, objectId, ObjectListPreferencesParams.none())

        /** @see [listPreferences] */
        fun listPreferences(
            collection: String,
            objectId: String,
            params: ObjectListPreferencesParams = ObjectListPreferencesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<PreferenceSet>>> =
            listPreferences(
                params.toBuilder().collection(collection).objectId(objectId).build(),
                requestOptions,
            )

        /** @see [listPreferences] */
        fun listPreferences(
            collection: String,
            objectId: String,
            params: ObjectListPreferencesParams = ObjectListPreferencesParams.none(),
        ): CompletableFuture<HttpResponseFor<List<PreferenceSet>>> =
            listPreferences(collection, objectId, params, RequestOptions.none())

        /** @see [listPreferences] */
        fun listPreferences(
            params: ObjectListPreferencesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<PreferenceSet>>>

        /** @see [listPreferences] */
        fun listPreferences(
            params: ObjectListPreferencesParams
        ): CompletableFuture<HttpResponseFor<List<PreferenceSet>>> =
            listPreferences(params, RequestOptions.none())

        /** @see [listPreferences] */
        fun listPreferences(
            collection: String,
            objectId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<PreferenceSet>>> =
            listPreferences(
                collection,
                objectId,
                ObjectListPreferencesParams.none(),
                requestOptions,
            )

        /**
         * Returns a raw HTTP response for `get /v1/objects/{collection}/{id}/schedules`, but is
         * otherwise the same as [ObjectServiceAsync.listSchedules].
         */
        fun listSchedules(
            collection: String,
            id: String,
        ): CompletableFuture<HttpResponseFor<ObjectListSchedulesPageAsync>> =
            listSchedules(collection, id, ObjectListSchedulesParams.none())

        /** @see [listSchedules] */
        fun listSchedules(
            collection: String,
            id: String,
            params: ObjectListSchedulesParams = ObjectListSchedulesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ObjectListSchedulesPageAsync>> =
            listSchedules(params.toBuilder().collection(collection).id(id).build(), requestOptions)

        /** @see [listSchedules] */
        fun listSchedules(
            collection: String,
            id: String,
            params: ObjectListSchedulesParams = ObjectListSchedulesParams.none(),
        ): CompletableFuture<HttpResponseFor<ObjectListSchedulesPageAsync>> =
            listSchedules(collection, id, params, RequestOptions.none())

        /** @see [listSchedules] */
        fun listSchedules(
            params: ObjectListSchedulesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ObjectListSchedulesPageAsync>>

        /** @see [listSchedules] */
        fun listSchedules(
            params: ObjectListSchedulesParams
        ): CompletableFuture<HttpResponseFor<ObjectListSchedulesPageAsync>> =
            listSchedules(params, RequestOptions.none())

        /** @see [listSchedules] */
        fun listSchedules(
            collection: String,
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ObjectListSchedulesPageAsync>> =
            listSchedules(collection, id, ObjectListSchedulesParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/objects/{collection}/{object_id}/subscriptions`,
         * but is otherwise the same as [ObjectServiceAsync.listSubscriptions].
         */
        fun listSubscriptions(
            collection: String,
            objectId: String,
        ): CompletableFuture<HttpResponseFor<ObjectListSubscriptionsPageAsync>> =
            listSubscriptions(collection, objectId, ObjectListSubscriptionsParams.none())

        /** @see [listSubscriptions] */
        fun listSubscriptions(
            collection: String,
            objectId: String,
            params: ObjectListSubscriptionsParams = ObjectListSubscriptionsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ObjectListSubscriptionsPageAsync>> =
            listSubscriptions(
                params.toBuilder().collection(collection).objectId(objectId).build(),
                requestOptions,
            )

        /** @see [listSubscriptions] */
        fun listSubscriptions(
            collection: String,
            objectId: String,
            params: ObjectListSubscriptionsParams = ObjectListSubscriptionsParams.none(),
        ): CompletableFuture<HttpResponseFor<ObjectListSubscriptionsPageAsync>> =
            listSubscriptions(collection, objectId, params, RequestOptions.none())

        /** @see [listSubscriptions] */
        fun listSubscriptions(
            params: ObjectListSubscriptionsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ObjectListSubscriptionsPageAsync>>

        /** @see [listSubscriptions] */
        fun listSubscriptions(
            params: ObjectListSubscriptionsParams
        ): CompletableFuture<HttpResponseFor<ObjectListSubscriptionsPageAsync>> =
            listSubscriptions(params, RequestOptions.none())

        /** @see [listSubscriptions] */
        fun listSubscriptions(
            collection: String,
            objectId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ObjectListSubscriptionsPageAsync>> =
            listSubscriptions(
                collection,
                objectId,
                ObjectListSubscriptionsParams.none(),
                requestOptions,
            )

        /**
         * Returns a raw HTTP response for `put /v1/objects/{collection}/{id}`, but is otherwise the
         * same as [ObjectServiceAsync.set].
         */
        fun set(collection: String, id: String): CompletableFuture<HttpResponseFor<Object>> =
            set(collection, id, ObjectSetParams.none())

        /** @see [set] */
        fun set(
            collection: String,
            id: String,
            params: ObjectSetParams = ObjectSetParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Object>> =
            set(params.toBuilder().collection(collection).id(id).build(), requestOptions)

        /** @see [set] */
        fun set(
            collection: String,
            id: String,
            params: ObjectSetParams = ObjectSetParams.none(),
        ): CompletableFuture<HttpResponseFor<Object>> =
            set(collection, id, params, RequestOptions.none())

        /** @see [set] */
        fun set(
            params: ObjectSetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Object>>

        /** @see [set] */
        fun set(params: ObjectSetParams): CompletableFuture<HttpResponseFor<Object>> =
            set(params, RequestOptions.none())

        /** @see [set] */
        fun set(
            collection: String,
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Object>> =
            set(collection, id, ObjectSetParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put
         * /v1/objects/{collection}/{object_id}/channel_data/{channel_id}`, but is otherwise the
         * same as [ObjectServiceAsync.setChannelData].
         */
        fun setChannelData(
            collection: String,
            objectId: String,
            channelId: String,
            params: ObjectSetChannelDataParams,
        ): CompletableFuture<HttpResponseFor<ChannelData>> =
            setChannelData(collection, objectId, channelId, params, RequestOptions.none())

        /** @see [setChannelData] */
        fun setChannelData(
            collection: String,
            objectId: String,
            channelId: String,
            params: ObjectSetChannelDataParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ChannelData>> =
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
        fun setChannelData(
            params: ObjectSetChannelDataParams
        ): CompletableFuture<HttpResponseFor<ChannelData>> =
            setChannelData(params, RequestOptions.none())

        /** @see [setChannelData] */
        fun setChannelData(
            params: ObjectSetChannelDataParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ChannelData>>

        /**
         * Returns a raw HTTP response for `put
         * /v1/objects/{collection}/{object_id}/preferences/{id}`, but is otherwise the same as
         * [ObjectServiceAsync.setPreferences].
         */
        fun setPreferences(
            collection: String,
            objectId: String,
            id: String,
            params: ObjectSetPreferencesParams,
        ): CompletableFuture<HttpResponseFor<PreferenceSet>> =
            setPreferences(collection, objectId, id, params, RequestOptions.none())

        /** @see [setPreferences] */
        fun setPreferences(
            collection: String,
            objectId: String,
            id: String,
            params: ObjectSetPreferencesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PreferenceSet>> =
            setPreferences(
                params.toBuilder().collection(collection).objectId(objectId).id(id).build(),
                requestOptions,
            )

        /** @see [setPreferences] */
        fun setPreferences(
            params: ObjectSetPreferencesParams
        ): CompletableFuture<HttpResponseFor<PreferenceSet>> =
            setPreferences(params, RequestOptions.none())

        /** @see [setPreferences] */
        fun setPreferences(
            params: ObjectSetPreferencesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PreferenceSet>>

        /**
         * Returns a raw HTTP response for `delete
         * /v1/objects/{collection}/{object_id}/channel_data/{channel_id}`, but is otherwise the
         * same as [ObjectServiceAsync.unsetChannelData].
         */
        fun unsetChannelData(
            collection: String,
            objectId: String,
            channelId: String,
        ): CompletableFuture<HttpResponseFor<String>> =
            unsetChannelData(collection, objectId, channelId, ObjectUnsetChannelDataParams.none())

        /** @see [unsetChannelData] */
        fun unsetChannelData(
            collection: String,
            objectId: String,
            channelId: String,
            params: ObjectUnsetChannelDataParams = ObjectUnsetChannelDataParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<String>> =
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
        ): CompletableFuture<HttpResponseFor<String>> =
            unsetChannelData(collection, objectId, channelId, params, RequestOptions.none())

        /** @see [unsetChannelData] */
        fun unsetChannelData(
            params: ObjectUnsetChannelDataParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<String>>

        /** @see [unsetChannelData] */
        fun unsetChannelData(
            params: ObjectUnsetChannelDataParams
        ): CompletableFuture<HttpResponseFor<String>> =
            unsetChannelData(params, RequestOptions.none())

        /** @see [unsetChannelData] */
        fun unsetChannelData(
            collection: String,
            objectId: String,
            channelId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<String>> =
            unsetChannelData(
                collection,
                objectId,
                channelId,
                ObjectUnsetChannelDataParams.none(),
                requestOptions,
            )
    }
}
