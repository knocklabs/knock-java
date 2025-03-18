// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages

import app.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageListDeliveryLogsParamsTest {

    @Test
    fun create() {
        MessageListDeliveryLogsParams.builder()
            .messageId("message_id")
            .after("after")
            .before("before")
            .pageSize(0L)
            .build()
    }

    @Test
    fun pathParams() {
        val params = MessageListDeliveryLogsParams.builder().messageId("message_id").build()

        assertThat(params._pathParam(0)).isEqualTo("message_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            MessageListDeliveryLogsParams.builder()
                .messageId("message_id")
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
        val params = MessageListDeliveryLogsParams.builder().messageId("message_id").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
