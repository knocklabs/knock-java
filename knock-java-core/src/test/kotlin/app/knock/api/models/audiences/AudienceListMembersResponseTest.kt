// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.audiences

import app.knock.api.models.users.User
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
                )
                .pageInfo(
                    AudienceListMembersResponse.PageInfo.builder()
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
            )
        assertThat(audienceListMembersResponse.pageInfo())
            .isEqualTo(
                AudienceListMembersResponse.PageInfo.builder()
                    ._typename("PageInfo")
                    .pageSize(25L)
                    .after(null)
                    .before(null)
                    .build()
            )
    }
}
