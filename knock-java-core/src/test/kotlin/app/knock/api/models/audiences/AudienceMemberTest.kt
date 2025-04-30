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
                .addedAt(OffsetDateTime.parse("1993-06-10T14:30:00Z"))
                .user(
                    User.builder()
                        .id("dr_grant")
                        ._typename("User")
                        .updatedAt(OffsetDateTime.parse("1993-06-09T08:15:00Z"))
                        .avatar("avatar")
                        .createdAt(null)
                        .email("alan.grant@dig.site.mt")
                        .name("Dr. Alan Grant")
                        .phoneNumber("phone_number")
                        .timezone("timezone")
                        .build()
                )
                .userId("dr_grant")
                .tenant("ingen_isla_nublar")
                .build()

        assertThat(audienceMember._typename()).isEqualTo("AudienceMember")
        assertThat(audienceMember.addedAt()).isEqualTo(OffsetDateTime.parse("1993-06-10T14:30:00Z"))
        assertThat(audienceMember.user())
            .isEqualTo(
                User.builder()
                    .id("dr_grant")
                    ._typename("User")
                    .updatedAt(OffsetDateTime.parse("1993-06-09T08:15:00Z"))
                    .avatar("avatar")
                    .createdAt(null)
                    .email("alan.grant@dig.site.mt")
                    .name("Dr. Alan Grant")
                    .phoneNumber("phone_number")
                    .timezone("timezone")
                    .build()
            )
        assertThat(audienceMember.userId()).isEqualTo("dr_grant")
        assertThat(audienceMember.tenant()).contains("ingen_isla_nublar")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val audienceMember =
            AudienceMember.builder()
                ._typename("AudienceMember")
                .addedAt(OffsetDateTime.parse("1993-06-10T14:30:00Z"))
                .user(
                    User.builder()
                        .id("dr_grant")
                        ._typename("User")
                        .updatedAt(OffsetDateTime.parse("1993-06-09T08:15:00Z"))
                        .avatar("avatar")
                        .createdAt(null)
                        .email("alan.grant@dig.site.mt")
                        .name("Dr. Alan Grant")
                        .phoneNumber("phone_number")
                        .timezone("timezone")
                        .build()
                )
                .userId("dr_grant")
                .tenant("ingen_isla_nublar")
                .build()

        val roundtrippedAudienceMember =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(audienceMember),
                jacksonTypeRef<AudienceMember>(),
            )

        assertThat(roundtrippedAudienceMember).isEqualTo(audienceMember)
    }
}
