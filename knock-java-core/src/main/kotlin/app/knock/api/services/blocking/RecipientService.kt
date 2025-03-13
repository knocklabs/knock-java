// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking

import app.knock.api.services.blocking.recipients.ChannelDataService
import app.knock.api.services.blocking.recipients.PreferenceService
import app.knock.api.services.blocking.recipients.SubscriptionService

interface RecipientService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun subscriptions(): SubscriptionService

    fun preferences(): PreferenceService

    fun channelData(): ChannelDataService

    /** A view of [RecipientService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun subscriptions(): SubscriptionService.WithRawResponse

        fun preferences(): PreferenceService.WithRawResponse

        fun channelData(): ChannelDataService.WithRawResponse
    }
}
