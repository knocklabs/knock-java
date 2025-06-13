// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking.objects

import app.knock.api.core.ClientOptions
import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.bulkoperations.BulkOperation
import app.knock.api.models.objects.bulk.BulkAddSubscriptionsParams
import app.knock.api.models.objects.bulk.BulkDeleteParams
import app.knock.api.models.objects.bulk.BulkSetParams
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

    /** Bulk deletes objects from the specified collection. */
    fun delete(collection: String, params: BulkDeleteParams): BulkOperation =
        delete(collection, params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        collection: String,
        params: BulkDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BulkOperation = delete(params.toBuilder().collection(collection).build(), requestOptions)

    /** @see [delete] */
    fun delete(params: BulkDeleteParams): BulkOperation = delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: BulkDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BulkOperation

    /**
     * Add subscriptions for all objects in a single collection. If a subscription for an object in
     * the collection already exists, it will be updated. This endpoint also handles
     * [inline identifications](/managing-recipients/identifying-recipients#inline-identifying-recipients)
     * for the `recipient` field.
     */
    fun addSubscriptions(collection: String, params: BulkAddSubscriptionsParams): BulkOperation =
        addSubscriptions(collection, params, RequestOptions.none())

    /** @see [addSubscriptions] */
    fun addSubscriptions(
        collection: String,
        params: BulkAddSubscriptionsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BulkOperation =
        addSubscriptions(params.toBuilder().collection(collection).build(), requestOptions)

    /** @see [addSubscriptions] */
    fun addSubscriptions(params: BulkAddSubscriptionsParams): BulkOperation =
        addSubscriptions(params, RequestOptions.none())

    /** @see [addSubscriptions] */
    fun addSubscriptions(
        params: BulkAddSubscriptionsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BulkOperation

    /** Bulk sets up to 1,000 objects at a time in the specified collection. */
    fun set(collection: String, params: BulkSetParams): BulkOperation =
        set(collection, params, RequestOptions.none())

    /** @see [set] */
    fun set(
        collection: String,
        params: BulkSetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BulkOperation = set(params.toBuilder().collection(collection).build(), requestOptions)

    /** @see [set] */
    fun set(params: BulkSetParams): BulkOperation = set(params, RequestOptions.none())

    /** @see [set] */
    fun set(
        params: BulkSetParams,
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
         * Returns a raw HTTP response for `post /v1/objects/{collection}/bulk/delete`, but is
         * otherwise the same as [BulkService.delete].
         */
        @MustBeClosed
        fun delete(collection: String, params: BulkDeleteParams): HttpResponseFor<BulkOperation> =
            delete(collection, params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            collection: String,
            params: BulkDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BulkOperation> =
            delete(params.toBuilder().collection(collection).build(), requestOptions)

        /** @see [delete] */
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
         * Returns a raw HTTP response for `post /v1/objects/{collection}/bulk/subscriptions/add`,
         * but is otherwise the same as [BulkService.addSubscriptions].
         */
        @MustBeClosed
        fun addSubscriptions(
            collection: String,
            params: BulkAddSubscriptionsParams,
        ): HttpResponseFor<BulkOperation> =
            addSubscriptions(collection, params, RequestOptions.none())

        /** @see [addSubscriptions] */
        @MustBeClosed
        fun addSubscriptions(
            collection: String,
            params: BulkAddSubscriptionsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BulkOperation> =
            addSubscriptions(params.toBuilder().collection(collection).build(), requestOptions)

        /** @see [addSubscriptions] */
        @MustBeClosed
        fun addSubscriptions(params: BulkAddSubscriptionsParams): HttpResponseFor<BulkOperation> =
            addSubscriptions(params, RequestOptions.none())

        /** @see [addSubscriptions] */
        @MustBeClosed
        fun addSubscriptions(
            params: BulkAddSubscriptionsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BulkOperation>

        /**
         * Returns a raw HTTP response for `post /v1/objects/{collection}/bulk/set`, but is
         * otherwise the same as [BulkService.set].
         */
        @MustBeClosed
        fun set(collection: String, params: BulkSetParams): HttpResponseFor<BulkOperation> =
            set(collection, params, RequestOptions.none())

        /** @see [set] */
        @MustBeClosed
        fun set(
            collection: String,
            params: BulkSetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BulkOperation> =
            set(params.toBuilder().collection(collection).build(), requestOptions)

        /** @see [set] */
        @MustBeClosed
        fun set(params: BulkSetParams): HttpResponseFor<BulkOperation> =
            set(params, RequestOptions.none())

        /** @see [set] */
        @MustBeClosed
        fun set(
            params: BulkSetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BulkOperation>
    }
}
