// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.schedules

import app.knock.api.services.async.ScheduleServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** List schedules */
class ScheduleListPageAsync
private constructor(
    private val schedulesService: ScheduleServiceAsync,
    private val params: ScheduleListParams,
    private val response: ScheduleListPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): ScheduleListPageResponse = response

    /**
     * Delegates to [ScheduleListPageResponse], but gracefully handles missing data.
     *
     * @see [ScheduleListPageResponse.entries]
     */
    fun entries(): List<Schedule> =
        response._entries().getOptional("entries").getOrNull() ?: emptyList()

    /**
     * Delegates to [ScheduleListPageResponse], but gracefully handles missing data.
     *
     * @see [ScheduleListPageResponse.pageInfo]
     */
    fun pageInfo(): Optional<ScheduleListPageResponse.PageInfo> =
        response._pageInfo().getOptional("page_info")

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ScheduleListPageAsync && schedulesService == other.schedulesService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(schedulesService, params, response) /* spotless:on */

    override fun toString() =
        "ScheduleListPageAsync{schedulesService=$schedulesService, params=$params, response=$response}"

    fun hasNextPage(): Boolean =
        entries().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun getNextPageParams(): Optional<ScheduleListParams> {
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

    fun getNextPage(): CompletableFuture<Optional<ScheduleListPageAsync>> {
        return getNextPageParams()
            .map { schedulesService.list(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            schedulesService: ScheduleServiceAsync,
            params: ScheduleListParams,
            response: ScheduleListPageResponse,
        ) = ScheduleListPageAsync(schedulesService, params, response)
    }

    class AutoPager(private val firstPage: ScheduleListPageAsync) {

        fun forEach(action: Predicate<Schedule>, executor: Executor): CompletableFuture<Void> {
            fun CompletableFuture<Optional<ScheduleListPageAsync>>.forEach(
                action: (Schedule) -> Boolean,
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

        fun toList(executor: Executor): CompletableFuture<List<Schedule>> {
            val values = mutableListOf<Schedule>()
            return forEach(values::add, executor).thenApply { values }
        }
    }
}
