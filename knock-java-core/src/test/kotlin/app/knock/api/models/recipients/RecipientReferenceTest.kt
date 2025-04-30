// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.recipients

import app.knock.api.core.JsonValue
import app.knock.api.core.jsonMapper
import app.knock.api.errors.KnockInvalidDataException
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class RecipientReferenceTest {

    @Test
    fun ofUser() {
        val user = "user_123"

        val recipientReference = RecipientReference.ofUser(user)

        assertThat(recipientReference.user()).contains(user)
        assertThat(recipientReference.objectReference()).isEmpty
    }

    @Test
    fun ofUserRoundtrip() {
        val jsonMapper = jsonMapper()
        val recipientReference = RecipientReference.ofUser("user_123")

        val roundtrippedRecipientReference =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(recipientReference),
                jacksonTypeRef<RecipientReference>(),
            )

        assertThat(roundtrippedRecipientReference).isEqualTo(recipientReference)
    }

    @Test
    fun ofObjectReference() {
        val objectReference =
            RecipientReference.ObjectReference.builder()
                .id("project_123")
                .collection("projects")
                .build()

        val recipientReference = RecipientReference.ofObjectReference(objectReference)

        assertThat(recipientReference.user()).isEmpty
        assertThat(recipientReference.objectReference()).contains(objectReference)
    }

    @Test
    fun ofObjectReferenceRoundtrip() {
        val jsonMapper = jsonMapper()
        val recipientReference =
            RecipientReference.ofObjectReference(
                RecipientReference.ObjectReference.builder()
                    .id("project_123")
                    .collection("projects")
                    .build()
            )

        val roundtrippedRecipientReference =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(recipientReference),
                jacksonTypeRef<RecipientReference>(),
            )

        assertThat(roundtrippedRecipientReference).isEqualTo(recipientReference)
    }

    @Test
    fun incompatibleJsonShapeDeserializesToUnknown() {
        val value = JsonValue.from(listOf("invalid", "array"))
        val recipientReference =
            jsonMapper().convertValue(value, jacksonTypeRef<RecipientReference>())

        val e = assertThrows<KnockInvalidDataException> { recipientReference.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
