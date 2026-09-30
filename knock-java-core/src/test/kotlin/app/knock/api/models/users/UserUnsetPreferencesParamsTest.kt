// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserUnsetPreferencesParamsTest {

    @Test
    fun create() {
        UserUnsetPreferencesParams.builder().userId("user_id").id("default").build()
    }

    @Test
    fun pathParams() {
        val params = UserUnsetPreferencesParams.builder().userId("user_id").id("default").build()

        assertThat(params._pathParam(0)).isEqualTo("user_id")
        assertThat(params._pathParam(1)).isEqualTo("default")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }
}
