// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.providers.msteams

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MsTeamListChannelsResponseTest {

    @Test
    fun create() {
        val msTeamListChannelsResponse =
            MsTeamListChannelsResponse.builder()
                .addMsTeamsChannel(
                    MsTeamListChannelsResponse.MsTeamsChannel.builder()
                        .id("channel-id-1")
                        .displayName("General")
                        .createdDateTime("createdDateTime")
                        .description("description")
                        .isArchived(true)
                        .membershipType("membershipType")
                        .build()
                )
                .build()

        assertThat(msTeamListChannelsResponse.msTeamsChannels())
            .containsExactly(
                MsTeamListChannelsResponse.MsTeamsChannel.builder()
                    .id("channel-id-1")
                    .displayName("General")
                    .createdDateTime("createdDateTime")
                    .description("description")
                    .isArchived(true)
                    .membershipType("membershipType")
                    .build()
            )
    }
}
