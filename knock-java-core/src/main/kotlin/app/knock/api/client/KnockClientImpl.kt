// File generated from our OpenAPI spec by Stainless.

package app.knock.api.client

import app.knock.api.core.ClientOptions
import app.knock.api.core.getPackageVersion
import app.knock.api.services.blocking.AudienceService
import app.knock.api.services.blocking.AudienceServiceImpl
import app.knock.api.services.blocking.BulkOperationService
import app.knock.api.services.blocking.BulkOperationServiceImpl
import app.knock.api.services.blocking.ChannelService
import app.knock.api.services.blocking.ChannelServiceImpl
import app.knock.api.services.blocking.MessageService
import app.knock.api.services.blocking.MessageServiceImpl
import app.knock.api.services.blocking.ObjectService
import app.knock.api.services.blocking.ObjectServiceImpl
import app.knock.api.services.blocking.ProviderService
import app.knock.api.services.blocking.ProviderServiceImpl
import app.knock.api.services.blocking.RecipientService
import app.knock.api.services.blocking.RecipientServiceImpl
import app.knock.api.services.blocking.ScheduleService
import app.knock.api.services.blocking.ScheduleServiceImpl
import app.knock.api.services.blocking.TenantService
import app.knock.api.services.blocking.TenantServiceImpl
import app.knock.api.services.blocking.UserService
import app.knock.api.services.blocking.UserServiceImpl
import app.knock.api.services.blocking.WorkflowService
import app.knock.api.services.blocking.WorkflowServiceImpl

class KnockClientImpl(private val clientOptions: ClientOptions) : KnockClient {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val async: KnockClientAsync by lazy { KnockClientAsyncImpl(clientOptions) }

    private val withRawResponse: KnockClient.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val recipients: RecipientService by lazy {
        RecipientServiceImpl(clientOptionsWithUserAgent)
    }

    private val users: UserService by lazy { UserServiceImpl(clientOptionsWithUserAgent) }

    private val objects: ObjectService by lazy { ObjectServiceImpl(clientOptionsWithUserAgent) }

    private val tenants: TenantService by lazy { TenantServiceImpl(clientOptionsWithUserAgent) }

    private val bulkOperations: BulkOperationService by lazy {
        BulkOperationServiceImpl(clientOptionsWithUserAgent)
    }

    private val messages: MessageService by lazy { MessageServiceImpl(clientOptionsWithUserAgent) }

    private val providers: ProviderService by lazy {
        ProviderServiceImpl(clientOptionsWithUserAgent)
    }

    private val workflows: WorkflowService by lazy {
        WorkflowServiceImpl(clientOptionsWithUserAgent)
    }

    private val schedules: ScheduleService by lazy {
        ScheduleServiceImpl(clientOptionsWithUserAgent)
    }

    private val channels: ChannelService by lazy { ChannelServiceImpl(clientOptionsWithUserAgent) }

    private val audiences: AudienceService by lazy {
        AudienceServiceImpl(clientOptionsWithUserAgent)
    }

    override fun async(): KnockClientAsync = async

    override fun withRawResponse(): KnockClient.WithRawResponse = withRawResponse

    override fun recipients(): RecipientService = recipients

    override fun users(): UserService = users

    override fun objects(): ObjectService = objects

    override fun tenants(): TenantService = tenants

    override fun bulkOperations(): BulkOperationService = bulkOperations

    override fun messages(): MessageService = messages

    override fun providers(): ProviderService = providers

    override fun workflows(): WorkflowService = workflows

    override fun schedules(): ScheduleService = schedules

    override fun channels(): ChannelService = channels

    override fun audiences(): AudienceService = audiences

    override fun close() = clientOptions.httpClient.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        KnockClient.WithRawResponse {

        private val recipients: RecipientService.WithRawResponse by lazy {
            RecipientServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val users: UserService.WithRawResponse by lazy {
            UserServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val objects: ObjectService.WithRawResponse by lazy {
            ObjectServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val tenants: TenantService.WithRawResponse by lazy {
            TenantServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val bulkOperations: BulkOperationService.WithRawResponse by lazy {
            BulkOperationServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val messages: MessageService.WithRawResponse by lazy {
            MessageServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val providers: ProviderService.WithRawResponse by lazy {
            ProviderServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val workflows: WorkflowService.WithRawResponse by lazy {
            WorkflowServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val schedules: ScheduleService.WithRawResponse by lazy {
            ScheduleServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val channels: ChannelService.WithRawResponse by lazy {
            ChannelServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val audiences: AudienceService.WithRawResponse by lazy {
            AudienceServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun recipients(): RecipientService.WithRawResponse = recipients

        override fun users(): UserService.WithRawResponse = users

        override fun objects(): ObjectService.WithRawResponse = objects

        override fun tenants(): TenantService.WithRawResponse = tenants

        override fun bulkOperations(): BulkOperationService.WithRawResponse = bulkOperations

        override fun messages(): MessageService.WithRawResponse = messages

        override fun providers(): ProviderService.WithRawResponse = providers

        override fun workflows(): WorkflowService.WithRawResponse = workflows

        override fun schedules(): ScheduleService.WithRawResponse = schedules

        override fun channels(): ChannelService.WithRawResponse = channels

        override fun audiences(): AudienceService.WithRawResponse = audiences
    }
}
