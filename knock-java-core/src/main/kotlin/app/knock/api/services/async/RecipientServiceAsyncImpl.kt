// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async

import app.knock.api.core.ClientOptions
import app.knock.api.services.async.recipients.ChannelDataServiceAsync
import app.knock.api.services.async.recipients.ChannelDataServiceAsyncImpl
import app.knock.api.services.async.recipients.PreferenceServiceAsync
import app.knock.api.services.async.recipients.PreferenceServiceAsyncImpl
import app.knock.api.services.async.recipients.SubscriptionServiceAsync
import app.knock.api.services.async.recipients.SubscriptionServiceAsyncImpl
import java.util.function.Consumer

class RecipientServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    RecipientServiceAsync {

    private val withRawResponse: RecipientServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val subscriptions: SubscriptionServiceAsync by lazy {
        SubscriptionServiceAsyncImpl(clientOptions)
    }

    private val preferences: PreferenceServiceAsync by lazy {
        PreferenceServiceAsyncImpl(clientOptions)
    }

    private val channelData: ChannelDataServiceAsync by lazy {
        ChannelDataServiceAsyncImpl(clientOptions)
    }

    override fun withRawResponse(): RecipientServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): RecipientServiceAsync =
        RecipientServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun subscriptions(): SubscriptionServiceAsync = subscriptions

    override fun preferences(): PreferenceServiceAsync = preferences

    override fun channelData(): ChannelDataServiceAsync = channelData

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        RecipientServiceAsync.WithRawResponse {

        private val subscriptions: SubscriptionServiceAsync.WithRawResponse by lazy {
            SubscriptionServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val preferences: PreferenceServiceAsync.WithRawResponse by lazy {
            PreferenceServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val channelData: ChannelDataServiceAsync.WithRawResponse by lazy {
            ChannelDataServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): RecipientServiceAsync.WithRawResponse =
            RecipientServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun subscriptions(): SubscriptionServiceAsync.WithRawResponse = subscriptions

        override fun preferences(): PreferenceServiceAsync.WithRawResponse = preferences

        override fun channelData(): ChannelDataServiceAsync.WithRawResponse = channelData
    }
}
