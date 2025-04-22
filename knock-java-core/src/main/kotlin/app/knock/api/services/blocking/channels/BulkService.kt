// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking.channels

interface BulkService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** A view of [BulkService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse
}
