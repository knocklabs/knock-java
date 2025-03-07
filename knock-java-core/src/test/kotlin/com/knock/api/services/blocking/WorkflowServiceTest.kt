// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.blocking

import com.knock.api.TestServerExtension
import com.knock.api.client.okhttp.KnockOkHttpClient
import com.knock.api.core.JsonValue
import com.knock.api.models.WorkflowCancelParams
import com.knock.api.models.WorkflowTriggerParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class WorkflowServiceTest {

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
                .tenant("prk_1")
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

        response.validate()
    }
}
