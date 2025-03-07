// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.knock.api.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.knock.api.core.RequestOptions
import com.knock.api.core.http.HttpResponseFor
import com.knock.api.models.WorkflowCancelParams
import com.knock.api.models.WorkflowTriggerParams
import com.knock.api.models.WorkflowTriggerResponse
import java.util.concurrent.CompletableFuture

interface WorkflowServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * When invoked for a workflow using a specific workflow key and cancellation key, will cancel
     * any queued workflow runs associated with that key/cancellation key pair. Can optionally be
     * provided one or more recipients to scope the request to.
     */
    @JvmOverloads
    fun cancel(
        params: WorkflowCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<String>

    /**
     * Trigger a workflow specified by the key to run for the given recipients, using the parameters
     * provided. Returns an identifier for the workflow run request. All workflow runs are executed
     * asynchronously.
     */
    @JvmOverloads
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
        @JvmOverloads
        @MustBeClosed
        fun cancel(
            params: WorkflowCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<String>>

        /**
         * Returns a raw HTTP response for `post /v1/workflows/{key}/trigger`, but is otherwise the
         * same as [WorkflowServiceAsync.trigger].
         */
        @JvmOverloads
        @MustBeClosed
        fun trigger(
            params: WorkflowTriggerParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WorkflowTriggerResponse>>
    }
}
