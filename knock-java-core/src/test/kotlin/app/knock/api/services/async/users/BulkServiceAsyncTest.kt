// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async.users

import app.knock.api.TestServerExtension
import app.knock.api.client.okhttp.KnockOkHttpClientAsync
import app.knock.api.models.users.bulk.BulkDeleteParams
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
        val bulkServiceAsync = client.users().bulk()

        val bulkOperationFuture =
            bulkServiceAsync.delete(BulkDeleteParams.builder().addUserId("string").build())

        val bulkOperation = bulkOperationFuture.get()
        bulkOperation.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun identify() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val bulkServiceAsync = client.users().bulk()

        val bulkOperationFuture = bulkServiceAsync.identify()

        val bulkOperation = bulkOperationFuture.get()
        bulkOperation.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun setPreferences() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val bulkServiceAsync = client.users().bulk()

        val bulkOperationFuture = bulkServiceAsync.setPreferences()

        val bulkOperation = bulkOperationFuture.get()
        bulkOperation.validate()
    }
}
