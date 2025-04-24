// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking

import app.knock.api.TestServerExtension
import app.knock.api.client.okhttp.KnockOkHttpClient
import app.knock.api.core.JsonValue
import app.knock.api.models.UnnamedSchemaWithArrayParent0
import app.knock.api.models.recipients.channeldata.PushChannelData
import app.knock.api.models.recipients.preferences.InlinePreferenceSetRequest
import app.knock.api.models.recipients.preferences.PreferenceSetChannelTypeSetting
import app.knock.api.models.recipients.preferences.PreferenceSetChannelTypes
import app.knock.api.models.recipients.preferences.PreferenceSetRequest
import app.knock.api.models.shared.Condition
import app.knock.api.models.tenants.TenantDeleteParams
import app.knock.api.models.tenants.TenantGetParams
import app.knock.api.models.tenants.TenantSetParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class TenantServiceTest {

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun list() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val tenantService = client.tenants()

        val page = tenantService.list()

        page.response().validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun delete() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val tenantService = client.tenants()

        tenantService.delete(TenantDeleteParams.builder().id("id").build())
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun get() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val tenantService = client.tenants()

        val tenant = tenantService.get(TenantGetParams.builder().id("id").build())

        tenant.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun set() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val tenantService = client.tenants()

        val tenant =
            tenantService.set(
                TenantSetParams.builder()
                    .id("id")
                    .addChannelData(
                        UnnamedSchemaWithArrayParent0.builder()
                            .channelId("97c5837d-c65c-4d54-aa39-080eeb81c69d")
                            .data(
                                PushChannelData.builder()
                                    .addToken("push_token_xxx")
                                    .type(PushChannelData.Type.PUSH_FCM)
                                    ._typename(PushChannelData._Typename.PUSH_CHANNEL_DATA)
                                    .build()
                            )
                            .provider("push_fcm")
                            .build()
                    )
                    .preferences(
                        InlinePreferenceSetRequest.builder()
                            .id("id")
                            .categories(
                                InlinePreferenceSetRequest.Categories.builder()
                                    .putAdditionalProperty(
                                        "marketing",
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
                                                            "variable" to "specimen.dna_sequence",
                                                        )
                                                    ),
                                            )
                                        ),
                                    )
                                    .putAdditionalProperty("transactional", JsonValue.from(true))
                                    .build()
                            )
                            .channelTypes(
                                PreferenceSetChannelTypes.builder()
                                    .chat(true)
                                    .email(true)
                                    .http(true)
                                    .inAppFeed(true)
                                    .push(true)
                                    .sms(
                                        PreferenceSetChannelTypeSetting.builder()
                                            .addCondition(
                                                Condition.builder()
                                                    .argument("US")
                                                    .operator(Condition.Operator.EQUAL_TO)
                                                    .variable("recipient.country_code")
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .build()
                            )
                            .workflows(
                                InlinePreferenceSetRequest.Workflows.builder()
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
                                                            "variable" to "specimen.dna_sequence",
                                                        )
                                                    ),
                                            )
                                        ),
                                    )
                                    .putAdditionalProperty("welcome-sequence", JsonValue.from(true))
                                    .build()
                            )
                            .build()
                    )
                    .settings(
                        TenantSetParams.Settings.builder()
                            .branding(
                                TenantSetParams.Settings.Branding.builder()
                                    .iconUrl("https://example.com/trex_silhouette_icon.png")
                                    .logoUrl("https://example.com/amber_fossil_logo.png")
                                    .primaryColor("#DF1A22")
                                    .primaryColorContrast("#FFDE00")
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

        tenant.validate()
    }
}
