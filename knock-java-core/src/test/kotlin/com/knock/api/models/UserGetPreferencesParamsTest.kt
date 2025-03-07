// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import com.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UserGetPreferencesParamsTest {

    @Test
    fun create() {
        UserGetPreferencesParams.builder().userId("user_id").id("id").tenant("tenant").build()
    }

    @Test
    fun queryParams() {
        val params =
            UserGetPreferencesParams.builder().userId("user_id").id("id").tenant("tenant").build()
        val expected = QueryParams.builder()
        expected.put("tenant", "tenant")
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = UserGetPreferencesParams.builder().userId("user_id").id("id").build()
        val expected = QueryParams.builder()
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun getPathParam() {
        val params = UserGetPreferencesParams.builder().userId("user_id").id("id").build()
        assertThat(params).isNotNull
        // path param "userId"
        assertThat(params.getPathParam(0)).isEqualTo("user_id")
        // path param "id"
        assertThat(params.getPathParam(1)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params.getPathParam(2)).isEqualTo("")
    }
}
