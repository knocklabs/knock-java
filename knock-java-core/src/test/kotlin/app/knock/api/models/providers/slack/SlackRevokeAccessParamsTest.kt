// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.providers.slack

import app.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SlackRevokeAccessParamsTest {

    @Test
    fun create() {
        SlackRevokeAccessParams.builder()
            .channelId("channel_id")
            .accessTokenObject("access_token_object")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            SlackRevokeAccessParams.builder()
                .channelId("channel_id")
                .accessTokenObject("access_token_object")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("channel_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            SlackRevokeAccessParams.builder()
                .channelId("channel_id")
                .accessTokenObject("access_token_object")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder().put("access_token_object", "access_token_object").build()
            )
    }
}
