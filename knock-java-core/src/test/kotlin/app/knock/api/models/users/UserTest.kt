// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserTest {

    @Test
    fun create() {
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

        assertThat(user.id()).isEqualTo("jane")
        assertThat(user._typename()).isEqualTo("User")
        assertThat(user.updatedAt()).isEqualTo(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
        assertThat(user.avatar()).contains("avatar")
        assertThat(user.createdAt()).isEmpty
        assertThat(user.email()).contains("jane@ingen.net")
        assertThat(user.name()).contains("Jane Doe")
        assertThat(user.phoneNumber()).contains("phone_number")
        assertThat(user.timezone()).contains("timezone")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
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

        val roundtrippedUser =
            jsonMapper.readValue(jsonMapper.writeValueAsString(user), jacksonTypeRef<User>())

        assertThat(roundtrippedUser).isEqualTo(user)
    }
}
