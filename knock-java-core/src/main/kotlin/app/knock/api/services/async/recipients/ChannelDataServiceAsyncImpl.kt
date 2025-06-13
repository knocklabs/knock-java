// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async.recipients

import app.knock.api.core.ClientOptions
import java.util.function.Consumer

class ChannelDataServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ChannelDataServiceAsync {

    private val withRawResponse: ChannelDataServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ChannelDataServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ChannelDataServiceAsync =
        ChannelDataServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ChannelDataServiceAsync.WithRawResponse {

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ChannelDataServiceAsync.WithRawResponse =
            ChannelDataServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )
    }
}
