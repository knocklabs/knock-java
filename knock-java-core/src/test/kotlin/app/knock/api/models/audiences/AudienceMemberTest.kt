// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.audiences

import app.knock.api.core.jsonMapper
import app.knock.api.models.users.User
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AudienceMemberTest {

    @Test
    fun create() {
        val audienceMember =
            AudienceMember.builder()
                ._typename("AudienceMember")
                .addedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                .user(
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
                .userId("user_123")
                .tenant("acme_corp")
                .build()

        assertThat(audienceMember._typename()).isEqualTo("AudienceMember")
        assertThat(audienceMember.addedAt()).isEqualTo(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
        assertThat(audienceMember.user())
            .isEqualTo(
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
        assertThat(audienceMember.userId()).isEqualTo("user_123")
        assertThat(audienceMember.tenant()).contains("acme_corp")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val audienceMember =
            AudienceMember.builder()
                ._typename("AudienceMember")
                .addedAt(OffsetDateTime.parse("2021-01-01T00:00:00Z"))
                .user(
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
                .userId("user_123")
                .tenant("acme_corp")
                .build()

        val roundtrippedAudienceMember =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(audienceMember),
                jacksonTypeRef<AudienceMember>(),
            )

        assertThat(roundtrippedAudienceMember).isEqualTo(audienceMember)
    }
}
