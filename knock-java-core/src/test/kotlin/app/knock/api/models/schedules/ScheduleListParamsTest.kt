// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.schedules

import app.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ScheduleListParamsTest {

    @Test
    fun create() {
        ScheduleListParams.builder()
            .workflow("workflow")
            .after("after")
            .before("before")
            .pageSize(0L)
            .addRecipient("user_123")
            .tenant("tenant")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            ScheduleListParams.builder()
                .workflow("workflow")
                .after("after")
                .before("before")
                .pageSize(0L)
                .addRecipient("user_123")
                .tenant("tenant")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("workflow", "workflow")
                    .put("after", "after")
                    .put("before", "before")
                    .put("page_size", "0")
                    .put("recipients[]", "user_123")
                    .put("tenant", "tenant")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = ScheduleListParams.builder().workflow("workflow").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("workflow", "workflow").build())
    }
}
