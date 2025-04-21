// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.schedules.Schedule
import app.knock.api.models.schedules.ScheduleCreateParams
import app.knock.api.models.schedules.ScheduleDeleteParams
import app.knock.api.models.schedules.ScheduleListPageAsync
import app.knock.api.models.schedules.ScheduleListParams
import app.knock.api.models.schedules.ScheduleUpdateParams
import app.knock.api.services.async.schedules.BulkServiceAsync
import com.google.errorprone.annotations.MustBeClosed
import java.util.concurrent.CompletableFuture

interface ScheduleServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun bulk(): BulkServiceAsync

    /**
     * Creates one or more schedules for a workflow with the specified recipients, timing, and data.
     * Schedules can be one-time or recurring. This endpoint also handles
     * [inline identifications](/managing-recipients/identifying-recipients#inline-identifying-recipients)
     * for the `actor`, `recipient`, and `tenant` fields.
     */
    fun create(params: ScheduleCreateParams): CompletableFuture<List<Schedule>> =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: ScheduleCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Schedule>>

    /**
     * Updates one or more existing schedules with new timing, data, or other properties. All
     * specified schedule IDs will be updated with the same values. This endpoint also handles
     * [inline identifications](/managing-recipients/identifying-recipients#inline-identifying-recipients)
     * for the `actor`, `recipient`, and `tenant` fields.
     */
    fun update(params: ScheduleUpdateParams): CompletableFuture<List<Schedule>> =
        update(params, RequestOptions.none())

    /** @see [update] */
    fun update(
        params: ScheduleUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Schedule>>

    /**
     * Returns a paginated list of schedules for the current environment, filtered by workflow and
     * optionally by recipients and tenant.
     */
    fun list(params: ScheduleListParams): CompletableFuture<ScheduleListPageAsync> =
        list(params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: ScheduleListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ScheduleListPageAsync>

    /**
     * Permanently deletes one or more schedules identified by the provided schedule IDs. This
     * operation cannot be undone.
     */
    fun delete(params: ScheduleDeleteParams): CompletableFuture<List<Schedule>> =
        delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: ScheduleDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Schedule>>

    /**
     * A view of [ScheduleServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        fun bulk(): BulkServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/schedules`, but is otherwise the same as
         * [ScheduleServiceAsync.create].
         */
        @MustBeClosed
        fun create(
            params: ScheduleCreateParams
        ): CompletableFuture<HttpResponseFor<List<Schedule>>> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: ScheduleCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Schedule>>>

        /**
         * Returns a raw HTTP response for `put /v1/schedules`, but is otherwise the same as
         * [ScheduleServiceAsync.update].
         */
        @MustBeClosed
        fun update(
            params: ScheduleUpdateParams
        ): CompletableFuture<HttpResponseFor<List<Schedule>>> =
            update(params, RequestOptions.none())

        /** @see [update] */
        @MustBeClosed
        fun update(
            params: ScheduleUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Schedule>>>

        /**
         * Returns a raw HTTP response for `get /v1/schedules`, but is otherwise the same as
         * [ScheduleServiceAsync.list].
         */
        @MustBeClosed
        fun list(
            params: ScheduleListParams
        ): CompletableFuture<HttpResponseFor<ScheduleListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: ScheduleListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ScheduleListPageAsync>>

        /**
         * Returns a raw HTTP response for `delete /v1/schedules`, but is otherwise the same as
         * [ScheduleServiceAsync.delete].
         */
        @MustBeClosed
        fun delete(
            params: ScheduleDeleteParams
        ): CompletableFuture<HttpResponseFor<List<Schedule>>> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: ScheduleDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Schedule>>>
    }
}
