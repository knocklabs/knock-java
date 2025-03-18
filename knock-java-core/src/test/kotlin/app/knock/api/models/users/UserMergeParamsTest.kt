// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import kotlin.test.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserMergeParamsTest {

    @Test
    fun create() {
        UserMergeParams.builder().userId("user_id").fromUserId("user_1").build()
    }

    @Test
    fun body() {
        val params = UserMergeParams.builder().userId("user_id").fromUserId("user_1").build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.fromUserId()).isEqualTo("user_1")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = UserMergeParams.builder().userId("user_id").fromUserId("user_1").build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.fromUserId()).isEqualTo("user_1")
    }

    @Test
    fun getPathParam() {
        val params = UserMergeParams.builder().userId("user_id").fromUserId("user_1").build()
        assertThat(params).isNotNull
        // path param "userId"
        assertThat(params.getPathParam(0)).isEqualTo("user_id")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
