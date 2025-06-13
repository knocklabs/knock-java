// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking

import app.knock.api.core.ClientOptions
import app.knock.api.services.blocking.integrations.CensusService
import app.knock.api.services.blocking.integrations.HightouchService
import java.util.function.Consumer

interface IntegrationService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): IntegrationService

    fun census(): CensusService

    fun hightouch(): HightouchService

    /**
     * A view of [IntegrationService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): IntegrationService.WithRawResponse

        fun census(): CensusService.WithRawResponse

        fun hightouch(): HightouchService.WithRawResponse
    }
}
