// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageGetContentResponseTest {

    @Test
    fun create() {
        val messageGetContentResponse =
            MessageGetContentResponse.builder()
                ._typename("MessageContent")
                .data(
                    MessageGetContentResponse.Data.MessageSmsContent.builder()
                        ._typename("MessageSmsContent")
                        .body("Hello, world!")
                        .to("user_123")
                        .build()
                )
                .insertedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                .messageId("2FVHPWxRqNuXQ9krvNP5A6Z4qXe")
                .build()

        assertThat(messageGetContentResponse._typename()).isEqualTo("MessageContent")
        assertThat(messageGetContentResponse.data())
            .isEqualTo(
                MessageGetContentResponse.Data.ofMessageSmsContent(
                    MessageGetContentResponse.Data.MessageSmsContent.builder()
                        ._typename("MessageSmsContent")
                        .body("Hello, world!")
                        .to("user_123")
                        .build()
                )
            )
        assertThat(messageGetContentResponse.insertedAt())
            .isEqualTo(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
        assertThat(messageGetContentResponse.messageId()).isEqualTo("2FVHPWxRqNuXQ9krvNP5A6Z4qXe")
    }
}
