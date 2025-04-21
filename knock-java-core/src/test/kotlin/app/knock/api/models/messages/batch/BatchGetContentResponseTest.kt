// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages.batch

import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BatchGetContentResponseTest {

    @Test
    fun create() {
        val batchGetContentResponse =
            BatchGetContentResponse.builder()
                ._typename("MessageContent")
                .data(
                    BatchGetContentResponse.Data.MessageSmsContent.builder()
                        ._typename("MessageSmsContent")
                        .body("Hello, world!")
                        .to("user_123")
                        .build()
                )
                .insertedAt(OffsetDateTime.parse("2025-01-01T00:00:00Z"))
                .messageId("2FVHPWxRqNuXQ9krvNP5A6Z4qXe")
                .build()

        assertThat(batchGetContentResponse._typename()).isEqualTo("MessageContent")
        assertThat(batchGetContentResponse.data())
            .isEqualTo(
                BatchGetContentResponse.Data.ofMessageSmsContent(
                    BatchGetContentResponse.Data.MessageSmsContent.builder()
                        ._typename("MessageSmsContent")
                        .body("Hello, world!")
                        .to("user_123")
                        .build()
                )
            )
        assertThat(batchGetContentResponse.insertedAt())
            .isEqualTo(OffsetDateTime.parse("2025-01-01T00:00:00Z"))
        assertThat(batchGetContentResponse.messageId()).isEqualTo("2FVHPWxRqNuXQ9krvNP5A6Z4qXe")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val batchGetContentResponse =
            BatchGetContentResponse.builder()
                ._typename("MessageContent")
                .data(
                    BatchGetContentResponse.Data.MessageSmsContent.builder()
                        ._typename("MessageSmsContent")
                        .body("Hello, world!")
                        .to("user_123")
                        .build()
                )
                .insertedAt(OffsetDateTime.parse("2025-01-01T00:00:00Z"))
                .messageId("2FVHPWxRqNuXQ9krvNP5A6Z4qXe")
                .build()

        val roundtrippedBatchGetContentResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(batchGetContentResponse),
                jacksonTypeRef<BatchGetContentResponse>(),
            )

        assertThat(roundtrippedBatchGetContentResponse).isEqualTo(batchGetContentResponse)
    }
}
