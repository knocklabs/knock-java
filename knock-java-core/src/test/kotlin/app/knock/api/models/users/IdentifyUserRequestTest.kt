// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.core.JsonValue
import app.knock.api.core.jsonMapper
import app.knock.api.models.recipients.channeldata.InlineChannelDataRequest
import app.knock.api.models.recipients.preferences.InlinePreferenceSetRequest
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class IdentifyUserRequestTest {

    @Test
    fun create() {
        val identifyUserRequest =
            IdentifyUserRequest.builder()
                .avatar("avatar")
                .channelData(
                    InlineChannelDataRequest.builder()
                        .putAdditionalProperty(
                            "97c5837d-c65c-4d54-aa39-080eeb81c69d",
                            JsonValue.from(mapOf("tokens" to listOf("push_token_123"))),
                        )
                        .build()
                )
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .email("ian.malcolm@chaos.theory")
                .locale("locale")
                .name("Dr. Ian Malcolm")
                .phoneNumber("phone_number")
                .preferences(
                    InlinePreferenceSetRequest.builder()
                        .putAdditionalProperty(
                            "default",
                            JsonValue.from(
                                mapOf(
                                    "categories" to
                                        mapOf(
                                            "marketing" to
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
                                            "transactional" to true,
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
                                                                "argument" to "frog_genome",
                                                                "operator" to "contains",
                                                                "variable" to
                                                                    "specimen.dna_sequence",
                                                            )
                                                        ),
                                                )
                                        ),
                                )
                            ),
                        )
                        .build()
                )
                .timezone("America/New_York")
                .build()

        assertThat(identifyUserRequest.avatar()).contains("avatar")
        assertThat(identifyUserRequest.channelData())
            .contains(
                InlineChannelDataRequest.builder()
                    .putAdditionalProperty(
                        "97c5837d-c65c-4d54-aa39-080eeb81c69d",
                        JsonValue.from(mapOf("tokens" to listOf("push_token_123"))),
                    )
                    .build()
            )
        assertThat(identifyUserRequest.createdAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(identifyUserRequest.email()).contains("ian.malcolm@chaos.theory")
        assertThat(identifyUserRequest.locale()).contains("locale")
        assertThat(identifyUserRequest.name()).contains("Dr. Ian Malcolm")
        assertThat(identifyUserRequest.phoneNumber()).contains("phone_number")
        assertThat(identifyUserRequest.preferences())
            .contains(
                InlinePreferenceSetRequest.builder()
                    .putAdditionalProperty(
                        "default",
                        JsonValue.from(
                            mapOf(
                                "categories" to
                                    mapOf(
                                        "marketing" to
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
                                            ),
                                        "transactional" to true,
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
                                                            "argument" to "frog_genome",
                                                            "operator" to "contains",
                                                            "variable" to "specimen.dna_sequence",
                                                        )
                                                    ),
                                            )
                                    ),
                            )
                        ),
                    )
                    .build()
            )
        assertThat(identifyUserRequest.timezone()).contains("America/New_York")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val identifyUserRequest =
            IdentifyUserRequest.builder()
                .avatar("avatar")
                .channelData(
                    InlineChannelDataRequest.builder()
                        .putAdditionalProperty(
                            "97c5837d-c65c-4d54-aa39-080eeb81c69d",
                            JsonValue.from(mapOf("tokens" to listOf("push_token_123"))),
                        )
                        .build()
                )
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .email("ian.malcolm@chaos.theory")
                .locale("locale")
                .name("Dr. Ian Malcolm")
                .phoneNumber("phone_number")
                .preferences(
                    InlinePreferenceSetRequest.builder()
                        .putAdditionalProperty(
                            "default",
                            JsonValue.from(
                                mapOf(
                                    "categories" to
                                        mapOf(
                                            "marketing" to
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
                                            "transactional" to true,
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
                                                                "argument" to "frog_genome",
                                                                "operator" to "contains",
                                                                "variable" to
                                                                    "specimen.dna_sequence",
                                                            )
                                                        ),
                                                )
                                        ),
                                )
                            ),
                        )
                        .build()
                )
                .timezone("America/New_York")
                .build()

        val roundtrippedIdentifyUserRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(identifyUserRequest),
                jacksonTypeRef<IdentifyUserRequest>(),
            )

        assertThat(roundtrippedIdentifyUserRequest).isEqualTo(identifyUserRequest)
    }
}
