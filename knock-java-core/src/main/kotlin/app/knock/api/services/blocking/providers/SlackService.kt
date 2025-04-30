// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking.providers

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.providers.slack.SlackCheckAuthParams
import app.knock.api.models.providers.slack.SlackCheckAuthResponse
import app.knock.api.models.providers.slack.SlackListChannelsPage
import app.knock.api.models.providers.slack.SlackListChannelsParams
import app.knock.api.models.providers.slack.SlackRevokeAccessParams
import app.knock.api.models.providers.slack.SlackRevokeAccessResponse
import com.google.errorprone.annotations.MustBeClosed

interface SlackService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Check if a Slack channel is authenticated. */
    fun checkAuth(params: SlackCheckAuthParams): SlackCheckAuthResponse =
        checkAuth(params, RequestOptions.none())

    /** @see [checkAuth] */
    fun checkAuth(
        params: SlackCheckAuthParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SlackCheckAuthResponse

    /** List Slack channels for a Slack workspace. */
    fun listChannels(params: SlackListChannelsParams): SlackListChannelsPage =
        listChannels(params, RequestOptions.none())

    /** @see [listChannels] */
    fun listChannels(
        params: SlackListChannelsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SlackListChannelsPage

    /** Revoke access for a Slack channel. */
    fun revokeAccess(params: SlackRevokeAccessParams): SlackRevokeAccessResponse =
        revokeAccess(params, RequestOptions.none())

    /** @see [revokeAccess] */
    fun revokeAccess(
        params: SlackRevokeAccessParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SlackRevokeAccessResponse

    /** A view of [SlackService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /v1/providers/slack/{channel_id}/auth_check`, but is
         * otherwise the same as [SlackService.checkAuth].
         */
        @MustBeClosed
        fun checkAuth(params: SlackCheckAuthParams): HttpResponseFor<SlackCheckAuthResponse> =
            checkAuth(params, RequestOptions.none())

        /** @see [checkAuth] */
        @MustBeClosed
        fun checkAuth(
            params: SlackCheckAuthParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SlackCheckAuthResponse>

        /**
         * Returns a raw HTTP response for `get /v1/providers/slack/{channel_id}/channels`, but is
         * otherwise the same as [SlackService.listChannels].
         */
        @MustBeClosed
        fun listChannels(params: SlackListChannelsParams): HttpResponseFor<SlackListChannelsPage> =
            listChannels(params, RequestOptions.none())

        /** @see [listChannels] */
        @MustBeClosed
        fun listChannels(
            params: SlackListChannelsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SlackListChannelsPage>

        /**
         * Returns a raw HTTP response for `put /v1/providers/slack/{channel_id}/revoke_access`, but
         * is otherwise the same as [SlackService.revokeAccess].
         */
        @MustBeClosed
        fun revokeAccess(
            params: SlackRevokeAccessParams
        ): HttpResponseFor<SlackRevokeAccessResponse> = revokeAccess(params, RequestOptions.none())

        /** @see [revokeAccess] */
        @MustBeClosed
        fun revokeAccess(
            params: SlackRevokeAccessParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SlackRevokeAccessResponse>
    }
}
