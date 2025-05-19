// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.audiences

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AudienceAddMembersParamsTest {

    @Test
    fun create() {
        AudienceAddMembersParams.builder()
            .key("key")
            .addMember(
                AudienceAddMembersParams.Member.builder()
                    .user(AudienceAddMembersParams.Member.User.builder().id("dr_sattler").build())
                    .tenant("ingen_isla_nublar")
                    .build()
            )
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            AudienceAddMembersParams.builder()
                .key("key")
                .addMember(
                    AudienceAddMembersParams.Member.builder()
                        .user(AudienceAddMembersParams.Member.User.builder().build())
                        .build()
                )
                .build()

        assertThat(params._pathParam(0)).isEqualTo("key")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            AudienceAddMembersParams.builder()
                .key("key")
                .addMember(
                    AudienceAddMembersParams.Member.builder()
                        .user(
                            AudienceAddMembersParams.Member.User.builder().id("dr_sattler").build()
                        )
                        .tenant("ingen_isla_nublar")
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.members())
            .containsExactly(
                AudienceAddMembersParams.Member.builder()
                    .user(AudienceAddMembersParams.Member.User.builder().id("dr_sattler").build())
                    .tenant("ingen_isla_nublar")
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            AudienceAddMembersParams.builder()
                .key("key")
                .addMember(
                    AudienceAddMembersParams.Member.builder()
                        .user(AudienceAddMembersParams.Member.User.builder().build())
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.members())
            .containsExactly(
                AudienceAddMembersParams.Member.builder()
                    .user(AudienceAddMembersParams.Member.User.builder().build())
                    .build()
            )
    }
}
