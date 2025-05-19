// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users.guides

import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GuideMarkMessageAsInteractedResponseTest {

    @Test
    fun create() {
        val guideMarkMessageAsInteractedResponse =
            GuideMarkMessageAsInteractedResponse.builder().status("ok").build()

        assertThat(guideMarkMessageAsInteractedResponse.status()).isEqualTo("ok")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val guideMarkMessageAsInteractedResponse =
            GuideMarkMessageAsInteractedResponse.builder().status("ok").build()

        val roundtrippedGuideMarkMessageAsInteractedResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(guideMarkMessageAsInteractedResponse),
                jacksonTypeRef<GuideMarkMessageAsInteractedResponse>(),
            )

        assertThat(roundtrippedGuideMarkMessageAsInteractedResponse)
            .isEqualTo(guideMarkMessageAsInteractedResponse)
    }
}
