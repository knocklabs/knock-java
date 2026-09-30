// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users.preferencecenter

import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PreferenceCenterGenerateSignedUrlResponseTest {

    @Test
    fun create() {
        val preferenceCenterGenerateSignedUrlResponse =
            PreferenceCenterGenerateSignedUrlResponse.builder()
                .token("token")
                .url("https://example.com/p/token")
                .build()

        assertThat(preferenceCenterGenerateSignedUrlResponse.token()).isEqualTo("token")
        assertThat(preferenceCenterGenerateSignedUrlResponse.url())
            .isEqualTo("https://example.com/p/token")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val preferenceCenterGenerateSignedUrlResponse =
            PreferenceCenterGenerateSignedUrlResponse.builder()
                .token("token")
                .url("https://example.com/p/token")
                .build()

        val roundtrippedPreferenceCenterGenerateSignedUrlResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(preferenceCenterGenerateSignedUrlResponse),
                jacksonTypeRef<PreferenceCenterGenerateSignedUrlResponse>(),
            )

        assertThat(roundtrippedPreferenceCenterGenerateSignedUrlResponse)
            .isEqualTo(preferenceCenterGenerateSignedUrlResponse)
    }
}
