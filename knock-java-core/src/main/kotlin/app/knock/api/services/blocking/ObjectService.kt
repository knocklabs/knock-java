// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.objects.Object
import app.knock.api.models.objects.ObjectDeleteParams
import app.knock.api.models.objects.ObjectGetParams
import app.knock.api.models.objects.ObjectListMessagesPage
import app.knock.api.models.objects.ObjectListMessagesParams
import app.knock.api.models.objects.ObjectListPage
import app.knock.api.models.objects.ObjectListParams
import app.knock.api.models.objects.ObjectListSchedulesPage
import app.knock.api.models.objects.ObjectListSchedulesParams
import app.knock.api.models.objects.ObjectSetParams
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
     * Permanently removes an object from the specified collection. This operation cannot be undone.
     */
    fun delete(params: ObjectDeleteParams): String = delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: ObjectDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): String

    /**
     * Retrieves a specific object by its ID from the specified collection. Returns the object with
     * all its properties.
     */
    fun get(params: ObjectGetParams): Object = get(params, RequestOptions.none())

    /** @see [get] */
    fun get(params: ObjectGetParams, requestOptions: RequestOptions = RequestOptions.none()): Object

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

    /** Returns a paginated list of schedules for an object. */
    fun listSchedules(params: ObjectListSchedulesParams): ObjectListSchedulesPage =
        listSchedules(params, RequestOptions.none())

    /** @see [listSchedules] */
    fun listSchedules(
        params: ObjectListSchedulesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ObjectListSchedulesPage

    /**
     * Creates a new object or updates an existing one in the specified collection. This operation
     * is used to identify objects with their properties, as well as optional preferences and
     * channel data.
     */
    fun set(params: ObjectSetParams): Object = set(params, RequestOptions.none())

    /** @see [set] */
    fun set(params: ObjectSetParams, requestOptions: RequestOptions = RequestOptions.none()): Object

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
         * Returns a raw HTTP response for `delete /v1/objects/{collection}/{id}`, but is otherwise
         * the same as [ObjectService.delete].
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
         * Returns a raw HTTP response for `get /v1/objects/{collection}/{id}`, but is otherwise the
         * same as [ObjectService.get].
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
         * Returns a raw HTTP response for `get /v1/objects/{collection}/{id}/messages`, but is
         * otherwise the same as [ObjectService.listMessages].
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
         * Returns a raw HTTP response for `get /v1/objects/{collection}/{id}/schedules`, but is
         * otherwise the same as [ObjectService.listSchedules].
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
         * Returns a raw HTTP response for `put /v1/objects/{collection}/{id}`, but is otherwise the
         * same as [ObjectService.set].
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
    }
}
