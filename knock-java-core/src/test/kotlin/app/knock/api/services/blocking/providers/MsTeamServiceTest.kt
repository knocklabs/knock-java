// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking.providers

import app.knock.api.TestServerExtension
import app.knock.api.client.okhttp.KnockOkHttpClient
import app.knock.api.models.providers.msteams.MsTeamCheckAuthParams
import app.knock.api.models.providers.msteams.MsTeamListChannelsParams
import app.knock.api.models.providers.msteams.MsTeamListTeamsParams
import app.knock.api.models.providers.msteams.MsTeamRevokeAccessParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class MsTeamServiceTest {

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun checkAuth() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val msTeamService = client.providers().msTeams()

        val response =
            msTeamService.checkAuth(
                MsTeamCheckAuthParams.builder()
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
                .apiKey("My API Key")
                .build()
        val msTeamService = client.providers().msTeams()

        val response =
            msTeamService.listChannels(
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
                .apiKey("My API Key")
                .build()
        val msTeamService = client.providers().msTeams()

        val page =
            msTeamService.listTeams(
                MsTeamListTeamsParams.builder()
                    .channelId("channel_id")
                    .msTeamsTenantObject("ms_teams_tenant_object")
                    .build()
            )

        page.response().validate()
    }

    @Disabled(
        "skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url"
    )
    @Test
    fun revokeAccess() {
        val client =
            KnockOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val msTeamService = client.providers().msTeams()

        val response =
            msTeamService.revokeAccess(
                MsTeamRevokeAccessParams.builder()
                    .channelId("channel_id")
                    .msTeamsTenantObject("ms_teams_tenant_object")
                    .build()
            )

        response.validate()
    }
}
