// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.workflowrecipientruns.WorkflowRecipientRunDetail
import app.knock.api.models.workflowrecipientruns.WorkflowRecipientRunGetParams
import app.knock.api.models.workflowrecipientruns.WorkflowRecipientRunListPage
import app.knock.api.models.workflowrecipientruns.WorkflowRecipientRunListParams
import com.google.errorprone.annotations.MustBeClosed

interface WorkflowRecipientRunService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Returns a single workflow recipient run with its associated events. */
    fun get(id: String): WorkflowRecipientRunDetail = get(id, WorkflowRecipientRunGetParams.none())

    /** @see [get] */
    fun get(
        id: String,
        params: WorkflowRecipientRunGetParams = WorkflowRecipientRunGetParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WorkflowRecipientRunDetail = get(params.toBuilder().id(id).build(), requestOptions)

    /** @see [get] */
    fun get(
        id: String,
        params: WorkflowRecipientRunGetParams = WorkflowRecipientRunGetParams.none(),
    ): WorkflowRecipientRunDetail = get(id, params, RequestOptions.none())

    /** @see [get] */
    fun get(
        params: WorkflowRecipientRunGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WorkflowRecipientRunDetail

    /** @see [get] */
    fun get(params: WorkflowRecipientRunGetParams): WorkflowRecipientRunDetail =
        get(params, RequestOptions.none())

    /** @see [get] */
    fun get(id: String, requestOptions: RequestOptions): WorkflowRecipientRunDetail =
        get(id, WorkflowRecipientRunGetParams.none(), requestOptions)

    /** Returns a paginated list of workflow recipient runs for the current environment. */
    fun list(): WorkflowRecipientRunListPage = list(WorkflowRecipientRunListParams.none())

    /** @see [list] */
    fun list(
        params: WorkflowRecipientRunListParams = WorkflowRecipientRunListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WorkflowRecipientRunListPage

    /** @see [list] */
    fun list(
        params: WorkflowRecipientRunListParams = WorkflowRecipientRunListParams.none()
    ): WorkflowRecipientRunListPage = list(params, RequestOptions.none())

    /** @see [list] */
    fun list(requestOptions: RequestOptions): WorkflowRecipientRunListPage =
        list(WorkflowRecipientRunListParams.none(), requestOptions)

    /**
     * A view of [WorkflowRecipientRunService] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /v1/workflow_recipient_runs/{id}`, but is otherwise
         * the same as [WorkflowRecipientRunService.get].
         */
        @MustBeClosed
        fun get(id: String): HttpResponseFor<WorkflowRecipientRunDetail> =
            get(id, WorkflowRecipientRunGetParams.none())

        /** @see [get] */
        @MustBeClosed
        fun get(
            id: String,
            params: WorkflowRecipientRunGetParams = WorkflowRecipientRunGetParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WorkflowRecipientRunDetail> =
            get(params.toBuilder().id(id).build(), requestOptions)

        /** @see [get] */
        @MustBeClosed
        fun get(
            id: String,
            params: WorkflowRecipientRunGetParams = WorkflowRecipientRunGetParams.none(),
        ): HttpResponseFor<WorkflowRecipientRunDetail> = get(id, params, RequestOptions.none())

        /** @see [get] */
        @MustBeClosed
        fun get(
            params: WorkflowRecipientRunGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WorkflowRecipientRunDetail>

        /** @see [get] */
        @MustBeClosed
        fun get(
            params: WorkflowRecipientRunGetParams
        ): HttpResponseFor<WorkflowRecipientRunDetail> = get(params, RequestOptions.none())

        /** @see [get] */
        @MustBeClosed
        fun get(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<WorkflowRecipientRunDetail> =
            get(id, WorkflowRecipientRunGetParams.none(), requestOptions)

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: WorkflowRecipientRunListParams = WorkflowRecipientRunListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WorkflowRecipientRunListPage>

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: WorkflowRecipientRunListParams = WorkflowRecipientRunListParams.none()
        ): HttpResponseFor<WorkflowRecipientRunListPage> = list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<WorkflowRecipientRunListPage> =
            list(WorkflowRecipientRunListParams.none(), requestOptions)
    }
}
