// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async.providers

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.providers.slack.SlackCheckAuthParams
import app.knock.api.models.providers.slack.SlackCheckAuthResponse
import app.knock.api.models.providers.slack.SlackListChannelsPageAsync
import app.knock.api.models.providers.slack.SlackListChannelsParams
import app.knock.api.models.providers.slack.SlackRevokeAccessParams
import app.knock.api.models.providers.slack.SlackRevokeAccessResponse
import com.google.errorprone.annotations.MustBeClosed
import java.util.concurrent.CompletableFuture

interface SlackServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Check if a Slack channel is authenticated. */
    fun checkAuth(
        channelId: String,
        params: SlackCheckAuthParams,
    ): CompletableFuture<SlackCheckAuthResponse> =
        checkAuth(channelId, params, RequestOptions.none())

    /** @see [checkAuth] */
    fun checkAuth(
        channelId: String,
        params: SlackCheckAuthParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<SlackCheckAuthResponse> =
        checkAuth(params.toBuilder().channelId(channelId).build(), requestOptions)

    /** @see [checkAuth] */
    fun checkAuth(params: SlackCheckAuthParams): CompletableFuture<SlackCheckAuthResponse> =
        checkAuth(params, RequestOptions.none())

    /** @see [checkAuth] */
    fun checkAuth(
        params: SlackCheckAuthParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<SlackCheckAuthResponse>

    /** List Slack channels for a Slack workspace. */
    fun listChannels(
        channelId: String,
        params: SlackListChannelsParams,
    ): CompletableFuture<SlackListChannelsPageAsync> =
        listChannels(channelId, params, RequestOptions.none())

    /** @see [listChannels] */
    fun listChannels(
        channelId: String,
        params: SlackListChannelsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<SlackListChannelsPageAsync> =
        listChannels(params.toBuilder().channelId(channelId).build(), requestOptions)

    /** @see [listChannels] */
    fun listChannels(
        params: SlackListChannelsParams
    ): CompletableFuture<SlackListChannelsPageAsync> = listChannels(params, RequestOptions.none())

    /** @see [listChannels] */
    fun listChannels(
        params: SlackListChannelsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<SlackListChannelsPageAsync>

    /** Revoke access for a Slack channel. */
    fun revokeAccess(
        channelId: String,
        params: SlackRevokeAccessParams,
    ): CompletableFuture<SlackRevokeAccessResponse> =
        revokeAccess(channelId, params, RequestOptions.none())

    /** @see [revokeAccess] */
    fun revokeAccess(
        channelId: String,
        params: SlackRevokeAccessParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<SlackRevokeAccessResponse> =
        revokeAccess(params.toBuilder().channelId(channelId).build(), requestOptions)

    /** @see [revokeAccess] */
    fun revokeAccess(
        params: SlackRevokeAccessParams
    ): CompletableFuture<SlackRevokeAccessResponse> = revokeAccess(params, RequestOptions.none())

    /** @see [revokeAccess] */
    fun revokeAccess(
        params: SlackRevokeAccessParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<SlackRevokeAccessResponse>

    /** A view of [SlackServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /v1/providers/slack/{channel_id}/auth_check`, but is
         * otherwise the same as [SlackServiceAsync.checkAuth].
         */
        @MustBeClosed
        fun checkAuth(
            channelId: String,
            params: SlackCheckAuthParams,
        ): CompletableFuture<HttpResponseFor<SlackCheckAuthResponse>> =
            checkAuth(channelId, params, RequestOptions.none())

        /** @see [checkAuth] */
        @MustBeClosed
        fun checkAuth(
            channelId: String,
            params: SlackCheckAuthParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<SlackCheckAuthResponse>> =
            checkAuth(params.toBuilder().channelId(channelId).build(), requestOptions)

        /** @see [checkAuth] */
        @MustBeClosed
        fun checkAuth(
            params: SlackCheckAuthParams
        ): CompletableFuture<HttpResponseFor<SlackCheckAuthResponse>> =
            checkAuth(params, RequestOptions.none())

        /** @see [checkAuth] */
        @MustBeClosed
        fun checkAuth(
            params: SlackCheckAuthParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<SlackCheckAuthResponse>>

        /**
         * Returns a raw HTTP response for `get /v1/providers/slack/{channel_id}/channels`, but is
         * otherwise the same as [SlackServiceAsync.listChannels].
         */
        @MustBeClosed
        fun listChannels(
            channelId: String,
            params: SlackListChannelsParams,
        ): CompletableFuture<HttpResponseFor<SlackListChannelsPageAsync>> =
            listChannels(channelId, params, RequestOptions.none())

        /** @see [listChannels] */
        @MustBeClosed
        fun listChannels(
            channelId: String,
            params: SlackListChannelsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<SlackListChannelsPageAsync>> =
            listChannels(params.toBuilder().channelId(channelId).build(), requestOptions)

        /** @see [listChannels] */
        @MustBeClosed
        fun listChannels(
            params: SlackListChannelsParams
        ): CompletableFuture<HttpResponseFor<SlackListChannelsPageAsync>> =
            listChannels(params, RequestOptions.none())

        /** @see [listChannels] */
        @MustBeClosed
        fun listChannels(
            params: SlackListChannelsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<SlackListChannelsPageAsync>>

        /**
         * Returns a raw HTTP response for `put /v1/providers/slack/{channel_id}/revoke_access`, but
         * is otherwise the same as [SlackServiceAsync.revokeAccess].
         */
        @MustBeClosed
        fun revokeAccess(
            channelId: String,
            params: SlackRevokeAccessParams,
        ): CompletableFuture<HttpResponseFor<SlackRevokeAccessResponse>> =
            revokeAccess(channelId, params, RequestOptions.none())

        /** @see [revokeAccess] */
        @MustBeClosed
        fun revokeAccess(
            channelId: String,
            params: SlackRevokeAccessParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<SlackRevokeAccessResponse>> =
            revokeAccess(params.toBuilder().channelId(channelId).build(), requestOptions)

        /** @see [revokeAccess] */
        @MustBeClosed
        fun revokeAccess(
            params: SlackRevokeAccessParams
        ): CompletableFuture<HttpResponseFor<SlackRevokeAccessResponse>> =
            revokeAccess(params, RequestOptions.none())

        /** @see [revokeAccess] */
        @MustBeClosed
        fun revokeAccess(
            params: SlackRevokeAccessParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<SlackRevokeAccessResponse>>
    }
}
