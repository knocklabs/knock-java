// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking.recipients

import app.knock.api.core.ClientOptions

class PreferenceServiceImpl internal constructor(
    private val clientOptions: ClientOptions,

) : PreferenceService {

    private val withRawResponse: PreferenceService.WithRawResponse by lazy { WithRawResponseImpl(clientOptions) }

    override fun withRawResponse(): PreferenceService.WithRawResponse = withRawResponse

    class WithRawResponseImpl internal constructor(
        private val clientOptions: ClientOptions,

    ) : PreferenceService.WithRawResponse
}
