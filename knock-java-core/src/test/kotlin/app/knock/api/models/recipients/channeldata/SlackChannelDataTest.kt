// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.recipients.channeldata

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SlackChannelDataTest {

    @Test
    fun createSlackChannelData() {
        val slackChannelData =
            SlackChannelData.builder()
                .addConnection(
                    SlackChannelData.Connection.SlackTokenConnection.builder()
                        .accessToken("xoxb-1234567890")
                        .channelId("C01234567890")
                        .userId("U01234567890")
                        .build()
                )
                .token(SlackChannelData.Token.builder().accessToken("xoxb-1234567890").build())
                .build()
        assertThat(slackChannelData).isNotNull
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
}
