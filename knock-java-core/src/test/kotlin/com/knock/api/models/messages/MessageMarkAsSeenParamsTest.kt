// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models.messages

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MessageMarkAsSeenParamsTest {

    @Test
    fun create() {
        MessageMarkAsSeenParams.builder().messageId("1jNaXzB2RZX3LY8wVQnfCKyPnv7").build()
    }

    @Test
    fun getPathParam() {
        val params =
            MessageMarkAsSeenParams.builder().messageId("1jNaXzB2RZX3LY8wVQnfCKyPnv7").build()
        assertThat(params).isNotNull
        // path param "messageId"
        assertThat(params.getPathParam(0)).isEqualTo("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
