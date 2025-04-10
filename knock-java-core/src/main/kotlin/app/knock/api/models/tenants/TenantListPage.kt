// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.tenants

import app.knock.api.services.blocking.TenantService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** List tenants */
class TenantListPage
private constructor(
    private val tenantsService: TenantService,
    private val params: TenantListParams,
    private val response: TenantListPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): TenantListPageResponse = response

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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is TenantListPage && tenantsService == other.tenantsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(tenantsService, params, response) /* spotless:on */

    override fun toString() =
        "TenantListPage{tenantsService=$tenantsService, params=$params, response=$response}"

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

    fun getNextPage(): Optional<TenantListPage> {
        return getNextPageParams().map { tenantsService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            tenantsService: TenantService,
            params: TenantListParams,
            response: TenantListPageResponse,
        ) = TenantListPage(tenantsService, params, response)
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
}
