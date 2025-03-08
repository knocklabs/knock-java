// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.knock.api.core.RequestOptions
import com.knock.api.core.http.HttpResponseFor
import com.knock.api.models.Schedule
import com.knock.api.models.ScheduleCreateParams
import com.knock.api.models.ScheduleDeleteParams
import com.knock.api.models.ScheduleListPage
import com.knock.api.models.ScheduleListParams
import com.knock.api.models.ScheduleUpdateParams

interface ScheduleService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Create schedules */
    fun create(params: ScheduleCreateParams): List<Schedule> = create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: ScheduleCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Schedule>

    /** Update schedules */
    fun update(params: ScheduleUpdateParams): List<Schedule> = update(params, RequestOptions.none())

    /** @see [update] */
    fun update(
        params: ScheduleUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Schedule>

    /** List schedules */
    fun list(params: ScheduleListParams): ScheduleListPage = list(params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: ScheduleListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ScheduleListPage

    /** Delete schedules */
    fun delete(params: ScheduleDeleteParams): List<Schedule> = delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: ScheduleDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Schedule>

    /** A view of [ScheduleService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/schedules`, but is otherwise the same as
         * [ScheduleService.create].
         */
        @MustBeClosed
        fun create(params: ScheduleCreateParams): HttpResponseFor<List<Schedule>> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: ScheduleCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Schedule>>

        /**
         * Returns a raw HTTP response for `put /v1/schedules`, but is otherwise the same as
         * [ScheduleService.update].
         */
        @MustBeClosed
        fun update(params: ScheduleUpdateParams): HttpResponseFor<List<Schedule>> =
            update(params, RequestOptions.none())

        /** @see [update] */
        @MustBeClosed
        fun update(
            params: ScheduleUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Schedule>>

        /**
         * Returns a raw HTTP response for `get /v1/schedules`, but is otherwise the same as
         * [ScheduleService.list].
         */
        @MustBeClosed
        fun list(params: ScheduleListParams): HttpResponseFor<ScheduleListPage> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: ScheduleListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ScheduleListPage>

        /**
         * Returns a raw HTTP response for `delete /v1/schedules`, but is otherwise the same as
         * [ScheduleService.delete].
         */
        @MustBeClosed
        fun delete(params: ScheduleDeleteParams): HttpResponseFor<List<Schedule>> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: ScheduleDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Schedule>>
    }
}
