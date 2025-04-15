// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages.batch

import app.knock.api.core.JsonValue
import app.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BatchGetContentParamsTest {

    @Test
    fun create() {
        BatchGetContentParams.builder().addMessageId(JsonValue.from(mapOf<String, Any>())).build()
    }

    @Test
    fun queryParams() {
        val params =
            BatchGetContentParams.builder()
                .addMessageId(JsonValue.from(mapOf<String, Any>()))
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
