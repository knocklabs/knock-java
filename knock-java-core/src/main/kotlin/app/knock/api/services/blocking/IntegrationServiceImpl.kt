// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking

import app.knock.api.core.ClientOptions
import app.knock.api.services.blocking.integrations.CensusService
import app.knock.api.services.blocking.integrations.CensusServiceImpl
import app.knock.api.services.blocking.integrations.HightouchService
import app.knock.api.services.blocking.integrations.HightouchServiceImpl

class IntegrationServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    IntegrationService {

    private val withRawResponse: IntegrationService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val census: CensusService by lazy { CensusServiceImpl(clientOptions) }

    private val hightouch: HightouchService by lazy { HightouchServiceImpl(clientOptions) }

    override fun withRawResponse(): IntegrationService.WithRawResponse = withRawResponse

    override fun census(): CensusService = census

    override fun hightouch(): HightouchService = hightouch

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        IntegrationService.WithRawResponse {

        private val census: CensusService.WithRawResponse by lazy {
            CensusServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val hightouch: HightouchService.WithRawResponse by lazy {
            HightouchServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun census(): CensusService.WithRawResponse = census

        override fun hightouch(): HightouchService.WithRawResponse = hightouch
    }
}
