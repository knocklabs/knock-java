// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking

import app.knock.api.core.ClientOptions
import app.knock.api.services.blocking.providers.MsTeamService
import app.knock.api.services.blocking.providers.MsTeamServiceImpl
import app.knock.api.services.blocking.providers.SlackService
import app.knock.api.services.blocking.providers.SlackServiceImpl

class ProviderServiceImpl internal constructor(
    private val clientOptions: ClientOptions,

) : ProviderService {

    private val withRawResponse: ProviderService.WithRawResponse by lazy { WithRawResponseImpl(clientOptions) }

    private val slack: SlackService by lazy { SlackServiceImpl(clientOptions) }

    private val msTeams: MsTeamService by lazy { MsTeamServiceImpl(clientOptions) }

    override fun withRawResponse(): ProviderService.WithRawResponse = withRawResponse

    override fun slack(): SlackService = slack

    override fun msTeams(): MsTeamService = msTeams

    class WithRawResponseImpl internal constructor(
        private val clientOptions: ClientOptions,

    ) : ProviderService.WithRawResponse {

        private val slack: SlackService.WithRawResponse by lazy { SlackServiceImpl.WithRawResponseImpl(clientOptions) }

        private val msTeams: MsTeamService.WithRawResponse by lazy { MsTeamServiceImpl.WithRawResponseImpl(clientOptions) }

        override fun slack(): SlackService.WithRawResponse = slack

        override fun msTeams(): MsTeamService.WithRawResponse = msTeams
    }
}
