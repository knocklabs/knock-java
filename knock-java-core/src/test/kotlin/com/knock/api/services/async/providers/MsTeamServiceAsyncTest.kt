// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.async.providers

import com.knock.api.TestServerExtension
import com.knock.api.client.okhttp.KnockOkHttpClientAsync
import com.knock.api.models.ProviderMsTeamCheckAuthParams
import com.knock.api.models.ProviderMsTeamListChannelsParams
import com.knock.api.models.ProviderMsTeamListTeamsParams
import com.knock.api.models.ProviderMsTeamRevokeAccessParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class MsTeamServiceAsyncTest {

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun checkAuth() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val msTeamServiceAsync = client.providers().msTeams()

        val responseFuture =
            msTeamServiceAsync.checkAuth(
                ProviderMsTeamCheckAuthParams.builder()
                    .channelId("channel_id")
                    .msTeamsTenantObject("ms_teams_tenant_object")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun listChannels() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val msTeamServiceAsync = client.providers().msTeams()

        val responseFuture =
            msTeamServiceAsync.listChannels(
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

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun listTeams() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val msTeamServiceAsync = client.providers().msTeams()

        val responseFuture =
            msTeamServiceAsync.listTeams(
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

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun revokeAccess() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val msTeamServiceAsync = client.providers().msTeams()

        val responseFuture =
            msTeamServiceAsync.revokeAccess(
                ProviderMsTeamRevokeAccessParams.builder()
                    .channelId("channel_id")
                    .msTeamsTenantObject("ms_teams_tenant_object")
                    .build()
            )

        val response = responseFuture.get()
    }
}
