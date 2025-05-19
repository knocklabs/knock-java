// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.async.objects

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.bulkoperations.BulkOperation
import app.knock.api.models.objects.bulk.BulkAddSubscriptionsParams
import app.knock.api.models.objects.bulk.BulkDeleteParams
import app.knock.api.models.objects.bulk.BulkSetParams
import com.google.errorprone.annotations.MustBeClosed
import java.util.concurrent.CompletableFuture

interface BulkServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Bulk deletes objects from the specified collection. */
    fun delete(collection: String, params: BulkDeleteParams): CompletableFuture<BulkOperation> =
        delete(collection, params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        collection: String,
        params: BulkDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BulkOperation> =
        delete(params.toBuilder().collection(collection).build(), requestOptions)

    /** @see [delete] */
    fun delete(params: BulkDeleteParams): CompletableFuture<BulkOperation> =
        delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: BulkDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BulkOperation>

    /**
     * Add subscriptions for all objects in a single collection. If a subscription for an object in
     * the collection already exists, it will be updated. This endpoint also handles
     * [inline identifications](/managing-recipients/identifying-recipients#inline-identifying-recipients)
     * for the `recipient` field.
     */
    fun addSubscriptions(
        collection: String,
        params: BulkAddSubscriptionsParams,
    ): CompletableFuture<BulkOperation> =
        addSubscriptions(collection, params, RequestOptions.none())

    /** @see [addSubscriptions] */
    fun addSubscriptions(
        collection: String,
        params: BulkAddSubscriptionsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BulkOperation> =
        addSubscriptions(params.toBuilder().collection(collection).build(), requestOptions)

    /** @see [addSubscriptions] */
    fun addSubscriptions(params: BulkAddSubscriptionsParams): CompletableFuture<BulkOperation> =
        addSubscriptions(params, RequestOptions.none())

    /** @see [addSubscriptions] */
    fun addSubscriptions(
        params: BulkAddSubscriptionsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BulkOperation>

    /** Bulk sets up to 1,000 objects at a time in the specified collection. */
    fun set(collection: String, params: BulkSetParams): CompletableFuture<BulkOperation> =
        set(collection, params, RequestOptions.none())

    /** @see [set] */
    fun set(
        collection: String,
        params: BulkSetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BulkOperation> =
        set(params.toBuilder().collection(collection).build(), requestOptions)

    /** @see [set] */
    fun set(params: BulkSetParams): CompletableFuture<BulkOperation> =
        set(params, RequestOptions.none())

    /** @see [set] */
    fun set(
        params: BulkSetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BulkOperation>

    /** A view of [BulkServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/objects/{collection}/bulk/delete`, but is
         * otherwise the same as [BulkServiceAsync.delete].
         */
        @MustBeClosed
        fun delete(
            collection: String,
            params: BulkDeleteParams,
        ): CompletableFuture<HttpResponseFor<BulkOperation>> =
            delete(collection, params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            collection: String,
            params: BulkDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BulkOperation>> =
            delete(params.toBuilder().collection(collection).build(), requestOptions)

        /** @see [delete] */
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
         * Returns a raw HTTP response for `post /v1/objects/{collection}/bulk/subscriptions/add`,
         * but is otherwise the same as [BulkServiceAsync.addSubscriptions].
         */
        @MustBeClosed
        fun addSubscriptions(
            collection: String,
            params: BulkAddSubscriptionsParams,
        ): CompletableFuture<HttpResponseFor<BulkOperation>> =
            addSubscriptions(collection, params, RequestOptions.none())

        /** @see [addSubscriptions] */
        @MustBeClosed
        fun addSubscriptions(
            collection: String,
            params: BulkAddSubscriptionsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BulkOperation>> =
            addSubscriptions(params.toBuilder().collection(collection).build(), requestOptions)

        /** @see [addSubscriptions] */
        @MustBeClosed
        fun addSubscriptions(
            params: BulkAddSubscriptionsParams
        ): CompletableFuture<HttpResponseFor<BulkOperation>> =
            addSubscriptions(params, RequestOptions.none())

        /** @see [addSubscriptions] */
        @MustBeClosed
        fun addSubscriptions(
            params: BulkAddSubscriptionsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BulkOperation>>

        /**
         * Returns a raw HTTP response for `post /v1/objects/{collection}/bulk/set`, but is
         * otherwise the same as [BulkServiceAsync.set].
         */
        @MustBeClosed
        fun set(
            collection: String,
            params: BulkSetParams,
        ): CompletableFuture<HttpResponseFor<BulkOperation>> =
            set(collection, params, RequestOptions.none())

        /** @see [set] */
        @MustBeClosed
        fun set(
            collection: String,
            params: BulkSetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BulkOperation>> =
            set(params.toBuilder().collection(collection).build(), requestOptions)

        /** @see [set] */
        @MustBeClosed
        fun set(params: BulkSetParams): CompletableFuture<HttpResponseFor<BulkOperation>> =
            set(params, RequestOptions.none())

        /** @see [set] */
        @MustBeClosed
        fun set(
            params: BulkSetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BulkOperation>>
    }
}
