// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async.providers

import app.knock.api.TestServerExtension
import app.knock.api.client.okhttp.KnockOkHttpClientAsync
import app.knock.api.models.providers.msteams.MsTeamCheckAuthParams
import app.knock.api.models.providers.msteams.MsTeamListChannelsParams
import app.knock.api.models.providers.msteams.MsTeamListTeamsParams
import app.knock.api.models.providers.msteams.MsTeamRevokeAccessParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class MsTeamServiceAsyncTest {

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun checkAuth() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val msTeamServiceAsync = client.providers().msTeams()

        val responseFuture =
            msTeamServiceAsync.checkAuth(
                MsTeamCheckAuthParams.builder()
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
                .apiKey("My API Key")
                .build()
        val msTeamServiceAsync = client.providers().msTeams()

        val responseFuture =
            msTeamServiceAsync.listChannels(
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
                .apiKey("My API Key")
                .build()
        val msTeamServiceAsync = client.providers().msTeams()

        val pageFuture =
            msTeamServiceAsync.listTeams(
                MsTeamListTeamsParams.builder()
                    .channelId("channel_id")
                    .msTeamsTenantObject("ms_teams_tenant_object")
                    .build()
            )

        val page = pageFuture.get()
        page.response().validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun revokeAccess() {
        val client =
            KnockOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val msTeamServiceAsync = client.providers().msTeams()

        val responseFuture =
            msTeamServiceAsync.revokeAccess(
                MsTeamRevokeAccessParams.builder()
                    .channelId("channel_id")
                    .msTeamsTenantObject("ms_teams_tenant_object")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
