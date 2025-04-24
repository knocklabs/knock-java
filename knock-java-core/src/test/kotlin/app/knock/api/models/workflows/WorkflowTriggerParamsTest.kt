// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.workflows

import app.knock.api.core.JsonValue
import app.knock.api.models.recipients.RecipientRequest
import app.knock.api.models.tenants.InlineTenantRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WorkflowTriggerParamsTest {

    @Test
    fun create() {
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
    }

    @Test
    fun pathParams() {
        val params =
            WorkflowTriggerParams.builder()
                .key("key")
                .recipients(
                    listOf(
                        RecipientRequest.ofUserRecipient("dr_grant"),
                        RecipientRequest.ofUserRecipient("dr_sattler"),
                        RecipientRequest.ofUserRecipient("dr_malcolm"),
                    )
                )
                .build()

        assertThat(params._pathParam(0)).isEqualTo("key")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
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

        val body = params._body()

        assertThat(body.recipients())
            .containsExactly(
                RecipientRequest.ofUserRecipient("dr_grant"),
                RecipientRequest.ofUserRecipient("dr_sattler"),
                RecipientRequest.ofUserRecipient("dr_malcolm"),
            )
        assertThat(body.actor()).contains(RecipientRequest.ofUserRecipient("mr_dna"))
        assertThat(body.cancellationKey()).contains("isla_nublar_incident_1993")
        assertThat(body.data())
            .contains(
                WorkflowTriggerParams.Data.builder()
                    .putAdditionalProperty("affected_areas", JsonValue.from("bar"))
                    .putAdditionalProperty("attraction_id", JsonValue.from("bar"))
                    .putAdditionalProperty("evacuation_protocol", JsonValue.from("bar"))
                    .putAdditionalProperty("message", JsonValue.from("bar"))
                    .putAdditionalProperty("severity", JsonValue.from("bar"))
                    .putAdditionalProperty("system_status", JsonValue.from("bar"))
                    .build()
            )
        assertThat(body.tenant()).contains(InlineTenantRequest.ofString("ingen_isla_nublar"))
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            WorkflowTriggerParams.builder()
                .key("key")
                .recipients(
                    listOf(
                        RecipientRequest.ofUserRecipient("dr_grant"),
                        RecipientRequest.ofUserRecipient("dr_sattler"),
                        RecipientRequest.ofUserRecipient("dr_malcolm"),
                    )
                )
                .build()

        val body = params._body()

        assertThat(body.recipients())
            .containsExactly(
                RecipientRequest.ofUserRecipient("dr_grant"),
                RecipientRequest.ofUserRecipient("dr_sattler"),
                RecipientRequest.ofUserRecipient("dr_malcolm"),
            )
    }
}
