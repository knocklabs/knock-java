// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.services.blocking.ObjectService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** List objects in a collection */
class ObjectListPage
private constructor(
    private val objectsService: ObjectService,
    private val params: ObjectListParams,
    private val response: ObjectListPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): ObjectListPageResponse = response

    /**
     * Delegates to [ObjectListPageResponse], but gracefully handles missing data.
     *
     * @see [ObjectListPageResponse.entries]
     */
    fun entries(): List<Object> =
        response._entries().getOptional("entries").getOrNull() ?: emptyList()

    /**
     * Delegates to [ObjectListPageResponse], but gracefully handles missing data.
     *
     * @see [ObjectListPageResponse.pageInfo]
     */
    fun pageInfo(): Optional<ObjectListPageResponse.PageInfo> =
        response._pageInfo().getOptional("page_info")

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ObjectListPage && objectsService == other.objectsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(objectsService, params, response) /* spotless:on */

    override fun toString() =
        "ObjectListPage{objectsService=$objectsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean =
        entries().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun getNextPageParams(): Optional<ObjectListParams> {
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

    fun getNextPage(): Optional<ObjectListPage> {
        return getNextPageParams().map { objectsService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            objectsService: ObjectService,
            params: ObjectListParams,
            response: ObjectListPageResponse,
        ) = ObjectListPage(objectsService, params, response)
    }

    class AutoPager(private val firstPage: ObjectListPage) : Iterable<Object> {

        override fun iterator(): Iterator<Object> = iterator {
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

        fun stream(): Stream<Object> {
            return StreamSupport.stream(spliterator(), false)
        }
    }
}
