// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async.users

import app.knock.api.core.ClientOptions

class FeedServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    FeedServiceAsync {

    private val withRawResponse: FeedServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): FeedServiceAsync.WithRawResponse = withRawResponse

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        FeedServiceAsync.WithRawResponse
}
