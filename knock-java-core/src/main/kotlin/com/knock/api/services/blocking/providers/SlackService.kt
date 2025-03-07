// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.knock.api.services.blocking.providers

import com.google.errorprone.annotations.MustBeClosed
import com.knock.api.core.RequestOptions
import com.knock.api.core.http.HttpResponseFor
import com.knock.api.models.ProviderSlackCheckAuthParams
import com.knock.api.models.ProviderSlackCheckAuthResponse
import com.knock.api.models.ProviderSlackListChannelsParams
import com.knock.api.models.ProviderSlackListChannelsResponse
import com.knock.api.models.ProviderSlackRevokeAccessParams

interface SlackService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Check if a Slack channel is authenticated */
    @JvmOverloads
    fun checkAuth(
        params: ProviderSlackCheckAuthParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProviderSlackCheckAuthResponse

    /** List Slack channels for a Slack workspace */
    @JvmOverloads
    fun listChannels(
        params: ProviderSlackListChannelsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProviderSlackListChannelsResponse

    /** Revoke access for a Slack channel */
    @JvmOverloads
    fun revokeAccess(
        params: ProviderSlackRevokeAccessParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): String

    /** A view of [SlackService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /v1/providers/slack/{channel_id}/auth_check`, but is
         * otherwise the same as [SlackService.checkAuth].
         */
        @JvmOverloads
        @MustBeClosed
        fun checkAuth(
            params: ProviderSlackCheckAuthParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProviderSlackCheckAuthResponse>

        /**
         * Returns a raw HTTP response for `get /v1/providers/slack/{channel_id}/channels`, but is
         * otherwise the same as [SlackService.listChannels].
         */
        @JvmOverloads
        @MustBeClosed
        fun listChannels(
            params: ProviderSlackListChannelsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProviderSlackListChannelsResponse>

        /**
         * Returns a raw HTTP response for `put /v1/providers/slack/{channel_id}/revoke_access`, but
         * is otherwise the same as [SlackService.revokeAccess].
         */
        @JvmOverloads
        @MustBeClosed
        fun revokeAccess(
            params: ProviderSlackRevokeAccessParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<String>
    }
}
