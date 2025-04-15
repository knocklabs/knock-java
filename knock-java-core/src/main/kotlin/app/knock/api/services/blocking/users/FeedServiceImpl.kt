// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking.users

import app.knock.api.core.ClientOptions

class FeedServiceImpl internal constructor(private val clientOptions: ClientOptions) : FeedService {

    private val withRawResponse: FeedService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): FeedService.WithRawResponse = withRawResponse

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        FeedService.WithRawResponse
}
