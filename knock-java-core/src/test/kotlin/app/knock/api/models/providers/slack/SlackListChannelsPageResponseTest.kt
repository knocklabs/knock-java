// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.providers.slack

import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SlackListChannelsPageResponseTest {

    @Test
    fun create() {
        val slackListChannelsPageResponse =
            SlackListChannelsPageResponse.builder()
                .nextCursor(null)
                .addSlackChannel(
                    SlackListChannelsResponse.builder()
                        .id("C01234567890")
                        .contextTeamId("T01234567890")
                        .isIm(false)
                        .isPrivate(false)
                        .name("general")
                        .build()
                )
                .build()

        assertThat(slackListChannelsPageResponse.nextCursor()).isEmpty
        assertThat(slackListChannelsPageResponse.slackChannels())
            .containsExactly(
                SlackListChannelsResponse.builder()
                    .id("C01234567890")
                    .contextTeamId("T01234567890")
                    .isIm(false)
                    .isPrivate(false)
                    .name("general")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val slackListChannelsPageResponse =
            SlackListChannelsPageResponse.builder()
                .nextCursor(null)
                .addSlackChannel(
                    SlackListChannelsResponse.builder()
                        .id("C01234567890")
                        .contextTeamId("T01234567890")
                        .isIm(false)
                        .isPrivate(false)
                        .name("general")
                        .build()
                )
                .build()

        val roundtrippedSlackListChannelsPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(slackListChannelsPageResponse),
                jacksonTypeRef<SlackListChannelsPageResponse>(),
            )

        assertThat(roundtrippedSlackListChannelsPageResponse)
            .isEqualTo(slackListChannelsPageResponse)
    }
}
