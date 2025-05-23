// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages

import app.knock.api.core.JsonValue
import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageDeliveryLogTest {

    @Test
    fun create() {
        val messageDeliveryLog =
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

        assertThat(messageDeliveryLog.id()).isEqualTo("2FVHPWxRqNuXQ9krvNP5A6Z4qXe")
        assertThat(messageDeliveryLog._typename()).isEqualTo("MessageDeliveryLog")
        assertThat(messageDeliveryLog.environmentId())
            .isEqualTo("123e4567-e89b-12d3-a456-426614174000")
        assertThat(messageDeliveryLog.insertedAt()).isEqualTo("2021-01-01T00:00:00Z")
        assertThat(messageDeliveryLog.request())
            .isEqualTo(
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
        assertThat(messageDeliveryLog.response())
            .isEqualTo(
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
        assertThat(messageDeliveryLog.serviceName()).isEqualTo("Postmark")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val messageDeliveryLog =
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

        val roundtrippedMessageDeliveryLog =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageDeliveryLog),
                jacksonTypeRef<MessageDeliveryLog>(),
            )

        assertThat(roundtrippedMessageDeliveryLog).isEqualTo(messageDeliveryLog)
    }
}
