// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.tenants

import app.knock.api.core.JsonValue
import app.knock.api.core.jsonMapper
import app.knock.api.models.recipients.preferences.PreferenceSet
import app.knock.api.models.recipients.preferences.PreferenceSetChannelTypes
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TenantTest {

    @Test
    fun create() {
        val tenant =
            Tenant.builder()
                .id("tenant_jp123")
                ._typename("Tenant")
                .name("Jurassic Park")
                .settings(
                    Tenant.Settings.builder()
                        .branding(
                            Tenant.Settings.Branding.builder()
                                .iconUrl("https://example.com/trex_silhouette_icon.png")
                                .logoUrl("https://example.com/amber_fossil_logo.png")
                                .primaryColor("#DF1A22")
                                .primaryColorContrast("#FFDE00")
                                .build()
                        )
                        .preferenceSet(
                            PreferenceSet.builder()
                                .id("default")
                                ._typename("PreferenceSet")
                                .categories(
                                    PreferenceSet.Categories.builder()
                                        .putAdditionalProperty(
                                            "safety",
                                            JsonValue.from(
                                                mapOf(
                                                    "channel_types" to
                                                        mapOf(
                                                            "chat" to true,
                                                            "email" to true,
                                                            "http" to true,
                                                            "in_app_feed" to true,
                                                            "push" to true,
                                                            "sms" to true,
                                                        ),
                                                    "conditions" to
                                                        listOf(
                                                            mapOf(
                                                                "argument" to "frog_genome",
                                                                "operator" to "contains",
                                                                "variable" to
                                                                    "specimen.dna_sequence",
                                                            )
                                                        ),
                                                )
                                            ),
                                        )
                                        .build()
                                )
                                .channelTypes(
                                    PreferenceSetChannelTypes.builder()
                                        .chat(true)
                                        .email(true)
                                        .http(true)
                                        .inAppFeed(true)
                                        .push(true)
                                        .sms(true)
                                        .build()
                                )
                                .workflows(
                                    PreferenceSet.Workflows.builder()
                                        .putAdditionalProperty(
                                            "park_alert",
                                            JsonValue.from(
                                                mapOf(
                                                    "channel_types" to
                                                        mapOf(
                                                            "chat" to true,
                                                            "email" to true,
                                                            "http" to true,
                                                            "in_app_feed" to true,
                                                            "push" to true,
                                                            "sms" to true,
                                                        ),
                                                    "conditions" to
                                                        listOf(
                                                            mapOf(
                                                                "argument" to "frog_genome",
                                                                "operator" to "contains",
                                                                "variable" to
                                                                    "specimen.dna_sequence",
                                                            )
                                                        ),
                                                )
                                            ),
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .build()

        assertThat(tenant.id()).isEqualTo("tenant_jp123")
        assertThat(tenant._typename()).isEqualTo("Tenant")
        assertThat(tenant.name()).contains("Jurassic Park")
        assertThat(tenant.settings())
            .contains(
                Tenant.Settings.builder()
                    .branding(
                        Tenant.Settings.Branding.builder()
                            .iconUrl("https://example.com/trex_silhouette_icon.png")
                            .logoUrl("https://example.com/amber_fossil_logo.png")
                            .primaryColor("#DF1A22")
                            .primaryColorContrast("#FFDE00")
                            .build()
                    )
                    .preferenceSet(
                        PreferenceSet.builder()
                            .id("default")
                            ._typename("PreferenceSet")
                            .categories(
                                PreferenceSet.Categories.builder()
                                    .putAdditionalProperty(
                                        "safety",
                                        JsonValue.from(
                                            mapOf(
                                                "channel_types" to
                                                    mapOf(
                                                        "chat" to true,
                                                        "email" to true,
                                                        "http" to true,
                                                        "in_app_feed" to true,
                                                        "push" to true,
                                                        "sms" to true,
                                                    ),
                                                "conditions" to
                                                    listOf(
                                                        mapOf(
                                                            "argument" to "frog_genome",
                                                            "operator" to "contains",
                                                            "variable" to "specimen.dna_sequence",
                                                        )
                                                    ),
                                            )
                                        ),
                                    )
                                    .build()
                            )
                            .channelTypes(
                                PreferenceSetChannelTypes.builder()
                                    .chat(true)
                                    .email(true)
                                    .http(true)
                                    .inAppFeed(true)
                                    .push(true)
                                    .sms(true)
                                    .build()
                            )
                            .workflows(
                                PreferenceSet.Workflows.builder()
                                    .putAdditionalProperty(
                                        "park_alert",
                                        JsonValue.from(
                                            mapOf(
                                                "channel_types" to
                                                    mapOf(
                                                        "chat" to true,
                                                        "email" to true,
                                                        "http" to true,
                                                        "in_app_feed" to true,
                                                        "push" to true,
                                                        "sms" to true,
                                                    ),
                                                "conditions" to
                                                    listOf(
                                                        mapOf(
                                                            "argument" to "frog_genome",
                                                            "operator" to "contains",
                                                            "variable" to "specimen.dna_sequence",
                                                        )
                                                    ),
                                            )
                                        ),
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val tenant =
            Tenant.builder()
                .id("tenant_jp123")
                ._typename("Tenant")
                .name("Jurassic Park")
                .settings(
                    Tenant.Settings.builder()
                        .branding(
                            Tenant.Settings.Branding.builder()
                                .iconUrl("https://example.com/trex_silhouette_icon.png")
                                .logoUrl("https://example.com/amber_fossil_logo.png")
                                .primaryColor("#DF1A22")
                                .primaryColorContrast("#FFDE00")
                                .build()
                        )
                        .preferenceSet(
                            PreferenceSet.builder()
                                .id("default")
                                ._typename("PreferenceSet")
                                .categories(
                                    PreferenceSet.Categories.builder()
                                        .putAdditionalProperty(
                                            "safety",
                                            JsonValue.from(
                                                mapOf(
                                                    "channel_types" to
                                                        mapOf(
                                                            "chat" to true,
                                                            "email" to true,
                                                            "http" to true,
                                                            "in_app_feed" to true,
                                                            "push" to true,
                                                            "sms" to true,
                                                        ),
                                                    "conditions" to
                                                        listOf(
                                                            mapOf(
                                                                "argument" to "frog_genome",
                                                                "operator" to "contains",
                                                                "variable" to
                                                                    "specimen.dna_sequence",
                                                            )
                                                        ),
                                                )
                                            ),
                                        )
                                        .build()
                                )
                                .channelTypes(
                                    PreferenceSetChannelTypes.builder()
                                        .chat(true)
                                        .email(true)
                                        .http(true)
                                        .inAppFeed(true)
                                        .push(true)
                                        .sms(true)
                                        .build()
                                )
                                .workflows(
                                    PreferenceSet.Workflows.builder()
                                        .putAdditionalProperty(
                                            "park_alert",
                                            JsonValue.from(
                                                mapOf(
                                                    "channel_types" to
                                                        mapOf(
                                                            "chat" to true,
                                                            "email" to true,
                                                            "http" to true,
                                                            "in_app_feed" to true,
                                                            "push" to true,
                                                            "sms" to true,
                                                        ),
                                                    "conditions" to
                                                        listOf(
                                                            mapOf(
                                                                "argument" to "frog_genome",
                                                                "operator" to "contains",
                                                                "variable" to
                                                                    "specimen.dna_sequence",
                                                            )
                                                        ),
                                                )
                                            ),
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .build()

        val roundtrippedTenant =
            jsonMapper.readValue(jsonMapper.writeValueAsString(tenant), jacksonTypeRef<Tenant>())

        assertThat(roundtrippedTenant).isEqualTo(tenant)
    }
}
