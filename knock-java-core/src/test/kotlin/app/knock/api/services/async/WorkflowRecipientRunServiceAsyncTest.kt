// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async

import app.knock.api.TestServerExtension
import app.knock.api.client.okhttp.KnockOkHttpClientAsync
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class WorkflowRecipientRunServiceAsyncTest {

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun get() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val workflowRecipientRunServiceAsync = client.workflowRecipientRuns()

        val workflowRecipientRunDetailFuture = workflowRecipientRunServiceAsync.get("id")

        val workflowRecipientRunDetail = workflowRecipientRunDetailFuture.get()
        workflowRecipientRunDetail.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun list() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val workflowRecipientRunServiceAsync = client.workflowRecipientRuns()

        val pageFuture = workflowRecipientRunServiceAsync.list()

        val page = pageFuture.get()
        page.response().validate()
    }
}
