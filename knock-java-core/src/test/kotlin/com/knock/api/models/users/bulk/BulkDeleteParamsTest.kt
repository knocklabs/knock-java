// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models.users.bulk

import kotlin.test.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BulkDeleteParamsTest {

    @Test
    fun create() {
        BulkDeleteParams.builder().addUserId("user_1").addUserId("user_2").build()
    }

    @Test
    fun body() {
        val params = BulkDeleteParams.builder().addUserId("user_1").addUserId("user_2").build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.userIds()).isEqualTo(listOf("user_1", "user_2"))
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = BulkDeleteParams.builder().addUserId("user_1").addUserId("user_2").build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.userIds()).isEqualTo(listOf("user_1", "user_2"))
    }
}
