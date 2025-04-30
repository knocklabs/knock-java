// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking

import app.knock.api.TestServerExtension
import app.knock.api.client.okhttp.KnockOkHttpClient
import app.knock.api.core.JsonValue
import app.knock.api.models.recipients.RecipientRequest
import app.knock.api.models.workflows.WorkflowCancelParams
import app.knock.api.models.workflows.WorkflowTriggerParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class WorkflowServiceTest {

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun cancel() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val workflowService = client.workflows()

        workflowService.cancel(
            WorkflowCancelParams.builder()
                .key("key")
                .cancellationKey("cancel-workflow-123")
                .addRecipient("jhammond")
                .build()
        )
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun trigger() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val workflowService = client.workflows()

        val response =
            workflowService.trigger(
                WorkflowTriggerParams.builder()
                    .key("key")
                    .recipients(
                        listOf(
                            RecipientRequest.ofUserRecipient("dr_grant"),
                            RecipientRequest.ofUserRecipient("dr_sattler"),
                            RecipientRequest.ofUserRecipient("dr_malcolm"),
                        )
                    )
                    .actor("mr_dna")
                    .cancellationKey("isla_nublar_incident_1993")
                    .data(
                        WorkflowTriggerParams.Data.builder()
                            .putAdditionalProperty("affected_areas", JsonValue.from("bar"))
                            .putAdditionalProperty("attraction_id", JsonValue.from("bar"))
                            .putAdditionalProperty("evacuation_protocol", JsonValue.from("bar"))
                            .putAdditionalProperty("message", JsonValue.from("bar"))
                            .putAdditionalProperty("severity", JsonValue.from("bar"))
                            .putAdditionalProperty("system_status", JsonValue.from("bar"))
                            .build()
                    )
                    .tenant("ingen_isla_nublar")
                    .build()
            )

        response.validate()
    }
}
