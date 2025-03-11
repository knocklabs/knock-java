// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.async

import com.knock.api.core.ClientOptions
import com.knock.api.services.async.providers.MsTeamServiceAsync
import com.knock.api.services.async.providers.MsTeamServiceAsyncImpl
import com.knock.api.services.async.providers.SlackServiceAsync
import com.knock.api.services.async.providers.SlackServiceAsyncImpl

class ProviderServiceAsyncImpl internal constructor(
    private val clientOptions: ClientOptions,

) : ProviderServiceAsync {

    private val withRawResponse: ProviderServiceAsync.WithRawResponse by lazy { WithRawResponseImpl(clientOptions) }

    private val slack: SlackServiceAsync by lazy { SlackServiceAsyncImpl(clientOptions) }

    private val msTeams: MsTeamServiceAsync by lazy { MsTeamServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): ProviderServiceAsync.WithRawResponse = withRawResponse

    override fun slack(): SlackServiceAsync = slack

    override fun msTeams(): MsTeamServiceAsync = msTeams

    class WithRawResponseImpl internal constructor(
        private val clientOptions: ClientOptions,

    ) : ProviderServiceAsync.WithRawResponse {

        private val slack: SlackServiceAsync.WithRawResponse by lazy { SlackServiceAsyncImpl.WithRawResponseImpl(clientOptions) }

        private val msTeams: MsTeamServiceAsync.WithRawResponse by lazy { MsTeamServiceAsyncImpl.WithRawResponseImpl(clientOptions) }

        override fun slack(): SlackServiceAsync.WithRawResponse = slack

        override fun msTeams(): MsTeamServiceAsync.WithRawResponse = msTeams
    }
}
