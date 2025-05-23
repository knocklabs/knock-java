// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async

interface SharedServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * A view of [SharedServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse
}
