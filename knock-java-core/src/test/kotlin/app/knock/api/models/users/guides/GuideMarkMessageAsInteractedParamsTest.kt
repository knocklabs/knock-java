// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users.guides

import app.knock.api.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GuideMarkMessageAsInteractedParamsTest {

    @Test
    fun create() {
        GuideMarkMessageAsInteractedParams.builder()
            .userId("user_id")
            .channelId("123e4567-e89b-12d3-a456-426614174000")
            .guideId("7e9dc78c-b3b1-4127-a54e-71f1899b831a")
            .guideKey("tour_notification")
            .guideStepRef("lab_tours")
            .metadata(
                GuideMarkMessageAsInteractedParams.Metadata.builder()
                    .putAdditionalProperty("cta", JsonValue.from("bar"))
                    .putAdditionalProperty("theme", JsonValue.from("bar"))
                    .putAdditionalProperty("type", JsonValue.from("bar"))
                    .build()
            )
            .tenant("ingen_isla_nublar")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            GuideMarkMessageAsInteractedParams.builder()
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
            GuideMarkMessageAsInteractedParams.builder()
                .userId("user_id")
                .channelId("123e4567-e89b-12d3-a456-426614174000")
                .guideId("7e9dc78c-b3b1-4127-a54e-71f1899b831a")
                .guideKey("tour_notification")
                .guideStepRef("lab_tours")
                .metadata(
                    GuideMarkMessageAsInteractedParams.Metadata.builder()
                        .putAdditionalProperty("cta", JsonValue.from("bar"))
                        .putAdditionalProperty("theme", JsonValue.from("bar"))
                        .putAdditionalProperty("type", JsonValue.from("bar"))
                        .build()
                )
                .tenant("ingen_isla_nublar")
                .build()

        val body = params._body()

        assertThat(body.channelId()).isEqualTo("123e4567-e89b-12d3-a456-426614174000")
        assertThat(body.guideId()).isEqualTo("7e9dc78c-b3b1-4127-a54e-71f1899b831a")
        assertThat(body.guideKey()).isEqualTo("tour_notification")
        assertThat(body.guideStepRef()).isEqualTo("lab_tours")
        assertThat(body.metadata())
            .contains(
                GuideMarkMessageAsInteractedParams.Metadata.builder()
                    .putAdditionalProperty("cta", JsonValue.from("bar"))
                    .putAdditionalProperty("theme", JsonValue.from("bar"))
                    .putAdditionalProperty("type", JsonValue.from("bar"))
                    .build()
            )
        assertThat(body.tenant()).contains("ingen_isla_nublar")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            GuideMarkMessageAsInteractedParams.builder()
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
