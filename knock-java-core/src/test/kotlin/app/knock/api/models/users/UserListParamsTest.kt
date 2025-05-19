// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserListParamsTest {

    @Test
    fun create() {
        UserListParams.builder()
            .after("after")
            .before("before")
            .addInclude(UserListParams.Include.PREFERENCES)
            .pageSize(0L)
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            UserListParams.builder()
                .after("after")
                .before("before")
                .addInclude(UserListParams.Include.PREFERENCES)
                .pageSize(0L)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "after")
                    .put("before", "before")
                    .put("include[]", "preferences")
                    .put("page_size", "0")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = UserListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
