// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async

import app.knock.api.core.ClientOptions
import app.knock.api.services.async.integrations.CensusServiceAsync
import app.knock.api.services.async.integrations.CensusServiceAsyncImpl
import app.knock.api.services.async.integrations.HightouchServiceAsync
import app.knock.api.services.async.integrations.HightouchServiceAsyncImpl

class IntegrationServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    IntegrationServiceAsync {

    private val withRawResponse: IntegrationServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val census: CensusServiceAsync by lazy { CensusServiceAsyncImpl(clientOptions) }

    private val hightouch: HightouchServiceAsync by lazy {
        HightouchServiceAsyncImpl(clientOptions)
    }

    override fun withRawResponse(): IntegrationServiceAsync.WithRawResponse = withRawResponse

    override fun census(): CensusServiceAsync = census

    override fun hightouch(): HightouchServiceAsync = hightouch

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        IntegrationServiceAsync.WithRawResponse {

        private val census: CensusServiceAsync.WithRawResponse by lazy {
            CensusServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val hightouch: HightouchServiceAsync.WithRawResponse by lazy {
            HightouchServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun census(): CensusServiceAsync.WithRawResponse = census

        override fun hightouch(): HightouchServiceAsync.WithRawResponse = hightouch
    }
}
