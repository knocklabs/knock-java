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
            .guideId("323e4567-e89b-12d3-a456-426614174000")
            .guideKey("guide_12345")
            .guideStepRef("step_12345")
            .content(
                JsonValue.from(mapOf("body" to "Guide content body", "title" to "Guide Title"))
            )
            .data(JsonValue.from(mapOf("product_id" to "product_123")))
            .isFinal(true)
            .metadata(JsonValue.from(mapOf("source" to "onboarding")))
            .tenant("tenant_12345")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            GuideMarkMessageAsSeenParams.builder()
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
            GuideMarkMessageAsSeenParams.builder()
                .userId("user_id")
                .messageId("message_id")
                .channelId("123e4567-e89b-12d3-a456-426614174000")
                .guideId("323e4567-e89b-12d3-a456-426614174000")
                .guideKey("guide_12345")
                .guideStepRef("step_12345")
                .content(
                    JsonValue.from(mapOf("body" to "Guide content body", "title" to "Guide Title"))
                )
                .data(JsonValue.from(mapOf("product_id" to "product_123")))
                .isFinal(true)
                .metadata(JsonValue.from(mapOf("source" to "onboarding")))
                .tenant("tenant_12345")
                .build()

        val body = params._body()

        assertThat(body.channelId()).isEqualTo("123e4567-e89b-12d3-a456-426614174000")
        assertThat(body.guideId()).isEqualTo("323e4567-e89b-12d3-a456-426614174000")
        assertThat(body.guideKey()).isEqualTo("guide_12345")
        assertThat(body.guideStepRef()).isEqualTo("step_12345")
        assertThat(body._content())
            .isEqualTo(
                JsonValue.from(mapOf("body" to "Guide content body", "title" to "Guide Title"))
            )
        assertThat(body._data()).isEqualTo(JsonValue.from(mapOf("product_id" to "product_123")))
        assertThat(body.isFinal()).contains(true)
        assertThat(body._metadata()).isEqualTo(JsonValue.from(mapOf("source" to "onboarding")))
        assertThat(body.tenant()).contains("tenant_12345")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            GuideMarkMessageAsSeenParams.builder()
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
