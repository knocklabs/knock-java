// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.models.schedules.Schedule
import app.knock.api.services.blocking.ObjectService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** List schedules */
class ObjectListSchedulesPage
private constructor(
    private val objectsService: ObjectService,
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

        return /* spotless:off */ other is ObjectListSchedulesPage && objectsService == other.objectsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(objectsService, params, response) /* spotless:on */

    override fun toString() =
        "ObjectListSchedulesPage{objectsService=$objectsService, params=$params, response=$response}"

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

    fun getNextPage(): Optional<ObjectListSchedulesPage> {
        return getNextPageParams().map { objectsService.listSchedules(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            objectsService: ObjectService,
            params: ObjectListSchedulesParams,
            response: ObjectListSchedulesPageResponse,
        ) = ObjectListSchedulesPage(objectsService, params, response)
    }

    class AutoPager(private val firstPage: ObjectListSchedulesPage) : Iterable<Schedule> {

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
