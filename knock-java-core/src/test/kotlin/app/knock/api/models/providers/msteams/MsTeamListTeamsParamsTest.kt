// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.providers.msteams

import app.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MsTeamListTeamsParamsTest {

    @Test
    fun create() {
        MsTeamListTeamsParams.builder()
            .channelId("channel_id")
            .msTeamsTenantObject("ms_teams_tenant_object")
            .queryOptions(
                MsTeamListTeamsParams.QueryOptions.builder()
                    .filter("\$filter")
                    .select("\$select")
                    .skiptoken("\$skiptoken")
                    .top(0L)
                    .build()
            )
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            MsTeamListTeamsParams.builder()
                .channelId("channel_id")
                .msTeamsTenantObject("ms_teams_tenant_object")
                .queryOptions(
                    MsTeamListTeamsParams.QueryOptions.builder()
                        .filter("\$filter")
                        .select("\$select")
                        .skiptoken("\$skiptoken")
                        .top(0L)
                        .build()
                )
                .build()
        val expected = QueryParams.builder()
        expected.put("ms_teams_tenant_object", "ms_teams_tenant_object")
        MsTeamListTeamsParams.QueryOptions.builder()
            .filter("\$filter")
            .select("\$select")
            .skiptoken("\$skiptoken")
            .top(0L)
            .build()
            .forEachQueryParam { key, values -> expected.put("query_options[$key]", values) }
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            MsTeamListTeamsParams.builder()
                .channelId("channel_id")
                .msTeamsTenantObject("ms_teams_tenant_object")
                .build()
        val expected = QueryParams.builder()
        expected.put("ms_teams_tenant_object", "ms_teams_tenant_object")
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun getPathParam() {
        val params =
            MsTeamListTeamsParams.builder()
                .channelId("channel_id")
                .msTeamsTenantObject("ms_teams_tenant_object")
                .build()
        assertThat(params).isNotNull
        // path param "channelId"
        assertThat(params.getPathParam(0)).isEqualTo("channel_id")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
