// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking.users

import app.knock.api.core.ClientOptions
import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.bulkoperations.BulkOperation
import app.knock.api.models.users.bulk.BulkDeleteParams
import app.knock.api.models.users.bulk.BulkIdentifyParams
import app.knock.api.models.users.bulk.BulkSetPreferencesParams
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface BulkService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): BulkService

    /** Permanently deletes up to 1,000 users at a time. */
    fun delete(params: BulkDeleteParams): BulkOperation = delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: BulkDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BulkOperation

    /**
     * Identifies multiple users in a single operation. Allows creating or updating up to 1,000
     * users in a single batch with various properties, preferences, and channel data.
     */
    fun identify(params: BulkIdentifyParams): BulkOperation =
        identify(params, RequestOptions.none())

    /** @see [identify] */
    fun identify(
        params: BulkIdentifyParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BulkOperation

    /**
     * Bulk sets the preferences for up to 1,000 users at a time. The preference set `:id` can be
     * either `default` or a `tenant.id`. Learn more about [per-tenant
     * preferences](/preferences/tenant-preferences). Note that this is a destructive operation and
     * will replace any existing users' preferences with the preferences sent.
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
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): BulkService.WithRawResponse

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
