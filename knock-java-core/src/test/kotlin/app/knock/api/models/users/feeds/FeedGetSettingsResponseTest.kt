// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users.feeds

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
}
