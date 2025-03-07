// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import com.knock.api.core.JsonValue
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MessageListEventsResponseTest {

    @Test
    fun createMessageListEventsResponse() {
        val messageListEventsResponse =
            MessageListEventsResponse.builder()
                .id("2FVHPWxRqNuXQ9krvNP5A6Z4qXe")
                ._typename("MessageEvent")
                .insertedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                .recipient("user_123")
                .type(MessageListEventsResponse.Type.MESSAGE_QUEUED)
                .data(
                    MessageListEventsResponse.Data.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .build()
        assertThat(messageListEventsResponse).isNotNull
        assertThat(messageListEventsResponse.id()).isEqualTo("2FVHPWxRqNuXQ9krvNP5A6Z4qXe")
        assertThat(messageListEventsResponse._typename()).isEqualTo("MessageEvent")
        assertThat(messageListEventsResponse.insertedAt())
            .isEqualTo(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
        assertThat(messageListEventsResponse.recipient())
            .isEqualTo(MessageListEventsResponse.Recipient.ofString("user_123"))
        assertThat(messageListEventsResponse.type())
            .isEqualTo(MessageListEventsResponse.Type.MESSAGE_QUEUED)
        assertThat(messageListEventsResponse.data())
            .contains(
                MessageListEventsResponse.Data.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
    }
}
