// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.providers.slack

import app.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SlackListChannelsParamsTest {

    @Test
    fun create() {
        SlackListChannelsParams.builder()
            .channelId("channel_id")
            .accessTokenObject("access_token_object")
            .queryOptions(
                SlackListChannelsParams.QueryOptions.builder()
                    .cursor("cursor")
                    .excludeArchived("exclude_archived")
                    .limit("limit")
                    .teamId("team_id")
                    .types("types")
                    .build()
            )
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            SlackListChannelsParams.builder()
                .channelId("channel_id")
                .accessTokenObject("access_token_object")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("channel_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            SlackListChannelsParams.builder()
                .channelId("channel_id")
                .accessTokenObject("access_token_object")
                .queryOptions(
                    SlackListChannelsParams.QueryOptions.builder()
                        .cursor("cursor")
                        .excludeArchived("exclude_archived")
                        .limit("limit")
                        .teamId("team_id")
                        .types("types")
                        .build()
                )
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("access_token_object", "access_token_object")
                    .put("query_options[cursor]", "cursor")
                    .put("query_options[exclude_archived]", "exclude_archived")
                    .put("query_options[limit]", "limit")
                    .put("query_options[team_id]", "team_id")
                    .put("query_options[types]", "types")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            SlackListChannelsParams.builder()
                .channelId("channel_id")
                .accessTokenObject("access_token_object")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder().put("access_token_object", "access_token_object").build()
            )
    }
}
