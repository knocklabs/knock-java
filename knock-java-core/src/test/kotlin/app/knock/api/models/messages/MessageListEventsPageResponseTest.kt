// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages

import app.knock.api.core.JsonValue
import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageListEventsPageResponseTest {

    @Test
    fun create() {
        val messageListEventsPageResponse =
            MessageListEventsPageResponse.builder()
                .addEntry(
                    MessageEvent.builder()
                        .id("2FVHPWxRqNuXQ9krvNP5A6Z4qXe")
                        ._typename("MessageEvent")
                        .insertedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                        .recipient("user_123")
                        .type(MessageEvent.Type.MESSAGE_SENT)
                        .data(
                            MessageEvent.Data.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .build()
                )
                .pageInfo(
                    MessageListEventsPageResponse.PageInfo.builder()
                        ._typename("PageInfo")
                        .pageSize(25L)
                        .after(null)
                        .before(null)
                        .build()
                )
                .build()

        assertThat(messageListEventsPageResponse.entries())
            .containsExactly(
                MessageEvent.builder()
                    .id("2FVHPWxRqNuXQ9krvNP5A6Z4qXe")
                    ._typename("MessageEvent")
                    .insertedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                    .recipient("user_123")
                    .type(MessageEvent.Type.MESSAGE_SENT)
                    .data(
                        MessageEvent.Data.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .build()
            )
        assertThat(messageListEventsPageResponse.pageInfo())
            .isEqualTo(
                MessageListEventsPageResponse.PageInfo.builder()
                    ._typename("PageInfo")
                    .pageSize(25L)
                    .after(null)
                    .before(null)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val messageListEventsPageResponse =
            MessageListEventsPageResponse.builder()
                .addEntry(
                    MessageEvent.builder()
                        .id("2FVHPWxRqNuXQ9krvNP5A6Z4qXe")
                        ._typename("MessageEvent")
                        .insertedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                        .recipient("user_123")
                        .type(MessageEvent.Type.MESSAGE_SENT)
                        .data(
                            MessageEvent.Data.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .build()
                )
                .pageInfo(
                    MessageListEventsPageResponse.PageInfo.builder()
                        ._typename("PageInfo")
                        .pageSize(25L)
                        .after(null)
                        .before(null)
                        .build()
                )
                .build()

        val roundtrippedMessageListEventsPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageListEventsPageResponse),
                jacksonTypeRef<MessageListEventsPageResponse>(),
            )

        assertThat(roundtrippedMessageListEventsPageResponse)
            .isEqualTo(messageListEventsPageResponse)
    }
}
