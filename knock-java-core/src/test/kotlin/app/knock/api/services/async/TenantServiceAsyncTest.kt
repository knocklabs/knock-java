// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async

import app.knock.api.TestServerExtension
import app.knock.api.client.okhttp.KnockOkHttpClientAsync
import app.knock.api.core.JsonValue
import app.knock.api.models.UnnamedSchemaWithArrayParent0
import app.knock.api.models.UnnamedSchemaWithArrayParent1
import app.knock.api.models.recipients.channeldata.PushChannelData
import app.knock.api.models.recipients.preferences.PreferenceSetChannelTypes
import app.knock.api.models.recipients.preferences.PreferenceSetRequest
import app.knock.api.models.tenants.TenantDeleteParams
import app.knock.api.models.tenants.TenantGetParams
import app.knock.api.models.tenants.TenantSetParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class TenantServiceAsyncTest {

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun list() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val tenantServiceAsync = client.tenants()

        val pageFuture = tenantServiceAsync.list()

        val page = pageFuture.get()
        page.response().validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun delete() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val tenantServiceAsync = client.tenants()

        val tenantFuture = tenantServiceAsync.delete(TenantDeleteParams.builder().id("id").build())

        val tenant = tenantFuture.get()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun get() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val tenantServiceAsync = client.tenants()

        val tenantFuture = tenantServiceAsync.get(TenantGetParams.builder().id("id").build())

        val tenant = tenantFuture.get()
        tenant.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun set() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val tenantServiceAsync = client.tenants()

        val tenantFuture =
            tenantServiceAsync.set(
                TenantSetParams.builder()
                    .id("id")
                    .addChannelData(
                        UnnamedSchemaWithArrayParent0.builder()
                            .channelId("97c5837d-c65c-4d54-aa39-080eeb81c69d")
                            .data(
                                PushChannelData.builder()
                                    ._typename(PushChannelData._Typename.PUSH_CHANNEL_DATA)
                                    .addToken("push_token_xxx")
                                    .build()
                            )
                            .provider("push_fcm")
                            .build()
                    )
                    .addPreference(
                        UnnamedSchemaWithArrayParent1.builder()
                            .id("default")
                            .categories(
                                UnnamedSchemaWithArrayParent1.Categories.builder()
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
                                                            "argument" to "some_property",
                                                            "operator" to "equal_to",
                                                            "variable" to "recipient.property",
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
                                UnnamedSchemaWithArrayParent1.Workflows.builder()
                                    .putAdditionalProperty(
                                        "dinosaurs-loose",
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
                                                            "argument" to "some_property",
                                                            "operator" to "equal_to",
                                                            "variable" to "recipient.property",
                                                        )
                                                    ),
                                            )
                                        ),
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .settings(
                        TenantSetParams.Settings.builder()
                            .branding(
                                TenantSetParams.Settings.Branding.builder()
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
                                                                    "argument" to "some_property",
                                                                    "operator" to "equal_to",
                                                                    "variable" to
                                                                        "recipient.property",
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
                                                                    "argument" to "some_property",
                                                                    "operator" to "equal_to",
                                                                    "variable" to
                                                                        "recipient.property",
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

        val tenant = tenantFuture.get()
        tenant.validate()
    }
}
