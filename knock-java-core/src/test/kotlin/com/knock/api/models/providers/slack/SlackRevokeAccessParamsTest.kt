// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models.providers.slack

import com.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SlackRevokeAccessParamsTest {

    @Test
    fun create() {
        SlackRevokeAccessParams.builder()
            .channelId("channel_id")
            .accessTokenObject("access_token_object")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            SlackRevokeAccessParams.builder()
                .channelId("channel_id")
                .accessTokenObject("access_token_object")
                .build()
        val expected = QueryParams.builder()
        expected.put("access_token_object", "access_token_object")
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            SlackRevokeAccessParams.builder()
                .channelId("channel_id")
                .accessTokenObject("access_token_object")
                .build()
        val expected = QueryParams.builder()
        expected.put("access_token_object", "access_token_object")
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun getPathParam() {
        val params =
            SlackRevokeAccessParams.builder()
                .channelId("channel_id")
                .accessTokenObject("access_token_object")
                .build()
        assertThat(params).isNotNull
        // path param "channelId"
        assertThat(params.getPathParam(0)).isEqualTo("channel_id")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
