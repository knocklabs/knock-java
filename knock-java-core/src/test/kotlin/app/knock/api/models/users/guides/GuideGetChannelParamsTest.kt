// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users.guides

import app.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GuideGetChannelParamsTest {

    @Test
    fun create() {
        GuideGetChannelParams.builder()
            .userId("user_id")
            .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .data("data")
            .tenant("tenant")
            .type("type")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            GuideGetChannelParams.builder()
                .userId("user_id")
                .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("user_id")
        assertThat(params._pathParam(1)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            GuideGetChannelParams.builder()
                .userId("user_id")
                .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .data("data")
                .tenant("tenant")
                .type("type")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("data", "data")
                    .put("tenant", "tenant")
                    .put("type", "type")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            GuideGetChannelParams.builder()
                .userId("user_id")
                .channelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
