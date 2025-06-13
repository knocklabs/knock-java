// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking.recipients

import app.knock.api.core.ClientOptions
import java.util.function.Consumer

class ChannelDataServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ChannelDataService {

    private val withRawResponse: ChannelDataService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ChannelDataService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ChannelDataService =
        ChannelDataServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ChannelDataService.WithRawResponse {

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ChannelDataService.WithRawResponse =
            ChannelDataServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )
    }
}
