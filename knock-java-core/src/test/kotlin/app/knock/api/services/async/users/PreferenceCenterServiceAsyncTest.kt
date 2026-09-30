// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async.users

import app.knock.api.TestServerExtension
import app.knock.api.client.okhttp.KnockOkHttpClientAsync
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class PreferenceCenterServiceAsyncTest {

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun generateSignedUrl() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val preferenceCenterServiceAsync = client.users().preferenceCenter()

        val responseFuture = preferenceCenterServiceAsync.generateSignedUrl("user_id")

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun getConfig() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val preferenceCenterServiceAsync = client.users().preferenceCenter()

        val responseFuture = preferenceCenterServiceAsync.getConfig("user_id")

        val response = responseFuture.get()
        response.validate()
    }
}
