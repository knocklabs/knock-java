// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking

import app.knock.api.core.ClientOptions
import app.knock.api.services.blocking.recipients.ChannelDataService
import app.knock.api.services.blocking.recipients.ChannelDataServiceImpl
import app.knock.api.services.blocking.recipients.PreferenceService
import app.knock.api.services.blocking.recipients.PreferenceServiceImpl
import app.knock.api.services.blocking.recipients.SubscriptionService
import app.knock.api.services.blocking.recipients.SubscriptionServiceImpl
import java.util.function.Consumer

class RecipientServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    RecipientService {

    private val withRawResponse: RecipientService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val subscriptions: SubscriptionService by lazy {
        SubscriptionServiceImpl(clientOptions)
    }

    private val preferences: PreferenceService by lazy { PreferenceServiceImpl(clientOptions) }

    private val channelData: ChannelDataService by lazy { ChannelDataServiceImpl(clientOptions) }

    override fun withRawResponse(): RecipientService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): RecipientService =
        RecipientServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun subscriptions(): SubscriptionService = subscriptions

    override fun preferences(): PreferenceService = preferences

    override fun channelData(): ChannelDataService = channelData

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        RecipientService.WithRawResponse {

        private val subscriptions: SubscriptionService.WithRawResponse by lazy {
            SubscriptionServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val preferences: PreferenceService.WithRawResponse by lazy {
            PreferenceServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val channelData: ChannelDataService.WithRawResponse by lazy {
            ChannelDataServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): RecipientService.WithRawResponse =
            RecipientServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun subscriptions(): SubscriptionService.WithRawResponse = subscriptions

        override fun preferences(): PreferenceService.WithRawResponse = preferences

        override fun channelData(): ChannelDataService.WithRawResponse = channelData
    }
}
