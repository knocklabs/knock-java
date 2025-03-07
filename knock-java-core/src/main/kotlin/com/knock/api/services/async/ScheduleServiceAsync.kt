// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.knock.api.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.knock.api.core.RequestOptions
import com.knock.api.core.http.HttpResponseFor
import com.knock.api.models.Schedule
import com.knock.api.models.ScheduleCreateParams
import com.knock.api.models.ScheduleDeleteParams
import com.knock.api.models.ScheduleListPageAsync
import com.knock.api.models.ScheduleListParams
import com.knock.api.models.ScheduleUpdateParams
import java.util.concurrent.CompletableFuture

interface ScheduleServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Create schedules */
    @JvmOverloads
    fun create(
        params: ScheduleCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Schedule>>

    /** Update schedules */
    @JvmOverloads
    fun update(
        params: ScheduleUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Schedule>>

    /** List schedules */
    @JvmOverloads
    fun list(
        params: ScheduleListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ScheduleListPageAsync>

    /** Delete schedules */
    @JvmOverloads
    fun delete(
        params: ScheduleDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<List<Schedule>>

    /**
     * A view of [ScheduleServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/schedules`, but is otherwise the same as
         * [ScheduleServiceAsync.create].
         */
        @JvmOverloads
        @MustBeClosed
        fun create(
            params: ScheduleCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Schedule>>>

        /**
         * Returns a raw HTTP response for `put /v1/schedules`, but is otherwise the same as
         * [ScheduleServiceAsync.update].
         */
        @JvmOverloads
        @MustBeClosed
        fun update(
            params: ScheduleUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Schedule>>>

        /**
         * Returns a raw HTTP response for `get /v1/schedules`, but is otherwise the same as
         * [ScheduleServiceAsync.list].
         */
        @JvmOverloads
        @MustBeClosed
        fun list(
            params: ScheduleListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ScheduleListPageAsync>>

        /**
         * Returns a raw HTTP response for `delete /v1/schedules`, but is otherwise the same as
         * [ScheduleServiceAsync.delete].
         */
        @JvmOverloads
        @MustBeClosed
        fun delete(
            params: ScheduleDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<List<Schedule>>>
    }
}
