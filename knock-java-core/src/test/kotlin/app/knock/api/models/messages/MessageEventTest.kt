// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages

import app.knock.api.core.JsonValue
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageEventTest {

    @Test
    fun create() {
        val messageEvent =
            MessageEvent.builder()
                .id("2FVHPWxRqNuXQ9krvNP5A6Z4qXe")
                ._typename("MessageEvent")
                .insertedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                .recipient("user_123")
                .type(MessageEvent.Type.MESSAGE_QUEUED)
                .data(
                    MessageEvent.Data.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .build()

        assertThat(messageEvent.id()).isEqualTo("2FVHPWxRqNuXQ9krvNP5A6Z4qXe")
        assertThat(messageEvent._typename()).isEqualTo("MessageEvent")
        assertThat(messageEvent.insertedAt())
            .isEqualTo(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
        assertThat(messageEvent.recipient()).isEqualTo(MessageEvent.Recipient.ofString("user_123"))
        assertThat(messageEvent.type()).isEqualTo(MessageEvent.Type.MESSAGE_QUEUED)
        assertThat(messageEvent.data())
            .contains(
                MessageEvent.Data.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
    }
}
