// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users.guides

import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GuideActionResponseTest {

    @Test
    fun create() {
        val guideActionResponse = GuideActionResponse.builder().status("ok").build()

        assertThat(guideActionResponse.status()).isEqualTo("ok")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val guideActionResponse = GuideActionResponse.builder().status("ok").build()

        val roundtrippedGuideActionResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(guideActionResponse),
                jacksonTypeRef<GuideActionResponse>(),
            )

        assertThat(roundtrippedGuideActionResponse).isEqualTo(guideActionResponse)
    }
}
