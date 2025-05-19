// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking

import app.knock.api.services.blocking.integrations.CensusService
import app.knock.api.services.blocking.integrations.HightouchService

interface IntegrationService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun census(): CensusService

    fun hightouch(): HightouchService

    /**
     * A view of [IntegrationService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        fun census(): CensusService.WithRawResponse

        fun hightouch(): HightouchService.WithRawResponse
    }
}
