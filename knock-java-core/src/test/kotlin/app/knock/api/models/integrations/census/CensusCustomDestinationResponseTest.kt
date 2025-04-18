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
                .result(JsonValue.from(mapOf<String, Any>()))
                .build()

        assertThat(censusCustomDestinationResponse.id()).contains("id")
        assertThat(censusCustomDestinationResponse._result())
            .isEqualTo(JsonValue.from(mapOf<String, Any>()))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val censusCustomDestinationResponse =
            CensusCustomDestinationResponse.builder()
                .id("id")
                .result(JsonValue.from(mapOf<String, Any>()))
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
