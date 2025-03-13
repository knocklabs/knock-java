// File generated from our OpenAPI spec by Stainless.

package app.knock.api.client

import app.knock.api.core.ClientOptions
import app.knock.api.core.getPackageVersion
import app.knock.api.services.async.AudienceServiceAsync
import app.knock.api.services.async.AudienceServiceAsyncImpl
import app.knock.api.services.async.BulkOperationServiceAsync
import app.knock.api.services.async.BulkOperationServiceAsyncImpl
import app.knock.api.services.async.ChannelServiceAsync
import app.knock.api.services.async.ChannelServiceAsyncImpl
import app.knock.api.services.async.MessageServiceAsync
import app.knock.api.services.async.MessageServiceAsyncImpl
import app.knock.api.services.async.ObjectServiceAsync
import app.knock.api.services.async.ObjectServiceAsyncImpl
import app.knock.api.services.async.ProviderServiceAsync
import app.knock.api.services.async.ProviderServiceAsyncImpl
import app.knock.api.services.async.RecipientServiceAsync
import app.knock.api.services.async.RecipientServiceAsyncImpl
import app.knock.api.services.async.ScheduleServiceAsync
import app.knock.api.services.async.ScheduleServiceAsyncImpl
import app.knock.api.services.async.TenantServiceAsync
import app.knock.api.services.async.TenantServiceAsyncImpl
import app.knock.api.services.async.UserServiceAsync
import app.knock.api.services.async.UserServiceAsyncImpl
import app.knock.api.services.async.WorkflowServiceAsync
import app.knock.api.services.async.WorkflowServiceAsyncImpl

class KnockClientAsyncImpl(
    private val clientOptions: ClientOptions,

) : KnockClientAsync {

    private val clientOptionsWithUserAgent =

      if (clientOptions.headers.names().contains("User-Agent")) clientOptions

      else clientOptions.toBuilder().putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}").build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val sync: KnockClient by lazy { KnockClientImpl(clientOptions) }

    private val withRawResponse: KnockClientAsync.WithRawResponse by lazy { WithRawResponseImpl(clientOptions) }

    private val recipients: RecipientServiceAsync by lazy { RecipientServiceAsyncImpl(clientOptionsWithUserAgent) }

    private val users: UserServiceAsync by lazy { UserServiceAsyncImpl(clientOptionsWithUserAgent) }

    private val objects: ObjectServiceAsync by lazy { ObjectServiceAsyncImpl(clientOptionsWithUserAgent) }

    private val tenants: TenantServiceAsync by lazy { TenantServiceAsyncImpl(clientOptionsWithUserAgent) }

    private val bulkOperations: BulkOperationServiceAsync by lazy { BulkOperationServiceAsyncImpl(clientOptionsWithUserAgent) }

    private val messages: MessageServiceAsync by lazy { MessageServiceAsyncImpl(clientOptionsWithUserAgent) }

    private val providers: ProviderServiceAsync by lazy { ProviderServiceAsyncImpl(clientOptionsWithUserAgent) }

    private val workflows: WorkflowServiceAsync by lazy { WorkflowServiceAsyncImpl(clientOptionsWithUserAgent) }

    private val schedules: ScheduleServiceAsync by lazy { ScheduleServiceAsyncImpl(clientOptionsWithUserAgent) }

    private val channels: ChannelServiceAsync by lazy { ChannelServiceAsyncImpl(clientOptionsWithUserAgent) }

    private val audiences: AudienceServiceAsync by lazy { AudienceServiceAsyncImpl(clientOptionsWithUserAgent) }

    override fun sync(): KnockClient = sync

    override fun withRawResponse(): KnockClientAsync.WithRawResponse = withRawResponse

    override fun recipients(): RecipientServiceAsync = recipients

    override fun users(): UserServiceAsync = users

    override fun objects(): ObjectServiceAsync = objects

    override fun tenants(): TenantServiceAsync = tenants

    override fun bulkOperations(): BulkOperationServiceAsync = bulkOperations

    override fun messages(): MessageServiceAsync = messages

    override fun providers(): ProviderServiceAsync = providers

    override fun workflows(): WorkflowServiceAsync = workflows

    override fun schedules(): ScheduleServiceAsync = schedules

    override fun channels(): ChannelServiceAsync = channels

    override fun audiences(): AudienceServiceAsync = audiences

    override fun close() = clientOptions.httpClient.close()

    class WithRawResponseImpl internal constructor(
        private val clientOptions: ClientOptions,

    ) : KnockClientAsync.WithRawResponse {

        private val recipients: RecipientServiceAsync.WithRawResponse by lazy { RecipientServiceAsyncImpl.WithRawResponseImpl(clientOptions) }

        private val users: UserServiceAsync.WithRawResponse by lazy { UserServiceAsyncImpl.WithRawResponseImpl(clientOptions) }

        private val objects: ObjectServiceAsync.WithRawResponse by lazy { ObjectServiceAsyncImpl.WithRawResponseImpl(clientOptions) }

        private val tenants: TenantServiceAsync.WithRawResponse by lazy { TenantServiceAsyncImpl.WithRawResponseImpl(clientOptions) }

        private val bulkOperations: BulkOperationServiceAsync.WithRawResponse by lazy { BulkOperationServiceAsyncImpl.WithRawResponseImpl(clientOptions) }

        private val messages: MessageServiceAsync.WithRawResponse by lazy { MessageServiceAsyncImpl.WithRawResponseImpl(clientOptions) }

        private val providers: ProviderServiceAsync.WithRawResponse by lazy { ProviderServiceAsyncImpl.WithRawResponseImpl(clientOptions) }

        private val workflows: WorkflowServiceAsync.WithRawResponse by lazy { WorkflowServiceAsyncImpl.WithRawResponseImpl(clientOptions) }

        private val schedules: ScheduleServiceAsync.WithRawResponse by lazy { ScheduleServiceAsyncImpl.WithRawResponseImpl(clientOptions) }

        private val channels: ChannelServiceAsync.WithRawResponse by lazy { ChannelServiceAsyncImpl.WithRawResponseImpl(clientOptions) }

        private val audiences: AudienceServiceAsync.WithRawResponse by lazy { AudienceServiceAsyncImpl.WithRawResponseImpl(clientOptions) }

        override fun recipients(): RecipientServiceAsync.WithRawResponse = recipients

        override fun users(): UserServiceAsync.WithRawResponse = users

        override fun objects(): ObjectServiceAsync.WithRawResponse = objects

        override fun tenants(): TenantServiceAsync.WithRawResponse = tenants

        override fun bulkOperations(): BulkOperationServiceAsync.WithRawResponse = bulkOperations

        override fun messages(): MessageServiceAsync.WithRawResponse = messages

        override fun providers(): ProviderServiceAsync.WithRawResponse = providers

        override fun workflows(): WorkflowServiceAsync.WithRawResponse = workflows

        override fun schedules(): ScheduleServiceAsync.WithRawResponse = schedules

        override fun channels(): ChannelServiceAsync.WithRawResponse = channels

        override fun audiences(): AudienceServiceAsync.WithRawResponse = audiences
    }
}
