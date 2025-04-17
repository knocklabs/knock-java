// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserGetPreferencesParamsTest {

    @Test
    fun create() {
        UserGetPreferencesParams.builder()
            .userId("user_id")
            .preferenceSetId("default")
            .tenant("tenant")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            UserGetPreferencesParams.builder().userId("user_id").preferenceSetId("default").build()

        assertThat(params._pathParam(0)).isEqualTo("user_id")
        assertThat(params._pathParam(1)).isEqualTo("default")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            UserGetPreferencesParams.builder()
                .userId("user_id")
                .preferenceSetId("default")
                .tenant("tenant")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("tenant", "tenant").build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            UserGetPreferencesParams.builder().userId("user_id").preferenceSetId("default").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
