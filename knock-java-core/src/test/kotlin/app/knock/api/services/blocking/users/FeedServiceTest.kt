// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking.users

import app.knock.api.TestServerExtension
import app.knock.api.client.okhttp.KnockOkHttpClient
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class FeedServiceTest {

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun getSettings() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val feedService = client.users().feeds()

        val response = feedService.getSettings("user_id", "182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")

        response.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun listItems() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val feedService = client.users().feeds()

        val page = feedService.listItems("user_id", "182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")

        page.response().validate()
    }
}
