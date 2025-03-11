// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.blocking

import com.knock.api.core.ClientOptions

class RecipientServiceImpl internal constructor(
    private val clientOptions: ClientOptions,

) : RecipientService {

    private val withRawResponse: RecipientService.WithRawResponse by lazy { WithRawResponseImpl(clientOptions) }

    override fun withRawResponse(): RecipientService.WithRawResponse = withRawResponse

    class WithRawResponseImpl internal constructor(
        private val clientOptions: ClientOptions,

    ) : RecipientService.WithRawResponse
}
