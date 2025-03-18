// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserListSubscriptionsParamsTest {

    @Test
    fun create() {
        UserListSubscriptionsParams.builder()
            .userId("user_id")
            .after("after")
            .before("before")
            .pageSize(0L)
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            UserListSubscriptionsParams.builder()
                .userId("user_id")
                .after("after")
                .before("before")
                .pageSize(0L)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "after")
                    .put("before", "before")
                    .put("page_size", "0")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = UserListSubscriptionsParams.builder().userId("user_id").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }

    @Test
    fun getPathParam() {
        val params = UserListSubscriptionsParams.builder().userId("user_id").build()
        assertThat(params).isNotNull
        // path param "userId"
        assertThat(params.getPathParam(0)).isEqualTo("user_id")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
