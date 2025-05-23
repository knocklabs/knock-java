// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking

import app.knock.api.core.ClientOptions
import app.knock.api.services.blocking.channels.BulkService
import app.knock.api.services.blocking.channels.BulkServiceImpl

class ChannelServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ChannelService {

    private val withRawResponse: ChannelService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val bulk: BulkService by lazy { BulkServiceImpl(clientOptions) }

    override fun withRawResponse(): ChannelService.WithRawResponse = withRawResponse

    override fun bulk(): BulkService = bulk

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ChannelService.WithRawResponse {

        private val bulk: BulkService.WithRawResponse by lazy {
            BulkServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun bulk(): BulkService.WithRawResponse = bulk
    }
}
