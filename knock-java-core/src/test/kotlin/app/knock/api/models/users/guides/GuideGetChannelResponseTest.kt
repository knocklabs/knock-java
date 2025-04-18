// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users.guides

import app.knock.api.core.JsonValue
import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GuideGetChannelResponseTest {

    @Test
    fun create() {
        val guideGetChannelResponse =
            GuideGetChannelResponse.builder()
                .addGuide(
                    GuideGetChannelResponse.Guide.builder()
                        .id("323e4567-e89b-12d3-a456-426614174000")
                        .content("Welcome to our application!")
                        .metadata(
                            GuideGetChannelResponse.Guide.Metadata.builder()
                                .putAdditionalProperty("dismissable", JsonValue.from("bar"))
                                .putAdditionalProperty("position", JsonValue.from("bar"))
                                .build()
                        )
                        .title("Welcome Guide")
                        .build()
                )
                .recipient(GuideGetChannelResponse.Recipient.builder().id("user_12345").build())
                .build()

        assertThat(guideGetChannelResponse.guides())
            .containsExactly(
                GuideGetChannelResponse.Guide.builder()
                    .id("323e4567-e89b-12d3-a456-426614174000")
                    .content("Welcome to our application!")
                    .metadata(
                        GuideGetChannelResponse.Guide.Metadata.builder()
                            .putAdditionalProperty("dismissable", JsonValue.from("bar"))
                            .putAdditionalProperty("position", JsonValue.from("bar"))
                            .build()
                    )
                    .title("Welcome Guide")
                    .build()
            )
        assertThat(guideGetChannelResponse.recipient())
            .contains(GuideGetChannelResponse.Recipient.builder().id("user_12345").build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val guideGetChannelResponse =
            GuideGetChannelResponse.builder()
                .addGuide(
                    GuideGetChannelResponse.Guide.builder()
                        .id("323e4567-e89b-12d3-a456-426614174000")
                        .content("Welcome to our application!")
                        .metadata(
                            GuideGetChannelResponse.Guide.Metadata.builder()
                                .putAdditionalProperty("dismissable", JsonValue.from("bar"))
                                .putAdditionalProperty("position", JsonValue.from("bar"))
                                .build()
                        )
                        .title("Welcome Guide")
                        .build()
                )
                .recipient(GuideGetChannelResponse.Recipient.builder().id("user_12345").build())
                .build()

        val roundtrippedGuideGetChannelResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(guideGetChannelResponse),
                jacksonTypeRef<GuideGetChannelResponse>(),
            )

        assertThat(roundtrippedGuideGetChannelResponse).isEqualTo(guideGetChannelResponse)
    }
}
