// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.tenants

import app.knock.api.core.AutoPagerAsync
import app.knock.api.core.PageAsync
import app.knock.api.core.checkRequired
import app.knock.api.models.shared.PageInfo
import app.knock.api.services.async.TenantServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see [TenantServiceAsync.list] */
class TenantListPageAsync
private constructor(
    private val service: TenantServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: TenantListParams,
    private val response: TenantListPageResponse,
) : PageAsync<Tenant> {

    /**
     * Delegates to [TenantListPageResponse], but gracefully handles missing data.
     *
     * @see [TenantListPageResponse.entries]
     */
    fun entries(): List<Tenant> =
        response._entries().getOptional("entries").getOrNull() ?: emptyList()

    /**
     * Delegates to [TenantListPageResponse], but gracefully handles missing data.
     *
     * @see [TenantListPageResponse.pageInfo]
     */
    fun pageInfo(): Optional<PageInfo> = response._pageInfo().getOptional("page_info")

    override fun items(): List<Tenant> = entries()

    override fun hasNextPage(): Boolean =
        items().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun nextPageParams(): TenantListParams {
        val nextCursor =
            pageInfo().flatMap { it._after().getOptional("after") }.getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): CompletableFuture<TenantListPageAsync> = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<Tenant> = AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): TenantListParams = params

    /** The response that this page was parsed from. */
    fun response(): TenantListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [TenantListPageAsync].
         *
         * The following fields are required:
         * ```java
         * .service()
         * .streamHandlerExecutor()
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TenantListPageAsync]. */
    class Builder internal constructor() {

        private var service: TenantServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: TenantListParams? = null
        private var response: TenantListPageResponse? = null

        @JvmSynthetic
        internal fun from(tenantListPageAsync: TenantListPageAsync) = apply {
            service = tenantListPageAsync.service
            streamHandlerExecutor = tenantListPageAsync.streamHandlerExecutor
            params = tenantListPageAsync.params
            response = tenantListPageAsync.response
        }

        fun service(service: TenantServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: TenantListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: TenantListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [TenantListPageAsync].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .service()
         * .streamHandlerExecutor()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TenantListPageAsync =
            TenantListPageAsync(
                checkRequired("service", service),
                checkRequired("streamHandlerExecutor", streamHandlerExecutor),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is TenantListPageAsync && service == other.service && streamHandlerExecutor == other.streamHandlerExecutor && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, streamHandlerExecutor, params, response) /* spotless:on */

    override fun toString() =
        "TenantListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
