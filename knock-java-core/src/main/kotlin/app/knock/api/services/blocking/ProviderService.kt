// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking

import app.knock.api.services.blocking.providers.MsTeamService
import app.knock.api.services.blocking.providers.SlackService

interface ProviderService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for
     * each method.
     */
    fun withRawResponse(): WithRawResponse

    fun slack(): SlackService

    fun msTeams(): MsTeamService

    /**
     * A view of [ProviderService] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        fun slack(): SlackService.WithRawResponse

        fun msTeams(): MsTeamService.WithRawResponse
    }
}
