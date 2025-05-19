// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserMergeParamsTest {

    @Test
    fun create() {
        UserMergeParams.builder().userId("user_id").fromUserId("user_1").build()
    }

    @Test
    fun pathParams() {
        val params = UserMergeParams.builder().userId("user_id").fromUserId("user_1").build()

        assertThat(params._pathParam(0)).isEqualTo("user_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params = UserMergeParams.builder().userId("user_id").fromUserId("user_1").build()

        val body = params._body()

        assertThat(body.fromUserId()).isEqualTo("user_1")
    }
}
