// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.channels.bulk

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BulkUpdateMessageStatusParamsTest {

    @Test
    fun create() {
        BulkUpdateMessageStatusParams.builder()
            .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .action(BulkUpdateMessageStatusParams.Action.SEEN)
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            BulkUpdateMessageStatusParams.builder()
                .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .action(BulkUpdateMessageStatusParams.Action.SEEN)
                .build()

        assertThat(params._pathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(params._pathParam(1)).isEqualTo("seen")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }
}
