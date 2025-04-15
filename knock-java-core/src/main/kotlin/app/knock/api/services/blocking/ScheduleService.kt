// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.schedules.Schedule
import app.knock.api.models.schedules.ScheduleCreateParams
import app.knock.api.models.schedules.ScheduleDeleteParams
import app.knock.api.models.schedules.ScheduleListPage
import app.knock.api.models.schedules.ScheduleListParams
import app.knock.api.models.schedules.ScheduleUpdateParams
import com.google.errorprone.annotations.MustBeClosed

interface ScheduleService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Create schedules */
    fun create(): List<Schedule> = create(ScheduleCreateParams.none())

    /** @see [create] */
    fun create(
        params: ScheduleCreateParams = ScheduleCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Schedule>

    /** @see [create] */
    fun create(params: ScheduleCreateParams = ScheduleCreateParams.none()): List<Schedule> =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(requestOptions: RequestOptions): List<Schedule> =
        create(ScheduleCreateParams.none(), requestOptions)

    /** Update schedules */
    fun update(): List<Schedule> = update(ScheduleUpdateParams.none())

    /** @see [update] */
    fun update(
        params: ScheduleUpdateParams = ScheduleUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Schedule>

    /** @see [update] */
    fun update(params: ScheduleUpdateParams = ScheduleUpdateParams.none()): List<Schedule> =
        update(params, RequestOptions.none())

    /** @see [update] */
    fun update(requestOptions: RequestOptions): List<Schedule> =
        update(ScheduleUpdateParams.none(), requestOptions)

    /** List schedules */
    fun list(params: ScheduleListParams): ScheduleListPage = list(params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: ScheduleListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ScheduleListPage

    /** Delete schedules */
    fun delete(): List<Schedule> = delete(ScheduleDeleteParams.none())

    /** @see [delete] */
    fun delete(
        params: ScheduleDeleteParams = ScheduleDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Schedule>

    /** @see [delete] */
    fun delete(params: ScheduleDeleteParams = ScheduleDeleteParams.none()): List<Schedule> =
        delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(requestOptions: RequestOptions): List<Schedule> =
        delete(ScheduleDeleteParams.none(), requestOptions)

    /** A view of [ScheduleService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/schedules`, but is otherwise the same as
         * [ScheduleService.create].
         */
        @MustBeClosed
        fun create(): HttpResponseFor<List<Schedule>> = create(ScheduleCreateParams.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: ScheduleCreateParams = ScheduleCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Schedule>>

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: ScheduleCreateParams = ScheduleCreateParams.none()
        ): HttpResponseFor<List<Schedule>> = create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(requestOptions: RequestOptions): HttpResponseFor<List<Schedule>> =
            create(ScheduleCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put /v1/schedules`, but is otherwise the same as
         * [ScheduleService.update].
         */
        @MustBeClosed
        fun update(): HttpResponseFor<List<Schedule>> = update(ScheduleUpdateParams.none())

        /** @see [update] */
        @MustBeClosed
        fun update(
            params: ScheduleUpdateParams = ScheduleUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Schedule>>

        /** @see [update] */
        @MustBeClosed
        fun update(
            params: ScheduleUpdateParams = ScheduleUpdateParams.none()
        ): HttpResponseFor<List<Schedule>> = update(params, RequestOptions.none())

        /** @see [update] */
        @MustBeClosed
        fun update(requestOptions: RequestOptions): HttpResponseFor<List<Schedule>> =
            update(ScheduleUpdateParams.none(), requestOptions)

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
        fun delete(): HttpResponseFor<List<Schedule>> = delete(ScheduleDeleteParams.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: ScheduleDeleteParams = ScheduleDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Schedule>>

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: ScheduleDeleteParams = ScheduleDeleteParams.none()
        ): HttpResponseFor<List<Schedule>> = delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(requestOptions: RequestOptions): HttpResponseFor<List<Schedule>> =
            delete(ScheduleDeleteParams.none(), requestOptions)
    }
}
