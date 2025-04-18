// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages.batch

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BatchUnarchiveParamsTest {

    @Test
    fun create() {
        BatchUnarchiveParams.builder()
            .addMessageId("11111111-1111-1111-1111-111111111111")
            .addMessageId("22222222-2222-2222-2222-222222222222")
            .build()
    }

    @Test
    fun body() {
        val params =
            BatchUnarchiveParams.builder()
                .addMessageId("11111111-1111-1111-1111-111111111111")
                .addMessageId("22222222-2222-2222-2222-222222222222")
                .build()

        val body = params._body()

        assertThat(body.messageIds())
            .containsExactly(
                "11111111-1111-1111-1111-111111111111",
                "22222222-2222-2222-2222-222222222222",
            )
    }
}
