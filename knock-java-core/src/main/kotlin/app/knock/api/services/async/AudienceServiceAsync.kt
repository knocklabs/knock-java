// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.audiences.AudienceAddMembersParams
import app.knock.api.models.audiences.AudienceListMembersParams
import app.knock.api.models.audiences.AudienceListMembersResponse
import app.knock.api.models.audiences.AudienceRemoveMembersParams
import com.google.errorprone.annotations.MustBeClosed
import java.util.concurrent.CompletableFuture

interface AudienceServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Add members */
    fun addMembers(params: AudienceAddMembersParams): CompletableFuture<String> =
        addMembers(params, RequestOptions.none())

    /** @see [addMembers] */
    fun addMembers(
        params: AudienceAddMembersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<String>

    /** List members */
    fun listMembers(
        params: AudienceListMembersParams
    ): CompletableFuture<AudienceListMembersResponse> = listMembers(params, RequestOptions.none())

    /** @see [listMembers] */
    fun listMembers(
        params: AudienceListMembersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AudienceListMembersResponse>

    /** Remove members */
    fun removeMembers(params: AudienceRemoveMembersParams): CompletableFuture<String> =
        removeMembers(params, RequestOptions.none())

    /** @see [removeMembers] */
    fun removeMembers(
        params: AudienceRemoveMembersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<String>

    /**
     * A view of [AudienceServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/audiences/{key}/members`, but is otherwise the
         * same as [AudienceServiceAsync.addMembers].
         */
        @MustBeClosed
        fun addMembers(
            params: AudienceAddMembersParams
        ): CompletableFuture<HttpResponseFor<String>> = addMembers(params, RequestOptions.none())

        /** @see [addMembers] */
        @MustBeClosed
        fun addMembers(
            params: AudienceAddMembersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<String>>

        /**
         * Returns a raw HTTP response for `get /v1/audiences/{key}/members`, but is otherwise the
         * same as [AudienceServiceAsync.listMembers].
         */
        @MustBeClosed
        fun listMembers(
            params: AudienceListMembersParams
        ): CompletableFuture<HttpResponseFor<AudienceListMembersResponse>> =
            listMembers(params, RequestOptions.none())

        /** @see [listMembers] */
        @MustBeClosed
        fun listMembers(
            params: AudienceListMembersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AudienceListMembersResponse>>

        /**
         * Returns a raw HTTP response for `delete /v1/audiences/{key}/members`, but is otherwise
         * the same as [AudienceServiceAsync.removeMembers].
         */
        @MustBeClosed
        fun removeMembers(
            params: AudienceRemoveMembersParams
        ): CompletableFuture<HttpResponseFor<String>> = removeMembers(params, RequestOptions.none())

        /** @see [removeMembers] */
        @MustBeClosed
        fun removeMembers(
            params: AudienceRemoveMembersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<String>>
    }
}
