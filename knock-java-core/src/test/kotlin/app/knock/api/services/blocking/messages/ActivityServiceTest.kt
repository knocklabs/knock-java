// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking.messages

import app.knock.api.TestServerExtension
import app.knock.api.client.okhttp.KnockOkHttpClient
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ActivityServiceTest {

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun list() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val activityService = client.messages().activities()

        val page = activityService.list("message_id")

        page.response().validate()
    }
}
