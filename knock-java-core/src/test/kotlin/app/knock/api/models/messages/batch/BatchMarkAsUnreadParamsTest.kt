// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages.batch

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BatchMarkAsUnreadParamsTest {

    @Test
    fun create() {
        BatchMarkAsUnreadParams.builder()
            .addMessageId("2w3YUpTTOxuDvZFji8OMsKrG176")
            .addMessageId("2w3YVRbPXMIh8Zq6oBFcVDA5xes")
            .build()
    }

    @Test
    fun body() {
        val params =
            BatchMarkAsUnreadParams.builder()
                .addMessageId("2w3YUpTTOxuDvZFji8OMsKrG176")
                .addMessageId("2w3YVRbPXMIh8Zq6oBFcVDA5xes")
                .build()

        val body = params._body()

        assertThat(body.messageIds())
            .containsExactly("2w3YUpTTOxuDvZFji8OMsKrG176", "2w3YVRbPXMIh8Zq6oBFcVDA5xes")
    }
}
