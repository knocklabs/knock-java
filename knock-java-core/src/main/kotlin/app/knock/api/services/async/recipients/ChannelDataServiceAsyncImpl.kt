// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async.recipients

import app.knock.api.core.ClientOptions

class ChannelDataServiceAsyncImpl internal constructor(
    private val clientOptions: ClientOptions,

) : ChannelDataServiceAsync {

    private val withRawResponse: ChannelDataServiceAsync.WithRawResponse by lazy { WithRawResponseImpl(clientOptions) }

    override fun withRawResponse(): ChannelDataServiceAsync.WithRawResponse = withRawResponse

    class WithRawResponseImpl internal constructor(
        private val clientOptions: ClientOptions,

    ) : ChannelDataServiceAsync.WithRawResponse
}
