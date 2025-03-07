// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.blocking.providers

import com.knock.api.TestServerExtension
import com.knock.api.client.okhttp.KnockOkHttpClient
import com.knock.api.models.ProviderMsTeamCheckAuthParams
import com.knock.api.models.ProviderMsTeamListChannelsParams
import com.knock.api.models.ProviderMsTeamListTeamsParams
import com.knock.api.models.ProviderMsTeamRevokeAccessParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class MsTeamServiceTest {

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun checkAuth() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val msTeamService = client.providers().msTeams()

        val response =
            msTeamService.checkAuth(
                ProviderMsTeamCheckAuthParams.builder()
                    .channelId("channel_id")
                    .msTeamsTenantObject("ms_teams_tenant_object")
                    .build()
            )

        response.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun listChannels() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val msTeamService = client.providers().msTeams()

        val response =
            msTeamService.listChannels(
                ProviderMsTeamListChannelsParams.builder()
                    .channelId("channel_id")
                    .msTeamsTenantObject("ms_teams_tenant_object")
                    .teamId("team_id")
                    .queryOptions(
                        ProviderMsTeamListChannelsParams.QueryOptions.builder()
                            .filter("\$filter")
                            .select("\$select")
                            .build()
                    )
                    .build()
            )

        response.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun listTeams() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val msTeamService = client.providers().msTeams()

        val response =
            msTeamService.listTeams(
                ProviderMsTeamListTeamsParams.builder()
                    .channelId("channel_id")
                    .msTeamsTenantObject("ms_teams_tenant_object")
                    .queryOptions(
                        ProviderMsTeamListTeamsParams.QueryOptions.builder()
                            .filter("\$filter")
                            .select("\$select")
                            .skiptoken("\$skiptoken")
                            .top(0L)
                            .build()
                    )
                    .build()
            )

        response.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun revokeAccess() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val msTeamService = client.providers().msTeams()

        msTeamService.revokeAccess(
            ProviderMsTeamRevokeAccessParams.builder()
                .channelId("channel_id")
                .msTeamsTenantObject("ms_teams_tenant_object")
                .build()
        )
    }
}
