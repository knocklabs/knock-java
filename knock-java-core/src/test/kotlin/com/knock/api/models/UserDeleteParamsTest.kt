// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UserDeleteParamsTest {

    @Test
    fun create() {
        UserDeleteParams.builder().userId("user_id").build()
    }

    @Test
    fun getPathParam() {
        val params = UserDeleteParams.builder().userId("user_id").build()
        assertThat(params).isNotNull
        // path param "userId"
        assertThat(params.getPathParam(0)).isEqualTo("user_id")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
