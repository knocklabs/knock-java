// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users.feeds

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FeedGetSettingsParamsTest {

    @Test
    fun create() {
        FeedGetSettingsParams.builder()
            .userId("user_id")
            .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            FeedGetSettingsParams.builder()
                .userId("user_id")
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("user_id")
        assertThat(params._pathParam(1)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }
}
