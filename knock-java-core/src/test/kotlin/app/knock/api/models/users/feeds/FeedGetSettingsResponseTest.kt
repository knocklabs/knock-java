// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users.feeds

import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FeedGetSettingsResponseTest {

    @Test
    fun create() {
        val feedGetSettingsResponse =
            FeedGetSettingsResponse.builder()
                .features(FeedGetSettingsResponse.Features.builder().brandingRequired(true).build())
                .build()

        assertThat(feedGetSettingsResponse.features())
            .isEqualTo(FeedGetSettingsResponse.Features.builder().brandingRequired(true).build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val feedGetSettingsResponse =
            FeedGetSettingsResponse.builder()
                .features(FeedGetSettingsResponse.Features.builder().brandingRequired(true).build())
                .build()

        val roundtrippedFeedGetSettingsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(feedGetSettingsResponse),
                jacksonTypeRef<FeedGetSettingsResponse>(),
            )

        assertThat(roundtrippedFeedGetSettingsResponse).isEqualTo(feedGetSettingsResponse)
    }
}
