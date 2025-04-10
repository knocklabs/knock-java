// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.models.schedules.Schedule
import app.knock.api.services.async.ObjectServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** List schedules */
class ObjectListSchedulesPageAsync
private constructor(
    private val objectsService: ObjectServiceAsync,
    private val params: ObjectListSchedulesParams,
    private val response: ObjectListSchedulesPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): ObjectListSchedulesPageResponse = response

    /**
     * Delegates to [ObjectListSchedulesPageResponse], but gracefully handles missing data.
     *
     * @see [ObjectListSchedulesPageResponse.entries]
     */
    fun entries(): List<Schedule> =
        response._entries().getOptional("entries").getOrNull() ?: emptyList()

    /**
     * Delegates to [ObjectListSchedulesPageResponse], but gracefully handles missing data.
     *
     * @see [ObjectListSchedulesPageResponse.pageInfo]
     */
    fun pageInfo(): Optional<ObjectListSchedulesPageResponse.PageInfo> =
        response._pageInfo().getOptional("page_info")

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ObjectListSchedulesPageAsync && objectsService == other.objectsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(objectsService, params, response) /* spotless:on */

    override fun toString() =
        "ObjectListSchedulesPageAsync{objectsService=$objectsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean =
        entries().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun getNextPageParams(): Optional<ObjectListSchedulesParams> {
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

    fun getNextPage(): CompletableFuture<Optional<ObjectListSchedulesPageAsync>> {
        return getNextPageParams()
            .map { objectsService.listSchedules(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            objectsService: ObjectServiceAsync,
            params: ObjectListSchedulesParams,
            response: ObjectListSchedulesPageResponse,
        ) = ObjectListSchedulesPageAsync(objectsService, params, response)
    }

    class AutoPager(private val firstPage: ObjectListSchedulesPageAsync) {

        fun forEach(action: Predicate<Schedule>, executor: Executor): CompletableFuture<Void> {
            fun CompletableFuture<Optional<ObjectListSchedulesPageAsync>>.forEach(
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
