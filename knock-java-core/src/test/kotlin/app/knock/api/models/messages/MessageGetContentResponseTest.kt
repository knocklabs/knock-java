// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages

import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
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
                        .body(
                            "URGENT: Power failure detected in perimeter fencing. Backup generators failed to engage. Technical team dispatched. Maintain lockdown protocols."
                        )
                        .to("+15553982647")
                        .build()
                )
                .insertedAt(OffsetDateTime.parse("1993-06-11T20:30:00Z"))
                .messageId("2w3YUpTTOxuDvZFji8OMsKrG176")
                .build()

        assertThat(messageGetContentResponse._typename()).isEqualTo("MessageContent")
        assertThat(messageGetContentResponse.data())
            .isEqualTo(
                MessageGetContentResponse.Data.ofMessageSmsContent(
                    MessageGetContentResponse.Data.MessageSmsContent.builder()
                        ._typename("MessageSmsContent")
                        .body(
                            "URGENT: Power failure detected in perimeter fencing. Backup generators failed to engage. Technical team dispatched. Maintain lockdown protocols."
                        )
                        .to("+15553982647")
                        .build()
                )
            )
        assertThat(messageGetContentResponse.insertedAt())
            .isEqualTo(OffsetDateTime.parse("1993-06-11T20:30:00Z"))
        assertThat(messageGetContentResponse.messageId()).isEqualTo("2w3YUpTTOxuDvZFji8OMsKrG176")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val messageGetContentResponse =
            MessageGetContentResponse.builder()
                ._typename("MessageContent")
                .data(
                    MessageGetContentResponse.Data.MessageSmsContent.builder()
                        ._typename("MessageSmsContent")
                        .body(
                            "URGENT: Power failure detected in perimeter fencing. Backup generators failed to engage. Technical team dispatched. Maintain lockdown protocols."
                        )
                        .to("+15553982647")
                        .build()
                )
                .insertedAt(OffsetDateTime.parse("1993-06-11T20:30:00Z"))
                .messageId("2w3YUpTTOxuDvZFji8OMsKrG176")
                .build()

        val roundtrippedMessageGetContentResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageGetContentResponse),
                jacksonTypeRef<MessageGetContentResponse>(),
            )

        assertThat(roundtrippedMessageGetContentResponse).isEqualTo(messageGetContentResponse)
    }
}
