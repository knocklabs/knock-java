// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.tenants

import app.knock.api.core.JsonValue
import app.knock.api.core.jsonMapper
import app.knock.api.errors.KnockInvalidDataException
import app.knock.api.models.recipients.channeldata.InlineChannelDataRequest
import app.knock.api.models.recipients.preferences.InlinePreferenceSetRequest
import app.knock.api.models.recipients.preferences.PreferenceSetChannelTypes
import app.knock.api.models.recipients.preferences.PreferenceSetRequest
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class InlineTenantRequestTest {

    @Test
    fun ofString() {
        val string = "string"

        val inlineTenantRequest = InlineTenantRequest.ofString(string)

        assertThat(inlineTenantRequest.string()).contains(string)
        assertThat(inlineTenantRequest.tenantRequest()).isEmpty
    }

    @Test
    fun ofStringRoundtrip() {
        val jsonMapper = jsonMapper()
        val inlineTenantRequest = InlineTenantRequest.ofString("string")

        val roundtrippedInlineTenantRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inlineTenantRequest),
                jacksonTypeRef<InlineTenantRequest>(),
            )

        assertThat(roundtrippedInlineTenantRequest).isEqualTo(inlineTenantRequest)
    }

    @Test
    fun ofTenantRequest() {
        val tenantRequest =
            TenantRequest.builder()
                .id("tenant_123")
                .channelData(
                    InlineChannelDataRequest.builder()
                        .putAdditionalProperty(
                            "97c5837d-c65c-4d54-aa39-080eeb81c69d",
                            JsonValue.from(
                                mapOf("data" to mapOf("tokens" to listOf("push_token_xxx")))
                            ),
                        )
                        .build()
                )
                .preferences(
                    InlinePreferenceSetRequest.builder()
                        .putAdditionalProperty(
                            "default",
                            JsonValue.from(
                                mapOf(
                                    "categories" to
                                        mapOf(
                                            "transactional" to
                                                mapOf(
                                                    "channel_types" to
                                                        mapOf(
                                                            "chat" to true,
                                                            "email" to false,
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
                                    "channel_types" to
                                        mapOf(
                                            "chat" to true,
                                            "email" to true,
                                            "http" to true,
                                            "in_app_feed" to true,
                                            "push" to true,
                                            "sms" to true,
                                        ),
                                    "workflows" to
                                        mapOf(
                                            "dinosaurs-loose" to
                                                mapOf(
                                                    "channel_types" to
                                                        mapOf(
                                                            "chat" to true,
                                                            "email" to false,
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
                                                ),
                                            "welcome-sequence" to true,
                                        ),
                                )
                            ),
                        )
                        .build()
                )
                .settings(
                    TenantRequest.Settings.builder()
                        .branding(
                            TenantRequest.Settings.Branding.builder()
                                .iconUrl("https://example.com/icon.png")
                                .logoUrl("https://example.com/logo.png")
                                .primaryColor("#000000")
                                .primaryColorContrast("#FFFFFF")
                                .build()
                        )
                        .preferenceSet(
                            PreferenceSetRequest.builder()
                                .categories(
                                    PreferenceSetRequest.Categories.builder()
                                        .putAdditionalProperty("marketing", JsonValue.from(false))
                                        .putAdditionalProperty(
                                            "transactional",
                                            JsonValue.from(
                                                mapOf(
                                                    "channel_types" to
                                                        mapOf(
                                                            "chat" to true,
                                                            "email" to false,
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
                                    PreferenceSetRequest.Workflows.builder()
                                        .putAdditionalProperty(
                                            "dinosaurs-loose",
                                            JsonValue.from(
                                                mapOf(
                                                    "channel_types" to
                                                        mapOf(
                                                            "chat" to true,
                                                            "email" to false,
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

        val inlineTenantRequest = InlineTenantRequest.ofTenantRequest(tenantRequest)

        assertThat(inlineTenantRequest.string()).isEmpty
        assertThat(inlineTenantRequest.tenantRequest()).contains(tenantRequest)
    }

    @Test
    fun ofTenantRequestRoundtrip() {
        val jsonMapper = jsonMapper()
        val inlineTenantRequest =
            InlineTenantRequest.ofTenantRequest(
                TenantRequest.builder()
                    .id("tenant_123")
                    .channelData(
                        InlineChannelDataRequest.builder()
                            .putAdditionalProperty(
                                "97c5837d-c65c-4d54-aa39-080eeb81c69d",
                                JsonValue.from(
                                    mapOf("data" to mapOf("tokens" to listOf("push_token_xxx")))
                                ),
                            )
                            .build()
                    )
                    .preferences(
                        InlinePreferenceSetRequest.builder()
                            .putAdditionalProperty(
                                "default",
                                JsonValue.from(
                                    mapOf(
                                        "categories" to
                                            mapOf(
                                                "transactional" to
                                                    mapOf(
                                                        "channel_types" to
                                                            mapOf(
                                                                "chat" to true,
                                                                "email" to false,
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
                                        "channel_types" to
                                            mapOf(
                                                "chat" to true,
                                                "email" to true,
                                                "http" to true,
                                                "in_app_feed" to true,
                                                "push" to true,
                                                "sms" to true,
                                            ),
                                        "workflows" to
                                            mapOf(
                                                "dinosaurs-loose" to
                                                    mapOf(
                                                        "channel_types" to
                                                            mapOf(
                                                                "chat" to true,
                                                                "email" to false,
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
                                                    ),
                                                "welcome-sequence" to true,
                                            ),
                                    )
                                ),
                            )
                            .build()
                    )
                    .settings(
                        TenantRequest.Settings.builder()
                            .branding(
                                TenantRequest.Settings.Branding.builder()
                                    .iconUrl("https://example.com/icon.png")
                                    .logoUrl("https://example.com/logo.png")
                                    .primaryColor("#000000")
                                    .primaryColorContrast("#FFFFFF")
                                    .build()
                            )
                            .preferenceSet(
                                PreferenceSetRequest.builder()
                                    .categories(
                                        PreferenceSetRequest.Categories.builder()
                                            .putAdditionalProperty(
                                                "marketing",
                                                JsonValue.from(false),
                                            )
                                            .putAdditionalProperty(
                                                "transactional",
                                                JsonValue.from(
                                                    mapOf(
                                                        "channel_types" to
                                                            mapOf(
                                                                "chat" to true,
                                                                "email" to false,
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
                                        PreferenceSetRequest.Workflows.builder()
                                            .putAdditionalProperty(
                                                "dinosaurs-loose",
                                                JsonValue.from(
                                                    mapOf(
                                                        "channel_types" to
                                                            mapOf(
                                                                "chat" to true,
                                                                "email" to false,
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
            )

        val roundtrippedInlineTenantRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inlineTenantRequest),
                jacksonTypeRef<InlineTenantRequest>(),
            )

        assertThat(roundtrippedInlineTenantRequest).isEqualTo(inlineTenantRequest)
    }

    @Test
    fun incompatibleJsonShapeDeserializesToUnknown() {
        val value = JsonValue.from(listOf("invalid", "array"))
        val inlineTenantRequest =
            jsonMapper().convertValue(value, jacksonTypeRef<InlineTenantRequest>())

        val e = assertThrows<KnockInvalidDataException> { inlineTenantRequest.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
