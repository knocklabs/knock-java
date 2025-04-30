// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async.integrations

import app.knock.api.TestServerExtension
import app.knock.api.client.okhttp.KnockOkHttpClientAsync
import app.knock.api.core.JsonValue
import app.knock.api.models.integrations.census.CensusCustomDestinationParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class CensusServiceAsyncTest {

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun customDestination() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val censusServiceAsync = client.integrations().census()

        val responseFuture =
            censusServiceAsync.customDestination(
                CensusCustomDestinationParams.builder()
                    .id("id")
                    .jsonrpc("jsonrpc")
                    .method("method")
                    .params(
                        CensusCustomDestinationParams.Params.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
