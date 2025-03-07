// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.async

import com.knock.api.core.ClientOptions

class RecipientServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    RecipientServiceAsync {

    private val withRawResponse: RecipientServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): RecipientServiceAsync.WithRawResponse = withRawResponse

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        RecipientServiceAsync.WithRawResponse
}
