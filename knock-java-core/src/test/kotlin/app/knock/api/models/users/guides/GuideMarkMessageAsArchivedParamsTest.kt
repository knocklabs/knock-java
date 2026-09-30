// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users.guides

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GuideMarkMessageAsArchivedParamsTest {

    @Test
    fun create() {
        GuideMarkMessageAsArchivedParams.builder()
            .userId("user_id")
            .channelId("123e4567-e89b-12d3-a456-426614174000")
            .guideId("7e9dc78c-b3b1-4127-a54e-71f1899b831a")
            .guideKey("tour_notification")
            .guideStepRef("lab_tours")
            .isFinal(false)
            .tenant("ingen_isla_nublar")
            .unthrottled(false)
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            GuideMarkMessageAsArchivedParams.builder()
                .userId("user_id")
                .channelId("123e4567-e89b-12d3-a456-426614174000")
                .guideId("7e9dc78c-b3b1-4127-a54e-71f1899b831a")
                .guideKey("tour_notification")
                .guideStepRef("lab_tours")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("user_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            GuideMarkMessageAsArchivedParams.builder()
                .userId("user_id")
                .channelId("123e4567-e89b-12d3-a456-426614174000")
                .guideId("7e9dc78c-b3b1-4127-a54e-71f1899b831a")
                .guideKey("tour_notification")
                .guideStepRef("lab_tours")
                .isFinal(false)
                .tenant("ingen_isla_nublar")
                .unthrottled(false)
                .build()

        val body = params._body()

        assertThat(body.channelId()).isEqualTo("123e4567-e89b-12d3-a456-426614174000")
        assertThat(body.guideId()).isEqualTo("7e9dc78c-b3b1-4127-a54e-71f1899b831a")
        assertThat(body.guideKey()).isEqualTo("tour_notification")
        assertThat(body.guideStepRef()).isEqualTo("lab_tours")
        assertThat(body.isFinal()).contains(false)
        assertThat(body.tenant()).contains("ingen_isla_nublar")
        assertThat(body.unthrottled()).contains(false)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            GuideMarkMessageAsArchivedParams.builder()
                .userId("user_id")
                .channelId("123e4567-e89b-12d3-a456-426614174000")
                .guideId("7e9dc78c-b3b1-4127-a54e-71f1899b831a")
                .guideKey("tour_notification")
                .guideStepRef("lab_tours")
                .build()

        val body = params._body()

        assertThat(body.channelId()).isEqualTo("123e4567-e89b-12d3-a456-426614174000")
        assertThat(body.guideId()).isEqualTo("7e9dc78c-b3b1-4127-a54e-71f1899b831a")
        assertThat(body.guideKey()).isEqualTo("tour_notification")
        assertThat(body.guideStepRef()).isEqualTo("lab_tours")
    }
}
