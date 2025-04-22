// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.integrations.census

import app.knock.api.core.JsonValue
import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CensusCustomDestinationResponseTest {

    @Test
    fun create() {
        val censusCustomDestinationResponse =
            CensusCustomDestinationResponse.builder()
                .id("id")
                .result(
                    CensusCustomDestinationResponse.Result.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .build()

        assertThat(censusCustomDestinationResponse.id()).contains("id")
        assertThat(censusCustomDestinationResponse.result())
            .contains(
                CensusCustomDestinationResponse.Result.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val censusCustomDestinationResponse =
            CensusCustomDestinationResponse.builder()
                .id("id")
                .result(
                    CensusCustomDestinationResponse.Result.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .build()

        val roundtrippedCensusCustomDestinationResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(censusCustomDestinationResponse),
                jacksonTypeRef<CensusCustomDestinationResponse>(),
            )

        assertThat(roundtrippedCensusCustomDestinationResponse)
            .isEqualTo(censusCustomDestinationResponse)
    }
}
