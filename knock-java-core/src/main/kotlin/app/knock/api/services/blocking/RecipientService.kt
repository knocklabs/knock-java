// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking

import app.knock.api.core.ClientOptions
import app.knock.api.services.blocking.recipients.ChannelDataService
import app.knock.api.services.blocking.recipients.PreferenceService
import app.knock.api.services.blocking.recipients.SubscriptionService
import java.util.function.Consumer

interface RecipientService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): RecipientService

    fun subscriptions(): SubscriptionService

    fun preferences(): PreferenceService

    fun channelData(): ChannelDataService

    /** A view of [RecipientService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): RecipientService.WithRawResponse

        fun subscriptions(): SubscriptionService.WithRawResponse

        fun preferences(): PreferenceService.WithRawResponse

        fun channelData(): ChannelDataService.WithRawResponse
    }
}
