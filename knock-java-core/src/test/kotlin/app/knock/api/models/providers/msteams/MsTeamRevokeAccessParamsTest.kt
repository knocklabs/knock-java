// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.providers.msteams

import app.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MsTeamRevokeAccessParamsTest {

    @Test
    fun create() {
        MsTeamRevokeAccessParams.builder()
            .channelId("channel_id")
            .msTeamsTenantObject("ms_teams_tenant_object")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            MsTeamRevokeAccessParams.builder()
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

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            MsTeamRevokeAccessParams.builder()
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

    @Test
    fun getPathParam() {
        val params =
            MsTeamRevokeAccessParams.builder()
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
