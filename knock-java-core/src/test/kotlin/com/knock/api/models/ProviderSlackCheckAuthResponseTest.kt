// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ProviderSlackCheckAuthResponseTest {

    @Test
    fun createProviderSlackCheckAuthResponse() {
        val providerSlackCheckAuthResponse =
            ProviderSlackCheckAuthResponse.builder()
                .connection(
                    ProviderSlackCheckAuthResponse.Connection.builder()
                        .ok(true)
                        .reason("reason")
                        .build()
                )
                .build()
        assertThat(providerSlackCheckAuthResponse).isNotNull
        assertThat(providerSlackCheckAuthResponse.connection())
            .isEqualTo(
                ProviderSlackCheckAuthResponse.Connection.builder()
                    .ok(true)
                    .reason("reason")
                    .build()
            )
    }
}
