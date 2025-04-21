// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking

import app.knock.api.core.ClientOptions

class SharedServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    SharedService {

    private val withRawResponse: SharedService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): SharedService.WithRawResponse = withRawResponse

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SharedService.WithRawResponse
}
