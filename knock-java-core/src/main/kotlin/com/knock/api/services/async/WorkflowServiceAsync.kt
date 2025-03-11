// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.knock.api.core.RequestOptions
import com.knock.api.core.http.HttpResponseFor
import com.knock.api.models.workflows.WorkflowCancelParams
import com.knock.api.models.workflows.WorkflowTriggerParams
import com.knock.api.models.workflows.WorkflowTriggerResponse
import java.util.concurrent.CompletableFuture

interface WorkflowServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for
     * each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * When invoked for a workflow using a specific workflow key and cancellation key,
     * will cancel any queued workflow runs associated with that key/cancellation key
     * pair. Can optionally be provided one or more recipients to scope the request to.
     */
    fun cancel(params: WorkflowCancelParams): CompletableFuture<String> =
        cancel(
          params, RequestOptions.none()
        )

    /** @see [cancel] */
    fun cancel(params: WorkflowCancelParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<String>

    /**
     * Trigger a workflow specified by the key to run for the given recipients, using
     * the parameters provided. Returns an identifier for the workflow run request. All
     * workflow runs are executed asynchronously.
     */
    fun trigger(params: WorkflowTriggerParams): CompletableFuture<WorkflowTriggerResponse> =
        trigger(
          params, RequestOptions.none()
        )

    /** @see [trigger] */
    fun trigger(params: WorkflowTriggerParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<WorkflowTriggerResponse>

    /**
     * A view of [WorkflowServiceAsync] that provides access to raw HTTP responses for
     * each method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/workflows/{key}/cancel`, but is
         * otherwise the same as [WorkflowServiceAsync.cancel].
         */
        @MustBeClosed
        fun cancel(params: WorkflowCancelParams): CompletableFuture<HttpResponseFor<String>> =
            cancel(
              params, RequestOptions.none()
            )

        /** @see [cancel] */
        @MustBeClosed
        fun cancel(params: WorkflowCancelParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<HttpResponseFor<String>>

        /**
         * Returns a raw HTTP response for `post /v1/workflows/{key}/trigger`, but is
         * otherwise the same as [WorkflowServiceAsync.trigger].
         */
        @MustBeClosed
        fun trigger(params: WorkflowTriggerParams): CompletableFuture<HttpResponseFor<WorkflowTriggerResponse>> =
            trigger(
              params, RequestOptions.none()
            )

        /** @see [trigger] */
        @MustBeClosed
        fun trigger(params: WorkflowTriggerParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<HttpResponseFor<WorkflowTriggerResponse>>
    }
}
