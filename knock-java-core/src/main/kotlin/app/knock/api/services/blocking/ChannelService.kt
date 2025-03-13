// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking

import app.knock.api.services.blocking.channels.BulkService

interface ChannelService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun bulk(): BulkService

    /** A view of [ChannelService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun bulk(): BulkService.WithRawResponse
    }
}
