// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.audiences.AudienceAddMembersParams
import app.knock.api.models.audiences.AudienceListMembersParams
import app.knock.api.models.audiences.AudienceListMembersResponse
import app.knock.api.models.audiences.AudienceRemoveMembersParams
import com.google.errorprone.annotations.MustBeClosed

interface AudienceService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Adds one or more members to the specified audience. */
    fun addMembers(key: String, params: AudienceAddMembersParams): String =
        addMembers(key, params, RequestOptions.none())

    /** @see [addMembers] */
    fun addMembers(
        key: String,
        params: AudienceAddMembersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): String = addMembers(params.toBuilder().key(key).build(), requestOptions)

    /** @see [addMembers] */
    fun addMembers(params: AudienceAddMembersParams): String =
        addMembers(params, RequestOptions.none())

    /** @see [addMembers] */
    fun addMembers(
        params: AudienceAddMembersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): String

    /** Returns a paginated list of members for the specified audience. */
    fun listMembers(key: String): AudienceListMembersResponse =
        listMembers(key, AudienceListMembersParams.none())

    /** @see [listMembers] */
    fun listMembers(
        key: String,
        params: AudienceListMembersParams = AudienceListMembersParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AudienceListMembersResponse =
        listMembers(params.toBuilder().key(key).build(), requestOptions)

    /** @see [listMembers] */
    fun listMembers(
        key: String,
        params: AudienceListMembersParams = AudienceListMembersParams.none(),
    ): AudienceListMembersResponse = listMembers(key, params, RequestOptions.none())

    /** @see [listMembers] */
    fun listMembers(
        params: AudienceListMembersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AudienceListMembersResponse

    /** @see [listMembers] */
    fun listMembers(params: AudienceListMembersParams): AudienceListMembersResponse =
        listMembers(params, RequestOptions.none())

    /** @see [listMembers] */
    fun listMembers(key: String, requestOptions: RequestOptions): AudienceListMembersResponse =
        listMembers(key, AudienceListMembersParams.none(), requestOptions)

    /** Removes one or more members from the specified audience. */
    fun removeMembers(key: String, params: AudienceRemoveMembersParams): String =
        removeMembers(key, params, RequestOptions.none())

    /** @see [removeMembers] */
    fun removeMembers(
        key: String,
        params: AudienceRemoveMembersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): String = removeMembers(params.toBuilder().key(key).build(), requestOptions)

    /** @see [removeMembers] */
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
        fun addMembers(key: String, params: AudienceAddMembersParams): HttpResponseFor<String> =
            addMembers(key, params, RequestOptions.none())

        /** @see [addMembers] */
        @MustBeClosed
        fun addMembers(
            key: String,
            params: AudienceAddMembersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<String> = addMembers(params.toBuilder().key(key).build(), requestOptions)

        /** @see [addMembers] */
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
        fun listMembers(key: String): HttpResponseFor<AudienceListMembersResponse> =
            listMembers(key, AudienceListMembersParams.none())

        /** @see [listMembers] */
        @MustBeClosed
        fun listMembers(
            key: String,
            params: AudienceListMembersParams = AudienceListMembersParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AudienceListMembersResponse> =
            listMembers(params.toBuilder().key(key).build(), requestOptions)

        /** @see [listMembers] */
        @MustBeClosed
        fun listMembers(
            key: String,
            params: AudienceListMembersParams = AudienceListMembersParams.none(),
        ): HttpResponseFor<AudienceListMembersResponse> =
            listMembers(key, params, RequestOptions.none())

        /** @see [listMembers] */
        @MustBeClosed
        fun listMembers(
            params: AudienceListMembersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AudienceListMembersResponse>

        /** @see [listMembers] */
        @MustBeClosed
        fun listMembers(
            params: AudienceListMembersParams
        ): HttpResponseFor<AudienceListMembersResponse> = listMembers(params, RequestOptions.none())

        /** @see [listMembers] */
        @MustBeClosed
        fun listMembers(
            key: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AudienceListMembersResponse> =
            listMembers(key, AudienceListMembersParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/audiences/{key}/members`, but is otherwise
         * the same as [AudienceService.removeMembers].
         */
        @MustBeClosed
        fun removeMembers(
            key: String,
            params: AudienceRemoveMembersParams,
        ): HttpResponseFor<String> = removeMembers(key, params, RequestOptions.none())

        /** @see [removeMembers] */
        @MustBeClosed
        fun removeMembers(
            key: String,
            params: AudienceRemoveMembersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<String> =
            removeMembers(params.toBuilder().key(key).build(), requestOptions)

        /** @see [removeMembers] */
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
