// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async

import app.knock.api.services.async.integrations.CensusServiceAsync
import app.knock.api.services.async.integrations.HightouchServiceAsync

interface IntegrationServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun census(): CensusServiceAsync

    fun hightouch(): HightouchServiceAsync

    /**
     * A view of [IntegrationServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        fun census(): CensusServiceAsync.WithRawResponse

        fun hightouch(): HightouchServiceAsync.WithRawResponse
    }
}
