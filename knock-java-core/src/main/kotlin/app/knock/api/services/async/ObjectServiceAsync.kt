// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.objects.Object
import app.knock.api.models.objects.ObjectDeleteParams
import app.knock.api.models.objects.ObjectGetParams
import app.knock.api.models.objects.ObjectListMessagesPageAsync
import app.knock.api.models.objects.ObjectListMessagesParams
import app.knock.api.models.objects.ObjectListPageAsync
import app.knock.api.models.objects.ObjectListParams
import app.knock.api.models.objects.ObjectListSchedulesPageAsync
import app.knock.api.models.objects.ObjectListSchedulesParams
import app.knock.api.models.objects.ObjectSetParams
import app.knock.api.services.async.objects.BulkServiceAsync
import com.google.errorprone.annotations.MustBeClosed
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
    fun list(params: ObjectListParams): CompletableFuture<ObjectListPageAsync> =
        list(params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: ObjectListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ObjectListPageAsync>

    /**
     * Permanently removes an object from the specified collection. This operation cannot be undone.
     */
    fun delete(params: ObjectDeleteParams): CompletableFuture<String> =
        delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: ObjectDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<String>

    /**
     * Retrieves a specific object by its ID from the specified collection. Returns the object with
     * all its properties.
     */
    fun get(params: ObjectGetParams): CompletableFuture<Object> = get(params, RequestOptions.none())

    /** @see [get] */
    fun get(
        params: ObjectGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Object>

    /**
     * Returns a paginated list of messages for a specific object in the given collection. Allows
     * filtering by message status and provides various sorting options.
     */
    fun listMessages(
        params: ObjectListMessagesParams
    ): CompletableFuture<ObjectListMessagesPageAsync> = listMessages(params, RequestOptions.none())

    /** @see [listMessages] */
    fun listMessages(
        params: ObjectListMessagesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ObjectListMessagesPageAsync>

    /** Returns a paginated list of schedules for an object. */
    fun listSchedules(
        params: ObjectListSchedulesParams
    ): CompletableFuture<ObjectListSchedulesPageAsync> =
        listSchedules(params, RequestOptions.none())

    /** @see [listSchedules] */
    fun listSchedules(
        params: ObjectListSchedulesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ObjectListSchedulesPageAsync>

    /**
     * Creates a new object or updates an existing one in the specified collection. This operation
     * is used to identify objects with their properties, as well as optional preferences and
     * channel data.
     */
    fun set(params: ObjectSetParams): CompletableFuture<Object> = set(params, RequestOptions.none())

    /** @see [set] */
    fun set(
        params: ObjectSetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Object>

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
         * Returns a raw HTTP response for `delete /v1/objects/{collection}/{id}`, but is otherwise
         * the same as [ObjectServiceAsync.delete].
         */
        @MustBeClosed
        fun delete(params: ObjectDeleteParams): CompletableFuture<HttpResponseFor<String>> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: ObjectDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<String>>

        /**
         * Returns a raw HTTP response for `get /v1/objects/{collection}/{id}`, but is otherwise the
         * same as [ObjectServiceAsync.get].
         */
        @MustBeClosed
        fun get(params: ObjectGetParams): CompletableFuture<HttpResponseFor<Object>> =
            get(params, RequestOptions.none())

        /** @see [get] */
        @MustBeClosed
        fun get(
            params: ObjectGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Object>>

        /**
         * Returns a raw HTTP response for `get /v1/objects/{collection}/{id}/messages`, but is
         * otherwise the same as [ObjectServiceAsync.listMessages].
         */
        @MustBeClosed
        fun listMessages(
            params: ObjectListMessagesParams
        ): CompletableFuture<HttpResponseFor<ObjectListMessagesPageAsync>> =
            listMessages(params, RequestOptions.none())

        /** @see [listMessages] */
        @MustBeClosed
        fun listMessages(
            params: ObjectListMessagesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ObjectListMessagesPageAsync>>

        /**
         * Returns a raw HTTP response for `get /v1/objects/{collection}/{id}/schedules`, but is
         * otherwise the same as [ObjectServiceAsync.listSchedules].
         */
        @MustBeClosed
        fun listSchedules(
            params: ObjectListSchedulesParams
        ): CompletableFuture<HttpResponseFor<ObjectListSchedulesPageAsync>> =
            listSchedules(params, RequestOptions.none())

        /** @see [listSchedules] */
        @MustBeClosed
        fun listSchedules(
            params: ObjectListSchedulesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ObjectListSchedulesPageAsync>>

        /**
         * Returns a raw HTTP response for `put /v1/objects/{collection}/{id}`, but is otherwise the
         * same as [ObjectServiceAsync.set].
         */
        @MustBeClosed
        fun set(params: ObjectSetParams): CompletableFuture<HttpResponseFor<Object>> =
            set(params, RequestOptions.none())

        /** @see [set] */
        @MustBeClosed
        fun set(
            params: ObjectSetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Object>>
    }
}
