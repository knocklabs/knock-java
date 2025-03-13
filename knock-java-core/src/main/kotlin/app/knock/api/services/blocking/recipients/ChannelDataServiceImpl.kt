// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking.recipients

import app.knock.api.core.ClientOptions

class ChannelDataServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ChannelDataService {

    private val withRawResponse: ChannelDataService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ChannelDataService.WithRawResponse = withRawResponse

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ChannelDataService.WithRawResponse
}
