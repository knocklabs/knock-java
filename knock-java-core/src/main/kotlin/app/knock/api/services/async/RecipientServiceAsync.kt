// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async

import app.knock.api.services.async.recipients.ChannelDataServiceAsync
import app.knock.api.services.async.recipients.PreferenceServiceAsync
import app.knock.api.services.async.recipients.SubscriptionServiceAsync

interface RecipientServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for
     * each method.
     */
    fun withRawResponse(): WithRawResponse

    fun subscriptions(): SubscriptionServiceAsync

    fun preferences(): PreferenceServiceAsync

    fun channelData(): ChannelDataServiceAsync

    /**
     * A view of [RecipientServiceAsync] that provides access to raw HTTP responses for
     * each method.
     */
    interface WithRawResponse {

        fun subscriptions(): SubscriptionServiceAsync.WithRawResponse

        fun preferences(): PreferenceServiceAsync.WithRawResponse

        fun channelData(): ChannelDataServiceAsync.WithRawResponse
    }
}
