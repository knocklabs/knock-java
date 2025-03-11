// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.async

import com.knock.api.services.async.providers.MsTeamServiceAsync
import com.knock.api.services.async.providers.SlackServiceAsync

interface ProviderServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for
     * each method.
     */
    fun withRawResponse(): WithRawResponse

    fun slack(): SlackServiceAsync

    fun msTeams(): MsTeamServiceAsync

    /**
     * A view of [ProviderServiceAsync] that provides access to raw HTTP responses for
     * each method.
     */
    interface WithRawResponse {

        fun slack(): SlackServiceAsync.WithRawResponse

        fun msTeams(): MsTeamServiceAsync.WithRawResponse
    }
}
