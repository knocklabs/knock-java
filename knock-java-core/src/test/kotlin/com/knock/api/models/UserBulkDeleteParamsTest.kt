// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import com.knock.api.core.http.QueryParams
import kotlin.test.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UserBulkDeleteParamsTest {

    @Test
    fun create() {
        UserBulkDeleteParams.builder()
            .addUserId("string")
            .addUserId("user_1")
            .addUserId("user_2")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            UserBulkDeleteParams.builder()
                .addUserId("string")
                .addUserId("user_1")
                .addUserId("user_2")
                .build()
        val expected = QueryParams.builder()
        expected.put("user_ids[]", "string")
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            UserBulkDeleteParams.builder()
                .addUserId("string")
                .addUserId("user_1")
                .addUserId("user_2")
                .build()
        val expected = QueryParams.builder()
        expected.put("user_ids[]", "string")
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun body() {
        val params =
            UserBulkDeleteParams.builder()
                .addUserId("string")
                .addUserId("user_1")
                .addUserId("user_2")
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.userIds()).isEqualTo(listOf("user_1", "user_2"))
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            UserBulkDeleteParams.builder()
                .addUserId("string")
                .addUserId("user_1")
                .addUserId("user_2")
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.userIds()).isEqualTo(listOf("user_1", "user_2"))
    }
}
