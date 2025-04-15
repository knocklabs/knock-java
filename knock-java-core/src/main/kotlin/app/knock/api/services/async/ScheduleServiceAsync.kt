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
import com.google.errorprone.annotations.MustBeClosed
import java.util.concurrent.CompletableFuture

interface ScheduleServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Create schedules */
    fun create(): CompletableFuture<List<Schedule>> = create(ScheduleCreateParams.none())

    /** @see [create] */
    fun create(
        params: ScheduleCreateParams = ScheduleCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Schedule>>

    /** @see [create] */
    fun create(
        params: ScheduleCreateParams = ScheduleCreateParams.none()
    ): CompletableFuture<List<Schedule>> = create(params, RequestOptions.none())

    /** @see [create] */
    fun create(requestOptions: RequestOptions): CompletableFuture<List<Schedule>> =
        create(ScheduleCreateParams.none(), requestOptions)

    /** Update schedules */
    fun update(): CompletableFuture<List<Schedule>> = update(ScheduleUpdateParams.none())

    /** @see [update] */
    fun update(
        params: ScheduleUpdateParams = ScheduleUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Schedule>>

    /** @see [update] */
    fun update(
        params: ScheduleUpdateParams = ScheduleUpdateParams.none()
    ): CompletableFuture<List<Schedule>> = update(params, RequestOptions.none())

    /** @see [update] */
    fun update(requestOptions: RequestOptions): CompletableFuture<List<Schedule>> =
        update(ScheduleUpdateParams.none(), requestOptions)

    /** List schedules */
    fun list(params: ScheduleListParams): CompletableFuture<ScheduleListPageAsync> =
        list(params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: ScheduleListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ScheduleListPageAsync>

    /** Delete schedules */
    fun delete(): CompletableFuture<List<Schedule>> = delete(ScheduleDeleteParams.none())

    /** @see [delete] */
    fun delete(
        params: ScheduleDeleteParams = ScheduleDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Schedule>>

    /** @see [delete] */
    fun delete(
        params: ScheduleDeleteParams = ScheduleDeleteParams.none()
    ): CompletableFuture<List<Schedule>> = delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(requestOptions: RequestOptions): CompletableFuture<List<Schedule>> =
        delete(ScheduleDeleteParams.none(), requestOptions)

    /**
     * A view of [ScheduleServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/schedules`, but is otherwise the same as
         * [ScheduleServiceAsync.create].
         */
        @MustBeClosed
        fun create(): CompletableFuture<HttpResponseFor<List<Schedule>>> =
            create(ScheduleCreateParams.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: ScheduleCreateParams = ScheduleCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Schedule>>>

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: ScheduleCreateParams = ScheduleCreateParams.none()
        ): CompletableFuture<HttpResponseFor<List<Schedule>>> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<List<Schedule>>> =
            create(ScheduleCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put /v1/schedules`, but is otherwise the same as
         * [ScheduleServiceAsync.update].
         */
        @MustBeClosed
        fun update(): CompletableFuture<HttpResponseFor<List<Schedule>>> =
            update(ScheduleUpdateParams.none())

        /** @see [update] */
        @MustBeClosed
        fun update(
            params: ScheduleUpdateParams = ScheduleUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Schedule>>>

        /** @see [update] */
        @MustBeClosed
        fun update(
            params: ScheduleUpdateParams = ScheduleUpdateParams.none()
        ): CompletableFuture<HttpResponseFor<List<Schedule>>> =
            update(params, RequestOptions.none())

        /** @see [update] */
        @MustBeClosed
        fun update(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<List<Schedule>>> =
            update(ScheduleUpdateParams.none(), requestOptions)

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
        fun delete(): CompletableFuture<HttpResponseFor<List<Schedule>>> =
            delete(ScheduleDeleteParams.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: ScheduleDeleteParams = ScheduleDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Schedule>>>

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: ScheduleDeleteParams = ScheduleDeleteParams.none()
        ): CompletableFuture<HttpResponseFor<List<Schedule>>> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<List<Schedule>>> =
            delete(ScheduleDeleteParams.none(), requestOptions)
    }
}
