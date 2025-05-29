// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async.providers

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.providers.msteams.MsTeamCheckAuthParams
import app.knock.api.models.providers.msteams.MsTeamCheckAuthResponse
import app.knock.api.models.providers.msteams.MsTeamListChannelsParams
import app.knock.api.models.providers.msteams.MsTeamListChannelsResponse
import app.knock.api.models.providers.msteams.MsTeamListTeamsPageAsync
import app.knock.api.models.providers.msteams.MsTeamListTeamsParams
import app.knock.api.models.providers.msteams.MsTeamRevokeAccessParams
import app.knock.api.models.providers.msteams.MsTeamRevokeAccessResponse
import java.util.concurrent.CompletableFuture

interface MsTeamServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Check if a connection to Microsoft Teams has been authorized for a given Microsoft Teams
     * tenant object.
     */
    fun checkAuth(
        channelId: String,
        params: MsTeamCheckAuthParams,
    ): CompletableFuture<MsTeamCheckAuthResponse> =
        checkAuth(channelId, params, RequestOptions.none())

    /** @see [checkAuth] */
    fun checkAuth(
        channelId: String,
        params: MsTeamCheckAuthParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MsTeamCheckAuthResponse> =
        checkAuth(params.toBuilder().channelId(channelId).build(), requestOptions)

    /** @see [checkAuth] */
    fun checkAuth(params: MsTeamCheckAuthParams): CompletableFuture<MsTeamCheckAuthResponse> =
        checkAuth(params, RequestOptions.none())

    /** @see [checkAuth] */
    fun checkAuth(
        params: MsTeamCheckAuthParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MsTeamCheckAuthResponse>

    /**
     * List the Microsoft Teams channels within a team. By default, archived and private channels
     * are excluded from the results.
     */
    fun listChannels(
        channelId: String,
        params: MsTeamListChannelsParams,
    ): CompletableFuture<MsTeamListChannelsResponse> =
        listChannels(channelId, params, RequestOptions.none())

    /** @see [listChannels] */
    fun listChannels(
        channelId: String,
        params: MsTeamListChannelsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MsTeamListChannelsResponse> =
        listChannels(params.toBuilder().channelId(channelId).build(), requestOptions)

    /** @see [listChannels] */
    fun listChannels(
        params: MsTeamListChannelsParams
    ): CompletableFuture<MsTeamListChannelsResponse> = listChannels(params, RequestOptions.none())

    /** @see [listChannels] */
    fun listChannels(
        params: MsTeamListChannelsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MsTeamListChannelsResponse>

    /**
     * Get a list of teams belonging to the Microsoft Entra tenant. By default, archived and private
     * channels are excluded from the results.
     */
    fun listTeams(
        channelId: String,
        params: MsTeamListTeamsParams,
    ): CompletableFuture<MsTeamListTeamsPageAsync> =
        listTeams(channelId, params, RequestOptions.none())

    /** @see [listTeams] */
    fun listTeams(
        channelId: String,
        params: MsTeamListTeamsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MsTeamListTeamsPageAsync> =
        listTeams(params.toBuilder().channelId(channelId).build(), requestOptions)

    /** @see [listTeams] */
    fun listTeams(params: MsTeamListTeamsParams): CompletableFuture<MsTeamListTeamsPageAsync> =
        listTeams(params, RequestOptions.none())

    /** @see [listTeams] */
    fun listTeams(
        params: MsTeamListTeamsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MsTeamListTeamsPageAsync>

    /** Remove a Microsoft Entra tenant ID from a Microsoft Teams tenant object. */
    fun revokeAccess(
        channelId: String,
        params: MsTeamRevokeAccessParams,
    ): CompletableFuture<MsTeamRevokeAccessResponse> =
        revokeAccess(channelId, params, RequestOptions.none())

    /** @see [revokeAccess] */
    fun revokeAccess(
        channelId: String,
        params: MsTeamRevokeAccessParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MsTeamRevokeAccessResponse> =
        revokeAccess(params.toBuilder().channelId(channelId).build(), requestOptions)

    /** @see [revokeAccess] */
    fun revokeAccess(
        params: MsTeamRevokeAccessParams
    ): CompletableFuture<MsTeamRevokeAccessResponse> = revokeAccess(params, RequestOptions.none())

    /** @see [revokeAccess] */
    fun revokeAccess(
        params: MsTeamRevokeAccessParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MsTeamRevokeAccessResponse>

    /**
     * A view of [MsTeamServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /v1/providers/ms-teams/{channel_id}/auth_check`, but
         * is otherwise the same as [MsTeamServiceAsync.checkAuth].
         */
        fun checkAuth(
            channelId: String,
            params: MsTeamCheckAuthParams,
        ): CompletableFuture<HttpResponseFor<MsTeamCheckAuthResponse>> =
            checkAuth(channelId, params, RequestOptions.none())

        /** @see [checkAuth] */
        fun checkAuth(
            channelId: String,
            params: MsTeamCheckAuthParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MsTeamCheckAuthResponse>> =
            checkAuth(params.toBuilder().channelId(channelId).build(), requestOptions)

        /** @see [checkAuth] */
        fun checkAuth(
            params: MsTeamCheckAuthParams
        ): CompletableFuture<HttpResponseFor<MsTeamCheckAuthResponse>> =
            checkAuth(params, RequestOptions.none())

        /** @see [checkAuth] */
        fun checkAuth(
            params: MsTeamCheckAuthParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MsTeamCheckAuthResponse>>

        /**
         * Returns a raw HTTP response for `get /v1/providers/ms-teams/{channel_id}/channels`, but
         * is otherwise the same as [MsTeamServiceAsync.listChannels].
         */
        fun listChannels(
            channelId: String,
            params: MsTeamListChannelsParams,
        ): CompletableFuture<HttpResponseFor<MsTeamListChannelsResponse>> =
            listChannels(channelId, params, RequestOptions.none())

        /** @see [listChannels] */
        fun listChannels(
            channelId: String,
            params: MsTeamListChannelsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MsTeamListChannelsResponse>> =
            listChannels(params.toBuilder().channelId(channelId).build(), requestOptions)

        /** @see [listChannels] */
        fun listChannels(
            params: MsTeamListChannelsParams
        ): CompletableFuture<HttpResponseFor<MsTeamListChannelsResponse>> =
            listChannels(params, RequestOptions.none())

        /** @see [listChannels] */
        fun listChannels(
            params: MsTeamListChannelsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MsTeamListChannelsResponse>>

        /**
         * Returns a raw HTTP response for `get /v1/providers/ms-teams/{channel_id}/teams`, but is
         * otherwise the same as [MsTeamServiceAsync.listTeams].
         */
        fun listTeams(
            channelId: String,
            params: MsTeamListTeamsParams,
        ): CompletableFuture<HttpResponseFor<MsTeamListTeamsPageAsync>> =
            listTeams(channelId, params, RequestOptions.none())

        /** @see [listTeams] */
        fun listTeams(
            channelId: String,
            params: MsTeamListTeamsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MsTeamListTeamsPageAsync>> =
            listTeams(params.toBuilder().channelId(channelId).build(), requestOptions)

        /** @see [listTeams] */
        fun listTeams(
            params: MsTeamListTeamsParams
        ): CompletableFuture<HttpResponseFor<MsTeamListTeamsPageAsync>> =
            listTeams(params, RequestOptions.none())

        /** @see [listTeams] */
        fun listTeams(
            params: MsTeamListTeamsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MsTeamListTeamsPageAsync>>

        /**
         * Returns a raw HTTP response for `put /v1/providers/ms-teams/{channel_id}/revoke_access`,
         * but is otherwise the same as [MsTeamServiceAsync.revokeAccess].
         */
        fun revokeAccess(
            channelId: String,
            params: MsTeamRevokeAccessParams,
        ): CompletableFuture<HttpResponseFor<MsTeamRevokeAccessResponse>> =
            revokeAccess(channelId, params, RequestOptions.none())

        /** @see [revokeAccess] */
        fun revokeAccess(
            channelId: String,
            params: MsTeamRevokeAccessParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MsTeamRevokeAccessResponse>> =
            revokeAccess(params.toBuilder().channelId(channelId).build(), requestOptions)

        /** @see [revokeAccess] */
        fun revokeAccess(
            params: MsTeamRevokeAccessParams
        ): CompletableFuture<HttpResponseFor<MsTeamRevokeAccessResponse>> =
            revokeAccess(params, RequestOptions.none())

        /** @see [revokeAccess] */
        fun revokeAccess(
            params: MsTeamRevokeAccessParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MsTeamRevokeAccessResponse>>
    }
}
