// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.async.providers

import com.google.errorprone.annotations.MustBeClosed
import com.knock.api.core.RequestOptions
import com.knock.api.core.http.HttpResponseFor
import com.knock.api.models.providers.msteams.MsTeamCheckAuthParams
import com.knock.api.models.providers.msteams.MsTeamCheckAuthResponse
import com.knock.api.models.providers.msteams.MsTeamListChannelsParams
import com.knock.api.models.providers.msteams.MsTeamListChannelsResponse
import com.knock.api.models.providers.msteams.MsTeamListTeamsParams
import com.knock.api.models.providers.msteams.MsTeamListTeamsResponse
import com.knock.api.models.providers.msteams.MsTeamRevokeAccessParams
import java.util.concurrent.CompletableFuture

interface MsTeamServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for
     * each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Check if a connection to Microsoft Teams has been authorized for a given
     * Microsoft Teams tenant object
     */
    fun checkAuth(params: MsTeamCheckAuthParams): CompletableFuture<MsTeamCheckAuthResponse> =
        checkAuth(
          params, RequestOptions.none()
        )

    /** @see [checkAuth] */
    fun checkAuth(params: MsTeamCheckAuthParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<MsTeamCheckAuthResponse>

    /**
     * List the Microsoft Teams channels within a team. By default, archived and
     * private channels are excluded from the results.
     */
    fun listChannels(params: MsTeamListChannelsParams): CompletableFuture<MsTeamListChannelsResponse> =
        listChannels(
          params, RequestOptions.none()
        )

    /** @see [listChannels] */
    fun listChannels(params: MsTeamListChannelsParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<MsTeamListChannelsResponse>

    /**
     * Get a list of teams belonging to the Microsoft Entra tenant. By default,
     * archived and private channels are excluded from the results.
     */
    fun listTeams(params: MsTeamListTeamsParams): CompletableFuture<MsTeamListTeamsResponse> =
        listTeams(
          params, RequestOptions.none()
        )

    /** @see [listTeams] */
    fun listTeams(params: MsTeamListTeamsParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<MsTeamListTeamsResponse>

    /** Remove a Microsoft Entra tenant ID from a Microsoft Teams tenant object */
    fun revokeAccess(params: MsTeamRevokeAccessParams): CompletableFuture<String> =
        revokeAccess(
          params, RequestOptions.none()
        )

    /** @see [revokeAccess] */
    fun revokeAccess(params: MsTeamRevokeAccessParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<String>

    /**
     * A view of [MsTeamServiceAsync] that provides access to raw HTTP responses for
     * each method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for
         * `get /v1/providers/ms-teams/{channel_id}/auth_check`, but is otherwise the same
         * as [MsTeamServiceAsync.checkAuth].
         */
        @MustBeClosed
        fun checkAuth(params: MsTeamCheckAuthParams): CompletableFuture<HttpResponseFor<MsTeamCheckAuthResponse>> =
            checkAuth(
              params, RequestOptions.none()
            )

        /** @see [checkAuth] */
        @MustBeClosed
        fun checkAuth(params: MsTeamCheckAuthParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<HttpResponseFor<MsTeamCheckAuthResponse>>

        /**
         * Returns a raw HTTP response for
         * `get /v1/providers/ms-teams/{channel_id}/channels`, but is otherwise the same as
         * [MsTeamServiceAsync.listChannels].
         */
        @MustBeClosed
        fun listChannels(params: MsTeamListChannelsParams): CompletableFuture<HttpResponseFor<MsTeamListChannelsResponse>> =
            listChannels(
              params, RequestOptions.none()
            )

        /** @see [listChannels] */
        @MustBeClosed
        fun listChannels(params: MsTeamListChannelsParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<HttpResponseFor<MsTeamListChannelsResponse>>

        /**
         * Returns a raw HTTP response for `get /v1/providers/ms-teams/{channel_id}/teams`,
         * but is otherwise the same as [MsTeamServiceAsync.listTeams].
         */
        @MustBeClosed
        fun listTeams(params: MsTeamListTeamsParams): CompletableFuture<HttpResponseFor<MsTeamListTeamsResponse>> =
            listTeams(
              params, RequestOptions.none()
            )

        /** @see [listTeams] */
        @MustBeClosed
        fun listTeams(params: MsTeamListTeamsParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<HttpResponseFor<MsTeamListTeamsResponse>>

        /**
         * Returns a raw HTTP response for
         * `put /v1/providers/ms-teams/{channel_id}/revoke_access`, but is otherwise the
         * same as [MsTeamServiceAsync.revokeAccess].
         */
        @MustBeClosed
        fun revokeAccess(params: MsTeamRevokeAccessParams): CompletableFuture<HttpResponseFor<String>> =
            revokeAccess(
              params, RequestOptions.none()
            )

        /** @see [revokeAccess] */
        @MustBeClosed
        fun revokeAccess(params: MsTeamRevokeAccessParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<HttpResponseFor<String>>
    }
}
