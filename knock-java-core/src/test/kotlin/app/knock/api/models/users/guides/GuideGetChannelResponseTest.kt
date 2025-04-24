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
                        .id("f47ac10b-58cc-4372-a567-0e02b2c3d479")
                        .content("New prehistoric specimens added to the visitor center display.")
                        .metadata(
                            GuideGetChannelResponse.Guide.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .title("Amber Collection Updated")
                        .build()
                )
                .addGuide(
                    GuideGetChannelResponse.Guide.builder()
                        .id("fe6c2c9c-849e-48d2-a5e5-9dc1f6b0f806")
                        .content("Version 2.1 - Enhanced paddock monitoring now available.")
                        .metadata(
                            GuideGetChannelResponse.Guide.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .title("Security Systems Upgraded")
                        .build()
                )
                .recipient(GuideGetChannelResponse.Recipient.builder().id("dr_malcolm").build())
                .build()

        assertThat(guideGetChannelResponse.guides())
            .containsExactly(
                GuideGetChannelResponse.Guide.builder()
                    .id("f47ac10b-58cc-4372-a567-0e02b2c3d479")
                    .content("New prehistoric specimens added to the visitor center display.")
                    .metadata(
                        GuideGetChannelResponse.Guide.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .title("Amber Collection Updated")
                    .build(),
                GuideGetChannelResponse.Guide.builder()
                    .id("fe6c2c9c-849e-48d2-a5e5-9dc1f6b0f806")
                    .content("Version 2.1 - Enhanced paddock monitoring now available.")
                    .metadata(
                        GuideGetChannelResponse.Guide.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .title("Security Systems Upgraded")
                    .build(),
            )
        assertThat(guideGetChannelResponse.recipient())
            .contains(GuideGetChannelResponse.Recipient.builder().id("dr_malcolm").build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val guideGetChannelResponse =
            GuideGetChannelResponse.builder()
                .addGuide(
                    GuideGetChannelResponse.Guide.builder()
                        .id("f47ac10b-58cc-4372-a567-0e02b2c3d479")
                        .content("New prehistoric specimens added to the visitor center display.")
                        .metadata(
                            GuideGetChannelResponse.Guide.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .title("Amber Collection Updated")
                        .build()
                )
                .addGuide(
                    GuideGetChannelResponse.Guide.builder()
                        .id("fe6c2c9c-849e-48d2-a5e5-9dc1f6b0f806")
                        .content("Version 2.1 - Enhanced paddock monitoring now available.")
                        .metadata(
                            GuideGetChannelResponse.Guide.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .title("Security Systems Upgraded")
                        .build()
                )
                .recipient(GuideGetChannelResponse.Recipient.builder().id("dr_malcolm").build())
                .build()

        val roundtrippedGuideGetChannelResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(guideGetChannelResponse),
                jacksonTypeRef<GuideGetChannelResponse>(),
            )

        assertThat(roundtrippedGuideGetChannelResponse).isEqualTo(guideGetChannelResponse)
    }
}
