// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.blocking

import com.knock.api.core.ClientOptions
import com.knock.api.services.blocking.channels.BulkService
import com.knock.api.services.blocking.channels.BulkServiceImpl

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
