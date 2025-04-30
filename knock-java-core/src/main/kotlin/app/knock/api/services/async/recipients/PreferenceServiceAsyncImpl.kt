// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async.recipients

import app.knock.api.core.ClientOptions

class PreferenceServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    PreferenceServiceAsync {

    private val withRawResponse: PreferenceServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): PreferenceServiceAsync.WithRawResponse = withRawResponse

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        PreferenceServiceAsync.WithRawResponse
}
