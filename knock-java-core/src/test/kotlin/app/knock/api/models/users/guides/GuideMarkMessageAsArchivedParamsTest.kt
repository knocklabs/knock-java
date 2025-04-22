// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users.guides

import app.knock.api.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GuideMarkMessageAsArchivedParamsTest {

    @Test
    fun create() {
        GuideMarkMessageAsArchivedParams.builder()
            .userId("user_id")
            .messageId("message_id")
            .channelId("123e4567-e89b-12d3-a456-426614174000")
            .guideId("323e4567-e89b-12d3-a456-426614174000")
            .guideKey("guide_12345")
            .guideStepRef("step_12345")
            .content(
                GuideMarkMessageAsArchivedParams.Content.builder()
                    .putAdditionalProperty("body", JsonValue.from("bar"))
                    .putAdditionalProperty("title", JsonValue.from("bar"))
                    .build()
            )
            .data(
                GuideMarkMessageAsArchivedParams.Data.builder()
                    .putAdditionalProperty("product_id", JsonValue.from("bar"))
                    .build()
            )
            .isFinal(true)
            .metadata(
                GuideMarkMessageAsArchivedParams.Metadata.builder()
                    .putAdditionalProperty("source", JsonValue.from("bar"))
                    .build()
            )
            .tenant("tenant_12345")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            GuideMarkMessageAsArchivedParams.builder()
                .userId("user_id")
                .messageId("message_id")
                .channelId("123e4567-e89b-12d3-a456-426614174000")
                .guideId("323e4567-e89b-12d3-a456-426614174000")
                .guideKey("guide_12345")
                .guideStepRef("step_12345")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("user_id")
        assertThat(params._pathParam(1)).isEqualTo("message_id")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            GuideMarkMessageAsArchivedParams.builder()
                .userId("user_id")
                .messageId("message_id")
                .channelId("123e4567-e89b-12d3-a456-426614174000")
                .guideId("323e4567-e89b-12d3-a456-426614174000")
                .guideKey("guide_12345")
                .guideStepRef("step_12345")
                .content(
                    GuideMarkMessageAsArchivedParams.Content.builder()
                        .putAdditionalProperty("body", JsonValue.from("bar"))
                        .putAdditionalProperty("title", JsonValue.from("bar"))
                        .build()
                )
                .data(
                    GuideMarkMessageAsArchivedParams.Data.builder()
                        .putAdditionalProperty("product_id", JsonValue.from("bar"))
                        .build()
                )
                .isFinal(true)
                .metadata(
                    GuideMarkMessageAsArchivedParams.Metadata.builder()
                        .putAdditionalProperty("source", JsonValue.from("bar"))
                        .build()
                )
                .tenant("tenant_12345")
                .build()

        val body = params._body()

        assertThat(body.channelId()).isEqualTo("123e4567-e89b-12d3-a456-426614174000")
        assertThat(body.guideId()).isEqualTo("323e4567-e89b-12d3-a456-426614174000")
        assertThat(body.guideKey()).isEqualTo("guide_12345")
        assertThat(body.guideStepRef()).isEqualTo("step_12345")
        assertThat(body.content())
            .contains(
                GuideMarkMessageAsArchivedParams.Content.builder()
                    .putAdditionalProperty("body", JsonValue.from("bar"))
                    .putAdditionalProperty("title", JsonValue.from("bar"))
                    .build()
            )
        assertThat(body.data())
            .contains(
                GuideMarkMessageAsArchivedParams.Data.builder()
                    .putAdditionalProperty("product_id", JsonValue.from("bar"))
                    .build()
            )
        assertThat(body.isFinal()).contains(true)
        assertThat(body.metadata())
            .contains(
                GuideMarkMessageAsArchivedParams.Metadata.builder()
                    .putAdditionalProperty("source", JsonValue.from("bar"))
                    .build()
            )
        assertThat(body.tenant()).contains("tenant_12345")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            GuideMarkMessageAsArchivedParams.builder()
                .userId("user_id")
                .messageId("message_id")
                .channelId("123e4567-e89b-12d3-a456-426614174000")
                .guideId("323e4567-e89b-12d3-a456-426614174000")
                .guideKey("guide_12345")
                .guideStepRef("step_12345")
                .build()

        val body = params._body()

        assertThat(body.channelId()).isEqualTo("123e4567-e89b-12d3-a456-426614174000")
        assertThat(body.guideId()).isEqualTo("323e4567-e89b-12d3-a456-426614174000")
        assertThat(body.guideKey()).isEqualTo("guide_12345")
        assertThat(body.guideStepRef()).isEqualTo("step_12345")
    }
}
