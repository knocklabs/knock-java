// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import com.knock.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ProviderMsTeamRevokeAccessParamsTest {

    @Test
    fun create() {
        ProviderMsTeamRevokeAccessParams.builder()
            .channelId("channel_id")
            .msTeamsTenantObject("ms_teams_tenant_object")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            ProviderMsTeamRevokeAccessParams.builder()
                .channelId("channel_id")
                .msTeamsTenantObject("ms_teams_tenant_object")
                .build()
        val expected = QueryParams.builder()
        expected.put("ms_teams_tenant_object", "ms_teams_tenant_object")
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            ProviderMsTeamRevokeAccessParams.builder()
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
            ProviderMsTeamRevokeAccessParams.builder()
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
