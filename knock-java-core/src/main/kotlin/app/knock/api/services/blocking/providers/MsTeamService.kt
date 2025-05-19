// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking.providers

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.providers.msteams.MsTeamCheckAuthParams
import app.knock.api.models.providers.msteams.MsTeamCheckAuthResponse
import app.knock.api.models.providers.msteams.MsTeamListChannelsParams
import app.knock.api.models.providers.msteams.MsTeamListChannelsResponse
import app.knock.api.models.providers.msteams.MsTeamListTeamsPage
import app.knock.api.models.providers.msteams.MsTeamListTeamsParams
import app.knock.api.models.providers.msteams.MsTeamRevokeAccessParams
import app.knock.api.models.providers.msteams.MsTeamRevokeAccessResponse
import com.google.errorprone.annotations.MustBeClosed

interface MsTeamService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Check if a connection to Microsoft Teams has been authorized for a given Microsoft Teams
     * tenant object.
     */
    fun checkAuth(channelId: String, params: MsTeamCheckAuthParams): MsTeamCheckAuthResponse =
        checkAuth(channelId, params, RequestOptions.none())

    /** @see [checkAuth] */
    fun checkAuth(
        channelId: String,
        params: MsTeamCheckAuthParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MsTeamCheckAuthResponse =
        checkAuth(params.toBuilder().channelId(channelId).build(), requestOptions)

    /** @see [checkAuth] */
    fun checkAuth(params: MsTeamCheckAuthParams): MsTeamCheckAuthResponse =
        checkAuth(params, RequestOptions.none())

    /** @see [checkAuth] */
    fun checkAuth(
        params: MsTeamCheckAuthParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MsTeamCheckAuthResponse

    /**
     * List the Microsoft Teams channels within a team. By default, archived and private channels
     * are excluded from the results.
     */
    fun listChannels(
        channelId: String,
        params: MsTeamListChannelsParams,
    ): MsTeamListChannelsResponse = listChannels(channelId, params, RequestOptions.none())

    /** @see [listChannels] */
    fun listChannels(
        channelId: String,
        params: MsTeamListChannelsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MsTeamListChannelsResponse =
        listChannels(params.toBuilder().channelId(channelId).build(), requestOptions)

    /** @see [listChannels] */
    fun listChannels(params: MsTeamListChannelsParams): MsTeamListChannelsResponse =
        listChannels(params, RequestOptions.none())

    /** @see [listChannels] */
    fun listChannels(
        params: MsTeamListChannelsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MsTeamListChannelsResponse

    /**
     * Get a list of teams belonging to the Microsoft Entra tenant. By default, archived and private
     * channels are excluded from the results.
     */
    fun listTeams(channelId: String, params: MsTeamListTeamsParams): MsTeamListTeamsPage =
        listTeams(channelId, params, RequestOptions.none())

    /** @see [listTeams] */
    fun listTeams(
        channelId: String,
        params: MsTeamListTeamsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MsTeamListTeamsPage =
        listTeams(params.toBuilder().channelId(channelId).build(), requestOptions)

    /** @see [listTeams] */
    fun listTeams(params: MsTeamListTeamsParams): MsTeamListTeamsPage =
        listTeams(params, RequestOptions.none())

    /** @see [listTeams] */
    fun listTeams(
        params: MsTeamListTeamsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MsTeamListTeamsPage

    /** Remove a Microsoft Entra tenant ID from a Microsoft Teams tenant object. */
    fun revokeAccess(
        channelId: String,
        params: MsTeamRevokeAccessParams,
    ): MsTeamRevokeAccessResponse = revokeAccess(channelId, params, RequestOptions.none())

    /** @see [revokeAccess] */
    fun revokeAccess(
        channelId: String,
        params: MsTeamRevokeAccessParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MsTeamRevokeAccessResponse =
        revokeAccess(params.toBuilder().channelId(channelId).build(), requestOptions)

    /** @see [revokeAccess] */
    fun revokeAccess(params: MsTeamRevokeAccessParams): MsTeamRevokeAccessResponse =
        revokeAccess(params, RequestOptions.none())

    /** @see [revokeAccess] */
    fun revokeAccess(
        params: MsTeamRevokeAccessParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MsTeamRevokeAccessResponse

    /** A view of [MsTeamService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /v1/providers/ms-teams/{channel_id}/auth_check`, but
         * is otherwise the same as [MsTeamService.checkAuth].
         */
        @MustBeClosed
        fun checkAuth(
            channelId: String,
            params: MsTeamCheckAuthParams,
        ): HttpResponseFor<MsTeamCheckAuthResponse> =
            checkAuth(channelId, params, RequestOptions.none())

        /** @see [checkAuth] */
        @MustBeClosed
        fun checkAuth(
            channelId: String,
            params: MsTeamCheckAuthParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MsTeamCheckAuthResponse> =
            checkAuth(params.toBuilder().channelId(channelId).build(), requestOptions)

        /** @see [checkAuth] */
        @MustBeClosed
        fun checkAuth(params: MsTeamCheckAuthParams): HttpResponseFor<MsTeamCheckAuthResponse> =
            checkAuth(params, RequestOptions.none())

        /** @see [checkAuth] */
        @MustBeClosed
        fun checkAuth(
            params: MsTeamCheckAuthParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MsTeamCheckAuthResponse>

        /**
         * Returns a raw HTTP response for `get /v1/providers/ms-teams/{channel_id}/channels`, but
         * is otherwise the same as [MsTeamService.listChannels].
         */
        @MustBeClosed
        fun listChannels(
            channelId: String,
            params: MsTeamListChannelsParams,
        ): HttpResponseFor<MsTeamListChannelsResponse> =
            listChannels(channelId, params, RequestOptions.none())

        /** @see [listChannels] */
        @MustBeClosed
        fun listChannels(
            channelId: String,
            params: MsTeamListChannelsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MsTeamListChannelsResponse> =
            listChannels(params.toBuilder().channelId(channelId).build(), requestOptions)

        /** @see [listChannels] */
        @MustBeClosed
        fun listChannels(
            params: MsTeamListChannelsParams
        ): HttpResponseFor<MsTeamListChannelsResponse> = listChannels(params, RequestOptions.none())

        /** @see [listChannels] */
        @MustBeClosed
        fun listChannels(
            params: MsTeamListChannelsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MsTeamListChannelsResponse>

        /**
         * Returns a raw HTTP response for `get /v1/providers/ms-teams/{channel_id}/teams`, but is
         * otherwise the same as [MsTeamService.listTeams].
         */
        @MustBeClosed
        fun listTeams(
            channelId: String,
            params: MsTeamListTeamsParams,
        ): HttpResponseFor<MsTeamListTeamsPage> =
            listTeams(channelId, params, RequestOptions.none())

        /** @see [listTeams] */
        @MustBeClosed
        fun listTeams(
            channelId: String,
            params: MsTeamListTeamsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MsTeamListTeamsPage> =
            listTeams(params.toBuilder().channelId(channelId).build(), requestOptions)

        /** @see [listTeams] */
        @MustBeClosed
        fun listTeams(params: MsTeamListTeamsParams): HttpResponseFor<MsTeamListTeamsPage> =
            listTeams(params, RequestOptions.none())

        /** @see [listTeams] */
        @MustBeClosed
        fun listTeams(
            params: MsTeamListTeamsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MsTeamListTeamsPage>

        /**
         * Returns a raw HTTP response for `put /v1/providers/ms-teams/{channel_id}/revoke_access`,
         * but is otherwise the same as [MsTeamService.revokeAccess].
         */
        @MustBeClosed
        fun revokeAccess(
            channelId: String,
            params: MsTeamRevokeAccessParams,
        ): HttpResponseFor<MsTeamRevokeAccessResponse> =
            revokeAccess(channelId, params, RequestOptions.none())

        /** @see [revokeAccess] */
        @MustBeClosed
        fun revokeAccess(
            channelId: String,
            params: MsTeamRevokeAccessParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MsTeamRevokeAccessResponse> =
            revokeAccess(params.toBuilder().channelId(channelId).build(), requestOptions)

        /** @see [revokeAccess] */
        @MustBeClosed
        fun revokeAccess(
            params: MsTeamRevokeAccessParams
        ): HttpResponseFor<MsTeamRevokeAccessResponse> = revokeAccess(params, RequestOptions.none())

        /** @see [revokeAccess] */
        @MustBeClosed
        fun revokeAccess(
            params: MsTeamRevokeAccessParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MsTeamRevokeAccessResponse>
    }
}
