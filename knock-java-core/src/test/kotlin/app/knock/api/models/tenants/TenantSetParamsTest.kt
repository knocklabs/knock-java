// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.tenants

import app.knock.api.core.JsonValue
import app.knock.api.models.UnnamedSchemaWithArrayParent0
import app.knock.api.models.UnnamedSchemaWithArrayParent1
import app.knock.api.models.recipients.channeldata.PushChannelData
import app.knock.api.models.recipients.preferences.PreferenceSetChannelTypes
import app.knock.api.models.recipients.preferences.PreferenceSetRequest
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TenantSetParamsTest {

    @Test
    fun create() {
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
                    .build()
            )
            .build()
    }

    @Test
    fun pathParams() {
        val params = TenantSetParams.builder().id("id").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
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
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.channelData().getOrNull())
            .containsExactly(
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
        assertThat(body.preferences().getOrNull())
            .containsExactly(
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
        assertThat(body.settings())
            .contains(
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
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = TenantSetParams.builder().id("id").build()

        val body = params._body()
    }
}
