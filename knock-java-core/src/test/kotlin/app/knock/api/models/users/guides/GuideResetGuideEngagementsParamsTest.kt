// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users.guides

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GuideResetGuideEngagementsParamsTest {

    @Test
    fun create() {
        GuideResetGuideEngagementsParams.builder()
            .userId("user_id")
            .guideKey("tour_notification")
            .tenant("ingen_isla_nublar")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            GuideResetGuideEngagementsParams.builder()
                .userId("user_id")
                .guideKey("tour_notification")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("user_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            GuideResetGuideEngagementsParams.builder()
                .userId("user_id")
                .guideKey("tour_notification")
                .tenant("ingen_isla_nublar")
                .build()

        val body = params._body()

        assertThat(body.guideKey()).isEqualTo("tour_notification")
        assertThat(body.tenant()).contains("ingen_isla_nublar")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            GuideResetGuideEngagementsParams.builder()
                .userId("user_id")
                .guideKey("tour_notification")
                .build()

        val body = params._body()

        assertThat(body.guideKey()).isEqualTo("tour_notification")
    }
}
