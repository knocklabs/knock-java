// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UserGetParamsTest {

    @Test
    fun create() {
      UserGetParams.builder()
          .userId("user_id")
          .build()
    }

    @Test
    fun getPathParam() {
      val params = UserGetParams.builder()
          .userId("user_id")
          .build()
      assertThat(params).isNotNull
      // path param "userId"
      assertThat(params.getPathParam(0)).isEqualTo("user_id")
      // out-of-bound path param
      assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
