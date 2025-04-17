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
            .addRecipient("jhammond")
            .actor("string")
            .cancellationKey(null)
            .data(
                WorkflowTriggerParams.Data.builder()
                    .putAdditionalProperty("dinosaur_names", JsonValue.from("bar"))
                    .putAdditionalProperty("is_alert", JsonValue.from("bar"))
                    .putAdditionalProperty("park_id", JsonValue.from("bar"))
                    .putAdditionalProperty("severity", JsonValue.from("bar"))
                    .putAdditionalProperty("welcome_message", JsonValue.from("bar"))
                    .build()
            )
            .tenant("acme_corp")
            .build()
    }

    @Test
    fun pathParams() {
        val params = WorkflowTriggerParams.builder().key("key").addRecipient("jhammond").build()

        assertThat(params._pathParam(0)).isEqualTo("key")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            WorkflowTriggerParams.builder()
                .key("key")
                .addRecipient("jhammond")
                .actor("string")
                .cancellationKey(null)
                .data(
                    WorkflowTriggerParams.Data.builder()
                        .putAdditionalProperty("dinosaur_names", JsonValue.from("bar"))
                        .putAdditionalProperty("is_alert", JsonValue.from("bar"))
                        .putAdditionalProperty("park_id", JsonValue.from("bar"))
                        .putAdditionalProperty("severity", JsonValue.from("bar"))
                        .putAdditionalProperty("welcome_message", JsonValue.from("bar"))
                        .build()
                )
                .tenant("acme_corp")
                .build()

        val body = params._body()

        assertThat(body.recipients()).containsExactly(RecipientRequest.ofString("jhammond"))
        assertThat(body.actor()).contains(RecipientRequest.ofString("string"))
        assertThat(body.cancellationKey()).isEmpty
        assertThat(body.data())
            .contains(
                WorkflowTriggerParams.Data.builder()
                    .putAdditionalProperty("dinosaur_names", JsonValue.from("bar"))
                    .putAdditionalProperty("is_alert", JsonValue.from("bar"))
                    .putAdditionalProperty("park_id", JsonValue.from("bar"))
                    .putAdditionalProperty("severity", JsonValue.from("bar"))
                    .putAdditionalProperty("welcome_message", JsonValue.from("bar"))
                    .build()
            )
        assertThat(body.tenant()).contains(InlineTenantRequest.ofString("acme_corp"))
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = WorkflowTriggerParams.builder().key("key").addRecipient("jhammond").build()

        val body = params._body()

        assertThat(body.recipients()).containsExactly(RecipientRequest.ofString("jhammond"))
    }
}
