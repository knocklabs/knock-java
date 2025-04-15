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

    /** Bulk deletes a list of users */
    fun delete(params: BulkDeleteParams): BulkOperation = delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: BulkDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BulkOperation

    /** Bulk identifies a list of users */
    fun identify(): BulkOperation = identify(BulkIdentifyParams.none())

    /** @see [identify] */
    fun identify(
        params: BulkIdentifyParams = BulkIdentifyParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BulkOperation

    /** @see [identify] */
    fun identify(params: BulkIdentifyParams = BulkIdentifyParams.none()): BulkOperation =
        identify(params, RequestOptions.none())

    /** @see [identify] */
    fun identify(requestOptions: RequestOptions): BulkOperation =
        identify(BulkIdentifyParams.none(), requestOptions)

    /** Bulk sets user preferences */
    fun setPreferences(): BulkOperation = setPreferences(BulkSetPreferencesParams.none())

    /** @see [setPreferences] */
    fun setPreferences(
        params: BulkSetPreferencesParams = BulkSetPreferencesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BulkOperation

    /** @see [setPreferences] */
    fun setPreferences(
        params: BulkSetPreferencesParams = BulkSetPreferencesParams.none()
    ): BulkOperation = setPreferences(params, RequestOptions.none())

    /** @see [setPreferences] */
    fun setPreferences(requestOptions: RequestOptions): BulkOperation =
        setPreferences(BulkSetPreferencesParams.none(), requestOptions)

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
        fun identify(): HttpResponseFor<BulkOperation> = identify(BulkIdentifyParams.none())

        /** @see [identify] */
        @MustBeClosed
        fun identify(
            params: BulkIdentifyParams = BulkIdentifyParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BulkOperation>

        /** @see [identify] */
        @MustBeClosed
        fun identify(
            params: BulkIdentifyParams = BulkIdentifyParams.none()
        ): HttpResponseFor<BulkOperation> = identify(params, RequestOptions.none())

        /** @see [identify] */
        @MustBeClosed
        fun identify(requestOptions: RequestOptions): HttpResponseFor<BulkOperation> =
            identify(BulkIdentifyParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/users/bulk/preferences`, but is otherwise the
         * same as [BulkService.setPreferences].
         */
        @MustBeClosed
        fun setPreferences(): HttpResponseFor<BulkOperation> =
            setPreferences(BulkSetPreferencesParams.none())

        /** @see [setPreferences] */
        @MustBeClosed
        fun setPreferences(
            params: BulkSetPreferencesParams = BulkSetPreferencesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BulkOperation>

        /** @see [setPreferences] */
        @MustBeClosed
        fun setPreferences(
            params: BulkSetPreferencesParams = BulkSetPreferencesParams.none()
        ): HttpResponseFor<BulkOperation> = setPreferences(params, RequestOptions.none())

        /** @see [setPreferences] */
        @MustBeClosed
        fun setPreferences(requestOptions: RequestOptions): HttpResponseFor<BulkOperation> =
            setPreferences(BulkSetPreferencesParams.none(), requestOptions)
    }
}
