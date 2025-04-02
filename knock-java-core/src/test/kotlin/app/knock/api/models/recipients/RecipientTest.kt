// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.recipients

import app.knock.api.core.JsonValue
import app.knock.api.core.jsonMapper
import app.knock.api.errors.KnockInvalidDataException
import app.knock.api.models.objects.Object
import app.knock.api.models.users.User
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class RecipientTest {

    @Test
    fun ofUser() {
        val user =
            User.builder()
                .id("jane")
                ._typename("User")
                .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                .avatar("avatar")
                .createdAt(null)
                .email("jane@ingen.net")
                .name("Jane Doe")
                .phoneNumber("phone_number")
                .timezone("timezone")
                .build()

        val recipient = Recipient.ofUser(user)

        assertThat(recipient.user()).contains(user)
        assertThat(recipient.object_()).isEmpty
    }

    @Test
    fun ofUserRoundtrip() {
        val jsonMapper = jsonMapper()
        val recipient =
            Recipient.ofUser(
                User.builder()
                    .id("jane")
                    ._typename("User")
                    .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                    .avatar("avatar")
                    .createdAt(null)
                    .email("jane@ingen.net")
                    .name("Jane Doe")
                    .phoneNumber("phone_number")
                    .timezone("timezone")
                    .build()
            )

        val roundtrippedRecipient =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(recipient),
                jacksonTypeRef<Recipient>(),
            )

        assertThat(roundtrippedRecipient).isEqualTo(recipient)
    }

    @Test
    fun ofObject() {
        val object_ =
            Object.builder()
                .id("project_1")
                ._typename("Object")
                .collection("projects")
                .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                .createdAt(null)
                .build()

        val recipient = Recipient.ofObject(object_)

        assertThat(recipient.user()).isEmpty
        assertThat(recipient.object_()).contains(object_)
    }

    @Test
    fun ofObjectRoundtrip() {
        val jsonMapper = jsonMapper()
        val recipient =
            Recipient.ofObject(
                Object.builder()
                    .id("project_1")
                    ._typename("Object")
                    .collection("projects")
                    .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                    .createdAt(null)
                    .build()
            )

        val roundtrippedRecipient =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(recipient),
                jacksonTypeRef<Recipient>(),
            )

        assertThat(roundtrippedRecipient).isEqualTo(recipient)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val recipient = jsonMapper().convertValue(testCase.value, jacksonTypeRef<Recipient>())

        val e = assertThrows<KnockInvalidDataException> { recipient.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
