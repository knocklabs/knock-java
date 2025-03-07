// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import com.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UserListSchedulesParamsTest {

    @Test
    fun create() {
        UserListSchedulesParams.builder()
            .userId("user_id")
            .after("after")
            .before("before")
            .pageSize(0L)
            .tenant("tenant")
            .workflow("workflow")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            UserListSchedulesParams.builder()
                .userId("user_id")
                .after("after")
                .before("before")
                .pageSize(0L)
                .tenant("tenant")
                .workflow("workflow")
                .build()
        val expected = QueryParams.builder()
        expected.put("after", "after")
        expected.put("before", "before")
        expected.put("page_size", "0")
        expected.put("tenant", "tenant")
        expected.put("workflow", "workflow")
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = UserListSchedulesParams.builder().userId("user_id").build()
        val expected = QueryParams.builder()
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun getPathParam() {
        val params = UserListSchedulesParams.builder().userId("user_id").build()
        assertThat(params).isNotNull
        // path param "userId"
        assertThat(params.getPathParam(0)).isEqualTo("user_id")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
