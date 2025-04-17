// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.workflows.WorkflowCancelParams
import app.knock.api.models.workflows.WorkflowTriggerParams
import app.knock.api.models.workflows.WorkflowTriggerResponse
import com.google.errorprone.annotations.MustBeClosed

interface WorkflowService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * When invoked for a workflow using a specific workflow key and cancellation key, will cancel
     * any queued workflow runs associated with that key/cancellation key pair. Can optionally be
     * provided one or more recipients to scope the request to.
     */
    fun cancel(params: WorkflowCancelParams): String = cancel(params, RequestOptions.none())

    /** @see [cancel] */
    fun cancel(
        params: WorkflowCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): String

    /**
     * Trigger a workflow specified by the key to run for the given recipients, using the parameters
     * provided. Returns an identifier for the workflow run request. All workflow runs are executed
     * asynchronously.
     */
    fun trigger(params: WorkflowTriggerParams): WorkflowTriggerResponse =
        trigger(params, RequestOptions.none())

    /** @see [trigger] */
    fun trigger(
        params: WorkflowTriggerParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WorkflowTriggerResponse

    /** A view of [WorkflowService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/workflows/{key}/cancel`, but is otherwise the
         * same as [WorkflowService.cancel].
         */
        @MustBeClosed
        fun cancel(params: WorkflowCancelParams): HttpResponseFor<String> =
            cancel(params, RequestOptions.none())

        /** @see [cancel] */
        @MustBeClosed
        fun cancel(
            params: WorkflowCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<String>

        /**
         * Returns a raw HTTP response for `post /v1/workflows/{key}/trigger`, but is otherwise the
         * same as [WorkflowService.trigger].
         */
        @MustBeClosed
        fun trigger(params: WorkflowTriggerParams): HttpResponseFor<WorkflowTriggerResponse> =
            trigger(params, RequestOptions.none())

        /** @see [trigger] */
        @MustBeClosed
        fun trigger(
            params: WorkflowTriggerParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WorkflowTriggerResponse>
    }
}
