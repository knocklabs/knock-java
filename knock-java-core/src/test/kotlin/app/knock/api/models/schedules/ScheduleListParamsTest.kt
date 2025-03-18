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
        val expected = QueryParams.builder()
        expected.put("workflow", "workflow")
        expected.put("after", "after")
        expected.put("before", "before")
        expected.put("page_size", "0")
        expected.put("recipients[]", ScheduleListParams.Recipient.ofString("user_123").toString())
        expected.put("tenant", "tenant")
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = ScheduleListParams.builder().workflow("workflow").build()
        val expected = QueryParams.builder()
        expected.put("workflow", "workflow")
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }
}
