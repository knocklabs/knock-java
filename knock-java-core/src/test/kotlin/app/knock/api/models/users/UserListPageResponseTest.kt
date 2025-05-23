// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.core.jsonMapper
import app.knock.api.models.shared.PageInfo
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserListPageResponseTest {

    @Test
    fun create() {
        val userListPageResponse =
            UserListPageResponse.builder()
                .addEntry(
                    User.builder()
                        .id("user_id")
                        ._typename("User")
                        .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                        .avatar("avatar")
                        .createdAt(null)
                        .email("ian.malcolm@chaos.theory")
                        .name("Dr. Ian Malcolm")
                        .phoneNumber("phone_number")
                        .timezone("timezone")
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

        assertThat(userListPageResponse.entries().getOrNull())
            .containsExactly(
                User.builder()
                    .id("user_id")
                    ._typename("User")
                    .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                    .avatar("avatar")
                    .createdAt(null)
                    .email("ian.malcolm@chaos.theory")
                    .name("Dr. Ian Malcolm")
                    .phoneNumber("phone_number")
                    .timezone("timezone")
                    .build()
            )
        assertThat(userListPageResponse.pageInfo())
            .contains(
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
        val userListPageResponse =
            UserListPageResponse.builder()
                .addEntry(
                    User.builder()
                        .id("user_id")
                        ._typename("User")
                        .updatedAt(OffsetDateTime.parse("2024-05-22T12:00:00Z"))
                        .avatar("avatar")
                        .createdAt(null)
                        .email("ian.malcolm@chaos.theory")
                        .name("Dr. Ian Malcolm")
                        .phoneNumber("phone_number")
                        .timezone("timezone")
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

        val roundtrippedUserListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(userListPageResponse),
                jacksonTypeRef<UserListPageResponse>(),
            )

        assertThat(roundtrippedUserListPageResponse).isEqualTo(userListPageResponse)
    }
}
