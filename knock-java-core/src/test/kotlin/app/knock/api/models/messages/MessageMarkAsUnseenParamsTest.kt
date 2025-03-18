// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageMarkAsUnseenParamsTest {

    @Test
    fun create() {
        MessageMarkAsUnseenParams.builder().messageId("1jNaXzB2RZX3LY8wVQnfCKyPnv7").build()
    }

    @Test
    fun pathParams() {
        val params =
            MessageMarkAsUnseenParams.builder().messageId("1jNaXzB2RZX3LY8wVQnfCKyPnv7").build()

        assertThat(params._pathParam(0)).isEqualTo("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
