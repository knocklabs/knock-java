// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.schedules

import app.knock.api.services.blocking.ScheduleService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** List schedules */
class ScheduleListPage
private constructor(
    private val schedulesService: ScheduleService,
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

        return /* spotless:off */ other is ScheduleListPage && schedulesService == other.schedulesService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(schedulesService, params, response) /* spotless:on */

    override fun toString() =
        "ScheduleListPage{schedulesService=$schedulesService, params=$params, response=$response}"

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

    fun getNextPage(): Optional<ScheduleListPage> {
        return getNextPageParams().map { schedulesService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            schedulesService: ScheduleService,
            params: ScheduleListParams,
            response: ScheduleListPageResponse,
        ) = ScheduleListPage(schedulesService, params, response)
    }

    class AutoPager(private val firstPage: ScheduleListPage) : Iterable<Schedule> {

        override fun iterator(): Iterator<Schedule> = iterator {
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

        fun stream(): Stream<Schedule> {
            return StreamSupport.stream(spliterator(), false)
        }
    }
}
