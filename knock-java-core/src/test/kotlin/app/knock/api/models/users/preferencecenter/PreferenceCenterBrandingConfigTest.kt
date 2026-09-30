// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users.preferencecenter

import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PreferenceCenterBrandingConfigTest {

    @Test
    fun create() {
        val preferenceCenterBrandingConfig =
            PreferenceCenterBrandingConfig.builder()
                .iconUrl("https://example.com/icon.png")
                .logoUrl("https://example.com/logo.png")
                .primaryColor("#000000")
                .primaryColorContrast(null)
                .build()

        assertThat(preferenceCenterBrandingConfig.iconUrl())
            .contains("https://example.com/icon.png")
        assertThat(preferenceCenterBrandingConfig.logoUrl())
            .contains("https://example.com/logo.png")
        assertThat(preferenceCenterBrandingConfig.primaryColor()).contains("#000000")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val preferenceCenterBrandingConfig =
            PreferenceCenterBrandingConfig.builder()
                .iconUrl("https://example.com/icon.png")
                .logoUrl("https://example.com/logo.png")
                .primaryColor("#000000")
                .primaryColorContrast(null)
                .build()

        val roundtrippedPreferenceCenterBrandingConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(preferenceCenterBrandingConfig),
                jacksonTypeRef<PreferenceCenterBrandingConfig>(),
            )

        assertThat(roundtrippedPreferenceCenterBrandingConfig)
            .isEqualTo(preferenceCenterBrandingConfig)
    }
}
