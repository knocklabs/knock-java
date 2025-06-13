// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async

import app.knock.api.core.ClientOptions
import app.knock.api.services.async.recipients.ChannelDataServiceAsync
import app.knock.api.services.async.recipients.PreferenceServiceAsync
import app.knock.api.services.async.recipients.SubscriptionServiceAsync
import java.util.function.Consumer

interface RecipientServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): RecipientServiceAsync

    fun subscriptions(): SubscriptionServiceAsync

    fun preferences(): PreferenceServiceAsync

    fun channelData(): ChannelDataServiceAsync

    /**
     * A view of [RecipientServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): RecipientServiceAsync.WithRawResponse

        fun subscriptions(): SubscriptionServiceAsync.WithRawResponse

        fun preferences(): PreferenceServiceAsync.WithRawResponse

        fun channelData(): ChannelDataServiceAsync.WithRawResponse
    }
}
