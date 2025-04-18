// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users.guides

import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GuideMarkMessageAsSeenResponseTest {

    @Test
    fun create() {
        val guideMarkMessageAsSeenResponse =
            GuideMarkMessageAsSeenResponse.builder().status("ok").build()

        assertThat(guideMarkMessageAsSeenResponse.status()).isEqualTo("ok")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val guideMarkMessageAsSeenResponse =
            GuideMarkMessageAsSeenResponse.builder().status("ok").build()

        val roundtrippedGuideMarkMessageAsSeenResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(guideMarkMessageAsSeenResponse),
                jacksonTypeRef<GuideMarkMessageAsSeenResponse>(),
            )

        assertThat(roundtrippedGuideMarkMessageAsSeenResponse)
            .isEqualTo(guideMarkMessageAsSeenResponse)
    }
}
