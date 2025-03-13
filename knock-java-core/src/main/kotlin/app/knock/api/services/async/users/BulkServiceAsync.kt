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
     * Returns a view of this service that provides access to raw HTTP responses for
     * each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Bulk delete users */
    fun delete(params: BulkDeleteParams): CompletableFuture<BulkOperation> =
        delete(
          params, RequestOptions.none()
        )

    /** @see [delete] */
    fun delete(params: BulkDeleteParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<BulkOperation>

    /** Bulk identifies users */
    fun identify(params: BulkIdentifyParams): CompletableFuture<BulkOperation> =
        identify(
          params, RequestOptions.none()
        )

    /** @see [identify] */
    fun identify(params: BulkIdentifyParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<BulkOperation>

    /** Bulk set preferences */
    fun setPreferences(params: BulkSetPreferencesParams): CompletableFuture<BulkOperation> =
        setPreferences(
          params, RequestOptions.none()
        )

    /** @see [setPreferences] */
    fun setPreferences(params: BulkSetPreferencesParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<BulkOperation>

    /**
     * A view of [BulkServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/users/bulk/delete`, but is otherwise
         * the same as [BulkServiceAsync.delete].
         */
        @MustBeClosed
        fun delete(params: BulkDeleteParams): CompletableFuture<HttpResponseFor<BulkOperation>> =
            delete(
              params, RequestOptions.none()
            )

        /** @see [delete] */
        @MustBeClosed
        fun delete(params: BulkDeleteParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<HttpResponseFor<BulkOperation>>

        /**
         * Returns a raw HTTP response for `post /v1/users/bulk/identify`, but is otherwise
         * the same as [BulkServiceAsync.identify].
         */
        @MustBeClosed
        fun identify(params: BulkIdentifyParams): CompletableFuture<HttpResponseFor<BulkOperation>> =
            identify(
              params, RequestOptions.none()
            )

        /** @see [identify] */
        @MustBeClosed
        fun identify(params: BulkIdentifyParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<HttpResponseFor<BulkOperation>>

        /**
         * Returns a raw HTTP response for `post /v1/users/bulk/preferences`, but is
         * otherwise the same as [BulkServiceAsync.setPreferences].
         */
        @MustBeClosed
        fun setPreferences(params: BulkSetPreferencesParams): CompletableFuture<HttpResponseFor<BulkOperation>> =
            setPreferences(
              params, RequestOptions.none()
            )

        /** @see [setPreferences] */
        @MustBeClosed
        fun setPreferences(params: BulkSetPreferencesParams, requestOptions: RequestOptions = RequestOptions.none()): CompletableFuture<HttpResponseFor<BulkOperation>>
    }
}
