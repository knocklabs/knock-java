// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.tenants.Tenant
import app.knock.api.models.tenants.TenantDeleteParams
import app.knock.api.models.tenants.TenantGetParams
import app.knock.api.models.tenants.TenantListPage
import app.knock.api.models.tenants.TenantListParams
import app.knock.api.models.tenants.TenantSetParams
import app.knock.api.services.blocking.tenants.BulkService
import com.google.errorprone.annotations.MustBeClosed

interface TenantService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun bulk(): BulkService

    /** List tenants for the current environment. */
    fun list(): TenantListPage = list(TenantListParams.none())

    /** @see [list] */
    fun list(
        params: TenantListParams = TenantListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TenantListPage

    /** @see [list] */
    fun list(params: TenantListParams = TenantListParams.none()): TenantListPage =
        list(params, RequestOptions.none())

    /** @see [list] */
    fun list(requestOptions: RequestOptions): TenantListPage =
        list(TenantListParams.none(), requestOptions)

    /** Delete a tenant and all associated data. This operation cannot be undone. */
    fun delete(id: String): String = delete(id, TenantDeleteParams.none())

    /** @see [delete] */
    fun delete(
        id: String,
        params: TenantDeleteParams = TenantDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): String = delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see [delete] */
    fun delete(id: String, params: TenantDeleteParams = TenantDeleteParams.none()): String =
        delete(id, params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: TenantDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): String

    /** @see [delete] */
    fun delete(params: TenantDeleteParams): String = delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(id: String, requestOptions: RequestOptions): String =
        delete(id, TenantDeleteParams.none(), requestOptions)

    /** Get a tenant by ID. */
    fun get(id: String): Tenant = get(id, TenantGetParams.none())

    /** @see [get] */
    fun get(
        id: String,
        params: TenantGetParams = TenantGetParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Tenant = get(params.toBuilder().id(id).build(), requestOptions)

    /** @see [get] */
    fun get(id: String, params: TenantGetParams = TenantGetParams.none()): Tenant =
        get(id, params, RequestOptions.none())

    /** @see [get] */
    fun get(params: TenantGetParams, requestOptions: RequestOptions = RequestOptions.none()): Tenant

    /** @see [get] */
    fun get(params: TenantGetParams): Tenant = get(params, RequestOptions.none())

    /** @see [get] */
    fun get(id: String, requestOptions: RequestOptions): Tenant =
        get(id, TenantGetParams.none(), requestOptions)

    /**
     * Sets a tenant within an environment, performing an upsert operation. Any existing properties
     * will be merged with the incoming properties.
     */
    fun set(id: String): Tenant = set(id, TenantSetParams.none())

    /** @see [set] */
    fun set(
        id: String,
        params: TenantSetParams = TenantSetParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Tenant = set(params.toBuilder().id(id).build(), requestOptions)

    /** @see [set] */
    fun set(id: String, params: TenantSetParams = TenantSetParams.none()): Tenant =
        set(id, params, RequestOptions.none())

    /** @see [set] */
    fun set(params: TenantSetParams, requestOptions: RequestOptions = RequestOptions.none()): Tenant

    /** @see [set] */
    fun set(params: TenantSetParams): Tenant = set(params, RequestOptions.none())

    /** @see [set] */
    fun set(id: String, requestOptions: RequestOptions): Tenant =
        set(id, TenantSetParams.none(), requestOptions)

    /** A view of [TenantService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun bulk(): BulkService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/tenants`, but is otherwise the same as
         * [TenantService.list].
         */
        @MustBeClosed fun list(): HttpResponseFor<TenantListPage> = list(TenantListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: TenantListParams = TenantListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TenantListPage>

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: TenantListParams = TenantListParams.none()
        ): HttpResponseFor<TenantListPage> = list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<TenantListPage> =
            list(TenantListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/tenants/{id}`, but is otherwise the same as
         * [TenantService.delete].
         */
        @MustBeClosed
        fun delete(id: String): HttpResponseFor<String> = delete(id, TenantDeleteParams.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            id: String,
            params: TenantDeleteParams = TenantDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<String> = delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            id: String,
            params: TenantDeleteParams = TenantDeleteParams.none(),
        ): HttpResponseFor<String> = delete(id, params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: TenantDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<String>

        /** @see [delete] */
        @MustBeClosed
        fun delete(params: TenantDeleteParams): HttpResponseFor<String> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(id: String, requestOptions: RequestOptions): HttpResponseFor<String> =
            delete(id, TenantDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/tenants/{id}`, but is otherwise the same as
         * [TenantService.get].
         */
        @MustBeClosed fun get(id: String): HttpResponseFor<Tenant> = get(id, TenantGetParams.none())

        /** @see [get] */
        @MustBeClosed
        fun get(
            id: String,
            params: TenantGetParams = TenantGetParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Tenant> = get(params.toBuilder().id(id).build(), requestOptions)

        /** @see [get] */
        @MustBeClosed
        fun get(
            id: String,
            params: TenantGetParams = TenantGetParams.none(),
        ): HttpResponseFor<Tenant> = get(id, params, RequestOptions.none())

        /** @see [get] */
        @MustBeClosed
        fun get(
            params: TenantGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Tenant>

        /** @see [get] */
        @MustBeClosed
        fun get(params: TenantGetParams): HttpResponseFor<Tenant> =
            get(params, RequestOptions.none())

        /** @see [get] */
        @MustBeClosed
        fun get(id: String, requestOptions: RequestOptions): HttpResponseFor<Tenant> =
            get(id, TenantGetParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put /v1/tenants/{id}`, but is otherwise the same as
         * [TenantService.set].
         */
        @MustBeClosed fun set(id: String): HttpResponseFor<Tenant> = set(id, TenantSetParams.none())

        /** @see [set] */
        @MustBeClosed
        fun set(
            id: String,
            params: TenantSetParams = TenantSetParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Tenant> = set(params.toBuilder().id(id).build(), requestOptions)

        /** @see [set] */
        @MustBeClosed
        fun set(
            id: String,
            params: TenantSetParams = TenantSetParams.none(),
        ): HttpResponseFor<Tenant> = set(id, params, RequestOptions.none())

        /** @see [set] */
        @MustBeClosed
        fun set(
            params: TenantSetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Tenant>

        /** @see [set] */
        @MustBeClosed
        fun set(params: TenantSetParams): HttpResponseFor<Tenant> =
            set(params, RequestOptions.none())

        /** @see [set] */
        @MustBeClosed
        fun set(id: String, requestOptions: RequestOptions): HttpResponseFor<Tenant> =
            set(id, TenantSetParams.none(), requestOptions)
    }
}
