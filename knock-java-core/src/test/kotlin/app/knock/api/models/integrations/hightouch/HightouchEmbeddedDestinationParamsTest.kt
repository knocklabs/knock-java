// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.integrations.hightouch

import app.knock.api.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class HightouchEmbeddedDestinationParamsTest {

    @Test
    fun create() {
        HightouchEmbeddedDestinationParams.builder()
            .id("id")
            .jsonrpc("jsonrpc")
            .method("method")
            .params(
                HightouchEmbeddedDestinationParams.Params.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            HightouchEmbeddedDestinationParams.builder()
                .id("id")
                .jsonrpc("jsonrpc")
                .method("method")
                .params(
                    HightouchEmbeddedDestinationParams.Params.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.id()).isEqualTo("id")
        assertThat(body.jsonrpc()).isEqualTo("jsonrpc")
        assertThat(body.method()).isEqualTo("method")
        assertThat(body.params())
            .contains(
                HightouchEmbeddedDestinationParams.Params.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            HightouchEmbeddedDestinationParams.builder()
                .id("id")
                .jsonrpc("jsonrpc")
                .method("method")
                .build()

        val body = params._body()

        assertThat(body.id()).isEqualTo("id")
        assertThat(body.jsonrpc()).isEqualTo("jsonrpc")
        assertThat(body.method()).isEqualTo("method")
    }
}
