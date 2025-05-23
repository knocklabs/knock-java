// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.providers.msteams

import app.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MsTeamListChannelsParamsTest {

    @Test
    fun create() {
        MsTeamListChannelsParams.builder()
            .channelId("channel_id")
            .msTeamsTenantObject("ms_teams_tenant_object")
            .teamId("team_id")
            .queryOptions(
                MsTeamListChannelsParams.QueryOptions.builder()
                    .filter("\$filter")
                    .select("\$select")
                    .build()
            )
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            MsTeamListChannelsParams.builder()
                .channelId("channel_id")
                .msTeamsTenantObject("ms_teams_tenant_object")
                .teamId("team_id")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("channel_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            MsTeamListChannelsParams.builder()
                .channelId("channel_id")
                .msTeamsTenantObject("ms_teams_tenant_object")
                .teamId("team_id")
                .queryOptions(
                    MsTeamListChannelsParams.QueryOptions.builder()
                        .filter("\$filter")
                        .select("\$select")
                        .build()
                )
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("ms_teams_tenant_object", "ms_teams_tenant_object")
                    .put("team_id", "team_id")
                    .put("query_options[\$filter]", "\$filter")
                    .put("query_options[\$select]", "\$select")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            MsTeamListChannelsParams.builder()
                .channelId("channel_id")
                .msTeamsTenantObject("ms_teams_tenant_object")
                .teamId("team_id")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("ms_teams_tenant_object", "ms_teams_tenant_object")
                    .put("team_id", "team_id")
                    .build()
            )
    }
}
