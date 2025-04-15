// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking.objects

import app.knock.api.TestServerExtension
import app.knock.api.client.okhttp.KnockOkHttpClient
import app.knock.api.models.objects.bulk.BulkAddSubscriptionsParams
import app.knock.api.models.objects.bulk.BulkDeleteParams
import app.knock.api.models.objects.bulk.BulkSetParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class BulkServiceTest {

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun delete() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val bulkService = client.objects().bulk()

        val bulkOperation =
            bulkService.delete(
                BulkDeleteParams.builder().collection("collection").addObjectId("string").build()
            )

        bulkOperation.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun addSubscriptions() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val bulkService = client.objects().bulk()

        val bulkOperation =
            bulkService.addSubscriptions(
                BulkAddSubscriptionsParams.builder().collection("projects").build()
            )

        bulkOperation.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun set() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val bulkService = client.objects().bulk()

        val bulkOperation =
            bulkService.set(BulkSetParams.builder().collection("collection").build())

        bulkOperation.validate()
    }
}
