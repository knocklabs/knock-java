// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking.integrations

import app.knock.api.TestServerExtension
import app.knock.api.client.okhttp.KnockOkHttpClient
import app.knock.api.core.JsonValue
import app.knock.api.models.integrations.hightouch.HightouchEmbeddedDestinationParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class HightouchServiceTest {

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun embeddedDestination() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val hightouchService = client.integrations().hightouch()

        val response =
            hightouchService.embeddedDestination(
                HightouchEmbeddedDestinationParams.builder()
                    .id("id")
                    .jsonrpc("jsonrpc")
                    .method("method")
                    .params(JsonValue.from(mapOf<String, Any>()))
                    .build()
            )

        response.validate()
    }
}
