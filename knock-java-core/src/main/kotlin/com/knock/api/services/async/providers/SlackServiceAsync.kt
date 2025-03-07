// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.knock.api.services.async.providers

import com.google.errorprone.annotations.MustBeClosed
import com.knock.api.core.RequestOptions
import com.knock.api.core.http.HttpResponseFor
import com.knock.api.models.ProviderSlackCheckAuthParams
import com.knock.api.models.ProviderSlackCheckAuthResponse
import com.knock.api.models.ProviderSlackListChannelsParams
import com.knock.api.models.ProviderSlackListChannelsResponse
import com.knock.api.models.ProviderSlackRevokeAccessParams
import java.util.concurrent.CompletableFuture

interface SlackServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Check if a Slack channel is authenticated */
    @JvmOverloads
    fun checkAuth(
        params: ProviderSlackCheckAuthParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProviderSlackCheckAuthResponse>

    /** List Slack channels for a Slack workspace */
    @JvmOverloads
    fun listChannels(
        params: ProviderSlackListChannelsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProviderSlackListChannelsResponse>

    /** Revoke access for a Slack channel */
    @JvmOverloads
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
        @JvmOverloads
        @MustBeClosed
        fun checkAuth(
            params: ProviderSlackCheckAuthParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProviderSlackCheckAuthResponse>>

        /**
         * Returns a raw HTTP response for `get /v1/providers/slack/{channel_id}/channels`, but is
         * otherwise the same as [SlackServiceAsync.listChannels].
         */
        @JvmOverloads
        @MustBeClosed
        fun listChannels(
            params: ProviderSlackListChannelsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProviderSlackListChannelsResponse>>

        /**
         * Returns a raw HTTP response for `put /v1/providers/slack/{channel_id}/revoke_access`, but
         * is otherwise the same as [SlackServiceAsync.revokeAccess].
         */
        @JvmOverloads
        @MustBeClosed
        fun revokeAccess(
            params: ProviderSlackRevokeAccessParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<String>>
    }
}
