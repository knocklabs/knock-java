// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages

import app.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MessageListActivitiesParamsTest {

    @Test
    fun create() {
        MessageListActivitiesParams.builder()
            .messageId("message_id")
            .after("after")
            .before("before")
            .pageSize(0L)
            .triggerData("trigger_data")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            MessageListActivitiesParams.builder()
                .messageId("message_id")
                .after("after")
                .before("before")
                .pageSize(0L)
                .triggerData("trigger_data")
                .build()
        val expected = QueryParams.builder()
        expected.put("after", "after")
        expected.put("before", "before")
        expected.put("page_size", "0")
        expected.put("trigger_data", "trigger_data")
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = MessageListActivitiesParams.builder().messageId("message_id").build()
        val expected = QueryParams.builder()
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun getPathParam() {
        val params = MessageListActivitiesParams.builder().messageId("message_id").build()
        assertThat(params).isNotNull
        // path param "messageId"
        assertThat(params.getPathParam(0)).isEqualTo("message_id")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
