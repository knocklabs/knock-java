// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.recipients.channeldata

import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SlackChannelDataTest {

    @Test
    fun create() {
        val slackChannelData =
            SlackChannelData.builder()
                ._typename(SlackChannelData._Typename.SLACK_CHANNEL_DATA)
                .addConnection(
                    SlackChannelData.Connection.SlackTokenConnection.builder()
                        .accessToken("xoxb-1234567890")
                        .channelId("C01234567890")
                        .userId("U01234567890")
                        .build()
                )
                .token(SlackChannelData.Token.builder().accessToken("xoxb-1234567890").build())
                .build()

        assertThat(slackChannelData._typename())
            .isEqualTo(SlackChannelData._Typename.SLACK_CHANNEL_DATA)
        assertThat(slackChannelData.connections())
            .containsExactly(
                SlackChannelData.Connection.ofSlackToken(
                    SlackChannelData.Connection.SlackTokenConnection.builder()
                        .accessToken("xoxb-1234567890")
                        .channelId("C01234567890")
                        .userId("U01234567890")
                        .build()
                )
            )
        assertThat(slackChannelData.token())
            .contains(SlackChannelData.Token.builder().accessToken("xoxb-1234567890").build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val slackChannelData =
            SlackChannelData.builder()
                ._typename(SlackChannelData._Typename.SLACK_CHANNEL_DATA)
                .addConnection(
                    SlackChannelData.Connection.SlackTokenConnection.builder()
                        .accessToken("xoxb-1234567890")
                        .channelId("C01234567890")
                        .userId("U01234567890")
                        .build()
                )
                .token(SlackChannelData.Token.builder().accessToken("xoxb-1234567890").build())
                .build()

        val roundtrippedSlackChannelData =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(slackChannelData),
                jacksonTypeRef<SlackChannelData>(),
            )

        assertThat(roundtrippedSlackChannelData).isEqualTo(slackChannelData)
    }
}
