// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async.objects

import app.knock.api.TestServerExtension
import app.knock.api.client.okhttp.KnockOkHttpClientAsync
import app.knock.api.models.objects.bulk.BulkAddSubscriptionsParams
import app.knock.api.models.objects.bulk.BulkDeleteParams
import app.knock.api.models.objects.bulk.BulkSetParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class BulkServiceAsyncTest {

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun delete() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val bulkServiceAsync = client.objects().bulk()

        val bulkOperationFuture =
            bulkServiceAsync.delete(
                BulkDeleteParams.builder().collection("collection").addObjectId("string").build()
            )

        val bulkOperation = bulkOperationFuture.get()
        bulkOperation.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun addSubscriptions() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val bulkServiceAsync = client.objects().bulk()

        val bulkOperationFuture =
            bulkServiceAsync.addSubscriptions(
                BulkAddSubscriptionsParams.builder().collection("projects").build()
            )

        val bulkOperation = bulkOperationFuture.get()
        bulkOperation.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun set() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val bulkServiceAsync = client.objects().bulk()

        val bulkOperationFuture =
            bulkServiceAsync.set(BulkSetParams.builder().collection("collection").build())

        val bulkOperation = bulkOperationFuture.get()
        bulkOperation.validate()
    }
}
