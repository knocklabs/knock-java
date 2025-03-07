// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UserFeedGetSettingsResponseTest {

    @Test
    fun createUserFeedGetSettingsResponse() {
        val userFeedGetSettingsResponse =
            UserFeedGetSettingsResponse.builder()
                .features(
                    UserFeedGetSettingsResponse.Features.builder().brandingRequired(true).build()
                )
                .build()
        assertThat(userFeedGetSettingsResponse).isNotNull
        assertThat(userFeedGetSettingsResponse.features())
            .isEqualTo(
                UserFeedGetSettingsResponse.Features.builder().brandingRequired(true).build()
            )
    }
}
