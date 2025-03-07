// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.knock.api.services.async.providers

import com.google.errorprone.annotations.MustBeClosed
import com.knock.api.core.RequestOptions
import com.knock.api.core.http.HttpResponseFor
import com.knock.api.models.ProviderMsTeamCheckAuthParams
import com.knock.api.models.ProviderMsTeamCheckAuthResponse
import com.knock.api.models.ProviderMsTeamListChannelsParams
import com.knock.api.models.ProviderMsTeamListChannelsResponse
import com.knock.api.models.ProviderMsTeamListTeamsParams
import com.knock.api.models.ProviderMsTeamListTeamsResponse
import com.knock.api.models.ProviderMsTeamRevokeAccessParams
import java.util.concurrent.CompletableFuture

interface MsTeamServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Check if a connection to Microsoft Teams has been authorized for a given Microsoft Teams
     * tenant object
     */
    @JvmOverloads
    fun checkAuth(
        params: ProviderMsTeamCheckAuthParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProviderMsTeamCheckAuthResponse>

    /**
     * List the Microsoft Teams channels within a team. By default, archived and private channels
     * are excluded from the results.
     */
    @JvmOverloads
    fun listChannels(
        params: ProviderMsTeamListChannelsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProviderMsTeamListChannelsResponse>

    /**
     * Get a list of teams belonging to the Microsoft Entra tenant. By default, archived and private
     * channels are excluded from the results.
     */
    @JvmOverloads
    fun listTeams(
        params: ProviderMsTeamListTeamsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProviderMsTeamListTeamsResponse>

    /** Remove a Microsoft Entra tenant ID from a Microsoft Teams tenant object */
    @JvmOverloads
    fun revokeAccess(
        params: ProviderMsTeamRevokeAccessParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<String>

    /**
     * A view of [MsTeamServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /v1/providers/ms-teams/{channel_id}/auth_check`, but
         * is otherwise the same as [MsTeamServiceAsync.checkAuth].
         */
        @JvmOverloads
        @MustBeClosed
        fun checkAuth(
            params: ProviderMsTeamCheckAuthParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProviderMsTeamCheckAuthResponse>>

        /**
         * Returns a raw HTTP response for `get /v1/providers/ms-teams/{channel_id}/channels`, but
         * is otherwise the same as [MsTeamServiceAsync.listChannels].
         */
        @JvmOverloads
        @MustBeClosed
        fun listChannels(
            params: ProviderMsTeamListChannelsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProviderMsTeamListChannelsResponse>>

        /**
         * Returns a raw HTTP response for `get /v1/providers/ms-teams/{channel_id}/teams`, but is
         * otherwise the same as [MsTeamServiceAsync.listTeams].
         */
        @JvmOverloads
        @MustBeClosed
        fun listTeams(
            params: ProviderMsTeamListTeamsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProviderMsTeamListTeamsResponse>>

        /**
         * Returns a raw HTTP response for `put /v1/providers/ms-teams/{channel_id}/revoke_access`,
         * but is otherwise the same as [MsTeamServiceAsync.revokeAccess].
         */
        @JvmOverloads
        @MustBeClosed
        fun revokeAccess(
            params: ProviderMsTeamRevokeAccessParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<String>>
    }
}
