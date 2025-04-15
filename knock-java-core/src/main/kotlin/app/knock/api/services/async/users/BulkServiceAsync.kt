// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async.users

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.bulkoperations.BulkOperation
import app.knock.api.models.users.bulk.BulkDeleteParams
import app.knock.api.models.users.bulk.BulkIdentifyParams
import app.knock.api.models.users.bulk.BulkSetPreferencesParams
import com.google.errorprone.annotations.MustBeClosed
import java.util.concurrent.CompletableFuture

interface BulkServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Bulk deletes a list of users */
    fun delete(params: BulkDeleteParams): CompletableFuture<BulkOperation> =
        delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: BulkDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BulkOperation>

    /** Bulk identifies a list of users */
    fun identify(): CompletableFuture<BulkOperation> = identify(BulkIdentifyParams.none())

    /** @see [identify] */
    fun identify(
        params: BulkIdentifyParams = BulkIdentifyParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BulkOperation>

    /** @see [identify] */
    fun identify(
        params: BulkIdentifyParams = BulkIdentifyParams.none()
    ): CompletableFuture<BulkOperation> = identify(params, RequestOptions.none())

    /** @see [identify] */
    fun identify(requestOptions: RequestOptions): CompletableFuture<BulkOperation> =
        identify(BulkIdentifyParams.none(), requestOptions)

    /** Bulk sets user preferences */
    fun setPreferences(): CompletableFuture<BulkOperation> =
        setPreferences(BulkSetPreferencesParams.none())

    /** @see [setPreferences] */
    fun setPreferences(
        params: BulkSetPreferencesParams = BulkSetPreferencesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BulkOperation>

    /** @see [setPreferences] */
    fun setPreferences(
        params: BulkSetPreferencesParams = BulkSetPreferencesParams.none()
    ): CompletableFuture<BulkOperation> = setPreferences(params, RequestOptions.none())

    /** @see [setPreferences] */
    fun setPreferences(requestOptions: RequestOptions): CompletableFuture<BulkOperation> =
        setPreferences(BulkSetPreferencesParams.none(), requestOptions)

    /** A view of [BulkServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/users/bulk/delete`, but is otherwise the same
         * as [BulkServiceAsync.delete].
         */
        @MustBeClosed
        fun delete(params: BulkDeleteParams): CompletableFuture<HttpResponseFor<BulkOperation>> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: BulkDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BulkOperation>>

        /**
         * Returns a raw HTTP response for `post /v1/users/bulk/identify`, but is otherwise the same
         * as [BulkServiceAsync.identify].
         */
        @MustBeClosed
        fun identify(): CompletableFuture<HttpResponseFor<BulkOperation>> =
            identify(BulkIdentifyParams.none())

        /** @see [identify] */
        @MustBeClosed
        fun identify(
            params: BulkIdentifyParams = BulkIdentifyParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BulkOperation>>

        /** @see [identify] */
        @MustBeClosed
        fun identify(
            params: BulkIdentifyParams = BulkIdentifyParams.none()
        ): CompletableFuture<HttpResponseFor<BulkOperation>> =
            identify(params, RequestOptions.none())

        /** @see [identify] */
        @MustBeClosed
        fun identify(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<BulkOperation>> =
            identify(BulkIdentifyParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/users/bulk/preferences`, but is otherwise the
         * same as [BulkServiceAsync.setPreferences].
         */
        @MustBeClosed
        fun setPreferences(): CompletableFuture<HttpResponseFor<BulkOperation>> =
            setPreferences(BulkSetPreferencesParams.none())

        /** @see [setPreferences] */
        @MustBeClosed
        fun setPreferences(
            params: BulkSetPreferencesParams = BulkSetPreferencesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BulkOperation>>

        /** @see [setPreferences] */
        @MustBeClosed
        fun setPreferences(
            params: BulkSetPreferencesParams = BulkSetPreferencesParams.none()
        ): CompletableFuture<HttpResponseFor<BulkOperation>> =
            setPreferences(params, RequestOptions.none())

        /** @see [setPreferences] */
        @MustBeClosed
        fun setPreferences(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<BulkOperation>> =
            setPreferences(BulkSetPreferencesParams.none(), requestOptions)
    }
}
