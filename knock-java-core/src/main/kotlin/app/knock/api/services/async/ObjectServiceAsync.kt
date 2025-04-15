// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.objects.ObjectAddSubscriptionsParams
import app.knock.api.models.objects.ObjectDeleteSubscriptionsParams
import app.knock.api.models.objects.ObjectGetChannelDataParams
import app.knock.api.models.objects.ObjectListPageAsync
import app.knock.api.models.objects.ObjectListParams
import app.knock.api.models.objects.ObjectListSubscriptionsPageAsync
import app.knock.api.models.objects.ObjectListSubscriptionsParams
import app.knock.api.models.objects.ObjectSetChannelDataParams
import app.knock.api.models.objects.ObjectUnsetChannelDataParams
import app.knock.api.models.recipients.channeldata.ChannelData
import app.knock.api.models.recipients.subscriptions.Subscription
import app.knock.api.services.async.objects.BulkServiceAsync
import com.google.errorprone.annotations.MustBeClosed
import java.util.concurrent.CompletableFuture

interface ObjectServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun bulk(): BulkServiceAsync

    /** List objects in a collection */
    fun list(params: ObjectListParams): CompletableFuture<ObjectListPageAsync> =
        list(params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: ObjectListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ObjectListPageAsync>

    /** Upsert subscriptions for an object */
    fun addSubscriptions(
        params: ObjectAddSubscriptionsParams
    ): CompletableFuture<List<Subscription>> = addSubscriptions(params, RequestOptions.none())

    /** @see [addSubscriptions] */
    fun addSubscriptions(
        params: ObjectAddSubscriptionsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Subscription>>

    /** Delete subscriptions for an object */
    fun deleteSubscriptions(
        params: ObjectDeleteSubscriptionsParams
    ): CompletableFuture<List<Subscription>> = deleteSubscriptions(params, RequestOptions.none())

    /** @see [deleteSubscriptions] */
    fun deleteSubscriptions(
        params: ObjectDeleteSubscriptionsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Subscription>>

    /** Get channel data for an object */
    fun getChannelData(params: ObjectGetChannelDataParams): CompletableFuture<ChannelData> =
        getChannelData(params, RequestOptions.none())

    /** @see [getChannelData] */
    fun getChannelData(
        params: ObjectGetChannelDataParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ChannelData>

    /**
     * List subscriptions for an object. Either list all subscriptions that belong to the object, or
     * all subscriptions that this object has. Determined by the `mode` query parameter.
     */
    fun listSubscriptions(
        params: ObjectListSubscriptionsParams
    ): CompletableFuture<ObjectListSubscriptionsPageAsync> =
        listSubscriptions(params, RequestOptions.none())

    /** @see [listSubscriptions] */
    fun listSubscriptions(
        params: ObjectListSubscriptionsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ObjectListSubscriptionsPageAsync>

    /** Set channel data for an object */
    fun setChannelData(params: ObjectSetChannelDataParams): CompletableFuture<ChannelData> =
        setChannelData(params, RequestOptions.none())

    /** @see [setChannelData] */
    fun setChannelData(
        params: ObjectSetChannelDataParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ChannelData>

    /** Unset channel data for an object */
    fun unsetChannelData(params: ObjectUnsetChannelDataParams): CompletableFuture<String> =
        unsetChannelData(params, RequestOptions.none())

    /** @see [unsetChannelData] */
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
        @MustBeClosed
        fun list(
            params: ObjectListParams
        ): CompletableFuture<HttpResponseFor<ObjectListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: ObjectListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ObjectListPageAsync>>

        /**
         * Returns a raw HTTP response for `post
         * /v1/objects/{collection}/{object_id}/subscriptions`, but is otherwise the same as
         * [ObjectServiceAsync.addSubscriptions].
         */
        @MustBeClosed
        fun addSubscriptions(
            params: ObjectAddSubscriptionsParams
        ): CompletableFuture<HttpResponseFor<List<Subscription>>> =
            addSubscriptions(params, RequestOptions.none())

        /** @see [addSubscriptions] */
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
        @MustBeClosed
        fun deleteSubscriptions(
            params: ObjectDeleteSubscriptionsParams
        ): CompletableFuture<HttpResponseFor<List<Subscription>>> =
            deleteSubscriptions(params, RequestOptions.none())

        /** @see [deleteSubscriptions] */
        @MustBeClosed
        fun deleteSubscriptions(
            params: ObjectDeleteSubscriptionsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Subscription>>>

        /**
         * Returns a raw HTTP response for `get
         * /v1/objects/{collection}/{object_id}/channel_data/{channel_id}`, but is otherwise the
         * same as [ObjectServiceAsync.getChannelData].
         */
        @MustBeClosed
        fun getChannelData(
            params: ObjectGetChannelDataParams
        ): CompletableFuture<HttpResponseFor<ChannelData>> =
            getChannelData(params, RequestOptions.none())

        /** @see [getChannelData] */
        @MustBeClosed
        fun getChannelData(
            params: ObjectGetChannelDataParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ChannelData>>

        /**
         * Returns a raw HTTP response for `get /v1/objects/{collection}/{object_id}/subscriptions`,
         * but is otherwise the same as [ObjectServiceAsync.listSubscriptions].
         */
        @MustBeClosed
        fun listSubscriptions(
            params: ObjectListSubscriptionsParams
        ): CompletableFuture<HttpResponseFor<ObjectListSubscriptionsPageAsync>> =
            listSubscriptions(params, RequestOptions.none())

        /** @see [listSubscriptions] */
        @MustBeClosed
        fun listSubscriptions(
            params: ObjectListSubscriptionsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ObjectListSubscriptionsPageAsync>>

        /**
         * Returns a raw HTTP response for `put
         * /v1/objects/{collection}/{object_id}/channel_data/{channel_id}`, but is otherwise the
         * same as [ObjectServiceAsync.setChannelData].
         */
        @MustBeClosed
        fun setChannelData(
            params: ObjectSetChannelDataParams
        ): CompletableFuture<HttpResponseFor<ChannelData>> =
            setChannelData(params, RequestOptions.none())

        /** @see [setChannelData] */
        @MustBeClosed
        fun setChannelData(
            params: ObjectSetChannelDataParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ChannelData>>

        /**
         * Returns a raw HTTP response for `delete
         * /v1/objects/{collection}/{object_id}/channel_data/{channel_id}`, but is otherwise the
         * same as [ObjectServiceAsync.unsetChannelData].
         */
        @MustBeClosed
        fun unsetChannelData(
            params: ObjectUnsetChannelDataParams
        ): CompletableFuture<HttpResponseFor<String>> =
            unsetChannelData(params, RequestOptions.none())

        /** @see [unsetChannelData] */
        @MustBeClosed
        fun unsetChannelData(
            params: ObjectUnsetChannelDataParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<String>>
    }
}
