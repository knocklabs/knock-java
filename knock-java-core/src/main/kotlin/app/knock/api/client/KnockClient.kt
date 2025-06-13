// File generated from our OpenAPI spec by Stainless.

package app.knock.api.client

import app.knock.api.core.ClientOptions
import app.knock.api.services.blocking.AudienceService
import app.knock.api.services.blocking.BulkOperationService
import app.knock.api.services.blocking.ChannelService
import app.knock.api.services.blocking.IntegrationService
import app.knock.api.services.blocking.MessageService
import app.knock.api.services.blocking.ObjectService
import app.knock.api.services.blocking.ProviderService
import app.knock.api.services.blocking.RecipientService
import app.knock.api.services.blocking.ScheduleService
import app.knock.api.services.blocking.SharedService
import app.knock.api.services.blocking.TenantService
import app.knock.api.services.blocking.UserService
import app.knock.api.services.blocking.WorkflowService
import java.util.function.Consumer

/**
 * A client for interacting with the Knock REST API synchronously. You can also switch to
 * asynchronous execution via the [async] method.
 *
 * This client performs best when you create a single instance and reuse it for all interactions
 * with the REST API. This is because each client holds its own connection pool and thread pools.
 * Reusing connections and threads reduces latency and saves memory. The client also handles rate
 * limiting per client. This means that creating and using multiple instances at the same time will
 * not respect rate limits.
 *
 * The threads and connections that are held will be released automatically if they remain idle. But
 * if you are writing an application that needs to aggressively release unused resources, then you
 * may call [close].
 */
interface KnockClient {

    /**
     * Returns a version of this client that uses asynchronous execution.
     *
     * The returned client shares its resources, like its connection pool and thread pools, with
     * this client.
     */
    fun async(): KnockClientAsync

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): KnockClient

    fun shared(): SharedService

    fun recipients(): RecipientService

    fun users(): UserService

    fun objects(): ObjectService

    fun tenants(): TenantService

    fun bulkOperations(): BulkOperationService

    fun messages(): MessageService

    fun providers(): ProviderService

    fun integrations(): IntegrationService

    fun workflows(): WorkflowService

    fun schedules(): ScheduleService

    fun channels(): ChannelService

    fun audiences(): AudienceService

    /**
     * Closes this client, relinquishing any underlying resources.
     *
     * This is purposefully not inherited from [AutoCloseable] because the client is long-lived and
     * usually should not be synchronously closed via try-with-resources.
     *
     * It's also usually not necessary to call this method at all. the default HTTP client
     * automatically releases threads and connections if they remain idle, but if you are writing an
     * application that needs to aggressively release unused resources, then you may call this
     * method.
     */
    fun close()

    /** A view of [KnockClient] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): KnockClient.WithRawResponse

        fun shared(): SharedService.WithRawResponse

        fun recipients(): RecipientService.WithRawResponse

        fun users(): UserService.WithRawResponse

        fun objects(): ObjectService.WithRawResponse

        fun tenants(): TenantService.WithRawResponse

        fun bulkOperations(): BulkOperationService.WithRawResponse

        fun messages(): MessageService.WithRawResponse

        fun providers(): ProviderService.WithRawResponse

        fun integrations(): IntegrationService.WithRawResponse

        fun workflows(): WorkflowService.WithRawResponse

        fun schedules(): ScheduleService.WithRawResponse

        fun channels(): ChannelService.WithRawResponse

        fun audiences(): AudienceService.WithRawResponse
    }
}
