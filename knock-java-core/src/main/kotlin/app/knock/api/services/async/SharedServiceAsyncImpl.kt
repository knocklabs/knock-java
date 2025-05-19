// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async

import app.knock.api.core.ClientOptions

class SharedServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    SharedServiceAsync {

    private val withRawResponse: SharedServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): SharedServiceAsync.WithRawResponse = withRawResponse

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SharedServiceAsync.WithRawResponse
}
