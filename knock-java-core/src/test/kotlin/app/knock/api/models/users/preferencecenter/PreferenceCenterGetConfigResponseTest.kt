// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users.preferencecenter

import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PreferenceCenterGetConfigResponseTest {

    @Test
    fun create() {
        val preferenceCenterGetConfigResponse =
            PreferenceCenterGetConfigResponse.builder()
                .accountName("Acme")
                .branding(
                    PreferenceCenterGetConfigResponse.Branding.builder()
                        .iconUrl("https://example.com/icon.png")
                        .logoUrl(null)
                        .primaryColor("#000000")
                        .primaryColorContrast("#ffffff")
                        .dark(
                            PreferenceCenterBrandingConfig.builder().primaryColor("#ffffff").build()
                        )
                        .build()
                )
                .config(
                    PreferenceCenterGetConfigResponse.Config.builder()
                        .body("Manage your notification preferences.")
                        .addRow(
                            PreferenceCenterGetConfigResponse.Config.Row.builder()
                                .name("Marketing")
                                .type(PreferenceCenterGetConfigResponse.Config.Row.Type.CATEGORY)
                                .addChannelType(
                                    PreferenceCenterGetConfigResponse.Config.Row.ChannelType.EMAIL
                                )
                                .description("Product news")
                                .identifier("marketing")
                                .build()
                        )
                        .title("Preferences")
                        .showAccountName(true)
                        .build()
                )
                .enabled(true)
                .userEmail("jane@example.com")
                .knockBrandingRequired(false)
                .build()

        assertThat(preferenceCenterGetConfigResponse.accountName()).contains("Acme")
        assertThat(preferenceCenterGetConfigResponse.branding())
            .isEqualTo(
                PreferenceCenterGetConfigResponse.Branding.builder()
                    .iconUrl("https://example.com/icon.png")
                    .logoUrl(null)
                    .primaryColor("#000000")
                    .primaryColorContrast("#ffffff")
                    .dark(PreferenceCenterBrandingConfig.builder().primaryColor("#ffffff").build())
                    .build()
            )
        assertThat(preferenceCenterGetConfigResponse.config())
            .isEqualTo(
                PreferenceCenterGetConfigResponse.Config.builder()
                    .body("Manage your notification preferences.")
                    .addRow(
                        PreferenceCenterGetConfigResponse.Config.Row.builder()
                            .name("Marketing")
                            .type(PreferenceCenterGetConfigResponse.Config.Row.Type.CATEGORY)
                            .addChannelType(
                                PreferenceCenterGetConfigResponse.Config.Row.ChannelType.EMAIL
                            )
                            .description("Product news")
                            .identifier("marketing")
                            .build()
                    )
                    .title("Preferences")
                    .showAccountName(true)
                    .build()
            )
        assertThat(preferenceCenterGetConfigResponse.enabled()).isEqualTo(true)
        assertThat(preferenceCenterGetConfigResponse.userEmail()).contains("jane@example.com")
        assertThat(preferenceCenterGetConfigResponse.knockBrandingRequired()).contains(false)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val preferenceCenterGetConfigResponse =
            PreferenceCenterGetConfigResponse.builder()
                .accountName("Acme")
                .branding(
                    PreferenceCenterGetConfigResponse.Branding.builder()
                        .iconUrl("https://example.com/icon.png")
                        .logoUrl(null)
                        .primaryColor("#000000")
                        .primaryColorContrast("#ffffff")
                        .dark(
                            PreferenceCenterBrandingConfig.builder().primaryColor("#ffffff").build()
                        )
                        .build()
                )
                .config(
                    PreferenceCenterGetConfigResponse.Config.builder()
                        .body("Manage your notification preferences.")
                        .addRow(
                            PreferenceCenterGetConfigResponse.Config.Row.builder()
                                .name("Marketing")
                                .type(PreferenceCenterGetConfigResponse.Config.Row.Type.CATEGORY)
                                .addChannelType(
                                    PreferenceCenterGetConfigResponse.Config.Row.ChannelType.EMAIL
                                )
                                .description("Product news")
                                .identifier("marketing")
                                .build()
                        )
                        .title("Preferences")
                        .showAccountName(true)
                        .build()
                )
                .enabled(true)
                .userEmail("jane@example.com")
                .knockBrandingRequired(false)
                .build()

        val roundtrippedPreferenceCenterGetConfigResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(preferenceCenterGetConfigResponse),
                jacksonTypeRef<PreferenceCenterGetConfigResponse>(),
            )

        assertThat(roundtrippedPreferenceCenterGetConfigResponse)
            .isEqualTo(preferenceCenterGetConfigResponse)
    }
}
