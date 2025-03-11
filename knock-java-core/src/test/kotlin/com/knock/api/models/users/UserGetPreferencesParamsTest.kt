// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models.users

import com.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UserGetPreferencesParamsTest {

    @Test
    fun create() {
      UserGetPreferencesParams.builder()
          .userId("user_id")
          .preferenceSetId("default")
          .tenant("tenant")
          .build()
    }

    @Test
    fun queryParams() {
      val params = UserGetPreferencesParams.builder()
          .userId("user_id")
          .preferenceSetId("default")
          .tenant("tenant")
          .build()
      val expected = QueryParams.builder()
      expected.put("tenant", "tenant")
      assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
      val params = UserGetPreferencesParams.builder()
          .userId("user_id")
          .preferenceSetId("default")
          .build()
      val expected = QueryParams.builder()
      assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun getPathParam() {
      val params = UserGetPreferencesParams.builder()
          .userId("user_id")
          .preferenceSetId("default")
          .build()
      assertThat(params).isNotNull
      // path param "userId"
      assertThat(params.getPathParam(0)).isEqualTo("user_id")
      // path param "preferenceSetId"
      assertThat(params.getPathParam(1)).isEqualTo("default")
      // out-of-bound path param
      assertThat(params.getPathParam(2)).isEqualTo("")
    }
}
