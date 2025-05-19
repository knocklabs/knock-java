// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.audiences

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AudienceRemoveMembersParamsTest {

    @Test
    fun create() {
        AudienceRemoveMembersParams.builder()
            .key("key")
            .addMember(
                AudienceRemoveMembersParams.Member.builder()
                    .user(
                        AudienceRemoveMembersParams.Member.User.builder().id("dr_sattler").build()
                    )
                    .tenant("ingen_isla_nublar")
                    .build()
            )
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            AudienceRemoveMembersParams.builder()
                .key("key")
                .addMember(
                    AudienceRemoveMembersParams.Member.builder()
                        .user(AudienceRemoveMembersParams.Member.User.builder().build())
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
            AudienceRemoveMembersParams.builder()
                .key("key")
                .addMember(
                    AudienceRemoveMembersParams.Member.builder()
                        .user(
                            AudienceRemoveMembersParams.Member.User.builder()
                                .id("dr_sattler")
                                .build()
                        )
                        .tenant("ingen_isla_nublar")
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.members())
            .containsExactly(
                AudienceRemoveMembersParams.Member.builder()
                    .user(
                        AudienceRemoveMembersParams.Member.User.builder().id("dr_sattler").build()
                    )
                    .tenant("ingen_isla_nublar")
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            AudienceRemoveMembersParams.builder()
                .key("key")
                .addMember(
                    AudienceRemoveMembersParams.Member.builder()
                        .user(AudienceRemoveMembersParams.Member.User.builder().build())
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.members())
            .containsExactly(
                AudienceRemoveMembersParams.Member.builder()
                    .user(AudienceRemoveMembersParams.Member.User.builder().build())
                    .build()
            )
    }
}
