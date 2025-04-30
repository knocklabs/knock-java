// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.providers.msteams

import app.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MsTeamListTeamsParamsTest {

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
    fun pathParams() {
        val params =
            MsTeamListTeamsParams.builder()
                .channelId("channel_id")
                .msTeamsTenantObject("ms_teams_tenant_object")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("channel_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
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

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("ms_teams_tenant_object", "ms_teams_tenant_object")
                    .put("query_options[\$filter]", "\$filter")
                    .put("query_options[\$select]", "\$select")
                    .put("query_options[\$skiptoken]", "\$skiptoken")
                    .put("query_options[\$top]", "0")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            MsTeamListTeamsParams.builder()
                .channelId("channel_id")
                .msTeamsTenantObject("ms_teams_tenant_object")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("ms_teams_tenant_object", "ms_teams_tenant_object")
                    .build()
            )
    }
}
