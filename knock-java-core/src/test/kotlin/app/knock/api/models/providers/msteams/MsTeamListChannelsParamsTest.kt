// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.providers.msteams

import app.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MsTeamListChannelsParamsTest {

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
        val expected = QueryParams.builder()
        expected.put("ms_teams_tenant_object", "ms_teams_tenant_object")
        expected.put("team_id", "team_id")
        MsTeamListChannelsParams.QueryOptions.builder()
            .filter("\$filter")
            .select("\$select")
            .build()
            .forEachQueryParam { key, values -> expected.put("query_options[$key]", values) }
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            MsTeamListChannelsParams.builder()
                .channelId("channel_id")
                .msTeamsTenantObject("ms_teams_tenant_object")
                .teamId("team_id")
                .build()
        val expected = QueryParams.builder()
        expected.put("ms_teams_tenant_object", "ms_teams_tenant_object")
        expected.put("team_id", "team_id")
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun getPathParam() {
        val params =
            MsTeamListChannelsParams.builder()
                .channelId("channel_id")
                .msTeamsTenantObject("ms_teams_tenant_object")
                .teamId("team_id")
                .build()
        assertThat(params).isNotNull
        // path param "channelId"
        assertThat(params.getPathParam(0)).isEqualTo("channel_id")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
