// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.knock.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.knock.api.core.RequestOptions
import com.knock.api.core.http.HttpResponseFor
import com.knock.api.models.AudienceAddMembersParams
import com.knock.api.models.AudienceListMembersParams
import com.knock.api.models.AudienceListMembersResponse
import com.knock.api.models.AudienceRemoveMembersParams

interface AudienceService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Add members */
    @JvmOverloads
    fun addMembers(
        params: AudienceAddMembersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): String

    /** List members */
    @JvmOverloads
    fun listMembers(
        params: AudienceListMembersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AudienceListMembersResponse

    /** Remove members */
    @JvmOverloads
    fun removeMembers(
        params: AudienceRemoveMembersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): String

    /** A view of [AudienceService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/audiences/{key}/members`, but is otherwise the
         * same as [AudienceService.addMembers].
         */
        @JvmOverloads
        @MustBeClosed
        fun addMembers(
            params: AudienceAddMembersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<String>

        /**
         * Returns a raw HTTP response for `get /v1/audiences/{key}/members`, but is otherwise the
         * same as [AudienceService.listMembers].
         */
        @JvmOverloads
        @MustBeClosed
        fun listMembers(
            params: AudienceListMembersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AudienceListMembersResponse>

        /**
         * Returns a raw HTTP response for `delete /v1/audiences/{key}/members`, but is otherwise
         * the same as [AudienceService.removeMembers].
         */
        @JvmOverloads
        @MustBeClosed
        fun removeMembers(
            params: AudienceRemoveMembersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<String>
    }
}
