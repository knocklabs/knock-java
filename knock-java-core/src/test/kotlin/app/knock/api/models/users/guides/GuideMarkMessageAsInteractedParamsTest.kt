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
            .messageId("message_id")
            .channelId("123e4567-e89b-12d3-a456-426614174000")
            .guideId("323e4567-e89b-12d3-a456-426614174000")
            .guideKey("guide_12345")
            .guideStepRef("step_12345")
            .content(JsonValue.from("content_12345"))
            .data(JsonValue.from("data_12345"))
            .isFinal(true)
            .metadata(JsonValue.from("metadata_12345"))
            .tenant("tenant_12345")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            GuideMarkMessageAsInteractedParams.builder()
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
            GuideMarkMessageAsInteractedParams.builder()
                .userId("user_id")
                .messageId("message_id")
                .channelId("123e4567-e89b-12d3-a456-426614174000")
                .guideId("323e4567-e89b-12d3-a456-426614174000")
                .guideKey("guide_12345")
                .guideStepRef("step_12345")
                .content(JsonValue.from("content_12345"))
                .data(JsonValue.from("data_12345"))
                .isFinal(true)
                .metadata(JsonValue.from("metadata_12345"))
                .tenant("tenant_12345")
                .build()

        val body = params._body()

        assertThat(body.channelId()).isEqualTo("123e4567-e89b-12d3-a456-426614174000")
        assertThat(body.guideId()).isEqualTo("323e4567-e89b-12d3-a456-426614174000")
        assertThat(body.guideKey()).isEqualTo("guide_12345")
        assertThat(body.guideStepRef()).isEqualTo("step_12345")
        assertThat(body._content()).isEqualTo(JsonValue.from("content_12345"))
        assertThat(body._data()).isEqualTo(JsonValue.from("data_12345"))
        assertThat(body.isFinal()).contains(true)
        assertThat(body._metadata()).isEqualTo(JsonValue.from("metadata_12345"))
        assertThat(body.tenant()).contains("tenant_12345")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            GuideMarkMessageAsInteractedParams.builder()
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
