// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.workflows.WorkflowCancelParams
import app.knock.api.models.workflows.WorkflowTriggerParams
import app.knock.api.models.workflows.WorkflowTriggerResponse
import com.google.errorprone.annotations.MustBeClosed
import java.util.concurrent.CompletableFuture

interface WorkflowServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Issues a cancellation request to inflight workflow runs */
    fun cancel(params: WorkflowCancelParams): CompletableFuture<String> =
        cancel(params, RequestOptions.none())

    /** @see [cancel] */
    fun cancel(
        params: WorkflowCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<String>

    /** Triggers a workflow */
    fun trigger(params: WorkflowTriggerParams): CompletableFuture<WorkflowTriggerResponse> =
        trigger(params, RequestOptions.none())

    /** @see [trigger] */
    fun trigger(
        params: WorkflowTriggerParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WorkflowTriggerResponse>

    /**
     * A view of [WorkflowServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/workflows/{key}/cancel`, but is otherwise the
         * same as [WorkflowServiceAsync.cancel].
         */
        @MustBeClosed
        fun cancel(params: WorkflowCancelParams): CompletableFuture<HttpResponseFor<String>> =
            cancel(params, RequestOptions.none())

        /** @see [cancel] */
        @MustBeClosed
        fun cancel(
            params: WorkflowCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<String>>

        /**
         * Returns a raw HTTP response for `post /v1/workflows/{key}/trigger`, but is otherwise the
         * same as [WorkflowServiceAsync.trigger].
         */
        @MustBeClosed
        fun trigger(
            params: WorkflowTriggerParams
        ): CompletableFuture<HttpResponseFor<WorkflowTriggerResponse>> =
            trigger(params, RequestOptions.none())

        /** @see [trigger] */
        @MustBeClosed
        fun trigger(
            params: WorkflowTriggerParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WorkflowTriggerResponse>>
    }
}
