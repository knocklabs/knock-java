// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ProviderMsTeamCheckAuthResponseTest {

    @Test
    fun createProviderMsTeamCheckAuthResponse() {
        val providerMsTeamCheckAuthResponse =
            ProviderMsTeamCheckAuthResponse.builder()
                .connection(
                    ProviderMsTeamCheckAuthResponse.Connection.builder()
                        .ok(true)
                        .reason("reason")
                        .build()
                )
                .build()
        assertThat(providerMsTeamCheckAuthResponse).isNotNull
        assertThat(providerMsTeamCheckAuthResponse.connection())
            .isEqualTo(
                ProviderMsTeamCheckAuthResponse.Connection.builder()
                    .ok(true)
                    .reason("reason")
                    .build()
            )
    }
}
