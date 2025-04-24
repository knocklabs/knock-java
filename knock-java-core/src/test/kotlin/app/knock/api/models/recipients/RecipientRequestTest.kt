// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.recipients

import app.knock.api.core.JsonValue
import app.knock.api.core.jsonMapper
import app.knock.api.errors.KnockInvalidDataException
import app.knock.api.models.UnnamedSchemaWithArrayParent0
import app.knock.api.models.objects.InlineObjectRequest
import app.knock.api.models.recipients.channeldata.PushChannelData
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
                .addChannelData(
                    UnnamedSchemaWithArrayParent0.builder()
                        .channelId("97c5837d-c65c-4d54-aa39-080eeb81c69d")
                        .data(
                            PushChannelData.builder()
                                .addToken("push_token_123")
                                .type(PushChannelData.Type.PUSH_FCM)
                                ._typename(PushChannelData._Typename.PUSH_CHANNEL_DATA)
                                .build()
                        )
                        .provider("push_fcm")
                        .build()
                )
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .preferences(
                    JsonValue.from(
                        listOf(
                            mapOf(
                                "channel_types" to mapOf("email" to true),
                                "id" to "default",
                                "workflows" to
                                    mapOf(
                                        "dinosaurs-loose" to
                                            mapOf("channel_types" to mapOf("email" to true))
                                    ),
                            )
                        )
                    )
                )
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
                    .addChannelData(
                        UnnamedSchemaWithArrayParent0.builder()
                            .channelId("97c5837d-c65c-4d54-aa39-080eeb81c69d")
                            .data(
                                PushChannelData.builder()
                                    .addToken("push_token_123")
                                    .type(PushChannelData.Type.PUSH_FCM)
                                    ._typename(PushChannelData._Typename.PUSH_CHANNEL_DATA)
                                    .build()
                            )
                            .provider("push_fcm")
                            .build()
                    )
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .preferences(
                        JsonValue.from(
                            listOf(
                                mapOf(
                                    "channel_types" to mapOf("email" to true),
                                    "id" to "default",
                                    "workflows" to
                                        mapOf(
                                            "dinosaurs-loose" to
                                                mapOf("channel_types" to mapOf("email" to true))
                                        ),
                                )
                            )
                        )
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
    fun ofInlineObject() {
        val inlineObject =
            InlineObjectRequest.builder()
                .id("project_1")
                .collection("projects")
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
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .preferences(InlinePreferenceSetRequest.builder().build())
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
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .preferences(InlinePreferenceSetRequest.builder().build())
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
