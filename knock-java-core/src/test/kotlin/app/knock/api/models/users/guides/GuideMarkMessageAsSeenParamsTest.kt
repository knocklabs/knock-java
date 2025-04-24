// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users.guides

import app.knock.api.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GuideMarkMessageAsSeenParamsTest {

    @Test
    fun create() {
        GuideMarkMessageAsSeenParams.builder()
            .userId("user_id")
            .messageId("message_id")
            .channelId("123e4567-e89b-12d3-a456-426614174000")
            .guideId("7e9dc78c-b3b1-4127-a54e-71f1899b831a")
            .guideKey("tour_notification")
            .guideStepRef("lab_tours")
            .content(
                GuideMarkMessageAsSeenParams.Content.builder()
                    .putAdditionalProperty("body", JsonValue.from("bar"))
                    .putAdditionalProperty("title", JsonValue.from("bar"))
                    .build()
            )
            .data(
                GuideMarkMessageAsSeenParams.Data.builder()
                    .putAdditionalProperty("next_time", JsonValue.from("bar"))
                    .putAdditionalProperty("spots_left", JsonValue.from("bar"))
                    .putAdditionalProperty("tour_id", JsonValue.from("bar"))
                    .build()
            )
            .isFinal(false)
            .metadata(
                GuideMarkMessageAsSeenParams.Metadata.builder()
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
            GuideMarkMessageAsSeenParams.builder()
                .userId("user_id")
                .messageId("message_id")
                .channelId("123e4567-e89b-12d3-a456-426614174000")
                .guideId("7e9dc78c-b3b1-4127-a54e-71f1899b831a")
                .guideKey("tour_notification")
                .guideStepRef("lab_tours")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("user_id")
        assertThat(params._pathParam(1)).isEqualTo("message_id")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            GuideMarkMessageAsSeenParams.builder()
                .userId("user_id")
                .messageId("message_id")
                .channelId("123e4567-e89b-12d3-a456-426614174000")
                .guideId("7e9dc78c-b3b1-4127-a54e-71f1899b831a")
                .guideKey("tour_notification")
                .guideStepRef("lab_tours")
                .content(
                    GuideMarkMessageAsSeenParams.Content.builder()
                        .putAdditionalProperty("body", JsonValue.from("bar"))
                        .putAdditionalProperty("title", JsonValue.from("bar"))
                        .build()
                )
                .data(
                    GuideMarkMessageAsSeenParams.Data.builder()
                        .putAdditionalProperty("next_time", JsonValue.from("bar"))
                        .putAdditionalProperty("spots_left", JsonValue.from("bar"))
                        .putAdditionalProperty("tour_id", JsonValue.from("bar"))
                        .build()
                )
                .isFinal(false)
                .metadata(
                    GuideMarkMessageAsSeenParams.Metadata.builder()
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
        assertThat(body.content())
            .contains(
                GuideMarkMessageAsSeenParams.Content.builder()
                    .putAdditionalProperty("body", JsonValue.from("bar"))
                    .putAdditionalProperty("title", JsonValue.from("bar"))
                    .build()
            )
        assertThat(body.data())
            .contains(
                GuideMarkMessageAsSeenParams.Data.builder()
                    .putAdditionalProperty("next_time", JsonValue.from("bar"))
                    .putAdditionalProperty("spots_left", JsonValue.from("bar"))
                    .putAdditionalProperty("tour_id", JsonValue.from("bar"))
                    .build()
            )
        assertThat(body.isFinal()).contains(false)
        assertThat(body.metadata())
            .contains(
                GuideMarkMessageAsSeenParams.Metadata.builder()
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
            GuideMarkMessageAsSeenParams.builder()
                .userId("user_id")
                .messageId("message_id")
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
