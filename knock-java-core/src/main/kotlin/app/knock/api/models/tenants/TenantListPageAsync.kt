// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.tenants

import app.knock.api.services.async.TenantServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** List tenants */
class TenantListPageAsync
private constructor(
    private val tenantsService: TenantServiceAsync,
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

        return /* spotless:off */ other is TenantListPageAsync && tenantsService == other.tenantsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(tenantsService, params, response) /* spotless:on */

    override fun toString() =
        "TenantListPageAsync{tenantsService=$tenantsService, params=$params, response=$response}"

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

    fun getNextPage(): CompletableFuture<Optional<TenantListPageAsync>> {
        return getNextPageParams()
            .map { tenantsService.list(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            tenantsService: TenantServiceAsync,
            params: TenantListParams,
            response: TenantListPageResponse,
        ) = TenantListPageAsync(tenantsService, params, response)
    }

    class AutoPager(private val firstPage: TenantListPageAsync) {

        fun forEach(action: Predicate<Tenant>, executor: Executor): CompletableFuture<Void> {
            fun CompletableFuture<Optional<TenantListPageAsync>>.forEach(
                action: (Tenant) -> Boolean,
                executor: Executor,
            ): CompletableFuture<Void> =
                thenComposeAsync(
                    { page ->
                        page
                            .filter { it.entries().all(action) }
                            .map { it.getNextPage().forEach(action, executor) }
                            .orElseGet { CompletableFuture.completedFuture(null) }
                    },
                    executor,
                )
            return CompletableFuture.completedFuture(Optional.of(firstPage))
                .forEach(action::test, executor)
        }

        fun toList(executor: Executor): CompletableFuture<List<Tenant>> {
            val values = mutableListOf<Tenant>()
            return forEach(values::add, executor).thenApply { values }
        }
    }
}
