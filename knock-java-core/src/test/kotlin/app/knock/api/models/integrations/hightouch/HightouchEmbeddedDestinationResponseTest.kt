// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.integrations.hightouch

import app.knock.api.core.JsonValue
import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class HightouchEmbeddedDestinationResponseTest {

    @Test
    fun create() {
        val hightouchEmbeddedDestinationResponse =
            HightouchEmbeddedDestinationResponse.builder()
                .id("id")
                .result(
                    HightouchEmbeddedDestinationResponse.Result.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .build()

        assertThat(hightouchEmbeddedDestinationResponse.id()).contains("id")
        assertThat(hightouchEmbeddedDestinationResponse.result())
            .contains(
                HightouchEmbeddedDestinationResponse.Result.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val hightouchEmbeddedDestinationResponse =
            HightouchEmbeddedDestinationResponse.builder()
                .id("id")
                .result(
                    HightouchEmbeddedDestinationResponse.Result.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .build()

        val roundtrippedHightouchEmbeddedDestinationResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(hightouchEmbeddedDestinationResponse),
                jacksonTypeRef<HightouchEmbeddedDestinationResponse>(),
            )

        assertThat(roundtrippedHightouchEmbeddedDestinationResponse)
            .isEqualTo(hightouchEmbeddedDestinationResponse)
    }
}
