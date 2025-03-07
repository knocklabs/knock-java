// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.async

import com.knock.api.TestServerExtension
import com.knock.api.client.okhttp.KnockOkHttpClientAsync
import com.knock.api.core.JsonValue
import com.knock.api.models.WorkflowCancelParams
import com.knock.api.models.WorkflowTriggerParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class WorkflowServiceAsyncTest {

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun cancel() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val workflowServiceAsync = client.workflows()

        val responseFuture =
            workflowServiceAsync.cancel(
                WorkflowCancelParams.builder()
                    .key("key")
                    .cancellationKey("cancel-workflow-123")
                    .addRecipient("jhammond")
                    .tenant("prk_1")
                    .build()
            )

        val response = responseFuture.get()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun trigger() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val workflowServiceAsync = client.workflows()

        val responseFuture =
            workflowServiceAsync.trigger(
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
            )

        val response = responseFuture.get()
        response.validate()
    }
}
