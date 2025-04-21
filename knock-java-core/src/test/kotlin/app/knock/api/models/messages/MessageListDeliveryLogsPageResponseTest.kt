// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages

import app.knock.api.core.JsonValue
import app.knock.api.core.jsonMapper
import app.knock.api.models.shared.PageInfo
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageListDeliveryLogsPageResponseTest {

    @Test
    fun create() {
        val messageListDeliveryLogsPageResponse =
            MessageListDeliveryLogsPageResponse.builder()
                .addEntry(
                    MessageDeliveryLog.builder()
                        .id("2FVHPWxRqNuXQ9krvNP5A6Z4qXe")
                        ._typename("MessageDeliveryLog")
                        .environmentId("123e4567-e89b-12d3-a456-426614174000")
                        .insertedAt("2021-01-01T00:00:00Z")
                        .request(
                            MessageDeliveryLog.Request.builder()
                                .body(
                                    MessageDeliveryLog.Request.Body.UnionMember1.builder()
                                        .putAdditionalProperty(
                                            "html_content",
                                            JsonValue.from("bar"),
                                        )
                                        .build()
                                )
                                .headers(
                                    MessageDeliveryLog.Request.Headers.builder()
                                        .putAdditionalProperty(
                                            "Content-Type",
                                            JsonValue.from("bar"),
                                        )
                                        .build()
                                )
                                .host("localhost")
                                .method(MessageDeliveryLog.Request.Method.GET)
                                .path("/")
                                .query("?foo=bar")
                                .build()
                        )
                        .response(
                            MessageDeliveryLog.Response.builder()
                                .body(
                                    MessageDeliveryLog.Response.Body.UnionMember1.builder()
                                        .putAdditionalProperty("success", JsonValue.from("bar"))
                                        .build()
                                )
                                .headers(
                                    MessageDeliveryLog.Response.Headers.builder()
                                        .putAdditionalProperty(
                                            "Content-Type",
                                            JsonValue.from("bar"),
                                        )
                                        .build()
                                )
                                .status(200L)
                                .build()
                        )
                        .serviceName("Postmark")
                        .build()
                )
                .pageInfo(
                    PageInfo.builder()
                        ._typename("PageInfo")
                        .pageSize(25L)
                        .after(null)
                        .before(null)
                        .build()
                )
                .build()

        assertThat(messageListDeliveryLogsPageResponse.entries())
            .containsExactly(
                MessageDeliveryLog.builder()
                    .id("2FVHPWxRqNuXQ9krvNP5A6Z4qXe")
                    ._typename("MessageDeliveryLog")
                    .environmentId("123e4567-e89b-12d3-a456-426614174000")
                    .insertedAt("2021-01-01T00:00:00Z")
                    .request(
                        MessageDeliveryLog.Request.builder()
                            .body(
                                MessageDeliveryLog.Request.Body.UnionMember1.builder()
                                    .putAdditionalProperty("html_content", JsonValue.from("bar"))
                                    .build()
                            )
                            .headers(
                                MessageDeliveryLog.Request.Headers.builder()
                                    .putAdditionalProperty("Content-Type", JsonValue.from("bar"))
                                    .build()
                            )
                            .host("localhost")
                            .method(MessageDeliveryLog.Request.Method.GET)
                            .path("/")
                            .query("?foo=bar")
                            .build()
                    )
                    .response(
                        MessageDeliveryLog.Response.builder()
                            .body(
                                MessageDeliveryLog.Response.Body.UnionMember1.builder()
                                    .putAdditionalProperty("success", JsonValue.from("bar"))
                                    .build()
                            )
                            .headers(
                                MessageDeliveryLog.Response.Headers.builder()
                                    .putAdditionalProperty("Content-Type", JsonValue.from("bar"))
                                    .build()
                            )
                            .status(200L)
                            .build()
                    )
                    .serviceName("Postmark")
                    .build()
            )
        assertThat(messageListDeliveryLogsPageResponse.pageInfo())
            .isEqualTo(
                PageInfo.builder()
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
        val messageListDeliveryLogsPageResponse =
            MessageListDeliveryLogsPageResponse.builder()
                .addEntry(
                    MessageDeliveryLog.builder()
                        .id("2FVHPWxRqNuXQ9krvNP5A6Z4qXe")
                        ._typename("MessageDeliveryLog")
                        .environmentId("123e4567-e89b-12d3-a456-426614174000")
                        .insertedAt("2021-01-01T00:00:00Z")
                        .request(
                            MessageDeliveryLog.Request.builder()
                                .body(
                                    MessageDeliveryLog.Request.Body.UnionMember1.builder()
                                        .putAdditionalProperty(
                                            "html_content",
                                            JsonValue.from("bar"),
                                        )
                                        .build()
                                )
                                .headers(
                                    MessageDeliveryLog.Request.Headers.builder()
                                        .putAdditionalProperty(
                                            "Content-Type",
                                            JsonValue.from("bar"),
                                        )
                                        .build()
                                )
                                .host("localhost")
                                .method(MessageDeliveryLog.Request.Method.GET)
                                .path("/")
                                .query("?foo=bar")
                                .build()
                        )
                        .response(
                            MessageDeliveryLog.Response.builder()
                                .body(
                                    MessageDeliveryLog.Response.Body.UnionMember1.builder()
                                        .putAdditionalProperty("success", JsonValue.from("bar"))
                                        .build()
                                )
                                .headers(
                                    MessageDeliveryLog.Response.Headers.builder()
                                        .putAdditionalProperty(
                                            "Content-Type",
                                            JsonValue.from("bar"),
                                        )
                                        .build()
                                )
                                .status(200L)
                                .build()
                        )
                        .serviceName("Postmark")
                        .build()
                )
                .pageInfo(
                    PageInfo.builder()
                        ._typename("PageInfo")
                        .pageSize(25L)
                        .after(null)
                        .before(null)
                        .build()
                )
                .build()

        val roundtrippedMessageListDeliveryLogsPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageListDeliveryLogsPageResponse),
                jacksonTypeRef<MessageListDeliveryLogsPageResponse>(),
            )

        assertThat(roundtrippedMessageListDeliveryLogsPageResponse)
            .isEqualTo(messageListDeliveryLogsPageResponse)
    }
}
