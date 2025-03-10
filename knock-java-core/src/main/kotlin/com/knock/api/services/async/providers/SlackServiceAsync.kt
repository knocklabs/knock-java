// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.async.providers

import com.google.errorprone.annotations.MustBeClosed
import com.knock.api.core.RequestOptions
import com.knock.api.core.http.HttpResponseFor
import com.knock.api.models.ProviderSlackCheckAuthParams
import com.knock.api.models.ProviderSlackCheckAuthResponse
import com.knock.api.models.ProviderSlackListChannelsPageAsync
import com.knock.api.models.ProviderSlackListChannelsParams
import com.knock.api.models.ProviderSlackRevokeAccessParams
import java.util.concurrent.CompletableFuture

interface SlackServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Check if a Slack channel is authenticated */
    fun checkAuth(
        params: ProviderSlackCheckAuthParams
    ): CompletableFuture<ProviderSlackCheckAuthResponse> = checkAuth(params, RequestOptions.none())

    /** @see [checkAuth] */
    fun checkAuth(
        params: ProviderSlackCheckAuthParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProviderSlackCheckAuthResponse>

    /** List Slack channels for a Slack workspace */
    fun listChannels(
        params: ProviderSlackListChannelsParams
    ): CompletableFuture<ProviderSlackListChannelsPageAsync> =
        listChannels(params, RequestOptions.none())

    /** @see [listChannels] */
    fun listChannels(
        params: ProviderSlackListChannelsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProviderSlackListChannelsPageAsync>

    /** Revoke access for a Slack channel */
    fun revokeAccess(params: ProviderSlackRevokeAccessParams): CompletableFuture<String> =
        revokeAccess(params, RequestOptions.none())

    /** @see [revokeAccess] */
    fun revokeAccess(
        params: ProviderSlackRevokeAccessParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<String>

    /** A view of [SlackServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /v1/providers/slack/{channel_id}/auth_check`, but is
         * otherwise the same as [SlackServiceAsync.checkAuth].
         */
        @MustBeClosed
        fun checkAuth(
            params: ProviderSlackCheckAuthParams
        ): CompletableFuture<HttpResponseFor<ProviderSlackCheckAuthResponse>> =
            checkAuth(params, RequestOptions.none())

        /** @see [checkAuth] */
        @MustBeClosed
        fun checkAuth(
            params: ProviderSlackCheckAuthParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProviderSlackCheckAuthResponse>>

        /**
         * Returns a raw HTTP response for `get /v1/providers/slack/{channel_id}/channels`, but is
         * otherwise the same as [SlackServiceAsync.listChannels].
         */
        @MustBeClosed
        fun listChannels(
            params: ProviderSlackListChannelsParams
        ): CompletableFuture<HttpResponseFor<ProviderSlackListChannelsPageAsync>> =
            listChannels(params, RequestOptions.none())

        /** @see [listChannels] */
        @MustBeClosed
        fun listChannels(
            params: ProviderSlackListChannelsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProviderSlackListChannelsPageAsync>>

        /**
         * Returns a raw HTTP response for `put /v1/providers/slack/{channel_id}/revoke_access`, but
         * is otherwise the same as [SlackServiceAsync.revokeAccess].
         */
        @MustBeClosed
        fun revokeAccess(
            params: ProviderSlackRevokeAccessParams
        ): CompletableFuture<HttpResponseFor<String>> = revokeAccess(params, RequestOptions.none())

        /** @see [revokeAccess] */
        @MustBeClosed
        fun revokeAccess(
            params: ProviderSlackRevokeAccessParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<String>>
    }
}
