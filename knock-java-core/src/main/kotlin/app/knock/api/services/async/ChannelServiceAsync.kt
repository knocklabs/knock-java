// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async

import app.knock.api.services.async.channels.BulkServiceAsync

interface ChannelServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for
     * each method.
     */
    fun withRawResponse(): WithRawResponse

    fun bulk(): BulkServiceAsync

    /**
     * A view of [ChannelServiceAsync] that provides access to raw HTTP responses for
     * each method.
     */
    interface WithRawResponse {

        fun bulk(): BulkServiceAsync.WithRawResponse
    }
}
