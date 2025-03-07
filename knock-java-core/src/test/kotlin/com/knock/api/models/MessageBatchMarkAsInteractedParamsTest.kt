// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import com.knock.api.core.JsonValue
import kotlin.test.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MessageBatchMarkAsInteractedParamsTest {

    @Test
    fun create() {
        MessageBatchMarkAsInteractedParams.builder()
            .addMessageId("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
            .metadata(
                MessageBatchMarkAsInteractedParams.Metadata.builder()
                    .putAdditionalProperty("key", JsonValue.from("bar"))
                    .build()
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            MessageBatchMarkAsInteractedParams.builder()
                .addMessageId("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
                .metadata(
                    MessageBatchMarkAsInteractedParams.Metadata.builder()
                        .putAdditionalProperty("key", JsonValue.from("bar"))
                        .build()
                )
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.messageIds()).isEqualTo(listOf("1jNaXzB2RZX3LY8wVQnfCKyPnv7"))
        assertThat(body.metadata())
            .contains(
                MessageBatchMarkAsInteractedParams.Metadata.builder()
                    .putAdditionalProperty("key", JsonValue.from("bar"))
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            MessageBatchMarkAsInteractedParams.builder()
                .addMessageId("1jNaXzB2RZX3LY8wVQnfCKyPnv7")
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.messageIds()).isEqualTo(listOf("1jNaXzB2RZX3LY8wVQnfCKyPnv7"))
    }
}
