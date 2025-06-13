// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async.recipients

import app.knock.api.core.ClientOptions
import java.util.function.Consumer

class PreferenceServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    PreferenceServiceAsync {

    private val withRawResponse: PreferenceServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): PreferenceServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): PreferenceServiceAsync =
        PreferenceServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        PreferenceServiceAsync.WithRawResponse {

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): PreferenceServiceAsync.WithRawResponse =
            PreferenceServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )
    }
}
