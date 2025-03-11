// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models.messages.batch

import com.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BatchGetContentParamsTest {

    @Test
    fun create() {
        BatchGetContentParams.builder().addMessageId("string").build()
    }

    @Test
    fun queryParams() {
        val params = BatchGetContentParams.builder().addMessageId("string").build()
        val expected = QueryParams.builder()
        expected.put("message_ids[]", "string")
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = BatchGetContentParams.builder().addMessageId("string").build()
        val expected = QueryParams.builder()
        expected.put("message_ids[]", "string")
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }
}
