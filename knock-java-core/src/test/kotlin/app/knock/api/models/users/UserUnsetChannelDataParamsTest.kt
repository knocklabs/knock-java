// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UserUnsetChannelDataParamsTest {

    @Test
    fun create() {
      UserUnsetChannelDataParams.builder()
          .userId("user_id")
          .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build()
    }

    @Test
    fun getPathParam() {
      val params = UserUnsetChannelDataParams.builder()
          .userId("user_id")
          .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build()
      assertThat(params).isNotNull
      // path param "userId"
      assertThat(params.getPathParam(0)).isEqualTo("user_id")
      // path param "channelId"
      assertThat(params.getPathParam(1)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
      // out-of-bound path param
      assertThat(params.getPathParam(2)).isEqualTo("")
    }
}
