// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.recipients.preferences

import app.knock.api.core.JsonValue
import org.junit.jupiter.api.Test

internal class InlinePreferenceSetRequestTest {

    @Test
    fun create() {
        val inlinePreferenceSetRequest =
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
                                                        "argument" to "some_property",
                                                        "operator" to "equal_to",
                                                        "variable" to "recipient.property",
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
                    ),
                )
                .build()
    }
}
