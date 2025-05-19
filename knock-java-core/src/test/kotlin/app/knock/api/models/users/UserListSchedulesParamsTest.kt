// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserListSchedulesParamsTest {

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
    fun pathParams() {
        val params = UserListSchedulesParams.builder().userId("user_id").build()

        assertThat(params._pathParam(0)).isEqualTo("user_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
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

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "after")
                    .put("before", "before")
                    .put("page_size", "0")
                    .put("tenant", "tenant")
                    .put("workflow", "workflow")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = UserListSchedulesParams.builder().userId("user_id").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
