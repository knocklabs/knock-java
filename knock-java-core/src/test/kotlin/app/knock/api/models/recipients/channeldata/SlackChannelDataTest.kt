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
                .addConnection(
                    SlackChannelData.Connection.SlackTokenConnection.builder()
                        .accessToken("xoxb-1234567890")
                        .channelId("C01234567890")
                        .userId("U01234567890")
                        .build()
                )
                .type(SlackChannelData.Type.CHAT_SLACK)
                .token(SlackChannelData.Token.builder().accessToken("xoxb-1234567890").build())
                ._typename(SlackChannelData._Typename.SLACK_CHANNEL_DATA)
                .build()

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
        assertThat(slackChannelData.type()).isEqualTo(SlackChannelData.Type.CHAT_SLACK)
        assertThat(slackChannelData.token())
            .contains(SlackChannelData.Token.builder().accessToken("xoxb-1234567890").build())
        assertThat(slackChannelData._typename())
            .contains(SlackChannelData._Typename.SLACK_CHANNEL_DATA)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val slackChannelData =
            SlackChannelData.builder()
                .addConnection(
                    SlackChannelData.Connection.SlackTokenConnection.builder()
                        .accessToken("xoxb-1234567890")
                        .channelId("C01234567890")
                        .userId("U01234567890")
                        .build()
                )
                .type(SlackChannelData.Type.CHAT_SLACK)
                .token(SlackChannelData.Token.builder().accessToken("xoxb-1234567890").build())
                ._typename(SlackChannelData._Typename.SLACK_CHANNEL_DATA)
                .build()

        val roundtrippedSlackChannelData =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(slackChannelData),
                jacksonTypeRef<SlackChannelData>(),
            )

        assertThat(roundtrippedSlackChannelData).isEqualTo(slackChannelData)
    }
}
