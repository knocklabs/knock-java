// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.audiences

import app.knock.api.core.jsonMapper
import app.knock.api.models.shared.PageInfo
import app.knock.api.models.users.User
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AudienceListMembersResponseTest {

    @Test
    fun create() {
        val audienceListMembersResponse =
            AudienceListMembersResponse.builder()
                .addEntry(
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
                )
                .pageInfo(
                    PageInfo.builder()
                        ._typename("PageInfo")
                        .pageSize(25L)
                        .after(null)
                        .before(null)
                        .build()
                )
                .build()

        assertThat(audienceListMembersResponse.entries())
            .containsExactly(
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
            )
        assertThat(audienceListMembersResponse.pageInfo())
            .isEqualTo(
                PageInfo.builder()
                    ._typename("PageInfo")
                    .pageSize(25L)
                    .after(null)
                    .before(null)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val audienceListMembersResponse =
            AudienceListMembersResponse.builder()
                .addEntry(
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
                )
                .pageInfo(
                    PageInfo.builder()
                        ._typename("PageInfo")
                        .pageSize(25L)
                        .after(null)
                        .before(null)
                        .build()
                )
                .build()

        val roundtrippedAudienceListMembersResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(audienceListMembersResponse),
                jacksonTypeRef<AudienceListMembersResponse>(),
            )

        assertThat(roundtrippedAudienceListMembersResponse).isEqualTo(audienceListMembersResponse)
    }
}
