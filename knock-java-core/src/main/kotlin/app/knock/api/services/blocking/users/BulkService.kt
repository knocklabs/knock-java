// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking.users

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.bulkoperations.BulkOperation
import app.knock.api.models.users.bulk.BulkDeleteParams
import app.knock.api.models.users.bulk.BulkIdentifyParams
import app.knock.api.models.users.bulk.BulkSetPreferencesParams
import com.google.errorprone.annotations.MustBeClosed

interface BulkService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Deletes multiple users in a single operation. Accepts up to 100 user IDs to delete and
     * returns a bulk operation that can be queried for progress.
     */
    fun delete(params: BulkDeleteParams): BulkOperation = delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: BulkDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BulkOperation

    /**
     * Identifies multiple users in a single operation. Allows creating or updating up to 100 users
     * in a single batch with various properties, preferences, and channel data.
     */
    fun identify(params: BulkIdentifyParams): BulkOperation =
        identify(params, RequestOptions.none())

    /** @see [identify] */
    fun identify(
        params: BulkIdentifyParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BulkOperation

    /**
     * Sets preferences for multiple users in a single operation. Supports either setting the same
     * preferences for multiple users or specific preferences for each user.
     */
    fun setPreferences(params: BulkSetPreferencesParams): BulkOperation =
        setPreferences(params, RequestOptions.none())

    /** @see [setPreferences] */
    fun setPreferences(
        params: BulkSetPreferencesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BulkOperation

    /** A view of [BulkService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/users/bulk/delete`, but is otherwise the same
         * as [BulkService.delete].
         */
        @MustBeClosed
        fun delete(params: BulkDeleteParams): HttpResponseFor<BulkOperation> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: BulkDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BulkOperation>

        /**
         * Returns a raw HTTP response for `post /v1/users/bulk/identify`, but is otherwise the same
         * as [BulkService.identify].
         */
        @MustBeClosed
        fun identify(params: BulkIdentifyParams): HttpResponseFor<BulkOperation> =
            identify(params, RequestOptions.none())

        /** @see [identify] */
        @MustBeClosed
        fun identify(
            params: BulkIdentifyParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BulkOperation>

        /**
         * Returns a raw HTTP response for `post /v1/users/bulk/preferences`, but is otherwise the
         * same as [BulkService.setPreferences].
         */
        @MustBeClosed
        fun setPreferences(params: BulkSetPreferencesParams): HttpResponseFor<BulkOperation> =
            setPreferences(params, RequestOptions.none())

        /** @see [setPreferences] */
        @MustBeClosed
        fun setPreferences(
            params: BulkSetPreferencesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BulkOperation>
    }
}
