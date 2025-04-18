// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users.guides

import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GuideMarkMessageAsArchivedResponseTest {

    @Test
    fun create() {
        val guideMarkMessageAsArchivedResponse =
            GuideMarkMessageAsArchivedResponse.builder().status("ok").build()

        assertThat(guideMarkMessageAsArchivedResponse.status()).isEqualTo("ok")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val guideMarkMessageAsArchivedResponse =
            GuideMarkMessageAsArchivedResponse.builder().status("ok").build()

        val roundtrippedGuideMarkMessageAsArchivedResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(guideMarkMessageAsArchivedResponse),
                jacksonTypeRef<GuideMarkMessageAsArchivedResponse>(),
            )

        assertThat(roundtrippedGuideMarkMessageAsArchivedResponse)
            .isEqualTo(guideMarkMessageAsArchivedResponse)
    }
}
