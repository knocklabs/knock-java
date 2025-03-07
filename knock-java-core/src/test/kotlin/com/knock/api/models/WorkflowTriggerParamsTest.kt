// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import com.knock.api.core.JsonValue
import kotlin.test.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WorkflowTriggerParamsTest {

    @Test
    fun create() {
        WorkflowTriggerParams.builder()
            .key("key")
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
            .addRecipient("jhammond")
            .tenant("acme_corp")
            .build()
    }

    @Test
    fun body() {
        val params =
            WorkflowTriggerParams.builder()
                .key("key")
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
                .addRecipient("jhammond")
                .tenant("acme_corp")
                .build()

        val body = params._body()

        assertNotNull(body)
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
        assertThat(body.recipients()).contains(listOf(RecipientRequest.ofString("jhammond")))
        assertThat(body.tenant()).contains(InlineTenantRequest.ofString("acme_corp"))
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = WorkflowTriggerParams.builder().key("key").build()

        val body = params._body()

        assertNotNull(body)
    }

    @Test
    fun getPathParam() {
        val params = WorkflowTriggerParams.builder().key("key").build()
        assertThat(params).isNotNull
        // path param "key"
        assertThat(params.getPathParam(0)).isEqualTo("key")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
