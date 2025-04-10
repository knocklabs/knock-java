// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.tenants

import app.knock.api.core.checkRequired
import app.knock.api.services.blocking.TenantService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** @see [TenantService.list] */
class TenantListPage
private constructor(
    private val service: TenantService,
    private val params: TenantListParams,
    private val response: TenantListPageResponse,
) {

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
    fun pageInfo(): Optional<TenantListPageResponse.PageInfo> =
        response._pageInfo().getOptional("page_info")

    fun hasNextPage(): Boolean =
        entries().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun getNextPageParams(): Optional<TenantListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(
            params
                .toBuilder()
                .apply {
                    pageInfo().flatMap { it._after().getOptional("after") }.ifPresent { after(it) }
                }
                .build()
        )
    }

    fun getNextPage(): Optional<TenantListPage> = getNextPageParams().map { service.list(it) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): TenantListParams = params

    /** The response that this page was parsed from. */
    fun response(): TenantListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [TenantListPage].
         *
         * The following fields are required:
         * ```java
         * .service()
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TenantListPage]. */
    class Builder internal constructor() {

        private var service: TenantService? = null
        private var params: TenantListParams? = null
        private var response: TenantListPageResponse? = null

        @JvmSynthetic
        internal fun from(tenantListPage: TenantListPage) = apply {
            service = tenantListPage.service
            params = tenantListPage.params
            response = tenantListPage.response
        }

        fun service(service: TenantService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: TenantListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: TenantListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [TenantListPage].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .service()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TenantListPage =
            TenantListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    class AutoPager(private val firstPage: TenantListPage) : Iterable<Tenant> {

        override fun iterator(): Iterator<Tenant> = iterator {
            var page = firstPage
            var index = 0
            while (true) {
                while (index < page.entries().size) {
                    yield(page.entries()[index++])
                }
                page = page.getNextPage().getOrNull() ?: break
                index = 0
            }
        }

        fun stream(): Stream<Tenant> {
            return StreamSupport.stream(spliterator(), false)
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is TenantListPage && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() = "TenantListPage{service=$service, params=$params, response=$response}"
}
