// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.providers.slack

import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SlackListChannelsResponseTest {

    @Test
    fun create() {
        val slackListChannelsResponse =
            SlackListChannelsResponse.builder()
                .nextCursor(null)
                .addSlackChannel(
                    SlackListChannelsResponse.SlackChannel.builder()
                        .id("C01234567890")
                        .contextTeamId("T01234567890")
                        .isIm(false)
                        .isPrivate(false)
                        .name("general")
                        .build()
                )
                .build()

        assertThat(slackListChannelsResponse.nextCursor()).isEmpty
        assertThat(slackListChannelsResponse.slackChannels())
            .containsExactly(
                SlackListChannelsResponse.SlackChannel.builder()
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
        val slackListChannelsResponse =
            SlackListChannelsResponse.builder()
                .nextCursor(null)
                .addSlackChannel(
                    SlackListChannelsResponse.SlackChannel.builder()
                        .id("C01234567890")
                        .contextTeamId("T01234567890")
                        .isIm(false)
                        .isPrivate(false)
                        .name("general")
                        .build()
                )
                .build()

        val roundtrippedSlackListChannelsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(slackListChannelsResponse),
                jacksonTypeRef<SlackListChannelsResponse>(),
            )

        assertThat(roundtrippedSlackListChannelsResponse).isEqualTo(slackListChannelsResponse)
    }
}
