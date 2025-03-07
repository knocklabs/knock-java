// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import com.knock.api.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MessageListDeliveryLogsResponseTest {

    @Test
    fun createMessageListDeliveryLogsResponse() {
        val messageListDeliveryLogsResponse =
            MessageListDeliveryLogsResponse.builder()
                .id("2FVHPWxRqNuXQ9krvNP5A6Z4qXe")
                ._typename("MessageDeliveryLog")
                .environmentId("123e4567-e89b-12d3-a456-426614174000")
                .insertedAt("2021-01-01T00:00:00Z")
                .request(
                    MessageListDeliveryLogsResponse.Request.builder()
                        .body(
                            MessageListDeliveryLogsResponse.Request.Body.UnionMember1.builder()
                                .putAdditionalProperty("html_content", JsonValue.from("bar"))
                                .build()
                        )
                        .headers(
                            MessageListDeliveryLogsResponse.Request.Headers.builder()
                                .putAdditionalProperty("Content-Type", JsonValue.from("bar"))
                                .build()
                        )
                        .host("localhost")
                        .method(MessageListDeliveryLogsResponse.Request.Method.GET)
                        .path("/")
                        .query("?foo=bar")
                        .build()
                )
                .response(
                    MessageListDeliveryLogsResponse.Response.builder()
                        .body(
                            MessageListDeliveryLogsResponse.Response.Body.UnionMember1.builder()
                                .putAdditionalProperty("success", JsonValue.from("bar"))
                                .build()
                        )
                        .headers(
                            MessageListDeliveryLogsResponse.Response.Headers.builder()
                                .putAdditionalProperty("Content-Type", JsonValue.from("bar"))
                                .build()
                        )
                        .status(200L)
                        .build()
                )
                .serviceName("Postmark")
                .build()
        assertThat(messageListDeliveryLogsResponse).isNotNull
        assertThat(messageListDeliveryLogsResponse.id()).isEqualTo("2FVHPWxRqNuXQ9krvNP5A6Z4qXe")
        assertThat(messageListDeliveryLogsResponse._typename()).isEqualTo("MessageDeliveryLog")
        assertThat(messageListDeliveryLogsResponse.environmentId())
            .isEqualTo("123e4567-e89b-12d3-a456-426614174000")
        assertThat(messageListDeliveryLogsResponse.insertedAt()).isEqualTo("2021-01-01T00:00:00Z")
        assertThat(messageListDeliveryLogsResponse.request())
            .isEqualTo(
                MessageListDeliveryLogsResponse.Request.builder()
                    .body(
                        MessageListDeliveryLogsResponse.Request.Body.UnionMember1.builder()
                            .putAdditionalProperty("html_content", JsonValue.from("bar"))
                            .build()
                    )
                    .headers(
                        MessageListDeliveryLogsResponse.Request.Headers.builder()
                            .putAdditionalProperty("Content-Type", JsonValue.from("bar"))
                            .build()
                    )
                    .host("localhost")
                    .method(MessageListDeliveryLogsResponse.Request.Method.GET)
                    .path("/")
                    .query("?foo=bar")
                    .build()
            )
        assertThat(messageListDeliveryLogsResponse.response())
            .isEqualTo(
                MessageListDeliveryLogsResponse.Response.builder()
                    .body(
                        MessageListDeliveryLogsResponse.Response.Body.UnionMember1.builder()
                            .putAdditionalProperty("success", JsonValue.from("bar"))
                            .build()
                    )
                    .headers(
                        MessageListDeliveryLogsResponse.Response.Headers.builder()
                            .putAdditionalProperty("Content-Type", JsonValue.from("bar"))
                            .build()
                    )
                    .status(200L)
                    .build()
            )
        assertThat(messageListDeliveryLogsResponse.serviceName()).isEqualTo("Postmark")
    }
}
