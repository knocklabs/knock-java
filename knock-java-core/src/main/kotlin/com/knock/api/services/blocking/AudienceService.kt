// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.knock.api.core.RequestOptions
import com.knock.api.core.http.HttpResponseFor
import com.knock.api.models.audiences.AudienceAddMembersParams
import com.knock.api.models.audiences.AudienceListMembersParams
import com.knock.api.models.audiences.AudienceListMembersResponse
import com.knock.api.models.audiences.AudienceRemoveMembersParams

interface AudienceService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Add members */
    fun addMembers(params: AudienceAddMembersParams): String =
        addMembers(params, RequestOptions.none())

    /** @see [addMembers] */
    fun addMembers(
        params: AudienceAddMembersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): String

    /** List members */
    fun listMembers(params: AudienceListMembersParams): AudienceListMembersResponse =
        listMembers(params, RequestOptions.none())

    /** @see [listMembers] */
    fun listMembers(
        params: AudienceListMembersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AudienceListMembersResponse

    /** Remove members */
    fun removeMembers(params: AudienceRemoveMembersParams): String =
        removeMembers(params, RequestOptions.none())

    /** @see [removeMembers] */
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
        @MustBeClosed
        fun addMembers(params: AudienceAddMembersParams): HttpResponseFor<String> =
            addMembers(params, RequestOptions.none())

        /** @see [addMembers] */
        @MustBeClosed
        fun addMembers(
            params: AudienceAddMembersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<String>

        /**
         * Returns a raw HTTP response for `get /v1/audiences/{key}/members`, but is otherwise the
         * same as [AudienceService.listMembers].
         */
        @MustBeClosed
        fun listMembers(
            params: AudienceListMembersParams
        ): HttpResponseFor<AudienceListMembersResponse> = listMembers(params, RequestOptions.none())

        /** @see [listMembers] */
        @MustBeClosed
        fun listMembers(
            params: AudienceListMembersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AudienceListMembersResponse>

        /**
         * Returns a raw HTTP response for `delete /v1/audiences/{key}/members`, but is otherwise
         * the same as [AudienceService.removeMembers].
         */
        @MustBeClosed
        fun removeMembers(params: AudienceRemoveMembersParams): HttpResponseFor<String> =
            removeMembers(params, RequestOptions.none())

        /** @see [removeMembers] */
        @MustBeClosed
        fun removeMembers(
            params: AudienceRemoveMembersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<String>
    }
}
