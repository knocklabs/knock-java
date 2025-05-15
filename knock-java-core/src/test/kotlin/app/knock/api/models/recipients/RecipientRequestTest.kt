// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.recipients

import app.knock.api.core.JsonValue
import app.knock.api.core.jsonMapper
import app.knock.api.errors.KnockInvalidDataException
import app.knock.api.models.objects.InlineObjectRequest
import app.knock.api.models.recipients.channeldata.InlineChannelDataRequest
import app.knock.api.models.recipients.preferences.InlinePreferenceSetRequest
import app.knock.api.models.users.InlineIdentifyUserRequest
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class RecipientRequestTest {

    @Test
    fun ofUserRecipient() {
        val userRecipient = "user_123"

        val recipientRequest = RecipientRequest.ofUserRecipient(userRecipient)

        assertThat(recipientRequest.userRecipient()).contains(userRecipient)
        assertThat(recipientRequest.inlineIdentifyUser()).isEmpty
        assertThat(recipientRequest.inlineObject()).isEmpty
    }

    @Test
    fun ofUserRecipientRoundtrip() {
        val jsonMapper = jsonMapper()
        val recipientRequest = RecipientRequest.ofUserRecipient("user_123")

        val roundtrippedRecipientRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(recipientRequest),
                jacksonTypeRef<RecipientRequest>(),
            )

        assertThat(roundtrippedRecipientRequest).isEqualTo(recipientRequest)
    }

    @Test
    fun ofInlineIdentifyUser() {
        val inlineIdentifyUser =
            InlineIdentifyUserRequest.builder()
                .id("user_1")
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
                .email("jane@ingen.net")
                .locale("locale")
                .name("Jane Doe")
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

        val recipientRequest = RecipientRequest.ofInlineIdentifyUser(inlineIdentifyUser)

        assertThat(recipientRequest.userRecipient()).isEmpty
        assertThat(recipientRequest.inlineIdentifyUser()).contains(inlineIdentifyUser)
        assertThat(recipientRequest.inlineObject()).isEmpty
    }

    @Test
    fun ofInlineIdentifyUserRoundtrip() {
        val jsonMapper = jsonMapper()
        val recipientRequest =
            RecipientRequest.ofInlineIdentifyUser(
                InlineIdentifyUserRequest.builder()
                    .id("user_1")
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
                    .email("jane@ingen.net")
                    .locale("locale")
                    .name("Jane Doe")
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
            )

        val roundtrippedRecipientRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(recipientRequest),
                jacksonTypeRef<RecipientRequest>(),
            )

        assertThat(roundtrippedRecipientRequest).isEqualTo(recipientRequest)
    }

    @Test
    fun ofInlineObject() {
        val inlineObject =
            InlineObjectRequest.builder()
                .id("project_1")
                .collection("projects")
                .channelData(
                    InlineChannelDataRequest.builder()
                        .putAdditionalProperty(
                            "97c5837d-c65c-4d54-aa39-080eeb81c69d",
                            JsonValue.from(mapOf("tokens" to listOf("push_token_xxx"))),
                        )
                        .build()
                )
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
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
                .build()

        val recipientRequest = RecipientRequest.ofInlineObject(inlineObject)

        assertThat(recipientRequest.userRecipient()).isEmpty
        assertThat(recipientRequest.inlineIdentifyUser()).isEmpty
        assertThat(recipientRequest.inlineObject()).contains(inlineObject)
    }

    @Test
    fun ofInlineObjectRoundtrip() {
        val jsonMapper = jsonMapper()
        val recipientRequest =
            RecipientRequest.ofInlineObject(
                InlineObjectRequest.builder()
                    .id("project_1")
                    .collection("projects")
                    .channelData(
                        InlineChannelDataRequest.builder()
                            .putAdditionalProperty(
                                "97c5837d-c65c-4d54-aa39-080eeb81c69d",
                                JsonValue.from(mapOf("tokens" to listOf("push_token_xxx"))),
                            )
                            .build()
                    )
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
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
                    .build()
            )

        val roundtrippedRecipientRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(recipientRequest),
                jacksonTypeRef<RecipientRequest>(),
            )

        assertThat(roundtrippedRecipientRequest).isEqualTo(recipientRequest)
    }

    @Test
    fun incompatibleJsonShapeDeserializesToUnknown() {
        val value = JsonValue.from(listOf("invalid", "array"))
        val recipientRequest = jsonMapper().convertValue(value, jacksonTypeRef<RecipientRequest>())

        val e = assertThrows<KnockInvalidDataException> { recipientRequest.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
