// File generated from our OpenAPI spec by Stainless.

package app.knock.api.services.blocking

import app.knock.api.core.RequestOptions
import app.knock.api.core.http.HttpResponseFor
import app.knock.api.models.tenants.TenantListPage
import app.knock.api.models.tenants.TenantListParams
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
    }
}
