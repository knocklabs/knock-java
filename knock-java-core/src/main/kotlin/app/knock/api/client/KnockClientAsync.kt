// File generated from our OpenAPI spec by Stainless.

package app.knock.api.client

import app.knock.api.services.async.AudienceServiceAsync
import app.knock.api.services.async.BulkOperationServiceAsync
import app.knock.api.services.async.ChannelServiceAsync
import app.knock.api.services.async.MessageServiceAsync
import app.knock.api.services.async.ObjectServiceAsync
import app.knock.api.services.async.ProviderServiceAsync
import app.knock.api.services.async.RecipientServiceAsync
import app.knock.api.services.async.ScheduleServiceAsync
import app.knock.api.services.async.TenantServiceAsync
import app.knock.api.services.async.UserServiceAsync
import app.knock.api.services.async.WorkflowServiceAsync

/**
 * A client for interacting with the Knock REST API asynchronously. You can also
 * switch to synchronous execution via the [sync] method.
 *
 * This client performs best when you create a single instance and reuse it for all
 * interactions with the REST API. This is because each client holds its own
 * connection pool and thread pools. Reusing connections and threads reduces
 * latency and saves memory. The client also handles rate limiting per client. This
 * means that creating and using multiple instances at the same time will not
 * respect rate limits.
 *
 * The threads and connections that are held will be released automatically if they
 * remain idle. But if you are writing an application that needs to aggressively
 * release unused resources, then you may call [close].
 */
interface KnockClientAsync {

    /**
     * Returns a version of this client that uses synchronous execution.
     *
     * The returned client shares its resources, like its connection pool and thread
     * pools, with this client.
     */
    fun sync(): KnockClient

    /**
     * Returns a view of this service that provides access to raw HTTP responses for
     * each method.
     */
    fun withRawResponse(): WithRawResponse

    fun recipients(): RecipientServiceAsync

    fun users(): UserServiceAsync

    fun objects(): ObjectServiceAsync

    fun tenants(): TenantServiceAsync

    fun bulkOperations(): BulkOperationServiceAsync

    fun messages(): MessageServiceAsync

    fun providers(): ProviderServiceAsync

    fun workflows(): WorkflowServiceAsync

    fun schedules(): ScheduleServiceAsync

    fun channels(): ChannelServiceAsync

    fun audiences(): AudienceServiceAsync

    /**
     * Closes this client, relinquishing any underlying resources.
     *
     * This is purposefully not inherited from [AutoCloseable] because the client is
     * long-lived and usually should not be synchronously closed via
     * try-with-resources.
     *
     * It's also usually not necessary to call this method at all. the default HTTP
     * client automatically releases threads and connections if they remain idle, but
     * if you are writing an application that needs to aggressively release unused
     * resources, then you may call this method.
     */
    fun close()

    /**
     * A view of [KnockClientAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        fun recipients(): RecipientServiceAsync.WithRawResponse

        fun users(): UserServiceAsync.WithRawResponse

        fun objects(): ObjectServiceAsync.WithRawResponse

        fun tenants(): TenantServiceAsync.WithRawResponse

        fun bulkOperations(): BulkOperationServiceAsync.WithRawResponse

        fun messages(): MessageServiceAsync.WithRawResponse

        fun providers(): ProviderServiceAsync.WithRawResponse

        fun workflows(): WorkflowServiceAsync.WithRawResponse

        fun schedules(): ScheduleServiceAsync.WithRawResponse

        fun channels(): ChannelServiceAsync.WithRawResponse

        fun audiences(): AudienceServiceAsync.WithRawResponse
    }
}
