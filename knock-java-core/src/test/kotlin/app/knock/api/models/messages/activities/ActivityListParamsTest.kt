// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages.activities

import app.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ActivityListParamsTest {

    @Test
    fun create() {
        ActivityListParams.builder()
            .messageId("message_id")
            .after("after")
            .before("before")
            .pageSize(0L)
            .triggerData("trigger_data")
            .build()
    }

    @Test
    fun pathParams() {
        val params = ActivityListParams.builder().messageId("message_id").build()

        assertThat(params._pathParam(0)).isEqualTo("message_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            ActivityListParams.builder()
                .messageId("message_id")
                .after("after")
                .before("before")
                .pageSize(0L)
                .triggerData("trigger_data")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "after")
                    .put("before", "before")
                    .put("page_size", "0")
                    .put("trigger_data", "trigger_data")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = ActivityListParams.builder().messageId("message_id").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
