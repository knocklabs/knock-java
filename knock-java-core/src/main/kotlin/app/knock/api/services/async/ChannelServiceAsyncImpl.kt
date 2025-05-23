// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async

import app.knock.api.core.ClientOptions
import app.knock.api.services.async.channels.BulkServiceAsync
import app.knock.api.services.async.channels.BulkServiceAsyncImpl

class ChannelServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ChannelServiceAsync {

    private val withRawResponse: ChannelServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val bulk: BulkServiceAsync by lazy { BulkServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): ChannelServiceAsync.WithRawResponse = withRawResponse

    override fun bulk(): BulkServiceAsync = bulk

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ChannelServiceAsync.WithRawResponse {

        private val bulk: BulkServiceAsync.WithRawResponse by lazy {
            BulkServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun bulk(): BulkServiceAsync.WithRawResponse = bulk
    }
}
