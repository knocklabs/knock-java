// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.workflowrecipientruns.WorkflowRecipientRunDetail
import app.knock.api.models.workflowrecipientruns.WorkflowRecipientRunGetParams
import app.knock.api.models.workflowrecipientruns.WorkflowRecipientRunListPageAsync
import app.knock.api.models.workflowrecipientruns.WorkflowRecipientRunListParams
import com.google.errorprone.annotations.MustBeClosed
import java.util.concurrent.CompletableFuture

interface WorkflowRecipientRunServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Returns a single workflow recipient run with its associated events. */
    fun get(id: String): CompletableFuture<WorkflowRecipientRunDetail> =
        get(id, WorkflowRecipientRunGetParams.none())

    /** @see [get] */
    fun get(
        id: String,
        params: WorkflowRecipientRunGetParams = WorkflowRecipientRunGetParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WorkflowRecipientRunDetail> =
        get(params.toBuilder().id(id).build(), requestOptions)

    /** @see [get] */
    fun get(
        id: String,
        params: WorkflowRecipientRunGetParams = WorkflowRecipientRunGetParams.none(),
    ): CompletableFuture<WorkflowRecipientRunDetail> = get(id, params, RequestOptions.none())

    /** @see [get] */
    fun get(
        params: WorkflowRecipientRunGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WorkflowRecipientRunDetail>

    /** @see [get] */
    fun get(params: WorkflowRecipientRunGetParams): CompletableFuture<WorkflowRecipientRunDetail> =
        get(params, RequestOptions.none())

    /** @see [get] */
    fun get(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<WorkflowRecipientRunDetail> =
        get(id, WorkflowRecipientRunGetParams.none(), requestOptions)

    /** Returns a paginated list of workflow recipient runs for the current environment. */
    fun list(): CompletableFuture<WorkflowRecipientRunListPageAsync> =
        list(WorkflowRecipientRunListParams.none())

    /** @see [list] */
    fun list(
        params: WorkflowRecipientRunListParams = WorkflowRecipientRunListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WorkflowRecipientRunListPageAsync>

    /** @see [list] */
    fun list(
        params: WorkflowRecipientRunListParams = WorkflowRecipientRunListParams.none()
    ): CompletableFuture<WorkflowRecipientRunListPageAsync> = list(params, RequestOptions.none())

    /** @see [list] */
    fun list(requestOptions: RequestOptions): CompletableFuture<WorkflowRecipientRunListPageAsync> =
        list(WorkflowRecipientRunListParams.none(), requestOptions)

    /**
     * A view of [WorkflowRecipientRunServiceAsync] that provides access to raw HTTP responses for
     * each method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /v1/workflow_recipient_runs/{id}`, but is otherwise
         * the same as [WorkflowRecipientRunServiceAsync.get].
         */
        @MustBeClosed
        fun get(id: String): CompletableFuture<HttpResponseFor<WorkflowRecipientRunDetail>> =
            get(id, WorkflowRecipientRunGetParams.none())

        /** @see [get] */
        @MustBeClosed
        fun get(
            id: String,
            params: WorkflowRecipientRunGetParams = WorkflowRecipientRunGetParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WorkflowRecipientRunDetail>> =
            get(params.toBuilder().id(id).build(), requestOptions)

        /** @see [get] */
        @MustBeClosed
        fun get(
            id: String,
            params: WorkflowRecipientRunGetParams = WorkflowRecipientRunGetParams.none(),
        ): CompletableFuture<HttpResponseFor<WorkflowRecipientRunDetail>> =
            get(id, params, RequestOptions.none())

        /** @see [get] */
        @MustBeClosed
        fun get(
            params: WorkflowRecipientRunGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WorkflowRecipientRunDetail>>

        /** @see [get] */
        @MustBeClosed
        fun get(
            params: WorkflowRecipientRunGetParams
        ): CompletableFuture<HttpResponseFor<WorkflowRecipientRunDetail>> =
            get(params, RequestOptions.none())

        /** @see [get] */
        @MustBeClosed
        fun get(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<WorkflowRecipientRunDetail>> =
            get(id, WorkflowRecipientRunGetParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/workflow_recipient_runs`, but is otherwise the
         * same as [WorkflowRecipientRunServiceAsync.list].
         */
        @MustBeClosed
        fun list(): CompletableFuture<HttpResponseFor<WorkflowRecipientRunListPageAsync>> =
            list(WorkflowRecipientRunListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: WorkflowRecipientRunListParams = WorkflowRecipientRunListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WorkflowRecipientRunListPageAsync>>

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: WorkflowRecipientRunListParams = WorkflowRecipientRunListParams.none()
        ): CompletableFuture<HttpResponseFor<WorkflowRecipientRunListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<WorkflowRecipientRunListPageAsync>> =
            list(WorkflowRecipientRunListParams.none(), requestOptions)
    }
}
